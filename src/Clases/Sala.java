/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alex
 */
public class Sala extends Deporte {

    private final int minJugadores = 14;

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
        return "futbol sala";
    }

}
