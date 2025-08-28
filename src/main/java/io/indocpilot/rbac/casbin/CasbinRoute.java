package io.indocpilot.rbac.casbin;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class CasbinRoute {

  private final CasbinService casbinService;

  @Bean
  public RouterFunction<ServerResponse> getCasbinRoute() {
    return RouterFunctions.route()
        .GET(
            "/authorize",
            RequestPredicates.accept(MediaType.APPLICATION_JSON),
            request -> {
              val role = request.queryParam("role").orElse("");
              val zone = request.queryParam("zone").orElse("");
              val resource = request.queryParam("resource").orElse("");
              val operation = request.queryParam("operation").orElse("");
              val projectCode = request.queryParam("projectCode").orElse("");

              return casbinService
                  .authorize(role, zone, resource, operation, projectCode)
                  .flatMap(isAuthorized -> ServerResponse.ok().bodyValue(isAuthorized));
            })
        .build();
  }
}
