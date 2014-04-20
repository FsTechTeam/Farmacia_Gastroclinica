/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gastroclinica;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geek
 */
public class Ventas extends javax.swing.JFrame {

    /**
     * Creates new form Ventas
     */
    ArrayList<VentasT> ArrayVentas = new ArrayList();
    Double totalFactura;
    Connection conexion;
    IngresoNvoCliente ingresoCliente = new IngresoNvoCliente();
    int cliente_id = 1;
    int usuario_id;
    String fecha;
    
    public Ventas() {
        
        initComponents();
           Calendar Cal= Calendar.getInstance();
           fecha= Cal.get(Cal.YEAR)+"-"+(Cal.get(Cal.MONTH)+1)+"-"+Cal.get(Cal.DATE);
           establecerConexion();
           
           totalFactura =0.0;
           
    }
    public void asignarUsuario(int usuario_id){
        this.usuario_id=usuario_id;
    
    }
    
    
    
    //Conexion con la base de Datos
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
    //Fin Conexion base de datos
 
    //Funcion principal
    void captarDatos(ArrayList<VentasT> lista1){
        
        ArrayVentas = lista1;
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("Cantidad");
        modelo1.addColumn("NOMBRE");
        modelo1.addColumn("FABRICANTE");
        modelo1.addColumn("PRESENTACION");
        modelo1.addColumn("PRECIO");
        
        tbventas.setModel(modelo1);
        String[]datos3 = new String [5];
        for (int i = 0; i < lista1.size(); i++) {
               datos3[0] = String.valueOf(lista1.get(i).getCantidad());
               datos3[1] = (lista1.get(i).getNombre());
               datos3[2] = (lista1.get(i).getFabricante());
               datos3[3] = (lista1.get(i).getPresentacion());
               datos3[4] = String.valueOf(lista1.get(i).getPrecio());               
               modelo1.addRow(datos3);
               totalFactura += (lista1.get(i).getPrecio()* lista1.get(i).getCantidad());
               
        }
        label9.setText(String.valueOf(totalFactura));
    }
    //Fin funcion principal
    
    //Insertar Factura
    public void insertarFactura(){
        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement("insert into Factura(Fecha, Total, Numero, Serie, Cliente_id, Usuario_id) values(?,?,?,?,?,?)");
                pst.setString(1, fecha);
                pst.setDouble(2, totalFactura);
                pst.setString(3, TextNit2.getText());
                pst.setString(4, TextNit1.getText());
                pst.setInt(5, cliente_id);
                pst.setInt(6, usuario_id);
                pst.execute();
                insertarDetalle();
                JOptionPane.showMessageDialog(null,"FACTURA OK");
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //fin Insertar Factura
    }
    //Insertar  detalle Factura
    int idLote, idFactura;
    double subTotal;
    public void insertarDetalle() throws SQLException{
        Statement st = conexion.createStatement();
        ResultSet rs;
        PreparedStatement pst;
        pst = conexion.prepareStatement("Select max(id) from Factura");
        rs=pst.executeQuery();
        while(rs.next()){
            
            idFactura = rs.getInt(1);
                    
        }
        for (int i = 0; i < ArrayVentas.size(); i++) {          
          pst = conexion.prepareStatement("select L.id from Producto P inner join Producto_Presentacion PP on P.id=PP.Producto_id inner join Lote L on PP.id = L.Producto_Presentacion_id where P.id = '"+ArrayVentas.get(i).getId()+"'");
          rs = pst.executeQuery();
          while(rs.next()){
              
              idLote =rs.getInt(1);
          }
          subTotal = (ArrayVentas.get(i).getCantidad()* ArrayVentas.get(i).getPrecio());
          pst = conexion.prepareStatement("insert into Detalle_Factura(Subtotal, Cantidad, Precio_Venta, Factura_id, Lote_id)values(?,?,?,?,?)");
          pst.setDouble(1,subTotal);
          pst.setInt(2, ArrayVentas.get(i).getCantidad());
          pst.setDouble(3, ArrayVentas.get(i).getPrecio());
          pst.setInt(4, idFactura);
          pst.setInt(5, idLote);
          pst.execute();
          JOptionPane.showMessageDialog(null,"Detalle OK");
        }
    }
    //Fin insertarDetalle
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbventas = new javax.swing.JTable();
        panel1 = new java.awt.Panel();
        label1 = new java.awt.Label();
        TextNit = new javax.swing.JTextField();
        TextNombre = new javax.swing.JTextField();
        TextDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        label5 = new java.awt.Label();
        label9 = new java.awt.Label();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        label11 = new java.awt.Label();
        label10 = new java.awt.Label();
        label2 = new java.awt.Label();
        TextNit1 = new java.awt.Label();
        label4 = new java.awt.Label();
        TextNit2 = new java.awt.Label();
        label12 = new java.awt.Label();
        jButton2 = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbventasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 678, 217));

        panel1.setForeground(new java.awt.Color(51, 255, 51));

        label1.setFont(new java.awt.Font("Lao MN", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(51, 0, 51));
        label1.setText("Cliente");

        TextNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNitActionPerformed(evt);
            }
        });
        TextNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextNitKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextNitKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lao MN", 0, 14)); // NOI18N
        jLabel1.setText("N.I.T.");

        jLabel2.setFont(new java.awt.Font("Lao MN", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Lao MN", 0, 14)); // NOI18N
        jLabel3.setText("Direccion:");

        button1.setLabel("+");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panel1Layout = new org.jdesktop.layout.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panel1Layout.createSequentialGroup()
                        .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1))
                        .add(31, 31, 31)
                        .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(panel1Layout.createSequentialGroup()
                                .add(TextNit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(button1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(TextNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 234, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(panel1Layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(18, 18, 18)
                        .add(TextDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(label1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(label1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(panel1Layout.createSequentialGroup()
                        .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(TextNit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jLabel2))
                    .add(panel1Layout.createSequentialGroup()
                        .add(button1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(TextNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(TextDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 170));
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        label9.setFont(new java.awt.Font("Lao MN", 0, 18)); // NOI18N
        label9.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 22, -1));

        filler1.setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 484, 105, 27));

        label11.setFont(new java.awt.Font("Lao MN", 0, 18)); // NOI18N
        label11.setText("Q.");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, -1));

        label10.setFont(new java.awt.Font("Lao MN", 0, 18)); // NOI18N
        label10.setText("VENTAS");
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        label2.setFont(new java.awt.Font("Lao MN", 2, 18)); // NOI18N
        label2.setText("Serie");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, -1));

        TextNit1.setFont(new java.awt.Font("Lao MN", 2, 18)); // NOI18N
        TextNit1.setForeground(new java.awt.Color(255, 51, 51));
        TextNit1.setText("A");
        getContentPane().add(TextNit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, -1));

        label4.setFont(new java.awt.Font("Lao MN", 2, 18)); // NOI18N
        label4.setText("Factura No.");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        TextNit2.setFont(new java.awt.Font("Lao MN", 2, 18)); // NOI18N
        TextNit2.setForeground(new java.awt.Color(255, 51, 51));
        TextNit2.setText("00198");
        getContentPane().add(TextNit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        label12.setFont(new java.awt.Font("Lao MN", 0, 18)); // NOI18N
        label12.setText("Total");
        getContentPane().add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gastroclinica/shopping-cart-accept-icon.png"))); // NOI18N
        jButton2.setText("Pagar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 130, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextNitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextNitKeyPressed
        boolean bandera=false;
        int code= evt.getKeyCode();
        
        if ( code == KeyEvent.VK_ENTER) {
            if ("C".equals(TextNit.getText()) | "c".equals(TextNit.getText())) {
                TextNit.setText("C/F");
                TextNombre.setText("C/F");
                TextDireccion.setText("C/F");
                TextNit.enable(false);
                TextNombre.enable(false);
                TextDireccion.enable(false);
            }
                
            String nit;
            nit = TextNit.getText();
            try {
                //Para buscar el nombre
                
                   String nit1, nombre;    
                   Statement st = conexion.createStatement();
                   ResultSet rs= st.executeQuery("select NIT, Nombre, Apellido, Ciudad, id from Cliente where NIT = '"+nit+"'");
                    while(rs.next()){
                       TextNit.setText(rs.getString(1));
                        if (nit == null ? TextNit.getText() == null : nit.equals(TextNit.getText())) {
                            TextNombre.setText(rs.getString(2) +" "+ rs.getString(3) );
                            TextDireccion.setText(rs.getString(4));
                            TextNombre.enable(false);
                            TextDireccion.enable(false);
                            cliente_id = rs.getInt(5);
                            bandera=true;
                        }
                    } 
                    if (bandera==false) {
                        JOptionPane.showMessageDialog(null, "No existe el Usuario");                               
                        ingresoCliente.show();
                }
                
                //Fin buscar nombre

            } catch (SQLException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        } else {
        }
    }//GEN-LAST:event_TextNitKeyPressed

    private void tbventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbventasMouseClicked
            
    }//GEN-LAST:event_tbventasMouseClicked

    private void TextNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNitActionPerformed

    private void TextNitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextNitKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TextNitKeyTyped

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        
        TextNit.setText(String.valueOf(idFactura));
        TextNombre.setText("");
        TextDireccion.setText("");
        
    }//GEN-LAST:event_button1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        insertarFactura();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextDireccion;
    private javax.swing.JTextField TextNit;
    private java.awt.Label TextNit1;
    private java.awt.Label TextNit2;
    private javax.swing.JTextField TextNombre;
    private java.awt.Button button1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label9;
    private java.awt.Panel panel1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tbventas;
    // End of variables declaration//GEN-END:variables
    
    
    
    
}
