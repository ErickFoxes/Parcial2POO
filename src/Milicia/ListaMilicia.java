/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milicia;

import Edificios.ListaEdificios;
import Factory.AbstractFactory;
import Factory.FactoryProducer;
import java.util.ArrayList;
import juego.Menu;

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
    public ArrayList RegresarLista(){
        return milicia;
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
    public void MostrarMilicia2(){      
        int i =0, itemCount = milicia.size(),o=0;
        while(i<itemCount){
            System.out.println((i+1)+"-"+milicia.get(i).mostrarNombre());
            i++;
        }
    }
    public void SoldadoAtacar(int x,int y){      
        milicia.get(x-1).modificarAtacando(1);
        milicia.get(x-1).modificarEdificioAtacando(y-1);
    }
    
    public int RegresarDaño(int x){
        return milicia.get(x).mostrarDaño();
    }
    public int VerificarAtacando(int x){ 
        return milicia.get(x).mostrarAtacando();
        
    }
    public int VerificarQuienAtacando(int x){ 
        return milicia.get(x).mostrarEdificioAtacando();
    }
//    public void VerificarAtacando2(){ 
//        Menu menu = new Menu();
//        int i =0, itemCount = milicia.size();
//        while(i<itemCount){
//            if(milicia.get(i).mostrarAtacando()!=0){
//                int o=0;
//                while(o!=milicia.get(i).mostrarEdificioAtacando()){
//                    o++;
//                }
//                int vidaEdificio = menu.RegresarVidaEdificio(o);
//                vidaEdificio = vidaEdificio-milicia.get(i).mostrarDaño();
//                menu.ModificarVidaEdificio(o,vidaEdificio);
//            }
//            
//            i++;
//        }
//    }
    
}
