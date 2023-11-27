package domain.entities;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.setAnio(anio);
        this.setMes(mes);
        this.setDia(dia);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        //Se podria optimizar el codigo y dejar esta logica en un metodo aparte, pero queda poco tiempo
        if(dia<1 || dia>31 || (mes==2 && dia>29) || (mes==4 && dia>30) || (mes==6 && dia>30) || (mes==9 && dia>30) || (mes==11 && dia>30)){
            System.out.println("Dia invalido");
            throw new IllegalArgumentException("El día debe estar entre 1 y 31");
        }
        if(mes ==2 && dia == 29 && !esAnioBisiesto(anio)){
            System.out.println("Dia invalido");
            throw new IllegalArgumentException("El día debe estar entre 1 y 28");
        }
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if(mes<1 || mes>12){
            System.out.println("Mes invalido");
            throw new IllegalArgumentException("El mes debe estar entre 1 y 12");
        }
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    private boolean esAnioBisiesto(int anio){
        return (anio%4==0 && anio%100!=0) || anio%400==0;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                '}';
    }
}
