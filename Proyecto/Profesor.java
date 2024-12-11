import java.util.ArrayList;

public class Profesor {
    private String nombre;
    private int id;
    private ArrayList<Clase> clases;

    public Profesor(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
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

    public void agregarClase(Clase clase) {
        if (!clases.contains(clase)) {
            clases.add(clase);
            clase.agregarProfesor(this); // Agregar este profe a la clase
        }
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    @Override
    public String toString() {
        String info = "Profesor: " + nombre + " (ID: " + id + ")\nClases:\n";
        for (Clase clase : clases) {
            info += "- " + clase.getCodigoMateria() + "\n";
        }
        return info;
    }
}