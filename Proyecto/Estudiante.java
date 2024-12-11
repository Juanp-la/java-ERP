import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private int id;
    private ArrayList<Materia> materias;
    private ArrayList<Clase> clases;

    public Estudiante(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.materias = new ArrayList<>();
        this.clases = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void agregarMateria(Materia materia, double nota) {
        materia.setNota(nota);
        materias.add(materia);
    }

    public void agregarClase(Clase clase) {
        if (!clases.contains(clase)) {
            clases.add(clase);
            clase.agregarEstudiante(this); // Agregar este estudiante a la claseE
        }
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }
    public double calcularPromedioGeneral() {
        if (materias.isEmpty()) {
            return 0.0;
        }

        double sumaNotas = 0.0;
        for (Materia materia : materias) {
            sumaNotas += materia.getNota();
        }

        return sumaNotas / materias.size();
    }
    public double getNotaPorMateria(Materia materia) {
        for (Materia m : materias) {
            if (m.getCodigo().equals(materia.getCodigo())) {
                return m.getNota();
            }
        }
        return 0.0; // Si la materia no está encontrada, devolvemos 0.0
    }


    @Override
    public String toString() {
        String info = "Estudiante: " + nombre + " (ID: " + id + ")\nMaterias:\n";
        for (Materia materia : materias) {
            info += "- " + materia.getNombre() + " (Nota: " + materia.getNota() + ")\n";
        }
        info += "Clases:\n";
        for (Clase clase : clases) {
            info += "- " + clase.getCodigoMateria() + "\n";
        }
        return info;
    }
}