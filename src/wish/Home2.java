package wish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Home2 {

    private JLabel furnitureLabel;
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

        furnitureLabel = new JLabel("Ready to furnish your dream home? Let's get started!");
        furnitureLabel.setForeground(Color.decode("#ffffff"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));

        // Create layout
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(new BorderLayout());

        // Create navigation bar
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        navBar.setBackground(new Color(0x00204D, true));

        JButton homeButton = new JButton("Home");
        JButton branchesButton = new JButton("Branches");
        JButton itemsButton = new JButton("Items");
        JButton employeeButton = new JButton("Employee");
        JButton customizeButton = new JButton("Customize");

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Home button action
            }
        });

        branchesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Branches button action
            }
        });

        itemsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Items button action
            }
        });

        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Employee button action
            }
        });

        customizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Customize button action
            }
        });

        navBar.add(homeButton);
        navBar.add(branchesButton);
        navBar.add(itemsButton);
        navBar.add(employeeButton);
        navBar.add(customizeButton);

        panel.add(navBar, BorderLayout.NORTH);
        panel.add(furnitureLabel, BorderLayout.CENTER);

        // Create window and set size to screen size
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Add panel to the window
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