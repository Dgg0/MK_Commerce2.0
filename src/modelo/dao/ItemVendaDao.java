/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidade.ItemVenda;
import modelo.entidade.Produto;

/**
 *
 * @author Diogo
 */
public class ItemVendaDao {
    Connection con;
    ProdutoDao produtoDao;
    
    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }
    
    public void insertItemVenda(ItemVenda itemVenda) {
        iniciarConexaoDB();
        String sql = "INSERT INTO produtos_venda (id, id_venda, id_produto, qtde, valor) VALUES (DEFAULT, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, itemVenda.getId_venda());
            pstmt.setInt(2, itemVenda.getProduto().getId());
            pstmt.setInt(3, itemVenda.getQuantidade());
            pstmt.setFloat(4, itemVenda.getValorUnitario());
            pstmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar compra" + ex.getMessage());
        }
    }
    
    private Produto buscarProduto(int id_produto) {
        if (produtoDao == null) {
            produtoDao = new ProdutoDao();
        }
        return produtoDao.selectId(id_produto);
    }
    
    public List<ItemVenda> selectId(int id_venda)  {
        iniciarConexaoDB();
        List<ItemVenda> listaItemVenda = new ArrayList<>();
        ItemVenda itemVenda = null;
        String sql = "SELECT id_venda, id_produto, qtde, valor FROM produtos_venda WHERE id_venda = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id_venda);
            ResultSet resultado = pstmt.executeQuery();
            while(resultado.next()) {
                itemVenda = new ItemVenda();
                itemVenda.setId_venda(resultado.getInt("id_venda"));
                itemVenda.setProduto(buscarProduto(resultado.getInt("id_produto")));
                itemVenda.setQuantidade(resultado.getInt("qtde"));
                itemVenda.setValorUnitario(resultado.getFloat("valor"));
                listaItemVenda.add(itemVenda);
            }
            return listaItemVenda;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar ItemVenda por ID " + ex.getMessage());
            return null;
        }
    }
}
