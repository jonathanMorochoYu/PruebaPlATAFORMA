package ups.edu.ec.Negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.Datos.InmuebleDao;
import ups.edu.ec.Modelo.Inmuebles;

@Stateless
public class GestionInmueble {
	
	@Inject
	private  InmuebleDao daoinmueble;
	
	public void guardarInmueble(Inmuebles inmuebles) throws Exception{
		if (!this.isCedulaValida(inmuebles.getAntiguedad())) 
			throw new Exception("cedula incorrecta");
		
		if(daoinmueble.read(inmuebles.getAntiguedad())==null) {
			
			try {
				daoinmueble.insert(inmuebles);
			} catch (Exception e) {
				
				throw new Exception("Error al insertarr"+ e.getMessage());
				// TODO: handle exception
			}
			}else {
				try {
					daoinmueble.update(inmuebles);
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("error al actualizar "+ e.getMessage());
				}
			}
}
	private boolean isCedulaValida(String antiguedad) {

		return antiguedad.length()==10;
	
	}
}
