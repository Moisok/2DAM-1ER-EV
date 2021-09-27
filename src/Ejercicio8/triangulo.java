package Ejercicio8;

public class triangulo extends tipo implements figura2d {
	
	//Artributos del triangulo
	private double altura;
	private double base;
	private double long_perimetro;
	private double long_area;
	
	public triangulo (String nombre, double base, double altura) {
		super (nombre);
		this.altura=altura;
		this.base=base;
	}

	@Override
	public double perimetro() {
		long_perimetro = base*3;
		return long_perimetro;
	}

	@Override
	public double area() {
		long_area = base*altura/2;
		return long_area;
	}

	@Override
	public void escalar(double escala) {
		altura = altura * escala;
		base = base * altura;
	}

	@Override
	public String imprimir() {
		return nombre + " " + altura + " " + base + " " + long_perimetro + " " + long_area;
	}
	
	
}
