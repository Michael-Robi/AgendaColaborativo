package co.uniquindio.programacion2.agenda.model;

import java.util.Arrays;

import javax.swing.JOptionPane;

import co.uniquindio.programacion2.agenda.exception.ContactoExcepction;

/**
 * Clase Agenda
 * 
 * @author Curso programación 2 nocturna
 *
 */
public class Agenda {

	private Contacto[] listContactos;
	private Grupo[] listGrupos;
	private String nombre;
	private int tamanioListContactos;
	private int tamanioListGrupos;
//	private int numContactos = 0;
	private int numGrupos = 0;

	/**
	 * Metodo constructor vacio en el cual sus parametros se asignan por defecto
	 */
	public Agenda() {
		this.nombre = "defecto";
		this.tamanioListContactos = 10;
		this.tamanioListGrupos = 10;
		listContactos = new Contacto[this.tamanioListContactos];
		listGrupos = new Grupo[this.tamanioListGrupos];

	}

	/**
	 * Metodo contructor en el cual se le asigna el nombre por parametro y el tamaño
	 * de los arreglos se asignan por defectos
	 * 
	 * @param nombre
	 */
	public Agenda(String nombre) {

		this.nombre = nombre;
		this.tamanioListContactos = 10;
		this.tamanioListGrupos = 10;
		listContactos = new Contacto[this.tamanioListContactos];
		listGrupos = new Grupo[this.tamanioListGrupos];
	}

	/**
	 * Metodo constructor en el cual se asignan los datos por medio de paramtros
	 * 
	 * @param nombre
	 * @param tamanioListContacto
	 * @param tamanioListGrupo
	 */
	public Agenda(String nombre, int tamanioListContactos, int tamanioListGrupos) {
		this.nombre = nombre;
		this.tamanioListContactos = tamanioListGrupos;
		this.tamanioListGrupos = tamanioListGrupos;
		listContactos = new Contacto[this.tamanioListContactos];
		listGrupos = new Grupo[this.tamanioListGrupos];
	}

	/**
	 * @return the tamanioListContactos
	 */
	public int getTamanioListContactos() {
		return tamanioListContactos;
	}

	/**
	 * @param tamanioListContactos the tamanioListContactos to set
	 */
	public void setTamanioListContactos(int tamanioListContactos) {
		this.tamanioListContactos = tamanioListContactos;
	}

	/**
	 * @return the tamanioListGrupos
	 */
	public int getTamanioListGrupos() {
		return tamanioListGrupos;
	}

	/**
	 * @param tamanioListGrupos the tamanioListGrupos to set
	 */
	public void setTamanioListGrupos(int tamanioListGrupos) {
		this.tamanioListGrupos = tamanioListGrupos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agenda [listContactos=" + Arrays.toString(listContactos) + ", listGrupos=" + Arrays.toString(listGrupos)
				+ ", nombre=" + nombre + "]";
	}

	/**
	 * @return the listContactos
	 */
	public Contacto[] getListContactos() {
		return listContactos;
	}

	/**
	 * @param listContactos the listContactos to set
	 */
	public void setListContactos(Contacto[] listContactos) {
		this.listContactos = listContactos;
	}

	/**
	 * @return the listGrupos
	 */
	public Grupo[] getListGrupos() {
		return listGrupos;
	}

	/**
	 * @param listGrupos the listGrupos to set
	 */
	public void setListGrupos(Grupo[] listGrupos) {
		this.listGrupos = listGrupos;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Crud

	/**
	 * Metodo CrearContacto()
	 * 
	 * @param nombre
	 * @param telefono
	 */

	public void crearContacto(String nombre, String telefono, int edad) throws ContactoExcepction {

		Contacto contactoExistente = null;
		int posicion = -1;

		// 1. Validar que no exista
		contactoExistente = obtenerContacto(telefono);

		if (contactoExistente == null) {

			// 2. Validar una posicion disponible (0 -9)
			posicion = obtenerPosicion();
			if (posicion != -1) {

				// 3. crear el contacto
				Contacto contacto = new Contacto(nombre, telefono, edad);

				// 4. Agregarlo al arreglo (lista)
				listContactos[posicion] = contacto;

			} else {
				// lanzar una excpeción
				throw new ContactoExcepction("No se puede agregar mas contactos al arreglo. Esta lleno");
			}

		} else {
//			lanzar la excepcion
			throw new ContactoExcepction("El contacto ya existe");
		}

	}

	/**
	 * Metodo eliminarContacto()
	 * 
	 * @param telefono
	 */
	private void eliminarContacto(String telefono) {

		Contacto contacto;

		contacto = obtenerContacto(telefono);

		if (contacto != null) {

			contacto = null;
		}

	}

	/**
	 * Metodo ActualizarContacto()
	 * 
	 * @param telefono
	 * @return
	 */
	private String ActualizarContacto(String telefono, String nombre) {

		Contacto contacto = null;
		String mensaje = " El contacto no se pudo actualizar";

		for (int i = 0; i < this.listContactos.length; i++) {

			if (existeContacto(telefono) == true) {
				contacto = listContactos[i];
				contacto.setNombre(nombre);
				mensaje = "El contacto fue actualizado";

			}
		}

		return mensaje;

	}

	/**
	 * obtenerPosicion()
	 * 
	 * @return posicion
	 */

	private int obtenerPosicion() {

		int posicion = -1;

		for (int i = 0; i < listContactos.length; i++) {

			if (listContactos[i] == null) {
				posicion = i;
				break;
			}
		}

		return posicion;
	}

	/**
	 * Metodo obtenerContacto()
	 * 
	 * @param telefono
	 * @return
	 */

	private Contacto obtenerContacto(String telefono) {

		Contacto contacto = null;

		for (int i = 0; i < listContactos.length; i++) {

			contacto = listContactos[i];

			if (contacto != null && contacto.getTelefono().equals(telefono)) {
				break;
			}
		}
		return contacto;
	}

	/**
	 * Metodo verificarAgendaLlena()
	 * 
	 * @return
	 */
	private boolean verificarAgendaLlena() {

		boolean agendaLlena = true;

		for (int i = 0; i < listContactos.length; i++) {

			if (listContactos[i] == null) {
				agendaLlena = false;
				break;
			}
		}

		return agendaLlena;
	}

	/**
	 * Metodo obtenerEspaciosDisponibles()
	 * 
	 * @return
	 */
	private int obtenerEspaciosDisponibles() {

		int contadorEspacios = 0;

		for (int i = 0; i < listContactos.length; i++) {

			if (listContactos[i] == null) {
				contadorEspacios++;
			}
		}

		return contadorEspacios;
	}

	/**
	 * Metodo existeContacto()
	 * 
	 * @param telefono
	 * @return
	 */
	private boolean existeContacto(String telefono) {

		boolean existeContacto = false;

		for (int i = 0; i < listContactos.length; i++) {

			if (listContactos[i] != null) {
				if (listContactos[i].getTelefono().equals(telefono)) {
					existeContacto = true;
					break;
				}
			}
		}

		return existeContacto;
	}

	public void mostrarContactos() {

		Contacto contacto = null;

		for (int i = 0; i < listContactos.length; i++) {

			contacto = listContactos[i];

			if (contacto != null) {
				System.out.println(contacto.toString());
			}
		}

	}

	/**
	 * 1- G1- Obtener< los contactos del grupo con nombre “amigos”
	 * 
	 * @param nombreGrupo
	 * @return
	 */
	public Contacto[] obtenerContactosGrupo(String nombreGrupo) {

		Contacto[] contactosGrupo = null;

		for (int i = 0; i < listGrupos.length; i++) {

			if (listGrupos[i] != null) {

				if (listGrupos[i].getNombre().equalsIgnoreCase(nombreGrupo)) {

					contactosGrupo = listGrupos[i].getListContactosAsociados();
				}
			}
		}

		return contactosGrupo;
	}

	/**
	 * 2-G2: Obtener los grupos que tengan un contacto donde su nombre inicie con
	 * vocal TIENE UN METODO EN GRUPO
	 * 
	 */
	public void mostrarGruposDeContactoConVocal() {

		int contador = 0;
		Grupo grupo = null;

		Grupo[] listaGruposInicialContactoVocal = null;

		contador = verificarCantidadGruposContactosIniciaVocal();

		listaGruposInicialContactoVocal = new Grupo[contador];
		int j = 0;

		for (int i = 0; i < listGrupos.length; i++) { // listGrupos => existencia de la relacion

			grupo = listGrupos[i];

			if (grupo != null) {

				if (grupo.verificarContactoIniciaVocal()) {
					listaGruposInicialContactoVocal[j] = grupo;
					j++;
				}

			}
		}

		imprimirArreglo(listaGruposInicialContactoVocal);

	}

	private void imprimirArreglo(Grupo[] listaGruposInicialContactoVocal) {

		Grupo grupo = null;
		for (int i = 0; i < listaGruposInicialContactoVocal.length; i++) {
			grupo = listaGruposInicialContactoVocal[i];
			if (grupo != null) {
				System.out.println(grupo.getNombre());
			}
		}

	}

	private int verificarCantidadGruposContactosIniciaVocal() {

		int contador = 0;
		Grupo grupo = null;

		for (int i = 0; i < listGrupos.length; i++) { // listGrupos => existencia de la relacion

			grupo = listGrupos[i];

			if (grupo != null) {

				if (grupo.verificarContactoIniciaVocal()) {
					contador++;
				}

			}
		}

		return contador;

	}

	/**
	 * 3-G3: Imprimir los contactos de las posiciones impares.
	 * 
	 * @param contacto
	 * @return posicionImpar
	 */

	public Contacto posicionImpar() {

		Contacto contacto = null;

		// Este ciclo permite recorrer el arreglo completo de los contactos en sus
		// posiciones ordenado

		for (int i = 0; i < listContactos.length; i++) {

			// contacto = listContactos[i];

			if (i % 2 == 0) {

			} else {
				System.out.println("Contacto en la posicon impar" + i + "Es:" + listContactos[i].toString());
			}

		}

		return contacto;

	}

	/**
	 * 
	 * 
	 * 4- G4 - Obtener cual es la edad que más se repite
	 * 
	 */

	public Contacto obtenerEdadRepite() {

		Contacto contactoActual = null;
		Contacto contactoSiguiente = null;

		int contadorRepite = 1;

		for (int i = 0; i < listContactos.length; i++) {
			contactoActual = listContactos[i];
			for (int j = i + 1; j < listContactos.length; j++) {

				contactoSiguiente = listContactos[j];

				if (contactoActual.getEdad() == contactoSiguiente.getEdad()) {
					// contadorRepite = contadorRepite + 1;
					System.out.println("La edad que mas se repite es " + listContactos[i].getEdad());
				}
			}
		}

		if (contadorRepite == 1) {
			System.out.println("La edad de todos los contactos es diferente");
		}

		return null;
	}

	/**
	 * 5- G5- Obtener el promedio de edades de los contactos
	 * 
	 */
	public double promedioEdades() {

		double promedio = 0;
		int contador = 0;

		for (int i = 0; i < listContactos.length; i++) {

			if (listContactos[i] != null) {
				contador++;
				promedio += listContactos[i].getEdad();
			}

		}

		return promedio / contador;
	}

	/**
	 * 6-G1- Obtener los contactos con una edad menor a 18
	 * 
	 **/

	public Contacto[] obtenerContactosMenoresDeEdad() {

		Contacto[] contactosMenoresDeEdad = new Contacto[this.tamanioListContactos];
		int indiceContactosMenores18 = 0;

		for (int i = 0; i < listContactos.length; i++) {

			if (listContactos[i] != null) {

				if (listContactos[i].verificarEdadMenor(18)) {
					contactosMenoresDeEdad[indiceContactosMenores18] = listContactos[i];
					indiceContactosMenores18++;
				}
			}
		}

		return contactosMenoresDeEdad;
	}

	/**
	 * Este metodo es la version 2 que obtiene los contactos menores de edad punto 6
	 * 
	 * @return
	 */

	public Contacto[] obtenerContactosMenoresDeEdadV2() {

		int cantidadMenores = 0;
		int rangoMenor = 18;
		cantidadMenores = obtenerCantidadContactosMenores(rangoMenor);
		int indiceMenores18 = 0;
		Contacto[] contactosMenoresDeEdad = new Contacto[cantidadMenores];

		for (int i = 0; i < listContactos.length; i++) {

			if (listContactos[i] != null) {
				if (listContactos[i].verificarEdadMenor(18)) {
					contactosMenoresDeEdad[indiceMenores18] = listContactos[i];
					indiceMenores18++;
				}
			}
		}

		return contactosMenoresDeEdad;
	}

	// Este metodo devuelve la cantidad de contactos menores de edad
	// Este metodo es una ayuda para el punto 6

	public int obtenerCantidadContactosMenores(int rangoMenor) {

		int cantidad = 0;

		for (int i = 0; i < listContactos.length; i++) {

			if (listContactos[i] != null) {

				if (listContactos[i].verificarEdadMenor(rangoMenor)) {
					cantidad++;
				}
			}
		}

		return cantidad;
	}

	/**
	 * 7-G2: Calcular la desviación estándar de las edades
	 * 
	 * @return
	 */
	public double desviacionEstandarEdadesContactos() {

		Contacto contacto = null;
		double media = 0;
		double primeraParteVarianza = 0;
		double varianza = 0;
		double desviacion = 0;

		media = contadorEdades() / ConctactosCreados();

		for (int i = 0; i < listContactos.length; i++) {
			contacto = listContactos[i];

			if (contacto != null) {
				primeraParteVarianza += Math.pow(listContactos[i].getEdad() - media, 2);
			}
		}

		varianza = primeraParteVarianza / ConctactosCreados();
		desviacion = Math.sqrt(varianza);
		return desviacion;
	}

	private int ConctactosCreados() {
		Contacto contacto = null;
		int contarContacotos = 0;

		for (int i = 0; i < listContactos.length; i++) {
			contacto = listContactos[i];

			if (contacto != null) {
				contarContacotos++;
			}
		}

		return contarContacotos;
	}

	private double contadorEdades() {
		Contacto contacto = null;
		double contadorEdades = 0;
		for (int i = 0; i < listContactos.length; i++) {
			contacto = listContactos[i];

			if (contacto != null) {
				contadorEdades += listContactos[i].getEdad();
			}
		}
		return contadorEdades;
	}

	/**
	 * 8-G3: Imprimir el nombre de los contactos de atras hacia adelante
	 * 
	 * @param nombre
	 * @return nombre invertido
	 */

	public Contacto imprimirDatosContactosHaciaAtras() {

		Contacto contacto = null;

		// ciclo que recorre el arreglo de la posicion final a la incial y lo imprime
		for (int i = listContactos.length - 1; i >= 0; i--) {

			System.out.println(i + "\t" + listContactos[i]);
		}

		return contacto;

	}

	/**
	 * 
	 * 
	 * 12- G4 - Pedir al usuario por teclado una frase y pasar sus caracteres a un
	 * arreglo de caracteres.
	 * 
	 */

	public void caracteresEnArreglo() {

		String frase = "";

		frase = JOptionPane.showInputDialog("Ingrese una frase");

		char[] caracteres = frase.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			System.out.println(caracteres[i]);

		}

	}

	/**
	 * nuevo 13- G5- Asociar un contacto a un grupo dado el nombre del grupo
	 * 
	 * @param nombreGrupo
	 * 
	 **/

	public String setContactoAGrupo(String nombreGrupo, Contacto contacto) {

		String mensaje = "OK";

		for (int i = 0; i < listGrupos.length; i++) {
			if (listGrupos[i] != null && listGrupos[i].getNombre().equalsIgnoreCase(nombreGrupo)) {
				listGrupos[i].setContacto(contacto);
			} else {
				mensaje = "Error\n El grupo no existe";
			}
		}
		return mensaje;
	}

	/**
	 * 14-G5- Ordenar la lista de contactos aplicando el método burbuja
	 * 
	 */

	public void ordenarListaContactos() {

		Contacto contactoMovido = new Contacto();

		int i, j;

		for (i = 0; i < listContactos.length; i++) {

			for (j = 0; j < listContactos.length - 1; j++) {

				if (listContactos[j + 1].getEdad() < listContactos[j].getEdad()) {
					contactoMovido = listContactos[j + 1];
					listContactos[j + 1] = listContactos[j];
					listContactos[j] = contactoMovido;
				}
			}
		}

		System.out.println("------------ahora ordenados-------------");

		for (int l = 0; l < listContactos.length; l++) {

			System.out.println(listContactos[l].toString());

		}
	}

	/**
	 * 
	 * 15- G5- Imprimir los contactos de las posiciones pares
	 * 
	 */

	public String contactosPosicionPar() {

		String mensaje = "";

		for (int i = 0; i < listContactos.length; i++) {
			if (i % 2 == 0 && listContactos[i] != null) {
				mensaje += listContactos[i].toString() + "\n";
			}
		}

		return mensaje;
	}

	/**
	 * 16-G1- Obtener los grupo que tenga la mayor cantidad de contactos asociados
	 * 
	 * @return
	 */

	public Grupo obtenerGrupoMayoriaContactos() {

		Grupo grupoMasContactos = null;
		int mayor = 0;

		for (int i = 0; i < this.listGrupos.length; i++) {

			if (this.listGrupos[i].getTamanioGrupo() > mayor) {
				grupoMasContactos = this.listGrupos[i];
				mayor = this.listGrupos[i].getNumContactosAsociado();
			}
		}

		return grupoMasContactos;
	}

	public String leerVentana(String mensaje) {

		return JOptionPane.showInputDialog(null, mensaje);
	}

	/**
	 * Nuevo metodo grupo3 agregarGrupo(Grupo g)
	 * 
	 * @param g
	 */
	public void agregarGrupo(Grupo g) {
		if (numGrupos < listGrupos.length) {
			listGrupos[numGrupos++] = g;
		}
	}

	/**
	 * Nuevo metodo grupo3 mostrarGrupo()
	 */
	public void mostrarGrupo() {
		for (int i = 0; i < listGrupos.length; i++) {
			if (listGrupos[i] != null) {
				System.out.println(listGrupos[i].toString());
			}
		}
	}

}
