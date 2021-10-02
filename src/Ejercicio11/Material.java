package Ejercicio11;

public class Material {
protected String codi;
protected String titol;
public Material(String c, String t) {
this.codi=c;
this.titol=t;
}
public String getCodi() {
return codi;
}
public void setCodi(String c) {
if(c!=null && !c.equals("")) {
codi=c;
}
}

public  int getNumPags() {
return (Integer) null;
}

public String getTitol() {
return titol;
}
public void setTitol(String t) {
titol=t;
}
public String mostrar() {
return codi + ": " +titol;
}
}
