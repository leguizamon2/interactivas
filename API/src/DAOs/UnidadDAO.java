package DAOs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.classic.Session;

import controlador.Controlador;
import entities.EdificioEntity;
import entities.PersonaEntity;
import entities.UnidadEntity;
import exceptions.EdificioException;
import exceptions.UnidadException;
import modelo.Edificio;
import modelo.Persona;
import modelo.Unidad;
import hibernate.HibernateUtil;


public class UnidadDAO {
		
		public List<Unidad> getUnidades(){
			List<Unidad> resultado = new ArrayList<Unidad>();
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			List<UnidadEntity> unidades = s.createQuery("from UnidadEntity").list();
			s.getTransaction().commit();
			s.close();
			for(UnidadEntity ce : unidades)
				resultado.add(toNegocio(ce));
			return resultado;
		}
		
		public 	Unidad findById(int numero) throws UnidadException{
			Session s = HibernateUtil.getSessionFactory().openSession();
			UnidadEntity unidad = (UnidadEntity) s.createQuery("from UnidadEntity c where c.id = ? ")
					.setInteger(0, numero)
					.uniqueResult();
			if(unidad == null)
				throw new UnidadException("No existe el Edificio " + numero);
			return toNegocio(unidad);
		}

		public void save(Unidad unidad){
			UnidadEntity aGrabar = toEntity(unidad);
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.save(aGrabar);
			s.evict(aGrabar);
			s.getTransaction().commit();
			s.close();
		}
		
		public void update(Unidad unidad){
			UnidadEntity aGrabar = toEntity(unidad);
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.update(aGrabar);
			s.getTransaction().commit();
			s.close();
		}
		
		public UnidadEntity toEntity(Unidad unidad){	
			UnidadEntity entity = new UnidadEntity(unidad.getId(), unidad.getPiso(), 
					unidad.getNumero(), unidad.getHabitado(), new EdificioDAO().toEntity(unidad.getEdificio()));
			
			List<PersonaEntity> duenios = new ArrayList<PersonaEntity>();  
			for(Persona duenio : unidad.getDuenios()) {
				duenios.add((new PersonaDAO().toEntity(duenio)));
			}
			
			List<PersonaEntity> inquilinos = new ArrayList<PersonaEntity>();  
			for(Persona inq : unidad.getInquilinos()) {
				inquilinos.add((new PersonaDAO().toEntity(inq)));
			}
			
			entity.setDuenios(duenios);
			entity.setInquilinos(inquilinos);
			
			return entity; 
		} 
		
		
		
		public Unidad toNegocio(UnidadEntity entity)
		{
						
			Unidad unidad = new Unidad(entity.getId(), entity.getPiso(), entity.getNumero(), entity.getHabitado(), new EdificioDAO().toNegocio(entity.getEdificio()));
			
				
			for(PersonaEntity duenio : entity.getDuenios()) {
				unidad.agregarDuenio(new PersonaDAO().toNegocio(duenio));
			}
			
			for(PersonaEntity inq : entity.getInquilinos()) {
				unidad.agregarInquilino(new PersonaDAO().toNegocio(inq));
			}
			return unidad; 
	    }
}


