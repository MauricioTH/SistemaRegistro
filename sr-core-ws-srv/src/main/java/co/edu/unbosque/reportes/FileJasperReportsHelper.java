/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.reportes;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.JRXmlExporter;

/**
 *
 * @author Mauricio
 */

public class FileJasperReportsHelper {
    public <T> byte[] writeCollectionIntoPDFByte(List<T> contents, String formato) throws Exception {
        byte bytes[] = null;
        try {

        	
        	 //InputStream inputStream = new FileInputStream("src/main/java/co/edu/unbosque/reportes/Requeridos");
            InputStream inputStreamImagen = this.getClass().getResourceAsStream("imagen.jpg");       	
        	HashMap<String, Object> params = new HashMap<String, Object>();
            //params.put("imagen", inputStreamImagen);
            //params.put("listaCuentas", contents);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStreamImagen, params, new JRBeanCollectionDataSource(contents));

            bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            return bytes;
        } catch (JRException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public <T> byte[] writeCollectionIntoExcelByte(List<T> contents, String formato) throws Exception {
        byte bytes[] = null;
        try {

          
            
            InputStream inputStream = new FileInputStream(formato);
            
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            HashMap<String, Object> params = new HashMap<String, Object>();
            //params.put("imagen", inputStreamImagen);
            //params.put("listaCuentas", contents);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, new JRBeanCollectionDataSource(contents));
            
            JRXlsExporter  xlsExporter  = new JRXlsExporter();
            xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);   
            xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);   

            System.out.println("Exporting report...");
            xlsExporter.exportReport();

            bytes = output.toByteArray();
            return bytes;
        } catch (JRException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public <T> byte[] writeCollectionIntoXmlByte(List<T> contents, String formato) throws Exception {
        byte bytes[] = null;
        try {

            InputStream inputStream = this.getClass().getResourceAsStream(formato);
            //InputStream inputStreamImagen = this.getClass().getResourceAsStream("imagen.jpg");
            
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            HashMap<String, Object> params = new HashMap<String, Object>();
            //params.put("imagen", inputStreamImagen);
            //params.put("listaCuentas", contents);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, new JRBeanCollectionDataSource(contents));
            
            JRXmlExporter xmlExporter  = new JRXmlExporter();
            xmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            xmlExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);   
            xmlExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);   

            System.out.println("Exporting report...");
            xmlExporter.exportReport();

            bytes = output.toByteArray();
            return bytes;
        } catch (JRException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public <T> byte[] writeCollectionIntoCsvByte(List<T> contents, String formato) throws Exception {
        byte bytes[] = null;
        try {

            InputStream inputStream = this.getClass().getResourceAsStream(formato);
            //InputStream inputStreamImagen = this.getClass().getResourceAsStream("imagen.jpg");
            
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            HashMap<String, Object> params = new HashMap<String, Object>();
            //params.put("imagen", inputStreamImagen);
            //params.put("listaCuentas", contents);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, new JRBeanCollectionDataSource(contents));
            
            JRCsvExporter csvExporter  = new JRCsvExporter();
            csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            csvExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);   
            csvExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);   

            System.out.println("Exporting report...");
            csvExporter.exportReport();

            bytes = output.toByteArray();
            return bytes;
        } catch (JRException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
