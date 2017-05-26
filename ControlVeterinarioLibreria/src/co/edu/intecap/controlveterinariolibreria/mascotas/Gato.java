
package co.edu.intecap.controlveterinariolibreria.mascotas;

import co.edu.intecap.controlveterinariolibreria.IAnimal;
import co.edu.intecap.controlveterinariolibreria.Mascota;


public class Gato extends Mascota implements IAnimal{
    
   public boolean garras;
   public boolean pelo;
   
   public Gato(){
       energia = 100;
       salud = 100;
   }
   
   public Gato(String nombre, String dueno, char genero, int edad){
       this.nombre=nombre;
       this.dueno=dueno;
       this.genero=genero;
       this.edad=edad;
       energia = 100;
       salud = 100;
   }
   
   public void maullar(){
       System.out.println("Miau... Miau... Miau...");
       energia -=1;
       nivelarEnergiaSalud();
   }
   
   public void ronronear(){
       System.out.println("Rrrrrrrr...");
       energia += 1;
       salud +=1;
       nivelarEnergiaSalud();
   }
   
   public void cazar(){
       energia -=30;
       nivelarEnergiaSalud();
   }

    @Override
    public void comer(double comida) {
        peso += comida*0.10;
    }

    @Override
    public void beber(double agua) {
        peso -= agua*0.015;
    }

    @Override
    public void defecar() {
        peso -= peso*0.001;
    }
   
}
