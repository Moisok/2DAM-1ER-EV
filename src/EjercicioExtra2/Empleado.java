package EjercicioExtra2;

//Clase Empleado con interface '

public class Empleado implements Comparable<Empleado> {

	private String nombre;
	private String cargo;
	private String oficina;
	private int edad;
	private int AniosExp;
	private double sueldoBruto;
	private int paga;
	
	
	private double sueldoBrutoAnual;
	
	//Constructor
	public Empleado (String nombre, String cargo, int edad, int AniosExp, 
			double sueldo, int paga, String oficina){
		this.nombre = nombre;
		this.cargo = cargo;
		this.edad = edad;
		this.AniosExp=AniosExp;
		this.sueldoBruto=sueldo;
		this.paga=paga;
		this.oficina=oficina;
	}

	//Getters
	public String getNombre() {
		return nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public int getEdad() {
		return edad;
	}

	public int getAniosExp() {
		return AniosExp;
	}

	public double getSueldo() {
		return sueldoBruto;
	}

	public int getPaga() {
		return paga;
	}
	public String getOficina() {
		return oficina;
	}
	public double getSueldoBrutoAnual() {
		return sueldoBrutoAnual;
	}
	

	//Calcular sueldo bruto anual
	double sueldoAnual () {
		this.sueldoBrutoAnual=paga*sueldoBruto;
		return sueldoBrutoAnual;	
	}
	
	//Mostrar
	String mostrar() {
		return nombre+"("+edad+")-"+cargo+"("+oficina+")"+":"+AniosExp+","+sueldoBrutoAnual+"€";
	}
	

	//metodo compare To
	@Override
	public int compareTo(Empleado o) {
		if (cargo.equals("Director")){
			return -1;
		}
		else if (!o.cargo.equals("Director") && cargo.equals("Jefa de oficina") && oficina.equals("Madrid")){
			return -1;
		}
		else if (AniosExp > o.AniosExp && cargo.equals("Jefa de oficina") || sueldoBrutoAnual > o.sueldoBruto && cargo.equals("Jefa de oficina")) {
			return -1;
		}
		else if (AniosExp < o.AniosExp) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
