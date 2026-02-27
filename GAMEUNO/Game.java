package GAMEUNO;
import java.util.*;

public class Game {

    private Deck deck;          // Mazo del juego
    private Hand jugador;       // Mano del jugador
    private Hand computadora;   // Mano de la computadora
    private Card cartaMesa;     // Carta actual en la mesa
    private Scanner scanner;    // Para poder leer entrada del usuario por medio teclado

    // Constructor
    public Game() {
        deck = new Deck();
        jugador = new Hand();
        computadora = new Hand();
        scanner = new Scanner(System.in);
    }
    // Metodo para iniciar el juego
    public void iniciar() {
        repartirCartas();
    // Se coloca la primera carta en mesa
        cartaMesa = deck.robarCarta();
        System.out.println("Carta inicial en mesa: " + cartaMesa);
        System.out.println("-----------------------------------");
        
    
        while (true) {

            turnoJugador();
            if (jugador.estaVacia()) {
                System.out.println("¡¡GANASTE!!");
                break;
            }

            turnoComputadora();
            if (computadora.estaVacia()) {
                System.out.println("La computadora ganó.");
                break;
            }
        }
    }
    // Reparte 7 cartas a cada jugador
    private void repartirCartas() {
        for (int i = 0; i < 7; i++) {
            jugador.agregarCarta(deck.robarCarta());
            computadora.agregarCarta(deck.robarCarta());
        }
    }
    // Logica del turno del jugador
    private void turnoJugador() {
        System.out.println("\n=== TU TURNO ===");
        System.out.println("Carta en mesa: " + cartaMesa);
        jugador.mostrarMano();

        System.out.println("Elige carta a jugar (numero) o -1 para robar:");
        int opcion = scanner.nextInt();

        if (opcion == -1) {
            jugador.agregarCarta(deck.robarCarta());
            System.out.println("Robaste carta.");
            return;
        }

        Card seleccionada = jugador.jugarCarta(opcion);

        if (seleccionada == null) {
            System.out.println("Indice invalido.");
            return;
        }

        if (seleccionada.esJugableSobre(cartaMesa)) {
            cartaMesa = seleccionada;
            System.out.println("Jugaste: " + cartaMesa);
        } else {
            System.out.println("Carta no valida.");
            jugador.agregarCarta(seleccionada);
        }
    }
    // Logica del turno de la computadora
    private void turnoComputadora() {
        System.out.println("\n=== TURNO COMPUTADORA ===");
        System.out.println("Carta en mesa: " + cartaMesa);

        for (int i = 0; i < computadora.size(); i++) {
            Card c = computadora.jugarCarta(i);

            if (c.esJugableSobre(cartaMesa)) {
                cartaMesa = c;
                System.out.println("Computadora jugó: " + cartaMesa);
                return;
            } else {
                computadora.agregarCarta(c);
            }
        }

        System.out.println("Computadora roba carta.");
        computadora.agregarCarta(deck.robarCarta());
    }
}