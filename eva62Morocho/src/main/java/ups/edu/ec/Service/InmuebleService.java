package ups.edu.ec.Service;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.Datos.InmuebleDao;
import ups.edu.ec.Modelo.Inmuebles;
import ups.edu.ec.Negocio.GestionInmueble;



@Path("inmueble")
public class InmuebleService {
	
	@Inject
	private InmuebleDao daopersona;
	@Inject
	private GestionInmueble gClientes;
	
	

	@GET
	@Path("saludo")
	public String saludo() {
		return "hola mundo";
	}

	
	@GET
	@Path("lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inmuebles> getListadoP() {
		
	return daopersona.getAll();
			
	}
	
	//post
	
	
		@POST
		@Produces("application/json")
		@Consumes("application/json")
		public Response guardarCliente(Inmuebles persona) {
			
			
			try {
				gClientes.guardarInmueble(persona);
				return Response.status(Response.Status.OK).entity(persona).build();
			} catch (Exception e) {
				// TODO: handle exception
				Error error = new Error();
				error.setCodigo(99);
				error.setMensaje("error al guardar:"+ e.getMessage());
				
				return Response.status(Response.Status.OK).entity(error).build();
				
			}
		}
		
		
}
