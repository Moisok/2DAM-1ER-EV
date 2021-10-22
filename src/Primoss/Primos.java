package Primoss;


import java.util.Scanner;

public class Primos {
	
	public static void main(String[] args) {
		
		Scanner lligPrimer=new Scanner(System.in);
		
		int num, comptador;
		boolean esPrimer;
		
		esPrimer=true;
		
		do {
			
			System.out.print("Introdueix un numero: ");
			num = lligPrimer.nextInt();
			
			if (num<=0) {
				System.out.println("El numero introduit ha de ser >=0, torna a provar....");
			}
		}while (num<0);
		
		
	
		for(int i=2;i<num;i++) {
			
			if (num%i==0)
				esPrimer=false;
		} 	
		
		/*
		 
		  // versi� amb WHILE
		
		comptador = num - 1;
	        while (esPrimer == true && comptador > 1) {
	            if (num % comptador == 0) {
	            	esPrimer = false;
	            }
	            comptador--;
	        } 
	        
	        */
		
		
		if (esPrimer==true)
			System.out.println("En numero " + num + " es primo");
		else
			System.out.println("En numero " + num + " NO es primer");
		
		
		
		
		
	}
	
	}
	