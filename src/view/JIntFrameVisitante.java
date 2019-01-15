/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.VisitanteCTR;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import model.domain.Visitante;

/**
 *
 * @author anderson
 */
public class JIntFrameVisitante extends javax.swing.JInternalFrame {

    private VisitanteCTR visitanteCTR;
    private Boolean status; //true = inserir; false = salvar;
    private DefaultTableModel modelTable;
    private int pontoAcessoTela; //1 - Acesso pelo SubMenu Visitante; 2 - Acesso pela Tela de Cadastro de Visita;
    private JIntFrameVisita jIntFrameVisita;
    
    /**
     * Creates new form jIntFrameVisitante
     */
    public JIntFrameVisitante(int pontoAcessoTela) {

        initComponents();
        this.pontoAcessoTela = pontoAcessoTela;
        modelTable = (DefaultTableModel) jTableVisitante.getModel();
        status = false;
        visitanteCTR = new VisitanteCTR();
        exibicaoInicial();
        DocumentFilter filter = new UppercaseDocumentFilter();
        ((AbstractDocument) jTextFieldPesq.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) jTextFieldRG.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) jTextFieldNome.getDocument()).setDocumentFilter(filter);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelPesq = new javax.swing.JLabel();
        jTextFieldPesq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVisitante = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jLabelCod = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelRG = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldRG = new javax.swing.JTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jTextFieldNome = new javax.swing.JTextField();

        setClosable(true);
        setTitle("CADASTRO DE VISITANTE");
        setPreferredSize(new java.awt.Dimension(600, 550));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelPesq.setText("PESQUISA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 25);
        getContentPane().add(jLabelPesq, gridBagConstraints);

        jTextFieldPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesqKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesqKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        getContentPane().add(jTextFieldPesq, gridBagConstraints);

        jTableVisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF", "RG", "NOME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVisitante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVisitanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVisitante);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 460;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo.gif"))); // NOI18N
        jButtonNovo.setText("NOVO");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonNovo, gridBagConstraints);

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.gif"))); // NOI18N
        jButtonSalvar.setText("SALVAR");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonSalvar, gridBagConstraints);

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deletar.gif"))); // NOI18N
        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonExcluir, gridBagConstraints);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.gif"))); // NOI18N
        jButtonFechar.setText("FECHAR");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonFechar, gridBagConstraints);

        jLabelCod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCod.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelCod.setText("CODIGO:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jLabelCod, gridBagConstraints);

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNome.setText("NOME:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jLabelNome, gridBagConstraints);

        jLabelCPF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCPF.setText("CPF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jLabelCPF, gridBagConstraints);

        jLabelRG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRG.setText("RG:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jLabelRG, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jLabelCodigo, gridBagConstraints);

        jTextFieldRG.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jTextFieldRG, gridBagConstraints);

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCPF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jFormattedTextFieldCPF, gridBagConstraints);

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jTextFieldNome, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableVisitanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVisitanteMouseClicked
        // TODO add your handling code here:

        preencheCampo(visitanteCTR.getPesqVisitante((Integer) jTableVisitante.getValueAt(jTableVisitante.getSelectedRow(), jTableVisitante.convertColumnIndexToView(0))));

        if (this.pontoAcessoTela == 2) {
            if (evt.getClickCount() == 2) {
                Visitante v = visitanteCTR.getPesqVisitante((Integer) jTableVisitante.getValueAt(jTableVisitante.getSelectedRow(), jTableVisitante.convertColumnIndexToView(0)));
                jIntFrameVisita.preencheCamposVisitante(v);
                dispose();
            }
        }

    }//GEN-LAST:event_jTableVisitanteMouseClicked

    private void jTextFieldPesqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesqKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextFieldPesqKeyPressed

    private void jTextFieldPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesqKeyReleased

// TODO add your handling code here:
        exibirPesquisa(jTextFieldPesq.getText());

    }//GEN-LAST:event_jTextFieldPesqKeyReleased

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:

        novoReg();

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        if ((jTextFieldNome.getText().trim().length() == 0)) {
            JOptionPane.showMessageDialog(null, "O REGISTRO NÃO SALVO! POR FAVOR, PREENCHA O CAMPO NOME DO VISITANTE.");
        } else {
            Visitante visitante = new Visitante();
            visitante.setIdVisitante(Integer.parseInt(jLabelCodigo.getText()));
            visitante.setCpfVisitante(jFormattedTextFieldCPF.getText().replaceAll("\\.", "").replaceAll("-", ""));
            visitante.setRgVisitante(jTextFieldRG.getText());
            visitante.setNomeVisitante(jTextFieldNome.getText());
            if (status) {
                if (visitanteCTR.inserirReg(visitante)) {
                    atualizarTabela(0);
                    status = false;
                    jButtonNovo.setEnabled(true);
                    jButtonExcluir.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "O REGISTRO SALVO COM SUCESSO!");
                } else {
                    status = true;
                    JOptionPane.showMessageDialog(null, "FALHA NA INSERÇÃO DO REGISTRO! POR FAVOR, TENTE NOVAMENTE.");
                }
            } else {
                if (visitanteCTR.atualizarReg(visitante)) {
                    atualizarTabela(jTableVisitante.convertRowIndexToModel(jTableVisitante.getSelectedRow()));
                    JOptionPane.showMessageDialog(null, "O REGISTRO FOI ATUALIZADO COM SUCESSO!");
                } else {
                    JOptionPane.showMessageDialog(null, "FALHA NA ATUALIZAÇÃO DO REGISTRO! POR FAVOR, TENTE NOVAMENTE.");
                }
            }
            exibirPesquisa("");
            jTextFieldPesq.setText("");
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:

        Visitante visitante = new Visitante();
        visitante.setIdVisitante(Integer.parseInt(jLabelCodigo.getText()));
        if (visitanteCTR.excluirReg(visitante)) {
            removeTabela(jTableVisitante.convertRowIndexToModel(jTableVisitante.getSelectedRow()));
            JOptionPane.showMessageDialog(null, "O REGISTRO EXLUÍDO COM SUCESSO!");
        } else {
            JOptionPane.showMessageDialog(null, "FALHA NA EXCLUSÃO DO REGISTRO! POR FAVOR, TENTE NOVAMENTE.");
        }

        exibirPesquisa("");
        jTextFieldPesq.setText("");

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:

        dispose();

    }//GEN-LAST:event_jButtonFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCod;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPesq;
    private javax.swing.JLabel jLabelRG;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVisitante;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesq;
    private javax.swing.JTextField jTextFieldRG;
    // End of variables declaration//GEN-END:variables

    public void exibicaoInicial() {

        jTableVisitante.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableVisitante.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTableVisitante.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableVisitante.getColumnModel().getColumn(3).setPreferredWidth(200);

        modelTable.setNumRows(0);

        visitanteCTR.getVisitanteList().forEach((v) -> {
            modelTable.addRow(new Object[]{
                v.getIdVisitante(),
                formatarCpf(v.getCpfVisitante()),
                v.getRgVisitante(),
                v.getNomeVisitante()});
        });

        jTableVisitante.addRowSelectionInterval(0, 0);
        preencheCampo(visitanteCTR.getVisitanteList().get(0));

    }

    public void preencheCampo(Visitante v) {
        jLabelCodigo.setText(String.valueOf(v.getIdVisitante()));
        jFormattedTextFieldCPF.setText(v.getCpfVisitante().equals("NULL") ? "" : v.getCpfVisitante());
        jTextFieldRG.setText(v.getRgVisitante() == null ? "" : v.getRgVisitante());
        jTextFieldNome.setText(v.getNomeVisitante() == null ? "" : v.getNomeVisitante());
    }

    public void exibirPesquisa(String valor) {

        TableRowSorter<DefaultTableModel> tr;
        tr = new TableRowSorter<DefaultTableModel>(modelTable);
        jTableVisitante.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(valor));

        if (tr.getViewRowCount() > 0) {
            jTableVisitante.addRowSelectionInterval(0, 0);
            preencheCampo(visitanteCTR.getPesqVisitante((Integer) jTableVisitante.getValueAt(jTableVisitante.getSelectedRow(), jTableVisitante.convertColumnIndexToView(0))));
        } else {
            jLabelCodigo.setText("");
            jFormattedTextFieldCPF.setText("");
            jTextFieldRG.setText("");
            jTextFieldNome.setText("");
        }

    }

    public void novoReg() {

        status = true;
        jButtonNovo.setEnabled(false);
        jButtonExcluir.setEnabled(false);

        modelTable.insertRow(0, new Object[]{
            visitanteCTR.ultimoReg().getIdVisitante() + 1,
            "",
            "",
            ""});
        jTableVisitante.clearSelection();
        jTableVisitante.addRowSelectionInterval(0, 0);

        jLabelCodigo.setText(String.valueOf(visitanteCTR.ultimoReg().getIdVisitante() + 1));
        jFormattedTextFieldCPF.setText("");
        jTextFieldRG.setText("");
        jTextFieldNome.setText("");

    }

    public void atualizarTabela(int pos) {
        modelTable.setValueAt(jFormattedTextFieldCPF.getText(), pos, 1);
        modelTable.setValueAt(jTextFieldRG.getText(), pos, 2);
        modelTable.setValueAt(jTextFieldNome.getText(), pos, 3);
    }

    public String formatarCpf(String cpf) {
        String cpfForm = "";
        try {
            MaskFormatter formatter = new MaskFormatter("###.###.###-##");
            formatter.setValueContainsLiteralCharacters(false);
            cpfForm = formatter.valueToString(cpf.equals("NULL") ? "" : cpf);
        } catch (ParseException ex) {
            Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cpfForm;
    }

    public void removeTabela(int i) {
        modelTable.removeRow(i);
    }

    public void setjIntFrameVisita(JIntFrameVisita jIntFrameVisita) {
        this.jIntFrameVisita = jIntFrameVisita;
    }
    
}
