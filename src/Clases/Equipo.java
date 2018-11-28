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
public class Equipo {

    private int id;
    ArrayList<Alumno> listaJugadores;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public ArrayList<Alumno> getListaJugadores() {
        return listaJugadores;
    }

    /**
     *
     * @param listaJugadores
     */
    public void setListaJugadores(ArrayList<Alumno> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

}
