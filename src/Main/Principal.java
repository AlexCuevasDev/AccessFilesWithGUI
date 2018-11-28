package Main;

import Clases.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Constructor vacío, inicializa rutas,archivos...
     */
    public Principal() {
        initComponents();

        inicializarRutasArchivos();
        crearArchivosSiNoExisten();
        jornadaEsportiva = Utilidades.getJornadaEsportiva(deportesDisponibles);
        mostrarAlumnosInscritos();
        esconderTxtBtn();
    }

    /**
     * Solución para que no cree un stackOverFlow al necesitar un método de esta
     * clase no estático
     *
     * @param bool
     */
    public Principal(boolean bool) {
        inicializarRutasArchivos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRespuesta = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlumnos = new javax.swing.JTable();
        lbMain = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuVer = new javax.swing.JMenu();
        menuInscritos = new javax.swing.JMenuItem();
        menuAlumnosDeporte = new javax.swing.JMenuItem();
        menuAlumnosPorCurso = new javax.swing.JMenuItem();
        menuDeportes = new javax.swing.JMenuItem();
        menuAlumno = new javax.swing.JMenu();
        menuInscribir = new javax.swing.JMenuItem();
        menuBorrarAlumno = new javax.swing.JMenuItem();
        menuCompararTxt = new javax.swing.JMenuItem();
        menuDeporte = new javax.swing.JMenu();
        menuAddDeporte = new javax.swing.JMenuItem();
        menuEliminarDeporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        tableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Curso", "Sexo", "Edad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAlumnos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableAlumnos);

        lbMain.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        menuVer.setText("Ver");

        menuInscritos.setText("Alumnos inscritos");
        menuInscritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInscritosActionPerformed(evt);
            }
        });
        menuVer.add(menuInscritos);

        menuAlumnosDeporte.setText("Alumnos por deporte");
        menuAlumnosDeporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlumnosDeporteActionPerformed(evt);
            }
        });
        menuVer.add(menuAlumnosDeporte);

        menuAlumnosPorCurso.setText("Alumnos en un curso determinado");
        menuAlumnosPorCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlumnosPorCursoActionPerformed(evt);
            }
        });
        menuVer.add(menuAlumnosPorCurso);

        menuDeportes.setText("Deportes");
        menuDeportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeportesActionPerformed(evt);
            }
        });
        menuVer.add(menuDeportes);

        jMenuBar1.add(menuVer);

        menuAlumno.setText("Alumno");

        menuInscribir.setText("Inscribir alumno");
        menuInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInscribirActionPerformed(evt);
            }
        });
        menuAlumno.add(menuInscribir);

        menuBorrarAlumno.setText("Borrar inscripción de un alumno");
        menuBorrarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBorrarAlumnoActionPerformed(evt);
            }
        });
        menuAlumno.add(menuBorrarAlumno);

        menuCompararTxt.setText("Comparar alumnos inscritos con un txt");
        menuCompararTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCompararTxtActionPerformed(evt);
            }
        });
        menuAlumno.add(menuCompararTxt);

        jMenuBar1.add(menuAlumno);

        menuDeporte.setText("Deporte");

        menuAddDeporte.setText("Añadir deporte");
        menuAddDeporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddDeporteActionPerformed(evt);
            }
        });
        menuDeporte.add(menuAddDeporte);

        menuEliminarDeporte.setText("Eliminar deporte");
        menuEliminarDeporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarDeporteActionPerformed(evt);
            }
        });
        menuDeporte.add(menuEliminarDeporte);

        jMenuBar1.add(menuDeporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMain, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(btnOk)
                    .addComponent(lbMain))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Le pone un Listener a InscribirAlumno para que refresque la página al
     * cerrarse
     *
     * @param evt
     */
    private void menuInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInscribirActionPerformed
        InscribirAlumno ia = new InscribirAlumno();
        ia.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ia.setVisible(true);

        ia.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                if (estado != null) {
                    if (estado.equals("alumnosInscritos")) {
                        menuInscritosActionPerformed(evt); //llamo al método menuInscritos para que vuelva a cargar los alumnos inscritos
                    } else if (estado.equals("alumnosXCurso")) {
                        btnOkActionPerformed(evt); //llamo a este método para que vuelva a cargar los alumnos de un curso
                    } else if (estado.equals("alumnosEnDeportes")) {
                        verAlumnosXDeporte();
                    } else if (estado.equals("deportes")) {
                        verDeportes();
                    }
                }
                estado = "";
            }
        });
    }//GEN-LAST:event_menuInscribirActionPerformed

    private void menuInscritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInscritosActionPerformed
        mostrarAlumnosInscritos();
    }//GEN-LAST:event_menuInscritosActionPerformed

    private void esconderTxtBtn() {
        txtRespuesta.setVisible(false);
        btnOk.setVisible(false);
    }

    /**
     * Muestra todos los alumnos inscritos.
     */
    public void mostrarAlumnosInscritos() {
        lbMain.setText("Mostrando todos los alumnos inscritos...");
        ArrayList<Alumno> listAlumnosInscritos = new ArrayList<>(); //= Utilidades.leerArchivo(alumnosFile);
        for (Deporte deporte : jornadaEsportiva.getListDeportes()) {
            listAlumnosInscritos.addAll(deporte.getListAlumnos());
        }
        estado = "alumnosInscritos";
        borrarPantalla();
        escribirAlumnosEnPantalla(listAlumnosInscritos);
    }

    /**
     * Este método te deja escoger un .txt para compararlo con los alumnos
     * inscritos y te imprime los que faltan.
     */
    public void getFileFromChooser() {
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Texto", "txt");
        selector.setFileFilter(filtro);
        File ruta = new File(System.getProperty("user.dir"));
        selector.setCurrentDirectory(ruta);
        int boton = selector.showOpenDialog(this);
        if (boton == JFileChooser.APPROVE_OPTION) {
            ArrayList<Alumno> listAlumPasados = Utilidades.leerArchivo(selector.getSelectedFile());
            ArrayList<Alumno> listAlumInscritos = Utilidades.leerArchivo(alumnosFile);
            ArrayList<Alumno> listAlumNoInscritos = new ArrayList<>();
            for (Alumno alumno : listAlumPasados) {
                if (!Utilidades.esInscrito(listAlumInscritos, alumno)) {
                    listAlumNoInscritos.add(alumno);
                }
            }

            lbMain.setText("Mostrando alumnos que faltan por inscribir...");
            borrarPantalla();
            escribirAlumnosEnPantalla(listAlumNoInscritos);
        }

    }

    /**
     * Escribe los alumnos pasados por parámetro en pantalla
     *
     * @param listAlumnos
     */
    public void escribirAlumnosEnPantalla(ArrayList<Alumno> listAlumnos) {
        menuEliminarDeporte.setEnabled(false);
        menuBorrarAlumno.setEnabled(true);

        JTableHeader th = tableAlumnos.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setHeaderValue("Nombre");
        tc = tcm.getColumn(1);
        tc.setHeaderValue("Apellidos");
        tc = tcm.getColumn(2);
        tc.setHeaderValue("Curso");
        tc = tcm.getColumn(3);
        tc.setHeaderValue("Sexo");
        tc = tcm.getColumn(4);
        tc.setHeaderValue("Edad");
        DefaultTableModel model = (DefaultTableModel) tableAlumnos.getModel();
        for (Alumno alumno : listAlumnos) {
            String alumno1[] = alumno.toString().split(";");
            model.addRow(alumno1);
        }
    }

    /**
     *
     */
    public void borrarPantalla() {
        DefaultTableModel model = (DefaultTableModel) tableAlumnos.getModel();
        model.setRowCount(0);
    }

    /**
     *
     */
    public void mostrarTxtBox() {
        txtRespuesta.setText("");
        txtRespuesta.setEnabled(true);
        txtRespuesta.setVisible(true);
    }

    /**
     * Obtiene todos los alumnos en los deportes de la jornada esportiva pasada
     * por parámetro Y los imprime ordenados
     *
     * @param jornadaEsportiva JornadaEsportiva
     */
    public void getAllAlumnosXDeportes(JornadaEsportiva jornadaEsportiva) {
        ArrayList<Alumno> listAlumnos;
        ArrayList<Deporte> listDeportes = jornadaEsportiva.getListDeportes();
        DefaultTableModel model = (DefaultTableModel) tableAlumnos.getModel();

        for (Deporte deporte : listDeportes) {
            listAlumnos = Utilidades.ordenarAlumnosASC(deporte.getListAlumnos());
            String stringDeporte[] = {deporte.toString().toUpperCase(), "", "", "", ""};
            model.addRow(stringDeporte);
            escribirAlumnosEnPantalla(listAlumnos);
        }
    }

    /**
     * borra un deporte pasado por parámetro de las jornadas esportivas, los
     * ficheros y te muestra los alumnos que han sido borrados.
     *
     * @param deporte String
     */
    public void borrarDeporte(String deporte) {
        ArrayList<Deporte> listDeportes = jornadaEsportiva.getListDeportes();

        for (int i = 0; i < listDeportes.size(); i++) {
            if (listDeportes.get(i).toString().equals(deporte)) {
                listDeportes.remove(i);
            }
        }
        deportesDisponibles.remove(deporte);
        Utilidades.escribirArchivo(listDeportes, jornadaEspFile);
        borrarPantalla();
        lbMain.setText("Mostrando alumnos borrados...");
        ArrayList<Alumno> listAlumn = Utilidades.leerArchivo(alumnosFile);
        ArrayList<Alumno> listAlumnBorrados = Utilidades.leerArchivo(Utilidades.selectorArchivo(deporte));
        listAlumn.removeAll(listAlumnBorrados);
        Utilidades.sobreescribirTodosLosAlumnos(listAlumn, "alumnos");
        escribirAlumnosEnPantalla(listAlumnBorrados);
        Utilidades.borrarFicheroDeporte(deporte);
    }

    /**
     * Vuelve a añadir un deporte a las jornadas esportivas nota: futbol y
     * futbol sala deben introducirse sin tilde
     */
    public void addDeporte() {
        String deporte = JOptionPane.showInputDialog(null, "Qué deporte deseas añadir?");
        if (!deportesDisponibles.contains(deporte)) {
            deportesDisponibles.add(deporte);
            if (Utilidades.selectorArchivo(deporte).exists()) {
                Utilidades.selectorArchivo(deporte).delete();
            }
            Utilidades.escribirDeportesDisp(deportesDisponibles, jornadaEspFile);
            try {
                Utilidades.selectorArchivo(deporte).createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar la ruta al archivo");
            }
            jornadaEsportiva = Utilidades.getJornadaEsportiva(deportesDisponibles);
            if (estado.equals("deportes")) {
                verDeportes();
                estado = "";
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ese deporte ya existe");
        }
    }

    /**
     * Muestra los deportes disponibles
     */
    public void verDeportes() {
        jornadaEsportiva = Utilidades.getJornadaEsportiva(deportesDisponibles);

        DefaultTableModel model = (DefaultTableModel) tableAlumnos.getModel();
        ArrayList<Deporte> listDeportes = jornadaEsportiva.getListDeportes();
        ArrayList<String[]> listEscribir = new ArrayList<>(); //hago esta lista porque el constructor de filas de la jTable me acepta strings
        for (Deporte deporte : listDeportes) {
            String stringDeportes[] = {deporte.toString().toUpperCase(), "" + deporte.getListAlumnos().size(), "" + deporte.esJugable(), "", ""};
            listEscribir.add(stringDeportes);
        }
        borrarPantalla();
        for (String[] linea : listEscribir) {
            model.addRow(linea);
        }
    }

    /**
     * tengo la variable estado que marca qué opcion ha seleccionado el usuario
     * según esta variable el botón realiza una función u otra.
     *
     * @param evt
     */
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (estado != null) {
            if (estado.equals("alumnosXCurso")) {
                if (!txtRespuesta.getText().equals("")) {
                    respuesta = txtRespuesta.getText();
                }
                ArrayList<Alumno> listAlumnosXCurso = Utilidades.getAlumnosXCurso(respuesta);
                borrarPantalla();
                escribirAlumnosEnPantalla(listAlumnosXCurso);
                esconderTxtBtn();
            }
        }
    }//GEN-LAST:event_btnOkActionPerformed
    /**
     * Llama a btnOk para mostrar los alumnos según el curso
     *
     * @param evt
     */
    private void menuAlumnosPorCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlumnosPorCursoActionPerformed
        estado = "alumnosXCurso";
        lbMain.setText("Selecciona el curso");
        txtRespuesta.setText("");
        txtRespuesta.setVisible(true);
        btnOk.setVisible(true);
    }//GEN-LAST:event_menuAlumnosPorCursoActionPerformed

    private void menuAlumnosDeporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlumnosDeporteActionPerformed
        lbMain.setText("Mostrando los alumnos en cada deporte ordenados por nombre");
        verAlumnosXDeporte();
    }//GEN-LAST:event_menuAlumnosDeporteActionPerformed
    /**
     * Implementa un método de utilidades para imprimir los alumnos ordenados
     * alfabéticamente y en su deporte
     */
    private void verAlumnosXDeporte() {
        estado = "alumnosEnDeportes";
        jornadaEsportiva = Utilidades.getJornadaEsportiva(deportesDisponibles);
        borrarPantalla();
        getAllAlumnosXDeportes(jornadaEsportiva);
    }

    /**
     * Muestra los deportes disponibles, los alumnos inscritos a estos y si es
     * jugable.
     *
     * @param evt
     */
    private void menuDeportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeportesActionPerformed
        menuEliminarDeporte.setEnabled(true);
        menuBorrarAlumno.setEnabled(false);
        estado = "deportes";
        lbMain.setText("Viendo los deportes disponibles...");
        JTableHeader th = tableAlumnos.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setHeaderValue("Deporte");
        tc = tcm.getColumn(1);
        tc.setHeaderValue("Alumnos Inscritos");
        tc = tcm.getColumn(2);
        tc.setHeaderValue("Jugable?");
        tc = tcm.getColumn(3);
        tc.setHeaderValue("Null");
        tc = tcm.getColumn(4);
        tc.setHeaderValue("Null");
        verDeportes();
    }//GEN-LAST:event_menuDeportesActionPerformed

    private void menuCompararTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCompararTxtActionPerformed
        getFileFromChooser();
    }//GEN-LAST:event_menuCompararTxtActionPerformed
    /**
     * Borra al alumno selecionado
     *
     * @param evt
     */
    private void menuBorrarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBorrarAlumnoActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableAlumnos.getModel();
        String[] nombreApellido = {"", ""};
        if (tableAlumnos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No hay ningún alumno selecionado.");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Seguro?");
            if (confirm == JOptionPane.YES_OPTION) {
                for (int i = 0; i < 2; i++) {
                    nombreApellido[i] = tableAlumnos.getValueAt(tableAlumnos.getSelectedRow(), i).toString();
                    System.out.println(nombreApellido[i]);
                }
                Alumno alumno = new Alumno(nombreApellido);
                Utilidades.borrarAlumno(jornadaEsportiva, alumno);
                mostrarAlumnosInscritos();
            }
        }
    }//GEN-LAST:event_menuBorrarAlumnoActionPerformed
    /**
     * Borra el deporte selecionado
     *
     * @param evt
     */
    private void menuEliminarDeporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarDeporteActionPerformed

        DefaultTableModel model = (DefaultTableModel) tableAlumnos.getModel();
        if (tableAlumnos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un deporte primero");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Seguro?");
            if (confirm == JOptionPane.YES_OPTION) {
                String deporte = tableAlumnos.getValueAt(tableAlumnos.getSelectedRow(), 0).toString();
                borrarDeporte(deporte.toLowerCase());
            }
        }

    }//GEN-LAST:event_menuEliminarDeporteActionPerformed

    private void menuAddDeporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddDeporteActionPerformed
        addDeporte();
    }//GEN-LAST:event_menuAddDeporteActionPerformed
    /**
     * Inicializa las rutas de los File
     */
    private void inicializarRutasArchivos() {
        directorio = new File("Datos");
        alumnosFile = new File(directorio + File.separator + "Alumnos.txt");
        futbolFile = new File(directorio + File.separator + "Futbol.txt");
        salaFile = new File(directorio + File.separator + "Sala.txt");
        basquetFile = new File(directorio + File.separator + "Basquet.txt");
        badmintonFile = new File(directorio + File.separator + "Badminton.txt");
        voleyFile = new File(directorio + File.separator + "Voley.txt");
        jornadaEspFile = new File(directorio + File.separator + "JornadaEsportiva.txt");
    }

    /**
     * creo los ficheros si no existen y en caso de que existan inicializo los
     * deportes disponibles
     */
    private void crearArchivosSiNoExisten() {
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        try {
            alumnosFile.createNewFile();
            futbolFile.createNewFile();
            salaFile.createNewFile();
            basquetFile.createNewFile();
            badmintonFile.createNewFile();
            voleyFile.createNewFile();
            if (jornadaEspFile.createNewFile()) {
                inicializarVariableDeportes();
                Utilidades.escribirDeportesDisp(deportesDisponibles, jornadaEspFile);
            } else {
                deportesDisponibles = Utilidades.leerDeportes();
                jornadaEsportiva = Utilidades.getJornadaEsportiva(deportesDisponibles);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar");
        }
    }

    /**
     * intenta cargar los deportes de fichero, en caso de no existir lo
     * inicializa por defecto con todos disponibles.
     */
    private void inicializarVariableDeportes() {

        deportesDisponibles.add("futbol");
        deportesDisponibles.add("futbol sala");
        deportesDisponibles.add("básquet");
        deportesDisponibles.add("bádminton");
        deportesDisponibles.add("vóley playa");

        //como jornadaEsportiva necesita ese fichero para inicializarse, no puedo usar .getListDeportes, así que uso un array de strings para crear el fichero.
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getDeportesDisponibles() {
        return deportesDisponibles;
    }

    /**
     *
     * @param deportesDisponibles
     */
    public void setDeportesDisponibles(ArrayList<String> deportesDisponibles) {
        this.deportesDisponibles = deportesDisponibles;
    }

    /**
     *
     * @return
     */
    public File getJornadaEspFile() {
        return jornadaEspFile;
    }

    /**
     *
     * @param jornadaEspFile
     */
    public void setJornadaEspFile(File jornadaEspFile) {
        this.jornadaEspFile = jornadaEspFile;
    }

    /**
     *
     * @return
     */
    public File getDirectorio() {
        return directorio;
    }

    /**
     *
     * @param directorio
     */
    public void setDirectorio(File directorio) {
        this.directorio = directorio;
    }

    /**
     *
     * @return
     */
    public File getAlumnosFile() {
        return alumnosFile;
    }

    /**
     *
     * @param alumnosFile
     */
    public void setAlumnosFile(File alumnosFile) {
        this.alumnosFile = alumnosFile;
    }

    /**
     *
     * @return
     */
    public File getFutbolFile() {
        return futbolFile;
    }

    /**
     *
     * @param futbolFile
     */
    public void setFutbolFile(File futbolFile) {
        this.futbolFile = futbolFile;
    }

    /**
     *
     * @return
     */
    public File getSalaFile() {
        return salaFile;
    }

    /**
     *
     * @param salaFile
     */
    public void setSalaFile(File salaFile) {
        this.salaFile = salaFile;
    }

    /**
     *
     * @return
     */
    public File getBasquetFile() {
        return basquetFile;
    }

    /**
     *
     * @param basquetFile
     */
    public void setBasquetFile(File basquetFile) {
        this.basquetFile = basquetFile;
    }

    /**
     *
     * @return
     */
    public File getBadmintonFile() {
        return badmintonFile;
    }

    /**
     *
     * @param badmintonFile
     */
    public void setBadmintonFile(File badmintonFile) {
        this.badmintonFile = badmintonFile;
    }

    /**
     *
     * @return
     */
    public File getVoleyFile() {
        return voleyFile;
    }

    /**
     *
     * @param voleyFile
     */
    public void setVoleyFile(File voleyFile) {
        this.voleyFile = voleyFile;
    }

    //Hacerlas 'default static' para que puedan accederse desde el package sin necesidad de instanciar un objeto
    File directorio, alumnosFile, futbolFile, salaFile, basquetFile, badmintonFile, voleyFile, jornadaEspFile;
    private String estado, respuesta;
    static ArrayList<String> deportesDisponibles = new ArrayList<>();
    private JornadaEsportiva jornadaEsportiva;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMain;
    private javax.swing.JMenuItem menuAddDeporte;
    private javax.swing.JMenu menuAlumno;
    private javax.swing.JMenuItem menuAlumnosDeporte;
    private javax.swing.JMenuItem menuAlumnosPorCurso;
    private javax.swing.JMenuItem menuBorrarAlumno;
    private javax.swing.JMenuItem menuCompararTxt;
    private javax.swing.JMenu menuDeporte;
    private javax.swing.JMenuItem menuDeportes;
    private javax.swing.JMenuItem menuEliminarDeporte;
    private javax.swing.JMenuItem menuInscribir;
    private javax.swing.JMenuItem menuInscritos;
    private javax.swing.JMenu menuVer;
    private javax.swing.JTable tableAlumnos;
    private javax.swing.JTextField txtRespuesta;
    // End of variables declaration//GEN-END:variables
}
