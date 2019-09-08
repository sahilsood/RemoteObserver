/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserver.reports;

import java.io.InputStream;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import remoteobserver.alpha.DBConnection;

/**
 *
 * @author Sood
 */
public class GenerateReport {

    public void generate(String report) {
        try {
            InputStream design = getClass().getResourceAsStream(report);
            JasperDesign jasperdesing = JRXmlLoader.load(design);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperdesing);
            Connection con = DBConnection.getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }

    }
}
