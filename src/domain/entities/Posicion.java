package domain.entities;

public class Posicion {
    private int codPos;
    private String nomPos;

    public Posicion(int codPos, String nomPos) {
        this.setCodPos(codPos);
        this.setNomPos(nomPos);
    }

    public int getCodPos() {
        return codPos;
    }

    public void setCodPos(int codPos) {
        this.codPos = codPos;
    }

    public String getNomPos() {
        return nomPos;
    }

    public void setNomPos(String nomPos) {
        if (nomPos == null || nomPos.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre de la posición no puede ser nulo ni vacío");
        }
        this.nomPos = nomPos;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "codPos=" + codPos +
                ", nomPos='" + nomPos + '\'' +
                '}';
    }
}
