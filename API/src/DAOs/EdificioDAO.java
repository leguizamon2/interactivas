package DAOs;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.classic.Session;

import entities.EdificioEntity;
import entities.UnidadEntity;
import exceptions.EdificioException;
import modelo.Edificio;
import modelo.Unidad;
import hibernate.HibernateUtil;


public class EdificioDAO {
		
		public List<Edificio> getEdificios(){
			List<Edificio> resultado = new ArrayList<Edificio>();
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			List<EdificioEntity> edificios = s.createQuery("from EdificioEntity").list();
			s.getTransaction().commit();
			s.close();
			for(EdificioEntity ce : edificios)
				resultado.add(toNegocio(ce));
			return resultado;
		}
		
		public 	Edificio findById(int numero, boolean conUnidades) throws EdificioException{
			Session s = HibernateUtil.getSessionFactory().openSession();
			EdificioEntity Edificio = (EdificioEntity ) s.createQuery("from EdificioEntity c where c.codigo = ? ")
					.setInteger(0, numero)
					.uniqueResult();
			if(Edificio == null)
				throw new EdificioException("No existe el Edificio " + numero);
			
			if(conUnidades)
				return toNegocioConUnidades(Edificio);
			else
				return toNegocio(Edificio);
		}

		public void save(Edificio edificio){
			EdificioEntity aGrabar = toEntity(edificio);
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.save(aGrabar);
			s.evict(aGrabar);
			s.getTransaction().commit();
			s.close();
		}
		
		public void update(Edificio edificio){
			EdificioEntity aGrabar = toEntity(edificio);
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.update(aGrabar);
			s.getTransaction().commit();
			s.close();
		}
		
		public EdificioEntity toEntity(Edificio edificio){
			return new EdificioEntity(edificio.getCodigo(), edificio.getNombre(), edificio.getDireccion());
		} 
		
		public Edificio toNegocio(EdificioEntity entity){
			return new Edificio(entity.getCodigo(), entity.getNombre(), entity.getDireccion());
	}
		
		
		public Edificio toNegocioConUnidades(EdificioEntity entity){
			Edificio e = new Edificio(entity.getCodigo(), entity.getNombre(), entity.getDireccion());
			
			for(UnidadEntity unidad : entity.getUnidades()) {
				Unidad u = new UnidadDAO().toNegocio(unidad);
				e.agregarUnidad(u);
			}
			
			return e;
		}
}


