package src;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
public class Frame {
    public static int height,width;
    public JFrame frame;
    public JTextField field;
    public JTextArea area;
    public JPanel sidebar,s;
    public JButton menu;
    public ArrayList<String> store;
    public Frame(int h , int w){
        frame = new JFrame();
        field = new JTextField();
        store = new ArrayList<>();
        height = h;
        width = w;
        area = new JTextArea();
        area.setEditable(false);
        area.setBounds(10,10,130,120);
        menu = new JButton("...");;
        menu.setBounds(480, 10, 40, 40);
        menu.addActionListener(e -> {
            sidebar.setVisible(!sidebar.isVisible());
        });
        sidebar = new JPanel();
        sidebar.setBounds(400, 70, 150, height);
        sidebar.setBackground(Color.LIGHT_GRAY);
        sidebar.setVisible(false);
        s = new JPanel();
        s.setName("History Panel");
        s.setBounds(400,70,150,height);
        s.setBackground(Color.LIGHT_GRAY);
        s.setVisible(false);
        JButton history = new JButton("History");
        history.setBounds(10, 70, 130, 40);
        history.addActionListener(e ->{
            sidebar.setVisible(false);
            s.setVisible(true);
            area.setText("");
            for(String cal : store){
                area.setText(area.getText() + cal + "\n");
            }
        });
        JButton c = new JButton("Close");
            c.setBounds(10, 170, 130, 40);
            c.addActionListener(f->{
                s.setVisible(false);
                sidebar.setVisible(true);
            });
            JButton clear = new JButton("Clear");
            clear.addActionListener(f->{
                area.setText("");
                store.clear();
            });
        s.add(c);
        s.add(clear);
        s.add(area);
        JButton close = new JButton("Close");
        close.setBounds(10, 170, 130, 40);
        close.addActionListener(e ->{
            sidebar.setVisible(false);
        });
        sidebar.add(history);
        sidebar.add(close);
    }
    public void setUp(){
        frame.setSize(width,height);
        frame.setTitle("Calculator");
        field.setBounds(30,30,330,50);
        field.setEditable(false);   
        frame.add(field);
        frame.add(menu);
        frame.add(sidebar);
        frame.add(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        Buttons ob = new Buttons(field,frame,store);
        ob.setButton();
        frame.setVisible(true);
    }   
}
