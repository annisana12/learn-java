package todolist.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {
    @Test
    void testConnection() throws SQLException {
        HikariDataSource dataSource = DatabaseUtil.getHikariDataSource();
        Connection connection = dataSource.getConnection();

        connection.close();
        dataSource.close();
    }
}
