package co.uniquindio.programacion2.agenda.aplicacion;

import java.util.Iterator;

import co.uniquindio.programacion2.agenda.exception.ContactoExcepction;
import co.uniquindio.programacion2.agenda.model.Agenda;
import co.uniquindio.programacion2.agenda.model.Contacto;
import co.uniquindio.programacion2.agenda.model.Grupo;
import co.uniquindio.programacion2.agenda.test.TestData;

public class Aplicacion {
	
	public static void main(String[] args) {
				
		Agenda agenda;
		TestData testData = new TestData();
	
		agenda = testData.inicializarDatosPrueba();
//		
//		for (int i = 0; i < agenda.obtenerContactosGrupo("amigos").length; i++) {
//			System.out.println(agenda.obtenerContactosGrupo("amigos")[i]);
//		}
		
		//Punto 2
//		agenda.mostrarGrupo();
//		
//		agenda.mostrarGruposDeContactoConVocal();
		
		//Punto 3
//		agenda.posicionImpar();
		
		//Punto 4
//		agenda.obtenerEdadRepite();
		
		//Punto 5
//		System.out.println("El promedio de edades son: "+agenda.promedioEdades());
		
		//Punto 6
//		agenda.obtenerContactosMenoresDeEdad();
		
		//Punto 7
//		System.out.println(agenda.obtenerContactosMenoresDeEdadV2().toString());

		//Punto 8
//		System.out.println("La desviacion estandar de las edades es: "+agenda.desviacionEstandarEdadesContactos());
		
		//Punto 9
//		agenda.imprimirDatosContactosHaciaAtras();
		
		//Punto 10
//		agenda.caracteresEnArreglo();
		
		//Punto 13
//		Contacto contacto = new Contacto("David");
//		agenda.setContactoAGrupo("Amigos", contacto);
//		
//		agenda.mostrarGrupo();
		
		//Punto 14 
		//Ordenan por telefono
//		agenda.ordenarListaContactos();
		
		//Punto 15
//		System.out.println(agenda.contactosPosicionPar());
		
		//Punto 16
//		System.out.println("El grupo con mayor numero de contacto es: "+agenda.obtenerGrupoMayoriaContactos());
		
		//crud
		//1. Crear contacto
		//crearContacto(agenda, "Carlos", "45678", 20);
		
		//2. actualizar contacto
//		actualizarContacto("Pedro","45678");
//		
//		//3. Consultar
//		consultarContacto("45678");
//		
//		//4. elmininar contacto
//		eliminarContacto("45678");

	}
	
	
	private static void crearContacto(Agenda agenda, String nombre, String telefono, int edad) {
		
		try {
			agenda.crearContacto(nombre,telefono,edad);
		} catch (ContactoExcepction e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private static void consultarContacto(String string) {
		// TODO Auto-generated method stub
		
	}

	private static void actualizarContacto(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarContacto(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
