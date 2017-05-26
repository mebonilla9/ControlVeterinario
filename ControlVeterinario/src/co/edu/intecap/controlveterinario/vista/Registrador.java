/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.controlveterinario.vista;

import co.edu.intecap.controlveterinariolibreria.Mascota;
import co.edu.intecap.controlveterinariolibreria.mascotas.Gato;
import co.edu.intecap.controlveterinariolibreria.mascotas.Perro;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Capacitaciones_pc01
 */
public class Registrador extends javax.swing.JDialog {

    private ArrayList<Perro> listaPerros;
    private ArrayList<Gato> listaGatos;

    private Principal ventanaPrincipal;

    /**
     * Creates new form Registrador
     *
     * @param parent
     * @param modal
     */
    public Registrador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        asignarGrupoMascotas();
        asignarEventos();
    }

    public Registrador(Frame parent, boolean modal, ArrayList<Perro> listaPerros,
            ArrayList<Gato> listaGatos, Principal ventanaPrincipal) {
        super(parent, modal);
        initComponents();
        this.listaPerros = listaPerros;
        this.listaGatos = listaGatos;
        this.ventanaPrincipal = ventanaPrincipal;
        asignarGrupoMascotas();
        asignarEventos();
    }

    private void asignarGrupoMascotas() {
        rbgMascotas.add(rbPerro);
        rbgMascotas.add(rbGato);
    }

    /**
     * Metodo que crea los orejones de los eventos para botones o componentes
     */
    private void asignarEventos() {
        ActionListener orejonRadioButtons = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JRadioButton botonSeleccionado = (JRadioButton) ae.getSource();
                if (botonSeleccionado.equals(rbPerro)) {
                    plPerro.setVisible(true);
                    plGato.setVisible(false);
                } else {
                    plPerro.setVisible(false);
                    plGato.setVisible(true);
                }
            }
        };
        rbPerro.addActionListener(orejonRadioButtons);
        rbGato.addActionListener(orejonRadioButtons);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgMascotas = new javax.swing.ButtonGroup();
        rbPerro = new javax.swing.JRadioButton();
        rbGato = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDueno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTamano = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboGenero = new javax.swing.JComboBox<>();
        plPerro = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        cbxCola = new javax.swing.JCheckBox();
        cbxOrejas = new javax.swing.JCheckBox();
        plGato = new javax.swing.JPanel();
        cbxPelo = new javax.swing.JCheckBox();
        cbxGarras = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rbPerro.setText("Perro");

        rbGato.setText("Gato");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Dueño:");

        jLabel3.setText("Peso:");

        jLabel4.setText("Tamaño:");

        jLabel5.setText("Edad:");

        jLabel6.setText("Raza:");

        jLabel7.setText("Genero:");

        cboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un genero", "Macho", "Hembra" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDueno)
                            .addComponent(txtNombre)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRaza)
                            .addComponent(txtEdad)
                            .addComponent(txtPeso)
                            .addComponent(txtTamano))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDueno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        plPerro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel8.setText("Color:");

        txtColor.setEditable(false);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        cbxCola.setText("Cola larga");

        cbxOrejas.setText("Orejas cortadas");

        javax.swing.GroupLayout plPerroLayout = new javax.swing.GroupLayout(plPerro);
        plPerro.setLayout(plPerroLayout);
        plPerroLayout.setHorizontalGroup(
            plPerroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plPerroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plPerroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(plPerroLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtColor))
                    .addComponent(cbxCola)
                    .addComponent(cbxOrejas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
        );
        plPerroLayout.setVerticalGroup(
            plPerroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plPerroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plPerroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCola)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxOrejas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        plGato.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cbxPelo.setText("Pelo largo");

        cbxGarras.setText("Garras largas");

        javax.swing.GroupLayout plGatoLayout = new javax.swing.GroupLayout(plGato);
        plGato.setLayout(plGatoLayout);
        plGatoLayout.setHorizontalGroup(
            plGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plGatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxPelo)
                    .addComponent(cbxGarras))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plGatoLayout.setVerticalGroup(
            plGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plGatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxPelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxGarras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbPerro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbGato))
                    .addComponent(plPerro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plGato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPerro)
                    .addComponent(rbGato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plPerro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plGato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (cboGenero.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un genero a la mascota", "Registro de mascota", JOptionPane.ERROR_MESSAGE);
                return;
            }
            /**
             * si el if anterior no se cumple se continua la ejecucion de las
             * siguientes lineas de codigo
             */
            if (rbPerro.isSelected()) {
                registrarPerro();
            } else if (rbGato.isSelected()) {
                registrarGato();
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de mascota", "Registro de mascota", JOptionPane.WARNING_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "La mascota se ha registrado correctamente", "Registro de mascota", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            ventanaPrincipal.refrescarListas();
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No ha sido posible registrar la mascota, contacte al administrador");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        Color colorSeleccionado = JColorChooser.showDialog(this, "Seleccionar color Perro", Color.white);
        txtColor.setBackground(colorSeleccionado);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void registrarPerro() {
        Perro nuevoPerro = (Perro) registrarMascota();
        nuevoPerro.color = txtColor.getBackground().toString();
        nuevoPerro.cola = cbxCola.isSelected();
        nuevoPerro.orejas = cbxOrejas.isSelected();
        listaPerros.add(nuevoPerro);
    }

    private void registrarGato() {
        Gato nuevoGato = (Gato) registrarMascota();
        nuevoGato.pelo = cbxPelo.isSelected();
        nuevoGato.garras = cbxGarras.isSelected();
        listaGatos.add(nuevoGato);
    }

    private Mascota registrarMascota() {
        Mascota nuevaMascota = null;
        if (rbPerro.isSelected()) {
            nuevaMascota = new Perro();
        } else if (rbGato.isSelected()) {
            nuevaMascota = new Gato();
        }
        nuevaMascota.setNombre(txtNombre.getText());
        nuevaMascota.dueno = txtDueno.getText();
        nuevaMascota.setPeso(Double.parseDouble(txtPeso.getText()));
        nuevaMascota.setTamano(Double.parseDouble(txtTamano.getText()));
        nuevaMascota.setEdad(Integer.parseInt(txtEdad.getText()));
        nuevaMascota.raza = txtRaza.getText();
        nuevaMascota.genero = cboGenero.getSelectedItem().toString().charAt(0);
        return nuevaMascota;
    }
    
    private void limpiarCampos() {
        rbgMascotas.clearSelection();
        txtNombre.setText("");
        txtDueno.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtRaza.setText("");
        txtTamano.setText("");
        cboGenero.setSelectedIndex(0);
        txtColor.setBackground(Color.WHITE);
        cbxCola.setSelected(false);
        cbxOrejas.setSelected(false);
        cbxPelo.setSelected(false);
        cbxGarras.setSelected(false);
        plPerro.setVisible(true);
        plGato.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(Registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registrador dialog = new Registrador(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JCheckBox cbxCola;
    private javax.swing.JCheckBox cbxGarras;
    private javax.swing.JCheckBox cbxOrejas;
    private javax.swing.JCheckBox cbxPelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel plGato;
    private javax.swing.JPanel plPerro;
    private javax.swing.JRadioButton rbGato;
    private javax.swing.JRadioButton rbPerro;
    private javax.swing.ButtonGroup rbgMascotas;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDueno;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRaza;
    private javax.swing.JTextField txtTamano;
    // End of variables declaration//GEN-END:variables
}