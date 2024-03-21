package wish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class page1 {

    private JLabel furnitureLabel;
    private JComboBox<String> colorSelector;
    private Image backgroundImage;
    private JPanel colorBox1, colorBox2;

    public page1() {
        // Load background image
        try {
            backgroundImage = ImageIO.read(new FileInputStream("C:\\Users\\Admin\\Downloads\\wall color according furnitures - 12.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));

        String[] colors = {"Pick a color", "Black", "Red", "Pink"};
        colorSelector = new JComboBox<>(colors);
        colorSelector.setBackground(Color.decode("#2B4A47"));
        colorSelector.setForeground(Color.decode("#F7AD3A"));
        colorSelector.setPreferredSize(new Dimension(150, 30));

        colorSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateColor();
            }
        });

        colorBox1 = new JPanel();
        colorBox1.setBackground(Color.white);
        colorBox1.setPreferredSize(new Dimension(100, 100));

        colorBox2 = new JPanel();  // Create the second color box
        colorBox2.setBackground(Color.white);  // Set initial color (optional)
        colorBox2.setPreferredSize(new Dimension(100, 100));

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
        gbc.insets = new Insets(5, 20, 10, 20);
        gbc.anchor = GridBagConstraints.WEST;

        // Add furnitureLabel to the middle-left corner
        gbc.gridy = 1;
        panel.add(furnitureLabel, gbc);

        // Add colorSelector to the middle-center corner
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(colorSelector, gbc);

        // Add text label "Suggested Colors"
        JLabel suggestedColorsLabel = new JLabel("Suggested Colors");
        suggestedColorsLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        suggestedColorsLabel.setForeground(Color.decode("#2B4A47"));
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(suggestedColorsLabel, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        panel.add(colorBox1, gbc);

        gbc.gridy = 2;
        panel.add(colorBox2, gbc);

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
        updateColor();
    }

    private void updateColor() {
        String selectedColor = (String) colorSelector.getSelectedItem();
        Color color = Color.white;
        switch (selectedColor) {
            case "Black":
                color = Color.white;
                break;
            case "Red":
                color = Color.lightGray;
                break;
            case "Pink":
                color = Color.black;
                break;
        }
        colorBox1.setBackground(color);

        selectedColor = (String) colorSelector.getSelectedItem();
        color = Color.white;
        switch (selectedColor) {
            case "Black":
                color = Color.yellow;
                break;
            case "Red":
                color = Color.lightGray;
                break;
            case "Pink":
                color = Color.blue;
                break;
        }
        colorBox2.setBackground(color);
    }
}
