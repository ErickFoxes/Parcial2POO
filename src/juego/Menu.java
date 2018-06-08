/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import Factory.AbstractFactory;
import Factory.FactoryProducer;
import Razas.Razas;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Erick <00092217@uca.edu.sv>
 */
public class Menu {
    private static Menu menu;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        
        return menu;
    }
    
    public void menu() {
        int x = 1,y=0;
        Scanner M = new Scanner(System.in);
        Fases fase = new Fases();

            mensajeDeInicio();
            mensajeDeInicio2();
            
             while(y==0){
                fase.setFases(x);
                fase(fase.getFases());
                x++;
                escoger();
            }
            
            
    }
    
    public void mensajeDeInicio(){
        
        int opcionInvocacion = 0;
        String opcionElegidaInvocacion;
        boolean b = true;
        Scanner M = new Scanner(System.in);
        System.out.println("Juego de 3 aldeas que quieren conquistarse unas a otras, para hacerlo necesitarán ayuda.");
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Razas");
        
            System.out.println("Jugador 1 Elija su tipo de invocación:\n1-Angeles\n2-Deidades\n3-Demonios");
            while(b){
                try {
                    opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            opcionElegidaInvocacion = "Angeles";
                            System.out.println("Jugador 1 haz elegido invocar Angeles para ayudar a tu aldea");
                            Razas angeles = factory.getRazas("Angeles");
                            angeles.Crear();
                            b=false;
                            break;
                        case 2:
                            opcionElegidaInvocacion = "Deidades";
                            System.out.println("Jugador 1 haz elegido invocar Deidades para ayudar a tu aldea");
                            Razas deidades = factory.getRazas("Deidades");
                            deidades.Crear();
                            b=false;
                            break;
                        case 3:
                            opcionElegidaInvocacion = "Demonios";
                            System.out.println("Jugador 1 haz elegido invocar Demonios para ayudar a tu aldea");
                            Razas demonios = factory.getRazas("Demonios");
                            demonios.Crear();
                            b=false;
                            break;
                        
                        default:
                            System.out.println("Por favor ingresa un valor valido");      
                    }
                } catch (InputMismatchException E){
                    System.err.println("Debes ingresar un # entero");
                    M.nextLine();
                }
            } 
            
        }
    public void mensajeDeInicio2(){
        int opcionInvocacion = 0;
        String opcionElegidaInvocacion;
        boolean b = true;
        AbstractFactory factory;
        factory =  FactoryProducer.getFactory("Razas");
        Scanner M = new Scanner(System.in);
                   System.out.println("Jugador 2 Elija su tipo de invocación:\n1-Angeles\n2-Deidades\n3-Demonios");
            while(b){
                try {
                    opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            opcionElegidaInvocacion = "Angeles";
                            System.out.println("Jugador 2 haz elegido invocar Angeles para ayudar a tu aldea");
                            Razas angeles = factory.getRazas("Angeles");
                            angeles.Crear();
                            b=false;
                            break;
                        case 2:
                            opcionElegidaInvocacion = "Deidades";
                            System.out.println("Jugador 2 haz elegido invocar Deidades para ayudar a tu aldea");
                            Razas deidades = factory.getRazas("Deidades");
                            deidades.Crear();
                            b=false;
                            break;
                        case 3:
                            opcionElegidaInvocacion = "Demonios";
                            System.out.println("Jugador 2 haz elegido invocar Demonios para ayudar a tu aldea");
                            Razas demonios = factory.getRazas("Demonios");
                            demonios.Crear();
                            b=false;
                            break;
                        
                        default:
                            System.out.println("Por favor ingresa un valor valido");      
                    }
                } catch (InputMismatchException E){
                    System.err.println("Debes ingresar un # entero");
                    M.nextLine();
                }
            }       
        }
    public void fase(int fase) {
        System.out.println("----------------------------------------");
        System.out.println("                Fase "+fase+"              ");
        System.out.println("----------------------------------------");
    }
    
    public void escoger() {
        System.out.println("----------------------------------------");
        System.out.println("Turno Jugador 1");
        System.out.println("1. Construir ");
        System.out.println("2. Mejorar ");
        System.out.println("3. Atacar ");
        System.out.println("4. Entrenar ");
        System.out.println("5. Terminar ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
        Scanner M = new Scanner(System.in);
        boolean b = true;
        while(b){
                try {
                    int opcionInvocacion = M.nextInt();
                    String opcionElegidaMenu;
                    switch (opcionInvocacion) {
                        case 1:
                        case 2:
                        case 3:
                        
                        default:
                            System.out.println("Por favor ingresa un valor valido");      
                    }
                } catch (InputMismatchException E){
                    System.err.println("Debes ingresar un # entero");
                    M.nextLine();
                }
            }    
        
    }
    
    public void escogerEdificiosD() {
        System.out.println("----------------------------------------");
        System.out.println("Edificios");
        System.out.println("1. Centro de sangre (Costo: )"+20+" Fases: ");
        System.out.println("2. extractor de sueños (Costo: )"+20+" Fases: ");
        System.out.println("3. Centro rcolector (Costo: )"+20+" Fases: ");
        System.out.println("4. Centro de invocación de demonios (Costo: )"+20+" Fases: ");
        System.out.println("5. Constructor de vehiculos (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
    }
    
    public void escogerEdificiosA() {
        System.out.println("----------------------------------------");
        System.out.println("Edificios");
        System.out.println("1. Centro de sangre (Costo: )"+20+" Fases: ");
        System.out.println("2. sacrificios (Costo: )"+20+" Fases: ");
        System.out.println("3. Centro rcolector de oro (Costo: )"+20+" Fases: ");
        System.out.println("4. Centro de invocación de angeles (Costo: )"+20+" Fases: ");
        System.out.println("5. Constructor de vehiculos (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
    }
    
    public void escogerEdificiosM() {
        System.out.println("----------------------------------------");
        System.out.println("Edificios, construir:");
        System.out.println("1. Productor de mana (Costo: )"+20+" Fases: ");
        System.out.println("2. Productor de pocimas (Costo: )"+20+" Fases: ");
        System.out.println("3. Mineria (Costo: )"+20+" Fases: ");
        System.out.println("4. Centro de invocación de deidades (Costo: )"+20+" Fases: ");
        System.out.println("5. Constructor de vehiculos (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar:");
    }
    
    public void escogerMiliciaD() {
        System.out.println("----------------------------------------");
        System.out.println("Milicia, Invocar:");
        System.out.println("1. Demonio menor (Costo: )"+20+" Fases: ");
        System.out.println("2. Demonio Mayor (Costo: )"+20+" Fases: ");
        System.out.println("3. Cerberos (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
    }
    
    public void escogerMiliciaA() {
        System.out.println("----------------------------------------");
        System.out.println("Milicia, Invocar:");
        System.out.println("1. Arqueros (Costo: )"+20+" Fases: ");
        System.out.println("2. Espadachines (Costo: )"+20+" Fases: ");
        System.out.println("3. Arcangeles (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
    }
    
    public void escogerMiliciaM() {
        System.out.println("----------------------------------------");
        System.out.println("Milicia, Invocar:");
        System.out.println("1. Deidad clase A (Costo: )"+20+" Fases: ");
        System.out.println("2. Deidad clase C (Costo: )"+20+" Fases: ");
        System.out.println("3. Deidad clase S (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
    }
    
    public void escogerVehiculosD() {
        System.out.println("----------------------------------------");
        System.out.println("Vehiculos, Llamar:");
        System.out.println("1. Cuervo (Costo: )"+20+" Fases: ");
        System.out.println("2. Toro S (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
    }
    
    public void escogerVehiculosA() {
        System.out.println("----------------------------------------");
        System.out.println("Vehiculos, Llamar:");
        System.out.println("1. Caballo  (Costo: )"+20+" Fases: ");
        System.out.println("2. Carrosas (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
    }
    
    public void escogerVehiculosM() {
        System.out.println("----------------------------------------");
        System.out.println("Vehiculos, Crear:");
        System.out.println("1. MBW volador  (Costo: )"+20+" Fases: ");
        System.out.println("2. caballo alado (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
    }
}



