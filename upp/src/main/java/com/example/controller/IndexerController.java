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
import com.example.lucene.model.IndexUnit;
import com.example.model.*;
import com.example.service.MagazineService;
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
	        	indexUnit.setNameMagazine(model.getScienceMagazine().getName());
	        	indexUnit.setTitle(model.getName());
	        	indexUnit.setAuthor(model.getAuthor().getFirstname() + " " + model.getAuthor().getLastname());
	            indexUnit.setKeywords(model.getKeywords());
	            //indexUnit.setText(preuzmiSadrzajFajla(file));
	            indexUnit.setScientificField(model.getScienceMagazine().getScientificField().getName());
	            indexer.add(indexUnit);
	        }
	    }
	}
		
	//indeksiranje i dodavanje rada
	@PostMapping("/index/add/{id}")
	//public ResponseEntity<String> multiUploadFileModel(@ModelAttribute SciencePaper sciencePaper, @PathVariable Long id) {
	public ResponseEntity<String> multiUploadFileModel(@ModelAttribute("currentUser") CurrentUser currentUser, @ModelAttribute SciencePaper sciencePaper, @PathVariable Long id) {
		//@ModelAttribute SciencePaper sciencePaper
		System.out.println("\n\t\taaaa oblas");
		User user = currentUser.getUser();
		List<User> coAuthor = new ArrayList<User>();
		Magazine magazine = magazineService.findOne(id);
		//ID DODELITI NA OSNOVU COMBO BOX
        sciencePaper.setScienceMagazine(magazine);
        sciencePaper.setNameMagazine(sciencePaper.getScienceMagazine().getName());
        sciencePaper.setNameScientifiField(sciencePaper.getScienceMagazine().getScientificField().getName());
		System.out.println("\n\t\tnaucna oblast kojoj pripada rad: " + sciencePaper.getScienceMagazine().getScientificField().getName());


        sciencePaper.setAuthor(user);

        sciencePaper.setCoAuthor(new ArrayList<User>());
		sciencePaper.setScentificField(sciencePaper.getScienceMagazine().getScientificField());

	    try {
	    	indexUploadedFile(sciencePaper);
	    } catch (IOException e) {
	    	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    }

        sciencePaperService.save(sciencePaper);
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

}