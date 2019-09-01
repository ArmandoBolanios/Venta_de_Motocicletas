package modelo;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReporteEmpleado extends DataBase {
    
    public void formatoPDF() {
        {
            try
              { 
              //String ubReporte = System.getProperty("user.dir")+"/src/reporte/reporte.jasper";
              JasperReport Reporte = (JasperReport) JRLoader.loadObject("iEmple.jasper");
              JasperPrint print = JasperFillManager.fillReport(Reporte, null, this.getConexion());
              FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf","PDF");
              JFileChooser fileChooser = new JFileChooser();       
              fileChooser.setFileFilter(filter);
              int seleccion = fileChooser.showOpenDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION)
                {
                   File f=fileChooser.getSelectedFile().getAbsoluteFile();
                   
              JRExporter exporter = new JRPdfExporter();
              exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
              exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(f+".pdf"));
              exporter.exportReport();
                }
        }
        catch(JRException ex)
          {
          Logger.getLogger(ReporteEmpleado.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null,"Error "+ex);
          }
        }
    }
    
    public void formatoWORD() {
        {
            try
          {
              //String ubReporte = System.getProperty("user.dir")+"/src/reporte/reporte.jasper";
              JasperReport Reporte = (JasperReport) JRLoader.loadObject("iEmple.jasper");
              JasperPrint print = JasperFillManager.fillReport(Reporte, null, this.getConexion());
              FileNameExtensionFilter filter = new FileNameExtensionFilter("Documento de Word","docx","DOCX");
              JFileChooser fileChooser = new JFileChooser();       
              fileChooser.setFileFilter(filter);
              int seleccion = fileChooser.showOpenDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION)
                {
                   String f=fileChooser.getSelectedFile()+"";
                   
              JRExporter exporter = new JRDocxExporter();
              exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
              exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(f+".docx"));
              exporter.exportReport();
                }
        }
        catch(JRException ex)
          {
          JOptionPane.showMessageDialog(null,"Error "+ex);
          }
        }
    }
    
    public void formatoEXCEL() {
        {
            try
          {
              //carga el archivo con extensión   .jasper
              JasperReport Reporte = (JasperReport) JRLoader.loadObject("iEmple.jasper");
//preparacion del reporte..llena el diseño del reporte..reporte diseñado y compilado con iReport              
              JasperPrint print = JasperFillManager.fillReport(Reporte, null, this.getConexion());
              FileNameExtensionFilter filter = new FileNameExtensionFilter("Libro de Excel","xlsx","XLSX");
              
//representa un fichero y nos permite obtener informacion sobre él.              
              JFileChooser fileChooser = new JFileChooser();       
              fileChooser.setFileFilter(filter);
              
              int seleccion = fileChooser.showOpenDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION)
                {
                   File f = fileChooser.getSelectedFile().getAbsoluteFile();
                   
              JRExporter exporter = new JRXlsxExporter();
              exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
              exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(f+".xlsx"));
              exporter.exportReport();
                }
        }
        catch(JRException ex)
          {
          JOptionPane.showMessageDialog(null,"Error"+ex);
          } 
        }
        }
}
