package Ejercicio11;

class Pelicula extends Material
{
// Atributos propios de las películas
private String director;
private int estreno;
// Constructor
public Pelicula(String codigo, String titulo, String director, int
estreno)
{
super(codigo, titulo);
this.director = director;
this.estreno = estreno;
}
// Getters y setters de director y año de estreno
public String getDirector()
{
return director;
}
public void setDirector(String director)
{
this.director = director;
}
public int getEstreno()
{
return estreno;
}
public void setEstreno(int estreno)
{
this.estreno = estreno;
}
@Override
public String mostrar()
{
return super.mostrar() + ", " + director + ", " + estreno;
}
}

