# Instructions

## Packaging

run
```sh
gradle bootBuildImage
```
this will build and tag image to a docker container with for example following name `harbour.739.net/library/taco-order:0.0.1-SNAPSHOT`


## Grafana
available at [http://localhost:3000](http://localhost:3000).

### Health with Spring Actuator

```sh
http :9010/actuator/health
```