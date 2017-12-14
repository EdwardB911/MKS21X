import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiTemperature extends JFrame implements ActionListener{

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
	CtoF = new JButton("CtoF");
	FtoC = new JButton("FtoC");

	t.addActionListener(this);
	CtoF.addActionListener(this);
	FtoC.addActionListener(this);

	pane.add(t);
	pane.add(CtoF);
	pane.add(FtoC);
    }

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	System.out.println(s);
	if(s.equals("CtoF")){
	    t.setText(CtoF(t.getText()));
	}
	if(s.equals("FtoC")){
	    t.setText(FtoC(t.getText()));
	}
    }

    public static void main(String[] args){
	GuiTemperature g = new GuiTemperature();
	g.setVisible(true);
    }
}
    
