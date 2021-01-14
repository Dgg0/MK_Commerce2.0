package visao.TableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Diogo
 */
public class CategoriaColumnModel extends DefaultTableColumnModel{
    public CategoriaColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 30, fm, false, "ID"));
        addColumn(criaColuna(1, 100, fm, true, "Nome"));
    }
    
    public TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }
        
        TableColumn coluna = new TableColumn(columnIndex);
        coluna.setCellRenderer(new CategoriaCellRenderer());
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
