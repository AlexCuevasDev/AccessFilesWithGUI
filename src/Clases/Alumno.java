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
public class Alumno implements Comparable<Alumno> {

    private String nombre, apellidos, curso, sexo;
    private int edad;

    /**
     * Constructor completo
     *
     * @param nombre String
     * @param apellidos String
     * @param curso String
     * @param sexo String
     * @param edad Int
     */
    public Alumno(String nombre, String apellidos, String curso, String sexo, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.sexo = sexo;
        this.edad = edad;
    }

    /**
     * Constructor con sólo un array del nombre y el apellido
     *
     * @param nombreApellido String[]
     */
    public Alumno(String[] nombreApellido) {
        this.nombre = nombreApellido[0];
        this.apellidos = nombreApellido[1];
        curso = null;
        sexo = null;
        edad = -1;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     */
    public String getCurso() {
        return curso;
    }

    /**
     *
     * @param curso
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     *
     * @return
     */
    public String getSexo() {
        return sexo;
    }

    /**
     *
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @return
     */
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Override para que imprima los datos de los alumnos en formato String.
     *
     * @return String
     */
    @Override
    public String toString() {
        return nombre + ";" + apellidos + ";" + curso + ";" + sexo + ";" + edad;
    }

    /**
     * Override del compare to en Comparable para poder usar .sort en dos
     * alumnos y ordenarlos
     *
     * @param a Alumno
     * @return Int
     */
    @Override
    public int compareTo(Alumno a) {
        return (nombre + apellidos).compareToIgnoreCase(a.nombre + a.apellidos);
    }

    /**
     * Override del .equals en List para poder usar el .contains y que funcione
     * correctamente.
     *
     * @param obj Alumno
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Alumno) {
            Alumno alum = (Alumno) obj;
            String nombreAlumnoLeido, nombreAlumnoXParametro = alum.getNombre() + " " + alum.getApellidos();
            nombreAlumnoLeido = nombre + " " + apellidos;
            if (nombreAlumnoLeido.equalsIgnoreCase(nombreAlumnoXParametro)) {
                return true;
            }
        }
        return false;
    }
}
