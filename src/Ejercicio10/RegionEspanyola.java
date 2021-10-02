package Ejercicio10;

public class RegionEspanyola extends Region {

	RegionEspanyola(String nombreRegion) {
		super(nombreRegion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String formato(int dia, int mes, int anio) {
		String fecha = dia + "/" + mes + "/" + anio;
		return fecha;
	}

}
