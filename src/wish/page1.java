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
        colorBox.setPreferredSize(new Dimension(100, 100));

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
        GridBagConstraints gbc = new GridBagConstraints();

        // Center components horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // **Wall Color Label (Top, Centered)**
        wallColorLabel = new JLabel("Wall Color According to Furniture");
        wallColorLabel.setForeground(Color.decode("#F7AD3A")); // Text color
        wallColorLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        gbc.gridx = 0;  // Leftmost column
        gbc.gridy = 0;  // Top row
        gbc.anchor = GridBagConstraints.CENTER;  // Center horizontally
        gbc.insets = new Insets(100, 250, 10, 0);  // Top inset of 100px, adjust horizontal padding if needed
        this.add(wallColorLabel, gbc);

        // **Furniture Label (Next Row, Left-aligned)**
        furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        gbc.gridy = 1;  // Next row after wallColorLabel
        gbc.anchor = GridBagConstraints.WEST;  // Left-aligned (default)
        gbc.insets = new Insets(10, 0, 10, 0);  // Adjust spacing between labels if needed
        this.add(furnitureLabel, gbc);

        // **Combo Box (Next Row, Right-aligned)**
        gbc.gridy = 2;  // Next row after furnitureLabel
        this.add(colorSelector, gbc);

        // **Color Box (Next Row, Optional)**
        gbc.gridy = 3;  // Next row
        this.add(colorBox, gbc);

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
