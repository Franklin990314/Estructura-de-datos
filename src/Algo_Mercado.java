import static java.lang.Math.abs;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Algo_Mercado {
	
	public static void Print_String (String[] Local) {
		
		try
		{
			
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			
			bw.write("> VEGETALES" + "			" + "> VIVERES" + "				" + "> ELEMENTOS DE ASEO");
			bw.newLine();
			bw.newLine();
			bw.flush();
			
			for(int i = 0; i < ((Local.length * 10) / Local.length); i++) {
				
				bw.write( i + " " + Local[i]);
				bw.flush();
				bw.write(i == 0? "				": "			");
				bw.flush();
				bw.write( "1" + i + " " +Local[i+10]);
				bw.flush();
				bw.write(i == 7 || i == 6 || i == 5 ? "			": "				");
				bw.flush();
				bw.write( "2" + i + " " +Local[i+20]);
				bw.flush();
				bw.newLine();
				bw.flush();
				
			}
		}
		catch (Exception ex) {}
	}
	
	public static String[] Cadena (String Local, int j) {
		
		try
		{
			
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			BufferedReader bz = new BufferedReader (new FileReader(new File(Local)));
			String Cadena[] = new String[j];
			String Line = null;
			int i = 0;
			
			while((Line = bz.readLine()) != null) {
				
				if(Character.isDigit( Line.charAt(1) )) {
				}
				else {
					Cadena[i] = Line;
					i++;
				}
			}
			
			return Cadena;
		}
		catch (Exception ex) {}
		return null;
	}
	
	public static int[] Cadena_Price (String Local, int j) {
		
		try
		{
			
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			BufferedReader bz = new BufferedReader (new FileReader(new File(Local)));
			int Cadena[] = new int[j];
			String Line = null;
			int i = 0;
			
			while((Line = bz.readLine()) != null) {
				
				if(Character.isDigit( Line.charAt(1))) {
					Cadena[i] = Integer.parseInt(Line);
					i++;
				}
			}
			
			return Cadena;
		}
		catch (Exception ex) {}
		return null;
	}
	public static void Print_Price(int[] Merca, String[] veget, int[] Price, int[] unidades) {
		
		try
		{
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			
			bw.write(">> Mientras hayan alimentos, viveres o elementos de aseo puestos en la lista de compras, verificar"
					+ " si hay unidades disponibles en el supermercado.");
			bw.newLine();
			bw.newLine();
			bw.flush();
			
			for(int i = 0; i < Merca.length; i++) {
				
				bw.write(veget[Merca[i]] + "" + veget[Merca[i]+(veget.length / 2)] + "" + Price[Merca[i]] + "          	"
						+ "Cant. disponible: " + unidades[i]);
				bw.flush();
				bw.write(Merca[i] == 4? " lb.": " U.");
				bw.newLine();
				bw.flush();
			}
		}
		catch (Exception ex) {}
	}
	
	public static void Comparation(int[] Merca, String[] veget, int[] Price, int[] unidades) {
		
		try
		{
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			String size [] = null;
			int Cant[] = null;
			int Suma = 0;
			String Ans = null;
			
			bw.newLine();
			bw.write(">> Para todo elementos en la lista, indicar la cantidad de unidades a llevar, teniendo "
					+ "en cuenta la disponibilidad en el supermercado y el orden en la lista");
			bw.newLine();
			bw.write("> Si no hay diponibilidad del producto, ingresar un '-1' "
					+ "(datos separados por coma y sin espacio): ");
			bw.flush();
			
			size = br.readLine().split(",");
			
			Cant = new int[size.length];
			
			for(int i = 0; i < size.length; i++)
				Cant[i] = Integer.parseInt( size[i]);
			
			for(int i = 0; i < Merca.length; i++) {
				
				if(Cant[i] > 0) 
					Suma = Suma + (Price[Merca[i]] * Cant[i]);
				
			}
			
			bw.write(">> ¿Hay fila en la caja registrador?  ");
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

			bw.write("El presupuesto para la compra de su mercado es de: $" + Suma);
			bw.newLine();
			bw.flush();
			
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
			int Elem_Price[] = null;
			String Size[] = null;
			int unidades[] = null;
			int Long = 0;
			
			
			bw.write("Para todos los alimentos, viveres y elementos de aseo faltantes en la casa, hacer "
					+ "una lista de compras.");
			bw.newLine();
			bw.flush();
			
			bw.write("Hacen falta Vegetales, Viveres o elementos de aseo? ");
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
				System.arraycopy(Cadena("Supermercado/Elem.in", Long * 2), 0, Elem, 0, Long * 2);
				
				Print_String(Elem);
				
				Elem_Price = new int[Long];
				System.arraycopy(Cadena_Price("Supermercado/Elem.in", Long), 0, Elem_Price, 0, Long);
				
				bw.newLine();
				bw.write("Indique el numero de refencia de los vegetales, viveres o elementos de aseo que hacen falta"
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
			
			unidades = new int[Ref.length];
			
			for(int i = 0; i < unidades.length; i++)
				unidades[i] = (int)(Math.random() * 20);
			
			Print_Price(Ref,Elem,Elem_Price,unidades);
			Comparation(Ref,Elem,Elem_Price,unidades);
		}
		catch (Exception ex) {}
	}

}
