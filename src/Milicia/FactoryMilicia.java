/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milicia;

import Edificios.Edificios;
import Factory.AbstractFactory;
import Razas.Razas;
import Vehiculos.Vehiculos;

/**
 *
 * @author Erick Leones
 */
public class FactoryMilicia implements AbstractFactory{

    @Override
    public Razas getRazas(String type) {
         return null;
    }

    @Override
    public Milicia getMilicia(String type) {
         switch (type) {
            case "Arcangeles":
                return new Arcangeles();
            case "Arqueros":
                return new Arqueros();
            case "Cerberos":
                return new Cerberos();
            case "Demonio Mayor":
                return new DemonioMayor();
            case "Demonio Menor":
                return new DemonioMenor();
            case "Espadachines":
                return new Espadachines();
            case "Deidades clase A":
                return new MClaseA();
            case "Deidades clase C":
                return new MClaseC();
            case "Deidades clase S":
                return new MClaseS();
            
        }
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
