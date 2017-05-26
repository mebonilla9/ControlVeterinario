/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.controlveterinariolibreria.util;

import co.edu.intecap.controlveterinariolibreria.mascotas.Gato;
import co.edu.intecap.controlveterinariolibreria.mascotas.Perro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Capacitaciones_pc01
 */
public class ArchivoUtil {

    private static final String RUTA_ARCHIVOS = System.getProperty("user.home")
            + File.separator + "control_veterinario";

    public ArchivoUtil() {
        File carpetaGuardar = new File(RUTA_ARCHIVOS);
        if (!carpetaGuardar.exists()) {
            carpetaGuardar.mkdir();
        }
    }

    public void escribirPerros(ArrayList<Perro> listaPerros) throws FileNotFoundException {
        String lineaPerros = transformarPerrosLineas(listaPerros);
        PrintStream escritor = new PrintStream(RUTA_ARCHIVOS + "/perros.txt");
        escritor.print(lineaPerros);
        // limpiar el canal
        escritor.flush();
        // cerrar el canal
        escritor.close();
    }

    public void escribirGatos(ArrayList<Gato> listaGatos) throws FileNotFoundException {
        String lineaGatos = transformarGatosLineas(listaGatos);
        PrintStream escritor = new PrintStream(RUTA_ARCHIVOS + "/gatos.txt");
        escritor.print(lineaGatos);
        // limpiar el canal
        escritor.flush();
        // cerrar el canal
        escritor.close();
    }

    public ArrayList<Perro> leerPerros() throws FileNotFoundException, IOException {
        ArrayList<Perro> listaPerros = new ArrayList<>();
        FileInputStream lectorArchivo = new FileInputStream(RUTA_ARCHIVOS + "/perros.txt");
        InputStreamReader conectorLector = new InputStreamReader(lectorArchivo);
        BufferedReader lector = new BufferedReader(conectorLector);

        String contenido;
        String linea = "";
        // validar si el lector devuelve una linea de texto y si lo hace,
        // guardarla en la variable contenido, caso contrario se sale del ciclo
        while ((contenido = lector.readLine()) != null) {
            linea += contenido;
            System.out.println(contenido);
        }
        lector.close();
        listaPerros = transformarLineasPerros(linea);
        return listaPerros;
    }

    public ArrayList<Gato> leerGatos() throws FileNotFoundException, IOException {
        ArrayList<Gato> listaGatos = new ArrayList<>();
        FileInputStream lectorArchivo = new FileInputStream(RUTA_ARCHIVOS + "/gatos.txt");
        InputStreamReader conectorLector = new InputStreamReader(lectorArchivo);
        BufferedReader lector = new BufferedReader(conectorLector);

        String contenido;
        String linea = "";
        // validar si el lector devuelve una linea de texto y si lo hace,
        // guardarla en la variable contenido, caso contrario se sale del ciclo
        while ((contenido = lector.readLine()) != null) {
            linea += contenido;
            System.out.println(contenido);
        }
        lector.close();
        listaGatos = transformarLineasGatos(linea);
        return listaGatos;
    }

    private String transformarPerrosLineas(ArrayList<Perro> listaPerros) {
        StringBuilder sb = new StringBuilder();
        for (Perro miPerro : listaPerros) {
            sb.append(miPerro.getNombre()).append("/");
            sb.append(miPerro.dueno).append("/");
            sb.append(miPerro.getPeso()).append("/");
            sb.append(miPerro.getTamano()).append("/");
            sb.append(miPerro.getEdad()).append("/");
            sb.append(miPerro.raza).append("/");
            sb.append(miPerro.genero).append("/");
            sb.append(miPerro.color).append("/");
            sb.append(miPerro.cola).append("/");
            sb.append(miPerro.orejas).append("/");
            sb.append(miPerro.getEnergia()).append("/");
            sb.append(miPerro.getSalud()).append(";");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String transformarGatosLineas(ArrayList<Gato> listaGatos) {
        StringBuilder sb = new StringBuilder();
        for (Gato miGato : listaGatos) {
            sb.append(miGato.getNombre()).append("/");
            sb.append(miGato.dueno).append("/");
            sb.append(miGato.getPeso()).append("/");
            sb.append(miGato.getTamano()).append("/");
            sb.append(miGato.getEdad()).append("/");
            sb.append(miGato.raza).append("/");
            sb.append(miGato.genero).append("/");
            sb.append(miGato.pelo).append("/");
            sb.append(miGato.garras).append("/");
            sb.append(miGato.getEnergia()).append("/");
            sb.append(miGato.getSalud()).append(";");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private ArrayList<Perro> transformarLineasPerros(String lineaPerros) {
        ArrayList<Perro> listaPerros = new ArrayList<>();
        String[] perros = new String[1];
        if (!lineaPerros.contains(";")) {
            perros[0] = lineaPerros;
        } else {
            perros = lineaPerros.split(";");
        }
        for (int i = 0; i < perros.length; i++) {
            Perro nuevoPerro = new Perro();
            // Extraer los atributos del perro usando el caracter de separacion (,)
            String[] atributosPerro = perros[i].split("/");
            nuevoPerro = transformarAtributosPerro(atributosPerro);
            listaPerros.add(nuevoPerro);
        }
        return listaPerros;
    }

    private ArrayList<Gato> transformarLineasGatos(String lineaGatos) {
        ArrayList<Gato> listaGatos = new ArrayList<>();
        String[] gatos = new String[1];
        if (!lineaGatos.contains(";")) {
            gatos[0] = lineaGatos;
        } else {
            gatos = lineaGatos.split(";");
        }
        for (int i = 0; i < gatos.length; i++) {
            Gato nuevoGato = new Gato();
            // Extraer los atributos del perro usando el caracter de separacion (,)
            String[] atributosGato = gatos[i].split("/");
            nuevoGato = transformarAtributosGato(atributosGato);
            listaGatos.add(nuevoGato);
        }
        return listaGatos;
    }

    private Perro transformarAtributosPerro(String[] atributosPerro) {
        Perro perroAtributos = new Perro();
        perroAtributos.setNombre(atributosPerro[0]);
        perroAtributos.dueno = atributosPerro[1];
        perroAtributos.setPeso(Double.parseDouble(atributosPerro[2]));
        perroAtributos.setTamano(Double.parseDouble(atributosPerro[3]));
        perroAtributos.setEdad(Integer.parseInt(atributosPerro[4]));
        perroAtributos.raza = atributosPerro[5];
        perroAtributos.genero = atributosPerro[6].charAt(0);
        perroAtributos.color = atributosPerro[7];
        perroAtributos.cola = Boolean.parseBoolean(atributosPerro[8]);
        perroAtributos.orejas = Boolean.parseBoolean(atributosPerro[9]);
        perroAtributos.setEnergia(Integer.parseInt(atributosPerro[10]));
        perroAtributos.setSalud(Integer.parseInt(atributosPerro[11]));
        return perroAtributos;
    }

    private Gato transformarAtributosGato(String[] atributosGato) {
        Gato gatoAtributos = new Gato();
        gatoAtributos.setNombre(atributosGato[0]);
        gatoAtributos.dueno = atributosGato[1];
        gatoAtributos.setPeso(Double.parseDouble(atributosGato[2]));
        gatoAtributos.setTamano(Double.parseDouble(atributosGato[3]));
        gatoAtributos.setEdad(Integer.parseInt(atributosGato[4]));
        gatoAtributos.raza = atributosGato[5];
        gatoAtributos.genero = atributosGato[6].charAt(0);
        gatoAtributos.pelo = Boolean.parseBoolean(atributosGato[7]);
        gatoAtributos.garras = Boolean.parseBoolean(atributosGato[8]);
        gatoAtributos.setEnergia(Integer.parseInt(atributosGato[9]));
        gatoAtributos.setSalud(Integer.parseInt(atributosGato[10]));
        return gatoAtributos;
    }

}
