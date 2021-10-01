package Ejercicio9;

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
	public void Dibujar() {
		System.out.println("Altura: " + altura + " base: " + base + " perimetro " + perimetro + " area " + area);
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
