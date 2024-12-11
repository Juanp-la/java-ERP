import java.util.ArrayList;

public class Clase {
    private String codigoMateria;
    private String nombreClase;
    private int semestre;
    private int nroHoras;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Profesor> profesores;

    public Clase(String codigoMateria, String nombreClase, int semestre, int nroHoras) {
        this.codigoMateria = codigoMateria;
        this.nombreClase = nombreClase;
        this.semestre = semestre;
        this.nroHoras = nroHoras;
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setNroHoras(int nroHoras) {
        this.nroHoras = nroHoras;
    }

    public int getNroHoras() {
        return nroHoras;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarProfesor(Profesor profesor) {
        if (!profesores.contains(profesor)) {
            profesores.add(profesor);
        }
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    @Override
    public String toString() {
        String info = "Clase: " + nombreClase + " (Código: " + codigoMateria + ", Semestre: " + semestre + ", Horas: " + nroHoras + ")\nProfesores:\n";
        for (Profesor profesor : profesores) {
            info += "- " + profesor.getNombre() + "\n";
        }
        info += "Estudiantes:\n";
        for (Estudiante estudiante : estudiantes) {
            info += "- " + estudiante.getNombre() + " (ID: " + estudiante.getId() + ")\n";
        }
        return info;
    }
}
