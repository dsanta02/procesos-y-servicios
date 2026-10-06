/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notasalumnos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class NotasAlumnos {

    public static void main(String[] args) throws IOException {

        Path fichero = Path.of("D:\\Users\\Alumno Mañana\\Desktop\\PROGRAMACION PROCESOS Y SERVICIOS\\notasAlumnos\\src\\notas.txt");
        Path bueno = fichero.toAbsolutePath();

        List<String> datos = Files.readAllLines(fichero);

        double mayor = 0;
        double menor = 10;
        double suma = 0;

        for (String dato : datos) {

            String[] partes = dato.split(" ");

            String nombre = partes[0];
            double nota = Double.parseDouble(partes[1].replace(",", "."));

            if (nota > mayor) {
                mayor = nota;
            }

            if (nota < menor) {
                menor = nota;
            }

            suma = suma + nota;
        }

        double media = suma / datos.size();

        System.out.println("Nota más alta: " + mayor);
        System.out.println("Nota más baja: " + menor);
        System.out.println("Media: " + media);
    }
}

            

        
    
    


