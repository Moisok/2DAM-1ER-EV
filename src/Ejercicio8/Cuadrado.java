package Ejercicio8;

//Clase cuadrado

public class Cuadrado extends dibujar {
	
	//Artributos propios
		private double lado;
		private double long_perimetro;
		private double long_area;
		
		//Constructor
		public Cuadrado (double lado) {
			this.lado=lado;
		}
		
		//Metodos implementados (heredados)
		
		
		//Calcular perimetro
		public double perimetro() {
			
			long_perimetro = lado * 4;
			
			return long_perimetro;
		}

		//Calcular Area
		public double area() {
			
			long_area = lado*lado;
			
			return long_area;
		}

		//Escalar las figuras
		public void escalar(double escala) {
				lado = lado * escala;
			}
		
		
		//Mostrar informacion
		public String imprimir() {
			return "Lado: " + lado + " Perimetro: " + long_perimetro + " Area: " + long_area;
		}

}
