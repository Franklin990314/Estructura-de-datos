package Various;
import java.util.Arrays;
import java.util.Random;

import java.io.*;

/**
 * 
 * @author Franklin
 *
 */

public class Examen {
	
	public static int []Comparacion(int Conduc, int[] Ruta) {
		int[] Rutas_Asig = null;
		if(Conduc <= Ruta.length) {
			
			Rutas_Asig = new int[Ruta.length];
			Arrays.sort(Ruta);
			
			for(int i = 0; i < Ruta.length; i++)
				Rutas_Asig[i] = Ruta[i];
		}
		else {
			
			Rutas_Asig = new int[Conduc];
			Arrays.sort(Ruta);
			
			int j = 0;
			int i = 0;
			while(i < Conduc) {
				
				if(j < Ruta.length) {
					
					Rutas_Asig[i] = Ruta[j];
					i++;
					j++;
				}else {
					
					j = 0;
				}
			}
			
		}
		
		return Rutas_Asig;
	}
	
	public static void printArray(int[] array, int[] array_1, int Conduc, int Horas) {
		
		try
		{
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

			for(int i = 0; i < Conduc; i++) {
				
				int j = array[i] + array_1[i];
				if(j > Horas)
					bw.write("** Conductor #" + (i + 1) + ", Rutas asignadas: " + array[i] + " , " + array_1[i] + 	
							 ", Horas Extras: " + (j - Horas) + ". **");
				else
					bw.write("** Conductor #" + (i + 1) + ", Rutas asignadas: " + array[i] + " , " + array_1[i] + 	
							 ", Horas Extras: 0. **");
				
				}

			bw.write("\n");
			bw.flush();
			bw.close();
		}
		catch(Exception ex) {}		
	}
	
	public static void main(String[] args) {
		
		System.gc();

		try
		{
			BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
			int Conductores = 0;
			int[] Rutas_M = null;
			int[] Rutas_T = null;
			String[] sizes = null;
			String[] sizes_1 = null;
			int Horas_Max = 0;
			
			bw.write("Defina la cantidad de conductores: ");
			bw.flush();
			Conductores = Integer.parseInt(br.readLine());
			
			bw.write("Ingrese los tamaños de las rutas de viaje de la mañana (separados por coma y sin espacio): ");
			bw.flush();
			sizes = br.readLine().split(",");
			
			Rutas_M = new int[sizes.length];
			for(int i = 0; i < sizes.length; i++)
				Rutas_M[i] = Integer.parseInt( sizes[i] );
			
			bw.write("Ingrese los tamaños de las rutas de viaje de la tarde (separados por coma y sin espacio): ");
			bw.flush();
			sizes_1 = br.readLine().split(",");
			
			Rutas_T = new int[sizes_1.length];
			for(int i = 0; i < sizes_1.length; i++)
				Rutas_T[i] = Integer.parseInt( sizes_1[i] );
			
			bw.write("Defina la cantidad de Horas de trabajo ");
			bw.flush();
			Horas_Max = Integer.parseInt(br.readLine());
			
			printArray(Comparacion( Conductores, Rutas_M), Comparacion( Conductores, Rutas_T), Conductores, Horas_Max);
			
		}
		catch(Exception ex) {}

	}

}