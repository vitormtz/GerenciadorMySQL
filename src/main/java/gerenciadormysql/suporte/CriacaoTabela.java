package gerenciadormysql.suporte;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor
 */
public class CriacaoTabela {

    public void popularTabela(ResultSet resultadoQ, JTable tabela) throws SQLException {

        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSetMetaData metaData = resultadoQ.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        Object[] row = new Object[columnCount];

        while (resultadoQ.next()) {
            for (int i = 0; i < columnCount; i++) {
                row[i] = resultadoQ.getObject(i + 1);
            }
            tableModel.addRow(row);
        }
        tabela.setModel(tableModel);
    }
}
