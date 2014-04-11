/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastroclinica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo López
 */
public class Compra extends javax.swing.JFrame {

    static boolean actualizarProv = false;
    static boolean actualizarDet=false;
    Connection conexion;
    int anio = 0;
    int mes = 0;
    int dia = 0;
    int idCompra = 0;
    int nFactura = 0;
    String proveedor = "";
    String fecha = "";
    int idUsuario = 0;

    /**
     * CrearecargarProves new form Compra
     */
    public Compra() {
        initComponents();
        establecerConexion();
        cargarProveedoress();
        iniciarCompra();
        this.setLocationRelativeTo(null);
        jDialog1.setLocation(this.getLocation().x + 65, this.getLocation().y + 65);
        jDialog1.setSize(510, 330);
        jTable1.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        idUsuario = 2;
    }

    public Compra(int idUsuario,Connection conexion) {
        initComponents();
        this.setLocationRelativeTo(null);
        jDialog1.setLocation(this.getLocation().x + 65, this.getLocation().y + 65);
        jDialog1.setSize(510, 330);
        jTable1.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        this.idUsuario = idUsuario;
        this.conexion=conexion;
        cargarProveedoress();
        iniciarCompra();
    }

    private void iniciarCompra() {
        ResultSet obtenerIDF = devolverResultado("select id from Compra where Fecha='2000-01-01';");
        try {
            if (obtenerIDF.next() == true) {
                idCompra = obtenerIDF.getInt("id");
            } else {
                String insertar = "insert into Compra(Fecha,Total,Usuario_id,Proveedor_id) values"
                        + "('2000-01-01',66.66,"+idUsuario+",1);";
                consultaInsertar(insertar);
                ResultSet obtenerOtraVez = devolverResultado("select id from Compra where Fecha='2000-01-01';");
                obtenerOtraVez.next();
                idCompra = obtenerOtraVez.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This merecargarProvhod is called from wirecargarProvhin recargarProvhe consrecargarProvrucrecargarProvor
 recargarProvo inirecargarProvialize recargarProvhe form. WARNING: Do NOT modify recargarProvhis code.
 The conrecargarProvenrecargarProv of recargarProvhis merecargarProvhod is always regenerarecargarProved by
 recargarProvhe Form EdirecargarProvor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap(0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("No. factura:");

        jLabel2.setText("Fecha compra:");

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Proveedor:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton5.setText("Agregar Producto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Total:");

        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Guardar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Limpiar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton8)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dia = jCalendar1.getDayChooser().getDay();
        mes = jCalendar1.getMonthChooser().getMonth() + 1;
        anio = jCalendar1.getYearChooser().getYear();
        jTextField2.setText(anio + "-" + mes + "-" + dia);
        jDialog1.dispose();
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jDialog1.show(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        AgregarProducto nuevo = new AgregarProducto(idCompra);
        actualizarDet=false;
        recargarDet.start();
        nuevo.show(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//        // TODO add your handling code here:
//        try {
//            conexion.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(TipoTelefono.class.getName()).log(Level.SEVERE, null, ex);
//        }
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ResultSet dc = devolverResultado("select* from Detalle_Compra where Compra_id=" + idCompra + ";");
        try {
            if (jTextField1.getText().compareTo("") != 0 && jTextField2.getText().compareTo("") != 0
                    && jComboBox1.getSelectedIndex() != 0 && dc.next() == true) {
                nFactura = Integer.parseInt(jTextField1.getText());
                fecha = "\'" + anio + "-" + mes + "-" + dia + "\'";
                proveedor = jComboBox1.getSelectedItem().toString();
                String[] partes = proveedor.split("-");
                String nombre = partes[0];
                String apellido = partes[1];
                ResultSet obtenerIDP = devolverResultado("select id from Proveedor where Nombre=\"" + nombre + "\" and Apellido=" + "\"" + apellido + "\";");
                obtenerIDP.next();
                int idP = obtenerIDP.getInt("id");
                ResultSet obtenerTotal = devolverResultado("select sum(DC.Subtotal) as Total from Compra C inner join Detalle_Compra DC on C.id=DC.Compra_id where C.id=" + idCompra + ";");
                obtenerTotal.next();
                double total = obtenerTotal.getDouble("Total");
                jLabel5.setText(total + "");
                consultaInsertar("update Compra set Fecha=" + fecha + " ,Usuario_id=" + idUsuario + " ,Proveedor_id=" + idP + " ,Total=" + total + " where id=" + idCompra + ";");
                JOptionPane.showMessageDialog(null, "Compra realizada con exito", "", JOptionPane.INFORMATION_MESSAGE);
                jButton3.setEnabled(false);
                jButton5.setEnabled(false);
                jButton7.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "No deje en blanco ningun cambo", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Proveedor nuevo = new Proveedor();
        actualizarProv=false;
        recargarProv.start();
        nuevo.show(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
        jButton7.setEnabled(true);
        iniciarCompra();
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
        ResultSet detalleC = devolverResultado("select P.Nombre,Pre.Presentacion,L.Numero as Numero_Lote,L.Fecha_Vencimiento,DC.Cantidad,DC.Costo,DC.Subtotal from Compra C inner join Detalle_Compra DC on C.id=DC.Compra_id inner join Lote L on DC.Lote_id=L.id inner join Producto_Presentacion PP on L.Producto_Presentacion_id=PP.id inner join Producto P on PP.Producto_id=P.id inner join Presentacion Pre on PP.Presentacion_id=Pre.id where C.id=" + idCompra + ";");
        try {
            cargarDC(detalleC);
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed
    public void cargarDC(ResultSet resultado) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("Nombre");
        modelo.addColumn("Presentación");
        modelo.addColumn("No. lote");
        modelo.addColumn("Fecha de vencimiento");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Costo");
        modelo.addColumn("Subtotal");
        while (resultado.next() == true) {
            Object[] fila = new Object[7];
            fila[0] = resultado.getString("Nombre");
            fila[1] = resultado.getString("Presentacion");
            fila[2] = resultado.getString("Numero_Lote");
            fila[3] = resultado.getString("Fecha_Vencimiento");
            fila[4] = resultado.getString("Cantidad");
            fila[5] = resultado.getString("Costo");
            fila[6] = resultado.getString("Subtotal");
            modelo.addRow(fila);
        }
    }

    private void cargarProveedoress() {
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Seleccione un proveedor");
        try {
            ResultSet resultado = devolverResultado("Select* from Proveedor;");
            while (resultado.next() == true) {
                jComboBox1.addItem(resultado.getString("Nombre") + "-" + resultado.getString("Apellido"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    Timer recargarProv = new Timer (200, new ActionListener () 
    { 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(actualizarProv==true){
            cargarProveedoress();
            actualizarProv=false;
            recargarProv.stop();
            
        }
     } 
    }); 
    Timer recargarDet = new Timer (200, new ActionListener () 
    { 
    @Override
        public void actionPerformed(ActionEvent e) {
            if (actualizarDet == true) {
                ResultSet detalleC = devolverResultado("select P.Nombre,Pre.Presentacion,L.Numero as Numero_Lote,L.Fecha_Vencimiento,DC.Cantidad,DC.Costo,DC.Subtotal from Compra C inner join Detalle_Compra DC on C.id=DC.Compra_id inner join Lote L on DC.Lote_id=L.id inner join Producto_Presentacion PP on L.Producto_Presentacion_id=PP.id inner join Producto P on PP.Producto_id=P.id inner join Presentacion Pre on PP.Presentacion_id=Pre.id where C.id=" + idCompra + ";");
                try {
                    cargarDC(detalleC);
                } catch (SQLException ex) {
                    Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
                actualizarDet=false;
                recargarDet.stop();
            }
        }
    });
    public ResultSet devolverResultado(String consulta) {
        ResultSet devolver = null;
        try {
            Statement s = conexion.createStatement();
            devolver = s.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return devolver;
    }

    public void consultaInsertar(String sql) {
        try {
            Statement insertar = conexion.createStatement();
            insertar.executeUpdate(sql);
            //JOptionPane.showMessageDialog(null, "Consulta realizada con exito", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de almacenar la informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/DBGastroClinica", "root", "ingenieria");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //return false;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            // return false;
        }
        //return true;
    }

    /**
     * @param args recargarProvhe command line argumenrecargarProvs
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
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
