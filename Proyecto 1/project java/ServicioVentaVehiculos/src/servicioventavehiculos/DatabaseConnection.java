/*Autora: Antonella Alares*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicioventavehiculos;

import java.sql.*;

/**
 *
 * @author anto_
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/vehiculos"; /*ejemplo_conexion - es lo que se debiera cambiar para hacer la conexi�n a otra BBDD*/
    private static final String USER = "root";
    private static final String PASSWORD = "Conexionlocal1";
    
    public static Connection getConnection()throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
    }  
}
