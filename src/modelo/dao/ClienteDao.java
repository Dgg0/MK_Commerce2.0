package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidade.Cliente;

/**
 *
 * @author Diogo
 */
public class ClienteDao {
    Connection con;
    
    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }
    
    public void salvar(Cliente cliente) {
        if (cliente.getId() != null) {
            this.update(cliente);
        } else {
            this.insert(cliente);
        }
    }
    
    public void excluir(Cliente cliente) {
        iniciarConexaoDB();
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, cliente.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + ex.getMessage());
        }
    }
    
    private void insert(Cliente cliente) {
        iniciarConexaoDB();
        String sql = "INSERT INTO cliente (nome, cpf, telefone, endereco) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente: " + ex.getMessage());
        }
    }
    
    private void update(Cliente cliente) {
        iniciarConexaoDB();
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, endereco = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setLong(5, cliente.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + ex.getMessage());
        }
    }
    
    public Cliente selectId(long id) {
        iniciarConexaoDB();
        Cliente cliente = null;
        String sql = "SELECT id, nome, cpf, telefone, endereco FROM cliente WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEndereco(resultado.getString("endereco"));
            }
            return cliente;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar por ID: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Cliente> selectNome(String nome) {
        iniciarConexaoDB();
        Cliente cliente = null;
        List<Cliente> lstCliente = new ArrayList();
        String sql = "SELECT id, nome, cpf, telefone, endereco FROM cliente WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEndereco(resultado.getString("endereco"));
                lstCliente.add(cliente);
            }
            return lstCliente;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente por nome: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Cliente> selectCpf(String cpf) {
        iniciarConexaoDB();
        Cliente cliente = null;
        List<Cliente> lstCliente = new ArrayList();
        String sql = "SELECT id, nome, cpf, telefone, endereco FROM cliente WHERE cpf LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cpf + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEndereco(resultado.getString("endereco"));
                lstCliente.add(cliente);
            }
            return lstCliente;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente por CPF: " + ex.getMessage());
            return null;
        }
    }
}
