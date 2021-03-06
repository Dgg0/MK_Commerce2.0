/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ListaVendaCellRenderer extends DefaultTableCellRenderer{
    public ListaVendaCellRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        Color corFundoZebrado = new Color(176, 196, 222);
        Color corFundoNormal = new Color(255, 255, 230);
        
        label.setFont(new java.awt.Font("Tahoma", 0, 12));
        
        if ((row % 2) == 0) {
            label.setBackground(corFundoNormal);
        } else {
            label.setBackground(corFundoZebrado);
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
