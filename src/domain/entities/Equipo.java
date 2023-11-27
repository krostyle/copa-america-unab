package domain.entities;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Equipo {
    private char grupo;
    private int rankingFifa;
    private Pais pais;
    private List<Jugador> jugadores;

    public Equipo(char grupo, int rankingFifa, Pais pais) {
        this.grupo = grupo;
        this.rankingFifa = rankingFifa;
        this.pais = pais;
        this.jugadores = new ArrayList<>();
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        if (grupo != 'A' && grupo != 'B' && grupo != 'C' && grupo != 'D') {
            throw new IllegalArgumentException("El grupo debe ser una letra entre A y D");
        }
        this.grupo = grupo;
    }

    public int getRankingFifa() {
        return rankingFifa;
    }

    public void setRankingFifa(int rankingFifa) {
        if (rankingFifa < 1 || rankingFifa > 100) {
            throw new IllegalArgumentException("El ranking debe ser un numero entre 1 y 100");
        }
        this.rankingFifa = rankingFifa;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Jugador> getJugadores() {
        //Devuevlo una copia y no el array el original
        return new ArrayList<>(jugadores);
    }


    public void agregarJugador(String nombreJugador) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                throw new IllegalArgumentException("Ya existe un jugador con ese nombre en el equipo");
            }
        }
        Random random = new Random();
        int numCamiseta = generarNumeroCamisetaUnico(jugadores.stream()
                .map(Jugador::getNumCamiseta)
                .collect(Collectors.toList()));
        Posicion posicion = obtenerPosicionPredeterminada();

        Jugador jugador;
        if (random.nextBoolean()) {
            int anioEntrada = random.nextInt(2023 - 2000) + 2000;
            jugador = new JugadorNacional(nombreJugador, numCamiseta, posicion, anioEntrada);
        } else {
            String marca = obtenerMarcaRepresentanteAleatoria();
            float fichaje = obtenerMontoFichajAleatorio();
            jugador = new JugadorInternacional(nombreJugador, numCamiseta, posicion, marca, fichaje);
        }

        this.jugadores.add(jugador);


    }

    private int generarNumeroCamisetaUnico(List<Integer> numerosCamisetaAsignados) {
        List<Integer> numerosValidos = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 21, 22, 23, 24, 25, 30, 31, 32, 33, 34, 35, 40, 41, 42, 43, 44, 45, 50, 51, 52, 53, 54, 55);
        List<Integer> numerosDisponibles = numerosValidos.stream()
                .filter(numero -> !numerosCamisetaAsignados.contains(numero))
                .collect(Collectors.toList());

        if (numerosDisponibles.isEmpty()) {
            throw new IllegalArgumentException("No hay numeros de camiseta disponibles");
        }

        Random random = new Random();
        int numCamiseta = numerosDisponibles.get(random.nextInt(numerosDisponibles.size()));
        return numCamiseta;
    }

    private Posicion obtenerPosicionPredeterminada() {
        //Podira validar que no se repita el arquero pero me queda muy poco tiempo
        Random random = new Random();
        Posicion[] posicionesValidas = {
                new Posicion(1, "Arquero"),
                new Posicion(2, "Defensa"),
                new Posicion(3, "Mediocampista"),
                new Posicion(4, "Delantero")
        };
        int indiceAleatorio = random.nextInt(posicionesValidas.length);
        return posicionesValidas[indiceAleatorio];
    }

    private String obtenerMarcaRepresentanteAleatoria() {
        String[] marcas = {"Nike", "Adidas", "Puma", "Under Armour", "New Balance"};
        Random random = new Random();
        int indiceAleatorio = random.nextInt(marcas.length);
        return marcas[indiceAleatorio];
    }

    private float obtenerMontoFichajAleatorio() {
        Random random = new Random();
        return 1.0f + random.nextFloat() * 9.0f;
    }


    public void asignarJugadoresAlEquipo(List<String> nombreJugadores) {
        Random random = new Random();
        List<Integer> numerosAsignados = jugadores.stream()
                .map(Jugador::getNumCamiseta)
                .collect(Collectors.toList());
        for (String nombreJugador : nombreJugadores) {
            int numCamiseta = generarNumeroCamisetaUnico(numerosAsignados);
            Posicion posicion = obtenerPosicionPredeterminada();
            //ya no se puede instanciar Jugador , debo instanciar las clases hijas
            //Se harán al azar con Random
            Jugador jugador;
            if (random.nextBoolean()) {
                int anioEntrada = random.nextInt(2023 - 2000) + 2000;
                jugador = new JugadorNacional(nombreJugador, numCamiseta, posicion, anioEntrada);
            } else {
                String marca = obtenerMarcaRepresentanteAleatoria();
                float fichaje = obtenerMontoFichajAleatorio();
                jugador = new JugadorInternacional(nombreJugador, numCamiseta, posicion, marca, fichaje);
            }

            this.jugadores.add(jugador);
            numerosAsignados.add(numCamiseta);
        }
    }

    public void eliminarJugadorDelEquipo(String nombreJugador) {
        Iterator<Jugador> iterador = jugadores.iterator();
        while (iterador.hasNext()) {
            Jugador jugador = iterador.next();
            if (jugador.getNombre().equals(nombreJugador)) {
                iterador.remove();
                return;
            }
        }
        throw new IllegalArgumentException("No existe un jugador con ese nombre en el equipo");
    }

    public void autorizarNominaDeJugadores(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            for (Jugador jugador : jugadores) {
                writer.println("Nombre: " + jugador.getNombre() +
                        ", Numero de camiseta: " + jugador.getNumCamiseta() +
                        ", Posicion: " + jugador.getPosicion().getNomPos() +
                        ", Goles: 0"
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al escribir el archivo", e);
        }
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "grupo=" + grupo +
                ", rankingFifa=" + rankingFifa +
                ", pais=" + pais.getNomPais() +
                ", jugadores=" + jugadores.size() +
                '}';
    }
}
