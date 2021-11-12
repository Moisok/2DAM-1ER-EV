package EjercicioExtrabien;


import java.util.Scanner;
import java.util.concurrent.Semaphore;
 
public class WriterReader {
	public static final Semaphore RW_mutex = new Semaphore(1, true);
	public static final Semaphore R_mutex = new Semaphore(1, true);
	public static int RC = 0;
	
	public static void main(String[] args) {
		int wr, re;
		ResourceManage manage = new ResourceManage();
		Scanner input = new Scanner(System.in);
		System.out.print ("Ingrese el número de escritores:");
		wr = input.nextInt();
		 System.out.print ("Ingrese el número de lectores:");
		re = input.nextInt();
		 // Instanciar objetos de lector y escritor
		for (int i = 0; i < wr; i++) {
			 new Writer(i,manage).start();
		}
		for (int i = 0; i < re; i++) {
			new Reader(i,manage).start();
		}
	}
}
 
class Reader extends Thread {
	private int num;
	private ResourceManage manage;
 
	
	public Reader(int num, ResourceManage manage) {
		super();
		this.num = num;
		this.manage = manage;
	}
 
 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		manage.naps();
		manage.startRead();
		 System.out.println (Thread.currentThread (). getName () + "Lectura ...");
		manage.naps();
		manage.endRead();
	}
}
 
class Writer extends Thread {
	private int num;
	private ResourceManage manage;
 
	public Writer(int num, ResourceManage manage) {
		super();
		this.num = num;
		this.manage = manage;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		manage.naps();
		manage.Write();
		 System.out.println (Thread.currentThread (). getName () + "Escribir un libro ...");
	}
}
 
class ResourceManage {
	public ResourceManage() {
		super();
		// TODO Auto-generated constructor stub
	}
	 // Establecer aleatoriamente el tiempo de espera
	public void naps() {
		try {
			Thread.sleep((int) (3000 * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 // Comienza a leer la operación
	public void startRead() {
		try {
			WriterReader.R_mutex.acquire();
			if (WriterReader.RC == 0) {
				WriterReader.RW_mutex.acquire();
			}
			WriterReader.RC++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			WriterReader.R_mutex.release();
		}
	}
	 // El lector se va
	public void endRead() {
		try {
			WriterReader.R_mutex.acquire();
			WriterReader.RC--;
			if (WriterReader.RC == 0) {
				WriterReader.RW_mutex.release();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			WriterReader.R_mutex.release();
		}
	}
	 // Operación de escritor
	public void Write() {
		try {
			WriterReader.RW_mutex.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			WriterReader.RW_mutex.release();
		}
	}
}