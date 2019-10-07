package DAOs;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.classic.Session;

import entities.ImagenEntity;
import entities.UnidadEntity;
import exceptions.ImagenException;
import modelo.Imagen;
import modelo.Unidad;
import hibernate.HibernateUtil;


public class ImagenDAO {
		
		public List<Imagen> getImagenes(){
			List<Imagen> resultado = new ArrayList<Imagen>();
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			List<ImagenEntity> imagenes = s.createQuery("from ImagenEntity").list();
			s.getTransaction().commit();
			s.close();
			for(ImagenEntity ce : imagenes)
				resultado.add(toNegocio(ce));
			return resultado;
		}
		
		public Imagen findById(int numero) throws ImagenException{
			Session s = HibernateUtil.getSessionFactory().openSession();
			ImagenEntity imagen = (ImagenEntity ) s.createQuery("from ImagenEntity c where c.numero = ? ")
					.setInteger(0, numero)
					.uniqueResult();
			if(imagen == null)
				throw new ImagenException("No existe la Imagen " + numero);
			
			return toNegocio(imagen);			
		}

		public void save(Imagen imagen){
			ImagenEntity aGrabar = toEntity(imagen);
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.save(aGrabar);
			s.evict(aGrabar);
			s.getTransaction().commit();
			s.close();
		}
		
		public void update(Imagen imagen){
			ImagenEntity aGrabar = toEntity(imagen);
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.update(aGrabar);
			s.getTransaction().commit();
			s.close();
		}
		
		public ImagenEntity toEntity(Imagen imagen){
			return new ImagenEntity(imagen.getNumero(), imagen.getEnBytes(), imagen.getTipo());
		} 
		
		public Imagen toNegocio(ImagenEntity entity){
			Imagen t = new Imagen(entity.getEnBytes(), entity.getTipo());
			t.setNumero(entity.getNumero());
			return  t;
	}
		
		
		
		
		
		
	
}


