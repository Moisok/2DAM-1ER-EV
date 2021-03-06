package Datos_persona;

public class persona {
	
	//Datos principales
	private String nombre;
	private int edad;
	private String DNI;
	private String sexo;
	private int peso ;
	private int altura;
	
	//Constructor por defecto
	public persona () {
	}
	
	//Constructor solo con el nombre, edad y DNI y el resto por defecto
	public persona(String nombre, int edad, String DNI) {
		this.nombre = nombre;
		this.edad = edad;
		DNI = DNI;
	}
	
	//Constructor con artributos
	public persona(String nombre, int edad, String DNI, String sexo, int peso, int altura) {
		this.nombre = nombre;
		this.edad = edad;
		DNI = DNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	//Constructor copia
	public persona (persona x) {
		this.nombre = nombre;
		this.edad = edad;
		DNI = DNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	//Metodo para calcular el IMC
	public double imc () {
		double imc = peso/(Math.pow(altura, 2));
		if (imc < 20 && imc > 0) {
			imc = -1;
			
		}
		if (imc > 20 && imc < 25) {
			imc = 0;
			
		}
		if (imc > 25 ) {
			imc = 1;
			
		}
		return imc;	
	}
	
	//Metodo para saber si es mayor de edad o no
	public boolean EsMayorDeEdad () {
		boolean mayor = false;
		if (edad >= 18) {
			mayor = true;
			return mayor;
		}
		else {
			return mayor;
		}
	}
	
	//Metodo para comprobar sexo
	public void comprobarSexo () {
		if (sexo.equals("H") || sexo.equals("h")) {
			System.out.println ("Es hombre");
		}
		
		if (sexo.equals("M") || sexo.equals("m")) {
			System.out.println ("Es mujer");
		}
		
		else {
			System.out.println("Se desconoce el sexo");
		}
		
	}
	
	//Metodo para general el DNI
	public void generarDNI () {
		int aleatorio;
		//Genera el numero
			aleatorio = (int)(1 + (Math.random() * 99999999));
		//Calcula la letra
			String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";

			int modulo= aleatorio % 23;

			char letra = juegoCaracteres.charAt(modulo);
			
			DNI = aleatorio + String.valueOf(letra);
	}

	
	//Setters para cada parámetro
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	//Getter
	public String getNombre() {
		return nombre;
	}

	//ToString
	@Override
	public String toString() {
		return "persona [nombre: " + nombre + ", edad: " + edad + ", DNI: " + DNI + ", sexo: " + sexo + ", peso: " + peso
				+ ", altura: " + altura + "]";
	}
	
	
	
	
	
	
	
	
}
