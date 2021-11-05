package co.uniquindio.programacion2.agenda.test;


import  java.util.Iterator ;
import java.util.Random;

import co.uniquindio.programacion2.agenda.model.Agenda;
import co.uniquindio.programacion2.agenda.model.Contacto;
import co.uniquindio.programacion2.agenda.model.Grupo;

public class TestData {
	
	public TestData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 9-G5: Inicializar de forma aleatoria la información de los contactos. (TestData)[20 nombres de prueba
	 * @return
	 */
	
	public Agenda inicializarDatosPrueba() {
		
		Agenda agenda = new Agenda();
		
		Contacto[] listaContactos = agenda.getListContactos();
		
		Grupo [] listaGrupos = agenda.getListGrupos();
		
		String nombres[] = {"Juan", "Pablo", "Manuel", "Jhon", "Stiven", "Santiago", "Kimberly","Andrea","Sofia","Maria","Yuliana","Paula","Pedro",
				"Julian", "Agustin", "Oscar", "Tomas", "Susana", "Milena", "Luisa"};
		
		String nombresGrupos[] = {"Amigos", "Familia ","Deporte", "Programacion ", "Trabajo"};

		
		//generarNombre(nombres);
		//generarNumeroTel();
		
		for (int i = 0; i < listaContactos.length; i++) {
			
			if (listaContactos[i] == null) {
				listaContactos[i] = new Contacto(generarNombre(nombres), generarNumeroTel(),inicializarEdadAleatoria());
			}
			
		}
		
		/**
		 * 10-G1- Inicializar de forma aleatoria la información de los grupos.(TestData)
		 */
		
		//Seccion que se encarga de crear los grupos
		Random EdadAleatorio = new Random();
		
		for(int i = 0; i < listaGrupos.length; i++ ){
			
		    /**
		     * int tamanioGrupo = (int) ((Math.random()* 19));
		     * 
		     * no es valido por que se pueden generar tamaños en cero.
		     * */
			
			int tamanioGrupo = (int) ((Math.random()* 10)+1);
			
			if(listaGrupos[i] == null){
				listaGrupos[i] = new Grupo(generarNombre(nombresGrupos),tamanioGrupo);
			}
			
		}
		
		
		
		//G1-Llenar Grupos 
		for(int i=0; i<listaGrupos.length;i++){
			
			int indiceContactos = 0; 
			
			//System.out.println("tamaño grupo: "+ listaGrupos[i].getTamanioGrupo());
			
			for(int j=0; j < listaGrupos[i].getTamanioGrupo();){
				
				indiceContactos = (int) ((Math.random()* 10));
				
				Contacto contacto = listaContactos[indiceContactos];
				
				if(!listaGrupos[i].validarExistencia(contacto)){
					//System.out.println("Entro al if");
					listaGrupos[i].AgregarContacto(contacto);
					j++;
				}
				
				//System.out.println("valor de j:" + j);
			}
		}
		
		/*
		Contacto contacto = new Contacto("Juan", "12345", 20);
		listaContactos[0] = contacto;
		
		contacto = new Contacto("Pedro", "12345",21);
		listaContactos[1] = contacto;
		
		contacto = new Contacto("Ana", "12345",22);
		listaContactos[2] = contacto;
		*/
		return agenda;
		
	}
	
	/**
	 * 
	 * 11-G3: Inicializar los datos de la edad del contacto de forma aleatoria entre un rango de 15 a 60
	 * 
	 */
	
	public int inicializarEdadAleatoria(){
		
		int edad;
		
		//Random es un objeto que permite obtener numeros aleatorios entre varios intervalos
		Random EdadAleatorio = new Random();
		
		// a este entero que es edad se le asigna un valor aleotario y con el metodo nextInt nos devuelve un valor entero entre 15 y 60 
				
		edad = 15 + EdadAleatorio.nextInt(60);
		
		return edad;
		
	}
	
	/**
	 * 9-G5: Inicializar de forma aleatoria la información de los contactos. (TestData)[20 nombres de prueba
	 * @return
	 */
	
	private String generarNumeroTel() {
		
		int num  = (int)((Math.random()*8999) + 1000);
		
		if (num < 1000) {
			generarNumeroTel();
		}
		
		return String.valueOf(num);
	}

	private String generarNombre(String[] nombres) {
		
		int posicion = (int)(Math.random()* nombres.length);
		
		return nombres[posicion];
	}
	
	
	
	
	
	
	
}
