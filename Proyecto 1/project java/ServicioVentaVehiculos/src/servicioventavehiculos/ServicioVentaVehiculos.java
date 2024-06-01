/*Autora: Antonella Alares */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servicioventavehiculos;

import java.sql.*;
import java.sql.Date;/*se usa para manejar fechas y horas*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author anto_
 */
public class ServicioVentaVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        //Para crear un nuevo vehiculo
        System.out.println("Este es el mensaje que aparece cada vez que se crea un vehículo:");
            /*Vehiculo insertado- están comentadas para que no se generen de nuevo cada vez que runneemos y/o den error*/
            Vehiculos vehiculo1= new Vehiculos(1, "Camión", "Volvo", 400, "2023-04-03");
            //Vehiculos vehiculo2 = new Vehiculos(2, "Moto", "Yamaha", 80, "2024-01-15");
            //Vehiculos vehiculo3 = new Vehiculos(3, "Camión", "Volvo5", 500, "2023-05-13");
            //Vehiculos vehiculo4= new Vehiculos(4, "Camión", "Volvo", 450, "2023-05-20");
            //Vehiculos vehiculo5 = new Vehiculos(5, "Moto", "Yamaha", 90, "2024-01-05");
            Vehiculos vehiculo6 = new Vehiculos(6,"Barco", "Yamaha", 350, "2021-08-12");
            Vehiculos vehiculo7 = new Vehiculos(7, "Bicicleta", "Giant", 5, "2020-07-22");
        
        
        //Para eliminar un vehiculo por su id (en este caso el que hemos creado arriba con id = 5):
        System.out.println("Este es el mensaje que aparece cuando se elimina un vehiculo: ");
        vehiculo7.deleteVehiculoById();
       
        
        //Para consultar los detalles vehiculos:
        System.out.println("Detalle de todos los vehículos: ");
        Vehiculos.printAllVehiculosDetails();
        
        //Para consultar los detalles un vehiculo por su id:
        System.out.println("Detalle de un vehículo por su id: ");
        vehiculo6.printOneVehiculoDetails();
        
        //Para actualizar un dato de un vehiculo:
        System.out.println("Para actualizar la potencia de un vehículo: ");
        vehiculo6.setPotencia(200);
        
        //Para ver la potencia media según el tipo de vehículo:
        System.out.println("Para poder calcular la potencia media de un vehículo de un determinado tipo: ");
        vehiculo1.calcularPotenciaMedia();
        
        //Para ver la potencia maxima según el tipo de vehículo:
        System.out.println("Para poder calcular la potencia maxima de un vehículo de un determinado tipo: ");
        vehiculo1.calcularPotenciaMaxima();
        
        
    }
    
}
