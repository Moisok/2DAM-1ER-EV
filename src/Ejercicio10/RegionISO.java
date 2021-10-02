package Ejercicio10;

public class RegionISO extends Region {

	//Contructor
	RegionISO(String nombreRegion) {
		super(nombreRegion);
	}
	
	//Metodo heredado
	@Override
	public String formato (int dia, int mes, int anio) {
		String fecha = anio + "/" + mes + "/" + dia;
		return fecha;
	}
	

}
