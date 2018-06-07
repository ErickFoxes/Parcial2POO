/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

import Factory.AbstractFactory;
import Milicia.Milicia;
import Razas.Razas;
import Vehiculos.Vehiculos;

/**
 *
 * @author Erick Leones
 */
public class FactoryEdificios implements AbstractFactory{

    @Override
    public Edificios getEdificios(String type) {
        switch (type) {
            case "Centro de Comando":
                return new CentroComando();
            case "Centro de Invocación de Angeles":
                return new CentroInvocacionA();
            case "Centro de Invocación de Demonios":
                return new CentroInvocacionD();
            case "Centro de Invocacion de Deidades":
                return new CentroInvocacionM();
            case "Centro Operativo":
                return new CentroOperativo();
            case "Centro Recolector":
                return new CentroRecolector();  
            case "Centro de Recolección de Sangre para Angeles":
                return new CentroSangreA();
            case "Centro de Recolección de Sangre para Demonios":
                return new CentroSangreD();
            case "Constructor de vehiculos para Demonios":
                return new ConstructorVehiculos();  
            case "Constructor de vehiculos para Angeles":
                return new ConstructorVehiculosA();
            case "Constructor de vehiculos para Deidades":
                return new ConstructorVehiculosM();
            case "Extractor de sueños":
                return new ExtractorSueños();  
            case "Mineria":
                return new Mineria();
            case "Mineria de oro":
                return new MineriaOro();
            case "Productor de mana":
                return new ProductorMana();  
            case "Productor de pocimas":
                return new ProductorPocimas();
            case "Rueda de Sacrificios":
                return new RuedaSacrificios();
            case "TorreAsociacion":
                return new TorreAsociacion();  
        }
        return null;
    }

    @Override
    public Milicia getMilicia(String type) {
        return null;
    }


    @Override
    public Vehiculos getVehiculos(String type) {
        return null;
    }

    @Override
    public Razas getRazas(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
