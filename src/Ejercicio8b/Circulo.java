package Ejercicio8b;

public class Circulo implements IFiguraGeometrica, IDibujable {
	
	//Artributos para el constructor
	private float radio;
	
	//Artributos para calculos
	private float perimetro;
	
	private float area;
	
	//Constructor
	public Circulo (float radio) {
		
		this.radio=radio;
	}
	

	@Override
	public void Dibujar() {
		System.out.println("Radio: " + radio + " Perimetro: " + perimetro + " area " + area);
	}

	//Calcular el Area
	@Override
	public float CalcularArea() {
		float elevado = (float) Math.pow(radio, 2);
		area = (float)(Math.PI*elevado);
		return area;

	}

	//Calcular el perimetro
	@Override
	public float CalcularPerimetro() {
		perimetro = (float)(2*Math.PI*radio);
		return perimetro;
	}
	
	

}
