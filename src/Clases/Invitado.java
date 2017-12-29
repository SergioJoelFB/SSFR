package Clases;

public class Invitado {

	/*nombre, apellido, teléfono, dirección, sexo, email*/
	
	private int id;
	private String nombre, apellido, telefono, direccion, email;
	private String sexo;
	
	public Invitado(int id, String n, String a, String t, String d, String s, String e) {
		this.id = id;
		this.nombre = n;
		this.apellido = a;
		this.telefono = t;
		this.direccion = d;
		this.sexo = s;
		this.email = e;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
