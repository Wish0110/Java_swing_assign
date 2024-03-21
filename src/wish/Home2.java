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
        // Load background image
        try {
            backgroundImage = ImageIO.read(new FileInputStream("C:\\Users\\Admin\\Downloads\\Group 1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        furnitureLabel = new JLabel("Ready to furnish your dream home? Let's get started!");
        furnitureLabel.setForeground(Color.decode("#ffffff"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));


        // Create layout
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 1, 10, 20);
        gbc.anchor = GridBagConstraints.WEST;

        // Add furnitureLabel to the middle-left corner
        gbc.gridy = 0;
        panel.add(furnitureLabel, gbc);


        // Create window
        int windowWidth = 900;
        int windowHeight = 600;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Add panel to the window
        frame.setContentPane(panel);

        // Show window
        frame.setVisible(true);

        // Set initial color
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Home2();
            }
        });
    }
}


