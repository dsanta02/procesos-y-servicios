/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notasalumnos2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Alumno> alumnos =
                GestorAlumnos.leerAlumnos();

        // Número de alumnos

        System.out.println("Numero de alumnos: " + alumnos.size());

        // Media de cada alumno

        for (Alumno alumno : alumnos) {

            System.out.println(
                    alumno.nombre + ": " + alumno.media()
            );
        }
    }
}