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
    private int madera,mana,pocimas,vida;
    @Override
    public void Crear(int madera, int mana, int pocimas,int vida) {
        this.madera = madera;
        this.mana = mana;
        this.pocimas = pocimas;
        this.vida = vida;
    }
    @Override
    public String toString() {
        return "Productor mana:\nRecursos: Mana: "+mana+" vida: "+vida;
    }
    public int getMadera() {
        return madera;
    }

    public void setMadera(int madera) {
        this.madera = madera;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPocimas() {
        return pocimas;
    }

    public void setPocimas(int pocimas) {
        this.pocimas = pocimas;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
