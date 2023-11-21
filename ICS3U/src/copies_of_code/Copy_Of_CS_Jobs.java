package copies_of_code; 

import java.io.BufferedReader; 

import java.io.FileReader; 

import java.io.IOException; 

import in_out.Out; 

/* 
* Project: src
* Package: arrays
* Class:  CS_Jobs_Assignment 
* Programmer: Zain Banday
* Date Created: 4/11/2023
* Description: Reads text from a notepad file about Computer Science Jobs, 
* and calculates average salary, lowest salary, and highest salary.
*/ 

public class Copy_Of_CS_Jobs { 

	public static void main(String[] args) { 

		// TODO Auto-generated method stub 

		//Variables
		int numJobs = 0;
		int numSources = 0; 
		String[] jobNames = new String[20];
		String[] sources = new String[3];
		String[] jobDescriptions = new String[20];
		int[] jobSalaries = new int[20];
		String[] bigList = new String[60];
		
		int minSalary = 1000000000, maxSalary = 0, minIndex = 0, maxIndex = 0;
		double sum = 0;
		
		
		
		
		//Start reading notepad functions
		try { 
			

			FileReader fr = new FileReader("CScareers.txt"); 

			BufferedReader br = new BufferedReader(fr); 

			//set number of sources
			numSources = Integer.parseInt(br.readLine()); 
			
			
		
			//set links of sources inside list
			for (int i = 0; i < numSources; i++) {
				sources[i] = br.readLine();
			}
			//set number of careers
			numJobs = Integer.parseInt(br.readLine());
			
			//make one big list containing all lines of code
			for (int g = 0; g < 60; g++) {
				bigList[g] = br.readLine();
	
			}
			//set job names (job names can only be under indexes 0,3,6,9......)
			for (int j = 0; j < 60; j += 3 ) {
				jobNames[j / 3] = bigList[j];
	
			}
			//set job salaries (job salaries can only be under indexes 1,4,7,10......)
			for (int p = 1; p < 60; p += 3 ) {

				jobSalaries[p / 3] = Integer.parseInt(bigList[p]);

			}
			//set job descriptions (job descriptions can only be under indexes 2,5,8,11......)
			for (int m = 2; m < 60; m+= 3) {
				jobDescriptions[m / 3] = bigList[m];

			}
				
			fr.close(); 

			br.close(); 
		} catch (IOException e) {  //IO Exception

			Out.println("I/O error"); 

		} catch (NumberFormatException e) { //Number Format Exception

			Out.println("Number Format Error"); 

		} 
		
		//caluclate sum, minimum, and maximum salary
		
		for (int i = 0; i < numJobs; i++) {
			sum += jobSalaries[i];
			if (jobSalaries[i] < minSalary) {
				minSalary = jobSalaries[i]; //set new minimum
				minIndex = i; //save minimum index
			}
			else if (jobSalaries[i] > maxSalary) {
				maxSalary = jobSalaries[i]; //set new maximum
				maxIndex = i; //save maximum index
			}
		}
		
		sum = (sum / numJobs); //calculate average
		
		//output sources
		Out.println("There are " + numSources + " sources. They Are: ");
		for (int i = 0; i < numSources; i ++) {
			Out.println(sources[i]);
		}
		
		//output lowest salaries
		Out.println("\nThe lowest salary of the 20 jobs is " + jobNames[minIndex] + ", they are paid $"
				+ minSalary + " and their job description is: ");
		Out.println(jobDescriptions[minIndex]);
		
		
		//output highest salaries
		Out.println("\nThe highest salary of the 20 jobs is " + jobNames[maxIndex] + ", they are paid $"
				+ maxSalary + " and their job description is: ");
		Out.println(jobDescriptions[maxIndex]);
		
		//output average
		Out.println("\nThe average of all salaries is $" + sum);
		


	} 
}
