// EstudianteController.java
package main.controllers;

import main.models.Estudiante;

import java.util.*;

public class EstudianteController {

    public Map<String, List<Estudiante>> procesarEstudiantes(Estudiante[] estudiantes) {
        List<Estudiante> listaEstudiantes = Arrays.asList(estudiantes);
        listaEstudiantes.sort(Comparator.comparingInt(Estudiante::getCalificacion));

        System.out.println("Estudiantes ordenados por calificación:");
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante);
        }

        Map<String, List<Estudiante>> categorias = new HashMap<>();
        for (Estudiante estudiante : listaEstudiantes) {
            String categoria = getCategoria(estudiante.getCalificacion());
            categorias.computeIfAbsent(categoria, k -> new ArrayList<>()).add(estudiante);
        }

        System.out.println("\nAgrupación por categorías:");
        for (Map.Entry<String, List<Estudiante>> entry : categorias.entrySet()) {
            System.out.print(entry.getKey() + ": [");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i).getNombre());
                if (i < entry.getValue().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        return categorias;
    }

    private String getCategoria(int calificacion) {
        if (calificacion >= 90) {
            return "A";
        } else if (calificacion >= 80) {
            return "B";
        } else if (calificacion >= 70) {
            return "C";
        } else if (calificacion >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
