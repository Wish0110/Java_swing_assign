package wish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

public class page1 extends JFrame {

    private ImageIcon backgroundImageIcon;
    private JPanel colorBox;
    private JComboBox<String> colorSelector;
    private JLabel furnitureLabel, wallColorLabel;

    public page1() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            backgroundImageIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\Downloads\\backgroundimg1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create the custom panel for background painting
        this.setContentPane(new BackgroundPanel());

        // Create the color box and selector
        colorBox = new JPanel();
        colorBox.setPreferredSize(new Dimension(50, 50));  // Set desired size (width, height)
        colorBox.setBackground(Color.red);  // Set initial background color (optional)

        colorSelector = new JComboBox<>(new String[]{"Black", "Red", "Pink"});
        colorSelector.setPreferredSize(new Dimension(200, 30));
        colorSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateColor();
            }
        });


        // Create a horizontal layout manager
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        // Separate GridBagConstraints objects with individual insets
        GridBagConstraints gbcWallColorLabel = new GridBagConstraints();
        gbcWallColorLabel.insets = new Insets(0, 120, 250, 0);  // Margin for wallColorLabel

        GridBagConstraints gbcFurnitureLabel = new GridBagConstraints();
        gbcFurnitureLabel.insets = new Insets(55, 20, 10, 20);  // Margin for furnitureLabel

        GridBagConstraints gbcColorSelector = new GridBagConstraints();
        gbcColorSelector.insets = new Insets(0, 20, 10, 50);  // Margin for colorSelector

        // **Wall Color Label (Top, Left-aligned with padding)**
        wallColorLabel = new JLabel("Wall Color According to Furniture");
        wallColorLabel.setForeground(Color.decode("#F7AD3A")); // Text color
        wallColorLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
        gbcWallColorLabel.gridx = 0;  // Leftmost column
        gbcWallColorLabel.gridy = 0;  // Top row
        gbcWallColorLabel.anchor = GridBagConstraints.WEST;  // Left-aligned
        this.add(wallColorLabel, gbcWallColorLabel);

        // **Furniture Label (Next row, Left-aligned)**
        furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        gbcFurnitureLabel.gridy = 1;  // Next row
        this.add(furnitureLabel, gbcFurnitureLabel);

        // **Combo Box (Next row, Left-aligned)**
        gbcColorSelector.gridy = 2;
        this.add(colorSelector, gbcColorSelector);
        // **Color Box (Next row, Right-aligned)**
        gbcColorSelector.fill = GridBagConstraints.NONE;  // Don't fill horizontally (use a separate gbc for colorBox)
        gbcColorSelector.gridx = 1;  // Move to the second column (right side)
        gbcColorSelector.weightx = 0.0;  // No extra space allocation
        gbcColorSelector.anchor = GridBagConstraints.EAST;  // Right-aligned
        this.add(colorBox, gbcColorSelector);

        this.pack();
        this.setSize(900, 600);
        this.setVisible(true);
    }

    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImageIcon != null) {
                g.drawImage(backgroundImageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        }
    }

    private void updateColor() {
        String selectedColor = (String) colorSelector.getSelectedItem();
        Color color = Color.white; // Default color
        switch (selectedColor) {
            case "Black":
                color = Color.black;
                break;
            case "Red":
                color = Color.RED;
                break;
            case "Pink":
                color = Color.PINK;
                break;
        }
        colorBox.setBackground(color);
    }
}
