/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Tipo;
import model.dao.TipoDAO;

/**
 *
 * @author Bernardo
 */
public class TelaCadastroTipo extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadastroTipo
     */
    public TelaCadastroTipo() {
        initComponents();
        readJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelnome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();
        jBAtualizar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTipo = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabelnome.setText("Nome");

        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBAtualizar.setText("Atualizar");
        jBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarActionPerformed(evt);
            }
        });

        BtExcluir.setText("Excluir");
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelnome)
                        .addGap(29, 29, 29)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jBAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(BtExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAtualizar)
                    .addComponent(BtExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTTipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codtip", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTipoMouseClicked(evt);
            }
        });
        jTTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTipoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTTipo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        // TODO add your handling code here:
        
        Tipo t = new Tipo();
        TipoDAO dao =new TipoDAO();

        t.setNome(txtNome.getText());
        dao.create(t);
        
        txtNome.setText("");
        readJTable();
        
        
        
//        DefaultTableModel dtmTipo = (DefaultTableModel) jTTipo.getModel();
//        Object[] dados = {txtNome.getText()};      
//        dtmTipo.addRow(dados);
        
        
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
        // TODO add your handling code here:
        if(jTTipo.getSelectedRow()!=-1){   
             Tipo t = new Tipo();
             TipoDAO dao =new TipoDAO();

             t.setNome(txtNome.getText());
             t.setCodtip(Integer.parseInt(jTTipo.getValueAt(jTTipo.getSelectedRow(), 0).toString()));
             dao.update(t);
             
             jTTipo.setValueAt(txtNome.getText(), jTTipo.getSelectedRow(), 1);
             txtNome.setText("");
             readJTable();
        }
    }//GEN-LAST:event_jBAtualizarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        // TODO add your handling code here:
        
        if(jTTipo.getSelectedRow()!=-1){
             Tipo t = new Tipo();
             TipoDAO dao =new TipoDAO();

             t.setCodtip(Integer.parseInt(jTTipo.getValueAt(jTTipo.getSelectedRow(), 0).toString()));
             dao.excluir(t);
            
            
            DefaultTableModel dtmTipo = (DefaultTableModel) jTTipo.getModel();
            dtmTipo.removeRow(jTTipo.getSelectedRow()); 
        }
        

    }//GEN-LAST:event_BtExcluirActionPerformed

    private void jTTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTipoMouseClicked
        // TODO add your handling code here:
        if(jTTipo.getSelectedRow()!=-1){            
            txtNome.setText(jTTipo.getValueAt(jTTipo.getSelectedRow(), 1).toString());            
        }else{
            JOptionPane.showMessageDialog(null,"Selecione!!!!");
        }
        
    }//GEN-LAST:event_jTTipoMouseClicked
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTTipo.getModel();
        modelo.setNumRows(0);
        TipoDAO dao = new TipoDAO();
        
        for(Tipo t : dao.read()){
            modelo.addRow(new Object[]{
                t.getCodtip(),
                t.getNome()      
            
            });
        }    
    }
    
    private void jTTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTipoKeyReleased
        // TODO add your handling code here:
        if(jTTipo.getSelectedRow()!=-1){
            
            txtNome.setText(jTTipo.getValueAt(jTTipo.getSelectedRow(), 1).toString());
            
        }else{
            JOptionPane.showMessageDialog(null,"Selecione!!!!");
        }
        
    }//GEN-LAST:event_jTTipoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLabelnome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTTipo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
