package domain.entities;

import java.time.LocalDate;
import java.util.*;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Fecha fecha;
    private Estadio estadio;
    private String  fase;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, Fecha fecha, Estadio estadio, String fase) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.estadio = estadio;
        setFase(fase);
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        if(!esFaseValida(fase)){
            throw new IllegalArgumentException("La fase debe ser una de las siguientes: FECHA 1, FECHA 2, FECHA 3, FECHA 4, FECHA 5, CUARTOS DE FINAL, SEMIFINALES, TERCER PUESTO, FINAL");
        }
        this.fase = fase;
    }

    public void cambiarFechaPartido( int nuevoDia, int nuevoMes, int nuevoAnio){
        LocalDate fechaActual = LocalDate.now();
        LocalDate nuevaFecha = LocalDate.of(nuevoAnio, nuevoMes, nuevoDia);
        LocalDate fechaPartidoActual = LocalDate.of(fecha.getAnio(), fecha.getMes(), fecha.getDia());

        if (nuevaFecha.isBefore(fechaActual)){
            throw new IllegalArgumentException("La fecha del partido no puede ser anterior a la fecha actual");
        }

        //comprobar que la nueva fecha sea para el mes anterio o siguiente del ya ingresado
        if((!nuevaFecha.isAfter(fechaPartidoActual.minusMonths(1)) && (!nuevaFecha.isBefore(fechaPartidoActual.plusMonths(1))))){
            throw new IllegalArgumentException("La fecha del partido debe ser para el mes anterior o siguiente del ya ingresado");
        }

        this.fecha.setDia(nuevoDia);
        this.fecha.setMes(nuevoMes);
        this.fecha.setAnio(nuevoAnio);
    }

    public void asigarEquiposAlPartido(List<String> nombreJugadoresEquipoLocal, List<String> nombreJugadoresEquipoVisitante){
        this.equipoLocal.asignarJugadoresAlEquipo(nombreJugadoresEquipoLocal);
        this.equipoVisitante.asignarJugadoresAlEquipo(nombreJugadoresEquipoVisitante);
    }

    private static boolean esFaseValida(String fase){
        Set<String> faseValida = new HashSet<>(
                Arrays.asList("FECHA 1", "FECHA 2", "FECHA 3", "FECHA 4", "FECHA 5", "CUARTOS DE FINAL", "SEMIFINALES","TERCER PUESTO", "FINAL"));
        return faseValida.contains(fase);
    }
}
