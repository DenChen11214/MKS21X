import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener{
  private JButton fcButton;
  private JButton cfButton;
  private JTextField fcText;
  private JTextField cfText;
  private Container pane;
  public TemperatureWindow(){
    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    this.setTitle("TemperatureConverter");
    this.setSize(600,400);
    this.setLocation(0,0);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    fcButton = new JButton("FahrenheitToCelcius");
    cfButton = new JButton("CelciustoFahrenheit");
    fcText = new JTextField(15);
    cfText = new JTextField(15);
    fcButton.addActionListener(this);
    cfButton.addActionListener(this);
    pane.add(fcButton);
    pane.add(fcText);
    pane.add(cfButton);
    pane.add(cfText);
  }
  public void actionPerformed(ActionEvent e){

  }
  public double CtoF(double cel){
    return cel * 1.8 + 32;
  }
  public double FtoC(double fah){
    return (fah - 32) / 1.8;
  }
}
