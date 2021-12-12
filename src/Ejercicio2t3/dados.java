public class dados {

	public static void main(String[] args) throws InterruptedException {
		
		tirada tirardados1;
		tirada tirardados2;
		tirada tirardados3;
		
		resultadosDados resultats = new resultadosDados();
		
		tirardados1 = new tirada(1, resultats);
		tirardados2 = new tirada(2, resultats);
		tirardados3 = new tirada(3, resultats);
		
		tirardados1.start();
		tirardados1.join();
		tirardados2.start();
		tirardados2.join();
		tirardados3.start();
		tirardados3.join();
		
		System.out.println("Total tirada: " + resultats.getTotal());
		System.out.println("Final hilo principal");
		
	}

}

//Clase intermedia
class resultadosDados {
	
	int tirada = 0;
	
	int total = 0;
	
	public void setTotal(int tirada) {
		this.tirada = tirada;
	}
	
	public void calcular() {
		total = total + tirada;
	}
	
	public int getTotal() {
		return total;
	}
	
}

//Clase para los dados
class tirada extends Thread {
	
	int ntirada;
	int resultado = 0;
	resultadosDados resultats;

	tirada (int ntirada, resultadosDados resultats){
		this.ntirada=ntirada;
		this.resultats = resultats;
	}
	
	@Override
	public void run () {
		resultado=(int)(Math.random()*(6 - 1)+1);
		resultats.setTotal(resultado);
		resultats.calcular();
		System.out.println("Tirada hilo dado: " + ntirada + " : " + resultado);	
	}
	
}
