/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.controlveterinariolibreria;

/**
 *
 * @author Capacitaciones_pc01
 */
public class Mascota {

    public char genero;
    protected double tamano;
    protected int edad; 
    protected int energia;
    protected int salud;
    public String dueno;
    protected String nombre;
    public String raza;
    protected double peso;
    
    public void jugar(){
        if (energia < 20) {
            System.out.println("Estoy muy cansado, no quiero jugar");
            return;
        }
        energia-= 30;
        if (salud < 40) {
            salud -= 5;
        } else if (salud >= 40) {
            salud += 5;
        }
        nivelarEnergiaSalud();
    }
    
    public void dormir(){
        if (salud < 30) {
            System.out.println("No puedo dormir, me siento muy mal");
        } else{
            System.out.println("Zzzzz...!");
            energia += 50;
        }
        nivelarEnergiaSalud();
    }
    
    
    public void vacunar(){
        if (salud < 20) {
            salud = 80;
            System.out.println("Ya me siento mejor");
            return;
        }
        System.out.println("No necesito esa vacuna");
    }
    
    protected void nivelarEnergiaSalud(){
        if (energia < 0) {
            energia = 10;
        } else if(energia > 100){
            energia = 100;
        }
        if (salud < 0) {
            salud = 10;
        } else if(salud > 100){
            salud = 100;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodos de Acceso de la clase">
    /**
     * @return the tamano
     */
    public double getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the energia
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * @param energia the energia to set
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    /**
     * @return the salud
     */
    public int getSalud() {
        return salud;
    }

    /**
     * @param salud the salud to set
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
   
    // </editor-fold>

}
