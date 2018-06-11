 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import Edificios.Edificios;
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
        mensajeDeInicio();
        mensajeDeInicio2();
        fase.setFases(x);
        while(jugando){           
           fase(fase.getFases(),TJugador);                
           if(TJugador==1){
               escoger(TJugador);
               TJugador=2;
           }else if(TJugador==2){
               escoger2(TJugador);
               TJugador=1;
               x++;
               fase.setFases(x);
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
                            listaEdificios.AgregarCentroOperativo();
                            b=false;
                            break;
                        case 2:
                            System.out.println("Jugador 1 haz elegido invocar Deidades para ayudar a tu aldea");
                            jugador1.raza = "Deidades";
                            listaEdificios.AgregarTorreQuemado();
                            b=false;
                            break;
                        case 3:
                            System.out.println("Jugador 1 haz elegido invocar Demonios para ayudar a tu aldea");
                            jugador1.raza = "Demonios";
                            listaEdificios.AgregarCentroComando();
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
                            listaEdificios2.AgregarCentroOperativo();
                            b=false;
                            break;
                        case 2:
                            System.out.println("Jugador 2 haz elegido invocar Deidades para ayudar a tu aldea");
                            jugador2.raza = "Deidades";
                            listaEdificios2.AgregarTorreQuemado();
                            b=false;
                            break;
                        case 3:
                            System.out.println("Jugador 2 haz elegido invocar Demonios para ayudar a tu aldea");
                            jugador2.raza = "Demonios";
                            listaEdificios2.AgregarCentroComando();
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
    public void fase(int fase,int TJugador) {
        System.out.println("-----------------------------------------");
        System.out.println("                Fase "+fase+"              ");
        System.out.println("-----------------------------------------");
        
        modificarRecurso(TJugador,300,"CentroSangreA",1);
        modificarRecurso(TJugador,150,"RuedaSacrificios",2);
        modificarRecurso(TJugador,25,"MineriaOro",3);
        
        modificarRecurso(TJugador,300,"Mineria",1);
        modificarRecurso(TJugador,150,"ProductorMana",2);
        modificarRecurso(TJugador,25,"ProductorPocimas",3);
        
        modificarRecurso(TJugador,300,"CentroSangreD",1);
        modificarRecurso(TJugador,150,"ExtractorSueños",2);
        modificarRecurso(TJugador,25,"CentroRecolector",3);
        
    }
    public void modificarRecurso(int TJugador,int Re,String edificio,int Recurso){
        Edificios recu = listaEdificios.VerRecursos();
        Edificios recu2 = listaEdificios2.VerRecursos();
        int R1,R2,R3,V;

        if(TJugador==1){
             R1=recu.MostrarRecurso1();
             R2=recu.MostrarRecurso2();
             R3=recu.MostrarRecurso3();
             V=recu.MostrarVida();
             listaEdificios.AumentarEdificioRecurso(edificio,R1,R2,R3,V,Re,Recurso); 
         }else if(TJugador==2){
             R1=recu2.MostrarRecurso1();
             R2=recu2.MostrarRecurso2();
             R3=recu2.MostrarRecurso3();
             V=recu2.MostrarVida();
             listaEdificios2.AumentarEdificioRecurso(edificio,R1,R2,R3,V,Re,Recurso);
         } 
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
                            if("Deidades".equals(jugador1.raza) ){
                                escogerEdificiosM(TJugador);
                            }else if("Demonios".equals(jugador1.raza)){
                                escogerEdificiosD(TJugador);
                            }else if("Angeles".equals(jugador1.raza)){
                                escogerEdificiosA(TJugador);
                            }
                            
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
                            if("Deidades".equals(jugador2.raza) ){
                                escogerEdificiosM(TJugador);
                            }else if("Demonios".equals(jugador2.raza)){
                                escogerEdificiosD(TJugador);
                            }else if("Angeles".equals(jugador2.raza)){
                                escogerEdificiosA(TJugador);
                            }
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
    
    public void escogerEdificiosD(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Edificios");
        System.out.println("1. Centro de sangre Costo:50 Madera + 300 Sueños  Fases: 2 fases ");
        System.out.println("2. extractor de sueños Costo: 300 Sangre  + 300 Sueños  Fases: 2 fases ");
        System.out.println("3. Centro recolector de madera Costo:400 Sangre + 50  madera  Fases: 2 fases");
        System.out.println("4. Centro de invocación de demonios Costo: 1100 Sangre + 700 Sueños + 20 Madera  Fases: 3 fases");
        System.out.println("5. Constructor de vehiculos Costo: 4000 Sangre + 2000 Sueños + 500 Madera Fases: 5 fases");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
        Scanner M = new Scanner(System.in);
        boolean b = true;
        Edificios recu = listaEdificios.VerRecursos();
        Edificios recu2 = listaEdificios2.VerRecursos();
        int R1,R2,R3,V;
        if(TJugador==1){
            while(b){
                try {
                    int opcionInvocacion = M.nextInt();
                    
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu.MostrarRecurso3()>=50 && recu.MostrarRecurso2()>=300){
                                listaEdificios.AgregarDonadorSangreD();
                                R1=recu.MostrarRecurso1();
                                R2=recu.MostrarRecurso2()-300;
                                R3=recu.MostrarRecurso3()-50;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu.MostrarRecurso1()>=300 && recu.MostrarRecurso2()>=300){
                                listaEdificios.AgregarExtractorSueños();
                                R1=recu.MostrarRecurso1()-300;
                                R2=recu.MostrarRecurso2()-300;
                                R3=recu.MostrarRecurso3();
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 3:
                            if(recu.MostrarRecurso1()>=400 && recu.MostrarRecurso3()>=50){
                                listaEdificios.AgregarCentroRecolector();
                                R1=recu.MostrarRecurso1()-400;
                                R2=recu.MostrarRecurso2();
                                R3=recu.MostrarRecurso3()-50;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 4:
                            if(recu.MostrarRecurso1()>=1100 && recu.MostrarRecurso2()>=700 && recu.MostrarRecurso3()>=20){
                                listaEdificios.AgregarCentroInvocadorD();
                                R1=recu.MostrarRecurso1()-1100;
                                R2=recu.MostrarRecurso2()-700;
                                R3=recu.MostrarRecurso3()-20;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 5:
                            if(recu.MostrarRecurso1()>=4000 && recu.MostrarRecurso2()>=2000 && recu.MostrarRecurso3()>=500){
                                listaEdificios.AgregarConstructorVehiculosD();
                                R1=recu.MostrarRecurso1()-4000;
                                R2=recu.MostrarRecurso2()-2000;
                                R3=recu.MostrarRecurso3()-500;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
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
                            if(recu2.MostrarRecurso3()>=50 && recu2.MostrarRecurso2()>=300){
                                listaEdificios2.AgregarDonadorSangreD();
                                R1=recu2.MostrarRecurso1();
                                R2=recu2.MostrarRecurso2()-300;
                                R3=recu2.MostrarRecurso3()-50;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu2.MostrarRecurso1()>=300 && recu2.MostrarRecurso2()>=300){
                                listaEdificios2.AgregarExtractorSueños();
                                R1=recu2.MostrarRecurso1()-300;
                                R2=recu2.MostrarRecurso2()-300;
                                R3=recu2.MostrarRecurso3();
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 3:
                            if(recu2.MostrarRecurso1()>=400 && recu2.MostrarRecurso3()>=50){
                                listaEdificios2.AgregarCentroRecolector();
                                R1=recu2.MostrarRecurso1()-400;
                                R2=recu2.MostrarRecurso2();
                                R3=recu2.MostrarRecurso3()-50;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 4:
                            if(recu2.MostrarRecurso1()>=1100 && recu2.MostrarRecurso2()>=700 && recu2.MostrarRecurso3()>=20){
                                listaEdificios2.AgregarCentroInvocadorD();
                                R1=recu2.MostrarRecurso1()-1100;
                                R2=recu2.MostrarRecurso2()-700;
                                R3=recu2.MostrarRecurso3()-20;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 5:
                            if(recu2.MostrarRecurso1()>=4000 && recu2.MostrarRecurso2()>=2000 && recu2.MostrarRecurso3()>=500){
                                listaEdificios2.AgregarConstructorVehiculosD();
                                R1=recu2.MostrarRecurso1()-4000;
                                R2=recu2.MostrarRecurso2()-2000;
                                R3=recu2.MostrarRecurso3()-500;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
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
    
    public void escogerEdificiosA(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Edificios");
        System.out.println("1. Centro de sangre Costo: 50 oro + 300 sacrificios Fases:2 fases ");
        System.out.println("2. Rueda de sacrificios Costo: 300 Sangre + 300 sacrificios Fases:2 fases ");
        System.out.println("3. Centro rcolector de oro Costo: 400 sangre + 50 oro Fases:2 fases ");
        System.out.println("4. Centro de invocación de angeles Costo: 1100 sangre + 700 sacrificios + 20 oro Fases:3 fases ");
        System.out.println("5. Constructor de vehiculos Costo: 4000 Sangre + 2000 sacrificios + 500 oro Fases:5 fases ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
        Scanner M = new Scanner(System.in);
        boolean b = true;
        Edificios recu = listaEdificios.VerRecursos();
        Edificios recu2 = listaEdificios2.VerRecursos();
        int R1,R2,R3,V;
        if(TJugador==1){
            while(b){
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu.MostrarRecurso3()>=50 && recu.MostrarRecurso2()>=300){
                                listaEdificios.AgregarCentroSangreA();
                                R1=recu.MostrarRecurso1();
                                R2=recu.MostrarRecurso2()-300;
                                R3=recu.MostrarRecurso3()-50;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu.MostrarRecurso1()>=300 && recu.MostrarRecurso2()>=300){
                                listaEdificios.AgregarRuedaSacrificios();
                                R1=recu.MostrarRecurso1()-300;
                                R2=recu.MostrarRecurso2()-300;
                                R3=recu.MostrarRecurso3();
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 3:
                            if(recu.MostrarRecurso1()>=400 && recu.MostrarRecurso3()>=50){
                                listaEdificios.AgregarMineriaOro();
                                R1=recu.MostrarRecurso1()-400;
                                R2=recu.MostrarRecurso2();
                                R3=recu.MostrarRecurso3()-50;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 4:
                            if(recu.MostrarRecurso1()>=1100 && recu.MostrarRecurso2()>=700 && recu.MostrarRecurso3()>=20){
                                listaEdificios.AgregarCentroInvocadorA();
                                R1=recu.MostrarRecurso1()-1100;
                                R2=recu.MostrarRecurso2()-700;
                                R3=recu.MostrarRecurso3()-20;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 5:
                             if(recu.MostrarRecurso1()>=4000 && recu.MostrarRecurso2()>=2000 && recu.MostrarRecurso3()>=500){
                                listaEdificios.AgregarConstructorVehiculosA();
                                R1=recu.MostrarRecurso1()-4000;
                                R2=recu.MostrarRecurso2()-2000;
                                R3=recu.MostrarRecurso3()-500;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
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
                            if(recu2.MostrarRecurso3()>=50 && recu2.MostrarRecurso2()>=300){
                                listaEdificios2.AgregarCentroSangreA();
                                R1=recu2.MostrarRecurso1();
                                R2=recu2.MostrarRecurso2()-300;
                                R3=recu2.MostrarRecurso3()-50;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu2.MostrarRecurso1()>=300 && recu2.MostrarRecurso2()>=300){
                                listaEdificios2.AgregarRuedaSacrificios();
                                R1=recu2.MostrarRecurso1()-300;
                                R2=recu2.MostrarRecurso2()-300;
                                R3=recu2.MostrarRecurso3();
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 3:
                            if(recu2.MostrarRecurso1()>=400 && recu2.MostrarRecurso3()>=50){
                                listaEdificios2.AgregarMineriaOro();
                                R1=recu2.MostrarRecurso1()-400;
                                R2=recu2.MostrarRecurso2();
                                R3=recu2.MostrarRecurso3()-50;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 4:
                            if(recu2.MostrarRecurso1()>=1100 && recu2.MostrarRecurso2()>=700 && recu2.MostrarRecurso3()>=20){
                                listaEdificios2.AgregarCentroInvocadorA();
                                R1=recu2.MostrarRecurso1()-1100;
                                R2=recu2.MostrarRecurso2()-700;
                                R3=recu2.MostrarRecurso3()-20;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 5:
                             if(recu2.MostrarRecurso1()>=4000 && recu2.MostrarRecurso2()>=2000 && recu2.MostrarRecurso3()>=500){
                                listaEdificios2.AgregarConstructorVehiculosA();
                                R1=recu2.MostrarRecurso1()-4000;
                                R2=recu2.MostrarRecurso2()-2000;
                                R3=recu2.MostrarRecurso3()-500;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
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
    
    public void escogerEdificiosM(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Edificios, construir:");
        System.out.println("1. Productor de mana, Costo: 300 Piedra + 300 Mana Fases: 2 fases");
        System.out.println("2. Productor de pocimas, Costo: 400 Piedra + 50 Pocimas Fases: 2 fases");
        System.out.println("3. Mineria, Costo: 50 pocimas + 300 mana  Fases: 2 fases");
        System.out.println("4. Centro de invocación de deidades, Costo:1100 Piedra + 700 Mana + 20 Pocimas Fases: 3 fases");
        System.out.println("5. Constructor de vehiculos, Costo: 4000 Piedra + 2000 Mana + 500 Pocimas Fases: 5 fases");
        System.out.println("Ingrese la opcion que desea ejecutar:");
        Scanner M = new Scanner(System.in);
        boolean b = true;
        Edificios recu = listaEdificios.VerRecursos();
        Edificios recu2 = listaEdificios2.VerRecursos();
        int R1,R2,R3,V;
        if(TJugador==1){
            while(b){
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                             if(recu.MostrarRecurso1()>=300 && recu.MostrarRecurso2()>=300){
                                listaEdificios.AgregarProductorMana();
                                R1=recu.MostrarRecurso1()-300;
                                R2=recu.MostrarRecurso2()-300;
                                R3=recu.MostrarRecurso3();
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu.MostrarRecurso1()>=400 && recu.MostrarRecurso3()>=50){
                                listaEdificios.AgregarProductorPocimas();
                                R1=recu.MostrarRecurso1()-400;
                                R2=recu.MostrarRecurso2();
                                R3=recu.MostrarRecurso3()-50;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 3:
                            if(recu.MostrarRecurso2()>=300 && recu.MostrarRecurso3()>=50){
                                listaEdificios.AgregarMineria();
                                R1=recu.MostrarRecurso1();
                                R2=recu.MostrarRecurso2()-300;
                                R3=recu.MostrarRecurso3()-50;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 4:
                            if(recu.MostrarRecurso1()>=1100 && recu.MostrarRecurso2()>=700 && recu.MostrarRecurso3()>=20){
                                listaEdificios.AgregarCentroInvocacionM();
                                R1=recu.MostrarRecurso1()-1100;
                                R2=recu.MostrarRecurso2()-700;
                                R3=recu.MostrarRecurso3()-20;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 5:
                            if(recu.MostrarRecurso1()>=4000 && recu.MostrarRecurso2()>=2000 && recu.MostrarRecurso3()>=500){
                                listaEdificios.AgregarVehiculosM();
                                R1=recu.MostrarRecurso1()-4000;
                                R2=recu.MostrarRecurso2()-2000;
                                R3=recu.MostrarRecurso3()-500;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
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
                             if(recu2.MostrarRecurso3()>=50 && recu2.MostrarRecurso2()>=300){
                                listaEdificios2.AgregarProductorMana();
                                R1=recu2.MostrarRecurso1();
                                R2=recu2.MostrarRecurso2()-300;
                                R3=recu2.MostrarRecurso3()-50;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu2.MostrarRecurso1()>=300 && recu2.MostrarRecurso2()>=300){
                                listaEdificios2.AgregarProductorPocimas();
                                R1=recu2.MostrarRecurso1()-300;
                                R2=recu2.MostrarRecurso2()-300;
                                R3=recu2.MostrarRecurso3();
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 3:
                            if(recu2.MostrarRecurso1()>=400 && recu2.MostrarRecurso3()>=50){
                                listaEdificios2.AgregarMineria();
                                R1=recu2.MostrarRecurso1()-400;
                                R2=recu2.MostrarRecurso2();
                                R3=recu2.MostrarRecurso3()-50;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 4:
                            if(recu2.MostrarRecurso1()>=1100 && recu2.MostrarRecurso2()>=700 && recu2.MostrarRecurso3()>=20){
                                listaEdificios2.AgregarCentroInvocacionM();
                                R1=recu2.MostrarRecurso1()-1100;
                                R2=recu2.MostrarRecurso2()-700;
                                R3=recu2.MostrarRecurso3()-20;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 5:
                            if(recu2.MostrarRecurso1()>=4000 && recu2.MostrarRecurso2()>=2000 && recu2.MostrarRecurso3()>=500){
                                listaEdificios2.AgregarVehiculosM();
                                R1=recu2.MostrarRecurso1()-4000;
                                R2=recu2.MostrarRecurso2()-2000;
                                R3=recu2.MostrarRecurso3()-500;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
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



