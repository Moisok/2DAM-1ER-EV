package Ejercicio11;

public class Llibre extends Material {
private String autor;
private int numPags;
public Llibre(String c,String t,String a,int n) {
super (c, t);
autor=a;
numPags=n;
}
public String getAutor() {
return autor;
}
public void setAutor(String a) {
this.autor = a;
}
public  int getNumPags() {
return numPags;
}
public void setNumPags(int numPags) {
this.numPags = numPags;
}
@Override
public String mostrar() {
return super.mostrar() + "("+autor+","+numPags+")";
}
}


