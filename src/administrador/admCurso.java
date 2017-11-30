/*
 *  Sistema de Control de Asistencia y Notas
 *  111Mil Programadores
 */

package administrador;

import clases.Curso;
import conexionbd.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayra
 */
public class admCurso {
private conexionBD ConexCurso;//crea un atributo de la clase conexion BASE DE DATOS para utilizar los metodos de esa clase.
private ArrayList<Curso> ListaCurso;//creamos un array para almacenar la lista de curso, que se trae de la base de datos.//importamos util.array y class.curso.
private Statement st;//se utilizan para la consulta de la base de datos.
private PreparedStatement pst;// se utiliza para agregar modificar y eliminar de la base de datos.
private ResultSet rs;// funciona para almacenar los resultados de la base de datos.

public admCurso(){//creamos el constructor de la clase admCurso
    ConexCurso = new conexionBD();// crear un objeto con la coneccionBD 
    ConexCurso.Conectar();// Conectar a la base de datos
    ListaCurso = new ArrayList<>();// creamos una instancia de la lista
    
}

    public ArrayList<Curso> getListaCurso() {
        return ListaCurso;
    }

public ArrayList<Curso> ListaCurso(){//creamos un metodo para obtener la lista de curso de la base de datos
    try {
        st = ConexCurso.getcon().createStatement();// obtenemos los datos de coneccion
        rs = st.executeQuery("SELECT * FROM Curso");// consulta a la base de datos
        while(rs.next()) { // es una estructura repetitiva "mientras".
        Curso curso = new Curso();//Creamos un objeto del tipo curso
        curso.setId_Curso(rs.getInt("id_curso"));//le pasamos los valores 
        curso.setCurso(rs.getString(2));//le pasamos los valores de la segunda columna
        ListaCurso.add(curso);// el objeto que ceamos guardamos en la lista
        
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(admCurso.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ListaCurso;
}
public void Agregar(Curso a){
    try {
        pst=ConexCurso.getcon().prepareStatement("insert into curso (id_curso, curso) values (?,?) ");
        pst.setInt(1, a.getId_Curso());
        pst.setString(2, a.getCurso());
        pst.execute();
        pst.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(admCurso.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}








}  


