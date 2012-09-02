package pongUI;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 02/09/2012
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class OptionsPane extends JFrame{


    public OptionsPane(Properties properties) {
        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();

        StringBuilder stringBuilder = new StringBuilder();

        for(String key : properties.stringPropertyNames()){
            stringBuilder.append(key).append(" : ").append(properties.get(key)).append("\n");
        }

        textArea.append(stringBuilder.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane);


        this.add(mainPanel, BorderLayout.CENTER);
        this.setSize(200, 100);
        this.setVisible(true);
    }
}
