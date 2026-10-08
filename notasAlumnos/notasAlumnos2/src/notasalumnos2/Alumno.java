/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notasalumnos2;

import java.util.ArrayList;

public class Alumno {

    String nombre;
    ArrayList<String> modulos;
    ArrayList<Double> notas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        modulos = new ArrayList<>();
        notas = new ArrayList<>();
    }

    public double media() {

        double suma = 0;

        for (double nota : notas) {
            suma += nota;
        }

        return suma / notas.size();
    }
}
