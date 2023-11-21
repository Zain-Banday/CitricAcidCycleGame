package ReveiwingCodingForJava;
import in_out.In;
import in_out.Out;

public class HelloWorld {

	public static void main(String[] args) {
		double radius = 1, area;
		boolean running = true;
		
	
		while (running) {
			Out.print("enter a radius (0 to cancel)");
			radius = In.getInt();
			if (radius !=0) {
				
				area = Math.PI * (Math.pow(radius, 2));
				Out.print(area);
				
			}
			else {
				running = false;
			}
		}
		
		
		
	

		
	}

}
