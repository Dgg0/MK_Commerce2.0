package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidade.Categoria;

/**
 *
 * @author Diogo
 */
public class CategoriaDao {
    private Connection con;
    
    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }
    
    public void salvar(Categoria categoria) {
        if (categoria.getId() != null) {
           this.update(categoria);
        } else {
           this.insert(categoria);
        }
    }
    
    public void excluir(Categoria categoria) {
        iniciarConexaoDB();
        String sql = "DELETE FROM categoria WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, categoria.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Categoria excluida com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir categoria: " + ex.getMessage());
        }
    }
    
    private void insert(Categoria categoria) {
        iniciarConexaoDB();
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, categoria.getNome());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir categoria: " + ex.getMessage());
        }
    }
    
    private void update(Categoria categoria) {
        iniciarConexaoDB();
        String sql = "UPDATE categoria SET nome = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, categoria.getNome());
            pstmt.setLong(2, categoria.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar categoria: " + ex.getMessage());
        }
    }
    
    public Categoria selectId(long id) {
        iniciarConexaoDB();
        Categoria categoria = null;
        String sql = "SELECT id, nome FROM categoria WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                categoria = new Categoria();
                categoria.setId(resultado.getInt("id"));
                categoria.setNome(resultado.getString("nome"));
            }
            return categoria;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar categoria por ID: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Categoria> selectNome(String nome) {
        iniciarConexaoDB();
        Categoria categoria;
        List<Categoria> lstCategoria = new ArrayList();
        String sql = "SELECT id, nome FROM categoria WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                categoria = new Categoria();
                categoria.setId(resultado.getInt("id"));
                categoria.setNome(resultado.getString("nome"));
                lstCategoria.add(categoria);
            }
            return lstCategoria;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar categoria por NOME: " + ex.getMessage());
            return null;
        }
    }
    
    public Categoria select(String nome) {
        iniciarConexaoDB();
        Categoria categoria = null;
        String sql = "SELECT id, nome FROM categoria WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                categoria = new Categoria();
                categoria.setId(resultado.getInt("id"));
                categoria.setNome(resultado.getString("nome"));
            }
            return categoria;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar categoria por NOME: " + ex.getMessage());
            return null;
        }
    }
}
