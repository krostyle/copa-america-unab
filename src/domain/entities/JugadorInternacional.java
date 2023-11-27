package domain.entities;

public class JugadorInternacional extends Jugador{
    private String marca;
    private float fichaje;

    public JugadorInternacional(String nombre, int numCamisera, Posicion posicion, String marca, float fichaje) {
        super(nombre, numCamisera, posicion);
        this.marca = marca;
        this.fichaje = fichaje;
    }

    @Override
    public float calcularBono (){
        float bonoBase = super.calcularBono();
        return  bonoBase * (1+this.getPosicion().getCodPos());
    }
}
