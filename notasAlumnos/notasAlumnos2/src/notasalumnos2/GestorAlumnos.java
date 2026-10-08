/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notasalumnos2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GestorAlumnos {

    public static ArrayList<Alumno> leerAlumnos() {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        Path carpeta = Paths.get(
            "D:\\Users\\Alumno Mañana\\Desktop\\PROGRAMACION PROCESOS Y SERVICIOS\\notasAlumnos\\alumnos"
        );

        try {

            for (Path ruta : Files.list(carpeta).toList()) {

                if (Files.isDirectory(ruta)) {

                    Alumno alumno = new Alumno(
                        ruta.getFileName().toString()
                    );

                    Path archivo = ruta.resolve("notas.txt");


                    for (String linea : Files.readAllLines(archivo)) {

                        String[] datos = linea.split(":");

                        alumno.modulos.add(datos[0]);

                        alumno.notas.add(
                            Double.parseDouble(datos[1].trim())
                        );
                    }

                    alumnos.add(alumno);
                }
            }

        } catch (IOException e) {

            System.out.println("Error leyendo los archivos");
            System.out.println(e.getMessage());
        }

        return alumnos;
    }
}