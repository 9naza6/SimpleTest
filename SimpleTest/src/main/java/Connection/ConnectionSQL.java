/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nazareth
 */
public class ConnectionSQL {
    Connection cn = null;

    public Connection getConnection() {
        try {
            /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=Stock"; //Cadena de conexion con servidor y Nombre de la BD
            String usuarioDB = "usuario";//Usuario
            String passwordDB = "12345";//Contraseña
            cn = DriverManager.getConnection(url, usuarioDB, passwordDB);*/
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stock","root","");
            System.out.println("Connected");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror en" + e);
        }
        return cn;
    }

    public static void Exit(Connection conex) {
        try {
            conex.close();
        } catch (Exception e) {
            System.out.println("Error cerrando la conexion: " + e);
        }
    }
}
