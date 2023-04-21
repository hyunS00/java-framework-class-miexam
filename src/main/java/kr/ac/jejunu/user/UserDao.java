package kr.ac.jejunu.user;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
    public User findById(Long id) throws SQLException {
        StatementStrategy statementStrategy = new FindByIdStatementStrategy(id);
        User user = jdbcContext.jdbcContextForFindById(statementStrategy);
        return user;
    }
    public void insert(User user) throws SQLException {
        StatementStrategy statementStrategy = new InsertStatementStrategy(user);
        jdbcContext.jdbcContextForInsert(user, statementStrategy);
    }
    public void update(User user) {
        StatementStrategy statementStrategy = new UpdateStatementStrategy(user);
        jdbcContext.jdbcCOntextForUpdate(statementStrategy);
    }

    public void delete(Long id) {
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
        jdbcContext.jdbcCOntextForUpdate(statementStrategy);
    }
}
