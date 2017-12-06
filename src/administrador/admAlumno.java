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

public void Agregar(Alumno alumno){
    try {
        pst=ConexAlumno.getcon().prepareStatement("insert into alumno (dni_alumno,nombre, edad, id_curso) values (?,?,?,?) ");
        pst.setInt(1, alumno.getDNI_Alumno());
        pst.setString(2, alumno.getNombre());
        pst.setByte(3, alumno.getEdad());
        pst.setString(4, alumno.getId_Curso());
        pst.execute();
        pst.close();
       
        
    } catch (SQLException ex) {
        Logger.getLogger(admCurso.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

public void modificar(Alumno alumno){
    try {
        pst=ConexAlumno.getcon().prepareStatement("update alumno set dni_alumno=?, nombre=?, edad=?, id_curso=? where dni_alumno="+ alumno.getDNI_Alumno());
        pst.setInt(1, alumno.getDNI_Alumno());
        pst.setString(2, alumno.getNombre());
        pst.setByte(3, alumno.getEdad());
        pst.setString(4, alumno.getId_Curso());
        pst.execute();
        pst.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(admCurso.class.getName()).log(Level.SEVERE, null, ex);
    }
   
}
public Alumno ObtenerAlumno(int dni_alumno){//creamos un metodo para obtener la lista de curso de la base de datos
        Alumno alumno= new Alumno();
    try {
        st = ConexAlumno.getcon().createStatement();// obtenemos los datos de coneccion
        rs = st.executeQuery("SELECT * FROM alumno where dni_alumno = "+ dni_alumno);// consulta a la base de datos
        while (rs.next()){
        alumno.setDNI_Alumno(rs.getInt(1)); 
        alumno.setNombre (rs.getString(2));
        alumno.setEdad(rs.getByte(3));
        alumno.setId_Curso(String.valueOf(rs.getInt(4)));
        
        }
        
        } catch (SQLException ex) {
        Logger.getLogger(admCurso.class.getName()).log(Level.SEVERE, null, ex);
    }
    return alumno;
}





}
