package softwere_com.miniproject1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Scrollable Table With Auto Resize Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 420);

            // Create a JTable with some data
            String[] columnNames = {"Column 1", "Column 2", "Column 3", "Column 4", "Column 5",
                    "Column 6", "Column 7", "Column 8", "Column 9", "Column 10"};
            String[][] data = new String[20][10]; // 20 rows, 10 columns for example
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(model);

            // Set auto resize mode for the JTable
            table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

            // Create a JScrollPane and add the JTable to it
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

            frame.add(scrollPane);
            frame.setVisible(true);
        });
    }
}