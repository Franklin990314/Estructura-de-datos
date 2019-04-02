package LinearDS_Problems;

import java.io.*;

import Linear_Data_Structures.List;
import Linear_Data_Structures.Node;


/**
 * 
 * @author Franklin
 *
 */

public class EconomicPhonebook {
	
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
	public EconomicPhonebook () {}
	
	
	public int solution(String num) {
		
		BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
		List Phone = new List();
		int num_case = Integer.parseInt( num ), Max = 0, max = 0, Mag = 0;
		
		try 
		{
				
			for(int i = 0; i < num_case; i++) {
					
				String Num = br.readLine();
				Phone.insertAtBegin(new ProblemNode ( Integer.parseInt(Num) ));
			}
			
			Phone.reverse();
			Mag = Phone.get(0).toString().length();
			for(int i = 0; i < num_case; i++) {
				
				for(int j = 0; j < Mag - 2; j++) {
					
					if(Phone.get(0).toString().charAt(j) == Phone.get(i+1).toString().charAt(j))
						max++;
				}
				if(max > Max)
					Max = max;
				max = 0;
			}
					
		}
		catch(Exception ex) {}
		
		return Max;
	}
	
	public static void main(String[] args) {
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));
		BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
		
		try 
		{
			String num_case = null;
			
			while( (num_case = br.readLine() ) != null) {
				
				EconomicPhonebook problem = new EconomicPhonebook();
				bw.write( problem.solution(num_case) + "\n" );
				bw.flush();
			}
		}
		catch(Exception ex) {}
	}

}
