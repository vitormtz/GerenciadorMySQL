package gerenciadormysql.suporte;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor
 */
public class ConexaoBD {

    public void consulta(String query, JTable tabela, JTable saida) {
        long start = System.nanoTime();

        String url = "jdbc:mysql://177.44.248.23:3306/locadora?useSSL=false";
        String user = "root";
        String password = "administrador";

        try ( Connection con = DriverManager.getConnection(url, user, password);  PreparedStatement pst = con.prepareStatement(query);  ResultSet resultadoQ = pst.executeQuery()) {
            new CriacaoTabela().popularTabela(resultadoQ, tabela);
            con.close();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(ConexaoBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        long end = System.nanoTime();
        long time = (end - start);
        double seconds = (double) time / 1_000_000_000.0;

        DefaultTableModel tableModel = new DefaultTableModel();
        Object[] row = new Object[5];

        tableModel.addColumn("#");
        tableModel.addColumn("Tempo");
        tableModel.addColumn("Ação");
        tableModel.addColumn("Mensagem");
        tableModel.addColumn("Duração");

        for (int i = 0; i < saida.getRowCount(); i++) {
            for (int j = 0; j < row.length; j++) {
                row[j] = saida.getValueAt(i, j);
            }
            tableModel.addRow(row);
        }

        row[0] = saida.getRowCount() + 1;
        row[1] = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        row[2] = query;
        row[3] = tabela.getModel().getRowCount() + " lines fetched";;
        row[4] = String.format("%.3f", seconds).replace(',', '.') + " sec";
        tableModel.addRow(row);

        saida.setModel(tableModel);

        saida.getColumnModel().getColumn(0).setMaxWidth(50);
        saida.getColumnModel().getColumn(1).setMaxWidth(75);
        saida.getColumnModel().getColumn(4).setMaxWidth(75);
    }
}
