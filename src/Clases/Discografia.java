package Clases;

import DBase.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Discografia {

    private int idDisco;
    private int idArtista;
    private String nombreDisco;
    private String fechaLanzamiento;
    private String duracion;
    private int cancionesDisco;

    public Discografia(int idDisco, int idArtista, String nombreDisco, String fechaLanzamiento, String duracion, int cancionesDisco) {
        this.idDisco = idDisco;
        this.idArtista = idArtista;
        this.nombreDisco = nombreDisco;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
        this.cancionesDisco = cancionesDisco;
    }

    Discografia() {
        idDisco = 0;
        idArtista = 0;
        nombreDisco = "No disponible";
        fechaLanzamiento = "00-00-0000";
        duracion = "00:00";
        cancionesDisco = 0;
    }

    public void consultaDisco() throws SQLException {
        DataBase db = new DataBase();
        ResultSet rs = db.obtenerTodo("discografia");
        while (rs.next()) {
            System.out.print("|idDisco: " + rs.getInt(1) + "| ");
            System.out.print("|idArtista: " + rs.getInt(2) + "| ");
            System.out.print("|Nombre Disco: " + rs.getString(3) + "| ");
            System.out.print("|Fecha Lanzamiento: " + rs.getString(4) + "| ");
            System.out.print("|Duracion: " + rs.getString(1) + "| ");
            System.out.println("|Canciones Disco: " + rs.getInt(1) + "|");
        }
    }

    public void busquedaDisco(String valor) throws SQLException {
        DataBase db = new DataBase();
        ResultSet rs = db.busquedaDatos("*","discografia", "nombreDisco", valor);

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
