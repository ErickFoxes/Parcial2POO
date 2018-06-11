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
public class CentroOperativo  implements Edificios{
    private int sangreMax,sacrificiosMax,oroMax,vida,sangre=1000,sacrificios=600,oro=100,estado=0;
    String nombre="CentroOperativo";
    @Override
    public void Crear(int sangre, int sacrificios, int oro,int vida) {
         this.sangreMax = sangre;
        this.sacrificiosMax = sacrificios;
        this.oroMax = oro;
        this.vida = vida;
    }
    public String toString() {
        return "Centro Operativo:\nRecursos: Sangre: "+sangre+" Sacrificios: "+sacrificios+" Oro: "+oro+" vida: "+vida;
    }

    @Override
    public int MostrarRecurso1() {
        return sangre;
    }

    @Override
    public int MostrarRecurso2() {
        return sacrificios;
    }

    @Override
    public int MostrarRecurso3() {
        return oro;
    }

    @Override
    public int MostrarMaxRecurso1() {
        return sangreMax;
    }

    @Override
    public int MostrarMaxRecurso2() {
        return sacrificiosMax;
    }

    @Override
    public int MostrarMaxRecurso3() {
        return oroMax;
    }
    @Override
    public void modificarRecursos(int x, int y, int z,int vida) {
        this.sangre = x;
        this.sacrificios = y;
        this.oro = z;
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
