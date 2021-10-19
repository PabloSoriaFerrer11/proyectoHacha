package proyectoHacha;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class todoCodigo {
	
	public static void comprobarFichero(String p, String lon, String nom, String rutaP, String exte) {
		//Comprobamos que esten todas las partes
		int partes = Integer.parseInt(p);
		int longitud = Integer.parseInt(lon);
		String nombre = nom; 
		String rutaPartes = rutaP;
		String extension = exte;
		
		boolean sobra = false;
		boolean error = false;
		
		if(longitud%partes != 0) {
			sobra = true;
		}
		
		if(sobra==false) {
			for(int i=1; i<=partes; i++) {
			
				String rutaEntrada = rutaPartes + "copiaNum" + i + nombre;
				
				File f = new File(rutaEntrada);
				if(f.exists()==false){
					System.out.println("Error. Falta un archivo para juntar");
					error = true;
					break;
				}else{
					System.out.println("De momento todo bien. La parte " + i + " existe. " );
					error = false;
				}
			}
			
		}else {
			for(int i=1; i<=partes+1; i++) {
				
				String rutaEntrada = rutaPartes + "copiaNum" + i + nombre;

				File f = new File(rutaEntrada);
				if(f.exists()==false){
					System.out.println("Error. Falta un archivo para juntar");
					error = true;
					break;
				}else{
					System.out.println("De momento todo bien. La parte " + i + " existe. " );
					error = false;
				}
			}
		}
		
		if(error==false){
			juntarArchivo(partes, longitud, nombre, rutaPartes, exte);
		}else {
			System.out.println("Debido a la falta de un archivo no se juntará. ");
		}
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodo Clase DialogJuntar. Este metodo juntara el archivo
	public static void juntarArchivo(int p, int lon, String nom, String rutaP, String exte) {
		
		//partes, longitud, nombre, rutaPartes
		int partes = p;
		int longitud = lon;
		String nombre = nom; 
		String rutaPartes = rutaP;
		String extension = exte;
		
		FileInputStream fis; 
		BufferedInputStream bis; 
		FileOutputStream fos; 
		BufferedOutputStream bos;
		
		//-----------
		//System.out.println(partes);
		//System.out.println(longitud);
		//System.out.println(nombre);
		//System.out.println(rutaPartes);
		//-----------		
		
		
		
		boolean sobra =  false;
		
		if(longitud%partes != 0) {
			sobra = true;
		}
		
		String rutaSalida = rutaPartes + nombre + "Juntado" + extension;
		
		//Juntamos los archivos
		try {
			fos = new FileOutputStream(rutaSalida, true);
			bos = new BufferedOutputStream(fos);
			
			
			if(sobra==false) {
				for(int i=1; i<=partes; i++) {
				
					String rutaEntrada = rutaPartes + "copiaNum" + i + nombre;
					
					fis = new FileInputStream(rutaEntrada);
					bis = new BufferedInputStream(fis);
				
					int x;
					while((x=bis.read())!=-1) {
						
						bos.write(x);
						
					}
					
					bis.close();
					fis.close();
				}
			}else {
				for(int i=1; i<=partes+1; i++) {
					
					String rutaEntrada = rutaPartes + "copiaNum" + i + nombre;
					
					fis = new FileInputStream(rutaEntrada);
					bis = new BufferedInputStream(fis);
				
					int x;
					while((x=bis.read())!=-1) {
						
						bos.write(x);
						
					}
					
					bis.close();
					fis.close();
				}
			}
			
			bos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e ) {
			e.printStackTrace();
		}
			
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Este metodo saca el HashCode de un archivo
	public static void sacarHash(String ruta, JTextField JText ) {
		try {
			File file = new File(ruta);
		
			MessageDigest md5Digest = MessageDigest.getInstance("MD5");
			
			String checksum = getFileChecksum(md5Digest, file);
			
			JText.setText(checksum);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	public static void compararHash(JTextField H1, JTextField H2, JTextField Res ) {
		
		String Hash1 = H1.getText();
		String hash2 = H2.getText();
		
		
		
		if(Hash1.equals(hash2)) {
			Res.setText("Son iguales");
		}else {
			Res.setText("No son iguales");
		}
		
	}
	
	////---------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodo para sacar Hash de MARCOS.
	private static String getFileChecksum(MessageDigest digest, File file) throws IOException{
	    FileInputStream fis = new FileInputStream(file);
	     
	    //Create byte array to read data in chunks
	    byte[] byteArray = new byte[1024];
	    int bytesCount = 0; 
	      

	    while ((bytesCount = fis.read(byteArray)) != -1) {
	        digest.update(byteArray, 0, bytesCount);
	    };
	     

	    fis.close();
	     

	    byte[] bytes = digest.digest();
	     

	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i< bytes.length ;i++)
	    {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	     
	    //return complete hash
	   return sb.toString();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodo de la clase JDialogSeparar que pone en ventana mas informacion sobre los ficheros
	public static void infoAdicional(String ruta, JTextField jTextFieldDirectorio, JTextField jTextFieldFichero ) {
		
		//Este valor almacenará la longitud de la ruta completa
		int longitud = ruta.length() -1;
		
		//Este valor almacenará la longitud hasta llegar al ultimo / de la ruta, para hacer substring
		int reposLong = 0;
		
		for(int i=longitud; i>=0;i--)
			if(ruta.charAt(i)=='\\'){
				reposLong = i;
				break;
			}
		
		//Se almacenará el directorio donde esta el archivo
		String directorio = ruta.substring(0,reposLong+1);
		
		jTextFieldDirectorio.setText(directorio);
		
		String fichero = ruta.substring(reposLong+1,ruta.length());
		
		jTextFieldFichero.setText(fichero);
		
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodo para CORTAR el archivo
	public static void cortarArchivo(JTextField textFieldRuta, JSpinner spinner, JTextField jTextFieldDirectorio, JProgressBar barra ) {
		// TODO Auto-generated method stub
		
		try {
			String ruta = textFieldRuta.getText();
			
			long lon = 0;
			
			File f =  new File(ruta);
			
			lon = f.length();
			
			//-----------------------------
			
			barra.setMaximum((int)lon);
			barra.setMinimum(0);
			barra.setVisible(true);
			
			//.............................
			
			int partes = (int)spinner.getValue();			

			int cadaParte = (int)lon/partes;
			
			System.out.println("-------------------------------------------");
			System.out.println("La longitud del archivo es de " + lon + " bytes");
			System.out.println("Se va dividir en " + partes + ".Cada parte se va a dividir en " + cadaParte + " bytes" );
			System.out.println("Sobran " + lon%partes + " bytes");
			System.out.println("-------------------------------------------");
			
 
			    FileInputStream fis = new FileInputStream(ruta);
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos;
				BufferedOutputStream bos;
				
				//---------------------------------------------------

				String direct = jTextFieldDirectorio.getText();
				
				String fich = f.getName();
				
				int punto = 0;
				
				
				//Utiilzado para eliminar la extensio fichero ".txt" o otras
				for(int l=fich.length() -1; l>=0; l--) 
					if(fich.charAt(l)=='.') 
						punto=l;
					
				String fichB = fich.substring(0, punto);
				
				String extension = fich.substring(punto, fich.length());
				
				
				//-----------------------------------------------
				int cont = 0; 
				int x;
				int ronda = 0;
				while((x=bis.read())!=-1) {
				
					if(cont==(ronda*cadaParte)) {
						ronda++;
						System.out.print(ronda + " - ");
						System.out.println(cont);
					}
					
					String rutaDestino = direct +  "copia" + "Num" + ronda + fichB; 
					
					fos = new FileOutputStream(rutaDestino, true);
					bos = new BufferedOutputStream(fos);
					
					bos.write(x);
					
					cont++;
					
					barra.setValue(cont);
					
					bos.close();
					fos.close();
					
				}
				
				bis.close();
				fis.close();
				
				ManejoXML.crearXML(partes, lon, direct, fichB, extension);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
