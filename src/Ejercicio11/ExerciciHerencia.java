package Ejercicio11;

//Programa modificado por Moises Sepulveda Segarra

public class ExerciciHerencia {
	
		private static final Llibre Pelicula = null;

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Llibre llibre1 = new Llibre("11AAA", "El juego de Ender", "Orso Scott Card", 321);
			Llibre llibre2 = new Llibre("22BBB", "La historia interminable", "Michael Ende", 411);
			Llibre llibre3 = new Llibre("33CCC", "El vell i la mar", "ErnestHemingway", 138);
			Llibre llibre4 = new Llibre("45678", "La gola del llop", "Paquito perez", 599);
			Llibre llibre5 = new Llibre("47045", "El Senior de los seniores", "Alberto garcia", 538);
			
			Pelicula peli1 = new Pelicula("123ZZ", "Titanic", "JamesCameron", 1999);
			Pelicula peli2 = new Pelicula("456YY", "Avatar", "JamesCameron", 2014);
			Usuari usu1 = new Usuari("11223344A", "Nacho", "C/ Java 8","966112233");
			Usuari usu2 = new Usuari("99999999B", "Jordi", "C/ Python 7","999999999");
			usu1.nouMaterial(llibre1);
			usu1.nouMaterial(llibre4);
			usu1.nouMaterial(llibre5);
			usu1.nouMaterial(llibre2);
			usu1.nouMaterial(peli1);
			usu2.nouMaterial(llibre3);
			usu2.nouMaterial(peli2);
			usu2.nouMaterial(llibre4);
			//System.out.println("Usuari: " + usu1.getNom());
			System.out.println("\n\nUsuari: " + usu1.mostrar());
			System.out.println("Té " + usu1.getContadorMat() + " materialsen préstec");
			Material[] materials = usu1.getMaterials();
			
			for (int i = 0; i < usu1.getContadorMat(); i++)
			{
			if (materials[i] instanceof Llibre && materials[i].getNumPags() > 500) {
					System.out.println ("Es un Ladrillo");
			}	
			System.out.println(materials[i].mostrar());
			}
			//System.out.println("\n\nUsuari: " + usu2.getNom());
			System.out.println("\n\nUsuari: " + usu2.mostrar());
			System.out.println("Té " + usu2.getContadorMat() + " materialsen préstec");
			Material[] materials2 = usu2.getMaterials();
			
			for (int i = 0; i < usu2.getContadorMat(); i++)
			{
			if (materials[i] instanceof Llibre && materials[i].getNumPags() > 500) {
					System.out.println ("Es un Ladrillo");
			}
			System.out.println(materials2[i].mostrar());
			}
			}
			}


/*for (int i = 0; i < usu1.getContadorMat(); i++){
if (materials[i] instanceof Llibre && materials[i].getNumPags() > 500) {
	System.out.println ("Es un Ladrillo");
}
	System.out.println(materials[i].mostrar());

}*/
