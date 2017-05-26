/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.veterinarioconsola;

import co.appreactor.superteclado.Teclado;
import co.edu.intecap.controlveterinariolibreria.mascotas.Perro;
import java.util.ArrayList;

/**
 *
 * @author Capacitaciones_pc01
 */
public class Principal {

    private static ArrayList<Perro> perrera;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        perrera = new ArrayList<>();
        int opcion = 1;
        while (opcion > 0) {
            opcion = menuUsuario();
            evaluarOpcionUsuario(opcion);
        }
        System.out.println("Gracias por usar la aplicacion, lamentablemente al"
                + "hacerlo los perros se escaparon de la perrera");
    }

    private static int menuUsuario() {
        int opcionUsuario = 0;
        System.out.println("Elija una opcion para continuar:");
        System.out.println("1. Matricular un perro");
        System.out.println("2. Alimentar perro");
        System.out.println("3. Jugar con perro");
        System.out.println("0. Salir del programa");
        opcionUsuario = Teclado.leerNumero();
        return opcionUsuario;
    }

    private static void evaluarOpcionUsuario(int opcion) {
        switch (opcion) {
            case 1:
                matricularPerro();
                break;
            case 2:
                alimentarPerro();
                break;
            case 3:

                break;
            default:
                break;
        }
    }

    private static void matricularPerro() {
        Perro unPerro = new Perro();        
        System.out.println("Digite el nombre del perro");
        unPerro.setNombre(Teclado.leerTexto());
        System.out.println("Digite la raza del perro");
        unPerro.raza = Teclado.leerTexto();
        System.out.println("Digite el nombre del dueño del perro");
        unPerro.dueno = Teclado.leerTexto();
        System.out.println("Digite la edad del perro");
        unPerro.setEdad(Teclado.leerNumero());
        System.out.println("Digite el tamaño del perro en cm");
        unPerro.setTamano(Teclado.leerNumeroDecimal());
        System.out.println("Digite el genero del perro (M,H)");
        unPerro.genero = Teclado.leerCaracter();
        System.out.println("Digite el peso del perro en Kg");
        unPerro.setPeso(Teclado.leerNumeroDecimal());
        System.out.println("Digite el color del perro");
        unPerro.color = Teclado.leerTexto();
        System.out.println("Digite si el perro tiene o no cola (S,N)");
        unPerro.cola = Teclado.leerCaracter() == 's' ? true : false;
        System.out.println("Digita si el perro tiene orejas cortadas o no (S,N)");
        unPerro.orejas = Teclado.leerCaracter() == 's';
        perrera.add(unPerro);
    }

    private static Perro seleccionarPerro() {
        System.out.println("Elija un perro de la perrera");
        for (int i = 0; i < perrera.size(); i++) {
            System.out.println(i + 1 + ". " + perrera.get(i).getNombre());
        }
        int posicionSeleccionada = Teclado.leerNumero();
        return perrera.get(posicionSeleccionada - 1);
    }

    private static void alimentarPerro() {
        Perro miPerro = seleccionarPerro();
        System.out.println("Digite la cantidad de comida a darle al perro");
        miPerro.comer(Teclado.leerNumeroDecimal());
        System.out.println("El Perro ha sido alimentado");
    }

}
