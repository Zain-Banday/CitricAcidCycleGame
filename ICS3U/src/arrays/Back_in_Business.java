package arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import in_out.Out;

public class Back_in_Business {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileReader fr = new FileReader("StudentInfo.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String studentName;
			int studentAge;
			double studentMark;
			while ((studentName = br.readLine()) != null) {
				studentAge = Integer.parseInt(br.readLine());
				studentMark = Double.parseDouble(br.readLine());
				Out.println("Student Name: " + studentName + " Age: " + studentAge + " Mark:" + studentMark);
				
			}
			
			fr.close();
			br.close();
			
		}	catch (IOException e) {
				Out.println("I/O error");
		}	catch (NumberFormatException e) {
				Out.println("Number Format Error");
		}
		
		


	}

}