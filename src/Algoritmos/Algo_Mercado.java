package Algoritmos;
import static java.lang.Math.abs;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 * @author Franklin
 *
 */

public class Algo_Mercado {
	
	public static void Print_String (String[] Elem, int Caden) {
		
		try
		{
			
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			
			for(int i = 0; i < ((Elem.length * Caden) / Elem.length); i++) {
				
				bw.write( i + " " + Elem[i]);
				bw.flush();
				bw.write(Elem[i].length() > 13 || (Elem[i].length() < 11 && Elem[i].length() > 5) ? "			": "				");
				bw.flush();
				bw.write(i + (Caden) + " " + Elem[i+Caden]);
				bw.flush();
				bw.write(Elem[i+Caden].length() < 5 || Elem[i+Caden].length() > 13? "			": "				");
				bw.flush();
				bw.write(Elem[i+Caden*2].charAt(0) == '.'? "" : i + (Caden * 2) + " " + Elem[i+(Caden*2)]);
				bw.flush();
				bw.newLine();
				bw.flush();
				
			}
		}
		catch (Exception ex) {}
	}
	
	public static String[] Cadena (String Elem, int Long, int Res) {
		
		try
		{
			
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			BufferedReader bz = new BufferedReader (new FileReader(new File(Elem)));
			String Cadena[] = new String[Long];
			String Cadena_Price[] = new String[Long / 2];
			String Line = null;
			int i = 0, j = 0;
			
			while((Line = bz.readLine()) != null) {
				
				if(Character.isDigit(Line.charAt(1))) {
					Cadena_Price[j] = Line;
					j++;
				}
				else {
					Cadena[i] = Line;
					i++;
				}
			}
			
			if(Res == 0)
				return Cadena;
			else
				return Cadena_Price;
			
		}
		catch (Exception ex) {}
		return null;
	}
	
	public static void Print_Price(int[] Ref, String[] Elem, String[] Price, int[] unid) {
		
		try
		{
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			
			for(int i = 0; i < Ref.length; i++) {
				
				bw.write(Elem[Ref[i]] + "" + Elem[Ref[i]+(Elem.length / 2)] + "" + Price[Ref[i]] + "          	"
						+ "Cant. disponible: " + unid[i]);
				bw.flush();
				bw.write(Ref[i] == 4? " lb.": " U.");
				bw.newLine();
				bw.flush();
			}
		}
		catch (Exception ex) {}
	}
	
	public static int Comparation(int[] Ref, String[] Elem, String[] Price, int[] unid, int[] Cant) {
		
		try
		{
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			int Suma = 0;
			String Ans = null;
			
			for(int i = 0; i < Ref.length; i++) {
				
				if(Cant[i] > 0) 
					Suma = Suma + (Integer.parseInt(Price[Ref[i]]) * Cant[i]);
				
			}
			
			bw.write(">> ¿Hay fila en la caja registradora? ");
			bw.flush();
			
			Ans = br.readLine();
			if (Ans.equals("si") || Ans.equals("Si") || Ans.equals("SI")) {
				
				bw.write("Haga la fila y espere su turno");
				bw.newLine();
				bw.flush();
				
				bw.write("> ¿Es su turno para la caja registradora?  ");
				bw.flush();
				Ans = br.readLine();
				
				while(Ans.equals("no") || Ans.equals("No") || Ans.equals("NO")) {
					bw.write("> ¿Es su turno para la caja registradora?  ");
					bw.flush();
					Ans = br.readLine();
					
				}
					
			}

			return Suma;
			
		}
		catch (Exception ex) {}
		return 0;
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
			
			
			bw.write("Para todos los alimentos, víveres y elementos de aseo faltantes en la casa, hacer "
					+ "una lista de compras.");
			bw.newLine();
			bw.flush();
			
			bw.write("¿Hacen falta Vegetales, Víveres o elementos de aseo? ");
			bw.flush();
			
			Ans = br.readLine();
			if (Ans.equals("si") || Ans.equals("Si") || Ans.equals("SI")) {
				
				BufferedReader bz = new BufferedReader (new FileReader(new File("Supermercado/Elem.in")));
				String Linea = null;
				
				while((Linea = bz.readLine()) != null) {
					
					if(Character.isDigit( Linea.charAt(1) ) || Linea.charAt(1) == '.') {
					}
					else 
						Long++;
				}
				
				Elem = new String[Long * 2];
				System.arraycopy(Cadena("Supermercado/Elem.in", Long * 2, 0), 0, Elem, 0, Long * 2);
				
				bw.write("> VEGETALES" + "			" + "> VÍVERES" + "				" + "> ELEMENTOS DE ASEO");
				bw.newLine();
				bw.newLine();
				bw.flush();
				
				Print_String(Elem, 10);
				
				Elem_Price = new String[Long];
				System.arraycopy(Cadena("Supermercado/Elem.in", Long * 2, 1), 0, Elem_Price, 0, Long);
				
				bw.newLine();
				bw.write("Indique el número de referencia de los vegetales, víveres o elementos de aseo que hacen falta"
						+ " (separados por coma y sin espacio): ");	
				bw.flush();
				Size = br.readLine().split(",");
				
				Ref = new int[Size.length];
				
				for(int i = 0; i < Size.length; i++)
					Ref[i] = Integer.parseInt( Size[i]);
					
			}
			else {
				
				bw.write(">> Usted no necesita calcular el presupuesto para la compra de su mercado.");
				bw.newLine();
				bw.flush();
			}
			
			unid = new int[Ref.length];
			
			for(int i = 0; i < unid.length; i++)
				unid[i] = (int)(Math.random() * 20);
			
			bw.write(">> Mientras haya alimentos, víveres o elementos de aseo puestos en la lista de compras, verificar"
					+ " si hay unidades disponibles en el supermercado.");
			bw.newLine();
			bw.newLine();
			bw.flush();
			
			Print_Price(Ref,Elem,Elem_Price,unid);
			
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
			
			bw.write("El presupuesto para la compra de su mercado es de: $" + Comparation(Ref,Elem,Elem_Price,unid,Cant));
			bw.newLine();
			bw.flush();
		}
		catch (Exception ex) {}
	}

}
