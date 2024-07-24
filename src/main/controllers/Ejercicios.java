// Ejercicios.java
package main.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ejercicios {

    public static Map<String, Integer> contarFrecuenciaDePalabras(String texto) {
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();
        String[] palabras = texto.toLowerCase().split("\\W+");

        for (String palabra : palabras) {
            frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
        }

        System.out.println("Frecuencia de palabras:");
        for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        return frecuenciaPalabras;
    }

    public static boolean verificarCaracteresUnicos(String cadena) {
        Set<Character> caracteres = new HashSet<>();

        for (char c : cadena.toCharArray()) {
            if (!caracteres.add(c)) {
                System.out.println("La cadena no tiene todos los caracteres únicos.");
                return false;
            }
        }

        System.out.println("La cadena tiene todos los caracteres únicos.");
        return true;
    }
}
