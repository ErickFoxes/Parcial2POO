/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

/**
 *
 * @author Erick Leones
 */
public class ConstructorVehiculos  implements Edificios{
    private int sangre,sueños,madera,vida,sangreMax,sueñosMax,maderaMax,estado=-5;
    String nombre="ConstructorVehiculos";
    @Override
    public void Crear(int sangre, int sueños, int madera,int vida) {
         this.sangre = madera;
        this.sueños = sueños;
        this.madera = madera;
        this.vida = vida;
    }
    public String toString() {
        String estadoE;
        if(estado!=0){
            estadoE="No disponible";
        }else{
            estadoE="Disponible";
        }
        return "Constructor de vehiculos:\nRecursos: vida: "+vida+" Estado:"+estadoE;
    }
     @Override
    public int MostrarRecurso1() {
       return sangre;
    }

    @Override
    public int MostrarRecurso2() {
        return sueños;
    }

    @Override
    public int MostrarRecurso3() {
        return madera;
    }

    @Override
    public int MostrarMaxRecurso1() {
        return sangreMax;
    }

    @Override
    public int MostrarMaxRecurso2() {
        return sueñosMax;
    }

    @Override
    public int MostrarMaxRecurso3() {
        return maderaMax;
    }
     @Override
    public void modificarRecursos(int x, int y, int z,int vida) {
        this.sangre = x;
        this.sueños = y;
        this.madera = z;
        this.vida = vida;
    }
    @Override
    public int MostrarVida() {
       return vida; 
    }
    @Override
    public String MostrarNombre() {
        return nombre;
    }
    @Override
    public int MostrarEstado() {
        return estado;
    }

    @Override
    public void modificarEstado(int x) {
        this.estado=x;
    }
}
