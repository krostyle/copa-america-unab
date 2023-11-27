package domain.entities;

public class Pais {
    private int codPais;
    private String nomPais;

    public Pais(int codPais, String nomPais) {
        this.setCodPais(codPais);
        this.setNomPais(nomPais);
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        if(codPais<4 || codPais>887) {
            throw new IllegalArgumentException("El código de país debe estar entre 4 y 887");
        }
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        if(nomPais == null || nomPais.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de país no puede ser nulo o vacío");
        }
        this.nomPais = nomPais;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "codPais=" + codPais +
                ", nomPais='" + nomPais + '\'' +
                '}';
    }
}
