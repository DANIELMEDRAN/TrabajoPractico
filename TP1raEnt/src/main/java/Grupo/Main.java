package Grupo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        Collection<Partido> partidos = new ArrayList<Partido>();
        
        Path pathResultados = Paths.get("src/test/resources/resultados_test1.csv");   
        List<String> lineaResultados = null;    
        
        try {
            lineaResultados = Files.readAllLines(pathResultados);
        } catch (IOException e) {
            System.out.println("No se pudo leer la linea de Resutados");
            System.exit(1);
        }    
        boolean primera =  true;
                
        for (String lineaResultado : lineaResultados) {
            if (primera) {
                primera =  false;
            } else {
                String[] campos =  lineaResultado.split(",");
                Equipo equipo1 = new Equipo(campos[0]);
                Equipo equipo2 = new Equipo(campos[3]);
                Partido partido = new Partido(equipo1,equipo2);
                partido.setGolesEq1(Integer.parseInt(campos[1]));
                partido.setGolesEq2(Integer.parseInt(campos[2]));
                partidos.add(partido);
                System.out.println(lineaResultado);
            }
        }
        int puntos = 0;
        
        Path pathpronostico = Paths.get("src/test/resources/pronostico_test1.csv");   
        List<String> lineasPronostico = null;    
        
        try {
            lineasPronostico = Files.readAllLines(pathpronostico);
        } catch (IOException e) {
            System.out.println("Error al leer linea Pronosticos");
            System.exit(1);
        }
        primera =  true;
                    
        for (String lineaPronostico : lineasPronostico) {
            if (primera) {
                primera =  false;
            } else {
                String[] campos =  lineaPronostico.split(",");
                Equipo equipo1 = new Equipo(campos[0]);
                Equipo equipo2 = new Equipo(campos[4]);
                Partido partido = null;
                
                for(Partido partidoCol : partidos) {
                    if(partidoCol.getEquipo1().getNombre().equals(equipo1.getNombre()) && partidoCol.getEquipo2().getNombre().equals(equipo2.getNombre())) { partido = partidoCol;
                   partido = partidoCol;
                    }
                }
                Equipo Equipo = null;
                ResultadoEnum Resultado = null; 
                
                if("X".equals(campos[1])) {
                	Equipo = equipo1;
                	Resultado = ResultadoEnum.Ganador ;
                }
                if("X".equals(campos[2])) {
                	Equipo = equipo1;
                	Resultado = ResultadoEnum.Empate;
                }
                if("X".equals(campos[3])) {
                	Equipo = equipo1;
                	Resultado = ResultadoEnum.Perdedor;
                }
                
                Pronostico pronostico = new Pronostico(partido, Equipo, Resultado);
                
                puntos += pronostico.puntos(); 
            } 
        }
        System.out.println("El puntaje obtenido por el Participante es:");
        System.out.println(puntos);
    }
}
