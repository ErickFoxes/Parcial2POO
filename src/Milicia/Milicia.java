/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milicia;

/**
 *
 * @author Erick Leones
 */
public interface Milicia {
    void Crear(int daño, int vida, int estado, int atacando);
    int mostrarDaño();
    int mostrarVida();
    int mostrarEstado();
    int mostrarAtacando();
    String mostrarNombre();
    void modificarDaño(int x);
    void modificarVida(int x);
    void modificarEstado(int x);
    void modificarAtacando(int x);
    
}
