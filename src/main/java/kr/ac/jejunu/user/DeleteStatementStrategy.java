package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    private long id;
    public DeleteStatementStrategy(Long id){
        this.id=id;
    }

    @Override
    public PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement =connection.prepareStatement("delete from userinfo where id=?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
