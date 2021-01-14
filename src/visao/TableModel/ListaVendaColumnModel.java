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
public class ListaVendaColumnModel extends DefaultTableColumnModel {
    
    public ListaVendaColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 30, fm, true, "Código"));
        addColumn(criaColuna(1, 90, fm, true, "Nome"));
        addColumn(criaColuna(2, 50, fm, true, "Marca"));
        addColumn(criaColuna(3, 50, fm, true, "Categoria"));
        addColumn(criaColuna(4, 100, fm, false, "Valor Unitário"));
        addColumn(criaColuna(5, 100, fm, false, "Quantidade"));
        addColumn(criaColuna(6, 80, fm, false, "Valor Total"));
    }
    
    public TableColumn criaColuna(int rowIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if (larguraTitulo > largura) {
            largura = larguraTitulo;
        }
        
        TableColumn coluna = new TableColumn(rowIndex);
        coluna.setCellRenderer(new ListaVendaCellRenderer());
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
