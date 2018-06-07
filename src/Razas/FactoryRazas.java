/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Razas;

import Edificios.Edificios;
import Factory.AbstractFactory;
import Milicia.Milicia;
import Vehiculos.Vehiculos;

/**
 *
 * @author Erick Leones
 */
public class FactoryRazas implements AbstractFactory{

    @Override
    public Razas getRazas(String type) {
        switch (type) {
            case "Angeles":
                return new Angeles();
            case "Deidades":
                return new Deidades();
            case "Demonios":
                return new Demonios();     
        }
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
         return null;
    }
    
}
