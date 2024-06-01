/*Autora: Antonella Alares */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicioventavehiculos;

import java.sql.Timestamp;
import java.sql.*;
import java.sql.Date;/*se usa para manejar fechas y horas*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author anto_
 */
public class Vehiculos {
    private int id;
    private  String tipo;
    private String marca;
    private int potencia;
    private String fecha_compra;

    public Vehiculos(int id, String tipo, String marca, int potencia, String fecha_compra) {
        this.id = id; 
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fecha_compra = fecha_compra;
        VehiculosDAO.insertVehiculo(tipo, marca, potencia, fecha_compra);
    }
    
   
    
    public static void printAllVehiculosDetails() {
        VehiculosDAO.printVehiculosDetails();
    }
    
     public void printOneVehiculoDetails() {
        VehiculosDAO.printOneVehiculoDetails(this.id);
    }
    
    public void deleteVehiculoById (){
    
   VehiculosDAO.deleteVehiculoById(this.id);
    }
    
    public void calcularPotenciaMedia(){
    VehiculosDAO.printVehiculoPotenciaMedia(this.tipo);
    }
    
    public void calcularPotenciaMaxima(){
    VehiculosDAO.printVehiculoPotenciaMaxima(this.tipo);
    }
    
    //GETTERS
    

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public int getPotencia() {
       return potencia; 
    }

    public String getFecha_compra() {
        return fecha_compra;
    }
    
    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPotencia(int nuevaPotencia) {
        this.id = id;
        VehiculosDAO.updateVehiculoPotencia(nuevaPotencia, id);
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }
    
    
    
}
