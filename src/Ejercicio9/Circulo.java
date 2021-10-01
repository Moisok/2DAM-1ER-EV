package Ejercicio9;

public class Circulo extends FormasGeometricas {
	
	
	//Artributos para calculos
	private float perimetro;
	
	private float area;
	
	//Constructor
	public Circulo (float lado) {
		super(lado);
	}
	

	@Override
	public void Dibujar() {
		System.out.println("Area: " + lado);
	}

	//Calcular el Area
	@Override
	public float CalcularArea() {
		float elevado = (float) Math.pow(lado, 2);
		area = (float)(Math.PI*elevado);
		return area;

	}

	//Calcular el perimetro
	@Override
	public float CalcularPerimetro() {
		perimetro = (float)(2*Math.PI*lado);
		return perimetro;
	}
	
	
	@Override
	public int compareTo (FormasGeometricas X) {
		if (this.lado < X.lado) {
            return -1;
        }
        if (lado > X.lado) {
            return 1;
        }
        return 0;
	} 

}
