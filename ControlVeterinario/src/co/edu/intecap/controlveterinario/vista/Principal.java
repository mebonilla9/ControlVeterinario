/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.controlveterinario.vista;

import co.edu.intecap.controlveterinariolibreria.Mascota;
import co.edu.intecap.controlveterinariolibreria.mascotas.Gato;
import co.edu.intecap.controlveterinariolibreria.mascotas.Perro;
import co.edu.intecap.controlveterinariolibreria.util.ArchivoUtil;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Capacitaciones_pc01
 */
public class Principal extends javax.swing.JFrame {

    private ArrayList<Perro> listaPerros;
    private ArrayList<Gato> listaGatos;
    
    private Perro perroSeleccionado;
    private Gato gatoSeleccionado;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        asignarEventos();
        try {
            listaPerros = new ArchivoUtil().leerPerros();
            listaGatos = new ArchivoUtil().leerGatos();
            refrescarListas();
        } catch (IOException e) {
            listaPerros = new ArrayList<>();
            listaGatos = new ArrayList<>();
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "El origen de datos no existe "
                    + "o no tiene permisos para accederlo", "Carga de datos de "
                    + "mascotas", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarEventos() {
        ListSelectionListener selectorMascota = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                /**
                 * Determinar con un switch que lista disparo el evento de cambio
                 */
                JList<String> listaSeleccionada = (JList<String>) lse.getSource();
                if (listaSeleccionada.equals(lstPerros)) {
                    // obtener el perro seleccionado del array list con el indice
                    // del jlist, y guardarlo en el perro seleccionado
                    perroSeleccionado = listaPerros.get(lstPerros.getSelectedIndex());
                    // hacer nulo el gato seleccionado
                    gatoSeleccionado = null;
                    // limpiar la seleccion del panel opuesto
                    lstGatos.clearSelection();
                } else if(listaSeleccionada.equals(lstGatos)){
                    // obtener el gato seleccionado del array list con el indice
                    // del jlist, y guardarlo en el gato seleccionado
                    gatoSeleccionado = listaGatos.get(lstGatos.getSelectedIndex());
                    // hacer nulo el perro seleccionado
                    perroSeleccionado = null;
                    // limpiar la seleccion del panel opuesto
                    lstPerros.clearSelection();
                }
                refrescarPanelInformacion();
            }
        };
        lstPerros.addListSelectionListener(selectorMascota);
        lstGatos.addListSelectionListener(selectorMascota);
        
    }
    
    public void refrescarListas() {
        /**
         * Crear los listModel para las listas de perros y gatos
         */

        // Perros
        DefaultListModel<String> modeloPerros = new DefaultListModel<>();
        for (int i = 0; i < listaPerros.size(); i++) {
            Perro perroCargar = listaPerros.get(i);
            modeloPerros.addElement(perroCargar.getNombre() + " - " + perroCargar.dueno);
        }
        lstPerros.setModel(modeloPerros);

        DefaultListModel<String> modeloGatos = new DefaultListModel<>();
        for (int i = 0; i < listaGatos.size(); i++) {
            Gato gatoCargar = listaGatos.get(i);
            modeloGatos.addElement(gatoCargar.getNombre() + " - " + gatoCargar.dueno);
        }
        lstGatos.setModel(modeloGatos);
    }
    
    private void refrescarPanelInformacion(){
        Mascota mascotaSeleccionada = null;
        if (perroSeleccionado != null) {
            mascotaSeleccionada = perroSeleccionado;
            cbxCola.setSelected(perroSeleccionado.cola);
            cbxOrejas.setSelected(perroSeleccionado.orejas);
            txtColor.setBackground(Color.getColor(perroSeleccionado.color));
            cbxPelo.setSelected(false);
            cbxGarras.setSelected(false);
            btnLadrar.setEnabled(true);
            btnMarcar.setEnabled(true);
            btnOlfatear.setEnabled(true);
            btnMaullar.setEnabled(false);
            btnCazar.setEnabled(false);
            btnRonronear.setEnabled(false);
        } else if(gatoSeleccionado != null){
            mascotaSeleccionada = gatoSeleccionado;
            cbxPelo.setSelected(gatoSeleccionado.pelo);
            cbxGarras.setSelected(gatoSeleccionado.garras);
            cbxCola.setSelected(false);
            cbxOrejas.setSelected(false);
            txtColor.setBackground(Color.GRAY);
            btnLadrar.setEnabled(false);
            btnMarcar.setEnabled(false);
            btnOlfatear.setEnabled(false);
            btnMaullar.setEnabled(true);
            btnCazar.setEnabled(true);
            btnRonronear.setEnabled(true);
        }
        txtNombre.setText(mascotaSeleccionada.getNombre());
        txtDueno.setText(mascotaSeleccionada.dueno);
        txtPeso.setText(mascotaSeleccionada.getPeso()+"");
        txtTamano.setText(mascotaSeleccionada.getTamano()+"");
        txtEdad.setText(mascotaSeleccionada.getEdad()+"");
        txtRaza.setText(mascotaSeleccionada.raza);
        txtGenero.setText(mascotaSeleccionada.genero+"");
        lblEnergia.setText("Energia: "+mascotaSeleccionada.getEnergia()+"%");
        lblSalud.setText("Salud: "+mascotaSeleccionada.getSalud()+"%");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPerros = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstGatos = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnDormir = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        btnVacunar = new javax.swing.JButton();
        btnBeber = new javax.swing.JButton();
        btnComer = new javax.swing.JButton();
        btnDefecar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnLadrar = new javax.swing.JButton();
        btnMarcar = new javax.swing.JButton();
        btnOlfatear = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnCazar = new javax.swing.JButton();
        btnMaullar = new javax.swing.JButton();
        btnRonronear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDueno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTamano = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        cbxCola = new javax.swing.JCheckBox();
        cbxOrejas = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        cbxPelo = new javax.swing.JCheckBox();
        cbxGarras = new javax.swing.JCheckBox();
        lblEnergia = new javax.swing.JLabel();
        lblSalud = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miRegistrar = new javax.swing.JMenuItem();
        miGuardar = new javax.swing.JMenuItem();
        miSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lstPerros.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstPerros);

        jLabel10.setText("Mascotas registradas");

        lstGatos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstGatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Actividades");

        btnDormir.setText("Dormir");

        btnJugar.setText("Jugar");

        btnVacunar.setText("Vacunar");

        btnBeber.setText("Beber");

        btnComer.setText("Comer");

        btnDefecar.setText("Defecar");

        btnLadrar.setText("Ladrar");

        btnMarcar.setText("Marcar");

        btnOlfatear.setText("Olfatear");

        btnCazar.setText("Cazar");

        btnMaullar.setText("Maullar");

        btnRonronear.setText("Ronronear");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnLadrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMarcar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnOlfatear))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnDormir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnJugar))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnBeber)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnComer)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVacunar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDefecar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCazar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMaullar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRonronear))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDormir)
                    .addComponent(btnJugar)
                    .addComponent(btnVacunar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBeber)
                    .addComponent(btnDefecar)
                    .addComponent(btnComer))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLadrar)
                    .addComponent(btnMarcar)
                    .addComponent(btnOlfatear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCazar)
                    .addComponent(btnMaullar)
                    .addComponent(btnRonronear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nombre:");

        txtNombre.setEditable(false);

        jLabel2.setText("Dueño:");

        txtDueno.setEditable(false);

        jLabel3.setText("Peso:");

        txtPeso.setEditable(false);

        jLabel4.setText("Tamaño:");

        txtTamano.setEditable(false);

        jLabel5.setText("Edad:");

        txtEdad.setEditable(false);

        jLabel6.setText("Raza:");

        txtRaza.setEditable(false);

        jLabel7.setText("Genero:");

        txtGenero.setEditable(false);

        jLabel9.setText("Información de la mascota");

        jLabel11.setText("Color:");

        txtColor.setEditable(false);

        cbxCola.setText("Cola larga");
        cbxCola.setEnabled(false);

        cbxOrejas.setText("Orejas Cortadas");
        cbxOrejas.setEnabled(false);

        cbxPelo.setText("Pelo Largo");
        cbxPelo.setEnabled(false);

        cbxGarras.setText("Garras Largas");
        cbxGarras.setEnabled(false);

        lblEnergia.setText("Energia");

        lblSalud.setText("Salud");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtDueno))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGenero)
                            .addComponent(txtRaza)
                            .addComponent(txtEdad)
                            .addComponent(txtTamano)
                            .addComponent(txtPeso)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbxCola)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxOrejas))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(33, 33, 33)
                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxPelo)
                                    .addComponent(lblEnergia))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSalud)
                                    .addComponent(cbxGarras))))
                        .addGap(0, 148, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDueno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCola)
                    .addComponent(cbxOrejas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxGarras)
                    .addComponent(cbxPelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnergia)
                    .addComponent(lblSalud))
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        miRegistrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        miRegistrar.setText("Registrar");
        miRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarActionPerformed(evt);
            }
        });
        jMenu1.add(miRegistrar);

        miGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miGuardar.setText("Guardar");
        miGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(miGuardar);

        miSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        miSalir.setText("Salir");
        jMenu1.add(miSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarActionPerformed
        new Registrador(this, true, listaPerros, listaGatos, this).setVisible(true);
    }//GEN-LAST:event_miRegistrarActionPerformed

    private void miGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarActionPerformed
        try {
            new ArchivoUtil().escribirPerros(listaPerros);
            new ArchivoUtil().escribirGatos(listaGatos);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "La aplicacion no tiene permisos "
                    + "para guardar la información", "Carga de datos de "
                    + "mascotas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miGuardarActionPerformed

    /**
     * @param args the command line arguments
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBeber;
    private javax.swing.JButton btnCazar;
    private javax.swing.JButton btnComer;
    private javax.swing.JButton btnDefecar;
    private javax.swing.JButton btnDormir;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnLadrar;
    private javax.swing.JButton btnMarcar;
    private javax.swing.JButton btnMaullar;
    private javax.swing.JButton btnOlfatear;
    private javax.swing.JButton btnRonronear;
    private javax.swing.JButton btnVacunar;
    private javax.swing.JCheckBox cbxCola;
    private javax.swing.JCheckBox cbxGarras;
    private javax.swing.JCheckBox cbxOrejas;
    private javax.swing.JCheckBox cbxPelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblEnergia;
    private javax.swing.JLabel lblSalud;
    private javax.swing.JList<String> lstGatos;
    private javax.swing.JList<String> lstPerros;
    private javax.swing.JMenuItem miGuardar;
    private javax.swing.JMenuItem miRegistrar;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDueno;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRaza;
    private javax.swing.JTextField txtTamano;
    // End of variables declaration//GEN-END:variables
}
