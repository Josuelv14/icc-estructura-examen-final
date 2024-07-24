package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EstudianteController {

    private Map<String, List<Estudiante>> categorias;

    public Map<String, List<Estudiante>> procesarEstudiantes(Estudiante[] estudiantes) {
        // TODO Auto-generated method stub
       for(Estudiante estudiante : estudiantes){
        String categoria = obtenerCategoria(estudiante.getCalificacion());
        if(!categorias.containsKey(categoria)){
            categorias.put(categoria,new ArrayList<>());
        }
        categorias.get(categoria).add(estudiante);
       }
       return categorias;

    }
    @SuppressWarnings("unused")
    private void quickSort(Estudiante[] estudiantes, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(estudiantes, izquierda, derecha);
            quickSort(estudiantes, izquierda, indiceParticion - 1);
            quickSort(estudiantes, indiceParticion + 1, derecha);
        }
    }
    private int particion(Estudiante[] estudiantes, int izquierda, int derecha) {
        int pivote = estudiantes[derecha].getCalificacion();
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (estudiantes[j].getCalificacion() < pivote) {
                i++;
                intercambiar(estudiantes, i, j);
            }
        }
        intercambiar(estudiantes, i + 1, derecha);
        return i + 1;
    }

    private void intercambiar(Estudiante[] estudiantes, int i, int j) {
        Estudiante temp = estudiantes[i];
        estudiantes[i] = estudiantes[j];
        estudiantes[j] = temp;
    }

    // Método para obtener la categoría según la calificación
    private String obtenerCategoria(int calificacion) {
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
