package Ejercicio8;

//Clase circulo

	public class Circulo extends dibujar {
	
	private double radio;
	
	private double long_perimetro;
	
	private double long_area;
	
	//Constructor
		public Circulo ( double radio) {
			this.radio = radio;
		}
		
		
		//Metodos de interface
		public double perimetro() {
			long_perimetro = 2*Math.PI*radio;
			return long_perimetro;
		}

		
		public double area() {
			double elevado = Math.pow(radio, 2);
			long_area = Math.PI*elevado;
			return long_area;
		}

		
		public void escalar(double escala) {
			radio = radio * escala;
		}

		
		public String imprimir() {
			return  "Radio: " + radio + " Perimetro: " + long_perimetro + " Area: " + long_area;
		}

}
