import javax.swing.*;
import java.awt.*;

public class GuiTemperature extends JFrame{

    private Container pane;
    private JTextField t;
    private JButton CtoF;
    private JButton FtoC;
    

    public static double CtoF(double t){
	return t*9/5 +32;
    }

    public static double FtoC(double t){
	return (t - 32)*5/9;
    }

    public GuiTemperature(){
	this.setTitle("Gui Temperature");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	t = new JTextField(12);

    
