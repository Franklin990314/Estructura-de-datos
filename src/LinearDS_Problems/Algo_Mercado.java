package LinearDS_Problems;

import java.io.*;
import java.util.Scanner;

import Linear_Data_Structures.Node;
import Linear_Data_Structures.List;

import java.util.*;

/**
 * 
 * @author Franklin
 *
 */

public class Algo_Mercado {
	
	/**
	 * 
	 *
	 */
	public class ProblemNode implements Node
	{
		public double value;
		public String Ref;
		public ProblemNode next = null;
		
		/**
		 * 
		 * @param value
		 */
		public ProblemNode(String Ref, double value) 
		{
			this.value = value;
			this.Ref = Ref;
		}
		
		@Override
		public void setNext(Node node) 
		{
			this.next = (ProblemNode)node;
		}


		@Override
		public Node getNext() 
		{
			return next;
		}


		@Override
		public Node clone() {
			ProblemNode temp = new ProblemNode(this.Ref, this.value);
			return temp;
		}


		@Override
		public boolean isEqual(Node node) 
		{
			ProblemNode temp = (ProblemNode)node;
			return this.Ref == temp.Ref ? true : false;
		}


		@Override
		public boolean isLessThan(Node node) 
		{
			ProblemNode temp = (ProblemNode)node;
			return this.value < temp.value ? true : false;
		}
		
		public String toString()
		{
			return this.Ref + "," + this.value;
		}
		
	}
	
	/**
	 * 
	 */
	public Algo_Mercado () {}
	
	
	public static void Print_String (List Elem, int Caden) {
		
		try
		{
			
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			
			for(int i = 0; i < ((Elem.length() * Caden) / Elem.length()); i++) {
				
				bw.write( i + " " + Elem.get(i).toString().split(",")[0]);
				bw.flush();
				bw.write(Elem.get(i).toString().split(",")[0].length() > 13 || (Elem.get(i).toString().split(",")[0].length() < 11 && Elem.get(i).toString().split(",")[0].length() > 5) ? "			": "				");
				bw.flush();
				bw.write(i + (Caden) + " " + Elem.get(i+Caden).toString().split(",")[0]);
				bw.flush();
				bw.write(Elem.get(i+Caden).toString().split(",")[0].length() < 5 || Elem.get(i+Caden).toString().split(",")[0].length() > 13? "			": "				");
				bw.flush();
				bw.write(i + (Caden * 2) + " " + Elem.get(i+(Caden*2)).toString().split(",")[0]);
				bw.flush();
				bw.newLine();
				bw.flush();
				
			}
		}
		catch (Exception ex) {}
	}
	
	public static void Print_Price(int[] Ref, String[] Points, List Elem, int[] unid) {
		
		try
		{
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			
			for(int i = 0; i < Ref.length; i++) {
				
				bw.write(Elem.get(Ref[i]).toString().split(",")[0] + "" + Points[Ref[i]] + "" + Elem.get(Ref[i]).toString().split(",")[1] + "          	"
						+ "Cant. disponible: " + unid[i]);
				bw.flush();
				bw.write(Ref[i] == 4? " lb.": " U.");
				bw.newLine();
				bw.flush();
			}
		}
		catch (Exception ex) {}
	}
	
	public static Double Comparation(int[] Ref, List Price, int[] Cant) {
		
		try
		{
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			Double Suma = 0.0;
			String Ans = null;
			
			for(int i = 0; i < Ref.length; i++) {
				
				if(Cant[i] > 0) 
					Suma = Suma + (Double.parseDouble(Price.get(Ref[i]).toString().split(",")[1]) * Cant[i]);
				
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
		return 0.0;
	}
	
	public Double solution() {
		
		try
		{
			
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			String Ans = null;
			int Cont = 0;
			int Ref[] = null, Cant[] = null, unid[] = null;
			String Elem[] = null, Size[] = null;
			List Elements = new List();
			
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
					
					String[] inf = Linea.split(" ");
					Elements.insertAtBegin(new ProblemNode ( inf[0] , Double.parseDouble(inf[2])) );
					Cont++;
					
				}
				
				BufferedReader bx = new BufferedReader (new FileReader(new File("Supermercado/Elem.in")));
				
				Elem = new String[Cont];
				for(int j = 0; j < Cont; j++) {
					
					String[] inf = bx.readLine().split(" ");
					Elem[j] = inf[1];
				}
					
				bw.write("> VEGETALES" + "			" + "> VÍVERES" + "				" + "> ELEMENTOS DE ASEO");
				bw.newLine();
				bw.newLine();
				bw.flush();
				
				Elements.reverse();
				Print_String(Elements, 10);
				
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
			
			Print_Price(Ref,Elem,Elements,unid);
			
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
			
			return Comparation(Ref,Elements,Cant);
			
		}
		catch (Exception ex) {}
		
		return -1.0;
	}
	
	
	public static void main(String[] args) {
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));
		
		try 
		{
				
			Algo_Mercado problem = new Algo_Mercado();
			bw.write("El presupuesto para la compra de su mercado es de: $" + problem.solution() + "\n" );
			bw.flush();
			
		}
		catch(Exception ex) {}
		
		
	}

}
