/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import Edificios.Edificios;
import Factory.AbstractFactory;
import Milicia.Milicia;
import Razas.Razas;

/**
 *
 * @author Erick Leones
 */
public class FactoryVehiculos implements AbstractFactory{

    @Override
    public Razas getRazas(String type) {
        return null;
    }

    @Override
    public Milicia getMilicia(String type) {
        return null;
    }

    @Override
    public Edificios getEdificios(String type) {
       return null;
    }

    @Override
    public Vehiculos getVehiculos(String type) {
        switch (type) {
            case "BMW Voladores":
                return new BMWVoladores();
            case "Caballos Alados":
                return new CaballosAlados();
            case "Caballos":
                return new CaballosM(); 
            case "Carrosas":
                return new Carrosa();
            case "Cuervos Demonio":
                return new CuervosD();
            case "Toro Demonio":
                return new TorosD(); 
        }
        return null;
    }
    
}
