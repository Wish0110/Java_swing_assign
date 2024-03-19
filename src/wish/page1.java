package wish;

import javax.swing.*;
import java.awt.*;

public class page1 extends JFrame {

    private ImageIcon backgroundImageIcon;

    public page1() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        backgroundImageIcon = new ImageIcon("C:\\Users\\Admin\\Downloads\\wall color according furnitures - 12.png");

        // Create a custom panel to handle background painting
        this.setContentPane(new BackgroundPanel());

        //tittle text
        JLabel label = new JLabel();
        label.setText("Wall Color According to Furniture");
        label.setForeground(Color.decode("#F7AD3A"));
        label.setFont(new Font("Sans Serif", Font.BOLD, 30));
        label.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        // Pack and set size after setting content pane
        this.pack();
        this.add(label);
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