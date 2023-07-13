package ups.edu.ec.Negocio;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.Datos.InmuebleDao;
import ups.edu.ec.Modelo.Inmuebles;


@Singleton
@Startup
public class DatosInmueble {
	@Inject
	private InmuebleDao daoinmueble;
	
	@PostConstruct
	public void init() {
		System.out.println("Hola UPS");
		
		Inmuebles p = new Inmuebles();
		
		p.setMarca("Mikasa");
		p.setAltura("1.65 mtr");
		p.setPeso("80 kl");
		p.setAntiguedad("Semi nueva");
		
		
		daoinmueble.insert(p);
		
		System.out.println("Mostrar Inmuebles Creados");

		List<Inmuebles> inmuebles = daoinmueble.getAll();
		for(Inmuebles per: inmuebles) {
			System.out.println(per);
		}
		
		System.out.println("-----------------------------------------");

		
		
		

	}
}
