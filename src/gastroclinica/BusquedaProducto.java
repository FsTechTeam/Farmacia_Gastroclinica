/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gastroclinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geek
 */
public class BusquedaProducto extends javax.swing.JFrame {

    /**
     * Creates new form BusquedaProducto
     */
    
    Connection conexion;
    String[]datos = new String [6];
    String[]datos1 = new String [6];
    int contProductosCar =0;
    int usuario_id;
    
   
    
    ArrayList<VentasT> lista = new ArrayList<VentasT>();
    
    public BusquedaProducto() {
        initComponents();
        establecerConexion();
    }
    
    private void establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBGastroClinica", "root", "mju7cde3");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
           
        }
        
    }
    public void Insertar(String nombre, String apellido, String direccion, String nit){
       
        try{
            PreparedStatement pst = conexion.prepareStatement("insert into Cliente(Nombre, Apellido, Ciudad, NIT) values(?,?,?,?)");
                                   
                pst.setString(1, nombre);
                pst.setString(2, apellido);
                pst.setString(3, direccion);
                pst.setString(4, nit);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Se ha ingresado el Producto exitosamente!");
                 int n = JOptionPane.showConfirmDialog(null, "Deseas ingresar un nuevo cliente?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                    
            
           }catch(Exception e){
               
           }             
     }
    
    /*void prueba(ArrayList<VentasT> lista1){
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");
        modelo1.addColumn("NOMBRE");
        modelo1.addColumn("FABRICANTE");
        modelo1.addColumn("PRESENTACION");
        modelo1.addColumn("PRECIO");
        modelo1.addColumn("EXISTENCIA");
        jTable1.setModel(modelo1);
        String[]datos3 = new String [6];
        for (int i = 0; i < lista1.size(); i++) {
               datos3[0] = String.valueOf(lista1.get(i).getId());
               datos3[1] = (lista1.get(i).getNombre());
               datos3[2] = (lista1.get(i).getFabricante());
               datos3[3] = (lista1.get(i).getPresentacion());
               datos3[4] = String.valueOf(lista1.get(i).getPrecio());
               datos3[5] = String.valueOf(lista1.get(i).getExistencia());
               modelo1.addRow(datos3);
        }
        
    
    }*/
    void mostrarDatos(String texto){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("FABRICANTE");
        modelo.addColumn("PRESENTACION");
        modelo.addColumn("PRECIO");
        modelo.addColumn("EXISTENCIA");
        
        tbProductos.setModel(modelo);
        tbProductos.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
           
        
        try{
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select P.id, P.Nombre, P.Fabricante , Pr.Presentacion, PP.Precio_Venta , PP.Existencia_Total from Producto P inner join Producto_Presentacion PP on  P.id = PP.Producto_id inner join Presentacion Pr on PP.Presentacion_id = Pr.id where P.Nombre like '%"+texto+"%'"); 
           while(rs.next()){
                datos[1] =rs.getString(2);
                datos[2] =rs.getString(3);
                datos[3] =rs.getString(4);
                datos[4] =rs.getString(5);
                datos[5] =rs.getString(6);
                datos[0] =rs.getString(1);
                modelo.addRow(datos);
            }
            tbProductos.setModel(modelo);
            tbProductos.getColumnModel().getColumn(0).setMaxWidth(0);
            tbProductos.getColumnModel().getColumn(0).setMinWidth(0);
        }catch(Exception e){
        
        }
    
    }
    public void obtenerDatos(String[]vect1){
            
          
        
    
    }
    //Asignar Usuario
    public void asignarUsuario(int usuario_id){
        this.usuario_id=usuario_id;
    
    }
    
    public void insertarProductos(String[]vect2){
           String nombre="", fabricante="", presentacion="", precio="", existencia="";
            nombre = vect2[0];
           fabricante=vect2[1];
           presentacion=vect2[2];
           precio=vect2[3];
           existencia=vect2[4];
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TextBusqueda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProductos.setEditingColumn(0);
        tbProductos.setEditingRow(0);
        tbProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        tbProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbProductosFocusGained(evt);
            }
        });
        tbProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbProductosKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 110, 785, 280);

        jLabel2.setFont(new java.awt.Font("Seravek", 0, 13)); // NOI18N
        jLabel2.setText("INGRESA EL NOMBRE DEL PRODUCTO QUE ESTAS BUSCANDO . . .");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(57, 43, 377, 16);

        jLabel1.setFont(new java.awt.Font("Seravek", 0, 24)); // NOI18N
        jLabel1.setText("BUSQUEDA DE PRODUCTOS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(16, 6, 292, 31);

        TextBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBusquedaActionPerformed(evt);
            }
        });
        TextBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextBusquedaKeyPressed(evt);
            }
        });
        getContentPane().add(TextBusqueda);
        TextBusqueda.setBounds(10, 70, 387, 37);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gastroclinica/shopping-cart-insert-icon.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(820, 250, 60, 60);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gastroclinica/shopping-cart-accept-icon.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(820, 320, 60, 60);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gastroclinica/Close-2-icon.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel5MouseMoved(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(820, 180, 60, 60);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gastroclinica/Pencil-icon.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel6MouseMoved(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(820, 110, 60, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBusquedaActionPerformed
        
    }//GEN-LAST:event_TextBusquedaActionPerformed

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
       
        int fil = tbProductos.getSelectedRow();
           
           datos1[0]= tbProductos.getValueAt(fil, 0).toString();
           datos1[1]= tbProductos.getValueAt(fil, 1).toString();
           datos1[2]= tbProductos.getValueAt(fil, 2).toString();
           datos1[3]= tbProductos.getValueAt(fil, 3).toString();
           datos1[4]= tbProductos.getValueAt(fil, 4).toString();
           datos1[5] = tbProductos.getValueAt(fil, 5).toString();                 
           obtenerDatos(datos1);
           
        
   
            
        
           
        
           
           
        //obtenerDatos(datos, fil);
    }//GEN-LAST:event_tbProductosMouseClicked

    private void tbProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbProductosFocusGained
         
    }//GEN-LAST:event_tbProductosFocusGained

    private void TextBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextBusquedaKeyPressed
        
        mostrarDatos(TextBusqueda.getText());
        
    }//GEN-LAST:event_TextBusquedaKeyPressed

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        
    }//GEN-LAST:event_tbProductosKeyPressed

    private void tbProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tbProductosKeyTyped

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here: jlabel click
        boolean siExiste=false;
        for (int i = 0; i < 6; i++) {
            if (datos[i]==null) {
                JOptionPane.showMessageDialog(null, "Selecciona el producto a ingresar");
            }
        }
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == Integer.parseInt(datos1[0])) {
                String cantidad= JOptionPane.showInputDialog(null, "Cantidad de producto", "Cantidad de"+lista.get(i).getNombre()+"desea comprar?", JOptionPane.QUESTION_MESSAGE);
                lista.get(i).setCantidad(Integer.parseInt(cantidad));
                siExiste =true;
                break;
            }
        }
        if ( siExiste == false) {
           lista.add(new VentasT(Integer.parseInt(datos1[0]), datos1[1], datos1[2], datos1[3], Double.parseDouble(datos1[4]), Integer.parseInt(datos1[5]),1));
           contProductosCar += 1;
        }
        
        
        JOptionPane.showMessageDialog(null,"Se ha añadido Correctamente"); 
        jLabel3.setText(String.valueOf(contProductosCar)); 
       
       // prueba(lista);
        
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here: FACTURAR
        Ventas formVentas = new Ventas();
        formVentas.captarDatos(lista);
        formVentas.asignarUsuario(usuario_id);
        formVentas.show();
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
            
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked
    
    
    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseReleased

    private void jLabel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseMoved
        // TODO add your handling code here:
        jLabel6.setToolTipText("Modificar Producto");
    }//GEN-LAST:event_jLabel6MouseMoved

    private void jLabel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseMoved
        // TODO add your handling code here:
        jLabel5.setToolTipText("Eliminar Producto");
    }//GEN-LAST:event_jLabel5MouseMoved

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved
        // TODO add your handling code here:
        jLabel3.setToolTipText("Cargar a Factura");
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved
        // TODO add your handling code here:
        jLabel4.setToolTipText("Facturar");
    }//GEN-LAST:event_jLabel4MouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaProducto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProductos;
    // End of variables declaration//GEN-END:variables
}
