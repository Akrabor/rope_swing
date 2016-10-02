package view;

import controller.Controller;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Henrik on 02.10.2016.
 */
public class View extends JFrame implements Observer{

    private JLabel lengthL, widthL;
    private JTextField lengthTF, widthTF;
    private JButton calculateB, exitB;

    //Button handlers:
    private CalculateButtonHandler cbHandler;
    private ExitButtonHandler ebHandler;

    public View(int width, int height, String title){
        //Instantiate the labels:
        lengthL = new JLabel("Enter position x: ", SwingConstants.RIGHT);
        widthL = new JLabel("Enter position y: ", SwingConstants.RIGHT);

        //Text fields next:
        lengthTF = new JTextField(10);
        widthTF = new JTextField(10);

        //Specify handlers for each button and add (register) ActionListeners to each button.
        calculateB = new JButton("Update position");
        cbHandler = new CalculateButtonHandler();
        calculateB.addActionListener(cbHandler);
        exitB = new JButton("Exit");
        ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);

        setTitle(title);
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3, 2));

        //Add things to the pane in the order you want them to appear (left to right, top to bottom)
        pane.add(lengthL);
        pane.add(lengthTF);
        pane.add(widthL);
        pane.add(widthTF);
        pane.add(calculateB);
        pane.add(exitB);

        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private class CalculateButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Controller.getInstance().changePlayerPosition(Integer.valueOf(lengthTF.getText()),Integer.valueOf(widthTF.getText()) );
        }
    }

    public class ExitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

    public void update(Observable o, Object arg){

        System.out.println("received model update.");
        if((int)arg == 1){
            System.out.println("new Player's position: " + Controller.getInstance().getPlayerPositionX() + "," + Controller.getInstance().getPlayerPositionY());
        }
    }
}
