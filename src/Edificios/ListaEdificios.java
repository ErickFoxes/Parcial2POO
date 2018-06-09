/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

import Factory.AbstractFactory;
import Factory.FactoryProducer;
import java.util.ArrayList;

/**
 *
 * @author Erick <00092217@uca.edu.sv>
 */
public class ListaEdificios {
    public ArrayList <Edificios> edificios;
    String respuesta;
    public ListaEdificios(){
        edificios = new ArrayList<>();
    }
    public void AgregarTorreQuemado(){
        TorreAsociacion torreAsociacion= new TorreAsociacion();
        edificios.add(torreAsociacion);
        torreAsociacion.setMadera(10000);
        torreAsociacion.setMana(5000);
        torreAsociacion.setPocimas(3000);
        torreAsociacion.setVida(8000);
    }
    public void AgregarTorre(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios edificio = factory.getEdificios("Torre Asociacion");
        edificios.add(edificio); 
        edificio.Crear(10000, 5000, 3000, 8000);
    }
    public void AgregarTorre(Edificios edifici) throws Exception{
        if(edificios != null){
            if(!edificios.contains(edifici)){
                edificios.add(edifici);
            }else{
                Exception e = new Exception("Los datos ya pertenecen a otro paquete");
                throw e;
            }
            
        }else{
            throw new Exception("El paquete no puede quedar vacío");
        }
    }
    public void AgregarProductorMana(){
        ProductorMana productorMana= new ProductorMana();
        edificios.add(productorMana);
        productorMana.setMadera(0);
        productorMana.setMana(0);
        productorMana.setPocimas(0);
        productorMana.setVida(1000);
    }
    
    
    public void MostrarEdificio(){
               
        edificios.forEach((torreAsociacion) -> {
            System.out.println(torreAsociacion.toString());
        });
    }
}
