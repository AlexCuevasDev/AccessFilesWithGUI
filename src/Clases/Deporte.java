/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public abstract class Deporte {

    ArrayList<Alumno> listAlumnos = new ArrayList<>();
    ArrayList<Equipo> listEquipos = new ArrayList<>();

    /**
     * Cada deporte sobreescribe este método con sus condiciones para definir si
     * es jugable
     *
     * @return
     */
    public boolean esJugable() {
        return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<Alumno> getListAlumnos() {
        return listAlumnos;
    }

    /**
     *
     * @param listAlumnos
     */
    public void setListAlumnos(ArrayList<Alumno> listAlumnos) {
        this.listAlumnos = listAlumnos;
    }

}
