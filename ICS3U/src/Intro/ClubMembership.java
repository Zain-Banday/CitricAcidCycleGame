package Intro;

import in_out.In;
import in_out.Out;


public class ClubMembership {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating local variables
		boolean tennisStatus = false;
		boolean lockerStatus = false;
		
		//asking for name
		Out.println("Enter name: ");
		String nameMember = In.getString();
		
		//asking for town
		Out.println("Enter Town or City Name: ");
		String townMember = In.getString();
		
		//asking if they want lockers
		Out.println("Do you want a locker for an additonal fee of $5.00? ");
		String lockerAffirmation = In.getString();
		if (lockerAffirmation.equals("yes") || lockerAffirmation.equals("Yes")) {
			 lockerStatus = true;
		}
		
		//asking if they want tennis court
		Out.println("Do you want Tennis Court Access for an additonal fee of $10.00? ");
		String tennisAffirmation = In.getString();
		if (tennisAffirmation.equals("yes") || tennisAffirmation.equals("Yes")) {
			tennisStatus = true;
		}
		

		//base price for gym membership
		double monthlyFee;
		monthlyFee = 34.99;
		
	
		//price if they got neither statuses
		if (lockerStatus == false && tennisStatus == false) {
			System.out.println("Membership Card\nName: "+nameMember+"    Town: "+townMember+
					"    Monthly Fee: $" +monthlyFee);
			
		//price if they got locker status
		} else if (lockerStatus == true && tennisStatus == false) {
			monthlyFee = monthlyFee + 5;
			System.out.println("Membership Card\nName: "+nameMember+"    Town: "+townMember+
					"    Monthly Fee: $" +monthlyFee);
		
		//price if they got tennis Status
		} else if (lockerStatus == false && tennisStatus == true) {
			monthlyFee = monthlyFee + 10;
			System.out.println("Membership Card\nName: "+nameMember+"    Town: "+townMember+
					"    Monthly Fee: $" +monthlyFee);
		
		//price if they got both locker Status and tennis Status	
		} else {
			monthlyFee = monthlyFee + 15;
			System.out.println("Membership Card\nName: "+nameMember+"    Town: "+townMember+
					"    Monthly Fee: $" +monthlyFee);
		}
			
			
		
		//printing out locker status
		if (lockerStatus == true) {
				System.out.println("Locker Status: True");
		} else {
			System.out.println("Locker Status: False");
		}
		
		//printing out tennis Status
		if (tennisStatus == true) {
			System.out.println("Tennis Court Access: True");
			
		} else {
			System.out.println("Tennis Court Access: False");
		}
	
		
	
		

	}

}
