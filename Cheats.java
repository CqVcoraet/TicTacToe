// Imported Packages
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Cheats extends JFrame {
    private static Cheats instance;
    private JTextPane textPane;
    private static boolean isVisible;
    private static StyledDocument doc;
    private static Style defaultStyle, warningStyle, errorStyle;
    static int lineNum = 0;
    static final String WARN_PRINTLN_COLOR = "#FFC900";
    static final String ERR_PRINTLN_COLOR = "#D40000";

    // Singleton to ensure one instance
    public static Cheats getInstance() {
        if (instance == null) {
            instance = new Cheats("Cheat Console");
        }
        return instance;
    }

    private Cheats(String title) {
        super(title);
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBackground(Color.BLACK);
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 14));

        doc = textPane.getStyledDocument();
        defaultStyle = textPane.addStyle("default", null);
        StyleConstants.setForeground(defaultStyle, Color.WHITE);

        warningStyle = textPane.addStyle("warning", null);
        StyleConstants.setForeground(warningStyle, Color.decode("#FFC900"));

        errorStyle = textPane.addStyle("error", null);
        StyleConstants.setForeground(errorStyle, Color.decode("#D40000"));

        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);

        // Set the location of the frame to the upper right corner
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width - getWidth();
        int y = 0;
        setLocation(x, y);
        setVisible(false);
    }

    public static void print(Object text) {
        try {
            getInstance().appendText(lineNum + "    " + String.valueOf(text), defaultStyle);
            lineNum++;
        } catch (Exception e) {
            Console.errprintln("Error: " + e.getMessage());
            Console.errprintln("Error Stack Trace: " + e.getStackTrace());
        }
    }

    public static void warnprint(Object text) {
        getInstance().appendText(lineNum + "    " + String.valueOf(text), warningStyle);
        lineNum++;
    }

    public static void errprint(Object text) {
        getInstance().appendText(lineNum + "    " + String.valueOf(text), errorStyle);
        lineNum++;
    }
    
    public static void println(Object text) {
        try {
            getInstance().appendText(lineNum + "    " + String.valueOf(text) + "\n", defaultStyle);
            lineNum++;
        } catch (Exception e) {
            Console.errprintln("Error: " + e.getMessage());
            Console.errprintln("Error Stack Trace: " + e.getStackTrace());
        }
    }

    public static void warnprintln(Object text) {
        getInstance().appendText(lineNum + "    " + String.valueOf(text) + "\n", warningStyle);
        lineNum++;
    }
    
    public static void errprintln(Object text) {
        getInstance().appendText(lineNum + "    " + String.valueOf(text) + "\n", errorStyle);
        lineNum++;
    }

    public static void spacer() {
        getInstance().appendText("\n", defaultStyle);
    }

    private void appendText(String text, Style style) {
        SwingUtilities.invokeLater(() -> {
            try {
                doc.insertString(doc.getLength(), text, style);
                textPane.setCaretPosition(doc.getLength());
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        });
    }

    public static void toggleVisibility() {
        Cheats cheatConsole = getInstance(); // Ensure the instance exists
        isVisible = !isVisible;
        cheatConsole.setVisible(isVisible);
    }
}
