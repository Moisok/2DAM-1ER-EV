package Ejercicio10;

//Programa Creado por moises Sepulveda Segarra

public class Regiones_Main {

	public static void main(String[] args) {
		
		//Contruimos las regiones
		RegionISO ri = new RegionISO ("ISO-8601");
		RegionEspanyola re = new RegionEspanyola ("Puente Tocinos");
		RegionInglesa rin = new RegionInglesa("Londres");
		
		//Metemos las fechas
		String fechaISO = ri.formato(4,8,1990);
		String fechaRE = re.formato(4, 8, 1990);
		String fechaRIN = rin.formato(4, 8, 1990);
		
		//Mostramos
		System.out.println(" ");
		System.out.println("Fecha formato ISO: " + fechaISO);
		System.out.println(" ");
		System.out.println("Fecha formato ESP: " + fechaRE);
		System.out.println(" ");
		System.out.println("Fecha formato UK: " + fechaRIN);
	}

}
