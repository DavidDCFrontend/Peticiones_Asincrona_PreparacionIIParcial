package es.dsw.models;

public class Alumno {

	private String Nif;
	private String Nombre;
	private String Apellidos;
	private int Edad;
	private int CodigoPostal;

	public Alumno(String nif, String nombre, String apellidos, int edad, int codigoPostal) {
		this.Nif = nif;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Edad = edad;
	    this.CodigoPostal = codigoPostal;
	}
	public String getNif() {
		return this.Nif;
	}
	public void setNif(String nif) {
		this.Nif = nif;
	}
	public String getNombre() {
		return this.Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getApellidos() {
		return this.Apellidos;
	}
	public void setApellidos(String apellidos) {
		this.Apellidos = apellidos;
	}
	public int getEdad() {
		return this.Edad;
	}
	public void setEdad(int edad) {
		this.Edad = edad;
	}
	public int getCodigoPostal() {
		return CodigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		CodigoPostal = codigoPostal;
	}
}
