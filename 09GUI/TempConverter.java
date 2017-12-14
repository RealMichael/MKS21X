import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TempConverter extends JFrame implements ActionListener{

    //VARIABLES

    private Container pane;
    private JButton f;
    private JButton c;
    //  private JLabel l;
    private JTextField t;
    //  private JCheckBox Celsius;
    //   private JCheckBox Fahrenheit;

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	try{
	    Double.parseDouble(t.getText());
	}
	catch(NumberFormatException A){
	    System.out.println("Enter a NUMBER");
	}
    
	
	 if(s.equals("Convert TO FAHRENHEIT!")){
	    System.out.println(((Double.parseDouble(t.getText()) * 1.8) + 32));
	}
	else{
	    System.out.println((Double.parseDouble(t.getText()) - 32) / 1.8);
	}
    
    }

    //CONSTRUCTOR
    
    public TempConverter(){
	this.setTitle("Convert your Temperature!");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	f = new JButton("Convert TO FAHRENHEIT!");
	c = new JButton("CONVERT TO CELSIUS!");
	t = new JTextField(20);
	//	l = new JLabel("pfff");
	//	Celsius = new JCheckBox("CELSIUS TO FAHRENHEIT");
	//	Fahrenheit = new JCheckBox("FAHRENHEIT TO CELSIUS");
	
	f.addActionListener(this);
	c.addActionListener(this);

	pane.add(t);
	pane.add(c);
	pane.add(f);
    }




    //DRIVER
    public static void main(String[] args){
	TempConverter a = new TempConverter();
	a.setVisible(true);
    }
}
