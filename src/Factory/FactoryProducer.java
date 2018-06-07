/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Edificios.FactoryEdificios;
import Milicia.FactoryMilicia;
import Razas.FactoryRazas;
import Vehiculos.FactoryVehiculos;

/**
 *
 * @author Erick Leones
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String type){
        switch(type){
            case "Razas":
                return new FactoryRazas();
            case "Edificios":
                return new FactoryEdificios();
            case "Vehiculos":
                return new FactoryVehiculos();
            case "Milicia":
                return new FactoryMilicia();
        }
        return null;
    }
}
