package mybatis.config;

import mybatis.dao.BookDao;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Mybatisconfig {
    public SqlSessionFactory getSqlSessionFactory(){
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis_basic");
        dataSource.setUsername("root");
        dataSource.setPassword("Ace0828yc@");
        Configuration configuration = new Configuration();
        configuration.setEnvironment(new Environment("development",
                new JdbcTransactionFactory(), dataSource));
        configuration.addMapper(BookDao.class);

        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
