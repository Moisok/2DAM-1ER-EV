package Ejercicio6t3;

public class main {

	public static void main(String[] args) {
		
		//Principal
		ThreadGroup main = new ThreadGroup ("Principal");
		Thread main1 = new Thread (main, "Hilo main");
		
		//Grupo 1
		ThreadGroup sgr = new ThreadGroup (main, "Subgrupo1");
		Thread hilo1_1 = new Thread (sgr, "Hilo1");
		Thread hilo2_2 = new Thread (sgr, "Hilo2");
		
		//Grupo 2
		ThreadGroup sgr2 = new ThreadGroup(main, "Subgrupo2");
		Thread hilo3_3 = new Thread (sgr2, "Hilo3");
		

		//Informacion
		//Nombre de los hilos activos
		System.out.println("Nombre de del grupo del hilo 1 " + "[" + hilo1_1.getThreadGroup().getName() + "]");
		System.out.println("Nombre de del grupo del hilo 2 " + "[" + hilo1_1.getThreadGroup().getName() + "]");
		System.out.println("Nombre de del grupo del hilo 3 " + "[" + hilo3_3.getThreadGroup().getName() + "]");
		System.out.println("Nombre de del grupo del main " + "[" + main1.getThreadGroup().getName() + "]\n");
		
		//Numero de grupos activos
		hilo1_1.start();
		hilo2_2.start();
		hilo3_3.start();
		main1.start();
		
		System.out.println("Numero de hilos activos [GRUPO1] " + main.activeGroupCount());
		System.out.println("Numero de hilos activos [GRUPO1] " + sgr.activeGroupCount());
		System.out.println("Numero de hilos activos [GRUPO2] " + sgr2.activeGroupCount()+ "\n");
		
		//Detalles de los grupos
		System.out.println("Detalles de los grupos\n");
		System.out.println("Grupo MAIN");
		main.list();
		System.out.println("\n");
		System.out.println("Grupo 1");
		sgr.list();
		System.out.println("\n");
		System.out.println("Grupo 2");
		sgr2.list();
		System.out.println(" ");
		
		//Priporidades de los grupos existentes
		System.out.println("Prioridad [MAIN]: " + main.getMaxPriority());
		System.out.println("Prioridad [GRUPO1]: " + sgr.getMaxPriority());
		System.out.println("Prioridad [GRUPO2]: " + sgr2.getMaxPriority() + "\n");
		sgr.setMaxPriority(3);
		sgr2.setMaxPriority(7);
		System.out.println("Prioridad cambiada");
		System.out.println("Prioridad [MAIN]: " + main.getMaxPriority());
		System.out.println("Prioridad [GRUPO1]: " + sgr.getMaxPriority());
		System.out.println("Prioridad [GRUPO2]: " + sgr2.getMaxPriority()+"\n");
		
		
		//Nombre del padre y grupo
		System.out.println("Nombre y padre de [MAIN] " + main.getName() + " " +main.getParent());
		System.out.println("Nombre y padre de [GRUPO1] " + sgr.getName() + " " +sgr.getParent());
		System.out.println("Nombre y padre de [GRUPO2] " + sgr2.getName() + " " +sgr2.getParent() + "\n");
		
		//Comprobar si los hilso perteneces al main principal
		System.out.println("¿Pertenece el [GRUPO1] al principal?: " + main.parentOf(sgr));
		System.out.println("¿Pertenece el [GRUPO2] al principal?: " + main.parentOf(sgr2));
		
	}

}
