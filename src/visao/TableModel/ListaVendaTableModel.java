/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.entidade.Categoria;
import modelo.entidade.Marca;
import modelo.entidade.Produto;
import modelo.entidade.Venda;

/**
 *
 * @author Diogo
 */
public class ListaVendaTableModel extends AbstractTableModel {
    
    private List<Venda> listaVenda;
    private String[] colunas = new String[]{"Código", "Nome", "Marca", "Categoria", "Valor Unitário", "Quantidade", "Valor Total"};
    
    public ListaVendaTableModel(List<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }
    
    public ListaVendaTableModel() {
        this.listaVenda = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaVenda.size();
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
    
    public void setValueAt(Venda aValue, int rowIndex) {
        Venda venda = listaVenda.get(rowIndex);
        
        venda.setCodProduto(aValue.getCodProduto());
        venda.setProduto(aValue.getProduto());
        venda.setMarcaProduto(aValue.getMarcaProduto());
        venda.setCategoriaProduto(aValue.getCategoriaProduto());
        venda.setValorUnitario(aValue.getValorUnitario());
        venda.setQuantidade(aValue.getQuantidade());
        venda.setValorTotal(aValue.getValorTotal());
        
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
        fireTableCellUpdated(rowIndex, 6);
        fireTableCellUpdated(rowIndex, 7);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Venda venda = listaVenda.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                venda.setCodProduto(Long.parseLong(aValue.toString()));
                break;
            case 1:
                venda.setProduto((Produto)aValue);
                break;
            case 2:
                venda.setMarcaProduto((Marca)aValue);
                break;
            case 3:
                venda.setCategoriaProduto((Categoria)aValue);
                break;
            case 4:
                venda.setValorUnitario(Float.parseFloat(aValue.toString()));
                break;
            case 5:
                venda.setQuantidade(Integer.parseInt(aValue.toString()));
                break;
            case 6:
                venda.setValorTotal(Float.parseFloat(aValue.toString()));
                break;
            default:
                System.err.println("Indice de coluna inválido");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda vendaSelecionada = listaVenda.get(rowIndex);
        String valueObject = null;
        
        switch(columnIndex) {
            case 0:
                valueObject = Long.toString(vendaSelecionada.getCodProduto());
                break;
            case 1:
                valueObject = vendaSelecionada.getProduto().toString();
                break;
            case 2:
                valueObject = vendaSelecionada.getMarcaProduto().toString();
                break;
            case 3:
                valueObject = vendaSelecionada.getCategoriaProduto().toString();
                break;
            case 4:
                valueObject = Float.toString(vendaSelecionada.getValorUnitario());
                break;
            case 5:
                valueObject = Integer.toString(vendaSelecionada.getQuantidade());
                break;
            case 6:
                valueObject = Double.toString(vendaSelecionada.getValorTotal());
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
    
    public Venda getVenda(int rowIndex) {
        return listaVenda.get(rowIndex);
    }
    
    public void addVenda(Venda venda) {
        this.listaVenda.add(venda);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void removerVenda(int rowIndex) {
        this.listaVenda.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void addListaDeVenda(List<Venda> novoProduto) {
        int ultimoIndice = getRowCount() - 1;
        this.listaVenda = novoProduto;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void clear() {
        this.listaVenda.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty() {
        return listaVenda.isEmpty();
    }
}
