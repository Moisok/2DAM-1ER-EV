package Ejercicio9;

public class Rectangulo extends FormasGeometricas {
	
	
	//Artributos a pasar
	private float lado;
	private float base;
	
	//Atributos para calcular
	private float perimetro;
	private float area;
	
	//Contructor
	Rectangulo(float lado, float base) {
		super(lado);
		this.base = base;
		
	}
	

	@Override
	public void Dibujar() {
		System.out.println("Area: " + base);
	}

	@Override
	public float CalcularArea() {
		area = base*lado;
		return area;
	}

	@Override
	public float CalcularPerimetro() {
		perimetro = (base*2)+(lado*2);
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
