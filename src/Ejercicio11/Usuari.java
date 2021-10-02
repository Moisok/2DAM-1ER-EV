package Ejercicio11;

public class Usuari {
	// Atributs o camps estàndard
	private String dni;
	private String nom;
	private String adreça;
	private String telefon;
	// Afegim la informació dels materials
	private Material[] materials;
	private int contadorMat;
	public static final int MAX_MAT = 5;
	// Constructor
	public Usuari(String dni, String n, String a, String t)
	{
	this.dni = dni;
	this.nom = n;
	this.adreça = a;
	this.telefon = t;
	this.materials = new Material[MAX_MAT];
	this.contadorMat = 0;
	}
	// Constructor de còpia
	public Usuari(Usuari u)
	{
	this.dni = u.dni;
	this.nom = u.nom;
	this.adreça = u.adreça;
	this.telefon = u.telefon;
	this.materials = u.materials;
	this.contadorMat = u.contadorMat;
	}
	// Mètodes
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
	public String getAdreça()
	{
	return adreça;
	}
	public void setAdreça(String a)
	{
	adreça = a;
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
	return nom+"("+dni+","+adreça+","+telefon+")";
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
	// Esborra el material de la posició indicada de l'array
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
