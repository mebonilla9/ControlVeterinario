/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.controlveterinariolibreria.mascotas;

import co.edu.intecap.controlveterinariolibreria.IAnimal;
import co.edu.intecap.controlveterinariolibreria.Mascota;

/**
 *
 * @author Capacitaciones_pc01
 */
public class Perro extends Mascota implements IAnimal{
    
    public boolean cola;
    public boolean orejas;
    public String color;
    
    public Perro(){
        energia = 100;
        salud = 100;
    }
    
    public Perro(String nombre, String dueno){
        energia = 100;
        salud = 100;
        this.nombre = nombre;
        this.dueno = dueno;
    }
    
    public void ladrar(){
        System.out.println("Guau... Guau... Guau...");
        energia -= 3;
        nivelarEnergiaSalud();
    }
    
    public void marcar(){
        salud -= 1;
        nivelarEnergiaSalud();
    }
    
    public void olfatear(){
        energia -= 5;
        nivelarEnergiaSalud();
    }

    @Override
    public void comer(double comida) {
        peso += comida * 0.15;
    }

    @Override
    public void beber(double agua) {
        peso -= agua * 0.025;
    }

    @Override
    public void defecar() {
        peso -= peso*0.001;
    }

    @Override
    public void jugar() {
        peso *= 0.5;
        super.jugar();
    }
    
    
        
}
