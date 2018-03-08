package F;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.event.ListSelectionEvent;

public class RowVerifierTableTest {

    public void makeUI() {
        int rows = 30;
        int columns = 5;
        final JTable table = new RowVerifierTable(rows, columns);
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                table.setValueAt(row + 100 * column, row, column);
            }
        }

        final JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class RowVerifierTable extends JTable {

    boolean rowSelectionAdjusting2;
    int selectedRow = -1;

    RowVerifierTable(int rows, int columns) {
        super(rows, columns);
        setSelectionMode(SINGLE_SELECTION);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int approve = YES_OPTION;
        if (!e.getValueIsAdjusting()) {
            if (selectedRow != -1) {
                approve = showConfirmDialog(null,
                        "Change row selection?", "Confirm", YES_NO_OPTION);
            }

            if (approve == YES_OPTION) {
                super.valueChanged(e);
            } else {
                getSelectionModel().removeListSelectionListener(this);
                getSelectionModel().clearSelection();
                setRowSelectionInterval(selectedRow, selectedRow);
                getSelectionModel().addListSelectionListener(this);
                scrollRectToVisible(getCellRect(selectedRow, 0, true));
                repaint();
            }
            selectedRow = getSelectedRow();
        }
    }
}
