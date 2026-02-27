package GAMEUNO;
import java.util.*;

public class Deck {
    // ArrayList que almacena todas las cartas del mazo
    private ArrayList<Card> cartas;
    // Cosntructor
    public Deck() {
        cartas = new ArrayList<>(); // Se inicializa la lista
        crearBaraja();              // Se crean las cartas
        barajar();                  // Se mezclan
    }
    // Metodo para crear la baraja
    private void crearBaraja() {
    // Arreglo de colores disponibles
        String[] colores = {"azul","verde","rojo","amarillo"};
    // Recorremos cada color
        for(String color : colores) {
    // Creamos cartas del 0 a 9
            for(int i = 0; i <= 9; i++) {
    // Se agregan dos cartas de cada numero
                cartas.add(new Card(color, i));
                cartas.add(new Card(color, i));
            }
        }
    }
    // Metodo para mezclar las cartas aleatoriamente
    public void barajar() {
        Collections.shuffle(cartas);
    }
    // Metodo para robar la carta del mazo
    public Card robarCarta() {
    // Si no hay cartas, retorna null
        if(cartas.isEmpty()) return null;
    // Remueve y devuelve la primera carta
        return cartas.remove(0);
    }
    // Devuelve cuantas cartas quedan en el mazo
    public int cartasRestantes() {
        return cartas.size();
    }
}