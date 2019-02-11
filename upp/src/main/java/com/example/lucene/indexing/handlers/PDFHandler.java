package com.example.lucene.indexing.handlers;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.example.lucene.indexing.filters.CyrillicLatinConverter;
import com.example.lucene.model.IndexUnit;
import org.apache.lucene.document.DateTools;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.text.PDFTextStripper;


public class PDFHandler extends DocumentHandler {

	@Override
	public IndexUnit getIndexUnit(File file) {
		IndexUnit retVal = new IndexUnit();
		try {
			PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
			parser.parse();
			String text = getText(parser);
			retVal.setText(zameniKarakter(text));

			// metadata extraction
			PDDocument pdf = parser.getPDDocument();
			PDDocumentInformation info = pdf.getDocumentInformation();

			String title = ""+info.getTitle();
			retVal.setTitle(title);

			String keywords = ""+info.getKeywords();
			retVal.setKeywords(keywords);
			
			retVal.setFilename(file.getCanonicalPath());
			
			String modificationDate=DateTools.dateToString(new Date(file.lastModified()),DateTools.Resolution.DAY);
			retVal.setFiledate(modificationDate);
			
			pdf.close();
		} catch (IOException e) {
			System.out.println("Greksa pri konvertovanju dokumenta u pdf");
		}

		return retVal;
	}

	@Override
	public String getText(File file) {
		try {
			PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
			parser.parse();
			PDFTextStripper textStripper = new PDFTextStripper();
			String text = textStripper.getText(parser.getPDDocument());
			return text;
		} catch (IOException e) {
			System.out.println("Greksa pri konvertovanju dokumenta u pdf");
		}
		return null;
	}
	
	public String getText(PDFParser parser) {
		try {
			PDFTextStripper textStripper = new PDFTextStripper();
			String text = textStripper.getText(parser.getPDDocument());
			return text;
		} catch (IOException e) {
			System.out.println("Greksa pri konvertovanju dokumenta u pdf");
		}
		return null;
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



}
