package wish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page1 extends JFrame implements ActionListener {

    private ImageIcon backgroundImageIcon;
    private JComboBox<String> furnitureComboBox;
    private JPanel whiteBox;
    private JButton submitButton;

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

        String[] furnitureOptions = {"Select...", "Brown", "Black", "White"};
        furnitureComboBox = new JComboBox<>(furnitureOptions);
        furnitureComboBox.setPreferredSize(new Dimension(150, 25));

        furnitureComboBox.addActionListener(this);

        // Use FlowLayout for easier component arrangement
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add components
        this.add(furnitureLabel);
        this.add(furnitureComboBox);

        // Create a new JPanel with a white background
        whiteBox = new JPanel();
        whiteBox.setBackground(Color.WHITE);
        whiteBox.setPreferredSize(new Dimension(50, 50));
        this.add(whiteBox);

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.red);
        submitButton.addActionListener(this);

        this.add(submitButton);

        this.pack();
        this.setSize(900, 600);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == furnitureComboBox) {
            // Handle furniture selection
            if (furnitureComboBox.getSelectedItem().equals("Black")) {
                whiteBox.setBackground(Color.BLACK);
            } else {
                whiteBox.setBackground(Color.WHITE);
            }
        }
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
