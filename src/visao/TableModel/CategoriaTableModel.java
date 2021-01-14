package visao.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.entidade.Categoria;

/**
 *
 * @author Diogo
 */
public class CategoriaTableModel extends AbstractTableModel {
    private List<Categoria> listaCategoria;
    private String[] colunas = new String[]{"ID", "Nome"};
    
    public CategoriaTableModel(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    public CategoriaTableModel() {
        this.listaCategoria = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaCategoria.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    public void setValueAt(Categoria aValue, int rowIndex) {
        Categoria categoria = listaCategoria.get(rowIndex);
        
        categoria.setId(aValue.getId());
        categoria.setNome(aValue.getNome());
        
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
    }
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Categoria categoria = listaCategoria.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                categoria.setId(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                categoria.setNome(aValue.toString());
                break;
            default:
                System.err.println("Indice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria categoriaSelecionada = listaCategoria.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                if (categoriaSelecionada.getId() != null) {
                    valueObject = String.valueOf(categoriaSelecionada.getId());
                } else {
                    valueObject = "";
                }
                break;
            case 1:
                valueObject = categoriaSelecionada.getNome();
                break;
            default:
                System.err.println("Índice inválido para propriedade do bean Categoria.class");
        }
        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Categoria getCategoria(int rowIndex) {
        return listaCategoria.get(rowIndex);
    }
    
    public void addCategoria(Categoria categoria) {
        this.listaCategoria.add(categoria);
        int ultimoIndice = getRowCount() - 1;       
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void removeCategoria(int rowIndex) {
        this.listaCategoria.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void addListaDeCategoria(List<Categoria> novaCategoria) {
        this.clear();
        int tamangoAntigo = getRowCount();
        this.listaCategoria.addAll(novaCategoria);
        
        fireTableRowsInserted(tamangoAntigo, getRowCount() - 1);
    }
    
    public void clear() {
        this.listaCategoria.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty() {
        return this.listaCategoria.isEmpty();
    }
    
    
    
}
