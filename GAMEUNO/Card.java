package GAMEUNO;

public class Card {
    // Atributos privados
    private String color; // Color de la carta
    private int numero; // Numero de la carta

    // Constructor de la clase Card
    public Card(String color, int numero) { // Parametros
        this.color = color;
        this.numero = numero;
    }
    // Metodo getter para obtener el color
    public String getColor() {
        return color;
    }
    // Metodo getter para obtener el numero
    public int getNumero() {
        return numero;
    }
    // Metodo para verificar si esta carta ouede jugarse sobre otra carta
    public boolean esJugableSobre(Card otra) {
    // Si no hay carta en mesa, cualquier carta es válida
        if (otra == null) return true;
    // Se puede jugar si el color es igual o el número es igual
        return this.color.equals(otra.color) || this.numero == otra.numero;
    }
    // Metodo que define como se imprime la carta en consola
    @Override
    public String toString() {
        return color + " " + numero;
    }
}