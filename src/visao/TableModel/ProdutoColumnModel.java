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
public class ProdutoColumnModel extends DefaultTableColumnModel {
    public ProdutoColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 80, fm, false, "ID"));
        addColumn(criaColuna(1, 100, fm, false, "Código"));
        addColumn(criaColuna(2, 150, fm, true, "Nome"));
        addColumn(criaColuna(3, 70, fm, true, "Marca"));
        addColumn(criaColuna(4, 70, fm, true, "Categoria"));
        addColumn(criaColuna(5, 50, fm, true, "Preço"));
        addColumn(criaColuna(6, 50, fm, true, "Estoque"));
        addColumn(criaColuna(7, 50, fm, true, "Estoque Minimo"));
    }
    
    public TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean Resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }
        
        TableColumn coluna = new TableColumn(columnIndex);
        coluna.setCellRenderer(new ProdutoCellRenderer());
        coluna.setHeaderRenderer(null);
        coluna.setHeaderValue(titulo);
        coluna.setPreferredWidth(largura);
        
        if (!Resizable) {
            coluna.setMaxWidth(largura);
            coluna.setMinWidth(largura);
        }
        coluna.setResizable(Resizable);
        return coluna;
    }
}
