package Ejercicio8;

//Clase circulo

	public class Circulo extends tipo implements figura2d {
	
	private double radio;
	
	private double long_perimetro;
	
	private double long_area;
	
	//Constructor
		public Circulo (String nombre, double radio) {
			super (nombre);
			this.radio = radio;
		}
		
		
		//Metodos de interface
		@Override
		public double perimetro() {
			long_perimetro = 2*Math.PI*radio;
			return long_perimetro;
		}

		
		@Override
		public double area() {
			double elevado = Math.pow(radio, 2);
			long_area = Math.PI*elevado;
			return long_area;
		}

		
		@Override
		public void escalar(double escala) {
			radio = radio * escala;
		}

		
		@Override
		public String imprimir() {
			return nombre + " " + radio + " " + long_perimetro + " " + long_area;
		}

}
