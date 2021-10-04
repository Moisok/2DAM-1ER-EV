package Ejercicio11;

public class Usuari {
	// Atributs o camps est�ndard
	private String dni;
	private String nom;
	private String direccion;
	private String telefon;
	// Afegim la informaci� dels materials
	private Material[] materials;
	private int contadorMat;
	public static final int MAX_MAT = 5;
	// Constructor
	public Usuari(String dni, String n, String a, String t)
	{
	this.dni = dni;
	this.nom = n;
	this.direccion = direccion;
	this.telefon = t;
	this.materials = new Material[MAX_MAT];
	this.contadorMat = 0;
	}
	// Constructor de c�pia
	public Usuari(Usuari u)
	{
	this.dni = u.dni;
	this.nom = u.nom;
	this.direccion = u.direccion;
	this.telefon = u.telefon;
	this.materials = u.materials;
	this.contadorMat = u.contadorMat;
	}
	// M�todes
	public String getDni()
	{
	return dni;
	}
	public void setDni(String d)
	{
	dni = d;
	}
	public String getNom()
	{
	return nom;
	}
	public void setNom(String n)
	{
	nom = n;
	}
	public String getdireccion()
	{
	return direccion;
	}
	public void setdireccion(String a)
	{
		direccion = a;
	}
	public String getTelefon()
	{
	return telefon;
	}
	public void setTelefon(String t)
	{
	telefon = t;
	}
	// Getters per obtindre l'array de materials i la quantitat
	public Material[] getMaterials()
	{
	return materials;
	}
	public int getContadorMat()
	{
	return contadorMat;
	}
	public String mostrar() {
	return nom+"("+dni+","+direccion+","+telefon+")";
	}
	// Afegix un nou material a l'array e incrementa el contador
	public void nouMaterial(Material nou)
	{
	if (contadorMat < MAX_MAT)
	{
	materials[contadorMat] = nou;
	contadorMat++;
	}
	}
	// Esborra el material de la posici� indicada de l'array
	public void esborraMaterial(int posicio)
	{
	if (posicio >= 0 && posicio < contadorMat)
	{
	for (int i = posicio; i < contadorMat -1; i++)
	{
	materials[i] = materials[i+1];
	}
	contadorMat--;
	}
	}
	}
