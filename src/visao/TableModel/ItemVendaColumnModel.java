/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.TableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Diogo
 */
public class ItemVendaColumnModel extends DefaultTableColumnModel{
    public ItemVendaColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 70, fm, false, "ID Venda"));
        addColumn(criaColuna(1, 80, fm, true, "Produto"));
        addColumn(criaColuna(2, 80, fm, false, "Quantidade"));
        addColumn(criaColuna(3, 100, fm, false, "Valor Unitário"));
    }
    
    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if(largura < larguraTitulo) {
            largura = larguraTitulo;
        }
        
        TableColumn coluna = new TableColumn(columnIndex);
        coluna.setCellRenderer(new ItemVendaCellRenderer());
        coluna.setHeaderRenderer(null);
        coluna.setHeaderValue(titulo);
        coluna.setPreferredWidth(largura);
        
        if (!resizable) {
            coluna.setMaxWidth(largura);
            coluna.setMinWidth(largura);
        }
        coluna.setResizable(resizable);
        
        return coluna;
    }
}
