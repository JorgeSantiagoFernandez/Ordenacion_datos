package ejercicio4;

import java.io.*;
import java.util.ArrayList;

public class ejercicio4 {

	public static void main(String[] args) {
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    
	    int posicion, peso, altura, contador = 0, contadorAux = 0, contadorLista = 0;
	    int pesoSuperar, alturaSuperar;
	    String linea, linea2;
	    
	    ArrayList lista = new ArrayList();
	    ArrayList listaAux = new ArrayList();
	    ArrayList listaDefinitiva = new ArrayList();
	    ArrayList<Integer>listaPeso = new ArrayList();
	    ArrayList<Integer>listaAltura = new ArrayList();

	    try {
	        
	    	archivo = new File ("C:\\archivo.txt");
	        fr = new FileReader (archivo);
	        br = new BufferedReader(fr);
	        
	        
	        while((linea=br.readLine())!=null) {
	           lista.add(linea);
	        }
	        
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }finally{         
	    	try{                    
	    		
	    		if( null != fr ){   
	    			fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	    
	    
	    for(int i=0; i< lista.size(); i++) {
	    	linea = (String) lista.get(i);
	    	posicion = linea.indexOf(",");
	    	
	    	peso =  Integer.parseInt(linea.substring(0, posicion));
	    	listaPeso.add(peso);
	    	
	    	altura = Integer.parseInt(linea.substring(posicion+1));
	    	listaAltura.add(altura);
	    	
	    	}
	    
	    while(contadorLista < lista.size()) {
	    	
	    	pesoSuperar = listaPeso.get(contadorLista);
    		alturaSuperar = listaAltura.get(contadorLista);
    		linea2 = pesoSuperar +","+ alturaSuperar;
			listaAux.add(linea2);
			
    		
	    	for(int i = contadorLista; i < lista.size() -1; i++) {
	    		
	    		if((pesoSuperar < listaPeso.get(i+1)) && 
	    				(alturaSuperar < listaAltura.get(i+1))) {
	    			
	    			pesoSuperar = listaPeso.get(i+1);
	    			alturaSuperar = listaAltura.get(i+1);
	    			linea2 = pesoSuperar +","+ alturaSuperar;
	    			listaAux.add(linea2);
	    			contadorAux++;
	    		}	    		
	    		
	    	}
	    	if(contadorAux > contador) {	    		
	    		listaDefinitiva.removeAll(listaDefinitiva);
	    		
	    		for(int i = 0; i < listaAux.size(); i++) {
	    			listaDefinitiva.add(listaAux.get(i));
	    		}
	    		
	    		contador = contadorAux;
	    		contadorAux = 0;
	    	}	    	
	    	
	    	listaAux.removeAll(listaAux);
	    	contadorLista++;
	    }
	    
	    for(int i = 0; i < listaDefinitiva.size(); i++) {
	    	System.out.println(listaDefinitiva.get(i));
	    }
	    
	    
	   }
	}