package kr.ac.jejunu.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    String name = "hulk";
    String password = "1234";
    public static UserDao userDao;
    @BeforeAll
    public static void setup(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1l;
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
        userDao.insert(user);
        assertThat(user.getId(),greaterThan(0L));
        User insertUser = userDao.findById(user.getId());
        assertThat(insertUser.getName(), is(user.getName()));
        assertThat(insertUser.getPassword(), is(user.getPassword()));
    }
}
