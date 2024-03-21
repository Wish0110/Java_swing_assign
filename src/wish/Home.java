package wish;

import javax.imageio.ImageIO;
import javax.swing.*;
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
        navbar.setOpaque(false); // Set navbar background transparent
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

        // Set text color of the buttons to yellow
        homeButton.setForeground(Color.YELLOW);
        branchesButton.setForeground(Color.YELLOW);
        itemsButton.setForeground(Color.YELLOW);
        employeeButton.setForeground(Color.YELLOW);
        customizeButton.setForeground(Color.YELLOW);

        navbar.add(homeButton);
        navbar.add(branchesButton);
        navbar.add(itemsButton);
        navbar.add(employeeButton);
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