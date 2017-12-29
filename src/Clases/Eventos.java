package Clases;

public class Eventos {
	
	int id;
	String nombre;
	String fecha;
	String ubicacion;
	String tipo_evento;
	
	public Eventos(){
		this.id = 0;
		this.nombre = "";
		this.fecha = "";
		this.ubicacion = "";
		this.tipo_evento = "";
	}
	
	public Eventos(int id, String n, String f, String u, String t){
		this.id = id;
		this.nombre = n;
		this.fecha = f;
		this.ubicacion = u;
		this.tipo_evento = t;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getUbic() {
		return ubicacion;
	}

	public void setUbic(String ubic) {
		this.ubicacion = ubic;
	}

	public String getTipo_evento() {
		return tipo_evento;
	}

	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}

}
