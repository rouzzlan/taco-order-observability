# Instructions

## Packaging

run

```sh
gradle bootBuildImage
```

this will build and tag image to a docker container with for example following
name `harbour.739.net/library/taco-order:0.0.1-SNAPSHOT`

## Grafana

available at [http://localhost:3000](http://localhost:3000). Login `user/password`.

#### Logs

in `Grafana` go to `Ecplore` and select `Loki`. run query
```text
{container_name="/taco-order-service"}
```

### Health with Spring Actuator

```sh
http :9010/actuator/health
```

#### readiness

The readiness state of a Spring Boot application indicates whether it’s ready to accept
traffic and process new requests. During the startup phase or graceful shutdown, the
application is not ready and will refuse any requests. It might also become temporarily
not ready if, at some point, it’s overloaded. When it’s not ready, Kubernetes will not
send any traffic to the application instance.

```sh
http :9010/actuator/health/readiness
```

#### liveness

The liveness state of a Spring Boot application indicates whether it’s in a correct or
broken internal state. If the Spring application context has started successfully, the
internal state is valid. It doesn’t depend on any external components. Otherwise, it
will cause cascading failures, since Kubernetes will try to restart the broken instances.

```sh
http :9010/actuator/health/liveness
```

#### Prometheus

```sh
http :9010/actuator/prometheus
```

or

```sh
http :9010/actuator/prometheus \
  'Accept:application/openmetrics-text; version=1.0.0; charset=utf-8'
```

in `Grafana` go to `Ecplore` and select `Prometheus`. run query
```text
jvm_memory_used_bytes{application="taco-order-service"}
```