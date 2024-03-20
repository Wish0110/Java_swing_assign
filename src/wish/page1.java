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
    private JPanel colorBox;
    private Image backgroundImage;

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

        String[] colors = {"Black", "Red", "Pink"};
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

        colorBox = new JPanel();
        colorBox.setBackground(Color.white);
        colorBox.setPreferredSize(new Dimension(100, 100));

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
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(suggestedColorsLabel, gbc);

        // Add colorBox to the middle-right corner
        gbc.gridx = 4;
        gbc.gridy = 1;
        panel.add(colorBox, gbc);

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
