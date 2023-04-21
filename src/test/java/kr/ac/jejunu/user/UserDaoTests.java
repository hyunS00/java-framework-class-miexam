package kr.ac.jejunu.user;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    String name = "hulk";
    String password = "1234";
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        UserDao userDao = new UserDao();
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        userDao.insert(user);
        assertThat(user.getId(),greaterThan(0L));
        User insertUser = userDao.findById(user.getId());
        assertThat(insertUser.getName(), is(user.getName()));
        assertThat(insertUser.getPassword(), is(user.getPassword()));
    }
}