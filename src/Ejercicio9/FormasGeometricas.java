package Ejercicio9;

//Hay que hacer esto y que las formas hereden desde aqui los artributos y los metodos
//Despues hay que ordenar por el area
//En java es sin la I la interface comparable

public abstract class FormasGeometricas implements IFiguraGeometrica, Comparable<FormasGeometricas>, IDibujable {

	float lado = 0;
	
	FormasGeometricas (float lado){
		this.lado=lado;
	}

	//Implementamos los metodos de las interfaces
	@Override
	public void Dibujar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo (FormasGeometricas X) {
		return 0;
	};
		
		

	@Override
	public float CalcularArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float CalcularPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
