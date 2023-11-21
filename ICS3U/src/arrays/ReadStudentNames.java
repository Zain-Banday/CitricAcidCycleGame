package arrays;
import java.io.*;
import in_out.*;

public class ReadStudentNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("StudentNames.txt");
			
			BufferedReader br = new BufferedReader(fr);
			
			
			String studentName;
			while ((studentName = br.readLine()) != null) {
				Out.println(studentName);
			}
			fr.close();
			br.close();
		}	catch (IOException e) {
			Out.println("I/O error");
		}

	}

}
