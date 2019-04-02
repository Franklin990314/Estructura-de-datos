package LinearDS_Problems;
import java.util.Arrays;
import java.util.Random;

import LinearDS_Problems.EconomicPhonebook.ProblemNode;
import Linear_Data_Structures.List;
import Linear_Data_Structures.Node;

import java.io.*;

/**
 * 
 * @author Franklin
 *
 */

public class Examen {
	
	public class ProblemNode implements Node
	{
		public int value;
		public ProblemNode next = null;
		
		/**
		 * 
		 * @param value
		 */
		public ProblemNode(int value) 
		{
			this.value = value;
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
			ProblemNode temp = new ProblemNode(this.value);
			return temp;
		}


		@Override
		public boolean isEqual(Node node) 
		{
			ProblemNode temp = (ProblemNode)node;
			return this.value == temp.value ? true : false;
		}


		@Override
		public boolean isLessThan(Node node) 
		{
			ProblemNode temp = (ProblemNode)node;
			return this.value < temp.value ? true : false;
		}
		
		public String toString()
		{
			return "" + this.value;
		}
	}
	
	/**
	 * 
	 */
	public Examen () {}
	
	public int solution() {
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		int n = 0, d = 0, Extra = 0, Cont_Extras = 0;
		String[] sizes = null;
		List morning = new List();
		List afternoon = new List();
		
		try 
		{
			bw.write("Por favor indique el número de conductores y rutas a utlizar: ");
			bw.flush();
			n = Integer.parseInt(br.readLine());
			bw.write("Ingrese los tamaños de las rutas de viaje de la mañana (separados por coma y sin espacio): ");
			bw.flush();
			sizes = br.readLine().split(",");
			
			for(int i = 0; i < sizes.length; i++)
				morning.insertAtEnd(new ProblemNode( Integer.parseInt(sizes[i]) ));
			
			sizes = null;
			bw.write("Ingrese los tamaños de las rutas de viaje de la tarde (separados por coma y sin espacio): ");
			bw.flush();
			sizes = br.readLine().split(",");
			
			for(int i = 0; i < sizes.length; i++)
				afternoon.insertAtBegin(new ProblemNode( Integer.parseInt(sizes[i]) ));
			
			
			morning.quickSort(morning);
			System.out.println("funciona");
			afternoon.quickSort(afternoon);
			afternoon.reverse();
			
			bw.write("Indique la duración de trabajo por día: ");
			bw.flush();
			n = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; i++) {
				
				Extra = Integer.parseInt( morning.get(i).toString() ) + Integer.parseInt ( afternoon.get(i).toString() );
				if(Extra > d)
					Cont_Extras += Extra - d;
			}
			
		}
		catch(Exception ex) {}
		
		return Cont_Extras;
	}
	
	public static void main(String[] args) {
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));
		
		try 
		{
				
			Examen problem = new Examen();
			bw.write("La menor cantidad de horas extras posibles a pagar es de: $" + problem.solution() + "\n" );
			bw.flush();
			
		}
		catch(Exception ex) {}
		
		
	}

}