/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milicia;

import Factory.AbstractFactory;
import Factory.FactoryProducer;
import java.util.ArrayList;

/**
 *
 * @author Erick <00092217@uca.edu.sv>
 */
public class ListaMilicia {
    public ArrayList <Milicia> milicia;
    String respuesta;
    
    public ListaMilicia(){
        milicia = new ArrayList<>();
    }
    /*Milicia Angeles*/
    public void AgregarArqueros(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Milicia");
        Milicia mili = factory.getMilicia("Arqueros");
        
        milicia.add(mili);
        mili.Crear(70, 120, -2, 0);
        
    }
    public void AgregarArcangeles(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Milicia");
        Milicia mili = factory.getMilicia("Arcangeles");
        
        milicia.add(mili);
        mili.Crear(425, 400, -4, 0);
        
    }
    /*Milicia Deidades*/
    public void AgregarClaseA(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Milicia");
        Milicia mili = factory.getMilicia("Deidades clase A");
        
        milicia.add(mili);
        mili.Crear(50, 100, -2, 0);
    }
    public void AgregarClaseS(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Milicia");
        Milicia mili = factory.getMilicia("Deidades clase S");
        
        milicia.add(mili);
        mili.Crear(300, 400, -4, 0);
    }
    /*Milicia Demonios*/
    public void AgregarDemonioMenor(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Milicia");
        Milicia mili = factory.getMilicia("Demonio Menor");
        
        milicia.add(mili);
        mili.Crear(45, 90, -2, 0);
    }
    public void AgregarDemonioMayor(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Milicia");
        Milicia mili = factory.getMilicia("Demonio Mayor");
        
        milicia.add(mili);
        mili.Crear(200, 450, -4, 0);
    }
    
    public void MostrarMilicia(){      
        milicia.forEach((mili) -> {
            System.out.println(mili.toString());
        });
    }
    public void VerEstado(String soldado){      
        int i =0, itemCount = milicia.size();
        while(i<itemCount){
            if(milicia.get(i).mostrarNombre()==soldado){
                if(milicia.get(i).mostrarEstado()<0){
                    milicia.get(i).modificarEstado(milicia.get(i).mostrarEstado()+1);
                }
            }
            i++;
        }
    }
    public boolean verificarSoldadoLista(String soldado){
         int i =0, itemCount = milicia.size();
         boolean t=false;
        while(i<itemCount){
            if(milicia.get(i).mostrarNombre()==soldado){
                if(milicia.get(i).mostrarEstado()==0){
                    t=true;
                }
                
            }
            i++;
        }
        return t;
    }
    public int contarMilicia(){
        int itemCount = milicia.size();
        return itemCount;
    }
}
