package domain.entities;

import java.time.LocalDate;

public class JugadorNacional extends Jugador{
    private int anioEntradaClubActual;

    public JugadorNacional(String nombre, int numCamisera, Posicion posicion, int anioEntradaClubActual) {
        super(nombre, numCamisera, posicion);
        this.anioEntradaClubActual = anioEntradaClubActual;
    }

    public int getAnioEntradaClubActual() {
        return anioEntradaClubActual;
    }

    public void setAnioEntradaClubActual(int anioEntradaClubActual) {
        this.anioEntradaClubActual = anioEntradaClubActual;
    }

    @Override
    public float calcularBono (){
        float bonoBase = super.calcularBono();
        //vamos a suponer que se calcula con la fecha actual
        int anioActual = LocalDate.now().getYear();
        int meses = (anioActual - this.anioEntradaClubActual) * 12;
        return  bonoBase * (1+meses);
    }
}
