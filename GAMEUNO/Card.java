package GAMEUNO;

public class Card {

    private String color;
    private int numero;
    private TipoCarta tipo;

    // Constructor para cartas NUMÉRICAS
    public Card(String color, int numero) {
        this.color = color;
        this.numero = numero;
        this.tipo = TipoCarta.NUMERO;
    }

    // Constructor para cartas ESPECIALES
    public Card(String color, TipoCarta tipo) {
        this.color = color;
        this.tipo = tipo;
        this.numero = -1;
    }

    public String getColor() {
        return color;
    }

    public int getNumero() {
        return numero;
    }

    public TipoCarta getTipo() {
        return tipo;
    }

    // Verifica si la carta puede jugarse
    public boolean esJugableSobre(Card otra) {

        if (otra == null) return true;

        // comodines siempre se pueden jugar
        if (tipo == TipoCarta.WILD || tipo == TipoCarta.DRAW4)
            return true;

        return this.color.equals(otra.color) ||
               this.numero == otra.numero ||
               this.tipo == otra.tipo;
    }

    @Override
    public String toString() {

        if(tipo == TipoCarta.NUMERO)
            return color + " " + numero;

        return color + " " + tipo;
    }
}