package tests;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import DAOs.ReclamoDAO;
import controlador.Controlador;
import exceptions.*;
import modelo.Reclamo;
import views.*;

public class test {


	public static void main(String[] args) {

		// //prueba enlistar edificios ANDA:
		// List<EdificioView> edificios = Controlador.getInstancia().getEdificios();
		// for(EdificioView e : edificios)
		// System.out.println(e.getNombre());
		//
		//
		//
		//
		// prueba enlistar documentos:
		// List<PersonaView> personas = Controlador.getInstancia().getPersonas();
		// for(PersonaView p : personas)
		// System.out.println(p.getDocumento());
		//
		//
		//
		// //prueba agregar persona:
		// Controlador.getInstancia().agregarPersona("0101", "Roger Federer");
		//
		//
		// check agregar persona ANDA:
		// List<PersonaView> afterInsert = Controlador.getInstancia().getPersonas();
		// System.out.println("DOCS CON INSERT:");
		// for(PersonaView p : afterInsert)
		// System.out.println(p.getDocumento());
		//
		//
		// //prueba eliminar persona:
		// try {
		// Controlador.getInstancia().eliminarPersona("0101");
		// } catch (PersonaException e) {
		// System.out.println("Documento no valido.");
		// }
		//
		//
		// //check eliminar persona ANDA:
		// List<PersonaView> afterDelete = Controlador.getInstancia().getPersonas();
		// System.out.println("DOCS CON DELETE:");
		// for(PersonaView p : afterDelete)
		// System.out.println(p.getDocumento());

		// check agregar persona ANDA:
		// List<UnidadView> units = null;
		// try {
		// units = Controlador.getInstancia().getUnidadesPorEdificio(2);
		// } catch (EdificioException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Unidades:");
		//
		// for(UnidadView p : units)
		// System.out.println(p.getEdificio());

		// Prueba habitantes por edificio.
		// List<PersonaView> habitantes = null;
		// try {
		// habitantes = Controlador.getInstancia().habitantesPorEdificio(2);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Habitantes:");
		//
		// for(PersonaView p : habitantes)
		// System.out.println(p.getNombre());
		//

		// Prueba duenios por unidad.
		// List<PersonaView> duenios = null;
		// try {
		// duenios = Controlador.getInstancia().dueniosPorUnidad(3);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Habitantes:");
		//
		// for(PersonaView p : duenios)
		// System.out.println(p.getNombre());
		//
		// Prueba habitantes por unidad.
		// List<PersonaView> duenios = null;
		// try {
		// duenios = Controlador.getInstancia().inquilinosPorUnidad(1, "10", "6");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Habitantes:");
		//
		// for(PersonaView p : duenios)
		// System.out.println(p.getNombre());

		// try {
		// Controlador.getInstancia().transferirUnidad(3, "10", "4", "CI 13230978");
		// } catch (UnidadException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (PersonaException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// // Prueba duenios por unidad.
		// List<PersonaView> duenios = null;
		// try {
		// duenios = Controlador.getInstancia().dueniosPorUnidad(3);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Habitantes:");
		//
		// for(PersonaView p : duenios)
		// System.out.println(p.getNombre());

		// try {
		// Controlador.getInstancia().alquilarUnidad(1, "10", "6", "CI 13230978");
		// } catch (UnidadException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (PersonaException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// //prueba agregar Duenio Unidad:
		// try {
		// Controlador.getInstancia().agregarDuenioUnidad(1, "121", "1", "CI 13230978");
		// } catch (UnidadException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (PersonaException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// check agregar persona ANDA:
		// List<PersonaView> duenios = null;
		// try {
		// duenios = Controlador.getInstancia().dueniosPorEdificio(2);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Duenios Edificio 2:");
		//
		// for(PersonaView p : duenios)
		// System.out.println(p.getDocumento());

		// check agregar persona ANDA:
		// List<PersonaView> duenios = null;
		// try {
		// duenios = Controlador.getInstancia().dueniosPorEdificio(2);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Duenios Edificio 2:");
		//
		// for(PersonaView p : duenios)
		// System.out.println(p.getDocumento());

		// System.out.println("Reclamos:"); //uno ya cargado en bd
		// for(ReclamoView r : Controlador.getInstancia().getReclamos())
		//// System.out.println(r.getUnidad().getId()); //Da ok
		////
		//// //System.out.println(r.getEdificio().getCodigo()); //Da 3 OK
		//// // System.out.println(r.getDescripcion()); //da ok
		//// //System.out.println(r.getNumero()); // da ok
		//// System.out.println(r.getUsuario().getDocumento()); //da DNI31064776 OK
		//

		// try {
		// Controlador.getInstancia().agregarInquilinoUnidad(1 , "10", "6",
		// "DNI93277649");
		// } catch (UnidadException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (PersonaException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

		// try {
		// Controlador.getInstancia().liberarUnidad(2, "10", "5");
		// } catch (UnidadException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// try {
		// Controlador.getInstancia().habitarUnidad(1531, "11", "1");
		// } catch (UnidadException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// try {
		// Controlador.getInstancia().alquilarUnidad(1, "10", "6", "CPA3449614");
		// } catch (UnidadException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (PersonaException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//

		// try {
		// Controlador.getInstancia().transferirUnidad(489, "24", "3", "DNI29988738");
		// } catch (UnidadException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (PersonaException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

//		try {
//			Controlador.getInstancia().agregarDuenioUnidad(489, "24", "3", "CI 13230978");
//		} catch (UnidadException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (PersonaException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		//// Prueba habitantes por unidad.
		// List<PersonaView> duenios = null;
		// try {
		// duenios = Controlador.getInstancia().inquilinosPorUnidad(15, "8", "4");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Habitantes:");
		//
		// for(PersonaView p : duenios)
		// System.out.println(p.getNombre());
		

		//// prueba imagenes // OK guarda string
		//
		// try {
		// Controlador.getInstancia().agregarImagenAReclamo(1,
		//// "C:\\Users\\april\\Desktop\\TPOfotos\\laver.jpg", "jpg");
		// } catch (ReclamoException | IOException e) {
		// System.out.println("FALLA");
		// }
		

		// saco imags NO LO PIDIO EL, pero chequeo lo mismo q entra, sale
		// BufferedImage rtdo;
		//
		// BufferedImage mia=null;
		// try {//para comparar la q sale es igual a la orig
		// mia = ImageIO.read(new
		// File("C:\\Users\\april\\Desktop\\TPOfotos\\laver.jpg"));
		// } catch (IOException e2) {
		// System.out.println("no");}
		//
		//
		// try {
		// rtdo = Controlador.getInstancia().getREIMG(1); //metodo AGREGADO NO ERA NEC
		// System.out.println(rtdo);
		// System.out.println(mia);
		//
		// } catch (IOException | ImagenException e) {
		// // TODO Auto-generated catch block
		// System.out.println("NO ANDAR");
		// }

		
		
		// anda OK
		// try {
		// List<ReclamoView> rtdo = Controlador.getInstancia().reclamosPorEdificio(3);
		// for(ReclamoView rv : rtdo)
		// System.out.println(rv.getDescripcion()); //"todo roto "
		// } catch (EdificioException | ReclamoException e) {
		// System.out.println("NO ANDA");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		
		
		// anda OK
		
//		  try 
//		  { 	ReclamoView rv = Controlador.getInstancia().reclamosPorNumero(1);
//		  		System.out.println(rv.getDescripcion()); //"todo roto " 
//		  } catch (IOException | ReclamoException e) { // TODO Auto-generated catch block
//			  	e.printStackTrace(); }
		 
		

		// anda OK
		List<ReclamoView> rtdo = null;
		try {
			rtdo = Controlador.getInstancia().reclamosPorPersona("DNI29988738");
			for (ReclamoView rv : rtdo)
				System.out.println(rv.getEstado()); // "todo roto "
		} catch (PersonaException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// anda OK
		try {
			Controlador.getInstancia().cambiarEstado(5, Estado.enProceso);
			for (ReclamoView rv : rtdo)
				System.out.println(rv.getEstado()); // "todo roto "
		}
		catch ( ReclamoException eg) {
			// TODO Auto-generated catch block
			eg.printStackTrace();
		}
		
		// anda OK
				List<ReclamoView> rtdo1 = null;
				try {
					rtdo1 = Controlador.getInstancia().reclamosPorPersona("DNI29988738");
					for (ReclamoView rv : rtdo1)
						System.out.println(rv.getEstado()); // "todo roto "
				} catch (PersonaException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
		//ANDA OK
//		List<ReclamoView> rtdo;
//		try {
//			rtdo = Controlador.getInstancia().reclamosPorUnidad(1086,"35","2");
//			 for(ReclamoView rv : rtdo)
//				System.out.println("UNI:"+rv.getDescripcion()); //"todo roto "
//		} catch (ReclamoException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
		
		
		
		
		
		// List<UnidadView> units = null;
		// try {
		// units = Controlador.getInstancia().getUnidadesPorEdificio(1);
		// } catch (EdificioException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Unidades:");
		//
		// for(UnidadView p : units)
		// if (p.isHabitado())
		// System.out.println(p.getNumero());

//		 try {
//		 Controlador.getInstancia().agregarReclamo(2, 2, "62", "DNI29988738",
//		 "Quesada","Pintar la pared"); //anda, da la alta en BD
//		 } catch (EdificioException | UnidadException | PersonaException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
//		 System.out.println("Reclamos:");
//		 for(Reclamo r : new ReclamoDAO().getReclamos())
//		 System.out.println(r.getNumero()); // dan ok
		
		
		

	}         

			
}


