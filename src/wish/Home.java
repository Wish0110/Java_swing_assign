package wish;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Home {

    public Home() {
        // Load the background image
        BufferedImage backgroundImage;
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/path/to/your/image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }

        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setLayout(new BorderLayout());

        // Create the navigation bar
        JPanel navbar = new JPanel();
        navbar.setBackground(new Color(43,74, 71));
        navbar.setPreferredSize(new Dimension(0, 50));
        navbar.setBorder(new EmptyBorder(20, 0, 0, 0));

        // Create the buttons and add padding to them
        JButton homeButton = new JButton("Home");
        homeButton.setBackground(new Color(43, 74, 71));
        homeButton.setBorder(BorderFactory.createCompoundBorder(
                homeButton.getBorder(),
                new EmptyBorder(10, 10, 10, 10)));

        JButton branchesButton = new JButton("Branches");
        branchesButton.setBackground(new Color(43, 74, 71));
        branchesButton.setBorder(BorderFactory.createCompoundBorder(
                branchesButton.getBorder(),
                new EmptyBorder(10, 10, 10, 10)));

        JButton itemsButton = new JButton("Items");
        itemsButton.setBackground(new Color(43, 74, 71));
        itemsButton.setBorder(BorderFactory.createCompoundBorder(
                itemsButton.getBorder(),
                new EmptyBorder(10, 10, 10, 10)));

        JButton employeeButton = new JButton("Employee");
        employeeButton.setBackground(new Color(43, 74, 71));
        employeeButton.setBorder(BorderFactory.createCompoundBorder(
                employeeButton.getBorder(),
                new EmptyBorder(10, 10, 10, 10)));

        JButton customizeButton = new JButton("Customize");
        customizeButton.setBackground(new Color(43, 74, 71));
        customizeButton.setBorder(BorderFactory.createCompoundBorder(
                customizeButton.getBorder(),
                new EmptyBorder(10, 10, 10, 10)));

        // Add action listeners to the buttons
        homeButton.addActionListener(e ->{
            // Handle home button click
        });

        branchesButton.addActionListener(e -> {
            // Handle branches button click
        });

        itemsButton.addActionListener(e -> {
            // Handle items button click
        });

        employeeButton.addActionListener(e -> {
            // Handle employee button click
        });

        customizeButton.addActionListener(e -> {
            // Handle customize button click
        });

        // Set text color of the buttons to yellow
        homeButton.setForeground(Color.YELLOW);
        branchesButton.setForeground(Color.white);
        itemsButton.setForeground(Color.white);
        employeeButton.setForeground(Color.white);
        customizeButton.setForeground(Color.white);

        // Add the buttons to the navbar
        navbar.add(homeButton);
        navbar.add(Box.createHorizontalStrut(20));
        navbar.add(branchesButton);
        navbar.add(Box.createHorizontalStrut(20));
        navbar.add(itemsButton);
        navbar.add(Box.createHorizontalStrut(20));
        navbar.add(employeeButton);
        navbar.add(Box.createHorizontalStrut(20));
        navbar.add(customizeButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navbar, BorderLayout.NORTH);
        mainPanel.add(backgroundLabel, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(backgroundLabel.getPreferredSize().width, backgroundLabel.getPreferredSize().height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().add(mainPanel);
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