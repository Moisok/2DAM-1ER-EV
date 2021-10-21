package EjercicioExtra2;

import java.util.ArrayList;
import java.util.Collections;

public class EjercicioEx2_Main {

	public static void main(String[] args) {
		
		
		//Creamos los empleados de madrid
		Empleado Juan = new Empleado ("Juan", "Programador", 19, 2, 1100, 12,"Madrid");
		
		Empleado Agapito = new Empleado ("Agapito", "Analista", 20, 2, 1350, 12,"Madrid");
		
		Empleado Maria = new Empleado ("Maria", "Jefa de oficina", 24, 9, 1600, 14,"Madrid");
		
		Empleado Ramon = new Empleado ("Ramon", "Programador", 22, 2, 1200, 12, "Madrid");
		
		Empleado Jennifer = new Empleado ("Jennifer", "Analista", 26, 5, 1300, 14 ,"Madrid");
		
		//Ahora creamos los empleados de Valencia
		Empleado Andy = new Empleado ("Andy", "Programador", 23, 2, 1250, 14,"Valencia");
		
		Empleado Albert = new Empleado ("Albert", "Analista", 28, 8, 1550, 14,"Valencia");
		
		Empleado Soraya = new Empleado ("Soraya", "Jefa de oficina", 30, 9, 1600, 14,"Valencia");
		
		Empleado Sandra = new Empleado ("Sandra", "Programador", 25, 2, 1500, 14, "Valencia");
		
		Empleado Miguel = new Empleado ("Miguel", "Analista", 29, 8, 1550, 14 ,"Valencia");
		
		//Director
		Empleado Adolfo = new Empleado ("Adolfo", "Director",40 ,15 ,3600 ,16 ,"Madrid");
		
		
		//Creamos ArrayList
		ArrayList <Empleado> empleados = new ArrayList<Empleado>();

		//Añadimos todos los empleados al ArryList de manera desordenada
		empleados.add(Miguel);
		empleados.add(Albert);
		empleados.add(Jennifer);
		empleados.add(Sandra);
		empleados.add(Soraya);
		empleados.add(Andy);
		empleados.add(Ramon);
		empleados.add(Maria);
		empleados.add(Agapito);
		empleados.add(Juan);
		empleados.add(Adolfo);
		
		//Ahora creamos un bucle for each para calcularles a todos el salario bruto
		for (Empleado empleado : empleados) {
			empleado.sueldoAnual();
		}
		
		
		//Ahora ordenamos aplicando los criterios de ordenacion
		Collections.sort(empleados);
		for (Empleado empleado : empleados) {
			System.out.println(empleado.mostrar());
		}
		
		System.out.println(" ");
		
		//Ahora ordenamos con el comparar sueldo
		Collections.sort(empleados, new ComparaSueldo());
		for (Empleado empleado : empleados) {
			System.out.println(empleado.mostrar());
		}
		
	}

}
