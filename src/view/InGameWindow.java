package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Henrik on 02.10.2016.
 */
public class InGameWindow extends JFrame{

    private String propsLocation;
    private Properties props;

    private Container pane = getContentPane();

    public InGameWindow(String propsLocation){
        this.propsLocation = propsLocation;
        loadProperties();

        setTitle(props.getProperty("project.title"));

        loadBackgroundImage();
        setSize(Integer.valueOf(props.getProperty("ingame.width")), Integer.valueOf(props.getProperty("ingame.height")));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void loadProperties(){
        try{
            props = new Properties();
            FileInputStream s = new FileInputStream(propsLocation);
            props.load(s);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadBackgroundImage(){
        String path = props.getProperty("ingame.bgimage");
        File file = new File(path);
        try{
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            pane.add(label);
            pack();
            setLocation(200,200);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void activate(){
        setVisible(true);
    }

    public void deActivate(){
        setVisible(false);
    }
}
