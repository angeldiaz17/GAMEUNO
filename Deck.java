package GAMEUNO;
import java.util.*;

public class Deck {

    private ArrayList<Card> cartas;

    public Deck() {
        cartas = new ArrayList<>();
        crearBaraja();
        barajar();
    }

    private void crearBaraja() {

        String[] colores = {"azul","verde","rojo","amarillo"};

        for(String color : colores) {

            for(int i=0;i<=9;i++) {
                cartas.add(new Card(color,i));
                cartas.add(new Card(color,i));
            }

            // cartas especiales por color
            cartas.add(new Card(color,TipoCarta.REVERSE));
            cartas.add(new Card(color,TipoCarta.SKIP));
            cartas.add(new Card(color,TipoCarta.DRAW2));
        }

        // comodines
        for(int i=0;i<4;i++) {
            cartas.add(new Card("negro",TipoCarta.WILD));
            cartas.add(new Card("negro",TipoCarta.DRAW4));
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Card robarCarta() {

        if(cartas.isEmpty())
            return null;

        return cartas.remove(0);
    }

    public int cartasRestantes() {
        return cartas.size();
    }
}