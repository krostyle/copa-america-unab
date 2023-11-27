package domain.entities;

public class Estadio {
    private int numEstadio;
    private String nomEstadio;

    public Estadio(int numEstadio, String nomEstadio) {
        this.numEstadio = numEstadio;
        this.nomEstadio = nomEstadio;
    }

    public int getNumEstadio() {
        return numEstadio;
    }

    public void setNumEstadio(int numEstadio) {
        this.numEstadio = numEstadio;
    }

    public String getNomEstadio() {
        return nomEstadio;
    }

    public void setNomEstadio(String nomEstadio) {
        this.nomEstadio = nomEstadio;
    }

    @Override
    public String toString() {
        return "Estadio{" +
                "numEstadio=" + numEstadio +
                ", nomEstadio='" + nomEstadio + '\'' +
                '}';
    }
}
