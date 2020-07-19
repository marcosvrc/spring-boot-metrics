
# spring-boot-metrics
Projeto para teste do uso do Spring Boot com Actuator, Micrometer, Prometheus e Grafana.

POC baseada nos artigos

Monitorando uma aplicação Spring Boot (2.x) utilizando Actuator, Micrometer, Prometheus e Grafana (1ª Parte — Actuator)
https://medium.com/projuristech/monitorando-uma-aplica%C3%A7%C3%A3o-spring-boot-2-x-cef826ae793c

Monitorando uma aplicação Spring Boot (2.x) utilizando Actuator, Micrometer, Prometheus e Grafana (2ª Parte — Prometheus e Grafana)
https://medium.com/projuristech/monitorando-uma-aplica%C3%A7%C3%A3o-spring-boot-2-x-fc939257db8e

Será usado aqui as seguintes tecnologias/frameworks/ferramentas:

 1. Spring Boot
 2. MongoDB
 3. Actuator
 4. Micrometer
 5. Grafana
 6. Prometheus

Passos para execução 

 1. Configurar a url de conexão do mongo no arquivo application.yml no caminho spring.data.mongodb.uri
 2. Ter instalado o grafana (máquina ou via docker) - [https://grafana.com/docs/grafana/latest/installation/debian/#2-start-the-server](https://grafana.com/docs/grafana/latest/installation/debian/#2-start-the-server)
 3. Ter instalado o Prometheus (máquina ou via docker) - [https://prometheus.io/docs/prometheus/latest/getting_started/](https://prometheus.io/docs/prometheus/latest/getting_started/)
 4. Utilizar o arquivo prometheus.yml que se encontra no resources/prometheus.yml e colocar no diretório onde foi descompatado a pasta do prometheus .
 5. Para executar o prometheus basta usar o comando (linux): 
    ./prometheus --config.file=prometheus.yml. Usar as apis do controller. Path: localhost:8087
 
 8. [ ] [GET]:    /client - Lista todos os clientes
 9. [ ] [GET]:    /client/{id} - Lista o cliente pelo id informado
 10. [ ] [POST]:   /client - Salva um cliente
 11. [ ] [DELETE]: /client/{id} - Deleta um client pelo id informado
 12. List item
