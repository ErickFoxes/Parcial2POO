/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Razas;

import Factory.AbstractFactory;
import Factory.FactoryProducer;
import java.util.ArrayList;

/**
 *
 * @author Erick <00092217@uca.edu.sv>
 */
public class ListaRazas {
    public ArrayList <Razas> razas;
    String respuesta;
    public ListaRazas(){
        razas = new ArrayList<>();
               
    }

    
     public void AgregarRaza(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Razas");
        Razas angele = factory.getRazas("Angeles");
        
        razas.add(angele);     
    }
     
     public void AgregarRaza(Razas angele) throws Exception{
        if(angele != null){
            if(!razas.contains(angele)){
                razas.add(angele);
            }else{
                Exception e = new Exception("Los datos ya pertenecen a otro paquete");
                throw e;
            }
            
        }else{
            throw new Exception("El paquete no puede quedar vacío");
        }
    }
     public void MostrarPaquete(){
               
        razas.forEach((angele) -> {
            System.out.println(angele.toString());
        });
    }
}
