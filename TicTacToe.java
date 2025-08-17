// Imported Packages
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

public class TicTacToe {
    // Variables
    static final int INIT_WIDTH = 600;
    static final int INIT_HEIGHT = 600;

    public static void main(String[] args) {
        displayGUI();
    }

    public static void displayGUI() {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(INIT_WIDTH, INIT_HEIGHT);
        frame.setLayout(new CardLayout());
        frame.setResizable(false);

        // Welcome Panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(null);
        welcomePanel.setBounds(0, 0, INIT_WIDTH, INIT_HEIGHT);
        welcomePanel.setBackground(Color.decode("#05DBFC"));

        JLabel welcomeTitle = new JLabel("Tic Tac Toe");
        welcomeTitle.setFont(Inter.getInterBoldFont(45));
        welcomeTitle.setForeground(Color.decode("#03468F"));
        
        // Center horizontally in the panel
        welcomeTitle.setBounds(0, 50, INIT_WIDTH, 50);
        welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
        welcomePanel.add(welcomeTitle);

        // Adding Panels to Frame
        frame.add(welcomePanel);
        
        // Keep this below EVERY GUI line
        frame.setVisible(true);
    }
    
}
