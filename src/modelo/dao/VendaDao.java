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
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidade.Cliente;
import modelo.entidade.Venda;

/**
 *
 * @author Diogo
 */
public class VendaDao {
    private Connection con;
    private ClienteDao clienteDao;
    
    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }
    
    public void insertVenda(Venda venda) {
        iniciarConexaoDB();
        String sql = "INSERT INTO vendas (id, id_cliente, tipo_pagamento, data_venda) VALUES(DEFAULT, ?, ?, ?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, venda.getCliente().getId());
            pstmt.setString(2, venda.getTipoPagamento());
            pstmt.setDate(3, new java.sql.Date(venda.getDataVenda().getTime()));
            pstmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a venda " + ex.getMessage());
        }
    }
    
    public Integer selectUltimaVenda() {
        iniciarConexaoDB();
        Integer id = null;
        String sql = "select * from vendas where id = (select max(id) from vendas)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                id = resultado.getInt("id");
            }
            return id;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ID: " + ex.getMessage());
            return null;
        }
    }
    
    private Cliente buscarCliente(int id_cliente) {
        if (clienteDao == null) {
            clienteDao = new ClienteDao();
        }
        return clienteDao.selectId(id_cliente);
    }
    
    public List<Venda> selectCliente(Integer id_cliente) {
        iniciarConexaoDB();
        Venda venda = null;
        List<Venda> listaVenda = new ArrayList<>();
        String sql = "SELECT id, id_cliente, tipo_pagamento, data_venda FROM vendas WHERE id_cliente = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id_cliente);
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                venda = new Venda();
                venda.setIdVenda(resultado.getInt("id"));
                venda.setCliente(buscarCliente(resultado.getInt("id_cliente")));
                venda.setTipoPagamento(resultado.getString("tipo_pagamento"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                listaVenda.add(venda);
            }
            return listaVenda;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar VENDA por CLIENTE: " + ex.getMessage());
            return null;
        }
    }
    
    public Venda selectId(Integer id_venda) {
        iniciarConexaoDB();
        Venda venda = null;
        String sql = "SELECT id, id_cliente, tipo_pagamento, data_venda FROM vendas WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id_venda);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                venda = new Venda();
                venda.setIdVenda(resultado.getInt("id"));
                venda.setCliente(buscarCliente(resultado.getInt("id_cliente")));
                venda.setTipoPagamento(resultado.getString("tipo_pagamento"));
                venda.setDataVenda(resultado.getDate("data_venda"));
            }
            return venda;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar VENDA por ID: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Venda> selectData(Date dataVenda) {
        iniciarConexaoDB();
        Venda venda = null;
        List<Venda> listaVenda = new ArrayList<>();
        String sql = "SELECT id, id_cliente, tipo_pagamento, data_venda FROM vendas WHERE data_venda = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDate(1, new java.sql.Date(dataVenda.getTime()));
            ResultSet resultado = pstmt.executeQuery();
            while(resultado.next()) {
                venda = new Venda();
                venda.setIdVenda(resultado.getInt("id"));
                venda.setCliente(buscarCliente(resultado.getInt("id_cliente")));
                venda.setTipoPagamento(resultado.getString("tipo_pagamento"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                listaVenda.add(venda);
            }
            return listaVenda;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar VENDA por DATA: " + ex.getMessage());
            return null;
        }
    }
}
    
    

