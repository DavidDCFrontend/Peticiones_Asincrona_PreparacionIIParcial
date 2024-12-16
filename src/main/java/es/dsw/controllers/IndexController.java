package es.dsw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.dsw.models.Alumno;
import es.dsw.models.Grupo;
import es.dsw.models.Resultado;


@Controller
public class IndexController {
	
	private Grupo grupo = new Grupo();

	@GetMapping(value= {"/","/index"})
	public String idx() {
		
		return "index";
	}
	
	@PostMapping("/getDatosAlumno")
	@ResponseBody
    public Resultado getDatosAlumno(@RequestParam(defaultValue="") String nif) {
		
        // Verificar si se ha proporcionado el NIF
        if (nif.trim().isEmpty()) {
            return new Resultado(null, "", true, "No ha indicado un NIF.");
        }

        // Buscar el alumno en la lista
        Alumno alumnoEncontrado = null;
        for (Alumno alumno : grupo.getListaAlumnos()) {
            if (alumno.getNif().equals(nif)) {
                alumnoEncontrado = alumno;
                break;
            }
        }

        // Si el alumno no es encontrado
        if (alumnoEncontrado == null) {
            return new Resultado(null, "", true, "Alumno con NIF: " + nif + " no localizado.");
        }

        // Determinar municipio
        String municipio = alumnoEncontrado.getCodigoPostal() == 35016 ? "Las Palmas de Gran Canaria" : "Otro municipio";

        // Crear el resultado con los datos del alumno y municipio
        return new Resultado(alumnoEncontrado, municipio, false, "");
    }
	
	
	
	/*
	@PostMapping(value= {"/getDatosAlumno"}, produces="application/json")
	@ResponseBody
	public Resultado getDatosAlumno(@RequestParam(defaultValue="") String nif) {
		
		Alumno alumnoNifCoincidente = null;
		int codigoPostal = 0;
		boolean error;
		String municipio = "";
		String msgError;
		
		// Si el usuario no indica ningún NIF se le informa del error
		if("".equals(nif.trim())) {
			error = true;
			msgError = "No ha indicado un NIF";
			Resultado objResultado = new Resultado(null, "Las palmas de GC", error, msgError);	
			return objResultado;
			
		} 
		
		// Si el usuario indica un NIF almacenamos todos los NIF de usuarios en una lista
		List<String> listaNifs = new ArrayList<>();
		
		Grupo objGrupo = new Grupo();
		
		for(Alumno alumno : objGrupo.getListaAlumnos()) {
			
			// Si el NIF introducido coincide alguno de los existentes, almacenamos el código postal del alumno cuyo NIF coincide y a dicho alumno
			if(codigoPostal == 0) {
				if(nif.equals(alumno.getNif())) {
					codigoPostal = alumno.getCodigoPostal();
					alumnoNifCoincidente = new Alumno(alumno.getNif(), alumno.getNombre(), alumno.getApellidos(), alumno.getEdad(), codigoPostal);
				}
			}
			
			listaNifs.add(alumno.getNif());
		}
		
		// Si el NIF introducido no coincide con ninguno de la lista
		if(!listaNifs.contains(nif)) {
			error = true;
			msgError = "Alumno con NIF: " + nif + " no localizado";
			Resultado objResultado = new Resultado(null, municipio, error, msgError);	
			return objResultado;
			
		} else {
			if(codigoPostal == 35016) {
				error = false;
				msgError = "";
				municipio = "Las Palmas de GC";
				Resultado objResultado = new Resultado(alumnoNifCoincidente, municipio, error, msgError);	
				return objResultado;
				
			} else {
				error = false;
				msgError = "";
				municipio = "Otro municipio";
				Resultado objResultado = new Resultado(alumnoNifCoincidente, municipio, error, msgError);	
				return objResultado;
			}
			
		}
	}
	*/
	
	
	/*
	 * Ejemplo para lograr obtener JSON deseado
	 * 
	@GetMapping(value= {"/getDatosAlumno"}, produces="application/json")
	@ResponseBody
	public Resultado getDatosAlumno() {
		
		Grupo objGrupo = new Grupo();
		
		Alumno alumno = objGrupo.getListaAlumnos().get(0);
		
		Resultado objResultado = new Resultado(alumno, "Las palmas de GC", false, "");
		
		return objResultado;
	}
	
	*/
}