package graphic; 

 

import java.awt.*; 

import javax.swing.*; 
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.net.MalformedURLException;
import java.net.URL;

 

public class Test_Draw extends JPanel { 

private static final long serialVersionUID = 1L; 

 

public void paintComponent(Graphics g) { 

super.paintComponent(g); 

setForeground(Color.BLUE); 

setBackground(Color.WHITE); 





 

Color mouthColour; 

Color skinColour; 

skinColour = new Color(69, 49, 2);

//draw head
g.setColor(skinColour);
g.drawOval(365, 265, 70, 70);
g.fillOval(365, 265, 70, 70);

//draw eyes
g.setColor(Color.BLACK);
g.fillOval(380,290,10,10);
g.fillOval(415,290,10,10);

//draw mouth
mouthColour = new Color(161, 27, 130);
g.setColor(mouthColour);
g.fillRect(380, 310, 45, 5);


//draw shirt
g.setColor(Color.red);

g.fillOval(375,335,50,150);


} 

 

public static void main(String[] args) { 

Test_Draw d = new Test_Draw(); 

JFrame f = new JFrame("Test Draw"); 

ImageIcon img = null;
try {
	img = new ImageIcon(new URL("https://th.bing.com/th/id/OIP.51iYQmIsUvjqIq2eisdkyQAAAA?pid=ImgDet&rs=1"));
} catch (MalformedURLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
JLabel jlPic = new JLabel(img);
f.add(jlPic);

f.add(d); 

f.setSize(800, 600); 

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

f.setLocationRelativeTo(null); 

f.setVisible(true); 

} 

} 