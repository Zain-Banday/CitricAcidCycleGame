package arrays; 

import java.io.BufferedReader; 

import java.io.FileReader; 

import java.io.IOException; 

import in_out.Out; 

public class Players { 

	public static void main(String[] args) { 

		// TODO Auto-generated method stub 

		try { 

			FileReader fr = new FileReader("PlayerStats.txt"); 

			BufferedReader br = new BufferedReader(fr); 

			String name; 

			int points; 

			int goals; 

			int assist; 

			while ((name = br.readLine()) != null) { 

				goals = Integer.parseInt(br.readLine()); 

				assist = Integer.parseInt(br.readLine()); 

				points = goals + assist; 

				Out.println(name + " - " + points + " points"); 

			} 
			
			fr.close(); 

			br.close(); 
		} catch (IOException e) { 

			Out.println("I/O error"); 

		} catch (NumberFormatException e) { 

			Out.println("Number Format Error"); 

		} 
		
	} 

} 
