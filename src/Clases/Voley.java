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
public class Voley extends Deporte {

    private final int minJugadores = 2; //min 2 en voley pista son 6

    @Override
    public boolean esJugable() {
        if (super.listAlumnos.size() >= minJugadores && super.listAlumnos.size() % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "vóley playa";
    }

}
