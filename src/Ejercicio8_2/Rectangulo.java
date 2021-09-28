package Ejercicio8_2;

public class Rectangulo implements IFiguraGeometrica, IDibujable {
	
	//Artributos a pasar
	private float altura;
	private float base;
	
	//Atributos para calcular
	private float perimetro;
	private float area;
	
	//Contructor
	public Rectangulo (float perimetro, float area) {
		
		this.perimetro=perimetro;
		
		this.area=area;
		
	}

	@Override
	public String Dibujar() {
		return "Dibujo de un Rectangulo";
	}

	@Override
	public float CalcularArea() {
		area = base*altura;
		return area;
	}

	@Override
	public float CalcularPerimetro() {
		perimetro = (base*2)+(altura*2);
		return perimetro;
	}
	
	
	

}
