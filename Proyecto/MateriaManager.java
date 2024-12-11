import java.util.ArrayList;

public class MateriaManager {
    private ArrayList<Materia> materias = new ArrayList<>();

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public void eliminarMateria(String codigo) {
        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                materias.remove(i);
                System.out.println("Materia eliminada con éxito.");
                return;
            }
        }
        System.out.println("Materia no encontrada.");
    }

    public Materia buscarMateria(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equalsIgnoreCase(codigo)) {
                return materia;
            }
        }
        return null;
    }

    public void mostrarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
            return;
        }

        for (Materia materia : materias) {
            System.out.println(materia);
        }
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }
    public Materia getMateriaPorCodigo(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equalsIgnoreCase(codigo)) {
                return materia;
            }
        }
        return null; //RETONA NADA SI NO ENCUNETRA NADA 
    }
    public void borrarMateria(String codigo) {
        Materia materia = getMateriaPorCodigo(codigo);
        if (materia != null) {
            materias.remove(materia);
        }
    }
}
