package co.uniquindio.programacion2.agenda.model;

/**
 * Clase Contacto
 * @author Curso programacion 2 nocturna
 *
 */
public class Contacto {
	
	
	Grupo [] listGruposAsociados;
	

	/**
	 * Metodo constructor para inicializar solo el nombre
	 * @param nombre
	 */
	public Contacto(String nombre) {
		this.nombre = nombre;
		this.telefono = "0000000000";
	}
	
	public Contacto() {
		
	}
	
	// Declaracion de los atributos
	private String nombre;
	private String telefono;
	private int edad;
	
	/**
	 * MÃƒÂ©todo constructor para crear los grupos
	 * 
	 * @param nombre
	 */
	public Contacto(String nombre, String numTelefono, int edad) {
		this.nombre = nombre;
		this.telefono = numTelefono;
		this.edad = edad;
		
		
		listGruposAsociados = new Grupo [3];
	}
	
	
	
	
	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}




	/**
	 * Metodo para obtener el nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * MÃƒÂ©todo para modificar el nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * MÃƒÂ©todo para obtener el telÃƒÂ©fono
	 * @return
	 */
	public String getTelefono() {
		return telefono;
	}
	

	/**
	 * MÃƒÂ©todo para modificar el telÃƒÂ©fono
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Continuidad de del punto 2
	 * G2-2: Obtener los grupos que tengan un contacto donde su nombre inicie con vocal
	 * @return
	 */
	
	public boolean ContactoConVocal() { 
		
		char caracter1 = this.getNombre().charAt(0);//Obtener de nombre la primera posicion
		char letraMinuscula =  Character.toLowerCase(caracter1); 
		
		if (letraMinuscula == 'a' || letraMinuscula == 'e' || letraMinuscula == 'i' || letraMinuscula == 'o' || letraMinuscula == 'u') { //Si inicia con vocal
			return true;
		}
		
		return false;
	}
	

	
	
	
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
	
	public boolean validarTelefono(String Telefono) {
        
		if(this.telefono.equals(Telefono)){
			return true;
		}
        
		return false;
	}
	
	/**
	 * 6-G1- Obtener los contactos con una edad menor a 18
	 * @param rangoMenor
	 * @return
	 */
	
	public boolean verificarEdadMenor(int rangoMenor) {
        
		if(this.edad < rangoMenor){
			
			return true;
		}
          
		return false;
	}
	
	
	
	
	
}
