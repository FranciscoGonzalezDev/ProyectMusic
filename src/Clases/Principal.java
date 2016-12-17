package Clases;

import DBase.DataBase;
import java.util.Scanner;

public class Principal {

   public static void main(String[] args) throws Exception {
       
        //INICIALIZAR
        DataBase db = new DataBase();
        Scanner sc = new Scanner(System.in);
        //FIN INICIALIZAR
        
        
        //CONECCION DB
        db.Connection();
        //FIN CONECCION DB
        
       //SELECION DE CLASE 
        System.out.println("(1) Artistas");
        System.out.println("(2) Canciones");
        System.out.println("(3) Discografia");

        System.out.print("Insertar opcion: ");
        int op = sc.nextInt();
        
        switch (op) {
            case 1:
                System.out.println("(A) Mostrar Artistas");
                System.out.println("(B) Insertar Artista");
                System.out.println("(C) Buscar Artistas");

                System.out.print("Insertar opcion: ");
                String op_artista = sc.next();

                Artista artista = new Artista();

                switch (op_artista) {
                    case ("a"):
                        artista.consultaArtista();
                        break;
                    case "b":
                        //Scanner sc = new Scanner(System.in);
                        System.out.print("Introduzca Nombre del Artista: ");
                        String Nombre = sc.next();
                        System.out.print("Introduzca Origen del Artista: ");
                        String Origen = sc.next();
                        System.out.print("Introduzca año de formacion del Artista: ");
                        int Formacion = sc.nextInt();
                        System.out.print("Introduzca cantidad de discos del Artista: ");
                        int Discos = sc.nextInt();
                        System.out.print("Introduzca cantidad de sencillos del Artista: ");
                        int Sencillos = sc.nextInt();
                        db.insertArtista(0, Nombre, Origen, Formacion, Discos, Sencillos);
                        break;
                    case "c":
                        System.out.print("Busqueda por nombre: ");
                        String Nombre_b = sc.next();
                        artista.busquedaArtista(Nombre_b);
                        break;
                }

                break;

            case 2://
                System.out.println("A) Mostrar Canciones");
                System.out.println("B) Insertar Cancion");
                System.out.println("C) Buscar Cancion");

                System.out.print("Insertar opcion: ");
                String op_cancion = sc.next();

                Cancion cancion = new Cancion();

                switch (op_cancion) {
                    case ("a"):
                        cancion.consultaCancion();
                        break;
                    case "b":
                        System.out.print("Introduzca Nombre de la Cancion: ");
                        String nombreCancion = sc.next();
                        System.out.print("Introduzca Duracion de la Cancion: ");
                        String Duracion = sc.next();

                        db.insertCancion(0, 0, 0, nombreCancion, Duracion);
                        break;
                    case "c":
                        System.out.print("Busqueda por nombre de la Cancion: ");
                        String Nombre_c = sc.next();
                        cancion.busquedaCancion(Nombre_c);
                        break;
                }
            case 3:
                System.out.println("A) Mostrar Discos");
                System.out.println("B) Insertar Disco");
                System.out.println("C) Buscar Disco");

                System.out.print("Insertar opcion: ");
                String op_disco = sc.next();

                Discografia disco = new Discografia();

                switch (op_disco) {
                    case ("a"):
                        disco.consultaDisco();
                        break;
                    case "b":
                        System.out.print("Introduzca Nombre del Disco: ");
                        String nombreDisco = sc.next();
                        System.out.print("Introduzca Fecha de Lanzamiento: ");
                        int fechaLanzamiento = sc.nextInt();
                        System.out.print("Introduzca Duracion del Disco: ");
                        String Duracion = sc.next();
                        System.out.print("Introduzca Duracion del Disco: ");
                        int cancionesDisco = sc.nextInt();
                        db.insertDiscografia(0, 0,nombreDisco, fechaLanzamiento, Duracion, cancionesDisco);
                        break;
                    case "c":
                        System.out.print("Busqueda por nombre del Disco: ");
                        String Nombre_d = sc.next();
                        disco.busquedaDisco(Nombre_d);
                        break;
                }
       break; } //FIN SELECION DE CLASE

    }
}