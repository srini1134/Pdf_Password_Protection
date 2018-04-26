package com.quicklyjava;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class JavaWritePDF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String csvFile = "c:/test/secured_User.csv";
	        String line = "";
	        String cvsSplitBy = ",";
	        
			File file = new File("c:/test/itext.pdf");
			FileOutputStream pdfFileout = new FileOutputStream(file);
			Document doc = new Document();
			PdfWriter writer = PdfWriter.getInstance(doc, pdfFileout);
			
			String user="PASS1",owner="PASS2";
			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] secureUser = line.split(cvsSplitBy);
	                
	                writer.setEncryption(secureUser[2].getBytes(), owner.getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
	            } 
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
			
			

			doc.addAuthor("QuicklyJava.com");
			doc.addTitle("This is title");
			doc.open();

			Paragraph para1 = new Paragraph();
			para1.add("This is paragraph 1");

			Paragraph para2 = new Paragraph();
			para2.add("This is paragraph 2");

			doc.add(para1);
			doc.add(para2);

			doc.close();
			pdfFileout.close();

			System.out.println("Success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
