package domain.entities;

public abstract class Jugador {
    private String nombre;
    private int numCamiseta;
    private Posicion posicion;

    public Jugador(String nombre, int numCamisera, Posicion posicion) {
        this.setNombre(nombre);
        this.setNumCamiseta(numCamisera);
        this.setPosicion(posicion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(int numCamiseta) {
        if (
                (numCamiseta >= 0 && numCamiseta <= 15) ||
                (numCamiseta >= 20 && numCamiseta <= 25) ||
                (numCamiseta >= 30 && numCamiseta <= 35) ||
                (numCamiseta >= 40 && numCamiseta <= 45) ||
                (numCamiseta >= 50 && numCamiseta <= 55))
        {
            this.numCamiseta = numCamiseta;
        } else {
            throw new IllegalArgumentException("El número de camiseta debe estar entre 0 y 15, 20 y 25, 30 y 35, 40 y 45 o 50 y 55");
        }

    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException("La posición no puede ser nula");
        }
        this.posicion = posicion;
    }

    public float calcularBono (){
        return 0.2f;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", numCamiseta=" + numCamiseta +
                ", posicion=" + posicion +
                '}';
    }
}
