package Ejercicio5t2;

import java.util.*;
import java.util.concurrent.*;


	//Clase Callable
	 class Division implements Callable <Integer> {
		
		private int num;
		
		public Division(int num) {
			this.num=num;

		}

		@Override
		public Integer call() throws Exception {
			if (num % 2 == 0) {
				return num;
			}
			else if (num % 3 == 0) {
				return num;
			}
			else {
				return 0;
			}
		}
		
	}


