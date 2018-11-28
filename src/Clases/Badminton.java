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
public class Badminton extends Deporte {

    final int minJugadores = 2;

    @Override
    public boolean esJugable() {
        if (super.listAlumnos.size() % 2 == 0 && super.listAlumnos.size() >= minJugadores) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "bádminton";
    }
}
