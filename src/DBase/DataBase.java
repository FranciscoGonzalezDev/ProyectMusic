package DBase;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DataBase {

    private static Connection Conexion;

    public void Connection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbmusic?user=root&password=");
            System.out.println("Conectado a la Base de Datos");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }
    }

    //INSERTAR DATOS
    public void insertArtista(int idArtista, String Nombre, String Origen, int Formacion, int Discos, int Sencillos) {
        try {
            String Query = "INSERT INTO artista VALUES("
                    + "\"" + idArtista + "\", "
                    + "\"" + Nombre + "\", "
                    + "\"" + Origen + "\", "
                    + "\"" + Formacion + "\", "
                    + "\"" + Discos + "\", "
                    + "\"" + Sencillos + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("\n Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println("\n Error en el almacenamiento de datos");
        }
    }

    public void insertCancion(int idCancion, int idDisco, int idArtista, String nombreCancion, String Duracion) {
        try {
            String Query = "INSERT INTO cancion VALUES("
                    + "\"" + idCancion + "\", "
                    + "\"" + idDisco + "\", "
                    + "\"" + idArtista + "\", "
                    + "\"" + nombreCancion + "\", "
                    + "\"" + Duracion + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("\n Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println("\n Error en el almacenamiento de datos");
        }
    }

    public void insertDiscografia(int idDisco, int idArtista, String nombreDisco, int fechaLanzamiento, String duracion, int cancionesDisco) {
        try {
            String Query = "INSERT INTO discografia VALUES("
                    + "\"" + idDisco + "\", "
                    + "\"" + idArtista + "\", "
                    + "\"" + nombreDisco + "\", "
                    + "\"" + fechaLanzamiento + "\", "
                    + "\"" + duracion + "\", "
                    + "\"" + cancionesDisco + "\")";

            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("\n Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println("\n Error en el almacenamiento de datos");
        }
    }
//FIN INSERTAR DATOS

//CONSULTAS BASE
    public ResultSet obtenerTodo(String tabla) {
        try {
            String Query = "SELECT * FROM " + tabla;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            return resultSet;

        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos");
        }
        return null;
    }

    public ResultSet busquedaDatos(String cadenaValues, String tabla, String columna, String valor) {
        try {
            String Query = "SELECT " + cadenaValues + " FROM " + tabla + " WHERE " + columna + " LIKE '%" + valor + "%'";
            Statement st = Conexion.createStatement();
            ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            return resultSet;

        } catch (SQLException ex) {
            System.out.println("Error en la Busqueda");
        }
        return null;
    }

    public int validar_ingreso(String usuario, String clave) {

        int resultado = 0;
        String Query = "SELECT * FROM usuario WHERE usuario='" + usuario + "' AND clave=('" + clave + "')";

        try {
            Statement st = Conexion.createStatement();
            ResultSet rs;
            rs = st.executeQuery(Query);

            if (rs.next()) {
                resultado = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        } finally {
            /*try {
                Conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);
            }*/
        }
        return resultado;
    }

    public static ArrayList<String> LlenarCombo(String tabla, String campo) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            String Query = "SELECT * FROM " + tabla;
            Statement st = Conexion.createStatement();
            ResultSet rs;
            rs = st.executeQuery(Query);

            while (rs.next()) {
                lista.add(rs.getString(campo));
            }
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos");
        }
        return lista;
    }

    public int obtenerID(String valor) {
        int id = 0;
        String Query = "SELECT idArtista FROM artista WHERE Nombre ='" + valor + "'";
        try {

            Statement st = Conexion.createStatement();
            ResultSet rs;
            rs = st.executeQuery(Query);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la Busqueda");
        }
        return id;
    }

}
// FIN CONSULTAS BASE

