package com.capg.hollywood.healthcheck;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import static com.capg.hollywood.utils.MovieUtils.*;


@Component
public class DatabaseHealthCheck implements HealthIndicator, HealthContributor {

@Autowired
private DataSource ds;

@Override
public Health health() {
try(Connection conn = ds.getConnection()){
Statement stmt = conn.createStatement();
stmt.execute(SQLSELECTSTATEMENT);
} catch (SQLException ex) {
return Health.down().withDetail(BACKEND_CALL, "Service is not working").withException(ex).build();
}
return Health.up().withDetail(BACKEND_CALL,"Service is working").build();
}
}
