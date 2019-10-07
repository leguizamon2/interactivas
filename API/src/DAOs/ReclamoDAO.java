package DAOs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.classic.Session;

import controlador.Controlador;
import entities.EdificioEntity;
import entities.ImagenEntity;
import entities.PersonaEntity;
import entities.ReclamoEntity;
import entities.UnidadEntity;
import exceptions.EdificioException;
import exceptions.PersonaException;
import exceptions.ReclamoException;
import exceptions.UnidadException;
import modelo.Edificio;
import modelo.Imagen;
import modelo.Persona;
import modelo.Reclamo;
import modelo.Unidad;
import hibernate.HibernateUtil;


public class ReclamoDAO {
		
	
	
			public List<Reclamo> getReclamos(){
			List<Reclamo> resultado = new ArrayList<Reclamo>();
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			List<ReclamoEntity> reclamos = s.createQuery("from ReclamoEntity").list();		
			
			for(ReclamoEntity re : reclamos)
				resultado.add(toNegocio(re));
			
			s.getTransaction().commit();
			s.close();
			return resultado;
		}
		
		
		public Reclamo findById(int numero) throws ReclamoException{
			Session s = HibernateUtil.getSessionFactory().openSession();
			ReclamoEntity reclamo = (ReclamoEntity) s.createQuery("from ReclamoEntity c where c.id = ? ")
					.setInteger(0, numero)
					.uniqueResult();
			if(reclamo == null)
				throw new ReclamoException("No existe el Reclamo " + numero);
			return toNegocio(reclamo);
		}
		
		
	public List<Reclamo> findByPersona(String numero) throws PersonaException {
			
			List <ReclamoEntity> resultado = new ArrayList<ReclamoEntity>();
			List <Reclamo> resultadoN = new ArrayList<Reclamo>();
			
			Session s = HibernateUtil.getSessionFactory().openSession();
			List <ReclamoEntity> reclamos =  (List<ReclamoEntity>) s.createQuery("from ReclamoEntity c where c.usuario= ? ")
					.setString(0, numero).list();
					
			
			if(reclamos.isEmpty())
				throw new PersonaException("No existen reclamos para el Edificio " + numero);
					
						
			for(ReclamoEntity r : reclamos)
				resultadoN.add(toNegocio(r));	
						
			
			return resultadoN;
		}
		
				
		
		
		public List<Reclamo> findByEdificio(int numero) throws ReclamoException{
			
			List <ReclamoEntity> resultado = new ArrayList<ReclamoEntity>();
			List <Reclamo> resultadoN = new ArrayList<Reclamo>();
			
			Session s = HibernateUtil.getSessionFactory().openSession();
			List <ReclamoEntity> reclamos =  (List<ReclamoEntity>) s.createQuery("from ReclamoEntity c where c.edificio= ? ")
					.setInteger(0, numero).list();
					
			
			if(reclamos.isEmpty())
				throw new ReclamoException("No existen reclamos para el Edificio " + numero);
					
						
			for(ReclamoEntity r : reclamos)
				resultadoN.add(toNegocio(r));	
						
			
			return resultadoN;
		}
		
		
		
		public List<Reclamo> findByUnidad(int id, String piso, String numero) throws ReclamoException{
			Session s = HibernateUtil.getSessionFactory().openSession();
			
			List <Reclamo> resultadoN = new ArrayList<Reclamo>();
			
			List <ReclamoEntity> reclamos =  (List<ReclamoEntity>) s.createQuery("from ReclamoEntity c where c.unidad = ?")
					.setInteger(0, id)
				//	.setString(1, piso)
				//	.setString(2, numero)
					.list();
			
			if(reclamos.isEmpty())
				throw new ReclamoException("No existen reclamos para el Edificio " + numero);
					
						
			for(ReclamoEntity r : reclamos)
				resultadoN.add(toNegocio(r));	
			
			return resultadoN;
		}
		
		

		public int save(Reclamo reclamo){
			ReclamoEntity aGrabar = toEntity(reclamo);
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.save(aGrabar);
			s.evict(aGrabar);
			s.getTransaction().commit();
			s.close();
			
			return aGrabar.getNumero();
		}
		
		
		public int update(Reclamo reclamo){
			ReclamoEntity aGrabar = toEntity(reclamo);
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.update(aGrabar);
			s.getTransaction().commit();
			s.close();
			
			return aGrabar.getNumero();
		}
		
				
		
		public ReclamoEntity toEntity(Reclamo reclamo) {
			ReclamoEntity entity = new ReclamoEntity(reclamo.getNumero(), reclamo.getEstado(),
					new PersonaDAO().toEntity(reclamo.getUsuario()),
					new EdificioDAO().toEntity(reclamo.getEdificio()), 
					reclamo.getUbicacion(), 
					reclamo.getDescripcion(),
					new UnidadDAO().toEntity(reclamo.getUnidad()));
			
			return entity; 
		}
		
		

		public Reclamo toNegocio(ReclamoEntity entity)
		{
			Reclamo reclamo = new Reclamo(entity.getNumero(), entity.getEstado(),
					new PersonaDAO().toNegocio(entity.getUsuario()),
					new EdificioDAO().toNegocio(entity.getEdificio()), 
					entity.getUbicacion(), 
					entity.getDescripcion(),
					new UnidadDAO().toNegocio(entity.getUnidad()));

			
			return reclamo; 
	    }		
		
		
}


