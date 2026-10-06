/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notasalumnos2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NotasAlumnos {

    public static void main(String[] args) throws IOException {

        Path carpeta = Path.of("alumnos");

        String[] modulos = {
            "Programación de Servicios y Procesos",
            "Desarrollo de Interfaces",
            "Acceso a Datos",
            "Sistemas de Gestión Empresarial",
            "Programación Multimedia y Dispositivos Móviles",
            "Inglés Profesional",
            "Proyecto Intermodular de Desarrollo de Aplicaciones Multiplataforma"
        };

        double[] sumaModulos = new double[7];

        int numeroAlumnos = 0;

        try (var archivos = Files.newDirectoryStream(carpeta)) {

            for (Path archivo : archivos) {

                numeroAlumnos++;

                double sumaAlumno = 0;
                int contadorNotas = 0;

                try (BufferedReader lector = Files.newBufferedReader(archivo)) {

                    String linea;

                    while ((linea = lector.readLine()) != null) {

                        String[] datos = linea.split(":");

                        String modulo = datos[0].trim();
                        double nota = Double.parseDouble(datos[1].trim());

                        sumaAlumno += nota;
                        contadorNotas++;

                        for (int i = 0; i < modulos.length; i++) {

                            if (modulo.equals(modulos[i])) {
                                sumaModulos[i] += nota;
                            }
                        }
                    }
                }

                double mediaAlumno = sumaAlumno / contadorNotas;

                System.out.println(
                        archivo.getFileName() + 
                        " → Media: " + mediaAlumno
                );
            }
        }

        System.out.println("\nMEDIA POR MÓDULO");

        for (int i = 0; i < modulos.length; i++) {

            double mediaModulo = sumaModulos[i] / numeroAlumnos;

            System.out.println(
                    modulos[i] + " → " + mediaModulo
            );
        }
    }
}
