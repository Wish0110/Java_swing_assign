package wish;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Home {
    private Image backgroundImage;

    public Home() {
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Admin\\Downloads\\Group 1.png")).getScaledInstance(
                    GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width,
                    GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height,
                    Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setLayout(new BorderLayout());

        // Create the navigation bar
        JPanel navbar = new JPanel();
        navbar.setBackground(new Color(43, 74, 71)); // Set navbar background color to "#2B4A47"
        navbar.setPreferredSize(new Dimension(0, 50));
        navbar.setBorder(new EmptyBorder(20, 0, 0, 0)); // Add top margin of 20 pixels

        JButton homeButton = new JButton("Home");
        homeButton.setBackground(Color.decode("#2B4A47"));
        homeButton.setBorder(BorderFactory.createLineBorder(Color.decode("#F7AD3A")));

        JButton branchesButton = new JButton("Branches");
        branchesButton.setBackground(Color.decode("#2B4A47"));

        JButton itemsButton = new JButton("Items");
        itemsButton.setBackground(Color.decode("#2B4A47"));

        JButton employeeButton = new JButton("Employee");
        employeeButton.setBackground(Color.decode("#2B4A47"));

        JButton customizeButton = new JButton("Customize");
        customizeButton.setBackground(Color.decode("#2B4A47"));

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

        // Set text color of the buttons to yellow
        homeButton.setForeground(Color.YELLOW);
        branchesButton.setForeground(Color.white);
        itemsButton.setForeground(Color.white);
        employeeButton.setForeground(Color.white);
        customizeButton.setForeground(Color.white);

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