package ups.edu.ec.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.Modelo.Inmuebles;

@Stateless
public class InmuebleDao implements Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Inmuebles inmuebles) {
		em.persist(inmuebles);
	}
	public void update(Inmuebles inmuebles) {
		em.merge(inmuebles);
	}
	
	public Inmuebles read(String antiguedad ) {
		Inmuebles p = em.find(Inmuebles.class, antiguedad);
		return p;
	}
	
	public void delete(String antiguedad) {
		Inmuebles p = em.find(Inmuebles.class, antiguedad);
		em.remove(p);
	}
	
	public List<Inmuebles> getAll(){
		String jpql = "SELECT p FROM Inmuebles p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}