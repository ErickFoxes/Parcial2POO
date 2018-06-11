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
public class ProductorMana  implements Edificios{
    private int madera,mana,pocimas,vida,maderaMax,manaMax,pocimasMax,estado=-2;
    String nombre="ProductorMana";
    @Override
    public void Crear(int madera, int mana, int pocimas,int vida) {
        this.madera = madera;
        this.mana = mana;
        this.pocimas = pocimas;
        this.vida = vida;
    }
    @Override
    public String toString() {
        String estadoE;
        if(estado!=0){
            estadoE="No disponible";
        }else{
            estadoE="Disponible";
        }
        return "Productor mana:\nRecursos: Mana: "+mana+" vida: "+vida+" Estado:"+estadoE;
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
