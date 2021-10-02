package Ejercicio11;

//Programa modificado por Moises Sepulveda Segarra

public class ExerciciHerencia {
	
		private static final Llibre Pelicula = null;

		public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Llibre llibre1 = new Llibre("11AAA", "El juego de Ender", "Orson Scott Card", 321);
			Llibre llibre2 = new Llibre("22BBB", "La historia interminable", "Michael Ende", 521);
			Llibre llibre3 = new Llibre("33CCC", "El vell i la mar", "Ernest Hemingway", 560);
			
			Pelicula peli1 = new Pelicula("123ZZ", "Titanic", "James Cameron", 1999);
			Pelicula peli2 = new Pelicula("456YY", "Avatar", "James Cameron", 2014);
			
			Usuari usu1 = new Usuari("11223344A", "Nacho", "C/ Java 8","966112233");
			
			usu1.nouMaterial(llibre1);
			usu1.nouMaterial(llibre2);
			usu1.nouMaterial(llibre3);
			usu1.nouMaterial(peli1);
			
		//System.out.println("Usuari: " + usu1.getNom());
			
			System.out.println("Té " + usu1.getContadorMat() + " materials en préstec");
			Material[] materials = usu1.getMaterials();
			
		for (int i = 0; i < usu1.getContadorMat(); i++){
			if (materials[i] instanceof Llibre && materials[i].getNumPags() > 500) {
				System.out.println ("Es un Ladrillo");
			}
				System.out.println(materials[i].mostrar());
		
		}
		
		
		
		
		}
}
