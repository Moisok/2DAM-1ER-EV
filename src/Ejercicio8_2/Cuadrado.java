package Ejercicio8_2;

//Creamos la clase cuadrado que heredara los metodos de las interfaces

public class Cuadrado implements IFiguraGeometrica, IDibujable {

	//Artributo a pasar
	private float lado;
	
	//Artributos para calculos
	private float area;
	private float perimetro;
	
	public Cuadrado (float lado) {
		
		this.lado=lado;
	}

	@Override
	public String Dibujar() {
		return "Dibujo de un cuadrado";
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
	
}
