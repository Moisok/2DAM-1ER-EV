package Ejercicio10;

public class RegionInglesa extends Region {

	RegionInglesa(String nombreRegion) {
		super(nombreRegion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String formato(int dia, int mes, int anio) {
		String fecha = mes + "/" + dia + "/" + anio;
		return fecha;
	}

}
