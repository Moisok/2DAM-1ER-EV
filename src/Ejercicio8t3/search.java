package Ejercicio8t3;

//Hilos
class search extends Thread{
	tiempo temps;
	search (tiempo temps){
		this.temps = temps;
	}
	@Override
	public void run() {
		temps.busqueda();
		temps.busqueda2();
	}
}