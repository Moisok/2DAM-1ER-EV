package EjercicioExtra2;

import java.util.Comparator;

public class ComparaSueldo implements Comparator<Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		if (o1.getSueldoBrutoAnual() > o2.getSueldoBrutoAnual()) {
			return -1;
		}

		if (o1.getSueldoBrutoAnual() < o2.getSueldoBrutoAnual()) {
			return 1;
		}
		
		else {
			return 0;
		}
		
	}

}
