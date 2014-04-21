/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gastroclinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sun.rmi.rmic.newrmic.jrmp.JrmpGenerator;

/**
 *
 * @author Geek
 */
public final class reporteFactura {
    Connection conexion;
    int id;
    
    public reporteFactura(Connection conexion, int id) throws JRException{
            this.conexion =conexion;
            this.id =id;
            
     
    }
    public void imprimirReporte(int id) throws JRException{
        JOptionPane.showMessageDialog(null,"DENTRO");
        
        String plantilla = "src/gastroclinica/ReporteFacturasGastro.jasper";
        JasperReport reporte = null;
        reporte =(JasperReport) JRLoader.loadObject(plantilla);
        Map param = new HashMap();
        //El primero el el nombre del parametro que esta en el reporte y la segunda es lo que se enviara como parametro
        param.put("Factura_id", id);
        JasperPrint jasperprint = JasperFillManager.fillReport(reporte, param, conexion);
        JasperViewer visor = new JasperViewer(jasperprint, false);
        visor.setTitle("Facturas - Farmacia Gastroclinica");
        visor.setVisible(true);
    
    }
    
    
         
    
}
