package io.indocpilot.rbac.config;

import java.nio.file.Path;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.casbin.jcasbin.main.Enforcer;
import org.casbin.jcasbin.persist.Adapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EnforcerConfig {

  /** Dependencies */
  private final Adapter adapter;

  @Bean
  @SneakyThrows
  public Enforcer getEnforcer() {
    return new Enforcer(
        Path.of(ClassLoader.getSystemResource("casbin/model.conf").toURI()).toString(), adapter);
  }
}
