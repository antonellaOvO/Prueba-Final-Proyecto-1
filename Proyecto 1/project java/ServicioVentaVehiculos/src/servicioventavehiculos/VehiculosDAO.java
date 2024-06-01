/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicioventavehiculos;

import java.sql.*;
import java.sql.Date;/*se usa para manejar fechas y horas*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author anto_
 */
public class VehiculosDAO {
    
    public static void printVehiculosDetails() {
   String query = "SELECT * FROM Vehiculos;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id");
       String tipo = rs.getString("tipo");
       String marca = rs.getString("marca");
       double potencia = rs.getInt("potencia");
       Date fechaCompra = rs.getDate("fecha_compra");
       
       
       System.out.println("ID vehiculo: " + id + ", Tipos vehiculos: " + tipo + ", Marca vehiculo: " + marca + ", Potencia vehiculo: " + potencia + ", Fecha Compra del vehiculo: " + fechaCompra);
       
       }  } catch(SQLException e){
       e.printStackTrace();
    }        
   
   }
    
   public static void printOneVehiculoDetails(int id){
        String query = "SELECT * FROM Vehiculos WHERE id = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id);// El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                int potencia = rs.getInt("potencia");
                Date fechaCompra = rs.getDate("fecha_compra");
                System.out.println("ID vehiculo: " + id + ", Tipos vehiculos: " + tipo + ", Marca vehiculo: " + marca + ", Potencia vehiculo: " + potencia + ", Fecha Compra del vehiculo: " + fechaCompra);
            }
            
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el printOneVehiculoDetails.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    

    
    
    public static void insertVehiculo(String tipo, String marca, int potencia, String fechaCompra){
    String query = "INSERT INTO Vehiculos (tipo, marca, potencia, fecha_compra) VALUES (?, ?, ?, ?);";
    try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

         Date sqlDate = Date.valueOf(fechaCompra);

        pstmt.setString(1,tipo); /*1 de campo 1 de la query*/
        pstmt.setString(2, marca); /*2 de campo 2 de la query*/
        pstmt.setInt(3, potencia); /*3 de campo 3 de la query*/
        pstmt.setString(4, fechaCompra);

        pstmt. executeUpdate();
        System.out.println("Nuevo vehiculo insertado ");

    }catch(SQLException e){
         e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
      }  
        
    }
    
    public static void deleteVehiculoById(int id) {
    String query = "DELETE FROM Vehiculos WHERE id=?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        System.out.println("El vehiculo con id: " + id + " ha sido eliminado. ");
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
    
    public static void updateVehiculoPotencia(int nuevaPotencia, int id){
     String query = "UPDATE Vehiculos SET potencia = ? WHERE id = ?;";
     try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
         pstmt.setInt(1,nuevaPotencia);
         pstmt.setInt(2, id);
      
         pstmt.executeUpdate();
         System.out.println("Nueva potencia: " + nuevaPotencia);
     
     }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    } 
     
 }
    
    public static double printVehiculoPotenciaMedia(String tipo) {
    double potenciaMedia = 0.0;
    String query = "SELECT AVG(potencia) AS potencia_media FROM Vehiculos WHERE tipo = ?;";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, tipo);

        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            potenciaMedia = rs.getDouble("potencia_media");
            System.out.println("La potencia media de este vehículo con tipo " + tipo + " es la siguiente: " + potenciaMedia);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return potenciaMedia;
}
    
public static double printVehiculoPotenciaMaxima(String tipo) {
    double potenciaMaxima = 0.0;
    String query = "SELECT MAX(potencia) AS potencia_maxima FROM Vehiculos WHERE tipo = ?;";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, tipo);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            potenciaMaxima = rs.getDouble("potencia_maxima");
            System.out.println("La potencia máxima de los vehículos con tipo " + tipo + " es la siguiente: " + potenciaMaxima);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return potenciaMaxima;
}


 
    
}
