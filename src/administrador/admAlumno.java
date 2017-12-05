/*
 *  Sistema de Control de Asistencia y Notas
 *  111Mil Programadores
 */

package administrador;

import clases.Alumno;
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
 * @author Expression Celeste is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class admAlumno {
private conexionBD ConexAlumno;//crea un atributo de la clase conexion BASE DE DATOS para utilizar los metodos de esa clase.
private ArrayList<Alumno> ListaAlumno;//creamos un array para almacenar la lista de curso, que se trae de la base de datos.//importamos util.array y class.curso.
private Statement st;//se utilizan para la consulta de la base de datos.
private PreparedStatement pst;// se utiliza para agregar modificar y eliminar de la base de datos.
private ResultSet rs;//

public admAlumno() {
    ConexAlumno = new conexionBD();// crear un objeto con la coneccionBD 
    ConexAlumno.Conectar();// Conectar a la base de datos
    ListaAlumno= new ArrayList<>();// creamos una instancia de la lista
    

    }
public ArrayList<Alumno> ListaAlumno(){//creamos un metodo para obtener la lista de curso de la base de datos
    try {
        st = ConexAlumno.getcon().createStatement();// obtenemos los datos de coneccion
        rs = st.executeQuery("SELECT * FROM alumno, curso where alumno.id_curso = curso.id_curso");// consulta a la base de datos
        while(rs.next()) { // es una estructura repetitiva "mientras".
        Alumno alumno = new  Alumno();//Creamos un objeto del tipo curso
        alumno.setDNI_Alumno(rs.getInt(1));//le pasamos los valores 
        alumno.setNombre(rs.getString(2));
        alumno.setEdad(rs.getByte(3));
        alumno.setId_Curso(rs.getString(6));
        ListaAlumno.add(alumno);// el objeto que ceamos guardamos en la lista
        
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(admAlumno.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ListaAlumno;
}

    public ArrayList<Alumno> getListaAlumno() {
        return ListaAlumno;
    }










}
