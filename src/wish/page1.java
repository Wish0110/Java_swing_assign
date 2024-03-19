package wish;

import javax.swing.*;
import java.awt.*;

public class page1 extends JFrame {

    private ImageIcon backgroundImageIcon;
    private JComboBox<String> furnitureComboBox;

    public page1() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        backgroundImageIcon = new ImageIcon("C:\\Users\\Admin\\Downloads\\wall color according furnitures - 12.png");

        // Create a custom panel to handle background painting
        this.setContentPane(new BackgroundPanel());

        //tittle text
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Wall Color According to Furniture");
        titleLabel.setForeground(Color.decode("#F7AD3A"));
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        // Furniture Color label text
        JLabel furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        furnitureLabel.setBorder(BorderFactory.createEmptyBorder(0, 70, 150, 0));

        // Use a layout manager for positioning
        this.setLayout(new BorderLayout());

        // Add labels to appropriate positions
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(furnitureLabel, BorderLayout.WEST);
        // Pack and set size after setting content pane
        this.pack();

        this.setSize(900, 600);
        this.setVisible(true);
    }

    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the background image
            if (backgroundImageIcon != null) {
                g.drawImage(backgroundImageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        }
    }
}