package Clases;

public abstract class Usuario {

	private String nombre;
	private String apellido;
	private String usuario;
	private String contra;
	
	Usuario(String n, String a, String u, String c){
		this.nombre = n;
		this.apellido = a;
		this.usuario = u;
		this.contra = c;
	}
	
	public Usuario() {
		/*
		this.nombre = " ";
		this.apellido = " ";
		this.usuario = " ";
		this.contra = " ";
		*/
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	
}
