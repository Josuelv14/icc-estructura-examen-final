// App.java
package main;

import main.controllers.EstudianteController;
import main.models.Estudiante;
import main.controllers.Ejercicios;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Estudiante[] estudiantes = {
                new Estudiante("Juan", 85),
                new Estudiante("María", 92),
                new Estudiante("Pedro", 78),
                new Estudiante("Ana", 88),
                new Estudiante("Luis", 75)
        };

        EstudianteController controlador = new EstudianteController();
        controlador.procesarEstudiantes(estudiantes);

        String texto = "Esta es una prueba. Esta prueba es solo una prueba.";
        Ejercicios.contarFrecuenciaDePalabras(texto);

        String cadena1 = "abcdefg";
        Ejercicios.verificarCaracteresUnicos(cadena1);

        String cadena2 = "hello";
        Ejercicios.verificarCaracteresUnicos(cadena2);
    }
}
