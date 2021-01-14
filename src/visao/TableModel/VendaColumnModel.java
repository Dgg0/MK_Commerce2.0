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
public class VendaColumnModel extends DefaultTableColumnModel{
    public VendaColumnModel(FontMetrics fm) {
       addColumn(criaColuna(0, 80, fm, false, "ID"));
       addColumn(criaColuna(1, 100, fm, true, "Cliente"));
       addColumn(criaColuna(2, 60, fm, true, "Tipo de Pagamento"));
       addColumn(criaColuna(3, 85, fm, false, "Data"));
    }
    
    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }
        
        TableColumn coluna = new TableColumn(columnIndex);
        coluna.setCellRenderer(new VendaCellRenderer());
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
