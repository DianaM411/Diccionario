package com.diana;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*Implementa un programa que cree la carpeta ‘Diccionario’ con tantos archivos como letras del
abecedario (A.txt, B.txt… Z.txt). Introducirá en cada archivo las palabras de ‘diccionario.txt’ que
comiencen por dicha letra.*/
public class Main {

    public static void main(String[] args) {
        try {
            //creamos la carpeta ‘Diccionario’
            //*******************************
            String pwd = System.getProperty("user.dir");//ruta directorio actual de trabajo
            File diccionario = new File(pwd + File.separator + "diccionario");
            // File.separator es para Windowns y Unix
            boolean crearDirectorio = diccionario.mkdir();//crear nueva carpeta

            //almacenamos las letras del abecedario en un Arraylist
            //*******************************
            List<String> nombresArchivos = new ArrayList<>(Arrays.asList("A.txt", "B.txt", "C.txt", "D.txt", "E.txt", "F.txt", "G.txt", "H.txt", "I.txt", "J.txt", "K.txt", "L.txt", "M.txt", "N.txt", "O.txt", "P.txt", "Q.txt", "R.txt", "S.txt", "T.txt", "U.txt", "V.txt", "W.txt", "X.txt", "Y.txt", "Z.txt"));
            //Tambien se puede hacer con un for (letra = 'A'; letra <= 'Z'; ++letra)

            //creamos los archivos de texto
            //*******************************
           /* for (String nuevoArchivo : nombresArchivos) {
                File file = new File(pwd + File.separator + "diccionario" + File.separator + nuevoArchivo);
                // Create the file
                if (file.createNewFile()) {
                    System.out.println("File is created!");
                } else {
                    System.out.println("File already exists.");
                }
            }*/

            //Introducir en cada archivo las palabras de ‘diccionario.txt’ que comiencen por dicha letra
            //*******************************

            //archivo ‘diccionario.txt’
            File dex = new File(pwd + File.separator + "Documentos" + File.separator + "diccionario.txt");

            //declaramos variables
            FileWriter escribir = null;
            BufferedWriter escritura = null;
            Scanner lector = new Scanner(dex);
            char letra;
            char l;
            String line;

            do {
                line = lector.nextLine();//leer linea por linea
                l = line.charAt(0);// leer el primer caracter de cada linea

                for (letra = 'a'; letra <= 'z'; ++letra) {
                    if (l == letra) {//si la primera letra corresponde
                        if(new File("diccionario" + File.separator + Character.toUpperCase(letra) + ".txt").exists())
                            escribir = new FileWriter("diccionario" + File.separator + Character.toUpperCase(letra) + ".txt",true);//archivo donde escribimos las palabras
                        else
                            escribir = new FileWriter("diccionario" + File.separator + Character.toUpperCase(letra) + ".txt");//archivo donde escribimos las palabras
                        escritura = new BufferedWriter(escribir);
                        //escribimos las palabras que empiezan por la letra en un archivo .txt
                        escritura.write(line);
                        escritura.newLine();
                        escritura.close();
                        break;
                    }
                }
            }
            while (lector.hasNextLine());//mientras el fichero tenga mas lineas
            //cerramos los scanners, FileWriter y BufferedWriter
            lector.close();
            escribir.close();
            //escritura.close();


        } catch (Exception e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
