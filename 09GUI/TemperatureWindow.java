import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener{
  private JButton fcButton;
  private JButton cfButton;
  private JTextField fcText;
  private JTextField output;
  private Container pane;
  public TemperatureWindow(){
    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    this.setTitle("TemperatureConverter");
    this.setSize(600,400);
    this.setLocation(0,0);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    fcButton = new JButton("Fahrenheit To Celcius");
    cfButton = new JButton("Celcius To Fahrenheit");
    fcText = new JTextField(15);
    output = new JTextField(15);
    fcButton.addActionListener(this);
    cfButton.addActionListener(this);
    pane.add(fcButton);
    pane.add(fcText);
    pane.add(cfButton);
    pane.add(output);
  }
  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    try{
	if(s.equals("Fahrenheit To Celcius")){
	    output.setText(Double.toString(FtoC(Double.parseDouble(fcText.getText()))));
	}
	if(s.equals("Celcius To Fahrenheit")){
	    output.setText(Double.toString(CtoF(Double.parseDouble(fcText.getText()))));
	}
    }
    catch(NumberFormatException error){
	output.setText("Double type Only");
    }
  }
  public double CtoF(double cel){
    return cel * 1.8 + 32;
  }
  public double FtoC(double fah){
    return (fah - 32) / 1.8;
  }
  public static void main(String[] args){
    TemperatureWindow t = new TemperatureWindow();
    t.setVisible(true);
  }
}
