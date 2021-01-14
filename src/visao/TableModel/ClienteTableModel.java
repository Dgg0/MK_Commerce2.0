/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.TableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.entidade.Cliente;


/**
 *
 * @author Diogo
 */
public class ClienteTableModel extends AbstractTableModel {
    private List<Cliente> listaCliente;
    private String[] colunas = new String[]{"ID", "Nome", "CPF", "Fone", "Endereço"};
    
    
    public ClienteTableModel(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    public ClienteTableModel() {
        this.listaCliente = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaCliente.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    public void setValueAt(Cliente aValue, int rowIndex){
        Cliente cliente = listaCliente.get(rowIndex);
        
        cliente.setId(aValue.getId());
        cliente.setNome(aValue.getNome());
        cliente.setCpf(aValue.getCpf());
        cliente.setTelefone(aValue.getTelefone());
        cliente.setEndereco(aValue.getEndereco());
        
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente cliente = listaCliente.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                cliente.setId(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                cliente.setNome(aValue.toString());
                break;
            case 2:
                cliente.setCpf(aValue.toString());
                break;
            case 3:
                cliente.setTelefone(aValue.toString());
                break;
            case 4:
                cliente.setEndereco(aValue.toString());
                break;
            default:
                System.err.println("Indíce de coluna inválido.");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente clienteSelecionado = listaCliente.get(rowIndex);
        String valueObject = null;
        
        switch (columnIndex){
            case 0:
                if (clienteSelecionado.getId() != null) {
                    valueObject = String.valueOf(clienteSelecionado.getId());
                } else{
                    valueObject = "";
                }
                break;
            case 1:
                valueObject = clienteSelecionado.getNome();
                break;
            case 2:
                valueObject = clienteSelecionado.getCpf();
                break;
            case 3:
                valueObject = clienteSelecionado.getTelefone();
                break;
            case 4:
                valueObject = clienteSelecionado.getEndereco();
                break;
            default:
                System.err.println("Indíce inválido para propriedade do bean Cliente.class");
        }
        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Cliente getCliente(int rowIndex) {
        return listaCliente.get(rowIndex);
    }
    
    public void addCliente(Cliente cliente) {
        listaCliente.add(cliente);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void removeCliente(int rowIndex) {
        listaCliente.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void addListaDeCliente(List<Cliente> novoCliente) {
        this.clear();
        int tamanhoAntigo = getRowCount();
        this.listaCliente = novoCliente;
        fireTableRowsInserted(tamanhoAntigo, tamanhoAntigo);
    }
    
    public void clear() {
        listaCliente.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty(){
        return listaCliente.isEmpty();
    }

    
    
    
    
    
}
