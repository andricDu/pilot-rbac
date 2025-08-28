package io.indocpilot.rbac.casbin;

import lombok.RequiredArgsConstructor;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CasbinService {

  private final Enforcer enforcer;

  public Mono<Boolean> authorize(
      String role, String zone, String resource, String operation, String projectCode) {
    return Mono.fromCallable(
            () -> enforcer.enforce(role, zone, resource, operation, projectCode));
  }
}
