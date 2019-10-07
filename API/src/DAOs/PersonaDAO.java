package DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entities.PersonaEntity;
import exceptions.PersonaException;
import hibernate.HibernateUtil;
import modelo.Persona;

public class PersonaDAO {


			public List<Persona> getPersonas(){
				List<Persona> resultado = new ArrayList<Persona>();
				Session s = HibernateUtil.getSessionFactory().openSession();
				s.beginTransaction();
				List<PersonaEntity> personas = s.createQuery("from PersonaEntity").list();
			
				/*check COINCIDEN COLUMNAS con entity creada:
				 * for(PersonaEntity p : personas)
				 * System.out.println("NI BIEN SALIO = "+p.getNombre());  */
				
				s.getTransaction().commit();
				s.close();
				for(PersonaEntity p : personas)
					resultado.add(toNegocio(p));  
				return resultado;
			}
			
			public Persona findById(String documento) throws PersonaException{
				Session s = HibernateUtil.getSessionFactory().openSession();
				PersonaEntity persona = 
						(PersonaEntity) s.createQuery
						("from PersonaEntity c where c.documento = ? ").setString(0, documento).uniqueResult();
				if(persona == null)
					throw new PersonaException("No existe el Persona " + documento);
				return toNegocio(persona);
			}

			public void save(Persona persona){
				PersonaEntity aGrabar = toEntity(persona);
				Session s = HibernateUtil.getSessionFactory().openSession();
				s.beginTransaction();
				s.save(aGrabar);
				s.evict(aGrabar);
				s.getTransaction().commit();
				s.close();
			}
			
			public void update(Persona persona){
				PersonaEntity aGrabar = toEntity(persona);
				Session s = HibernateUtil.getSessionFactory().openSession();
				s.beginTransaction();
				s.update(aGrabar);
				s.getTransaction().commit();
				s.close();
			}
			
			public void delete(Persona persona){
				PersonaEntity aGrabar = toEntity(persona);
				Session s = HibernateUtil.getSessionFactory().openSession();
				s.beginTransaction();
				s.delete(aGrabar);
				s.getTransaction().commit();
				s.close();
			}
			
			
					
			public PersonaEntity toEntity(Persona persona){
				return new PersonaEntity(persona.getDocumento(), persona.getNombre());
			} 
			
			public Persona toNegocio(PersonaEntity entity){
				return new Persona(entity.getDocumento(), entity.getNombre()); 		}
	}

	


