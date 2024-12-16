package es.dsw.models;

import java.util.ArrayList;

public class Grupo {

	private ArrayList<Alumno> ListaAlumnos;

	public Grupo() {
		this.ListaAlumnos = new ArrayList<Alumno>();
		
		this.ListaAlumnos.add(new Alumno("49992122M", "Miguel", "Ramirez Serrano", 28, 35016));
		this.ListaAlumnos.add(new Alumno("49992123A", "Lucia", "Pérez Gonzalez", 34, 35200));
		this.ListaAlumnos.add(new Alumno("49992124C", "Alberto", "Gonzalez Sanchez", 21, 35016));
		this.ListaAlumnos.add(new Alumno("49992125F", "Yurena", "Sanchez Lorenzo", 45, 35200));
		this.ListaAlumnos.add(new Alumno("49992126G", "Pedro", "Lorenzo García", 52, 35016));
		this.ListaAlumnos.add(new Alumno("49992127H", "Iván", "García Perico", 44, 35016));
		this.ListaAlumnos.add(new Alumno("49992128I", "Melisa", "Perico Betancort", 41, 35016));
		this.ListaAlumnos.add(new Alumno("49992129J", "Felipe", "Betancort Ortega", 27, 35400));
		this.ListaAlumnos.add(new Alumno("49992120K", "Alejandro", "Ortega Serrano", 21, 35016));
		this.ListaAlumnos.add(new Alumno("49992121L", "Ismael", "Serrano Mesa", 21, 35400));
	}
	
	public ArrayList<Alumno> getListaAlumnos() {
		return ListaAlumnos;
	}
}
