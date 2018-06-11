/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

/**
 *
 * @author UCA
 */
public interface Edificios {
    void Crear(int madera, int mana, int pocimas,int vida);
    int MostrarRecurso1();
    int MostrarRecurso2();
    int MostrarRecurso3();
    int MostrarVida();
    int MostrarEstado();
    int MostrarMaxRecurso1();
    int MostrarMaxRecurso2();
    int MostrarMaxRecurso3();
    String MostrarNombre();
    void modificarEstado(int x);
    void modificarRecursos(int x,int y,int z,int vida);
    
}
