package wish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Home2 {

    private Image backgroundImage;

    public Home2() {
        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Load background image (assuming image is less than screen size)
        try {
            backgroundImage = ImageIO.read(new FileInputStream("C:\\Users\\Admin\\Downloads\\Group 1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create buttons
        JButton homeButton = new JButton("Home");
        JButton branchesButton = new JButton("Branches");
        JButton itemsButton = new JButton("Items");
        JButton employeeButton = new JButton("Employee");
        JButton customizeButton = new JButton("Customize");

        // Create button panel with horizontal layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(0, 0, 0, 0)); // Transparent background

        buttonPanel.add(homeButton);
        buttonPanel.add(Box.createHorizontalStrut(20)); // Add spacing between buttons
        buttonPanel.add(branchesButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(itemsButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(employeeButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(customizeButton);

        // Create main panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Add button panel to the top of the main panel
        panel.add(buttonPanel, BorderLayout.NORTH);

        // Create window and set size to screen size
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Add main panel to the window
        frame.setContentPane(panel);

        // Show window
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Home2();
            }
        });
    }
}


