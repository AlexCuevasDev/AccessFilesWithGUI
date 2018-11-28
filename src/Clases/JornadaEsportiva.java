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
public class JornadaEsportiva {

    ArrayList<Deporte> listDeportes = new ArrayList<>();

    /**
     *
     * @return
     */
    public ArrayList<Deporte> getListDeportes() {
        return listDeportes;
    }

    /**
     *
     * @param listDeportes
     */
    public void setListDeportes(ArrayList<Deporte> listDeportes) {
        this.listDeportes = listDeportes;
    }

}
