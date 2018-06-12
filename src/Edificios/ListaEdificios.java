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
    
    /*Edificios de Deidades*/
    public void AgregarTorreQuemado(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios torre = factory.getEdificios("Torre Asociacion");
        
        edificios.add(torre);
        torre.Crear(10000, 5000, 3000, 8000);
    }
    public void AgregarProductorMana(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios productorMana = factory.getEdificios("Productor de mana");
        
        edificios.add(productorMana);
        productorMana.Crear(0, 0, 0, 1000);
    }
    public void AgregarProductorPocimas(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios productorPocimas = factory.getEdificios("Productor de pocimas");
        
        edificios.add(productorPocimas);
        productorPocimas.Crear(0, 0, 0, 1000);
    }
    public void AgregarMineria(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios mineria = factory.getEdificios("Mineria");
        
        edificios.add(mineria);
        mineria.Crear(0, 0, 0, 1000);
    }
    public void AgregarCentroInvocacionM(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios centroInvocacionM = factory.getEdificios("Centro de Invocacion de Deidades");
        
        edificios.add(centroInvocacionM);
        centroInvocacionM.Crear(0, 0, 0, 1000);
    }
    public void AgregarVehiculosM(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios vehiculos = factory.getEdificios("Constructor de vehiculos para Deidades");
        
        edificios.add(vehiculos);
        vehiculos.Crear(0, 0, 0, 1000);
    }
    /*Edificios de Angeles*/
    public void AgregarCentroOperativo(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios centroOperativo = factory.getEdificios("Centro Operativo");
        edificios.add(centroOperativo);
        centroOperativo.Crear(10000, 5000, 3000, 8000);
    }
    public void AgregarCentroSangreA(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios centroOperativo = factory.getEdificios("Centro de Recolección de Sangre para Angeles");
        edificios.add(centroOperativo);
        centroOperativo.Crear(0, 0, 0, 1000);
    }
    public void AgregarRuedaSacrificios(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios ruedaS = factory.getEdificios("Rueda de Sacrificios");
        edificios.add(ruedaS);
        ruedaS.Crear(0, 0, 0, 1000);
    }
    public void AgregarMineriaOro(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios mineriaOro = factory.getEdificios("Mineria de oro");
        edificios.add(mineriaOro);
        mineriaOro.Crear(0, 0, 0, 1000);
    }
    public void AgregarCentroInvocadorA(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios centroInvocadorA = factory.getEdificios("Centro de Invocación de Angeles");
        edificios.add(centroInvocadorA);
        centroInvocadorA.Crear(0, 0, 0, 1000);
    }
    public void AgregarConstructorVehiculosA(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios vehiculosA = factory.getEdificios("Constructor de vehiculos para Angeles");
        edificios.add(vehiculosA);
        vehiculosA.Crear(0, 0, 0, 1000);
    }
    /*Edificios de Demonios*/
    public void AgregarCentroComando(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios centroComando = factory.getEdificios("Centro de Comando");
        edificios.add(centroComando);
        centroComando.Crear(10000, 5000, 3000, 8000);
    }
    public void AgregarDonadorSangreD(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios centroSangreD = factory.getEdificios("Centro de Recolección de Sangre para Demonios");
        edificios.add(centroSangreD);
        centroSangreD.Crear(0, 0, 0, 1000);
    }
    public void AgregarExtractorSueños(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios extractorSueños = factory.getEdificios("Extractor de sueños");
        edificios.add(extractorSueños);
        extractorSueños.Crear(0, 0, 0, 1000);
    }
    public void AgregarCentroRecolector(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios recolector = factory.getEdificios("Centro Recolector");
        edificios.add(recolector);
        recolector.Crear(0, 0, 0, 1000);
    }
    public void AgregarCentroInvocadorD(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios centroInvocadorD = factory.getEdificios("Centro de Invocación de Demonios");
        edificios.add(centroInvocadorD);
        centroInvocadorD.Crear(0, 0, 0, 1000);
    }
    public void AgregarConstructorVehiculosD(){
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Edificios");
        Edificios vehiculos = factory.getEdificios("Constructor de vehiculos para Demonios");
        edificios.add(vehiculos);
        vehiculos.Crear(0, 0, 0, 1000);
    }
    
    
    public void MostrarEdificio(){      
        edificios.forEach((torreAsociacion) -> {
            System.out.println(torreAsociacion.toString());
        });
    }
    public void AumentarEdificioRecurso(String edificio,int Re1,int Re2,int Re3,int V1,int Rc,int Recurso){      
        int i =0,o=0,j=0;
        int R1,R2,R3,V;
        int itemCount = edificios.size();

            if(Recurso==1){
                while(i<itemCount){
                    if(edificios.get(i).MostrarNombre()==edificio){
                        if(edificios.get(i).MostrarEstado()==0){
                            o++;
                        }else{
                            edificios.get(i).modificarEstado(edificios.get(i).MostrarEstado()+1);
                        }
                    }
                    i++;
                }
                if(edificios.get(0).MostrarRecurso1()<edificios.get(0).MostrarMaxRecurso1()){
                    edificios.get(0).modificarRecursos(Re1+(Rc*o), Re2, Re3, V1);
                    if(edificios.get(0).MostrarRecurso1()>edificios.get(0).MostrarMaxRecurso1()){
                        edificios.get(0).modificarRecursos(edificios.get(0).MostrarMaxRecurso1(), Re2, Re3, V1);
                    }
                }
                
            }else if(Recurso==2){
                while(i<itemCount){
                    if(edificios.get(i).MostrarNombre()==edificio){
                        if(edificios.get(i).MostrarEstado()==0){
                            o++;
                        }else{
                            edificios.get(i).modificarEstado(edificios.get(i).MostrarEstado()+1);
                        }
                    }
                    i++;
                } 
                if(edificios.get(0).MostrarRecurso2()<edificios.get(0).MostrarMaxRecurso2()){
                    edificios.get(0).modificarRecursos(Re1, Re2+(Rc*o), Re3, V1);
                    if(edificios.get(0).MostrarRecurso2()>edificios.get(0).MostrarMaxRecurso2()){
                        edificios.get(0).modificarRecursos(Re1, edificios.get(0).MostrarMaxRecurso2(), Re3, V1);
                    }
                }
            }else if(Recurso==3){
                while(i<itemCount){
                    if(edificios.get(i).MostrarNombre()==edificio){
                        if(edificios.get(i).MostrarEstado()==0){
                            o++;
                        }else{
                            edificios.get(i).modificarEstado(edificios.get(i).MostrarEstado()+1);
                        }
                    }
                    i++;
                }
                if(edificios.get(0).MostrarRecurso3()<edificios.get(0).MostrarMaxRecurso3()){
                    edificios.get(0).modificarRecursos(Re1, Re2, Re3+(Rc*o), V1);
                    if(edificios.get(0).MostrarRecurso3()>edificios.get(0).MostrarMaxRecurso3()){
                        edificios.get(0).modificarRecursos(Re1,Re2 ,edificios.get(0).MostrarMaxRecurso3(), V1);
                    }
                }
            }
   
    }
    public Edificios VerRecursos(){      
        return edificios.get(0);
    }
    public void VerEstado(String edificio){      
        int i =0, itemCount = edificios.size();
        while(i<itemCount){
            if(edificios.get(i).MostrarNombre()==edificio){
                if(edificios.get(i).MostrarEstado()<0){
                    edificios.get(i).modificarEstado(edificios.get(i).MostrarEstado()+1);
                }
            }
            i++;
        }
    }
    public int VerEstadoEdificio(String edificio){      
        int i =0, itemCount = edificios.size(),estado=1;
        while(i<itemCount){
            if(edificios.get(i).MostrarNombre()==edificio){
                estado = edificios.get(i).MostrarEstado();
            }
            i++;
        }
        return estado;
    }
    public void ModificarEstadoEdificio(String edificio){      
        int i =0, itemCount = edificios.size();
        while(i<itemCount){
            if(edificios.get(i).MostrarNombre()==edificio){
                edificios.get(i).modificarEstado(edificios.get(i).MostrarEstado()+1);
            }
            i++;
        }
    }
    public boolean verificarEdificioLista(String edificio){
         int i =0, itemCount = edificios.size();
         boolean t=false;
        while(i<itemCount){
            if(edificios.get(i).MostrarNombre()==edificio){
                if(edificios.get(i).MostrarEstado()==0){
                    t=true;
                }
                
            }
            i++;
        }
        return t;
    }
    public int contarEdificio(String edificio){
        int i =0, itemCount = edificios.size(),o=0;
        while(i<itemCount){
            if(edificios.get(i).MostrarNombre()==edificio){
                o++;
            }
            i++;
        }
        return o;
    }
    public int contarEdificios(){
        int  itemCount = edificios.size();
        return itemCount;
    }
    public void MostrarEdificio2(){      

        int i =0, itemCount = edificios.size(),o=0;
        while(i<itemCount){
            System.out.println((i+1)+"-"+edificios.get(i).MostrarNombre());
            i++;
        }
    }
}
