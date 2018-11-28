package Main;

import Clases.Alumno;
import Main.Utilidades;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class LlenarArchivos {

    /**
     *
     */
    public static final int numAlumnosAInsertar = 20;

    /**
     *
     */
    public static final String[] deportesDisponibles = {"futbol", "futbol sala", "básquet", "bádminton", "vóley playa"};

    /**
     * inserta un número definido en numAlumnosAInsertar de Alumnos en los
     * ficheros nota: puede repetir y en tal caso no lo inserta pero muestra el
     * error
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] arrayHombres = {"Alex", "Cristian", "Pau", "Pol", "Pepe", "Diego", "Jose", "Xavi", "Marc", "Josep"};
        String[] arrayMujeres = {"Maria", "Ari", "Marta", "Pepita", "Anna", "Paula", "Mar", "Sara", "Alba", "Eli"};
        String[] arrayApellidos = {"Cuevas", "Apellido", "Test", "Stucom", "Represa", "Corominola", "Pérez", "Davesa", "Solé", "Català", "Rodríguez"};
        String[] arrayCursos = {"Dam", "ASIX", "DAW", "Test", "Pruebas"};

        Random rand = new Random();

        for (int i = 0; i < numAlumnosAInsertar; i++) {
            int random1 = rand.nextInt(arrayHombres.length) + 0;
            int random2 = rand.nextInt(arrayMujeres.length) + 0;
            int random3 = rand.nextInt(arrayApellidos.length) + 0;
            int random4 = rand.nextInt(arrayApellidos.length) + 0;
            int random5 = rand.nextInt(arrayCursos.length) + 0;

            Alumno ab = new Alumno(arrayHombres[random1], arrayApellidos[random3], arrayCursos[random5], "Hombre", rand.nextInt(100));
            Alumno bc = new Alumno(arrayMujeres[random2], arrayApellidos[random4], arrayCursos[random5], "Mujer", rand.nextInt(100));

            Utilidades.inscribirAlumno(ab, deportesDisponibles[rand.nextInt(deportesDisponibles.length)]);
            Utilidades.inscribirAlumno(bc, deportesDisponibles[rand.nextInt(deportesDisponibles.length)]);
        }
        System.exit(0);
    }

}
