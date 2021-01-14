/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.entidade.ItemVenda;
import modelo.entidade.Produto;

/**
 *
 * @author Diogo
 */
public class ItemVendaTableModel extends AbstractTableModel{
    List<ItemVenda> listaItemVenda;
    String colunas[] = new String[]{"ID Venda", "Produto", "Quantidade", "Valor Unitário"};
    
    public ItemVendaTableModel(List<ItemVenda> novaListaItemVenda) {
        this.listaItemVenda = novaListaItemVenda;
    }
    
    public ItemVendaTableModel() {
        this.listaItemVenda = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaItemVenda.size();
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
    
    public void setValueAt(ItemVenda aValue, int rowIndex) {
        ItemVenda itemVenda = listaItemVenda.get(rowIndex);
        
        itemVenda.setId_venda(aValue.getId_venda());
        itemVenda.setProduto(aValue.getProduto());
        itemVenda.setQuantidade(aValue.getQuantidade());
        itemVenda.setValorUnitario(aValue.getValorUnitario());
        
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ItemVenda itemVenda = listaItemVenda.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                itemVenda.setId_venda(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                itemVenda.setProduto((Produto)aValue);
                break;
            case 2:
                itemVenda.setQuantidade(Integer.parseInt(aValue.toString()));
                break;
            case 3:
                itemVenda.setValorUnitario(Float.parseFloat(aValue.toString()));
                break;
            default:
                System.err.println("Índice de Coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemVenda itemVendaSelecionado = listaItemVenda.get(rowIndex);
        String valueObject = null;
        
        switch(columnIndex) {
            case 0:
                valueObject = String.valueOf(itemVendaSelecionado.getId_venda());
                break;
            case 1:
                valueObject = itemVendaSelecionado.getProduto().getNome();
                break;
            case 2:
                valueObject = String.valueOf(itemVendaSelecionado.getQuantidade());
                break;
            case 3:
                valueObject = Float.toString(itemVendaSelecionado.getValorUnitario());
                break;
            default:
                System.err.println("Índice de Coluna inválido para a propriedade do bean ItemVenda.class");
        }
        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public ItemVenda getItemVenda(int rowIndex) {
        return listaItemVenda.get(rowIndex);
    }
    
    public void addItemVenda(ItemVenda itemVenda) {
        this.listaItemVenda.add(itemVenda);
        int ultimoIndice = getRowCount();
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void addListaItemVenda(List<ItemVenda> novoItemVenda) {
        this.clear();
        int tamanhoAntigo = getRowCount() - 1;
        this.listaItemVenda.addAll(novoItemVenda);
        
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    public void removerItemVenda(int rowIndex) {
        this.listaItemVenda.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void clear() {
        this.listaItemVenda.clear();
    }
    
    public boolean isEmpty() {
        return this.listaItemVenda.isEmpty();
    }
}
