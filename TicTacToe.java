// Imported Packages
import java.io.File;
import java.io.IOException;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

public class TicTacToe {
    // Variables
    static final int INIT_WIDTH = 600;
    static final int INIT_HEIGHT = 600;

    public static void main(String[] args) {
        // JButton Color Workaround for Mac - FINALLY FIGURED IT OUT!
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            Console.errprintln("Error: " + e.getMessage());
        }

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

        // Welcome Panel Button
        JButton welcomeButton = new JButton("Play");
        welcomeButton.setFont(Inter.getInterExtraBoldFont(20));
        welcomeButton.setBounds(INIT_WIDTH / 2 - 50, INIT_HEIGHT / 2 - 25, 100, 50);
        welcomeButton.setBackground(Color.decode("#03468F"));
        welcomeButton.setForeground(Color.WHITE);
        welcomeButton.setFocusable(false);
        welcomeButton.addActionListener(e -> {
            // Action for Play button
            JOptionPane.showMessageDialog(frame, "Game Starting...", "Info", JOptionPane.INFORMATION_MESSAGE);
            // Here you would typically start the game logic
        });
        welcomePanel.add(welcomeButton);

        // Login Panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, INIT_WIDTH, INIT_HEIGHT);
        loginPanel.setBackground(Color.decode("#05DBFC"));

        // Adding Panels to Frame
        frame.add(welcomePanel);
        frame.add(loginPanel);

        // Button Action Listeners
        welcomeButton.addActionListener(e -> {
            // Switch to login panel
            CardLayout layout = (CardLayout) frame.getLayout();
            layout.show(frame.getContentPane(), "LoginPanel");
        });

        CardLayout layout = (CardLayout) frame.getLayout();
        
        // Keep this below EVERY GUI line
        frame.setVisible(true);
    }
    
}
