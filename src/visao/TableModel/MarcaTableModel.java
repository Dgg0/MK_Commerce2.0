package visao.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.entidade.Marca;

/**
 *
 * @author Diogo
 */
public class MarcaTableModel extends AbstractTableModel {
    private List<Marca> listaMarca;
    private String[] colunas = new String[]{"Id", "Nome"};
    
    public MarcaTableModel(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public MarcaTableModel(){
        this.listaMarca = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaMarca.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex){
      return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void setValueAt(Marca aValue, int rowIndex) {
        Marca marca = listaMarca.get(rowIndex);

        marca.setId(aValue.getId());
        marca.setNome(aValue.getNome());

        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      Marca marca = listaMarca.get(rowIndex);

        switch (columnIndex) {
            case 0:
                 marca.setId(Integer.parseInt(aValue.toString()));
                 break;
            case 1:
                 marca.setNome(aValue.toString());
                 break;
            default:
                 System.err.println("Índice da coluna inválido");
        }
    fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marca marcaSelecionada = listaMarca.get(rowIndex);
        String valueObject = null;
        switch(columnIndex){
            case 0:
                if (marcaSelecionada.getId() != null) {
                    valueObject = String.valueOf(marcaSelecionada.getId());
                } else {
                    valueObject = "";
                }
                break;
            case 1: 
                valueObject = marcaSelecionada.getNome();
                break;
            default: 
                System.err.println("Índice inválido para propriedade do bean Marca.class");
        }
        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Marca getMarca(int indiceLinha) {
        return listaMarca.get(indiceLinha);
    }

    public void addMarca(Marca marca) {
        listaMarca.add(marca);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }


    public void removeMarca(int indiceLinha) {
        listaMarca.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }


    public void addListaDeMarca(List<Marca> novasMarcas) {
        this.clear();
        int tamanhoAntigo = getRowCount();
        listaMarca.addAll(novasMarcas);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void clear() {
        listaMarca.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return listaMarca.isEmpty();
    }
}
