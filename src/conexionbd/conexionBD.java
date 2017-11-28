/*
 *  Sistema de Control de Asistencia y Notas
 *  111Mil Programadores
 */

package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayra
 */
public class conexionBD {
    
    private Connection con = null;//creamos el atributo para guardar la coneccion a la base de datos.
    public void Conectar(){// es el metodo para conectar a la base de datos.
        
    //el try catch se utiliza para capturar errores.
        try {
            Class.forName("com.mysql.jdbc.Driver");//especificamos el driver que vamos a utilizar.
            try {
                con= DriverManager.getConnection("jdbc:mysql://localhost/canyabd","root","root");//se obtiene la coneccion a la base de datos
                
            } catch (SQLException e) {
            }
        } catch (ClassNotFoundException e) {
        }
    }
public Connection getcon(){//te devuelve la conexion a la base de datos
    
    return con;
}
public void Desconectar(){// creamos otro metodo que es para conectarte a la  base de datos 
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
