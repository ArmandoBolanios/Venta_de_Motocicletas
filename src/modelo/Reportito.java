package modelo;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;//
import net.sf.jasperreports.engine.JasperPrint;//puede ser impreso a pdf,etc
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class Reportito extends DataBase {
    {
        try {
            JasperReport Reporte = (JasperReport) JRLoader.loadObject("report2.jasper");
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
        }catch(JRException jasperError) {
            JOptionPane.showMessageDialog(null, jasperError.getMessage());
        }
    }
}
