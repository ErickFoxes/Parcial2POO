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
public class TorreAsociacion  implements Edificios{
    private int maderaMax,manaMax,pocimasMax,vida,madera=1000,mana=600,pocimas=100,estado=1;
    String nombre="TorreAsociacion";
    @Override
    public void Crear(int madera, int mana, int pocimas,int vida) {
        this.maderaMax = madera;
        this.manaMax = mana;
        this.pocimasMax = pocimas;
        this.vida = vida;
    }
    @Override
    public String toString() {
        return "Torre Asociacion:\nRecursos: Piedra: "+madera+" Mana: "+mana+" Pocimas: "+pocimas+" vida: "+vida;
    }

    @Override
    public int MostrarRecurso1() {
        return madera;
    }

    @Override
    public int MostrarRecurso2() {
        return mana;
    }

    @Override
    public int MostrarRecurso3() {
        return pocimas;
    }

    @Override
    public int MostrarMaxRecurso1() {
        return maderaMax;
    }

    @Override
    public int MostrarMaxRecurso2() {
        return manaMax;
    }

    @Override
    public int MostrarMaxRecurso3() {
        return pocimasMax;
    }

    @Override
    public void modificarRecursos(int x, int y, int z, int vida) {
        this.madera = x;
        this.mana = y;
        this.pocimas = z;
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
