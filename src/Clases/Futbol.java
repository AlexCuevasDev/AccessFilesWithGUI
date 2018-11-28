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
public class Futbol extends Deporte {

    private final int minJugadores = 22;

    /**
     *
     * @param listAlumnos
     */
    @Override
    public void setListAlumnos(ArrayList<Alumno> listAlumnos) {
        this.listAlumnos = listAlumnos;
    }

    @Override
    public boolean esJugable() {
        if (super.listAlumnos.size() >= minJugadores) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "futbol";
    }

}
