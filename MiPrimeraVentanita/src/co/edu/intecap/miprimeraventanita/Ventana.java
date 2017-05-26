/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.miprimeraventanita;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Capacitaciones_pc01
 */
public class Ventana extends JFrame{

    public Ventana() throws HeadlessException {
        initComponents();
    }

    public Ventana(String string) throws HeadlessException {
        super(string);
        initComponents();
    }

    private void initComponents() {
        // configuracion por defecto para el cierre de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 450);
        
    }
    
    public static void main(String... args){
        Ventana miVentanita = new Ventana("Esta es mi primera Ventanita");
        miVentanita.setVisible(true);
    }
    
}
