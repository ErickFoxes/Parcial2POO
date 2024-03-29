 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import Edificios.Edificios;
import Edificios.ListaEdificios;
import Milicia.ListaMilicia;
import Vehiculos.ListaVehiculos;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *t
 * @author Erick <00092217@uca.edu.sv>
 */

public class Menu {
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    ListaEdificios listaEdificios = new ListaEdificios();
    ListaEdificios listaEdificios2 = new ListaEdificios();
    ListaMilicia listaMilicia = new ListaMilicia();
    ListaMilicia listaMilicia2 = new ListaMilicia();
    ListaVehiculos listaVehiculos = new ListaVehiculos();
    ListaVehiculos listaVehiculos2 = new ListaVehiculos();
    private static Menu menu;

    public Menu() {
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
        
        modificarRecurso(TJugador,400,"CentroSangreA",1);
        modificarRecurso(TJugador,250,"RuedaSacrificios",2);
        modificarRecurso(TJugador,125,"MineriaOro",3);
        
        modificarRecurso(TJugador,500,"Mineria",1);
        modificarRecurso(TJugador,300,"ProductorMana",2);
        modificarRecurso(TJugador,150,"ProductorPocimas",3);
        
        modificarRecurso(TJugador,600,"CentroSangreD",1);
        modificarRecurso(TJugador,400,"ExtractorSueños",2);
        modificarRecurso(TJugador,200,"CentroRecolector",3);
        
        VerificarAtaque(TJugador);
        VerificarAtaqueV(TJugador);
        
        if(TJugador==1){
            listaEdificios.VerEstado("CentroInvocacionA");
            listaEdificios.VerEstado("CentroInvocacionD");
            listaEdificios.VerEstado("CentroInvocacionM");
            listaEdificios.VerEstado("ConstructorVehiculos");
            listaEdificios.VerEstado("ConstructorVehiculosA");
            listaEdificios.VerEstado("ConstructorVehiculosM");
            listaMilicia.VerEstado("Arcangeles");
            listaMilicia.VerEstado("Arqueros");
            listaMilicia.VerEstado("Demonio Mayor");
            listaMilicia.VerEstado("Demonio Menor");
            listaMilicia.VerEstado("Deidades clase A");
            listaMilicia.VerEstado("Deidades clase S");
            listaVehiculos.VerEstado("BMW");
            listaVehiculos.VerEstado("CaballosAlados");
            listaVehiculos.VerEstado("CaballosM");
            listaVehiculos.VerEstado("Carrosa");
            listaVehiculos.VerEstado("CuervosD");
            listaVehiculos.VerEstado("TorosD");
        }else{
            listaEdificios2.VerEstado("CentroInvocacionA");
            listaEdificios2.VerEstado("CentroInvocacionD");
            listaEdificios2.VerEstado("CentroInvocacionM");
            listaEdificios2.VerEstado("ConstructorVehiculos");
            listaEdificios2.VerEstado("ConstructorVehiculosA");
            listaEdificios2.VerEstado("ConstructorVehiculosM");
            listaMilicia2.VerEstado("Arcangeles");
            listaMilicia2.VerEstado("Arqueros");
            listaMilicia2.VerEstado("Demonio Mayor");
            listaMilicia2.VerEstado("Demonio Menor");
            listaMilicia2.VerEstado("Deidades clase A");
            listaMilicia2.VerEstado("Deidades clase S");
            listaVehiculos2.VerEstado("BMW");
            listaVehiculos2.VerEstado("CaballosAlados");
            listaVehiculos2.VerEstado("CaballosM");
            listaVehiculos2.VerEstado("Carrosa");
            listaVehiculos2.VerEstado("CuervosD");
            listaVehiculos2.VerEstado("TorosD");
        }
        
        
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
            System.out.println("6. Crear vehiculo");
            System.out.println("7. Terminar ");
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
                        case 2:
                            if("Deidades".equals(jugador1.raza) ){
                                mejorarComandoM(TJugador);
                            }else if("Demonios".equals(jugador1.raza)){
                                mejorarComandoD(TJugador);
                            }else if("Angeles".equals(jugador1.raza)){
                                mejorarComandoA(TJugador);
                            }
                            break;
                        case 3:
                            if("Deidades".equals(jugador1.raza) ){
                                AtacarM(TJugador);
                            }else if("Demonios".equals(jugador1.raza)){
                                AtacarM(TJugador);
                            }else if("Angeles".equals(jugador1.raza)){
                                AtacarM(TJugador);
                            }
                            break;
                        case 4:
                            if(listaEdificios.verificarEdificioLista("CentroInvocacionA") || listaEdificios.verificarEdificioLista("CentroInvocacionD") || listaEdificios.verificarEdificioLista("CentroInvocacionM")){
                                if("Deidades".equals(jugador1.raza) ){
                                escogerMiliciaM(TJugador);
                                }else if("Demonios".equals(jugador1.raza)){
                                    escogerMiliciaD(TJugador);
                                }else if("Angeles".equals(jugador1.raza)){
                                    escogerMiliciaA(TJugador);
                                }
                            }else{
                                System.out.println("No tienes un centro de invocación disponible.");
                            }
                            break;
                        case 5:
                            System.out.println("Edificaciones:");
                            listaEdificios.MostrarEdificio();
                            System.out.println("Milicia:");
                            listaMilicia.MostrarMilicia();
                            System.out.println("Vehiculos:");
                            listaVehiculos.MostrarVehiculos();
                            break;
                        case 6:
                            if(listaEdificios.verificarEdificioLista("ConstructorVehiculos") || listaEdificios.verificarEdificioLista("ConstructorVehiculosA") || listaEdificios.verificarEdificioLista("ConstructorVehiculosM")){
                                if("Deidades".equals(jugador1.raza) ){
                                    escogerVehiculosM(TJugador);
                                }else if("Demonios".equals(jugador1.raza)){
                                    escogerVehiculosD(TJugador);
                                }else if("Angeles".equals(jugador1.raza)){
                                    escogerVehiculosA(TJugador);
                                }
                            }else{
                                System.out.println("No tienes un centro constructor de vehiculos disponible.");
                            }
                            break;
                        case 7:
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
            System.out.println("6. Crear vehiculo");
            System.out.println("7. Terminar ");
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
                        case 2:
                            if("Deidades".equals(jugador2.raza) ){
                                mejorarComandoM(TJugador);
                            }else if("Demonios".equals(jugador2.raza)){
                                mejorarComandoD(TJugador);
                            }else if("Angeles".equals(jugador2.raza)){
                                mejorarComandoA(TJugador);
                            }
                            
                            break;
                        case 3:
                            if("Deidades".equals(jugador2.raza) ){
                                AtacarM(TJugador);
                            }else if("Demonios".equals(jugador2.raza)){
                                AtacarM(TJugador);
                            }else if("Angeles".equals(jugador2.raza)){
                                AtacarM(TJugador);
                            }
                            break;
                        case 4:
                            if(listaEdificios2.verificarEdificioLista("CentroInvocacionA") || listaEdificios2.verificarEdificioLista("CentroInvocacionD") || listaEdificios2.verificarEdificioLista("CentroInvocacionM")){
                                if("Deidades".equals(jugador2.raza) ){
                                escogerMiliciaM(TJugador);
                                }else if("Demonios".equals(jugador2.raza)){
                                    escogerMiliciaD(TJugador);
                                }else if("Angeles".equals(jugador2.raza)){
                                    escogerMiliciaA(TJugador);
                                }
                            }else{
                                System.out.println("No tienes un centro de invocación disponible.");
                            }
                            break;
                        case 5:
                            System.out.println("Edificaciones:");
                            listaEdificios2.MostrarEdificio();
                            System.out.println("Milicia:");
                            listaMilicia2.MostrarMilicia();
                            System.out.println("Vehiculos:");
                            listaVehiculos2.MostrarVehiculos();
                        break;
                        case 6:
                            if(listaEdificios2.verificarEdificioLista("ConstructorVehiculos") || listaEdificios2.verificarEdificioLista("ConstructorVehiculosA") || listaEdificios2.verificarEdificioLista("ConstructorVehiculosM")){
                                if("Deidades".equals(jugador2.raza) ){
                                    escogerVehiculosM(TJugador);
                                }else if("Demonios".equals(jugador2.raza)){
                                    escogerVehiculosD(TJugador);
                                }else if("Angeles".equals(jugador2.raza)){
                                    escogerVehiculosA(TJugador);
                                }
                            }else{
                                System.out.println("No tienes un centro constructor de vehiculos disponible.");
                            }
                            break;
                        case 7:
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
    
    public void escogerMiliciaD(int TJugador) {
        
        System.out.println("----------------------------------------");
        System.out.println("Milicia, Invocar:");
        System.out.println("1. Demonio menor Costo: 100 Sangre + 100 sueños Fases:2 fases\nDaño: 45 Vida: 90 ");
        System.out.println("2. Demonio Mayor Costo: 500 Sangre + 600 sueños Fases:4 fases\nDaño: 200 Vida: 450 ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
        Scanner M = new Scanner(System.in);
        Edificios recu = listaEdificios.VerRecursos();
        Edificios recu2 = listaEdificios2.VerRecursos();
        boolean b = true;
        int R1,R2,R3,V;
        if(TJugador==1){
            if(listaMilicia.contarMilicia()<maximoMilicia(TJugador)){
                while(b){
                    try {
                        int opcionInvocacion = M.nextInt();
                        switch (opcionInvocacion) {
                            case 1:
                                if(recu.MostrarRecurso1()>=100 && recu.MostrarRecurso2()>=100){
                                    listaMilicia.AgregarDemonioMenor();
                                    R1=recu.MostrarRecurso1()-100;
                                    R2=recu.MostrarRecurso2()-100;
                                    R3=recu.MostrarRecurso3();
                                    V=recu.MostrarVida();
                                    recu.modificarRecursos(R1, R2, R3, V);
                                }else{
                                    System.out.println("No tienes recursos suficientes");
                                }
                                b=false;
                                break;
                            case 2:
                                if(recu.MostrarRecurso1()>=500 && recu.MostrarRecurso2()>=600){
                                    listaMilicia.AgregarDemonioMayor();
                                    R1=recu.MostrarRecurso1()-500;
                                    R2=recu.MostrarRecurso2()-600;
                                    R3=recu.MostrarRecurso3();
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
                System.out.println("Ya tienes la capacidad maxima de Milicia");
            }
             
        }else{
            if(listaMilicia2.contarMilicia()<maximoMilicia(TJugador)){
                while(b){
                    try {
                        int opcionInvocacion = M.nextInt();
                        switch (opcionInvocacion) {
                            case 1:
                                if(recu2.MostrarRecurso1()>=100 && recu2.MostrarRecurso2()>=100){
                                    listaMilicia2.AgregarDemonioMenor();
                                    R1=recu2.MostrarRecurso1()-100;
                                    R2=recu2.MostrarRecurso2()-100;
                                    R3=recu2.MostrarRecurso3();
                                    V=recu2.MostrarVida();
                                    recu2.modificarRecursos(R1, R2, R3, V);
                                }else{
                                    System.out.println("No tienes recursos suficientes");
                                }
                                b=false;
                                break;
                            case 2:
                                if(recu2.MostrarRecurso1()>=500 && recu2.MostrarRecurso2()>=600){
                                    listaMilicia2.AgregarDemonioMayor();
                                    R1=recu2.MostrarRecurso1()-500;
                                    R2=recu2.MostrarRecurso2()-600;
                                    R3=recu2.MostrarRecurso3();
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
            }else{
                System.out.println("Ya tienes la capacidad maxima de Milicia");
            }
            
        }
    }
    
    public void escogerMiliciaA(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Milicia, Invocar:");
        System.out.println("1. Arqueros Costo: 90 Sangre + 80 Sacrificios Fases:2 fases\nDaño: 70 Vida: 120  ");
        System.out.println("2. Arcangeles Costo: 500 Sangre + 600 Sueños Fases:4 fases\nDaño: 425 Vida: 400  ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
        Scanner M = new Scanner(System.in);
        Edificios recu = listaEdificios.VerRecursos();
        Edificios recu2 = listaEdificios2.VerRecursos();
        boolean b = true;
        int R1,R2,R3,V;
        if(TJugador==1){
            if(listaMilicia.contarMilicia()<maximoMilicia(TJugador)){
                while(b){
                    try {
                        int opcionInvocacion = M.nextInt();
                        switch (opcionInvocacion) {
                            case 1:
                                if(recu.MostrarRecurso1()>=90 && recu.MostrarRecurso2()>=80){
                                    listaMilicia.AgregarArqueros();
                                    R1=recu.MostrarRecurso1()-90;
                                    R2=recu.MostrarRecurso2()-80;
                                    R3=recu.MostrarRecurso3();
                                    V=recu.MostrarVida();
                                    recu.modificarRecursos(R1, R2, R3, V);
                                }else{
                                    System.out.println("No tienes recursos suficientes");
                                }
                                b=false;
                                break;
                            case 2:
                                if(recu.MostrarRecurso1()>=500 && recu.MostrarRecurso2()>=600){
                                    listaMilicia.AgregarArcangeles();
                                    R1=recu.MostrarRecurso1()-500;
                                    R2=recu.MostrarRecurso2()-600;
                                    R3=recu.MostrarRecurso3();
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
                System.out.println("Ya tienes la capacidad maxima de Milicia");
            }
             
        }else{
            if(listaMilicia2.contarMilicia()<maximoMilicia(TJugador)){
                while(b){
                    try {
                        int opcionInvocacion = M.nextInt();
                        switch (opcionInvocacion) {
                            case 1:
                                if(recu2.MostrarRecurso1()>=90 && recu2.MostrarRecurso2()>=80){
                                    listaMilicia2.AgregarArqueros();
                                    R1=recu2.MostrarRecurso1()-90;
                                    R2=recu2.MostrarRecurso2()-80;
                                    R3=recu2.MostrarRecurso3();
                                    V=recu2.MostrarVida();
                                    recu2.modificarRecursos(R1, R2, R3, V);
                                }else{
                                    System.out.println("No tienes recursos suficientes");
                                }
                                b=false;
                                break;
                            case 2:
                                if(recu2.MostrarRecurso1()>=500 && recu2.MostrarRecurso2()>=600){
                                    listaMilicia2.AgregarArcangeles();
                                    R1=recu2.MostrarRecurso1()-500;
                                    R2=recu2.MostrarRecurso2()-600;
                                    R3=recu2.MostrarRecurso3();
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
            }else{
                System.out.println("Ya tienes la capacidad maxima de Milicia");
            }
            
        }
    }
    
    public void escogerMiliciaM(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Milicia, Invocar:");
        System.out.println("1. Deidad clase A Costo: 100 Madera + 100 Mana Fases:2 fases\nDaño: 50 Vida: 100 ");
        System.out.println("2. Deidad clase S Costo: 500 Madera + 600 Mana Fases:4 fases\nDaño: 300 Vida: 400  ");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
        Scanner M = new Scanner(System.in);
        Edificios recu = listaEdificios.VerRecursos();
        Edificios recu2 = listaEdificios2.VerRecursos();
        boolean b = true;
        int R1,R2,R3,V;
        if(TJugador==1){
            if(listaMilicia.contarMilicia()<maximoMilicia(TJugador)){
                while(b){
                    try {
                        int opcionInvocacion = M.nextInt();
                        switch (opcionInvocacion) {
                            case 1:
                                if(recu.MostrarRecurso1()>=100 && recu.MostrarRecurso2()>=100){
                                    listaMilicia.AgregarClaseA();
                                    R1=recu.MostrarRecurso1()-100;
                                    R2=recu.MostrarRecurso2()-100;
                                    R3=recu.MostrarRecurso3();
                                    V=recu.MostrarVida();
                                    recu.modificarRecursos(R1, R2, R3, V);
                                }else{
                                    System.out.println("No tienes recursos suficientes");
                                }
                                b=false;
                                break;
                            case 2:
                                if(recu.MostrarRecurso1()>=500 && recu.MostrarRecurso2()>=600){
                                    listaMilicia.AgregarClaseS();
                                    R1=recu.MostrarRecurso1()-500;
                                    R2=recu.MostrarRecurso2()-600;
                                    R3=recu.MostrarRecurso3();
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
                System.out.println("Ya tienes la capacidad maxima de Milicia");
            }
            
        }else{
            if(listaMilicia2.contarMilicia()<maximoMilicia(TJugador)){
                while(b){
                    try {
                        int opcionInvocacion = M.nextInt();
                        switch (opcionInvocacion) {
                            case 1:
                                if(recu2.MostrarRecurso1()>=100 && recu2.MostrarRecurso2()>=100){
                                    listaMilicia2.AgregarClaseA();
                                    R1=recu2.MostrarRecurso1()-100;
                                    R2=recu2.MostrarRecurso2()-100;
                                    R3=recu2.MostrarRecurso3();
                                    V=recu2.MostrarVida();
                                    recu2.modificarRecursos(R1, R2, R3, V);
                                }else{
                                    System.out.println("No tienes recursos suficientes");
                                }
                                b=false;
                                break;
                            case 2:
                                if(recu2.MostrarRecurso1()>=500 && recu2.MostrarRecurso2()>=600){
                                    listaMilicia2.AgregarClaseS();
                                    R1=recu2.MostrarRecurso1()-500;
                                    R2=recu2.MostrarRecurso2()-600;
                                    R3=recu2.MostrarRecurso3();
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
            }else{
                System.out.println("Ya tienes la capacidad maxima de Milicia");
            }
            
        }
    }
    
    public void escogerVehiculosD(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Vehiculos, Llamar:");
        System.out.println("1. Cuervo Costo: 3000 sangre + 3000 sueños Fases:3 fases\nDaño: 100 Vida: 500 ");
        System.out.println("2. Toro S Costo: 4000 sangre + 3000 sueños Fases:3 fases\nDaño: 150 Vida: 700  ");
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
                            if(recu.MostrarRecurso1()>=3000 && recu.MostrarRecurso2()>=3000){
                                listaVehiculos.AgregarCuervos();
                                R1=recu.MostrarRecurso1()-3000;
                                R2=recu.MostrarRecurso2()-3000;
                                R3=recu.MostrarRecurso3();
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu.MostrarRecurso1()>=4000 && recu.MostrarRecurso2()>=3000){
                                listaVehiculos.AgregarToro();
                                R1=recu.MostrarRecurso1()-4000;
                                R2=recu.MostrarRecurso2()-3000;
                                R3=recu.MostrarRecurso3();
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
                            if(recu2.MostrarRecurso1()>=3000 && recu2.MostrarRecurso2()>=3000){
                                listaVehiculos2.AgregarCuervos();
                                R1=recu2.MostrarRecurso1()-3000;
                                R2=recu2.MostrarRecurso2()-3000;
                                R3=recu2.MostrarRecurso3();
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu2.MostrarRecurso1()>=4000 && recu2.MostrarRecurso2()>=3000){
                                listaVehiculos2.AgregarToro();
                                R1=recu2.MostrarRecurso1()-4000;
                                R2=recu2.MostrarRecurso2()-3000;
                                R3=recu2.MostrarRecurso3();
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
    
    public void escogerVehiculosA(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Vehiculos, Llamar:");
        System.out.println("1. Caballo  Costo: 2000 sangre + 3000 Sacrificios Fases:3 fases\nDaño: 60 Vida: 300 ");
        System.out.println("2. Carrosas  Costo: 5000 sangre + 2000 Sacrificios Fases:3 fases\nDaño: 130 Vida: 700 ");
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
                            if(recu.MostrarRecurso1()>=2000 && recu.MostrarRecurso2()>=3000){
                                listaVehiculos.AgregarCaballos();
                                R1=recu.MostrarRecurso1()-2000;
                                R2=recu.MostrarRecurso2()-3000;
                                R3=recu.MostrarRecurso3();
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu.MostrarRecurso1()>=5000 && recu.MostrarRecurso2()>=2000){
                                listaVehiculos.AgregarCarrosas();
                                R1=recu.MostrarRecurso1()-5000;
                                R2=recu.MostrarRecurso2()-2000;
                                R3=recu.MostrarRecurso3();
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
                            if(recu2.MostrarRecurso1()>=2000 && recu2.MostrarRecurso2()>=3000){
                                listaVehiculos2.AgregarCaballos();
                                R1=recu2.MostrarRecurso1()-5000;
                                R2=recu2.MostrarRecurso2()-2000;
                                R3=recu2.MostrarRecurso3();
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu2.MostrarRecurso1()>=5000 && recu2.MostrarRecurso2()>=2000){
                                listaVehiculos2.AgregarCarrosas();
                                R1=recu2.MostrarRecurso1()-3000;
                                R2=recu2.MostrarRecurso2()-2000;
                                R3=recu2.MostrarRecurso3();
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
    
    public void escogerVehiculosM(int TJugador) {
        System.out.println("----------------------------------------");
        System.out.println("Vehiculos, Crear:");
        System.out.println("1. MBW volador  Costo: 5000 piedra + 2000 Mana Fases:3 fases\nDaño: 70 Vida: 600 ");
        System.out.println("2. caballo alado Costo: 3000 piedra + 3000 Mana Fases:3 fases\nDaño: 40 Vida: 300");
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
                            if(recu.MostrarRecurso1()>=5000 && recu.MostrarRecurso2()>=2000){
                                listaVehiculos.AgregarBMW();
                                R1=recu.MostrarRecurso1()-5000;
                                R2=recu.MostrarRecurso2()-2000;
                                R3=recu.MostrarRecurso3();
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu.MostrarRecurso1()>=3000 && recu.MostrarRecurso2()>=3000){
                                listaEdificios.AgregarDonadorSangreD();
                                listaVehiculos.AgregarCaballosA();
                                R1=recu.MostrarRecurso1()-3000;
                                R2=recu.MostrarRecurso2()-3000;
                                R3=recu.MostrarRecurso3();
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
                            if(recu2.MostrarRecurso1()>=5000 && recu2.MostrarRecurso2()>=2000){
                                listaVehiculos2.AgregarBMW();
                                R1=recu2.MostrarRecurso1()-5000;
                                R2=recu2.MostrarRecurso2()-2000;
                                R3=recu2.MostrarRecurso3();
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            b=false;
                            break;
                        case 2:
                            if(recu2.MostrarRecurso1()>=3000 && recu2.MostrarRecurso2()>=3000){
                                listaVehiculos2.AgregarCaballosA();
                                R1=recu2.MostrarRecurso1()-3000;
                                R2=recu2.MostrarRecurso2()-3000;
                                R3=recu2.MostrarRecurso3();
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
    
    public int maximoMilicia(int TJugador){
         int maxMilicia=0;
        if(TJugador==1){
            int cantMilicia = listaMilicia.contarMilicia(),cantCentroInvoA=listaEdificios.contarEdificio("CentroInvocacionA"),cantCentroInvoD=listaEdificios.contarEdificio("CentroInvocacionD"),cantCentroInvoM=listaEdificios.contarEdificio("CentroInvocacionM");
            if("Deidades".equals(jugador1.raza) ){
                maxMilicia = cantCentroInvoM*10;
            }else if("Demonios".equals(jugador1.raza)){
                maxMilicia = cantCentroInvoD*10;
            }else if("Angeles".equals(jugador1.raza)){
                maxMilicia = cantCentroInvoA*10;
            }
        }else{
            int cantMilicia = listaMilicia2.contarMilicia(),cantCentroInvoA=listaEdificios2.contarEdificio("CentroInvocacionA"),cantCentroInvoD=listaEdificios2.contarEdificio("CentroInvocacionD"),cantCentroInvoM=listaEdificios2.contarEdificio("CentroInvocacionM");
            if("Deidades".equals(jugador2.raza) ){
                maxMilicia = cantCentroInvoM*10;
            }else if("Demonios".equals(jugador2.raza)){
                maxMilicia = cantCentroInvoD*10;
            }else if("Angeles".equals(jugador2.raza)){
                maxMilicia = cantCentroInvoA*10;
            }
        }
        return maxMilicia;
        
    }
    
    public void mejorarComandoM(int TJugador){
        if(TJugador==1){
            if(listaEdificios.VerEstadoEdificio("TorreAsociacion")==3){
                System.out.println("Ha llegado a su maximo nivel");
            }else if(listaEdificios.VerEstadoEdificio("TorreAsociacion")==1){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 1333 madera +1333 mana +1333 pocimas");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu.MostrarRecurso1()>=1333 && recu.MostrarRecurso2()>=1333 && recu.MostrarRecurso3()>=1333){
                                listaEdificios.ModificarEstadoEdificio("TorreAsociacion");
                                recu.Crear(15000, 7500, 4500, 8000);
                                R1=recu.MostrarRecurso1()-1333;
                                R2=recu.MostrarRecurso2()-1333;
                                R3=recu.MostrarRecurso3()-1333;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Por favor ingresa un valor valido");
                    }
                } catch (InputMismatchException E){
                    System.err.println("Debes ingresar un # entero");
                    M.nextLine();
                }
            }else if(listaEdificios.VerEstadoEdificio("TorreAsociacion")==2){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 2000 madera +2000 mana +2000 pocimas");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu.MostrarRecurso1()>=2000 && recu.MostrarRecurso2()>=2000 && recu.MostrarRecurso3()>=2000){
                                listaEdificios.ModificarEstadoEdificio("TorreAsociacion");
                                recu.Crear(20000, 10000, 6000, 8000);
                                R1=recu.MostrarRecurso1()-2000;
                                R2=recu.MostrarRecurso2()-2000;
                                R3=recu.MostrarRecurso3()-2000;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
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
            if(listaEdificios2.VerEstadoEdificio("TorreAsociacion")==3){
            System.out.println("Ha llegado a su maximo nivel");
        }else if(listaEdificios2.VerEstadoEdificio("TorreAsociacion")==1){
            System.out.println("----------------------------------------");
            System.out.println("Mejorar por: Costo: 1333 madera +1333 mana +1333 pocimas");
            System.out.println("1. aceptar ");
            System.out.println("2. cancelar ");
            System.out.println("Ingrese la opcion que desea ejecutar: ");
            Edificios recu = listaEdificios.VerRecursos();
            Edificios recu2 = listaEdificios2.VerRecursos();
            Scanner M = new Scanner(System.in);
            int R1,R2,R3,V;
            try {
                int opcionInvocacion = M.nextInt();
                switch (opcionInvocacion) {
                    case 1:
                        if(recu2.MostrarRecurso1()>=1333 && recu2.MostrarRecurso2()>=1333 && recu2.MostrarRecurso3()>=1333){
                            listaEdificios2.ModificarEstadoEdificio("TorreAsociacion");
                            recu2.Crear(15000, 7500, 4500, 8000);
                            R1=recu2.MostrarRecurso1()-1333;
                            R2=recu2.MostrarRecurso2()-1333;
                            R3=recu2.MostrarRecurso3()-1333;
                            V=recu2.MostrarVida();
                            recu2.modificarRecursos(R1, R2, R3, V);
                        }else{
                            System.out.println("No tienes recursos suficientes");
                        }
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Por favor ingresa un valor valido");
                }
            } catch (InputMismatchException E){
                System.err.println("Debes ingresar un # entero");
                M.nextLine();
            }
        }else if(listaEdificios2.VerEstadoEdificio("TorreAsociacion")==2){
            System.out.println("----------------------------------------");
            System.out.println("Mejorar por: Costo: 2000 madera +2000 mana +2000 pocimas");
            System.out.println("1. aceptar ");
            System.out.println("2. cancelar ");
            System.out.println("Ingrese la opcion que desea ejecutar: ");
            Edificios recu = listaEdificios.VerRecursos();
            Edificios recu2 = listaEdificios2.VerRecursos();
            Scanner M = new Scanner(System.in);
            int R1,R2,R3,V;
            try {
                int opcionInvocacion = M.nextInt();
                switch (opcionInvocacion) {
                    case 1:
                        if(recu2.MostrarRecurso1()>=2000 && recu2.MostrarRecurso2()>=2000 && recu2.MostrarRecurso3()>=2000){
                            listaEdificios2.ModificarEstadoEdificio("TorreAsociacion");
                            recu2.Crear(20000, 10000, 6000, 8000);
                            R1=recu2.MostrarRecurso1()-2000;
                            R2=recu2.MostrarRecurso2()-2000;
                            R3=recu2.MostrarRecurso3()-2000;
                            V=recu2.MostrarVida();
                            recu2.modificarRecursos(R1, R2, R3, V);
                        }else{
                            System.out.println("No tienes recursos suficientes");
                        }
                        break;
                    case 2:
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
    public void mejorarComandoA(int TJugador){
        if(TJugador==1){
            if(listaEdificios.VerEstadoEdificio("CentroOperativo")==3){
                System.out.println("Ha llegado a su maximo nivel");
            }else if(listaEdificios.VerEstadoEdificio("CentroOperativo")==1){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 1333 Sangre +1333 Sacrificios +1333 Oro");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu.MostrarRecurso1()>=1333 && recu.MostrarRecurso2()>=1333 && recu.MostrarRecurso3()>=1333){
                                listaEdificios.ModificarEstadoEdificio("CentroOperativo");
                                recu.Crear(15000, 7500, 4500, 8000);
                                R1=recu.MostrarRecurso1()-1333;
                                R2=recu.MostrarRecurso2()-1333;
                                R3=recu.MostrarRecurso3()-1333;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Por favor ingresa un valor valido");
                    }
                } catch (InputMismatchException E){
                    System.err.println("Debes ingresar un # entero");
                    M.nextLine();
                }

            }else if(listaEdificios.VerEstadoEdificio("CentroOperativo")==2){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 2000 Sangre +2000 Sacrificios +2000 Oro");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu.MostrarRecurso1()>=2000 && recu.MostrarRecurso2()>=2000 && recu.MostrarRecurso3()>=2000){
                                listaEdificios.ModificarEstadoEdificio("CentroOperativo");
                                recu.Crear(20000, 10000, 6000, 8000);
                                R1=recu.MostrarRecurso1()-2000;
                                R2=recu.MostrarRecurso2()-2000;
                                R3=recu.MostrarRecurso3()-2000;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
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
            if(listaEdificios2.VerEstadoEdificio("CentroOperativo")==3){
                System.out.println("Ha llegado a su maximo nivel");
            }else if(listaEdificios2.VerEstadoEdificio("CentroOperativo")==1){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 1333 Sangre +1333 Sacrificios +1333 Oro");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu2.MostrarRecurso1()>=1333 && recu2.MostrarRecurso2()>=1333 && recu2.MostrarRecurso3()>=1333){
                                listaEdificios2.ModificarEstadoEdificio("CentroOperativo");
                                recu2.Crear(15000, 7500, 4500, 8000);
                                R1=recu2.MostrarRecurso1()-1333;
                                R2=recu2.MostrarRecurso2()-1333;
                                R3=recu2.MostrarRecurso3()-1333;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Por favor ingresa un valor valido");
                    }
                } catch (InputMismatchException E){
                    System.err.println("Debes ingresar un # entero");
                    M.nextLine();
                }

            }else if(listaEdificios2.VerEstadoEdificio("CentroOperativo")==2){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 2000 Sangre +2000 Sacrificios +2000 Oro");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu2.MostrarRecurso1()>=2000 && recu2.MostrarRecurso2()>=2000 && recu2.MostrarRecurso3()>=2000){
                                listaEdificios2.ModificarEstadoEdificio("CentroOperativo");
                                recu2.Crear(20000, 10000, 6000, 8000);
                                R1=recu2.MostrarRecurso1()-2000;
                                R2=recu2.MostrarRecurso2()-2000;
                                R3=recu2.MostrarRecurso3()-2000;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
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
    public void mejorarComandoD(int TJugador){
        if(TJugador==1){
            if(listaEdificios.VerEstadoEdificio("CentroComando")==3){
                System.out.println("Ha llegado a su maximo nivel");
            }else if(listaEdificios.VerEstadoEdificio("CentroComando")==1){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 1333 Sangre +1333 Sueños +1333 madera");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu.MostrarRecurso1()>=1333 && recu.MostrarRecurso2()>=1333 && recu.MostrarRecurso3()>=1333){
                                listaEdificios.ModificarEstadoEdificio("CentroComando");
                                recu.Crear(15000, 7500, 4500, 8000);
                                R1=recu.MostrarRecurso1()-1333;
                                R2=recu.MostrarRecurso2()-1333;
                                R3=recu.MostrarRecurso3()-1333;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Por favor ingresa un valor valido");
                    }
                } catch (InputMismatchException E){
                    System.err.println("Debes ingresar un # entero");
                    M.nextLine();
                }

            }else if(listaEdificios.VerEstadoEdificio("CentroComando")==2){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 2000 Sangre +2000 Sueños +2000 Madera");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu.MostrarRecurso1()>=2000 && recu.MostrarRecurso2()>=2000 && recu.MostrarRecurso3()>=2000){
                                listaEdificios.ModificarEstadoEdificio("CentroComando");
                                recu.Crear(20000, 10000, 6000, 8000);
                                R1=recu.MostrarRecurso1()-2000;
                                R2=recu.MostrarRecurso2()-2000;
                                R3=recu.MostrarRecurso3()-2000;
                                V=recu.MostrarVida();
                                recu.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
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
            if(listaEdificios2.VerEstadoEdificio("CentroComando")==3){
                System.out.println("Ha llegado a su maximo nivel");
            }else if(listaEdificios2.VerEstadoEdificio("CentroComando")==1){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 1333 Sangre +1333 Sueños +1333 madera");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu2.MostrarRecurso1()>=1333 && recu2.MostrarRecurso2()>=1333 && recu2.MostrarRecurso3()>=1333){
                                listaEdificios2.ModificarEstadoEdificio("CentroComando");
                                recu2.Crear(15000, 7500, 4500, 8000);
                                R1=recu2.MostrarRecurso1()-1333;
                                R2=recu2.MostrarRecurso2()-1333;
                                R3=recu2.MostrarRecurso3()-1333;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Por favor ingresa un valor valido");
                    }
                } catch (InputMismatchException E){
                    System.err.println("Debes ingresar un # entero");
                    M.nextLine();
                }

            }else if(listaEdificios2.VerEstadoEdificio("CentroComando")==2){
                System.out.println("----------------------------------------");
                System.out.println("Mejorar por: Costo: 2000 Sangre +2000 Sueños +2000 Madera");
                System.out.println("1. aceptar ");
                System.out.println("2. cancelar ");
                System.out.println("Ingrese la opcion que desea ejecutar: ");
                Edificios recu = listaEdificios.VerRecursos();
                Edificios recu2 = listaEdificios2.VerRecursos();
                Scanner M = new Scanner(System.in);
                int R1,R2,R3,V;
                try {
                    int opcionInvocacion = M.nextInt();
                    switch (opcionInvocacion) {
                        case 1:
                            if(recu2.MostrarRecurso1()>=2000 && recu2.MostrarRecurso2()>=2000 && recu2.MostrarRecurso3()>=2000){
                                listaEdificios2.ModificarEstadoEdificio("CentroComando");
                                recu2.Crear(20000, 10000, 6000, 8000);
                                R1=recu2.MostrarRecurso1()-2000;
                                R2=recu2.MostrarRecurso2()-2000;
                                R3=recu2.MostrarRecurso3()-2000;
                                V=recu2.MostrarVida();
                                recu2.modificarRecursos(R1, R2, R3, V);
                            }else{
                                System.out.println("No tienes recursos suficientes");
                            }
                            break;
                        case 2:
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
    
    public void AtacarM(int TJugador){
        if(TJugador==1){
            if(listaMilicia.contarMilicia()!=0 || listaVehiculos.contarVehiculos()!=0){
                int cantEdificios = listaEdificios2.contarEdificios();
                int cantMiliciaPropia = listaMilicia.contarMilicia();
                Scanner M = new Scanner(System.in);
                listaEdificios2.MostrarEdificio2();
                 System.out.println("Elije una unidad a atacar:");
                 int opcionAAtacar = M.nextInt();
                 if(opcionAAtacar>0 && opcionAAtacar<=cantEdificios){
                    System.out.println("1-Milicia\n2-Vehiculos\nElija con que atacar:");
                    try{
                        int opcionConAtacar = M.nextInt();
                        switch(opcionConAtacar){
                            case 1:
                                System.out.println("Elija los soldados que iran a la batalla(elija 0  para terminar:");
                                boolean t=true;
                                listaMilicia.MostrarMilicia2();
                                while(t){
                                    int opcionSoldado = M.nextInt();
                                    if(opcionSoldado==0){
                                        t=false;
                                    }else{
                                        listaMilicia.SoldadoAtacar(opcionSoldado,opcionAAtacar);
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Elija los vehiculos que iran a la batalla(elija 0  para terminar:");
                                boolean g=true;
                                listaVehiculos.MostrarVehiculos2();
                                while(g){
                                    int opcionSoldado = M.nextInt();
                                    if(opcionSoldado==0){
                                        g=false;
                                    }else{
                                        listaVehiculos.VehiculoAtacar(opcionSoldado, opcionAAtacar);
                                    }
                                }
                                break;
                            default:
                                System.out.println("Por favor ingresa un valor valido");
                        }
                    }catch (InputMismatchException E){
                        System.err.println("Debes ingresar un # entero");
                        M.nextLine();
                    }

                 }else{
                     System.out.println("No ha seleccionado una unidad");
                 }        
            }else{
                System.out.println("Usted no tiene soldados con que atacar");
            }
        
        }else{
            if(listaMilicia2.contarMilicia()!=0 || listaVehiculos.contarVehiculos()!=0){
                int cantEdificios = listaEdificios.contarEdificios();
                int cantMiliciaPropia = listaMilicia2.contarMilicia();
                Scanner M = new Scanner(System.in);
                listaEdificios.MostrarEdificio2();
                 System.out.println("Elije una unidad a atacar:");
                 int opcionAAtacar = M.nextInt();
                 if(opcionAAtacar>0 && opcionAAtacar<=cantEdificios){
                    System.out.println("1-Milicia\n2-Vehiculos\nElija con que atacar:");
                    try{
                        int opcionConAtacar = M.nextInt();
                        switch(opcionConAtacar){
                            case 1:
                                System.out.println("Elija los soldados que iran a la batalla(elija 0  para terminar:");
                                boolean t=true;
                                listaMilicia2.MostrarMilicia2();
                                while(t){
                                    int opcionSoldado = M.nextInt();
                                    if(opcionSoldado==0){
                                        t=false;
                                    }else{
                                        listaMilicia2.SoldadoAtacar(opcionSoldado,opcionAAtacar);
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Elija los vehiculos que iran a la batalla(elija 0  para terminar:");
                                boolean g=true;
                                listaVehiculos2.MostrarVehiculos2();
                                while(g){
                                    int opcionSoldado = M.nextInt();
                                    if(opcionSoldado==0){
                                        g=false;
                                    }else{
                                        listaVehiculos2.VehiculoAtacar(opcionSoldado, opcionAAtacar);
                                    }
                                }
                                break;
                            default:
                                System.out.println("Por favor ingresa un valor valido");
                        }
                    }catch (InputMismatchException E){
                        System.err.println("Debes ingresar un # entero");
                        M.nextLine();
                    }

                 }else{
                     System.out.println("No ha seleccionado una unidad");
                 } 
            }else{
                System.out.println("Usted no tiene soldados con que atacar");
            }
        }   
    }
    
    public void VerificarAtaque(int TJugador){
        if(TJugador==1){
            ArrayList liMili = listaMilicia.RegresarLista();
            ArrayList liEdi = listaEdificios2.RegresarLista();
            int i = 0;
            while(i<liMili.size()){
                if(listaMilicia.VerificarAtacando(i)==1){
                    int o=0;
                    while(o!=listaMilicia.VerificarQuienAtacando(i)){
                        o++;
                    }
                    int vidaEdificio = listaEdificios2.RegresarVida(o);
                    if(vidaEdificio>0){
                        vidaEdificio = vidaEdificio-listaMilicia.RegresarDaño(i);
                        listaEdificios2.ModificarVidaEdificio(o, vidaEdificio);
                    }else{
                        listaMilicia.SoldadoNOAtacar(i);
                    }
                    
                }
                 i++;   
            }
        }else{
            ArrayList liMili = listaMilicia2.RegresarLista();
            ArrayList liEdi = listaEdificios.RegresarLista();
            int i = 0;
            while(i<liMili.size()){
                if(listaMilicia2.VerificarAtacando(i)==1){
                    int o=0;
                    while(o!=listaMilicia2.VerificarQuienAtacando(i)){
                        o++;
                    }
                    int vidaEdificio = listaEdificios.RegresarVida(o);
                    if(vidaEdificio>0){
                        vidaEdificio = vidaEdificio-listaMilicia2.RegresarDaño(i);
                        listaEdificios.ModificarVidaEdificio(o, vidaEdificio);
                    }else{
                        listaMilicia2.SoldadoNOAtacar(i);
                    }
                    
                }
                 i++;   
            }
        }
    }
    public void VerificarAtaqueV(int TJugador){
        if(TJugador==1){
            ArrayList liVehi = listaVehiculos.RegresarLista();
            ArrayList liEdi = listaEdificios2.RegresarLista();
            int i = 0;
            while(i<liVehi.size()){
                if(listaVehiculos.VerificarAtacando(i)==1){
                    int o=0;
                    while(o!=listaVehiculos.VerificarQuienAtacando(i)){
                        o++;
                    }
                    int vidaEdificio = listaEdificios2.RegresarVida(o);
                    if(vidaEdificio>0){
                        vidaEdificio = vidaEdificio-listaVehiculos.RegresarDaño(i);
                        listaEdificios2.ModificarVidaEdificio(o, vidaEdificio);
                    }else{
                        listaVehiculos.VehiculoNOAtacar(i);
                    }
                    
                }
                 i++;   
            }
        }else{
            ArrayList liVehi = listaVehiculos2.RegresarLista();
            ArrayList liEdi = listaEdificios.RegresarLista();
            int i = 0;
            while(i<liVehi.size()){
                if(listaVehiculos2.VerificarAtacando(i)==1){
                    int o=0;
                    while(o!=listaVehiculos2.VerificarQuienAtacando(i)){
                        o++;
                    }
                    int vidaEdificio = listaEdificios.RegresarVida(o);
                    if(vidaEdificio>0){
                        vidaEdificio = vidaEdificio-listaVehiculos2.RegresarDaño(i);
                        listaEdificios.ModificarVidaEdificio(o, vidaEdificio);
                    }else{
                        listaVehiculos2.VehiculoNOAtacar(i);
                    }
                    
                }
                 i++;   
            }
        }
    }
    public int RegresarVidaEdificio(int x){
        return listaEdificios2.RegresarVida(x);
    }
    public void ModificarVidaEdificio(int x,int vidaNew){
        listaEdificios2.ModificarVidaEdificio(x, vidaNew);
    }
}



