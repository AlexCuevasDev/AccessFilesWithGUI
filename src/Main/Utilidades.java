package Main;

import Clases.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene métodos de utilidad general, uso protected para
 * restringirlo a sólo este paquete pero si fuese necesario podrían ser public.
 * He separado los métodos aquí porque de esta forma en el resto de clases sólo
 * me preocupo de implementarlo y el código queda más limpio.
 *
 * @author Alex
 */
public class Utilidades {

    /**
     * Ordena los alumnos alfabéticamente, he usado el método .sort de
     * collections creando antes un comparador en Alumno.
     *
     * @param listAlumnos
     * @return
     */
    static ArrayList<Alumno> ordenarAlumnosASC(ArrayList<Alumno> listAlumnos) {
        Collections.sort(listAlumnos);
        return listAlumnos;
    }

    /**
     * Devuelve los alumnos del curso pasado por parámetro
     *
     * @param curso String
     * @return listAlumnosXCurso Arraylist Alumno
     */
    static ArrayList<Alumno> getAlumnosXCurso(String curso) {
        ArrayList<Alumno> listAlumnos = leerArchivo(selectorArchivo("alumnos"));
        ArrayList<Alumno> listAlumnosXCurso = new ArrayList<Alumno>();

        for (Alumno alumno : listAlumnos) {
            if (alumno.getCurso().equalsIgnoreCase(curso)) {
                listAlumnosXCurso.add(alumno);
            }
        }
        return listAlumnosXCurso;
    }

    /**
     * Recibe un File por parámetro y te devuelve los alumnos inscritos en él.
     *
     * @param archivo
     * @return listAlumnos ArrayList Alumno
     */
    static ArrayList<Alumno> leerArchivo(File archivo) {
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Alumno> listAlumnos = new ArrayList<>();
        Alumno alumno;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String datos[] = linea.split(";");
                alumno = new Alumno(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
                listAlumnos.add(alumno);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el archivo " + ex.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo " + ex.getMessage());
            }
        }
        return listAlumnos;

    }

    /**
     * Borra el fichero de deporte pasado por parámetro
     *
     * @param deporte String
     */
    static void borrarFicheroDeporte(String deporte) {
        File deporteFile = selectorArchivo(deporte);
        deporteFile.delete();
    }

    /**
     * Inicializa la jornada esportiva según los ficheros
     *
     * @param deportesDisponibles String[]
     * @return JornadaEsportiva
     */
    static JornadaEsportiva getJornadaEsportiva(ArrayList<String> deportesDisponibles) {
        JornadaEsportiva je = new JornadaEsportiva();
        ArrayList<Deporte> listDeportes = new ArrayList<>();

        Futbol futbol = new Futbol();
        Basquet basquet = new Basquet();
        Badminton badminton = new Badminton();
        Sala fSala = new Sala();
        Voley voley = new Voley();

        try {
            for (String deporte : deportesDisponibles) {
                switch (deporte.toLowerCase()) {
                    case "futbol":
                        futbol.setListAlumnos(leerArchivo(selectorArchivo(deporte)));
                        listDeportes.add(futbol);
                        break;
                    case "básquet":
                        basquet.setListAlumnos(leerArchivo(selectorArchivo(deporte)));
                        listDeportes.add(basquet);
                        break;
                    case "bádminton":
                        badminton.setListAlumnos(leerArchivo(selectorArchivo(deporte)));
                        listDeportes.add(badminton);
                        break;
                    case "futbol sala":
                        fSala.setListAlumnos(leerArchivo(selectorArchivo(deporte)));
                        listDeportes.add(fSala);
                        break;
                    case "vóley playa":
                        voley.setListAlumnos(leerArchivo(selectorArchivo(deporte)));
                        listDeportes.add(voley);
                        break;
                    default:
                        throw new IOException("Un archivo no encontrado: " + deporte);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "El programa se interrumpió. " + e.getMessage());
        }

        je.setListDeportes(listDeportes);

        return je;
    }

    /**
     * Comprueba si un alumno está inscrito en un ArrayList
     *
     * @param listAlumnos ArrayList Alumno
     * @param a Alumno
     * @return boolean
     */
    static boolean esInscrito(ArrayList<Alumno> listAlumnos, Alumno a) {
        if (listAlumnos.contains(a)) {
            return true;
        }
        return false;
    }

    /**
     * Este método comprueba que el alumno no exista y en ese caso lo inscribe
     * en el deporte y en alumnos
     *
     * @param a un objeto Alumno
     * @param destino String con el nombre del fichero de destino
     */
    static void inscribirAlumno(Alumno a, String destino) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        File destinoFile = selectorArchivo(destino); //uso el método selectorDeporte para que me dé el File
        ArrayList<Alumno> listAlumnosLeidos = leerArchivo(selectorArchivo("alumnos"));;
        //leo todos los alumnos anteriores, compruebo que no exista el nuevo alumno
        if (esInscrito(listAlumnosLeidos, a)) {
            JOptionPane.showMessageDialog(null, "El alumno ya está inscrito");
        } else {
            try {
                listAlumnosLeidos.add(a);

                fw = new FileWriter(selectorArchivo("alumnos"));
                bw = new BufferedWriter(fw);

                for (int i = 0; i < listAlumnosLeidos.size(); i++) {
                    bw.write(listAlumnosLeidos.get(i).toString());
                    bw.newLine();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al encontrar el archivo " + ex.getMessage());
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar el archivo " + ex.getMessage());
                }
            }

            //separo en dos try distintos para asegurarme que el buffer se cierra en cada iteración
            try {
                listAlumnosLeidos = leerArchivo(destinoFile);
                fw = new FileWriter(destinoFile);
                bw = new BufferedWriter(fw);

                listAlumnosLeidos.add(a);

                for (int i = 0; i < listAlumnosLeidos.size(); i++) {
                    bw.write(listAlumnosLeidos.get(i).toString()); //obtengo el alumno de la lista y lo imprimo en el archivo
                    bw.newLine();
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al encontrar el archivo " + ex.getMessage());
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar el archivo " + ex.getMessage());
                }
            }
        }
    }

    /**
     * Escribe en un archivo los deportes
     *
     * @param listDeportes ArrayList Deporte
     * @param destino String
     */
    static void escribirArchivo(ArrayList<Deporte> listDeportes, File destino) {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(destino);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < listDeportes.size(); i++) {
                bw.write(listDeportes.get(i).toString() + ";");
                bw.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el archivo " + ex.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo " + ex.getMessage());
            }
        }
    }

    static void escribirDeportesDisp(ArrayList<String> listDeportes, File destino) {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(destino);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < listDeportes.size(); i++) {
                bw.write(listDeportes.get(i) + ";");
                bw.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el archivo " + ex.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo " + ex.getMessage());
            }
        }
    }

    /**
     * Borra un alumno de las jornadas esportivas
     *
     * @param je JornadaEsportiva
     * @param a Alumno
     */
    static void borrarAlumno(JornadaEsportiva je, Alumno a) {
        ArrayList<Alumno> listAlumn = leerArchivo(selectorArchivo("alumnos"));

        if (listAlumn.contains(a)) {
            listAlumn.remove(a);
            sobreescribirTodosLosAlumnos(listAlumn, "alumnos");
            for (Deporte deporte : je.getListDeportes()) {
                if (esInscrito(deporte.getListAlumnos(), a)) {
                    listAlumn = deporte.getListAlumnos();
                    listAlumn.remove(a);
                    sobreescribirTodosLosAlumnos(listAlumn, deporte.toString());
                    deporte.setListAlumnos(listAlumn);
                    JOptionPane.showMessageDialog(null, "Alumno borrado de: " + deporte.toString());
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El alumno no está inscrito");
        }

    }

    /**
     * Soobreescribe todos los alumnos de un fichero No uso un for y el método
     * inscribirAlumno ya que eso crearía demasiadas escrituras en disco
     *
     * @param listAlumn alumnos a inscribir
     * @param destino string del destino
     */
    static void sobreescribirTodosLosAlumnos(ArrayList<Alumno> listAlumn, String destino) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        File destinoFile = selectorArchivo(destino);
        try {
            fw = new FileWriter(destinoFile);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < listAlumn.size(); i++) {
                bw.write(listAlumn.get(i).toString());
                bw.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el archivo " + ex.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo " + ex.getMessage());
            }
        }
    }

    /**
     * Lee todos los deportes disponibles en la jornada esportiva.
     *
     * @return listDeportes ArrayList<String> con los deportes disponibles
     */
    static ArrayList<String> leerDeportes() {
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<String> listDeportes = new ArrayList<>();

        try {
            fr = new FileReader(selectorArchivo("jornada esportiva"));
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String deportes[] = linea.split(";");
                for (int i = 0; i < deportes.length; i++) {
                    listDeportes.add(deportes[i]);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el archivo " + ex.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo " + ex.getMessage());
            }
        }
        return listDeportes;
    }

    /**
     * Selector al que le pasas un String con el nombre y te devuelve el File
     * correspondiente.
     *
     * @param archivo
     * @return File. null if it doesn't exist
     */
    static File selectorArchivo(String archivo) {
        Principal p = new Principal(true); //para evitar el error de StackOverflow y al no poder obtener getters estáticos

        switch (archivo.toLowerCase()) {
            case "futbol":
                // return Principal.futbolFile;
                return p.futbolFile;
            case "básquet":
                return p.basquetFile;
            case "futbol sala":
                return p.salaFile;
            case "vóley playa":
                return p.voleyFile;
            case "bádminton":
                return p.badmintonFile;
            case "alumnos":
                return p.alumnosFile;
            case "jornada esportiva":
                return p.jornadaEspFile;
            case "directorio":
                return p.directorio;
            default:
                return null; //si no es ninguno de esos devuelve nulo y salta la excepción del trycatch
        }
    }
}
