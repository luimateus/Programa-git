/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploconexionjdbc;

/**
 *
 * @author moneca
 */
//importamos las librerias necesarias

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario ="root";
        String password = "";
        String url ="jdbc:mysql://localhost:3308/prueba";
        Connection conexion;
        Statement statement;
        ResultSet rs;
    
        
// Cargar el controlador   
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            
            //statement.executeUpdate("INSERT INTO USUARIO(IDUSUARIO, NOMBRE, APELLIDO, CORREO) VALUES ('10221170', 'Francisco', 'Hernandez', 'fahe@gmail.com')");
            
            //statement.executeUpdate("UPDATE USUARIO SET NOMBRE = 'Vicente' WHERE NOMBRE = 'Nelson'");
            
            //statement.executeUpdate("DELETE FROM USUARIO WHERE IDUSUARIO = '1021451'");
            
            rs = statement.executeQuery("SELECT *FROM  USUARIO");
            rs.next();
            do {                
                System.out.println(rs.getString("idusuario")+" : "+rs.getString("nombre")+" : "+rs.getString("apellido")+": "+rs.getString("correo"));
                
                
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
