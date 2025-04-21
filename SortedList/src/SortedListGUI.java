import javax.swing.*;
import java.awt.*;

public class SortedListGUI extends JFrame {
    private JTextField inputField, searchField;
    private JTextArea displayArea;
    private SortedList sortedList;

    public SortedListGUI() {
        sortedList = new SortedList();
        setTitle("Sorted Array List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        JButton addButton = new JButton("Add String");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter String:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search String:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(inputPanel, BorderLayout.NORTH);
        add(searchPanel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String text = inputField.getText();
            sortedList.add(text);
            updateDisplay();
            inputField.setText("");
        });

        searchButton.addActionListener(e -> {
            String key = searchField.getText();
            int result = sortedList.binarySearch(key);
            if (result >= 0) {
                displayArea.append("\nFound: " + key + " at index " + result);
            } else {
                int insertionPoint = -result - 1;
                displayArea.append("\nNot found. Would be inserted at index: " + insertionPoint);
            }
            searchField.setText("");
        });
    }

    private void updateDisplay() {
        displayArea.setText("Sorted List:\n" + sortedList.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortedListGUI().setVisible(true));
    }
}
