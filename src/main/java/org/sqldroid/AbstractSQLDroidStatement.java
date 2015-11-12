package org.sqldroid;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Date: 11/12/15
 * Time: 5:25 AM
 *
 * @author Mikhail Kulikov
 */
public abstract class AbstractSQLDroidStatement implements Statement {

    @Override
    public void setMaxRows(int max) throws SQLException {
        if (isClosed()) {
            throw new SQLException("Statement is closed.");
        } else if (max < 0) {
            throw new SQLException("Max rows must be zero or positive. Got " + max);
        } else if (max == 0) {
            setMaxRowsInner(null);
        } else {
            setMaxRowsInner(max);
        }
    }

    protected abstract void setMaxRowsInner(Integer max);

}
