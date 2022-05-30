package ar.edu.unju.fi.model;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Component
public class Usuario {
	private int codigo;
	private String nombre;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate nacimiento;
	private int edad;
	private int voto;
	
	public Usuario() {}
	
	public Usuario(int codigo,String nombre, String email, LocalDate nacimiento) {
		super();
		this.codigo=codigo;
		this.nombre = nombre;
		this.email = email;
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
		this.edad= calcularEdad();
	}
	
	
	public int calcularEdad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(nacimiento, hoy);
		int edad=periodo.getYears();
		return edad;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = calcularEdad();
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the voto
	 */
	public int getVoto() {
		return voto;
	}

	/**
	 * @param voto the voto to set
	 */
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	
	
}
