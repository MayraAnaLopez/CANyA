package clases;

public class Alumno {

    private int DNI_Alumno;

    private String Nombre;

    private byte Edad;

    private String id_Curso;

    public String getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(String id_Curso) {
        this.id_Curso = id_Curso;
    }

    public Alumno(int DNI_Alumno, String Nombre, byte Edad, String id_Curso) {
        this.DNI_Alumno = DNI_Alumno;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.id_Curso = id_Curso;
    }

 

    public Alumno() {
    }

    public int getDNI_Alumno() {
        return DNI_Alumno;
    }

    public void setDNI_Alumno(int DNI_Alumno) {
        this.DNI_Alumno = DNI_Alumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public byte getEdad() {
        return Edad;
    }

    public void setEdad(byte Edad) {
        this.Edad = Edad;
    }

   
    
    
    
    
    
    
}

