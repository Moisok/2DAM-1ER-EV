package Ejercicio10;

//Clase padre region

public abstract class Region implements IData {

	private String nombreRegion;
	
	//Constructor
	Region (String nombreRegion){
		this.nombreRegion = nombreRegion;
	}
	
}
