package clases;

public class Curso {

    private int id_Curso;

    private String Curso;

    public Curso() {
    }

    public Curso(int id_Curso, String Curso) {
        this.id_Curso = id_Curso;
        this.Curso = Curso;
    }

    public int getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(int id_Curso) {
        this.id_Curso = id_Curso;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }
    
}
