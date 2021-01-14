package visao.TableModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Diogo
 */
public class ClienteCellRenderer extends DefaultTableCellRenderer {
    public ClienteCellRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        Color FundoCorZebrado = new Color(176, 196, 222);
        Color FundoCorNormal = new Color(255, 255, 230);
        
        switch (row % 2) {
            case 0:
                label.setBackground(FundoCorNormal);
                break;
            case 1:
                label.setBackground(FundoCorZebrado);
                break;
        }
        
        if (isSelected) {
            label.setBackground(new Color(65, 105, 255));
        }
        
        switch (column) {
            default:
                label.setHorizontalAlignment(LEFT);
        }
        return label;
    }
}
