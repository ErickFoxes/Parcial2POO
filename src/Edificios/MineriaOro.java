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
public class MineriaOro  implements Edificios{
    private int sangre,sacrificios,oro,vida,sangreMax,sacrificiosMax,oroMax,estado=-2;
    String nombre="MineriaOro";
    @Override
    public void Crear(int sangre, int sacrificios, int oro,int vida) {
         this.sangre = sangre;
        this.sacrificios = sacrificios;
        this.oro = oro;
        this.vida = vida;
    }
        public String toString() {
        return "Mineria de oro:\nRecursos: Oro: "+oro+" vida: "+vida;
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
