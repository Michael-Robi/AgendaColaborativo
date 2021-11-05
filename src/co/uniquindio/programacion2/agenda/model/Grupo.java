package co.uniquindio.programacion2.agenda.model;

import java.util.Arrays;

public class Grupo {
	
	
	private String nombre;
	private Contacto[] listContactosAsociados;
	private int numContactosAsociado = 0;
	private int tamanioGrupo;
	
	
	public Grupo(String nombre) {
		this.nombre = nombre;
		this.listContactosAsociados = new Contacto[10];
		this.tamanioGrupo = 20;
		this.listContactosAsociados= new Contacto[this.tamanioGrupo];
	}
	
	public Grupo(String nombre, int tamanioGrupo){
		this.nombre = nombre;
		this.tamanioGrupo = tamanioGrupo;
		this.listContactosAsociados = new Contacto[this.tamanioGrupo];
	}

	public Contacto[] getListContactosAsociados() {
		return listContactosAsociados;
	}

	public void setListContactosAsociados(Contacto[] listContactosAsociados) {
		this.listContactosAsociados = listContactosAsociados;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", listGruposAsociados=" + Arrays.toString(listContactosAsociados)
		+ "]";
	}
	
	
	/**
	 * 2-G2: Obtener los grupos que tengan un contacto donde su nombre inicie con vocal
	 * @return
	 */
	
/*	public boolean GruposDeContactoConVocal() {	
		
		boolean valor = false;
	
		if (Contacto.ContactoConVocal()==true) {
		
		valor = true;
	
		return valor;
		}
		
		return true;
	
	}
*/
	public boolean verificarContactoIniciaVocal() {
		
		Contacto contacto= null;

		for (int i = 0; i < listContactosAsociados.length; i++) {
			contacto = listContactosAsociados[i];
			
			if (contacto != null) {
				
				if (contacto.ContactoConVocal()) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * @param tamanioGrupo the tamanioGrupo to set
	 */
	public void setTamanioGrupo(int tamanioGrupo) {
		this.tamanioGrupo = tamanioGrupo;
	}
	
	/**
	 * @return the tamanioGrupo
	 */
	public int getTamanioGrupo() {
		return tamanioGrupo;
	}
	
	public boolean validarNombre(String nombre) {
		
		if(this.nombre.equalsIgnoreCase(nombre))
			return true;
		
		return false;
	}
	
	public boolean validarExistencia(Contacto c) {

		boolean existencia = false;

		for(int i=0; i < listContactosAsociados.length; i++ ){

			if(c  != null && listContactosAsociados[i] != null){

				if(listContactosAsociados[i].validarTelefono(c.getTelefono())){
					existencia = true;
					break;
				}
			}
		}

		return existencia;
	}
	
	public String AgregarContacto(Contacto c){

		int posicion = -1;
		String mensaje = "";

		if(c != null){

			if(!validarExistencia(c)){

				posicion = obtenerPosicion();

				if(posicion != -1){

					listContactosAsociados[posicion] = c;
					mensaje = "Contacto Agregado con exito";
				}
				else{
					mensaje = "Contacto no fue agreado";
				}


			}
		}

		return mensaje;

	}
	
	private int obtenerPosicion() {

		for(int i = 0; i < this.listContactosAsociados.length; i++){

			if(listContactosAsociados[i] == null){
				return i;
			}
		}

		return -1;
	}

	public void setContacto(Contacto contacto) {
		for(int i = 0; i< listContactosAsociados.length;i++){
			if (listContactosAsociados [i] != null){
				listContactosAsociados [i] = contacto;
				break;
			}
		}
		
	}

	public int getNumContactosAsociado() {
		return numContactosAsociado;
	}


	
	
	
	
	
}
