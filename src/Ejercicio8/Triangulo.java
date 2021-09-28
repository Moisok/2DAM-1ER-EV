package Ejercicio8;

//Clase triangulo

public class Triangulo extends dibujar {
	
	//Artributos del triangulo
	private double altura;
	private double base;
	private double long_perimetro;
	private double long_area;
	
	public Triangulo (double base, double altura) {
		this.altura=altura;
		this.base=base;
	}


	public double perimetro() {
		long_perimetro = base*3;
		return long_perimetro;
	}

	
	public double area() {
		long_area = base*altura/2;
		return long_area;
	}


	public void escalar(double escala) {
		altura = altura * escala;
		base = base * altura;
	}


	public String imprimir() {
		return "Altura: " + altura + " Base: " + base + " Perimetro: " + long_perimetro + " Area: " + long_area;
	}
	
	
}
