
$(document).ready(function(){

	//Se inicializa la ventana jquery
	//'$("#Win1")':Esto selecciona un elemento HTML con el id "Win1". El signo $ es el selector de jQuery, que se utiliza para seleccionar elementos en el DOM (Document Object Model).
	//            El # delante de "Win1" indica que se está seleccionando un ID con ese nombre.
	//'dialog()': Este es un método de jQuery UI que convierte el elemento seleccionado en un diálogo modal. Un diálogo es una ventana emergente que puede contener contenido, y en este caso, 
	//          se configura para tener ciertas opciones.
	//'modal: true':Esta opción indica que el diálogo será modal. Esto significa que cuando el diálogo esté abierto, el resto del contenido de la página quedará bloqueado, y el usuario no 
	//              podrá interactuar con él hasta que cierre el diálogo.
	//'autoOpen: false': Esto significa que el diálogo no se abrirá automáticamente cuando se cargue la página. Para abrirlo, deberás llamar a su método .dialog("open") en algún momento desde el código JavaScript.
 	$("#Win1").dialog({modal: true, width: 650, height: 422, autoOpen: false, resizable: false});
 	
 	//Se sobrecarga evento click del botón "Nuevo Alumno"
	$("#btn1").on("click",function(){
		
		$('#ResultadoF1').html('');
		$('#msgError').html('');
	    $('#Win1').dialog('open');
	
	});
	
	//Se sobrecarga evento click del botón "Buscar"
	$("#btnSend").on("click",function(){
	
		let data_nif = $("#F1Nif").val();  // Almacena NIF introducido
		
		$('#msgError').html('');
		$('#ResultadoF1').html('');
		
		$.ajax({
			url: '/getDatosAlumno', 
			dataType: "json",
			method: 'POST',
			data:   {nif:data_nif},
			success: function(respuesta){
				if (respuesta.error) {
					$('#msgError').html('<p>'+respuesta.msgError+'</p>');
				} else {
					$('#ResultadoF1').html('<p><b>Nif: </b> '+respuesta.alumno.nif+'</p>' +
            				               '<p><b>Nombre: </b> '+respuesta.alumno.nombre+'</p>' +
            				               '<p><b>Apellidos: </b> '+respuesta.alumno.apellidos+'</p>' +
            				               '<p><b>Edad: </b> '+respuesta.alumno.edad+'</p>' +
            				               '<p><b>Municipio: </b> '+respuesta.municipio+'</p>');
            	    $('#Win1').dialog('close');
				}	
			},
			error: function(){
				$('#msgError').html('<p>Error Fatal</p>');
			}
		 });
	
	});


});