package Clases;

import DBase.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cancion {

    private int idCancion;
    private int idDisco;
    private int idArtista;
    private String nombreCancion;
    private String Duracion;

    public Cancion(int idCancion, int idDisco, int idArtista, String nombreCancion, String Duracion) {
        this.idCancion = idCancion;
        this.idDisco = idDisco;
        this.idArtista = idArtista;
        this.nombreCancion = nombreCancion;
        this.Duracion = Duracion;
    }

    Cancion() {
        idCancion = 0;
        idDisco = 0;
        idArtista = 0;
        nombreCancion = "Nombre de la cancion no disponible";
        Duracion = "0000";
    }

    public void consultaCancion() throws SQLException {
        DataBase db = new DataBase();
        ResultSet rs = db.obtenerTodo("cancion");
        while (rs.next()) {
            System.out.print("|idCancion: " + rs.getInt(1) + "| ");
            System.out.print("|idDisco: " + rs.getInt(2) + "| ");
            System.out.print("|idArtista: " + rs.getInt(3) + "| ");
            System.out.print("|Nombre Cancion: " + rs.getString(4) + "| ");
            System.out.print("|Duracion: " + rs.getString(1) + "| ");
        }
    }
        public void busquedaCancion(String valor) throws SQLException {
        DataBase db = new DataBase();
        ResultSet rs = db.busquedaDatos("*","cancion", "nombreCancion", valor);

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
