package ups.edu.ec.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inmuebles {
	
	@Id
	//@GeneratedValue
	private String antiguedad;
	private String altura;
	private String peso;
	private String marca;
	public String getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Inmuebles [antiguedad=" + antiguedad + ", altura=" + altura + ", peso=" + peso + ", marca=" + marca
				+ "]";
	}
	
	
	
	

}
