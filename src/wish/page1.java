package wish;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class page1 extends JFrame implements ActionListener {

    private ImageIcon backgroundImageIcon;
    private JComboBox<String> furnitureComboBox;

    public page1() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        backgroundImageIcon = new ImageIcon("C:\\Users\\Admin\\Downloads\\wall color according furnitures - 12.png");

        // Create a custom panel to handle background painting
        this.setContentPane(new BackgroundPanel());

        // Furniture Color label text
        JLabel furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        furnitureLabel.setBounds(70, 150, 150, 20); // Set bounds for absolute positioning

        String[] furnitureOptions = {"Select...", "Brown", "Black", "White"};
        furnitureComboBox = new JComboBox<>(furnitureOptions);
        furnitureComboBox.setPreferredSize(new Dimension(150, 25));

        // Remove layout manager
        this.setLayout(null);

        // Furniture ComboBox (without transparent frame)
        furnitureComboBox.setBounds(230, 150, 150, 25); // Set bounds for absolute positioning

        // Create a new JPanel with a white background
        JPanel whiteBox = new JPanel();
        whiteBox.setBackground(Color.WHITE);
        whiteBox.setBounds(200, 50, 50, 50); // Set bounds for absolute positioning

        // Add components directly to the frame
        //this.add(titleLabel);
        this.add(furnitureLabel);
        this.add(furnitureComboBox);
        this.add(whiteBox); // Add the white box to the frame

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