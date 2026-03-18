package GAMEUNO;
import java.util.*;

public class Hand{
    // Lista que guarda las cartas del jugador
    private ArrayList<Card> cartas;
    // Constructor
    public Hand(){
        cartas = new ArrayList<>();
    }
    // Agrega una carta a la mano
    public void agregarCarta(Card c){
        cartas.add(c);
    }
    // Juega una carta según su índice
    public Card jugarCarta(int indice){
        // Verifica que el indice sea valido
        if (indice < 0 || indice >= cartas.size()) return null;
        return cartas.remove(indice);
    }
    // Devuelve el número de cartas en mano
    public int size(){
        return cartas.size();
    }
    // Verifica si la mano está vacía
    public boolean estaVacia(){
        return cartas.isEmpty();
    }
    // Muestra todas las cartas en consola
    public void mostrarMano(){
        System.out.println("Cartas en mano:");
        for(int i = 0; i < cartas.size(); i++){
            System.out.println(i + ": " + cartas.get(i));
        }
    }
     // Verifica si el jugador tiene al menos una jugada válida
    public boolean tieneJugadaValida(Card cartaMesa){
        for (Card c : cartas){
            if (c.esJugableSobre(cartaMesa)){
                return true;
            }
        }
        return false;
    }
}