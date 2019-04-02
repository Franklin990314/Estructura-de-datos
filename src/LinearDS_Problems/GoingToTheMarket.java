package LinearDS_Problems;

import java.io.*;

import Linear_Data_Structures.List;
import Linear_Data_Structures.Node;

/**
 * 
 * @author Franklin
 *
 */

public class GoingToTheMarket  {
	
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
	public GoingToTheMarket () {}
	
	/**
	 * 
	 * @return
	 */
	public Double solution() {
		
		BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
		List Market = new List();
		Double Suma = 0.0; 
		
		try 
		{
			int num_case = Integer.parseInt (br.readLine() ), Long = num_case;
			
			for(int i = 0; i < num_case; i++) {
				
				String[] Num = br.readLine().split(" ");
					
				Market.insertAtBegin(new ProblemNode ( Num[0] , Double.parseDouble( Num[1] )) );
				 
			}
			
			Market.reverse();
			
			num_case = Integer.parseInt (br.readLine() );
			
			for(int i = 0; i < num_case; i++) {
				
				String[] Num = br.readLine().split(" ");
				
				for(int j = 0; j < Long; j++) 
					if(Num[0].equals( Market.get(j).toString().split(",")[0] ) ) 
						Suma = Suma + (Integer.parseInt(Num[1]) * Double.parseDouble( Market.get(j).toString().split(",")[1] ));
			}
			
		}
		catch(Exception ex) {}
		
		return Suma;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));
		BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
		
		try 
		{
			int num_case = Integer.parseInt( br.readLine() );
			
			for(int i = 0; i < num_case; i++) {
				
				GoingToTheMarket problem = new GoingToTheMarket();
				bw.write("R$ " + problem.solution() + "\n" );
				bw.flush();
			}
		}
		catch(Exception ex) {}
		
	}
}