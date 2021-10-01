package Ejercicio9;

//Creamos la clase cuadrado que heredara los metodos de las interfaces

public class Cuadrado extends FormasGeometricas {


	//Artributos para calculos
	private float area;
	private float perimetro;
	
	public Cuadrado (float lado) {
		super(lado);
	}

	@Override
	public void Dibujar() {
		System.out.println("Area: " + lado);
	}

	@Override
	public float CalcularArea() {
		area = lado * lado;
		return area;
	}

	@Override
	public float CalcularPerimetro() {
		perimetro = lado * 4;
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
