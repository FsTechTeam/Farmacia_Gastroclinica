/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gastroclinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Geek
 */
public class Conectar {
    Connection conectar = null;

    /**
     * La clase conectar hace la conexion con la base de datos
     *
     * @return
     */
    public Connection conexion() {

        try {
            String host = "";
            String DB = "";
            String user = "";
            String pass = "";
            host = JOptionPane.showInputDialog(null, "Servidor por defecto", "Servidor:", JOptionPane.QUESTION_MESSAGE);
            System.out.println(host);
            DB = JOptionPane.showInputDialog(null, "Nombre Base de datos", "BD:", JOptionPane.QUESTION_MESSAGE);
            user = JOptionPane.showInputDialog(null, "Usuario de la base de datos", "User:", JOptionPane.QUESTION_MESSAGE);
            pass = JOptionPane.showInputDialog(null, "Contraseña de la base de datos", "Password:", JOptionPane.QUESTION_MESSAGE);

            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://" + host + "/" + DB + "", user, pass);

//            System.out.println("jdbc:mysql://'"+host+"'/'"+DB+"','root','mju7cde3'");
//            JOptionPane.showMessageDialog(null,"Conexion Exitosa");       
        } catch (Exception e) {

            System.out.print(e.getMessage());
//            JOptionPane.showMessageDialog(null,"Conexion Fallida");       

        }
        return conectar;

    }

}
