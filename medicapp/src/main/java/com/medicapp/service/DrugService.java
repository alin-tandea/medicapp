package com.medicapp.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.medicapp.data.access.DrugDAO;
import com.medicapp.data.access.DrugDAOImpl;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.Drug;

import com.medicapp.data.model.Staff;

public class DrugService {

	private static DrugDAO d = new DrugDAOImpl();
	
	public static void addDrugOnPrescription(int idconsultation , int iddrug){
		Date date = new Date();
		d.addDrugOnPrescription(idconsultation, iddrug, date);
	}
	
	public static List<Drug> getAllDrugs(){
		return d.getAllDrugs();
	}
	
	public static List<Drug> searchDrugName(String name){
		return d.getAllDrugs().stream().filter(d -> d.getName().toLowerCase().contains(name)).collect(Collectors.toList());
	}
	
	
	public static void generatePrescript(List<Drug> drugs , int idstaff , int idconsult){
		@SuppressWarnings("unused")
		PdfWriter p ;
		Document document;
		
		document = new Document(PageSize.A4);
		com.itextpdf.text.List orderedList = new com.itextpdf.text.List();
		
		for(Drug d : drugs){
			DrugService.addDrugOnPrescription(idconsult, d.getIddrug());
			ListItem item = new ListItem(d.getName() + " pret : " + d.getPrice() + " lei" );
			item.setAlignment(Element.ALIGN_LEFT);
			orderedList.add(item);
		}
		
		
		Consultation c = ConsultationService.getConsultation(idconsult);
		System.out.println(c);
		Staff staff = StaffService.getStaff(idstaff);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String curentDate = dtf.format(localDate);
		try {
			p = PdfWriter.getInstance(document, new FileOutputStream("prescript.pdf"));
			document.open();
			Paragraph title = new Paragraph("Reteta medicala , eliberata in data de : " + curentDate);
			document.add(title);
			Paragraph info = new Paragraph("Eliberata de : " + staff.getName());
			Paragraph pacientInfo = new Paragraph("Nume titular : " + c.getPatientName());
			//Paragraph cnpInfo = new Paragraph("Cod numeric personal : " + patient.getCnp());
			Paragraph sub = new Paragraph("Lista medicamentelor prescrise si suma decontata");
			Paragraph signature = new Paragraph("Semnatura si stampila medicului :");
			document.add(new Phrase("\n"));
			document.add(info);
			document.add(new Phrase("\n"));
			document.add(pacientInfo);
			document.add(new Phrase("\n"));
			//document.add(cnpInfo);
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(sub);
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(orderedList);
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(signature);
			document.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static ByteArrayOutputStream loadPdf(){
		
		File file = new File("prescript.pdf");
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		byte[] buf = new byte[1024];
		try {
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum); // no doubt here is 0
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		//file.delete();
		return bos;
	}
	
	
}
