import domain.entities.*;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PrincipalCopaAmerica {
    public static void main(String[] args) {
        //Copa america 2015 Chile campeon ! :D
        Pais paisLocalChile = new Pais(40, "Chile");
        Pais paisVisitanteArgentina = new Pais(5, "Argentina");

        //Estadio
        Estadio estadioNacionalChile = new Estadio(1, "Estadio Nacional de Chile");

        //Equipos
        Equipo equipoLocalChile = new Equipo('A', 45, paisLocalChile);
        Equipo equipoVisitanteArgentina = new Equipo('A', 50, paisVisitanteArgentina);

        //Jugadores Chile
        List<String> jugadoresChile = List.of("Claudio Bravo", "Mauricio Isla", "Gary Medel", "Gonzalo Jara", "Eugenio Mena", "Charles Aranguiz", "Marcelo Diaz", "Arturo Vidal", "Alexis Sanchez", "Eduardo Vargas", "Jean Beausejour");
        //Jugadores Argentina
        List<String> jugadoresArgentina = List.of("Sergio Romero", "Pablo Zabaleta", "Ezequiel Garay", "Martín Demichelis", "Marcos Rojo", "Javier Mascherano", "Lucas Biglia", "Javier Pastore", "Lionel Messi", "Gonzalo Higuaín", "Ángel Di María");

        //Fehca Partido
        Fecha fechaPartido = new Fecha(11, 6, 2015);

        //Crear Partido
        Partido partido = new Partido(equipoLocalChile, equipoVisitanteArgentina, fechaPartido, estadioNacionalChile, "FINAL");

        //Asignar Equipos al partido
        partido.asigarEquiposAlPartido(jugadoresChile, jugadoresArgentina);

        System.out.println("Datos del estadio:");
        System.out.println("Estadio: " + partido.getEstadio().getNomEstadio());

        System.out.println("Datos del Partido:");
        System.out.println("Equipo local: " + partido.getEquipoLocal().getPais().getNomPais());
        System.out.println("Equipo visitante: " + partido.getEquipoVisitante().getPais().getNomPais());
        System.out.println("Fecha: " + partido.getFecha().getDia() + "/" + partido.getFecha().getMes() + "/" + partido.getFecha().getAnio());
        System.out.println("Fase: " + partido.getFase());


        System.out.println("Grupos:");
        System.out.println("Grupo equipo local: " + partido.getEquipoLocal().getGrupo());
        System.out.println("Grupo equipo visitante: " + partido.getEquipoVisitante().getGrupo());



        Equipo equipoMejorRankeado = partido.getEquipoLocal().getRankingFifa() > partido.getEquipoVisitante().getRankingFifa() ? partido.getEquipoLocal() : partido.getEquipoVisitante();

        System.out.println("Ranking FIFA:");
        System.out.println("Codigo Equipo mejor rankeado: " + equipoMejorRankeado.getPais().getCodPais());
    }


}