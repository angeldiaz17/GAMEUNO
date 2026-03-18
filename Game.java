package GAMEUNO;
import java.util.*;

public class Game {

    private Deck deck;
    private Hand jugador;
    private Hand computadora;
    private Card cartaMesa;

    private Scanner scanner;

    public Game() {

        deck = new Deck();
        jugador = new Hand();
        computadora = new Hand();

        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        repartirCartas();

        cartaMesa = deck.robarCarta();

        System.out.println("Carta inicial: " + cartaMesa);

        while(true) {

            turnoJugador();

            if(jugador.estaVacia()) {
                System.out.println("GANASTE");
                break;
            }

            turnoComputadora();

            if(computadora.estaVacia()) {
                System.out.println("La computadora ganó");
                break;
            }
        }
    }

    private void repartirCartas() {

        for(int i=0;i<7;i++) {

            jugador.agregarCarta(deck.robarCarta());
            computadora.agregarCarta(deck.robarCarta());

        }
    }

    private void turnoJugador() {

        System.out.println("\n--- TU TURNO ---");
        System.out.println("Carta en mesa: "+cartaMesa);

        jugador.mostrarMano();

        try {

            System.out.println("Elige carta o -1 para robar:");

            int opcion = scanner.nextInt();

            if(opcion==-1) {

                jugador.agregarCarta(deck.robarCarta());

                System.out.println("Robaste carta");

                return;
            }

            Card seleccionada = jugador.jugarCarta(opcion);

            if(seleccionada==null) {

                System.out.println("Indice invalido");

                return;
            }

            if(seleccionada.esJugableSobre(cartaMesa)) {

                cartaMesa = seleccionada;

                aplicarEfecto(seleccionada);

                System.out.println("Jugaste "+cartaMesa);

            }

            else {

                System.out.println("Carta no válida");

                jugador.agregarCarta(seleccionada);

            }

        }

        catch(InputMismatchException e) {

            System.out.println("Entrada invalida");

            scanner.next();

        }
    }

    private void turnoComputadora() {

        System.out.println("\n--- TURNO COMPUTADORA ---");

        for(int i=0;i<computadora.size();i++) {

            Card c = computadora.jugarCarta(i);

            if(c.esJugableSobre(cartaMesa)) {

                cartaMesa = c;

                aplicarEfecto(c);

                System.out.println("Computadora jugó "+cartaMesa);

                return;

            }

            else {

                computadora.agregarCarta(c);

            }
        }

        System.out.println("Computadora roba carta");

        computadora.agregarCarta(deck.robarCarta());
    }

    private void aplicarEfecto(Card carta) {

        switch(carta.getTipo()) {

            case DRAW2:

                System.out.println("Jugador roba 2");

                jugador.agregarCarta(deck.robarCarta());
                jugador.agregarCarta(deck.robarCarta());

                break;

            case DRAW4:

                System.out.println("Jugador roba 4");

                for(int i=0;i<4;i++)
                    jugador.agregarCarta(deck.robarCarta());

                break;

            case SKIP:

                System.out.println("Turno saltado");

                break;

            case REVERSE:

                System.out.println("Reversa (sin efecto en 2 jugadores)");

                break;

            default:

                break;
        }
    }
}