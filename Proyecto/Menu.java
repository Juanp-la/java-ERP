import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Menu {
    private void cargarArchivos() {
        System.out.println("Cargando datos desde archivos...");
        try (BufferedReader brEstudiantes = new BufferedReader(new FileReader("estudiantes.txt"));
             BufferedReader brProfesores = new BufferedReader(new FileReader("profesores.txt"));
             BufferedReader brMaterias = new BufferedReader(new FileReader("materias.txt"));
             BufferedReader brClases = new BufferedReader(new FileReader("clases.txt"))) {
            // Cargar estudiantes
            String linea;
            while ((linea = brEstudiantes.readLine()) != null) {
                String[] atribs = linea.split(",");
                Estudiante estudiante = new Estudiante(atribs[0], Integer.parseInt(atribs[1].trim()));
                estudiantes.add(estudiante);
            }
            // Cargar profesores
            while ((linea = brProfesores.readLine()) != null) {
                String[] atribs = linea.split(",");
                Profesor profesor = new Profesor(atribs[0], Integer.parseInt(atribs[1].trim()));
                profesores.add(profesor);
            }
            // Cargar materias
            while ((linea = brMaterias.readLine()) != null) {
                String[] atribs = linea.split(",");
                Materia materia = new Materia(atribs[0], atribs[1], Integer.parseInt(atribs[2].trim()));
                materiaManager.agregarMateria(materia);
            }
            // Cargar clases
            while ((linea = brClases.readLine()) != null) {
                String[] atribs = linea.split(",");
                Clase clase = new Clase(atribs[0], atribs[1], Integer.parseInt(atribs[2].trim()), Integer.parseInt(atribs[3].trim()));
                clases.add(clase);
            }
            System.out.println("Datos cargados con éxito.");
        } catch (IOException e) {
            System.err.println("Error al cargar los archivos: " + e.getMessage());
        }
    } 
    

    private void guardarArchivos() {
        System.out.println("Guardando datos en archivos...");
        try (PrintWriter pwEstudiantes = new PrintWriter(new BufferedWriter(new FileWriter("estudiantes.txt")));
             PrintWriter pwProfesores = new PrintWriter(new BufferedWriter(new FileWriter("profesores.txt")));
             PrintWriter pwMaterias = new PrintWriter(new BufferedWriter(new FileWriter("materias.txt")));
             PrintWriter pwClases = new PrintWriter(new BufferedWriter(new FileWriter("clases.txt")))) {
            // Guardar estudiantes
            for (Estudiante estudiante : estudiantes) {
                pwEstudiantes.println(estudiante.getNombre() + "," + estudiante.getId());
            }
            // Guardar profesores
            for (Profesor profesor : profesores) {
                pwProfesores.println(profesor.getNombre() + "," + profesor.getId());
            }
            // Guardar materias
            for (Materia materia : materiaManager.getMaterias()) {
                pwMaterias.println(materia.getCodigo() + "," + materia.getNombre() + "," + materia.getSemestre());
            }
            // Guardar clases
            for (Clase clase : clases) {
                pwClases.println(clase.getCodigoMateria() + "," + clase.getNombreClase() + "," + clase.getSemestre() + "," + clase.getNroHoras());
            }
            System.out.println("Datos guardados con éxito.");
        } catch (IOException e) {
            System.err.println("Error al guardar los archivos: " + e.getMessage());
        }
    } 
    

    private Scanner scanner = new Scanner(System.in);
    private MateriaManager materiaManager = new MateriaManager();
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();
    private ArrayList<Clase> clases = new ArrayList<>();

    public void iniciarMenu() {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarEstudiantes();
                    break;
                case 2:
                    gestionarProfesores();
                    break;
                case 3:
                    gestionarMaterias();
                    break;
                case 4:
                    gestionarClases();
                    break;
                case 5:
                    ordenarArreglos();
                    break;
                case 6:
                    realizarConsultas();
                    break;
                case 7:
                    cargarArchivos();
                    break;
                case 8:
                    guardarArchivos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("--- Menú Principal ---");
        System.out.println("1. Gestionar Estudiantes");
        System.out.println("2. Gestionar Profesores");
        System.out.println("3. Gestionar Materias");
        System.out.println("4. Gestionar Clases");
        System.out.println("5. Ordenar Arreglos");
        System.out.println("6. Hacer Consultas");
        System.out.println("7. Cargar Archivos");
        System.out.println("8. Guardar Archivos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void gestionarEstudiantes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Estudiantes ---");
            System.out.println("1. Consultar Estudiantes");
            System.out.println("2. Adicionar Estudiante");
            System.out.println("3. Adicionar Materias a Estudiante");
            System.out.println("4. Adicionar Clases a Estudiante");
            System.out.println("5. Modificar Estudiante");
            System.out.println("6. Borrar Estudiante");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarEstudiantes();
                    break;
                case 2:
                    adicionarEstudiante();
                    break;
                case 3:
                    adicionarMateriasEstudiante();
                    break;
                case 4:
                    adicionarClasesEstudiante();
                    break;
                case 5:
                    modificarEstudiante();
                    break;
                case 6:
                    borrarEstudiante();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void gestionarProfesores() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Profesores ---");
            System.out.println("1. Consultar Profesores");
            System.out.println("2. Adicionar Profesor");
            System.out.println("3. Adicionar Clases a Profesor");
            System.out.println("4. Modificar Profesor");
            System.out.println("5. Borrar Profesor");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarProfesores();
                    break;
                case 2:
                    adicionarProfesor();
                    break;
                case 3:
                    adicionarClasesProfesor();
                    break;
                case 4:
                    modificarProfesor();
                    break;
                case 5:
                    borrarProfesor();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void gestionarMaterias() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Materias ---");
            System.out.println("1. Consultar Materias");
            System.out.println("2. Adicionar Materia");
            System.out.println("3. Borrar Materia");
            System.out.println("4. Actualizar Materia");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarMaterias();
                    break;
                case 2:
                    adicionarMateria();
                    break;
                case 3:
                    borrarMateria();
                    break;
                case 4:
                    actualizarMateria();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void gestionarClases() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clases ---");
            System.out.println("1. Consultar Clases");
            System.out.println("2. Adicionar Clase");
            System.out.println("3. Adicionar Alumnos a Clase");
            System.out.println("4. Asignar Profesores a Clase");
            System.out.println("5. Borrar Clase");
            System.out.println("6. Actualizar Clase");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarClases();
                    break;
                case 2:
                    adicionarClase();
                    break;
                case 3:
                    adicionarAlumnosClase();
                    break;
                case 4:
                    asignarProfesoresClase();
                    break;
                case 5:
                    borrarClase();
                    break;
                case 6:
                    actualizarClase();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void ordenarArreglos() {
        System.out.println("\n--- Ordenar Arreglos ---");
        System.out.println("1. Ordenar Materias");
        System.out.println("2. Ordenar Clases");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                ordenarMaterias();
                System.out.println("Materias ordenadas por nombre.");
                break;
            case 2:
                ordenarClases();
                System.out.println("Clases ordenadas por nombre.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void ordenarMaterias() {
        ArrayList<Materia> materias = materiaManager.getMaterias();
        for (int i = 0; i < materias.size() - 1; i++) {
            for (int j = 0; j < materias.size() - i - 1; j++) {
                if (materias.get(j).getNombre().compareToIgnoreCase(materias.get(j + 1).getNombre()) > 0) {
                    Materia temp = materias.get(j);
                    materias.set(j, materias.get(j + 1));
                    materias.set(j + 1, temp);
                }
            }
        }
    }

    private void ordenarClases() {
        for (int i = 0; i < clases.size() - 1; i++) {
            for (int j = 0; j < clases.size() - i - 1; j++) {
                if (clases.get(j).getNombreClase().compareToIgnoreCase(clases.get(j + 1).getNombreClase()) > 0) {
                    Clase temp = clases.get(j);
                    clases.set(j, clases.get(j + 1));
                    clases.set(j + 1, temp);
                }
            }
        }
    }

    private void realizarConsultas() {
        int opcion;
        do {
            System.out.println("\n--- Realizar Consultas ---");
            System.out.println("1. Consultar datos de un estudiante, sus clases y notas por semestre");
            System.out.println("2. Imprimir pensum de un estudiante");
            System.out.println("3. Consultar datos de un profesor y sus clases por semestre");
            System.out.println("4. Listar alumnos de una clase con su profesor, ordenado por nombre o notas");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarDatosEstudiante();
                    break;
                case 2:
                    imprimirPensumEstudiante();
                    break;
                case 3:
                    consultarDatosProfesor();
                    break;
                case 4:
                    listarAlumnosClase();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void consultarDatosEstudiante() {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Estudiante estudiante = buscarEstudiante(id);
        if (estudiante != null) {
            System.out.println("Datos del estudiante:");
            System.out.println(estudiante);
            System.out.println("Clases del estudiante:");
            for (Clase clase : estudiante.getClases()) {
                System.out.println(clase);
            }
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }


    private void imprimirPensumEstudiante() {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Estudiante estudiante = buscarEstudiante(id);
        if (estudiante != null) {
            System.out.println("Pensum del estudiante:");
            for (Materia materia : materiaManager.getMaterias()) {
                String estado;
                if (estudiante.getMaterias().contains(materia)) {
                    estado = "Cursada";
                } else {
                    estado = "Pendiente";
                }
                System.out.println("Materia: " + materia.getNombre() + " - Estado: " + estado);
            }
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void consultarDatosProfesor() {
        System.out.print("Ingrese el ID del profesor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Profesor profesor = buscarProfesor(id);
        if (profesor != null) {
            System.out.println("Datos del profesor:");
            System.out.println(profesor);
            System.out.println("Clases del profesor:");
            for (Clase clase : profesor.getClases()) {
                System.out.println(clase);
            }
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private void listarAlumnosClase() {
        System.out.print("Ingrese el código de la clase: ");
        String codigoClase = scanner.nextLine();
        Clase clase = buscarClase(codigoClase);
        if (clase != null) {
            System.out.println("Alumnos de la clase: " + clase.getNombreClase());
            ArrayList<Estudiante> alumnos = clase.getEstudiantes();
            System.out.println("Ordenar por:");
            System.out.println("1. Nombre");
            System.out.println("2. Nota");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    ordenarAlumnosPorNombre(alumnos);
                    break;
                case 2:
                    ordenarAlumnosPorNota(alumnos);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    return;
            }
            for (Estudiante alumno : alumnos) {
                System.out.println(alumno.getNombre() + " (ID: " + alumno.getId() + ") - Promedio: " + alumno.calcularPromedioGeneral());
            }
        } else {
            System.out.println("Clase no encontrada.");
        }
    }

    private void ordenarAlumnosPorNombre(ArrayList<Estudiante> alumnos) {
        for (int i = 0; i < alumnos.size() - 1; i++) {
            for (int j = 0; j < alumnos.size() - i - 1; j++) {
                if (alumnos.get(j).getNombre().compareToIgnoreCase(alumnos.get(j + 1).getNombre()) > 0) {
                    Estudiante temp = alumnos.get(j);
                    alumnos.set(j, alumnos.get(j + 1));
                    alumnos.set(j + 1, temp);
                }
            }
        }
    }

    private void ordenarAlumnosPorNota(ArrayList<Estudiante> alumnos) {
        for (int i = 0; i < alumnos.size() - 1; i++) {
            for (int j = 0; j < alumnos.size() - i - 1; j++) {
                if (alumnos.get(j).calcularPromedioGeneral() < alumnos.get(j + 1).calcularPromedioGeneral()) {
                    Estudiante temp = alumnos.get(j);
                    alumnos.set(j, alumnos.get(j + 1));
                    alumnos.set(j + 1, temp);
                }
            }
        }
    }

    // Métodos 
    private void consultarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }
    }

    private void adicionarEstudiante() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                System.out.println("Estudiante con este ID ya existe.");
                estudiante.setNombre(nombre);
                return;
            }
        }

        Estudiante nuevoEstudiante = new Estudiante(nombre, id);
        estudiantes.add(nuevoEstudiante);
        System.out.println("Estudiante agregado con éxito.");
    }

    private void adicionarMateriasEstudiante() {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Estudiante estudiante = buscarEstudiante(id);
        if (estudiante != null) {
            System.out.print("Ingrese el código de la materia: ");
            String codigoMateria = scanner.nextLine();
            Materia materia = materiaManager.getMateriaPorCodigo(codigoMateria);
            if (materia != null) {
                System.out.print("Ingrese la nota de la materia: ");
                double nota = scanner.nextDouble();
                scanner.nextLine();
                estudiante.agregarMateria(materia, nota);
                System.out.println("Materia agregada al estudiante con éxito.");
            } else {
                System.out.println("Materia no encontrada.");
            }
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void adicionarClasesEstudiante() {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Estudiante estudiante = buscarEstudiante(id);
        if (estudiante != null) {
            System.out.print("Ingrese el código de la clase: ");
            String codigoClase = scanner.nextLine();
            Clase clase = buscarClase(codigoClase);
            if (clase != null) {
                estudiante.agregarClase(clase);
                System.out.println("Clase agregada al estudiante con éxito.");
            } else {
                System.out.println("Clase no encontrada.");
            }
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void modificarEstudiante() {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Estudiante estudiante = buscarEstudiante(id);
        if (estudiante != null) {
            System.out.print("Ingrese el nuevo nombre del estudiante: ");
            String nombre = scanner.nextLine();
            estudiante.setNombre(nombre);
            System.out.println("Estudiante modificado con éxito.");
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void borrarEstudiante() {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        estudiantes.removeIf(estudiante -> estudiante.getId() == id);
        System.out.println("Estudiante borrado con éxito.");
    }

    private Estudiante buscarEstudiante(int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    private void consultarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            for (Profesor profesor : profesores) {
                System.out.println(profesor);
            }
        }
    }

    private void adicionarProfesor() {
        System.out.print("Ingrese el nombre del profesor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del profesor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Profesor profesor : profesores) {
            if (profesor.getId() == id) {
                System.out.println("Profesor con este ID ya existe. Ingresando en modo actualización.");
                profesor.setNombre(nombre);
                return;
            }
        }

        Profesor nuevoProfesor = new Profesor(nombre, id);
        profesores.add(nuevoProfesor);
        System.out.println("Profesor agregado con éxito.");
    }

    private void adicionarClasesProfesor() {
        System.out.print("Ingrese el ID del profesor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Profesor profesor = buscarProfesor(id);
        if (profesor != null) {
            System.out.print("Ingrese el código de la clase: ");
            String codigoClase = scanner.nextLine();
            Clase clase = buscarClase(codigoClase);
            if (clase != null) {
                profesor.agregarClase(clase);
                System.out.println("Clase agregada al profesor con éxito.");
            } else {
                System.out.println("Clase no encontrada.");
            }
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private void modificarProfesor() {
        System.out.print("Ingrese el ID del profesor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Profesor profesor = buscarProfesor(id);
        if (profesor != null) {
            System.out.print("Ingrese el nuevo nombre del profesor: ");
            String nombre = scanner.nextLine();
            profesor.setNombre(nombre);
            System.out.println("Profesor modificado con éxito.");
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private void borrarProfesor() {
        System.out.print("Ingrese el ID del profesor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        profesores.removeIf(profesor -> profesor.getId() == id);
        System.out.println("Profesor borrado con éxito.");
    }

    private Profesor buscarProfesor(int id) {
        for (Profesor profesor : profesores) {
            if (profesor.getId() == id) {
                return profesor;
            }
        }
        return null;
    }

    private void consultarMaterias() {
        if (materiaManager.getMaterias().isEmpty()) {
            System.out.println("No hay materias registradas.");
        } else {
            for (Materia materia : materiaManager.getMaterias()) {
                System.out.println(materia);
            }
        }
    }

    private void adicionarMateria() {
        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código de la materia: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el semestre de la materia: ");
        int semestre = scanner.nextInt();
        scanner.nextLine();

        Materia nuevaMateria = new Materia(codigo, nombre, semestre);
        materiaManager.agregarMateria(nuevaMateria);
        System.out.println("Materia agregada con éxito.");
    }

    private void borrarMateria() {
        System.out.print("Ingrese el código de la materia: ");
        String codigo = scanner.nextLine();
        Materia materia = materiaManager.getMateriaPorCodigo(codigo);
        if (materia != null) {
            materiaManager.borrarMateria(codigo);
            System.out.println("Materia borrada con éxito.");
        } else {
            System.out.println("Materia no encontrada o está asociada a un estudiante o clase, no se puede borrar.");
        }
    }

    private void actualizarMateria() {
        System.out.print("Ingrese el código de la materia: ");
        String codigo = scanner.nextLine();
        Materia materia = materiaManager.getMateriaPorCodigo(codigo);
        if (materia != null) {
            System.out.print("Ingrese el nuevo nombre de la materia: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo semestre de la materia: ");
            int semestre = scanner.nextInt();
            scanner.nextLine();
            materia.setNombre(nombre);
            materia.setSemestre(semestre);
            System.out.println("Materia actualizada con éxito.");
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    private void consultarClases() {
        if (clases.isEmpty()) {
            System.out.println("No hay clases registradas.");
        } else {
            for (Clase clase : clases) {
                System.out.println(clase);
            }
        }
    }

    private void adicionarClase() {
        System.out.print("Ingrese el código de la materia: ");
        String codigoMateria = scanner.nextLine();
        System.out.print("Ingrese el nombre de la clase: ");
        String nombreClase = scanner.nextLine();
        System.out.print("Ingrese el semestre: ");
        int semestre = scanner.nextInt();
        System.out.print("Ingrese el número de horas: ");
        int nroHoras = scanner.nextInt();
        scanner.nextLine();

        Clase nuevaClase = new Clase(codigoMateria, nombreClase, semestre, nroHoras);
        clases.add(nuevaClase);
        System.out.println("Clase agregada con éxito.");
    }

    private void adicionarAlumnosClase() {
        System.out.print("Ingrese el código de la clase: ");
        String codigoClase = scanner.nextLine();
        Clase clase = buscarClase(codigoClase);
        if (clase != null) {
            System.out.print("Ingrese el ID del estudiante: ");
            int idEstudiante = scanner.nextInt();
            scanner.nextLine();
            Estudiante estudiante = buscarEstudiante(idEstudiante);
            if (estudiante != null) {
                clase.agregarEstudiante(estudiante);
                System.out.println("Estudiante agregado a la clase con éxito.");
            } else {
                System.out.println("Estudiante no encontrado.");
            }
        } else {
            System.out.println("Clase no encontrada.");
        }
    }

    private void asignarProfesoresClase() {
        System.out.print("Ingrese el código de la clase: ");
        String codigoClase = scanner.nextLine();
        Clase clase = buscarClase(codigoClase);
        if (clase != null) {
            System.out.print("Ingrese el ID del profesor: ");
            int idProfesor = scanner.nextInt();
            scanner.nextLine();
            Profesor profesor = buscarProfesor(idProfesor);
            if (profesor != null) {
                clase.agregarProfesor(profesor);
                System.out.println("Profesor asignado a la clase con éxito.");
            } else {
                System.out.println("Profesor no encontrado.");
            }
        } else {
            System.out.println("Clase no encontrada.");
        }
    }

    private void borrarClase() {
        System.out.print("Ingrese el código de la clase: ");
        String codigoClase = scanner.nextLine();
        clases.removeIf(clase -> clase.getCodigoMateria().equalsIgnoreCase(codigoClase));
        System.out.println("Clase borrada con éxito.");
    }

    private void actualizarClase() {
        System.out.print("Ingrese el código de la clase: ");
        String codigoClase = scanner.nextLine();
        Clase clase = buscarClase(codigoClase);
        if (clase != null) {
            System.out.print("Ingrese el nuevo nombre de la clase: ");
            String nombreClase = scanner.nextLine();
            System.out.print("Ingrese el nuevo semestre: ");
            int semestre = scanner.nextInt();
            System.out.print("Ingrese el nuevo número de horas: ");
            int nroHoras = scanner.nextInt();
            scanner.nextLine();
            clase.setNombreClase(nombreClase);
            clase.setSemestre(semestre);
            clase.setNroHoras(nroHoras);
            System.out.println("Clase actualizada con éxito.");
        } else {
            System.out.println("Clase no encontrada.");
        }
    }

    private Clase buscarClase(String codigoClase) {
        for (Clase clase : clases) {
            if (clase.getCodigoMateria().equalsIgnoreCase(codigoClase)) {
                return clase;
            }
        }
        return null;
    }
}
