/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import Edificios.ListaEdificios;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Erick <00092217@uca.edu.sv>
 */
public class Menu {
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    ListaEdificios listaEdificios = new ListaEdificios();
    ListaEdificios listaEdificios2 = new ListaEdificios();
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
        int x = 1,TJugador=1;
        boolean jugando=true;
        Scanner M = new Scanner(System.in);
        Fases fase = new Fases();
        listaEdificios.AgregarTorreQuemado();
        listaEdificios2.AgregarTorreQuemado();
        mensajeDeInicio();
        mensajeDeInicio2();
        fase.setFases(x);
        while(jugando){
           
           fase(fase.getFases());    
           
           
           if(TJugador==1){
               escoger(TJugador);
               TJugador=2;
           }else if(TJugador==2){
               escoger2(TJugador);
               TJugador=1;
               fase.setFases(x);
               x++;
           }
           
           

       }
            
            
    }
    
    public void mensajeDeInicio(){
        
        int opcionInvocacion = 0;
        String opcionElegidaInvocacion;
        boolean b = true;
        Scanner M = new Scanner(System.in);
        System.out.println("Juego de 3 aldeas que quieren conquistarse unas a otras, para hacerlo necesitarán ayuda.");
//        AbstractFactory factory;
//        factory =  FactoryProducer.getFactory("Razas");
        
            System.out.println("Jugador 1 Elija su tipo de invocación:\n1-Angeles\n2-Deidades\n3-Demonios");
            while(b){
                try {
                    opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            System.out.println("Jugador 1 haz elegido invocar Angeles para ayudar a tu aldea");
//                            ListaRazas listaAngeles = new ListaRazas();
//                            listaAngeles.AgregarRaza();
//                            listaAngeles.MostrarPaquete();
                            jugador1.raza = "Angeles";
                            b=false;
                            break;
                        case 2:
                            System.out.println("Jugador 1 haz elegido invocar Deidades para ayudar a tu aldea");
                            jugador1.raza = "Deidades";
                            b=false;
                            break;
                        case 3:
                            System.out.println("Jugador 1 haz elegido invocar Demonios para ayudar a tu aldea");
                            jugador1.raza = "Demonios";
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
        
        Scanner M = new Scanner(System.in);
                   System.out.println("Jugador 2 Elija su tipo de invocación:\n1-Angeles\n2-Deidades\n3-Demonios");
            while(b){
                try {
                    opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            System.out.println("Jugador 2 haz elegido invocar Angeles para ayudar a tu aldea");
                            jugador2.raza = "Angeles";
                            b=false;
                            break;
                        case 2:
                            System.out.println("Jugador 2 haz elegido invocar Deidades para ayudar a tu aldea");
                            jugador2.raza = "Deidades";
                            b=false;
                            break;
                        case 3:
                            System.out.println("Jugador 2 haz elegido invocar Demonios para ayudar a tu aldea");
                            jugador2.raza = "Demonios";
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
        System.out.println("-----------------------------------------");
        System.out.println("                Fase "+fase+"              ");
        System.out.println("-----------------------------------------");
    }
    
    public void escoger(int TJugador) {
        
        boolean b = true;
        while(b){
            System.out.println("----------------------------------------");
            System.out.println("Turno Jugador "+TJugador+"");
            System.out.println("1. Construir ");
            System.out.println("2. Mejorar ");
            System.out.println("3. Atacar ");
            System.out.println("4. Entrenar ");
            System.out.println("5. Mostrar recursos,edificios,milicia ");
            System.out.println("6. Terminar ");
            System.out.println("Ingrese la opcion que desea ejecutar: ");
            Scanner M = new Scanner(System.in);
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            escogerEdificiosM(TJugador);
                        break;
                        case 5:
                            listaEdificios.MostrarEdificio();
                        break;
                        case 6:
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
    
    public void escoger2(int TJugador) {
        
        boolean b = true;
        while(b){
            System.out.println("----------------------------------------");
            System.out.println("Turno Jugador "+TJugador+"");
            System.out.println("1. Construir ");
            System.out.println("2. Mejorar ");
            System.out.println("3. Atacar ");
            System.out.println("4. Entrenar ");
            System.out.println("5. Mostrar recursos,edificios,milicia ");
            System.out.println("6. Terminar ");
            System.out.println("Ingrese la opcion que desea ejecutar: ");
            Scanner M = new Scanner(System.in);
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            escogerEdificiosM(TJugador);
                        break;
                        case 5:
                            listaEdificios2.MostrarEdificio();
                        break;
                        case 6:
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
    
    public void escogerEdificiosM(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Edificios, construir:");
        System.out.println("1. Productor de mana (Costo: )"+20+" Fases: ");
        System.out.println("2. Productor de pocimas (Costo: )"+20+" Fases: ");
        System.out.println("3. Mineria (Costo: )"+20+" Fases: ");
        System.out.println("4. Centro de invocación de deidades (Costo: )"+20+" Fases: ");
        System.out.println("5. Constructor de vehiculos (Costo: )"+20+" Fases: ");
        System.out.println("Ingrese la opcion que desea ejecutar:");
        Scanner M = new Scanner(System.in);
        boolean b = true;
        if(TJugador==1){
            while(b){
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            listaEdificios.AgregarProductorMana();
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
        }else{
            while(b){
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            listaEdificios2.AgregarProductorMana();
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



