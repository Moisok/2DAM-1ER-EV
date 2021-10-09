package EjercicioExtra2;

import java.util.ArrayList;

public class EjercicioEx2_Main {

	public static void main(String[] args) {
		
		//Creamos los empleados de madrid
		Empleado Juan = new Empleado ("Juan", "Programador", 19, 0, 1200, 12,"Madrid");
		
		Empleado Agapito = new Empleado ("Agapito", "Analista", 20, 2, 1250, 12,"Madrid");
		
		Empleado Maria = new Empleado ("Maria", "Jefa de oficina", 24, 4, 1600, 14,"Madrid");
		
		Empleado Ramon = new Empleado ("Ramon", "Programador", 22, 2, 1200, 12, "Madrid");
		
		Empleado Jennifer = new Empleado ("Jennifer", "Analista", 26, 5, 1300, 14 ,"Madrid");
		
		//Ahora creamos los empleados de Valencia
		Empleado Andy = new Empleado ("Andy", "Programador", 23, 4, 1250, 14,"Valencia");
		
		Empleado Albert = new Empleado ("Albert", "Analista", 28, 8, 1550, 14,"Valencia");
		
		Empleado Soraya = new Empleado ("Soraya", "Jefa de oficina", 30, 6, 1600, 14,"Valencia");
		
		Empleado Sandra = new Empleado ("Sandra", "Programador", 25, 5, 1500, 14, "Valencia");
		
		Empleado Miguel = new Empleado ("Miguel", "Analista", 29, 9, 1550, 14 ,"Valencia");
		
		//Por ultimo el director de la empresa
		Empleado Adolfo = new Empleado ("Adolfo", "Director",40 ,15 ,3600 ,16 ,"Madrid");
		
		//Creamos ArrayList
		ArrayList <Empleado> empleados = new ArrayList<Empleado>();

		//A�adimos todos los empleados al ArryList de manera desordenada
		empleados.add(Miguel);
		empleados.add(Albert);
		empleados.add(Jennifer);
		empleados.add(Adolfo);
		empleados.add(Sandra);
		empleados.add(Soraya);
		empleados.add(Andy);
		empleados.add(Ramon);
		empleados.add(Maria);
		empleados.add(Agapito);
		empleados.add(Juan);
		
		//Ahora creamos un bucle for each para calcularles a todos el salario bruto
		for (Empleado empleado : empleados) {
			empleado.sueldoAnual();
		}
		
		//Ahora creamos otro bucle para mostrar de manera desordenada
		for (Empleado empleado : empleados) {
			System.out.println(empleado.mostrar());
		}
		
		//Ahora ordenamos aplicando los criterios de ordenacion
		
		
	}

}
