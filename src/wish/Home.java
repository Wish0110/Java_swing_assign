package wish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Home {
    private Image backgroundImage;

    public Home() {
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Admin\\Downloads\\Group 1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = ge.getMaximumWindowBounds();
        int windowWidth = bounds.width;
        int windowHeight = bounds.height;

        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setLayout(new BorderLayout());

        // Create the navigation bar
        JPanel navbar = new JPanel();
        navbar.setBackground(Color.DARK_GRAY);
        navbar.setPreferredSize(new Dimension(0, 50));

        JButton homeButton = new JButton("Home");
        JButton branchesButton = new JButton("Branches");
        JButton itemsButton = new JButton("Items");
        JButton employeeButton = new JButton("Employee");
        JButton customizeButton = new JButton("Customize");

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle home button click
            }
        });

        branchesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle branches button click
            }
        });

        itemsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle items button click
            }
        });

        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle employee button click
            }
        });

        customizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle customize button click
            }
        });

        navbar.add(homeButton);
        navbar.add(branchesButton);
        navbar.add(itemsButton);
        navbar.add(employeeButton);
        navbar.add(customizeButton);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(navbar, BorderLayout.NORTH);

        backgroundLabel.add(panel);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().add(backgroundLabel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Home();
            }
        });
    }
}