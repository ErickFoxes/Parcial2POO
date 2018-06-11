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
public class DemonioMayor implements Milicia{
    int daño,vida,estado,atacando;
    String nombre="Demonio Mayor";
    @Override
    public void Crear(int daño, int vida, int estado, int atacando) {
        this.daño = daño;
        this.vida = vida;
        this.estado = estado;
        this.atacando = atacando;
    }
    public String toString() {
        String estadoE;
        if(estado!=0){
            estadoE="No disponible";
        }else{
            estadoE="Disponible";
        }
        return "Demonio mayor: Daño:"+daño+" vida: "+vida+" Estado:"+estadoE;
    }
     @Override
    public int mostrarDaño() {
        return daño;
    }

    @Override
    public int mostrarVida() {
        return vida;
    }

    @Override
    public int mostrarEstado() {
        return estado;
    }

    @Override
    public int mostrarAtacando() {
        return atacando;
    }

    @Override
    public void modificarDaño(int x) {
        this.daño = x;
    }

    @Override
    public void modificarVida(int x) {
        this.vida = x;
    }

    @Override
    public void modificarEstado(int x) {
        this.estado = x;
    }

    @Override
    public void modificarAtacando(int x) {
        this.atacando = x;
    }
    @Override
    public String mostrarNombre() {
        return nombre;
    }
}
