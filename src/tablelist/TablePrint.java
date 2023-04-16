/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablelist;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author devvu
 */
public class TablePrint {

    public static void Print(ArrayList<ArrayList<String>> data){
        
        
        String path = "D:\\doc.pdf";
        
        
        
           
//        try {

//            PdfDocument doc = new PdfDocument();
////            doc.set
//            Document document = new Document(doc);
//            PdfWriter.getInstance(document, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
//            my_pdf_report.open();
//            //we have four columns in our table
//            PdfPTable my_report_table = new PdfPTable(data.get(0).get(0).length());
//            for (int i = 0; i < data.size(); i++) {
//
//                ArrayList<String> tab = data.get(i);
//                PdfPCell cel = new PdfPCell();
//                for (int j = 0; j < tab.size(); j++) {
//                    cel.addElement(new Phrase(tab.get(j)));
//                }
//                
//                my_report_table.addCell(cel);
//            }
//
//            /* Attach report table to PDF */
//            my_pdf_report.add(my_report_table);
//            my_pdf_report.close();
//        } catch (FileNotFoundException | DocumentException e) {
//            e.printStackTrace();
//        }

    }
}
