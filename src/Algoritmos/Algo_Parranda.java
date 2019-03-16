package Algoritmos;
import static java.lang.Math.abs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

import Algoritmos.Algo_Mercado;

public class Algo_Parranda {
	
	public static void Print (String Lista) {
		
		try
		{
			
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			BufferedReader bz = new BufferedReader (new FileReader(new File(Lista)));
			String Linea = null;
			int random = 0;
			
			while((Linea = bz.readLine()) != null) {
				
				random = (int) (Math.random() * 2);
				bw.write("> " + Linea + (Linea.length() > 5? "			": "				"));
				bw.flush();
				bw.write((random == 0? "Disponible": "No disponible") + "				" );
				bw.flush();
				bw.write("> " + (Linea = bz.readLine()) + (Linea.length() > 5? "			": "				"));
				bw.flush();
				bw.write(random == 0? "Disponible": "No disponible");
				bw.flush();
				bw.newLine();
				bw.flush();
				
			}
		}
		catch (Exception ex) {}
	}

	public static void main(String[] args) {
		
		
		try
		{
			
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			String Ans = null;
			int Ref[] = null;
			String Elem[] = null;
			String Elem_Price[] = null;
			String Size[] = null;
			int unid[] = null;
			int Long = 0;
			int Cant[] = null;
			Algo_Mercado Ac1 = new Algo_Mercado();
			
			bw.write(">> Para todos sus amigos y amigas de la universidad, confirmar la disponibilidad "
					+ "de tiempo para una parranda:");
			bw.newLine();
			bw.newLine();
			bw.flush();
			
			Print("Parranda/Amigos.in");
			
			System.out.println();
			bw.write(">> ¿Hay suficientes amigos o amigas disponibles para hacer la parranda? ");
			bw.flush();
			
			Ans = br.readLine();
			if(Ans.equals("si") || Ans.equals("Si") || Ans.equals("SI")) {
				
				BufferedReader bz = new BufferedReader (new FileReader(new File("Parranda/Elemen.in")));
				String Linea = null;
				
				while((Linea = bz.readLine()) != null) {
					
					if(Character.isDigit( Linea.charAt(1) ) || Linea.charAt(1) == '.') {
					}
					else 
						Long++;
				}
				
				Elem = new String[Long * 2];
				System.arraycopy(Ac1.Cadena("Parranda/Elemen.in", Long * 2, 0), 0, Elem, 0, Long * 2);
				
				bw.write("Para todos los elementos necesarios para hacer una parranda, hacer una lista.");
				bw.newLine();
				bw.newLine();
				bw.flush();
				
				Ac1.Print_String(Elem, 3);
				
				Elem_Price = new String[Long];
				System.arraycopy(Ac1.Cadena("Parranda/Elemen.in", Long * 2, 1), 0, Elem_Price, 0, Long);
				
				bw.newLine();
				bw.write("Indique el número de referencia de elementos que hacen falta"
						+ " (separados por coma y sin espacio): ");	
				bw.flush();
				Size = br.readLine().split(",");
				
				Ref = new int[Size.length];
				
				for(int i = 0; i < Size.length; i++)
					Ref[i] = Integer.parseInt( Size[i]);
				
			}else {
				
				bw.write("> Lo sentimos, usted no puede hacer la parranda.");
				bw.flush();
			}
			
			unid = new int[Ref.length];
			
			for(int i = 0; i < unid.length; i++)
				unid[i] = (int)(Math.random() * 20);
			
			bw.newLine();
			bw.write("");
			bw.flush();
			
			Ac1.Print_Price(Ref,Elem,Elem_Price,unid);
			
			bw.newLine();
			bw.write(">> Para todos los elementos en la lista, indicar la cantidad de unidades a llevar, teniendo "
					+ "en cuenta la disponibilidad en el supermercado y el orden en la lista");
			bw.newLine();
			bw.write("> Si no hay disponibilidad del producto, ingresar un '-1' "
					+ "(datos separados por coma y sin espacio): ");
			bw.flush();
			
			Size = null;
			Size = br.readLine().split(",");
			
			Cant = new int[Size.length];
			
			for(int i = 0; i < Size.length; i++)
				Cant[i] = Integer.parseInt( Size[i]);
			
			bw.write("El presupuesto de usted y sus amigos debe ser de: $" + Ac1.Comparation(Ref,Elem,Elem_Price,unid,Cant));
			bw.newLine();
			bw.flush();
			
			
			
			
		}
		catch (Exception ex) {}
	}

}
