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

        // Using setBounds for component placement
        int windowWidth = 900;
        int windowHeight = 600;

        // Wall Color Label (Top, Left-aligned with padding)
        wallColorLabel = new JLabel("Wall Color According to Furniture");
        wallColorLabel.setForeground(Color.decode("#F7AD3A")); // Text color
        wallColorLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
        int wallColorLabelWidth = (int) wallColorLabel.getPreferredSize().getWidth();
        int wallColorLabelHeight = (int) wallColorLabel.getPreferredSize().getHeight();
        wallColorLabel.setBounds(10, 10, wallColorLabelWidth, wallColorLabelHeight);  // Adjust padding as needed

        // Furniture Label (Next row, Left-aligned)
        furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        int furnitureLabelWidth = (int) furnitureLabel.getPreferredSize().getWidth();
        int furnitureLabelHeight = (int) furnitureLabel.getPreferredSize().getHeight();
        furnitureLabel.setBounds(10, wallColorLabelHeight + 20, furnitureLabelWidth, furnitureLabelHeight);  // Adjust padding as needed

        // Combo Box (Next row, Left-aligned)
        int colorSelectorWidth = colorSelector.getPreferredSize().width;
        int colorSelectorHeight = colorSelector.getPreferredSize().height;
        colorSelector.setBounds(10, furnitureLabelHeight + 40, colorSelectorWidth, colorSelectorHeight);  // Adjust padding as needed

        // Color Box (Next row, Right-aligned)
        int colorBoxWidth = 50;  // Set desired width
        int colorBoxHeight = 50;  // Set desired height
        int xPos = windowWidth - colorBoxWidth - 10;  // Calculate x position for right alignment
        colorBox.setBounds(xPos, furnitureLabelHeight + 40, colorBoxWidth, colorBoxHeight);

        this.add(wallColorLabel);
        this.add(furnitureLabel);
        this.add(colorSelector);
        this.add(colorBox);

        this.pack();  // Not strictly necessary with setBounds
        this.setSize(windowWidth, windowHeight);
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
