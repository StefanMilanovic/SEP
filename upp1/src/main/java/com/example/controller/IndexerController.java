package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.example.lucene.indexing.Indexer;
import com.example.lucene.indexing.filters.CyrillicLatinConverter;
import com.example.lucene.model.IndexUnit;
import com.example.model.*;
import com.example.service.MagazineService;
import com.example.service.SciencePaperDownloadService;
import com.example.service.SciencePaperService;
import com.example.service.ScientificFieldService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
/*
import org.springframework.security.access.prepost.PreAuthorize;
import udd.lucene.indexing.Indexer;
import udd.lucene.model.IndexUnit;
import udd.model.nc.Casopis;
import udd.model.nc.Korisnik;
import udd.model.nc.Rad;
import udd.model.nc.StatusRada;
import udd.service.nc.CasopisService;
import udd.service.nc.KorisnikService;
import udd.service.nc.RadService;
*/
@CrossOrigin(origins = "*")
@RestController
public class IndexerController {

	@Autowired
	private Indexer indexer;
	
	@Autowired
    SciencePaperService sciencePaperService;
	
	@Autowired
    MagazineService magazineService;
	
	@Autowired
    UserService userService;
	
	@Autowired
	SciencePaperDownloadService downloadService;

	private static String DATA_DIR_PATH;
	
	static {
		ResourceBundle rb=ResourceBundle.getBundle("application");
		DATA_DIR_PATH=rb.getString("dataDir");
	}
		
	private File getResourceFilePath(String path) {
	    URL url = this.getClass().getClassLoader().getResource(path);
		File file = null;
		    
		try {
			file = new File(url.toURI());
		} catch (URISyntaxException e) {
			file = new File(url.getPath());
		}   
		    
		return file;
	}
	
	//cuvanje fajla na serveru
	private String saveUploadedFile(MultipartFile file) throws IOException {
		String retVal = null;
		    	
	    if (! file.isEmpty()) {
	    	byte[] bytes = file.getBytes();
		    Path path = Paths.get(getResourceFilePath(DATA_DIR_PATH).getAbsolutePath() + File.separator + file.getOriginalFilename());
		    Files.write(path, bytes);
		    retVal = path.toString();
		    System.out.println("\n\tSACUVANO NA PUTANJI:\n\t\t" + retVal + "\n");
	    }
	            
	    return retVal;
	}
	
	//indeksiranje rada   //posledjeni model naseg RADA !!!!!! ZA MULITI UPLOAD ISTO
	private void indexUploadedFile(SciencePaper model) throws IOException{
		for (MultipartFile file : model.getTextPDF()) {
			if (file.isEmpty()) {
				continue; //next please
	        }
	            
	        String fileName = saveUploadedFile(file);
	        if(fileName != null){
	        	IndexUnit indexUnit = indexer.getHandler(fileName).getIndexUnit(new File(fileName));
	        	indexUnit.setNameMagazine(zameniKarakter(model.getScienceMagazine().getName()));
	        	indexUnit.setTitle(zameniKarakter(model.getName()));
	        	indexUnit.setAuthor(zameniKarakter(model.getAuthor().getFirstname()) + " " +zameniKarakter(model.getAuthor().getLastname()));
	            indexUnit.setKeywords(zameniKarakter(model.getKeywords()));
	            //indexUnit.setText(preuzmiSadrzajFajla(file));
	            indexUnit.setScientificField(zameniKarakter(model.getScienceMagazine().getScientificField().getName()));
	            indexer.add(indexUnit);
	        }
	    }
	}
		
	//indeksiranje i dodavanje rada
	@PostMapping("/index/add/{id}")
	//public ResponseEntity<String> multiUploadFileModel(@ModelAttribute SciencePaper sciencePaper, @PathVariable Long id) {
	public ResponseEntity<String> multiUploadFileModel(@ModelAttribute("currentUser") CurrentUser currentUser, @ModelAttribute SciencePaper sciencePaper, @PathVariable Long id) {
		//@ModelAttribute SciencePaper sciencePaper
		//POCETAK ZORICEV KOD
		
		try {
			SciencePaperDownload newPaper = new SciencePaperDownload(sciencePaper.getName(), sciencePaper.getTextPDF()[0].getContentType(), sciencePaper.getTextPDF()[0].getBytes());
			newPaper.setName(zameniKarakter(newPaper.getName()));
			downloadService.save(newPaper);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
				
		//KRAJ ZORICEV KOD
		System.out.println("\n\t\taaaa oblas");
		User user = currentUser.getUser();
		List<User> coAuthor = new ArrayList<User>();
		
		Magazine magazine = magazineService.findOne(id);		
		//ID DODELITI NA OSNOVU COMBO BOX
		
		SciencePaper newSciencePaper = new SciencePaper(sciencePaper.getName(), sciencePaper.getKeywords(), sciencePaper.getAbbstract(), sciencePaper.getScentificField(), sciencePaper.getTextPDF());
        
		newSciencePaper.setScienceMagazine(magazine);
		newSciencePaper.setNameMagazine(newSciencePaper.getScienceMagazine().getName());
		newSciencePaper.setNameScientifiField(newSciencePaper.getScienceMagazine().getScientificField().getName());
		System.out.println("\n\t\tnaucna oblast kojoj pripada rad: " + newSciencePaper.getScienceMagazine().getScientificField().getName());


		newSciencePaper.setAuthor(user);

		newSciencePaper.setCoAuthor(new ArrayList<User>());
		newSciencePaper.setScentificField(newSciencePaper.getScienceMagazine().getScientificField());

	    try {
	    	indexUploadedFile(newSciencePaper);
	    	newSciencePaper.setPic(newSciencePaper.getTextPDF()[0].getBytes());
	    } catch (IOException e) {
	    	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    }

      //  CyrillicLatinConverter.cir2lat
        newSciencePaper.setName(zameniKarakter(newSciencePaper.getName()));

        newSciencePaper.setKeywords(zameniKarakter(newSciencePaper.getKeywords()));
        newSciencePaper.setAbbstract(zameniKarakter(newSciencePaper.getAbbstract()));

        sciencePaperService.save(newSciencePaper);

	    return new ResponseEntity<String>("Uspesan upload fajla! :)", HttpStatus.OK);
	}
	
	@GetMapping("/reindex")
	public ResponseEntity<String> index() throws IOException {
		File dataDir = getResourceFilePath(DATA_DIR_PATH);
		long start = new Date().getTime();
		int numIndexed = indexer.index(dataDir);
		long end = new Date().getTime();
		
		String text = "Indexing " + numIndexed + " files took " + (end - start) + " milliseconds";
		return new ResponseEntity<String>(text, HttpStatus.OK);
	}

    //konverzija
    public static String zameniKarakter(String text) {


        String text1 = text.toLowerCase();
        String text2 = CyrillicLatinConverter.cir2lat(text1);

        //latinica
        String text3 = text2.replaceAll("đ", "dj");
        String text4 = text3.replaceAll("č", "c");
        String text5 = text4.replaceAll("ć", "c");
        String text6 = text5.replaceAll("dž", "dz");
        String text7 = text6.replaceAll("š", "s");
        String text8 = text7.replaceAll("ž", "z");

        //cirilica
        String text9 = text8.replaceAll("ђ", "dj");
        String text10 = text9.replaceAll("љ", "lj");
        String text11 = text10.replaceAll("њ", "nj");
        String text12 = text11.replaceAll("dj", "d");

        return text12;
    }

    /*
    //uklanjanje stop reci
		private String ukloniStopReci(String text) {
			//stop reci u srpskom jeziku
			//"i", "a", "ili", "ali", "pa", "te", "da", "u", "po", "na"

			String init = text.toLowerCase();

			String text1 = init.replaceAll(" i ", "  ");
			String text2 = text1.replaceAll(" a ", "  ");
			String text3 = text2.replaceAll(" ili ", "  ");
			String text4 = text3.replaceAll(" ali ", "  ");
			String text5 = text4.replaceAll(" pa ", "  ");
			String text6 = text5.replaceAll(" te ", "  ");
			String text7 = text6.replaceAll(" da ", "  ");
			String text8 = text7.replaceAll(" u ", "  ");
			String text9 = text8.replaceAll(" po ", "  ");
			String text10 = text9.replaceAll(" na ", "  ");

			return text10;
		}
    */

}