/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.VisitaCTR;
import control.VisitadoCTR;
import control.VisitanteCTR;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import model.domain.EmpresaVisitante;
import model.domain.Visitado;
import model.domain.Visitante;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author anderson
 */
public class JIntFrameRelVisita extends javax.swing.JInternalFrame {

    private VisitanteCTR visitanteCTR;
    private VisitaCTR visitaCRT;
    private VisitadoCTR visitadoCTR;

    /**
     * Creates new form JIntFrameRelVisita
     */
    public JIntFrameRelVisita() {
        initComponents();

        jXDatePickerDataInicial.setDate(new Date());
        jXDatePickerDataFinal.setDate(new Date());
        visitanteCTR = new VisitanteCTR();
        visitaCRT = new VisitaCTR();
        visitadoCTR = new VisitadoCTR();

        visitaCRT.carregListaEmpresa();

        preencherVisitante();
        preencherEmpresa();
        preencherVisitado();

        DocumentFilter filter = new UppercaseDocumentFilter();
        ((AbstractDocument) ((JTextField) jComboBoxVisitante.getEditor().getEditorComponent()).getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) ((JTextField) jComboBoxEmpresa.getEditor().getEditorComponent()).getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) ((JTextField) jComboBoxVisitado.getEditor().getEditorComponent()).getDocument()).setDocumentFilter(filter);

        AutoCompleteDecorator.decorate(jComboBoxVisitante);
        AutoCompleteDecorator.decorate(jComboBoxEmpresa);
        AutoCompleteDecorator.decorate(jComboBoxVisitado);

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

        jLabelDataInicial = new javax.swing.JLabel();
        jLabelDataFinal = new javax.swing.JLabel();
        jXDatePickerDataInicial = new org.jdesktop.swingx.JXDatePicker();
        jXDatePickerDataFinal = new org.jdesktop.swingx.JXDatePicker();
        jLabelVisitante = new javax.swing.JLabel();
        jComboBoxVisitante = new javax.swing.JComboBox<>();
        jLabelEmpresa = new javax.swing.JLabel();
        jComboBoxEmpresa = new javax.swing.JComboBox<>();
        jComboBoxVisitado = new javax.swing.JComboBox<>();
        jButtonImprimir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelVisitado = new javax.swing.JLabel();

        setClosable(true);
        setTitle("FILTRO DE RELATÓRIO DE VISITA");
        setMinimumSize(new java.awt.Dimension(400, 350));
        setPreferredSize(new java.awt.Dimension(400, 350));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelDataInicial.setText("DATA INICIAL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jLabelDataInicial, gridBagConstraints);

        jLabelDataFinal.setText("DATA FINAL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jLabelDataFinal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        getContentPane().add(jXDatePickerDataInicial, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(jXDatePickerDataFinal, gridBagConstraints);

        jLabelVisitante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisitante.setText("VISITANTE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        getContentPane().add(jLabelVisitante, gridBagConstraints);

        jComboBoxVisitante.setEditable(true);
        jComboBoxVisitante.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jComboBoxVisitante, gridBagConstraints);

        jLabelEmpresa.setText("EMPRESA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        getContentPane().add(jLabelEmpresa, gridBagConstraints);

        jComboBoxEmpresa.setEditable(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jComboBoxEmpresa, gridBagConstraints);

        jComboBoxVisitado.setEditable(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jComboBoxVisitado, gridBagConstraints);

        jButtonImprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonImprimir.setText("IMPRIMIR");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        getContentPane().add(jButtonImprimir, gridBagConstraints);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        getContentPane().add(jButtonCancelar, gridBagConstraints);

        jLabelVisitado.setText("VISITADO:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        getContentPane().add(jLabelVisitado, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:

        dispose();

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        // TODO add your handling code here:

        try {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dataInicial = format.format(jXDatePickerDataInicial.getDate());
            String dataFinal = format.format(jXDatePickerDataFinal.getDate());

            Visitante visitante = visitanteCTR.getVisitante(jComboBoxVisitante.getSelectedIndex() - 1);
            EmpresaVisitante empresaVisitante = visitaCRT.getEmpresa(jComboBoxEmpresa.getSelectedIndex() - 1);
            Visitado visitado = visitadoCTR.getVisitado(jComboBoxVisitado.getSelectedIndex() - 1);

            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(visitaCRT.getVisitaRelList(visitante, empresaVisitante, visitado, dataInicial, dataFinal));

            Map parametros = new HashMap();

            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream("./ireport/visitaReport.jasper"), parametros, ds);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
            
        } catch (Exception ex) {
            Logger.getLogger(JIntFramePainelVisitante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JComboBox<String> jComboBoxEmpresa;
    private javax.swing.JComboBox<String> jComboBoxVisitado;
    private javax.swing.JComboBox<String> jComboBoxVisitante;
    private javax.swing.JLabel jLabelDataFinal;
    private javax.swing.JLabel jLabelDataInicial;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelVisitado;
    private javax.swing.JLabel jLabelVisitante;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerDataFinal;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerDataInicial;
    // End of variables declaration//GEN-END:variables

    public void preencherVisitante() {
        jComboBoxVisitante.addItem("TODOS");
        visitanteCTR.getVisitanteList()
                .sort((v1, v2) -> v1.getNomeVisitante().compareTo(v2.getNomeVisitante()));
        visitanteCTR.getVisitanteList()
                .forEach((v) -> {
                    jComboBoxVisitante.addItem(v.getNomeVisitante());
                });
    }

    public void preencherEmpresa() {
        jComboBoxEmpresa.addItem("TODOS");
        visitaCRT.getEmpresaList().forEach((e) -> {
            jComboBoxEmpresa.addItem(e.getNomeEmpresa());
        });
    }

    public void preencherVisitado() {
        jComboBoxVisitado.addItem("TODOS");
        visitadoCTR.getVisitadoList()
                .sort((vdo1, vdo2) -> vdo1.getNomeVisitado().compareTo(vdo2.getNomeVisitado()));
        visitadoCTR.getVisitadoList()
                .forEach((vdo) -> {
                    jComboBoxVisitado.addItem(vdo.getNomeVisitado());
                });
    }

}
