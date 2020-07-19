## spring-boot-metrics
Projeto para teste do uso do Spring Boot com Actuator, Micrometer, Prometheus e Grafana. Esta POC foi baseada nos artigos do autor Felipe da Rosa nos links abaixo:

 [Link Parte 1] - Monitorando uma aplicação Spring Boot (2.x) utilizando Actuator, Micrometer, Prometheus e Grafana (1ª Parte — Actuator) 
 [Link Parte 2] - Monitorando uma aplicação Spring Boot (2.x) utilizando Actuator, Micrometer, Prometheus e Grafana (2ª Parte — Prometheus e Grafana) 

Será usado aqui as seguintes tecnologias/frameworks/ferramentas:

* Spring Boot
* MongoDB
* Actuator
* Micrometer
* Grafana
* Prometheus

## Passos para execução

Configurar a url de conexão do mongo no arquivo application.yml no caminho:
```sh
spring.data.mongodb.uri
```
Ter instalado o grafana (máquina ou via docker). Para maiores detalhes, usar o link: [Guide Installation Grafana] 

Entrar na pasta onde foi descompatado o grafana e iniciar o comando (no meu caso linux):
```sh
./grafana-server
```

Realizar o teste chamado a url ./grafana-server


Ter instalado o Prometheus (máquina ou via docker). Para maiores detalhes, usar o link: [Guide Installation Prometheus]

Utilizar o arquivo prometheus.yml que se encontra no resources/prometheus.yml e colocar no diretório onde foi descompatado a pasta do prometheus .

Entrar na pasta onde foi descompatado o prometheus e iniciar o comando (no meu caso linux): 
```sh
./prometheus --config.file=prometheus.yml
```
## API's

A seguir as Api's disponíveis no projeto. Path:

```sh
localhost:8087
```


| Verbo Http | Path | Descrição |
| ------     | ---- | ----------|
| GET | /client | Lista todos os clientes. |
| GET | /client/{id} | Lista o cliente pelo id informado | 
| POST| /client | Salva um cliente |
| DELETE | /client/{id}  | Deleta um client pelo id informado |

## Execução das métricas com Actuator, Prometheus e Grafana

Subi a aplicação
Verificar as opções disponíveis usando o actuator

```sh
http://localhost:8087/actuator
```
 As opções são:
 
 ```sh
http://localhost:8087/actuator
http://localhost:8087/actuator/beans
http://localhost:8087/actuator/caches/{cache}
http://localhost:8087/actuator/caches
http://localhost:8087/actuator/health
http://localhost:8087/actuator/health/{*path}
http://localhost:8087/actuator/info
http://localhost:8087/actuator/conditions
http://localhost:8087/actuator/configprops
http://localhost:8087/actuator/env/{toMatch}
http://localhost:8087/actuator/loggers
http://localhost:8087/actuator/loggers/{name}
http://localhost:8087/actuator/heapdump
http://localhost:8087/actuator/threaddump
http://localhost:8087/actuator/prometheus
http://localhost:8087/actuator/metrics/{requiredMetricName}
http://localhost:8087/actuator/metrics
http://localhost:8087/actuator/scheduledtasks
http://localhost:8087/actuator/mappings
```
 

Executar a aplicação usando as apis para que seja possível gerar as métricas




[Link Parte 1]: <https://medium.com/projuristech/monitorando-uma-aplica%C3%A7%C3%A3o-spring-boot-2-x-cef826ae793c>
[Link Parte 2]: <https://medium.com/projuristech/monitorando-uma-aplica%C3%A7%C3%A3o-spring-boot-2-x-fc939257db8e>
[Guide Installation Grafana]: <https://grafana.com/docs/grafana/latest/installation/debian/#2-start-the-server>
[Guide Installation Prometheus]: <https://prometheus.io/docs/prometheus/latest/getting_started/>
   
