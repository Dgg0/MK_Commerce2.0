package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidade.Categoria;
import modelo.entidade.Marca;
import modelo.entidade.Produto;

/**
 *
 * @author Diogo
 */
public class ProdutoDao {
    Connection con;
    
    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }
    
    public void salvar(Produto produto) {
        if (produto.getId() != null) {
            this.update(produto);
        } else {
            this.insert(produto);
        }
    }
    
    public void excluir(Produto produto) {
        iniciarConexaoDB();
        String sql = "DELETE FROM produto WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, produto.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Produto apagado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar produto: " + ex.getMessage());
        }
    }
    
    private void insert(Produto produto) {
        iniciarConexaoDB();
        String sql = "INSERT INTO produto (cod_produto, nome, id_marca, id_categoria, preco, qtdeEstoque, estoqueMin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, produto.getCodProduto());
            pstmt.setString(2, produto.getNome());
            pstmt.setLong(3, produto.getMarca().getId());
            pstmt.setInt(4, produto.getCategoria().getId());
            pstmt.setFloat(5, produto.getPreco());
            pstmt.setInt(6, produto.getQtdeEstoque());
            pstmt.setInt(7, produto.getEstoqueMin());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto: " + ex.getMessage());
        }
    }
    
    public void updateEstoque(int id_produto, int estoqueAtualizado) {
        iniciarConexaoDB();
        String sql = "UPDATE produto SET qtdeEstoque = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, estoqueAtualizado);
            pstmt.setInt(2, id_produto);
            pstmt.execute();
        } catch (SQLException ex) {
        }
    }
    
    private void update(Produto produto) {
        iniciarConexaoDB();
        String sql = "UPDATE produto SET cod_produto = ?, nome = ?, id_marca = ?, id_categoria = ?, preco = ?, qtdeEstoque = ?, estoqueMin = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, produto.getCodProduto());
            pstmt.setString(2, produto.getNome());
            pstmt.setLong(3, produto.getMarca().getId());
            pstmt.setLong(4, produto.getCategoria().getId());
            pstmt.setFloat(5, produto.getPreco());
            pstmt.setInt(6, produto.getQtdeEstoque());
            pstmt.setInt(7, produto.getEstoqueMin());
            pstmt.setInt(8, produto.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + ex.getMessage());
        }
    }
    
    private MarcaDao marcaDao;
    private Marca buscarMarca(long id) {
        if (marcaDao == null) {
            marcaDao = new MarcaDao();
        }
        return marcaDao.selectId(id);
    }
    
    private CategoriaDao categoriaDao;
    private Categoria buscarCategoria(int id) {
        if (categoriaDao == null) {
            categoriaDao = new CategoriaDao();
        }
        return categoriaDao.selectId(id);
    }
    
    public Produto selectId(int idProduto) {
        iniciarConexaoDB();
        Produto produto  = null;
        String sql = "SELECT id, cod_produto, nome, id_marca, id_categoria, preco, qtdeEstoque, estoqueMin FROM produto WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, idProduto);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                produto = new Produto();
                produto.setId(resultado.getInt("id"));
                produto.setCodProduto(resultado.getInt("cod_produto"));
                produto.setNome(resultado.getString("nome"));
                produto.setMarca(buscarMarca(resultado.getInt("id_marca")));
                produto.setCategoria(buscarCategoria(resultado.getInt("id_categoria")));
                produto.setPreco(resultado.getFloat("preco"));
                produto.setQtdeEstoque(resultado.getInt("qtdeEstoque"));
                produto.setEstoqueMin(resultado.getInt("estoqueMin"));
            }
            return produto;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produto por ID: " + ex.getMessage());
            return null;
        }
    }
    
    public Produto selectCod(int codProduto) {
        iniciarConexaoDB();
        Produto produto = null;
        String sql = "SELECT id, cod_produto, nome, id_marca, id_categoria, preco, qtdeEstoque, estoqueMin FROM produto WHERE cod_produto = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, codProduto);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                produto = new Produto();
                produto.setId(resultado.getInt("id"));
                produto.setCodProduto(resultado.getInt("cod_produto"));
                produto.setNome(resultado.getString("nome"));
                produto.setMarca(buscarMarca(resultado.getLong("id_marca")));
                produto.setCategoria(buscarCategoria(resultado.getInt("id_categoria")));
                produto.setPreco(resultado.getFloat("preco"));
                produto.setQtdeEstoque(resultado.getInt("qtdeEstoque"));
                produto.setEstoqueMin(resultado.getInt("estoqueMin"));
            }
            return produto;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Produto por ID: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Produto> selectNome(String nome) {
        iniciarConexaoDB();
        Produto produto = null;
        List<Produto> lstProduto = new ArrayList();
        String sql = "SELECT id, cod_produto, nome, id_marca, id_categoria, preco, qtdeEstoque, estoqueMin FROM produto WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                produto = new Produto();
                produto.setId(resultado.getInt("id"));
                produto.setCodProduto(resultado.getInt("cod_produto"));
                produto.setNome(resultado.getString("nome"));
                produto.setMarca(buscarMarca(resultado.getLong("id_marca")));
                produto.setCategoria(buscarCategoria(resultado.getInt("id_categoria")));
                produto.setPreco(resultado.getFloat("preco"));
                produto.setQtdeEstoque(resultado.getInt("qtdeEstoque"));
                produto.setEstoqueMin(resultado.getInt("estoqueMin"));
                lstProduto.add(produto);
            }
            return lstProduto;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produto por NOME: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Produto> selectMarca(int idMarca) {
        iniciarConexaoDB();
        Produto produto = null;
        List<Produto> lstProduto = new ArrayList<>();
        String sql = "SELECT id, cod_produto, nome, id_marca, id_categoria, preco, qtdeEstoque, estoqueMin FROM produto where id_marca = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, idMarca);
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                produto = new Produto();
                produto.setId(resultado.getInt("id"));
                produto.setCodProduto(resultado.getInt("cod_produto"));
                produto.setNome(resultado.getString("nome"));
                produto.setMarca(buscarMarca(resultado.getInt("id_marca")));
                produto.setCategoria(buscarCategoria(resultado.getInt("id_categoria")));
                produto.setPreco(resultado.getFloat("preco"));
                produto.setQtdeEstoque(resultado.getInt("qtdeEstoque"));
                produto.setEstoqueMin(resultado.getInt("estoqueMin"));
                lstProduto.add(produto);
            }
            return lstProduto;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro apo pesquisar produto por MARCA: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Produto> selectCategoria(int idCategoria) {
        iniciarConexaoDB();
        Produto produto = null;
        List<Produto> lstProduto = new ArrayList<>();
        String sql = "SELECT id, cod_produto, nome, id_marca, id_categoria, preco, qtdeEstoque, estoqueMin FROM produto WHERE id_categoria = ?;";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, idCategoria);
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                produto = new Produto();
                produto.setId(resultado.getInt("id"));
                produto.setCodProduto(resultado.getInt("cod_produto"));
                produto.setNome(resultado.getString("nome"));
                produto.setMarca(buscarMarca(resultado.getInt("id_marca")));
                produto.setCategoria(buscarCategoria(resultado.getInt("id_categoria")));
                produto.setPreco(resultado.getFloat("preco"));
                produto.setQtdeEstoque(resultado.getInt("qtdeEstoque"));
                produto.setEstoqueMin(resultado.getInt("estoqueMin"));
                lstProduto.add(produto);
            }
            return lstProduto;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produto por CATEGORIA: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Produto> selectEstoque() {
        iniciarConexaoDB();
        List<Produto> listaProduto = new ArrayList<>();
        Produto produto = null;
        String sql = "SELECT id, cod_produto, nome, id_marca, id_categoria, preco, qtdeEstoque, estoqueMin FROM produto WHERE qtdeEstoque < estoqueMin";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();
            while(resultado.next()) {
                produto = new Produto();
                produto.setId(resultado.getInt(1));
                produto.setCodProduto(resultado.getInt(2));
                produto.setNome(resultado.getString(3));
                produto.setMarca(buscarMarca(resultado.getInt(4)));
                produto.setCategoria(buscarCategoria(resultado.getInt(5)));
                produto.setPreco(resultado.getFloat(6));
                produto.setQtdeEstoque(resultado.getInt(7));
                produto.setEstoqueMin(resultado.getInt(8));
                listaProduto.add(produto);
            }
            return listaProduto;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar PRODUTOS pelo ESTOQUE: " + ex.getMessage());
            return null;
        }
    }
}
