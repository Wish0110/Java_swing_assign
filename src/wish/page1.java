package wish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page1 extends JFrame {

    private ImageIcon backgroundImageIcon;


    public page1() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        backgroundImageIcon = new ImageIcon("C:\\Users\\Admin\\Downloads\\backgroundimg1.png");

        // Create a custom panel to handle background painting
        this.setContentPane(new BackgroundPanel());

        // Furniture Color label text
        JLabel furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        furnitureLabel.setBounds(70, 150, 150, 20); // Set bounds for absolute positioning

       // Set bounds for absolute positioning

        // Add components directly to the frame
        this.add(furnitureLabel);

        // Call revalidate() and repaint() to update the layout and size of the frame
        this.revalidate();
        this.repaint();


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