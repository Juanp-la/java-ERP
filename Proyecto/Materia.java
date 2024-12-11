public class Materia {
    private String codigo;
    private String nombre;
    private int semestre;
    private double nota;

    public Materia(String codigo, String nombre, int semestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Semestre: " + semestre + ", Nota: " + nota;
    }
}
