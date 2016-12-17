package Clases;

import DBase.DataBase;
import java.sql.*;

public class Artista {

    private int idArtista;
    private String Nombre;
    private String Origen;
    private String Formacion;
    private int Discos;
    private int Sencillos;

    public Artista(int idArtista, String Nombre, String Origen, String Formacion, int Discos, int Sencillos) {
        this.idArtista = idArtista;
        this.Nombre = Nombre;
        this.Origen = Origen;
        this.Formacion = Formacion;
        this.Discos = Discos;
        this.Sencillos = Sencillos;
    }

    Artista() {
        idArtista = 0;
        Nombre = "Nombre no disponible";
        Origen = "Origen no disponible";
        Formacion = "Año de formacion no disponible";
        Discos = 0;
        Sencillos = 0;
    }

    public void consultaArtista() throws SQLException {
        DataBase db = new DataBase();
        ResultSet rs = db.obtenerTodo("artista");

        while (rs.next()) {
            System.out.print("|idArtista: " + rs.getInt(1) + "| ");
            System.out.print("|Nombre: " + rs.getString(2) + "| ");
            System.out.print("|Origen: " + rs.getString(3) + "| ");
            System.out.print("|Formacion: " + rs.getString(4) + "| ");
            System.out.print("|Discos: " + rs.getInt(1) + "| ");
            System.out.println("|Sencillos: " + rs.getInt(1) + "|");
        }
    }

    public void busquedaArtista(String valor) throws SQLException {
        DataBase db = new DataBase();
        ResultSet rs = db.busquedaDatos("*","artista","Nombre", valor);

        while (rs.next()) {
            System.out.print("|idArtista: " + rs.getInt(1) + "| ");
            System.out.print("|Nombre: " + rs.getString(2) + "| ");
            System.out.print("|Origen: " + rs.getString(3) + "| ");
            System.out.print("|Formacion: " + rs.getString(4) + "| ");
            System.out.print("|Discos: " + rs.getInt(1) + "| ");
            System.out.println("|Sencillos: " + rs.getInt(1) + "|");
        }

    }

}
