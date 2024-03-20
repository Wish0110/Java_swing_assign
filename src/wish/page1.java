package wish;
import javax.swing.*;
import java.awt.*;

public class page1 {

    private JLabel wallColorLabel;
    private JLabel furnitureLabel;
    private JComboBox<String> colorSelector;
    private JPanel colorBox;

    public page1() {
        // Create components
        wallColorLabel = new JLabel("Wall Color According to Furniture");
        wallColorLabel.setForeground(Color.decode("#F7AD3A"));
        wallColorLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));

        furnitureLabel = new JLabel("Furniture Color");
        furnitureLabel.setForeground(Color.decode("#2B4A47"));
        furnitureLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));

        String[] colors = {"Black", "Red", "Pink"};
        colorSelector = new JComboBox<>(colors);
        colorSelector.addActionListener(e -> updateColor());

        colorBox = new JPanel();
        colorBox.setBackground(Color.white);
        colorBox.setPreferredSize(new Dimension(100, 100));

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 10, 20);
        gbc.anchor = GridBagConstraints.WEST;

        // Add wallColorLabel to the top-left corner
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(wallColorLabel, gbc);

        // Add furnitureLabel to the middle-left corner
        gbc.gridy = 1;
        panel.add(furnitureLabel, gbc);

        // Add colorSelector to the middle-center corner
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(colorSelector, gbc);

        // Add colorBox to the middle-right corner
        gbc.gridx = 2;
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
        frame.add(panel, BorderLayout.CENTER);

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

