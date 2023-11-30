package kr.co.mpago.util;



import javax.sql.DataSource;

import org.apache.catalina.startup.SetContextPropertiesRule;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mariadb.jdbc.Driver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import kr.co.mpago.mapper.MemberMapper;
import net.sf.log4jdbc.log.log4j2.Log4j2SpyLogDelegator;

public class DBUtils {
	
	private static TransactionFactory transactionFactory() {
		return new JdbcTransactionFactory();
	}
	
    public static DataSource dataSource() {
    	HikariConfig config = new HikariConfig();
    	config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
    	config.setJdbcUrl("jdbc:log4jdbc:mariadb://mpago.co.kr:3306/moving");
    	config.setUsername("kht");
    	config.setPassword("1234");
    	config.setMinimumIdle(1);
//    	config.setMaximumPoolSize(1);
    	config.setConnectionTimeout(3000);
    	config.setValidationTimeout(3000);
    	config.setMaxLifetime(30000);
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
    
    public static SqlSessionFactory sqlSessionFactory() {
        Environment environment = new Environment("moving", transactionFactory(), dataSource());
        Configuration configuration = new Configuration(environment);
        configuration.addMappers("kr.co.mpago.mapper"); 

        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
