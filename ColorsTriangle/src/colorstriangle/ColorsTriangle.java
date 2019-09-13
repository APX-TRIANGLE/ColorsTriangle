/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorstriangle;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dgiraldo
 */
public class ColorsTriangle {

    private static final Pattern patternLetraG = Pattern.compile("([RB])+");
    private static final Pattern patternLetraB = Pattern.compile("([RG])+");
    private static final Pattern patternLetraR = Pattern.compile("([GB])+");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Crea el scanner para leer la entrada por consola.
        Scanner scanner = new Scanner(System.in);
        // Crea el patron para establecer los caracteres permitidos.
        Pattern patternCadenaEntrada = Pattern.compile("([RGB])+");

        System.out.println("Por favor escriba la cadena de entrada.");

        // Carga la variable con el valor ingresado por consola.
        String cadenaEntrada = scanner.nextLine().trim();

        // Asigna a marcher el valor de el reconocimiento del patron
        // para garantizar que se ingresaron los caracteres adecuados.
        Matcher matcher = patternCadenaEntrada.matcher(cadenaEntrada);

        // Convierte la cadena ingresada por consola en un arreglo de caracteres
        char[] caracteres = cadenaEntrada.toCharArray();

        // Si la validación del patron es exitosa entra a la función.
        if (matcher.matches()) {

            StringBuilder caracter = new StringBuilder();
            // Recorre el arreglo de caracteres y va quitando la ultima posición al
            // recorrerlo hasta que solo quede el ultimo caracter de la comparación.
            for (int posicion = 0; posicion < (caracteres.length - 1); posicion++) {

                if (caracteres.length == 1) {
                    break;
                }

                char caracterValidado = validaColor(caracteres[posicion], caracteres[posicion + 1]);
                caracteres[posicion] = caracterValidado;
                caracter.append(caracterValidado);

                //System.out.println(validaColor(caracteres[posicion], caracteres[posicion + 1]));
                if ((posicion + 1) == caracteres.length) {
                    posicion = 0;
                    caracteres = caracter.toString().toCharArray();
                    caracter = new StringBuilder();
                }
            }
        } else {
            System.out.println("Entrada incorrecta, verifique que sus letras sean mayusculas y que contengan unicamente R, G ó B.");
        }
        System.out.println(caracteres[0]);
    }

    /**
     * @param letraUno Letra de comparación 1
     * @param letraDos Letra de compraración 2
     * @return Retorna el caracter que queda al realiar la evaluación necesaria.
     */
    private static char validaColor(char letraUno, char letraDos) {
        char letraColor = ' ';

        if (letraUno == letraDos) {
            return letraUno;
        }

        if (patternLetraG.matcher((letraUno + "" + letraDos)).matches()) {
            return 'G';
        }

        if (patternLetraB.matcher((letraUno + "" + letraDos)).matches()) {
            return 'B';
        }

        if (patternLetraR.matcher((letraUno + "" + letraDos)).matches()) {
            return 'R';
        }

        return letraColor;
    }
}
