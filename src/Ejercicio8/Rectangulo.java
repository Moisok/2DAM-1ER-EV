package Ejercicio8;



	public class Rectangulo extends dibujar {
		
		//Artributos propios
		private double altura;
		private double base;
		private double long_perimetro;
		private double long_area;
		
		//Constructor
		public Rectangulo (double altura, double base) {
			this.altura = altura;
			this.base = base;
		}
		
		//Calcular perimetro
		public double perimetro() {
			long_perimetro = (base*2)+(altura*2);
			return long_perimetro;
		}
		
		//Calcular area
		public double area() {
			long_area = base*altura;
			return long_area;
		}
		
		//Escalar la figura
		public void escalar(double escala) {
			altura = altura * escala;
			base = base * altura;
			
		}
		
		//Mostrar artributos
		@Override
		public String imprimir() {
			return "Altura: " + altura + " Base: " + base + " Perimetro: " + long_perimetro + " Area: " + long_area;
		}
		

		
	}


