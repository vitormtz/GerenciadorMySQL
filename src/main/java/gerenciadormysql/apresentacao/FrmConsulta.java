package gerenciadormysql.apresentacao;

import gerenciadormysql.suporte.ConexaoBD;

/**
 *
 * @author vitor
 */
public class FrmConsulta extends javax.swing.JFrame {

    /**
     * Creates new form FrmConsulta
     */
    public FrmConsulta() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(this.getSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGerenciamento = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        scrpnQuery = new javax.swing.JScrollPane();
        txtarQuery = new javax.swing.JTextArea();
        scrpnResultado = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        scrpnSaida = new javax.swing.JScrollPane();
        tblSaida = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GerenciadorMySQL");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtarQuery.setColumns(20);
        txtarQuery.setRows(5);
        scrpnQuery.setViewportView(txtarQuery);

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblResultado.setToolTipText("");
        tblResultado.setEnabled(false);
        scrpnResultado.setViewportView(tblResultado);

        tblSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSaida.setToolTipText("");
        tblSaida.setEnabled(false);
        scrpnSaida.setViewportView(tblSaida);

        javax.swing.GroupLayout pnlGerenciamentoLayout = new javax.swing.GroupLayout(pnlGerenciamento);
        pnlGerenciamento.setLayout(pnlGerenciamentoLayout);
        pnlGerenciamentoLayout.setHorizontalGroup(
            pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrpnSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
                    .addComponent(scrpnQuery)
                    .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrpnResultado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlGerenciamentoLayout.setVerticalGroup(
            pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrpnQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrpnResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(scrpnSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGerenciamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGerenciamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (!txtarQuery.getText().isBlank()) {
            new ConexaoBD().consulta(txtarQuery.getText(), tblResultado, tblSaida);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JPanel pnlGerenciamento;
    private javax.swing.JScrollPane scrpnQuery;
    private javax.swing.JScrollPane scrpnResultado;
    private javax.swing.JScrollPane scrpnSaida;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTable tblSaida;
    private javax.swing.JTextArea txtarQuery;
    // End of variables declaration//GEN-END:variables
}
