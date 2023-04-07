package Grupo;

public class Pronostico {

	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	public Pronostico(Partido partido, Equipo equipo, ResultadoEnum campos) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = campos;
	}
	public Partido getPartido() {
		return this.partido;
	}
	public Equipo getEquipo() {
		return this.equipo;
	}
	public ResultadoEnum getResultado() {
		return this.resultado;
	}
	
	public int puntos() {
		ResultadoEnum resultadoReal = this.partido.Resultado(this.equipo);
		if(this.resultado.equals(resultadoReal)) {
			return 1;
	}	else {
			return 0;
	}
	}
}
