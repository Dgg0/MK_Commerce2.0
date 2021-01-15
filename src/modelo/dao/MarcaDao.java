package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidade.Marca;

/**
 *
 * @author Diogo
 */
public class MarcaDao {
    private Connection con;
    
    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }
    
    public void salvar(Marca marca) {
        if (marca.getId() != null) {
            this.update(marca);
        } else {
            this.insert(marca);
        }
    }
    
    public void excluir(Marca marca) {
        iniciarConexaoDB();
        String sql = "DELETE FROM marca WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, marca.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Marca excluida com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir marca: " + ex.getMessage());
        }
    }
    
    private void insert(Marca marca) {
        iniciarConexaoDB();
        String sql = "INSERT INTO marca (nome) VALUES (?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, marca.getNome());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Marca inserida com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir marca: " + ex.getMessage());
        }
    }
    
    private void update(Marca marca) {
        iniciarConexaoDB();
        String sql = "UPDATE marca SET nome = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, marca.getNome());
            pstmt.setLong(2, marca.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Marca atualizada com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar marca: " + ex.getMessage());
        }
    }
    
    public Marca selectId(long id) {
        iniciarConexaoDB();
        Marca marca = null;
        String sql = "SELECT id, nome FROM marca WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                marca = new Marca();
                marca.setId(resultado.getInt("id"));
                marca.setNome(resultado.getString("nome"));
            }
            return marca;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar marca por ID: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Marca> selectNome(String nome) {
        iniciarConexaoDB();
        Marca marca; 
        List<Marca> lstMarca = new ArrayList();
        String sql = "SELECT id, nome FROM marca WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                marca = new Marca();
                marca.setId(resultado.getInt("id"));
                marca.setNome(resultado.getString("nome"));
                lstMarca.add(marca);
            }
            return lstMarca;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar marca por NOME: " + ex.getMessage());
            return null;
        }
    }
    
    public Marca select(String nome) {
        iniciarConexaoDB();
        Marca marca = null; 
        String sql = "SELECT id, nome FROM marca WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                marca = new Marca();
                marca.setId(resultado.getInt("id"));
                marca.setNome(resultado.getString("nome"));
            }
            return marca;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar marca por NOME: " + ex.getMessage());
            return null;
        }
    }
}
