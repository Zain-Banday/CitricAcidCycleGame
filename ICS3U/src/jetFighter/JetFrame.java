package jetFighter;



import javax.swing.JFrame;



public class JetFrame extends JFrame{

	JetPanel panel;
	
	JetFrame(){
		
		panel = new JetPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(null);
		
		this.setResizable(false);
		
		this.setVisible(true);
		this.setTitle("Jet Fighter");
		
		this.add(panel);
		this.pack();
		
		
		
		

		
	}


}
	
