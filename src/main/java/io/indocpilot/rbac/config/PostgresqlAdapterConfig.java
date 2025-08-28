package io.indocpilot.rbac.config;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.casbin.adapter.JDBCAdapter;
import org.casbin.jcasbin.persist.Adapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PostgresqlAdapterConfig {

  /** Dependencies */
  public final DataSource dataSource;

  @Bean
  @SneakyThrows
  public Adapter getAdapter() {
    return new JDBCAdapter(dataSource);
  }
}
