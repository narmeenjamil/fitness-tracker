import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class FitnessTrackerWithRanges extends JFrame {
    final Map<String, JCheckBox> parameterCheckboxes = new HashMap<>();

    public FitnessTrackerWithRanges() {
        try {
            setTitle("Welcome to OptiFit Pro Tracker");
            setSize(800, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Main Panel with Gradient Background
            JPanel mainPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    Color gradientStart = new Color(255, 153, 102);
                    Color gradientEnd = new Color(255, 94, 98);
                    GradientPaint gp = new GradientPaint(0, 0, gradientStart, 0, getHeight(), gradientEnd);
                    g2d.setPaint(gp);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            mainPanel.setLayout(null);
            add(mainPanel);

            // Header Label
            JLabel header = new JLabel("Welcome to OptiFit Pro Tracker", SwingConstants.CENTER);
            header.setFont(new Font("Segoe UI", Font.BOLD, 32));
            header.setForeground(Color.WHITE);
            header.setBounds(0, 50, 800, 50);
            mainPanel.add(header);

            // Start Button Panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBounds(250, 150, 300, 100);
            buttonPanel.setOpaque(false);
            buttonPanel.setLayout(new GridBagLayout());
            mainPanel.add(buttonPanel);

            JButton startButton = new JButton("START");
            startButton.setFont(new Font("Segoe UI", Font.BOLD, 22));
            startButton.setBackground(new Color(34, 139, 34));
            startButton.setForeground(Color.WHITE);
            startButton.setFocusPainted(false);
            startButton.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

            // Button Hover Effect
            startButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    startButton.setBackground(new Color(50, 205, 50));
                    startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    startButton.setBackground(new Color(34, 139, 34));
                }
            });

            startButton.addActionListener(e -> {
                try {
                    showFitnessForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "An error occurred while opening the fitness form.\n" + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });
            buttonPanel.add(startButton);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "An error occurred while initializing the main window.\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showFitnessForm() {
        JFrame inputFrame = new JFrame("Select Fitness Parameters");
        try {
            inputFrame.setSize(700, 800);
            inputFrame.setLocationRelativeTo(null);
            inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(11, 1, 10, 10)) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    Color gradientStart = new Color(255, 223, 186);
                    Color gradientEnd = new Color(255, 179, 71);
                    GradientPaint gp = new GradientPaint(0, 0, gradientStart, 0, getHeight(), gradientEnd);
                    g2d.setPaint(gp);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            inputFrame.add(panel);

            Font labelFont = new Font("Segoe UI", Font.BOLD, 16);

            String[] labels = {
                    "Walking Steps", "Water Intake (ml)", "Blood Pressure",
                    "Cholesterol", "Heart Rate", "Sleep Hours",
                    "Working Hours", "Sugar Level", "Body Weight (kg)", "ECG"
            };

            for (String label : labels) {
                JCheckBox checkbox = new JCheckBox(label);
                checkbox.setFont(labelFont);
                checkbox.setBackground(new Color(255, 250, 240));
                checkbox.setForeground(new Color(47, 79, 79));
                parameterCheckboxes.put(label, checkbox);
                panel.add(checkbox);
            }

            // Submit Button
            JButton submitButton = new JButton("Check Fitness");
            submitButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
            submitButton.setBackground(new Color(70, 130, 180));
            submitButton.setForeground(Color.WHITE);

            // Button Hover Effect
            submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    submitButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    submitButton.setBackground(new Color(70, 130, 180)); // Steel blue
                }
            });

            submitButton.addActionListener(e -> {
                try {
                    showDropdownWindow();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            inputFrame,
                            "An error occurred while opening the dropdown window.\n" + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });
            panel.add(submitButton);

            inputFrame.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "An error occurred while setting up the fitness form.\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showDropdownWindow() {
        JFrame dropdownFrame = new JFrame("Input Values for Selected Parameters");
        try {
            dropdownFrame.setSize(500, 600);
            dropdownFrame.setLocationRelativeTo(null);
            dropdownFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel dropdownPanel = new JPanel(new GridLayout(parameterCheckboxes.size() + 1, 2, 10, 10)) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    Color gradientStart = new Color(255, 239, 186);
                    Color gradientEnd = new Color(255, 204, 153);
                    GradientPaint gp = new GradientPaint(0, 0, gradientStart, 0, getHeight(), gradientEnd);
                    g2d.setPaint(gp);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            dropdownPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            dropdownFrame.add(dropdownPanel);

            Font labelFont = new Font("Segoe UI", Font.BOLD, 16);

            Map<String, JComboBox<String>> dropdownValues = new HashMap<>();

            for (Map.Entry<String, JCheckBox> entry : parameterCheckboxes.entrySet()) {
                if (entry.getValue().isSelected()) {
                    JLabel label = new JLabel(entry.getKey() + ":");
                    label.setFont(labelFont);
                    label.setForeground(new Color(102, 51, 0));

                    JComboBox<String> dropdown = new JComboBox<>();
                    switch (entry.getKey()) {
                        case "Walking Steps" -> {
                            for (int i = 0; i <= 10000; i += 1000) {
                                dropdown.addItem(i + " steps");
                            }
                        }
                        case "Water Intake (ml)" -> {
                            dropdown.addItem("Between 5-6 glasses");
                            dropdown.addItem("Between 7-12 glasses");
                            dropdown.addItem("More than 3 liter");
                        }
                        case "Sleep Hours" -> {
                            dropdown.addItem("Less than 5 hours");
                            dropdown.addItem("Between 6-10 hours");
                            dropdown.addItem("Greater than 10 hours");
                        }
                        case "Body Weight (kg)" -> {
                            dropdown.addItem("Between 40 - 50");
                            dropdown.addItem("Between 51 - 60");
                            dropdown.addItem("Between 61 - 70");
                            dropdown.addItem("Greater than 70");
                        }
                        default -> {
                            dropdown.addItem("Low");
                            dropdown.addItem("Medium");
                            dropdown.addItem("High");
                        }
                    }
                    dropdown.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    dropdown.setBackground(new Color(255, 250, 240));
                    dropdown.setForeground(new Color(47, 79, 79));

                    dropdownPanel.add(label);
                    dropdownPanel.add(dropdown);
                    dropdownValues.put(entry.getKey(), dropdown);
                }
            }

            JButton submitButton = new JButton("Submit");
            submitButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
            submitButton.setBackground(new Color(46, 139, 87));
            submitButton.setForeground(Color.WHITE);

            // Button Hover Effect
            submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    submitButton.setBackground(new Color(60, 179, 113));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    submitButton.setBackground(new Color(46, 139, 87));
                }
            });

            submitButton.addActionListener(e -> {
                try {
                    StringBuilder results = new StringBuilder("Health Assessment:\n\n");
                    boolean isFit = true;

                    // Analyze parameters and add suggestions
                    for (Map.Entry<String, JComboBox<String>> entry : dropdownValues.entrySet()) {
                        String key = entry.getKey();
                        String value = (String) entry.getValue().getSelectedItem();

                        results.append(key).append(": ").append(value);

                        switch (key) {
                            case "Walking Steps" -> {
                                if (value.contains("1000")) {
                                    results.append(" - Low activity. Increase daily steps to improve.\n");
                                    isFit = false;
                                } else {
                                    results.append(" - Good activity level.\n");
                                }
                            }
                            case "Water Intake (ml)" -> {
                                if (value.contains("5-6")) {
                                    results.append(" - Insufficient. Drink more water for hydration.\n");
                                    isFit = false;
                                } else {
                                    results.append(" - Adequate hydration level.\n");
                                }
                            }
                            case "Sleep Hours" -> {
                                if (value.contains("Less than 5 hours")) {
                                    results.append(" - Poor sleep. Aim for 6-8 hours daily.\n");
                                    isFit = false;
                                } else {
                                    results.append(" - Sufficient sleep.\n");
                                }
                            }
                            case "Body Weight (kg)" -> {
                                if (value.contains("Greater than 70") || value.contains("40 - 50")) {
                                    results.append(" - Weight outside the healthy range. Consult a nutritionist.\n");
                                    isFit = false;
                                } else {
                                    results.append(" - Healthy weight.\n");
                                }
                            }
                            default -> {
                                if (value.equals("Low")) {
                                    results.append(" - Below optimal. Consider consulting a doctor.\n");
                                    isFit = false;
                                } else {
                                    results.append(" - Normal.\n");
                                }
                            }
                        }
                    }

                    // Final assessment
                    if (isFit) {
                        results.append("\nOverall: You are physically and mentally fit. Keep maintaining a healthy lifestyle!");
                    } else {
                        results.append("\nOverall: Some parameters are not optimal. Follow the above suggestions for improvement.");
                    }

                    // Show the message dialog with the assessment
                    JOptionPane.showMessageDialog(
                            dropdownFrame,
                            results.toString(),
                            "Health Assessment Report",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            dropdownFrame,
                            "An error occurred while processing the results.\n" + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });
            dropdownPanel.add(new JLabel());
            dropdownPanel.add(submitButton);

            dropdownFrame.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "An error occurred while setting up the dropdown window.\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FitnessTrackerWithRanges frame = new FitnessTrackerWithRanges();
            frame.setVisible(true);
        });
    }

    public String assessHealth(String walkingSteps, String s) {
        return walkingSteps;

    }


}

