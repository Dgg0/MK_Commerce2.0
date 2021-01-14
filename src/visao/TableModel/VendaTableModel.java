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
import modelo.entidade.Venda;
import uteis.Uteis;

/**
 *
 * @author Diogo
 */
public class VendaTableModel extends AbstractTableModel{
    List<Venda> listaVenda;
    String colunas[] = new String[] {"ID", "Cliente", "Tipo de Pagamento", "Data da Venda"};

    public VendaTableModel(List<Venda> novaListaVenda) {
        this.listaVenda = novaListaVenda;
    }
    
    public VendaTableModel() {
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
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex] ;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    public void setValueAt(Venda aValue, int rowIndex) {
        Venda venda = listaVenda.get(rowIndex);
        
        venda.setIdVenda(aValue.getIdProduto());
        venda.setCliente(aValue.getCliente());
        venda.setTipoPagamento(aValue.getTipoPagamento());
        venda.setDataVenda(aValue.getDataVenda());
        
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Venda venda = listaVenda.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                venda.setIdProduto(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                venda.setCliente((Cliente)aValue);
                break;
            case 2:
                venda.setTipoPagamento(aValue.toString());
                break;
            case 3:
                venda.setDataVenda(Uteis.parseDate(aValue.toString()));
                break;
            default:
                System.err.println("Índice de coluna Inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda vendaSelecionada = listaVenda.get(rowIndex);
        String valueObject = null;
        
        switch(columnIndex) {
            case 0:
                if (vendaSelecionada.getIdVenda() != null) {
                    valueObject = String.valueOf(vendaSelecionada.getIdVenda());
                } else {
                    valueObject = "";
                }
                break;
            case 1:
               valueObject = vendaSelecionada.getCliente().getNome();
               break;
            case 2:
                valueObject = vendaSelecionada.getTipoPagamento();
                break;
            case 3:
                valueObject = Uteis.parseDate(vendaSelecionada.getDataVenda());
                break;
            default :
                System.err.println("Ìndice de Coluna inválido para propriedade do bean Venda.class");
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
        int ultimoIndice = getRowCount();
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void addListaDeVenda(List<Venda> novaVenda) {
        this.clear();
        int tamanhoAntigo = getRowCount();
        this.listaVenda.addAll(novaVenda);
        
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    public void removerVenda(int rowIndex) {
        this.listaVenda.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void clear() {
        this.listaVenda.clear();
        
        fireTableDataChanged();
    }
    
    public boolean isEmpty() {
        return this.listaVenda.isEmpty();
    }
}
