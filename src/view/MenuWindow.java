package view;

import controller.Controller;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Henrik on 02.10.2016.
 */
public class MenuWindow extends JFrame{

    private JLabel lengthL, widthL;
    private JTextField lengthTF, widthTF;
    private JButton startGame, exitB;

    //Button handlers:
    private StartGameButtonHandler cbHandler;
    private ExitButtonHandler ebHandler;

    public MenuWindow(int width, int height, String title){
        //Instantiate the labels:
        lengthL = new JLabel("Enter position x: ", SwingConstants.RIGHT);
        widthL = new JLabel("Enter position y: ", SwingConstants.RIGHT);

        //Text fields next:
        lengthTF = new JTextField(10);
        widthTF = new JTextField(10);

        //Specify handlers for each button and add (register) ActionListeners to each button.
        startGame = new JButton("Start Game");
        cbHandler = new StartGameButtonHandler();
        startGame.addActionListener(cbHandler);
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
        pane.add(startGame);
        pane.add(exitB);

        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void activate(){
        setVisible(true);
    }
    public void deActivate(){
        setVisible(false);
    }

    private class StartGameButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Controller.getInstance().startGame();
            //Controller.getInstance().changePlayerPosition(Integer.valueOf(lengthTF.getText()),Integer.valueOf(widthTF.getText()) );
        }
    }

    public class ExitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
