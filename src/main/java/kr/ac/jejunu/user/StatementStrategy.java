package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {

    public PreparedStatement getPreparedStatement(Connection connection) throws SQLException;

//        PreparedStatement preparedStatement;
//        preparedStatement = connection.prepareStatement("delete from userinfo where id=?");
//        preparedStatement.setLong(1, id);
//        return preparedStatement;

}