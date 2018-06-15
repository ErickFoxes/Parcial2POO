/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import Factory.AbstractFactory;
import Factory.FactoryProducer;
import java.util.ArrayList;

/**
 *
 * @author Erick <00092217@uca.edu.sv>
 */
public class ListaVehiculos {
    public ArrayList <Vehiculos> vehiculos;
    String respuesta;
    public ListaVehiculos(){
        vehiculos = new ArrayList<>();
    }
    public ArrayList RegresarLista(){
        return vehiculos;
    }
    public void AgregarBMW(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Vehiculos");
        Vehiculos mili = factory.getVehiculos("BMW Voladores");
        
        vehiculos.add(mili);
        mili.Crear(70, 600, -3, 0);
    }
    public void AgregarCaballosA(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Vehiculos");
        Vehiculos mili = factory.getVehiculos("Caballos Alados");
        
        vehiculos.add(mili);
        mili.Crear(400, 300, -3, 0);
    }
    public void AgregarCaballos(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Vehiculos");
        Vehiculos mili = factory.getVehiculos("Caballos");
        
        vehiculos.add(mili);
        mili.Crear(60, 300, -3, 0);
    }
    public void AgregarCarrosas(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Vehiculos");
        Vehiculos mili = factory.getVehiculos("Carrosas");
        
        vehiculos.add(mili);
        mili.Crear(130, 700, -3, 0);
    }
    public void AgregarCuervos(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Vehiculos");
        Vehiculos mili = factory.getVehiculos("Cuervos Demonio");
        
        vehiculos.add(mili);
        mili.Crear(100, 500, -3, 0);
    }
    public void AgregarToro(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Vehiculos");
        Vehiculos mili = factory.getVehiculos("Toro Demonio");
        
        vehiculos.add(mili);
        mili.Crear(150, 700, -3, 0);
    }
    public void MostrarVehiculos(){      
        vehiculos.forEach((mili) -> {
            System.out.println(mili.toString());
        });
    }
    public void VerEstado(String vehiculo){      
        int i =0, itemCount = vehiculos.size();
        while(i<itemCount){
            if(vehiculos.get(i).mostrarNombre()==vehiculo){
                if(vehiculos.get(i).mostrarEstado()<0){
                    vehiculos.get(i).modificarEstado(vehiculos.get(i).mostrarEstado()+1);
                }
            }
            i++;
        }
    }
    public boolean verificarVehiculoLista(String vehiculo){
         int i =0, itemCount = vehiculos.size();
         boolean t=false;
        while(i<itemCount){
            if(vehiculos.get(i).mostrarNombre()==vehiculo){
                if(vehiculos.get(i).mostrarEstado()==0){
                    t=true;
                }
                
            }
            i++;
        }
        return t;
    }
    public int contarVehiculos(){
        int itemCount = vehiculos.size();
        return itemCount;
    }
    public void MostrarVehiculos2(){      
        int i =0, itemCount = vehiculos.size(),o=0;
        while(i<itemCount){
            String estadoOcupado="No";
            if(vehiculos.get(i).mostrarAtacando()==1){
                estadoOcupado="Si";
            }
            System.out.println((i+1)+"-"+vehiculos.get(i).mostrarNombre()+" Ocupado: "+estadoOcupado);
            i++;
        }
    }
    public void VehiculoAtacar(int x,int y){      
        vehiculos.get(x-1).modificarAtacando(1);
        vehiculos.get(x-1).modificarEdificioAtacando(y-1);
    }
    public void VehiculoNOAtacar(int x){      
        vehiculos.get(x).modificarAtacando(0);
    }
    
    public int RegresarDaño(int x){
        return vehiculos.get(x).mostrarDaño();
    }
    public int VerificarAtacando(int x){ 
        return vehiculos.get(x).mostrarAtacando();
        
    }
    public int VerificarQuienAtacando(int x){ 
        return vehiculos.get(x).mostrarEdificioAtacando();
    }
}
