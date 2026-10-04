package src;
import javax.swing.*;
import java.util.ArrayList;
public class Buttons{
    public JButton[] b;
    private JTextField field;
    private JFrame frame;
    ArrayList<String> store;
    Buttons(JTextField field , JFrame frame, ArrayList<String> store){
        this.field = field;
        this.frame = frame;
        this.store = store;
        b = new JButton[18];
        for(int i = 0;i<17;i++){
            b[i] = new JButton(String.valueOf(i));
        }
        b[10] = new JButton("+");
        b[11] = new JButton("-");
        b[12] = new JButton("*");
        b[13] = new JButton("/");
        b[14] = new JButton("%");
        b[15] = new JButton("^");
        b[16] = new JButton("=");
        b[17] = new JButton("CLEAR");
        addListeners();
    }
    private void addListeners(){
        for(int i = 0;i<16;i++){
            b[i].addActionListener(e -> {
                JButton c = (JButton) e.getSource();
                field.setText(field.getText() + c.getText());
            });
        }
        b[16].addActionListener(e -> {
            String exp = field.getText();
            double result = new Logic().evaluate(exp);
            field.setText(Double.toString(result));
            store.add(exp + " = " + result);
        });
        b[17].addActionListener(e -> {
            field.setText("");
        });
    }
    public void setButton(){
        for(int i = 0;i<18;i++){
            b[i].setBounds(30 + (i % 4) * 80,
                120 + (i / 4) * 60,
                70,
                50);
            frame.add(b[i]);
        }
    }
}
