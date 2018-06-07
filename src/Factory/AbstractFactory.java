/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Edificios.Edificios;
import Milicia.Milicia;
import Razas.Razas;
import Vehiculos.Vehiculos;

/**
 *
 * @author Erick Leones
 */
public interface AbstractFactory {
    Razas getRazas(String type);
    Milicia getMilicia(String type);
    Edificios getEdificios(String type);
    Vehiculos getVehiculos(String type);
}
