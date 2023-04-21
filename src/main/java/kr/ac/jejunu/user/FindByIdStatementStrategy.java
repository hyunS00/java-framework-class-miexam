package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FindByIdStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement getPreparedStatement(Object object, Connection connection) throws SQLException {
        Long id = (Long)object;
        PreparedStatement preparedStatement = connection.prepareStatement("select id, name, password from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}