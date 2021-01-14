/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import modelo.dao.CategoriaDao;
import modelo.dao.MarcaDao;
import modelo.dao.ProdutoDao;
import modelo.entidade.Categoria;
import modelo.entidade.Marca;
import modelo.entidade.Produto;
import visao.TableModel.ProdutoColumnModel;
import visao.TableModel.ProdutoTableModel;

/**
 *
 * @author Diogo
 */
public class ProdutoCons extends javax.swing.JDialog {

    /**
     * Creates new form ProdutoFrm
     */
    public ProdutoCons(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centralizarTela();
        formatarTableModel();
        jComboMarca.setEnabled(false);
        jComboCategoria.setEnabled(false);
        carregarComboBoxCategoria();
        carregarComboBoxMarca();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jComboParametros = new javax.swing.JComboBox<>();
        jTxfPesquisarPor = new javax.swing.JTextField();
        jBtnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboMarca = new javax.swing.JComboBox<>();
        jComboCategoria = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblProduto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jBtnEditar = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisar"));

        jComboParametros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboParametros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Código", "Marca", "Categoria", "Id" }));
        jComboParametros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboParametrosItemStateChanged(evt);
            }
        });

        jTxfPesquisarPor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/from/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setToolTipText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Marca");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Categoria");

        jComboMarca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jComboCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxfPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jBtnPesquisar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxfPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBtnPesquisar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Código", "Nome", "Marca", "Categoria", "Preço", "Estoque", "Estoque Min"
            }
        ));
        jScrollPane2.setViewportView(jTblProduto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/from/editdocuments.png"))); // NOI18N
        jBtnEditar.setToolTipText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/from/novo.png"))); // NOI18N
        jBtnNovo.setToolTipText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        jBtnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/from/exit.png"))); // NOI18N
        jBtnFechar.setToolTipText("Sair");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnNovo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnFechar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnEditar)
                .addGap(18, 18, 18)
                .addComponent(jBtnNovo)
                .addGap(32, 32, 32)
                .addComponent(jBtnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        this.botaoPesquisar();
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        this.botaoEditar();
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        this.botaoNovo();
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
        this.dispose();;
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jComboParametrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboParametrosItemStateChanged
        if (jComboParametros.getSelectedItem().equals("Marca")) {
            jComboCategoria.setEnabled(false);
            jComboMarca.setEnabled(true);
            jTxfPesquisarPor.setEnabled(false);
        }  else if (jComboParametros.getSelectedItem().equals("Categoria")) {
            jComboMarca.setEnabled(false);
            jComboCategoria.setEnabled(true);
            jTxfPesquisarPor.setEnabled(false);
        } else {
            jTxfPesquisarPor.setEnabled(true);
            jComboMarca.setEnabled(false);
            jComboCategoria.setEnabled(false);
        }
    }//GEN-LAST:event_jComboParametrosItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutoCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoCons dialog = new ProdutoCons(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboCategoria;
    private javax.swing.JComboBox<String> jComboMarca;
    private javax.swing.JComboBox<String> jComboParametros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTblProduto;
    private javax.swing.JTextField jTxfPesquisarPor;
    // End of variables declaration//GEN-END:variables
    
    private List<Produto> listaProduto;
    private ProdutoDao produtoDao;
    private MarcaDao marcaDao;
    private CategoriaDao categoriaDao;
    private ProdutoFrm produtoFrm;
    
    private void centralizarTela() {
        Dimension tamanhoTela = getToolkit().getScreenSize();
        Dimension tamanho = getSize();
        setLocation((tamanhoTela.width - tamanho.width)/ 2,250);
    }
    
    private DefaultComboBoxModel comboBoxMarca;
    private DefaultComboBoxModel comboBoxCategoria;
    
    private void carregarComboBoxMarca() {
        if (marcaDao == null) {
            marcaDao = new MarcaDao();
        }
        List<Marca> listaMarca = marcaDao.pesquisar("");
        comboBoxMarca = (DefaultComboBoxModel)jComboMarca.getModel();
        comboBoxMarca.removeAllElements();
        for (int linha = 0; linha < listaMarca.size(); linha++) {
            Marca marca = listaMarca.get(linha);
            comboBoxMarca.addElement(marca);
        }
        jComboMarca.setModel(comboBoxMarca);
    }
    
    private void carregarComboBoxCategoria() {
        if (categoriaDao == null) {
            categoriaDao = new CategoriaDao();
        }
        List<Categoria> listaCategoria = categoriaDao.pesquisar("");
        comboBoxCategoria = (DefaultComboBoxModel)jComboCategoria.getModel();
        comboBoxCategoria.removeAllElements();
        for (int linha = 0; linha < listaCategoria.size(); linha++) {
            Categoria categoria = listaCategoria.get(linha);
            comboBoxCategoria.addElement(categoria);
        }
        jComboCategoria.setModel(comboBoxCategoria);
    }
    
    private void formatarTableModel() {
        FontMetrics fm = jTblProduto.getFontMetrics(jTblProduto.getFont());
        jTblProduto.setColumnModel(new ProdutoColumnModel(fm));
    }
    
    private ProdutoTableModel model = new ProdutoTableModel();
    private void setListaProduto(List<Produto> listaProduto) {
        jTblProduto.setModel(model);
        model.addListaDeProduto(listaProduto);
        this.formatarTableModel();
    }
    
    public Produto getProdutoSelecionado() {
        return model.getProduto(jTblProduto.getSelectedRow());
    }
    
    private String param[] = new String[2];
    private void getParametroPesquisa() {
        param[0] = jComboParametros.getSelectedItem().toString().toUpperCase();
        param[1] = jTxfPesquisarPor.getText().toUpperCase();
    }
    
    private void botaoPesquisar(){
        getParametroPesquisa();
        if (produtoDao == null) {
            produtoDao = new ProdutoDao();
        }
        listaProduto = new ArrayList<>();
        
        if (param[0].equals("NOME")) {
            listaProduto = produtoDao.selectNome(param[1]);
        } else if (param[0].equals("CÓDIGO")) {
            listaProduto.add(produtoDao.selectCod(Integer.parseInt(param[1])));
        } else  if (param[0].equals("MARCA")) {
            Marca marca = marcaDao.buscarMarca(jComboMarca.getSelectedItem().toString());
            listaProduto =  produtoDao.selectMarca(marca.getId());
        } else if (param[0].equals("CATEGORIA")) {
            Categoria categoria = categoriaDao.buscarCategoria(jComboCategoria.getSelectedItem().toString());
            listaProduto = produtoDao.selectCategoria(categoria.getId());
        } else {
            listaProduto.add(produtoDao.selectId(Integer.parseInt(param[1])));
        }
        setListaProduto(listaProduto);
    }
    
    private void botaoNovo() {
        if (produtoFrm == null) {
            produtoFrm = new ProdutoFrm(new JFrame(), true);
        }
        produtoFrm.setProduto(new Produto());
        produtoFrm.setVisible(true);
    }
    
    private void botaoEditar() {
        if (produtoFrm == null) {
            produtoFrm = new ProdutoFrm(new JFrame(), true);
        }
        produtoFrm.setProduto(getProdutoSelecionado());
        produtoFrm.setVisible(true);
    }
}
