package com.example.lucene.indexing.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import com.example.lucene.indexing.filters.CyrillicLatinConverter;
import com.example.lucene.model.IndexUnit;
import org.apache.lucene.document.DateTools;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;



public class Word2007Handler extends DocumentHandler {

	public IndexUnit getIndexUnit(File file) {
		IndexUnit retVal = new IndexUnit();

		try {
			XWPFDocument wordDoc = new XWPFDocument(new FileInputStream(file));
			XWPFWordExtractor we = new XWPFWordExtractor(wordDoc);

			String text = we.getText();
			//retVal.setText(text);
			retVal.setText(CyrillicLatinConverter.cir2lat(text));


			POIXMLProperties props = wordDoc.getProperties();

			String title = props.getCoreProperties().getTitle();
			retVal.setTitle(title);

			String keywords = props.getCoreProperties()
					.getUnderlyingProperties().getKeywordsProperty().getValue();
			retVal.setKeywords(keywords);

			retVal.setFilename(file.getCanonicalPath());
			
			String modificationDate=DateTools.dateToString(new Date(file.lastModified()),DateTools.Resolution.DAY);
			retVal.setFiledate(modificationDate);
			
			we.close();

		} catch (Exception e) {
			System.out.println("Problem pri parsiranju docx fajla");
		}

		return retVal;
	}

	@Override
	public String getText(File file) {
		String text = null;
		try {
			XWPFDocument wordDoc = new XWPFDocument(new FileInputStream(file));
			XWPFWordExtractor we = new XWPFWordExtractor(wordDoc);
			text = we.getText();
			we.close();
		}catch (Exception e) {
			System.out.println("Problem pri parsiranju docx fajla");
		}
		return text;
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
