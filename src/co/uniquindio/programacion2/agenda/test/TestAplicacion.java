package co.uniquindio.programacion2.agenda.test;

import co.uniquindio.programacion2.agenda.exception.ContactoExcepction;
import co.uniquindio.programacion2.agenda.model.Agenda;
import co.uniquindio.programacion2.agenda.model.Contacto;
import co.uniquindio.programacion2.agenda.model.Grupo;
import co.uniquindio.programacion2.agenda.test.TestData;

import java.text.DecimalFormat;

public class TestAplicacion {
	
	
	public static void main(String[] args) {
		TestData testData = new TestData();
		
		DecimalFormat formateador = new DecimalFormat("####.####");
		Agenda agenda = testData.inicializarDatosPrueba(); 
//new Agenda("Agenda1");
//		for (int i = 0; i<4; i++) {
//			Contacto con = new Contacto("Contacto"+(i+1),"310231332"+i, 20+i);
//			try {
//				agenda.crearContacto(con.getNombre(),con.getTelefono(),con.getEdad());
//			} catch (ContactoExcepction e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		//Main metodo 2 Desviacion estandar edades contactos
		agenda.mostrarContactos();
		System.out.println("Desviacion estandar en edades: "+formateador.format(agenda.desviacionEstandarEdadesContactos()));

		//Main metodo 1 Obtener los grupos que tengan un contacto donde su nombre inicie con vocal
//		Grupo grupo = new Grupo("Grupo A");
//		Grupo grupo1 = new Grupo("Grupo B");
//		
//		for (int i = 0; i <3; i++) {
//			//Creamos los contacto
//			Contacto con = new Contacto("Alex"+(i+1),"310231332"+i, 20+i);
//			Contacto con1 = new Contacto("Andres"+(i+1),"310231332"+i, 20+i);
//			//Creamos un grupo con contactos
//			grupo.crearContacto(con);
//			grupo1.crearContacto(con1);
//		}
//		
//		//agregamos en la agenda los grupos
//		agenda.agregarGrupo(grupo);
//		agenda.agregarGrupo(grupo1);
//		
//		//mostrar grupos y agenda
//		agenda.mostrarGrupo();
//		System.out.println(agenda.toString());
//		
//		//Mostrar metodo 1
//		System.out.println("Grupos que contienen contactos que inician por vocal");
//		agenda.mostrarGruposDeContactoConVocal();
		
	}

}
