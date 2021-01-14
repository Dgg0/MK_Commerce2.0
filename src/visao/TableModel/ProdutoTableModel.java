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

/**
 *
 * @author Diogo
 */
public class ProdutoTableModel extends AbstractTableModel {
    public List<Produto> listaProduto;
    public String[] colunas = new String[]{"Id", "Código", "Nome", "Marca", "Categoria", "Preço", "Estoque", "Estoque Minimo"};
    
    public ProdutoTableModel(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    public ProdutoTableModel() {
        this.listaProduto = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaProduto.size();
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
    
    public void setValueAt(Produto aValue, int rowIndex) {
        Produto produto = listaProduto.get(rowIndex);
        
        produto.setId(aValue.getId());
        produto.setCodProduto(aValue.getCodProduto());
        produto.setNome(aValue.getNome());
        produto.setMarca(aValue.getMarca());
        produto.setCategoria(aValue.getCategoria());
        produto.setPreco(aValue.getPreco());
        produto.setQtdeEstoque(aValue.getQtdeEstoque());
        produto.setEstoqueMin(aValue.getEstoqueMin());
        
        fireTableRowsUpdated(rowIndex, 1);
        fireTableRowsUpdated(rowIndex, 2);
        fireTableRowsUpdated(rowIndex, 3);
        fireTableRowsUpdated(rowIndex, 4);
        fireTableRowsUpdated(rowIndex, 5);
        fireTableRowsUpdated(rowIndex, 6);
        fireTableRowsUpdated(rowIndex, 7);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto produto = listaProduto.get(columnIndex);
        
        switch (columnIndex) {
            case 0:
                produto.setId(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                produto.setCodProduto(Integer.parseInt(aValue.toString()));
                break;
            case 2:
                produto.setNome(aValue.toString());
                break;
            case 3:
                produto.setMarca((Marca)aValue);
                break;
            case 4:
                produto.setCategoria((Categoria)aValue);
                break;
            case 5:
                produto.setPreco(Float.parseFloat(aValue.toString()));
                break;
            case 6:
                produto.setQtdeEstoque(Integer.parseInt(aValue.toString()));
                break;
            case 7:
                produto.setEstoqueMin(Integer.parseInt(aValue.toString()));
                break;
            default:
                System.err.println("Indice da coluna inválido");
        }
        fireTableRowsUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produtoSelecionado = listaProduto.get(rowIndex);
        String valueObject = null;
        
        switch(columnIndex) {
            case 0:
                if (produtoSelecionado.getId() != null) {
                    valueObject = String.valueOf(produtoSelecionado.getId());
                } else {
                    valueObject = "";
                }
                break;
            case 1:
                valueObject = String.valueOf(produtoSelecionado.getCodProduto());
                break;
            case 2:
                valueObject = produtoSelecionado.getNome();
                break;
            case 3:
                valueObject = produtoSelecionado.getMarca().getNome();
                break;
            case 4:
                valueObject = produtoSelecionado.getCategoria().getNome();
                break;
            case 5:
                valueObject = String.valueOf(produtoSelecionado.getPreco());
                break;
            case 6:
                valueObject = String.valueOf(produtoSelecionado.getQtdeEstoque());
                break;
            case 7:
                valueObject = String.valueOf(produtoSelecionado.getEstoqueMin());
                break;
            default:
                System.err.println("Indice inválido para a propriedade do bean produto.Class");
        }
        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Produto getProduto(int rowIndex) {
        return listaProduto.get(rowIndex);
    }
    
    public void addProduto(Produto produto) {
        listaProduto.add(produto);
        
        int ultimoIndice  = getRowCount() - 1;
        
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void removerProduto(int rowIndex) {
        listaProduto.remove(rowIndex);
        
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void addListaDeProduto(List<Produto> novoProduto) {
        clear();
        int tamanhoAntigo = getRowCount();
        listaProduto.addAll(novoProduto);
        
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    public void clear() {
        listaProduto.clear();
        
        fireTableDataChanged();
    }
    
    public boolean isEmpty() {
        return listaProduto.isEmpty();
    }
}
