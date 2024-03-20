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
        gbc.anchor = GridBagConstraints.CENTER;

        wallColorLabel = new JLabel("Wall Color According to Furniture");
        wallColorLabel.setForeground(Color.decode("#F7AD3A")); // Text color
        wallColorLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;  // Center horizontally
        gbc.insets = new Insets(0, 0, 400, 0);  // Top inset of 100px
        this.add(wallColorLabel, gbc);

        // Add spacing between labels (adjust as needed)
        gbc.insets = new Insets(10, 0, 10, 0);

        furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));

        gbc.gridx = 0;  // Add label to the first column (left)
        gbc.gridy = 0;
        this.add(furnitureLabel, gbc);

        // Add spacing between label and combobox (adjust as needed)
        gbc.insets = new Insets(0, 10, 0, 0);

        gbc.gridx = 1;  // Add combobox to the second column (right)
        this.add(colorSelector, gbc);

        gbc.insets = new Insets(0, 200, 0, 0);  // Reset insets for combobox spacing

        gbc.gridx = 2;  // Add color box to the third column (optional)
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
