package wish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page1 {
    private JLabel furnitureLabel;
    private JLabel SuggestedColors;
    private JComboBox<String> colorSelector;
    private JPanel colorBox1;
    private JPanel colorBox2;
    private Image backgroundImage;

    public page1() {
        // Load background image
        backgroundImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\backgroundimg1.png");

        // Create furniture label
        furnitureLabel = new JLabel("Furniture", SwingConstants.CENTER);
        furnitureLabel.setFont(new Font("Arial", Font.BOLD, 18));
        furnitureLabel.setForeground(Color.decode("#2B4A47"));

        // Create suggest colors label
        SuggestedColors = new JLabel("Suggested Colors", SwingConstants.CENTER);
        SuggestedColors.setFont(new Font("Arial", Font.BOLD, 18));
        SuggestedColors.setForeground(Color.decode("#2B4A47"));

        // Create color selector
        colorSelector = new JComboBox<>(new String[]{"Black", "Red", "Pink"});
        colorSelector.setBackground(Color.decode("#2B4A47"));
        colorSelector.setForeground(Color.decode("#F7AD3A"));
        colorSelector.setPreferredSize(new Dimension(150, 30));

        colorSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateColor();
            }
        });

        // Create color boxes
        colorBox1 = new JPanel();
        colorBox1.setBackground(Color.white);
        colorBox1.setPreferredSize(new Dimension(100, 100));

        colorBox2 = new JPanel();
        colorBox2.setBackground(Color.white);
        colorBox2.setPreferredSize(new Dimension(100, 100));

        // Create container and set background image
        JPanel container = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        container.setLayout(null);

        // Set component positions
        int furnitureLabelX = 50, furnitureLabelY = 200, furnitureLabelWidth = 150, furnitureLabelHeight = 45;
        int SuggestedColorsX = 400, SuggestedColorsY = 200, SuggestedColorsWidth = 250, SuggestedColorsHeight = 45;
        int colorSelectorX = 230, colorSelectorY = 210, colorSelectorWidth = 150, colorSelectorHeight = 30;
        int colorBox1X = 650, colorBox1Y = 210, colorBox1Width = 100, colorBox1Height = 100;
        int colorBox2X = 650, colorBox2Y = 330, colorBox2Width = 100, colorBox2Height = 100;

        furnitureLabel.setBounds(furnitureLabelX, furnitureLabelY, furnitureLabelWidth, furnitureLabelHeight);
        SuggestedColors.setBounds(SuggestedColorsX, SuggestedColorsY, SuggestedColorsWidth, SuggestedColorsHeight);
        colorSelector.setBounds(colorSelectorX, colorSelectorY, colorSelectorWidth, colorSelectorHeight);
        colorBox1.setBounds(colorBox1X, colorBox1Y, colorBox1Width, colorBox1Height);
        colorBox2.setBounds(colorBox2X, colorBox2Y, colorBox2Width, colorBox2Height);

        container.add(furnitureLabel);
        container.add(SuggestedColors);
        container.add(colorSelector);
        container.add(colorBox1);
        container.add(colorBox2);

        // Set initial color
        updateColor();

        // Create window
        int windowWidth = 900;
        int windowHeight = 600;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setContentPane(container);

        // Show window
        frame.setVisible(true);
    }

    private void updateColor() {String selectedColor = (String) colorSelector.getSelectedItem();
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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new page1();
            }
        });
    }
}