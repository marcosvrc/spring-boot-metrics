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

Testar a execução chamado a url:

```sh
http://localhost:3000/
user: admin | password: admin
```

Deve ser exibida a imagem conforme mostrado abaixo:

![alt text](https://github.com/marcosvrc/imagens_readme/blob/master/spring-boot-metrics/Grafana_executando.png)

Ter instalado o Prometheus (máquina ou via docker). Para maiores detalhes, usar o link: [Guide Installation Prometheus]

Utilizar o arquivo prometheus.yml que se encontra no resources/prometheus.yml e colocar no diretório onde foi descompatado a pasta do prometheus .

Entrar na pasta onde foi descompatado o prometheus e iniciar o comando (no meu caso linux): 
```sh
./prometheus --config.file=prometheus.yml
```

Deve ser exibida a imagem conforme mostrado abaixo:

![alt text](https://github.com/marcosvrc/imagens_readme/blob/master/spring-boot-metrics/Prometheus_Executando.png)

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

Subi a aplicação e verificar as opções disponíveis usando o actuator

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
 
 ## Métricas utilizadas pelo Prometheus
 
 Ao usar o path abaixo, é possível verificar quais métricas disponíveis para utilização
 
```sh
http://localhost:8087/actuator/prometheus
```

```sh
# HELP jvm_gc_memory_promoted_bytes_total Count of positive increases in the size of the old generation memory pool before GC to after GC
# TYPE jvm_gc_memory_promoted_bytes_total counter
jvm_gc_memory_promoted_bytes_total 2170800.0
# HELP jvm_memory_used_bytes The amount of used memory
# TYPE jvm_memory_used_bytes gauge
jvm_memory_used_bytes{area="nonheap",id="CodeHeap 'profiled nmethods'",} 1.6031104E7
jvm_memory_used_bytes{area="heap",id="G1 Survivor Space",} 2.097152E7
jvm_memory_used_bytes{area="heap",id="G1 Old Gen",} 4309504.0
jvm_memory_used_bytes{area="nonheap",id="Metaspace",} 5.040788E7
jvm_memory_used_bytes{area="nonheap",id="CodeHeap 'non-nmethods'",} 1295360.0
jvm_memory_used_bytes{area="heap",id="G1 Eden Space",} 2.11812352E8
jvm_memory_used_bytes{area="nonheap",id="Compressed Class Space",} 6154344.0
jvm_memory_used_bytes{area="nonheap",id="CodeHeap 'non-profiled nmethods'",} 5143424.0
# HELP jvm_threads_daemon_threads The current number of live daemon threads
# TYPE jvm_threads_daemon_threads gauge
jvm_threads_daemon_threads 18.0
# HELP jvm_memory_max_bytes The maximum amount of memory in bytes that can be used for memory management
# TYPE jvm_memory_max_bytes gauge
jvm_memory_max_bytes{area="nonheap",id="CodeHeap 'profiled nmethods'",} 1.22912768E8
jvm_memory_max_bytes{area="heap",id="G1 Survivor Space",} -1.0
jvm_memory_max_bytes{area="heap",id="G1 Old Gen",} 4.169138176E9
jvm_memory_max_bytes{area="nonheap",id="Metaspace",} -1.0
jvm_memory_max_bytes{area="nonheap",id="CodeHeap 'non-nmethods'",} 5832704.0
jvm_memory_max_bytes{area="heap",id="G1 Eden Space",} -1.0
jvm_memory_max_bytes{area="nonheap",id="Compressed Class Space",} 1.073741824E9
jvm_memory_max_bytes{area="nonheap",id="CodeHeap 'non-profiled nmethods'",} 1.22912768E8
# HELP jvm_gc_max_data_size_bytes Max size of old generation memory pool
# TYPE jvm_gc_max_data_size_bytes gauge
jvm_gc_max_data_size_bytes 4.169138176E9
# HELP jvm_buffer_total_capacity_bytes An estimate of the total capacity of the buffers in this pool
# TYPE jvm_buffer_total_capacity_bytes gauge
jvm_buffer_total_capacity_bytes{id="mapped",} 0.0
jvm_buffer_total_capacity_bytes{id="direct",} 81920.0
# HELP jvm_threads_live_threads The current number of live threads including both daemon and non-daemon threads
# TYPE jvm_threads_live_threads gauge
jvm_threads_live_threads 22.0
# HELP system_cpu_count The number of processors available to the Java virtual machine
# TYPE system_cpu_count gauge
system_cpu_count 4.0
# HELP jvm_threads_states_threads The current number of threads having NEW state
# TYPE jvm_threads_states_threads gauge
jvm_threads_states_threads{state="runnable",} 7.0
jvm_threads_states_threads{state="blocked",} 0.0
jvm_threads_states_threads{state="waiting",} 11.0
jvm_threads_states_threads{state="timed-waiting",} 4.0
jvm_threads_states_threads{state="new",} 0.0
jvm_threads_states_threads{state="terminated",} 0.0
# HELP tomcat_sessions_rejected_sessions_total  
# TYPE tomcat_sessions_rejected_sessions_total counter
tomcat_sessions_rejected_sessions_total 0.0
# HELP process_start_time_seconds Start time of the process since unix epoch.
# TYPE process_start_time_seconds gauge
process_start_time_seconds 1.595166524412E9
# HELP tomcat_sessions_alive_max_seconds  
# TYPE tomcat_sessions_alive_max_seconds gauge
tomcat_sessions_alive_max_seconds 0.0
# HELP jvm_memory_committed_bytes The amount of memory in bytes that is committed for the Java virtual machine to use
# TYPE jvm_memory_committed_bytes gauge
jvm_memory_committed_bytes{area="nonheap",id="CodeHeap 'profiled nmethods'",} 2.0119552E7
jvm_memory_committed_bytes{area="heap",id="G1 Survivor Space",} 2.097152E7
jvm_memory_committed_bytes{area="heap",id="G1 Old Gen",} 1.70917888E8
jvm_memory_committed_bytes{area="nonheap",id="Metaspace",} 5.2477952E7
jvm_memory_committed_bytes{area="nonheap",id="CodeHeap 'non-nmethods'",} 2555904.0
jvm_memory_committed_bytes{area="heap",id="G1 Eden Space",} 2.70532608E8
jvm_memory_committed_bytes{area="nonheap",id="Compressed Class Space",} 6946816.0
jvm_memory_committed_bytes{area="nonheap",id="CodeHeap 'non-profiled nmethods'",} 5767168.0
# HELP system_cpu_usage The "recent cpu usage" for the whole system
# TYPE system_cpu_usage gauge
system_cpu_usage 0.18597560975609756
# HELP process_cpu_usage The "recent cpu usage" for the Java Virtual Machine process
# TYPE process_cpu_usage gauge
process_cpu_usage 7.035647279549719E-4
# HELP process_uptime_seconds The uptime of the Java virtual machine
# TYPE process_uptime_seconds gauge
process_uptime_seconds 14784.167
# HELP jvm_gc_pause_seconds Time spent in GC pause
# TYPE jvm_gc_pause_seconds summary
jvm_gc_pause_seconds_count{action="end of minor GC",cause="Metadata GC Threshold",} 1.0
jvm_gc_pause_seconds_sum{action="end of minor GC",cause="Metadata GC Threshold",} 0.024
jvm_gc_pause_seconds_count{action="end of minor GC",cause="G1 Evacuation Pause",} 2.0
jvm_gc_pause_seconds_sum{action="end of minor GC",cause="G1 Evacuation Pause",} 0.042
# HELP jvm_gc_pause_seconds_max Time spent in GC pause
# TYPE jvm_gc_pause_seconds_max gauge
jvm_gc_pause_seconds_max{action="end of minor GC",cause="Metadata GC Threshold",} 0.0
jvm_gc_pause_seconds_max{action="end of minor GC",cause="G1 Evacuation Pause",} 0.0
# HELP jvm_gc_live_data_size_bytes Size of old generation memory pool after a full GC
# TYPE jvm_gc_live_data_size_bytes gauge
jvm_gc_live_data_size_bytes 4276176.0
# HELP jvm_buffer_memory_used_bytes An estimate of the memory that the Java virtual machine is using for this buffer pool
# TYPE jvm_buffer_memory_used_bytes gauge
jvm_buffer_memory_used_bytes{id="mapped",} 0.0
jvm_buffer_memory_used_bytes{id="direct",} 81920.0
# HELP tomcat_sessions_expired_sessions_total  
# TYPE tomcat_sessions_expired_sessions_total counter
tomcat_sessions_expired_sessions_total 0.0
# HELP http_server_requests_seconds  
# TYPE http_server_requests_seconds summary
http_server_requests_seconds_count{exception="None",method="DELETE",outcome="SUCCESS",status="204",uri="/client/{id}",} 10.0
http_server_requests_seconds_sum{exception="None",method="DELETE",outcome="SUCCESS",status="204",uri="/client/{id}",} 0.168899127
http_server_requests_seconds_count{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/client",} 5.0
http_server_requests_seconds_sum{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/client",} 0.149545212
http_server_requests_seconds_count{exception="None",method="POST",outcome="CLIENT_ERROR",status="404",uri="/**",} 1.0
http_server_requests_seconds_sum{exception="None",method="POST",outcome="CLIENT_ERROR",status="404",uri="/**",} 0.00261472
http_server_requests_seconds_count{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",} 919.0
http_server_requests_seconds_sum{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",} 3.613955916
http_server_requests_seconds_count{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/metrics",} 2.0
http_server_requests_seconds_sum{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/metrics",} 0.010520176
http_server_requests_seconds_count{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/client/{id}",} 1.0
http_server_requests_seconds_sum{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/client/{id}",} 0.010902844
http_server_requests_seconds_count{exception="HttpMessageNotReadableException",method="POST",outcome="CLIENT_ERROR",status="400",uri="/client",} 1.0
http_server_requests_seconds_sum{exception="HttpMessageNotReadableException",method="POST",outcome="CLIENT_ERROR",status="400",uri="/client",} 0.00397457
http_server_requests_seconds_count{exception="None",method="POST",outcome="SUCCESS",status="200",uri="/client",} 4.0
http_server_requests_seconds_sum{exception="None",method="POST",outcome="SUCCESS",status="200",uri="/client",} 8.764055502
http_server_requests_seconds_count{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator",} 3.0
http_server_requests_seconds_sum{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator",} 0.023511768
http_server_requests_seconds_count{exception="None",method="GET",outcome="CLIENT_ERROR",status="404",uri="/**",} 1.0
http_server_requests_seconds_sum{exception="None",method="GET",outcome="CLIENT_ERROR",status="404",uri="/**",} 0.014083789
# HELP http_server_requests_seconds_max  
# TYPE http_server_requests_seconds_max gauge
http_server_requests_seconds_max{exception="None",method="DELETE",outcome="SUCCESS",status="204",uri="/client/{id}",} 0.0
http_server_requests_seconds_max{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/client",} 0.0
http_server_requests_seconds_max{exception="None",method="POST",outcome="CLIENT_ERROR",status="404",uri="/**",} 0.0
http_server_requests_seconds_max{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",} 0.009711023
http_server_requests_seconds_max{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/metrics",} 0.0
http_server_requests_seconds_max{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/client/{id}",} 0.0
http_server_requests_seconds_max{exception="HttpMessageNotReadableException",method="POST",outcome="CLIENT_ERROR",status="400",uri="/client",} 0.0
http_server_requests_seconds_max{exception="None",method="POST",outcome="SUCCESS",status="200",uri="/client",} 0.0
http_server_requests_seconds_max{exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator",} 0.0
http_server_requests_seconds_max{exception="None",method="GET",outcome="CLIENT_ERROR",status="404",uri="/**",} 0.0
# HELP tomcat_sessions_active_max_sessions  
# TYPE tomcat_sessions_active_max_sessions gauge
tomcat_sessions_active_max_sessions 0.0
# HELP logback_events_total Number of error level events that made it to the logs
# TYPE logback_events_total counter
logback_events_total{level="warn",} 1.0
logback_events_total{level="debug",} 0.0
logback_events_total{level="error",} 0.0
logback_events_total{level="trace",} 0.0
logback_events_total{level="info",} 11.0
# HELP jvm_gc_memory_allocated_bytes_total Incremented for an increase in the size of the young generation memory pool after one GC to before the next
# TYPE jvm_gc_memory_allocated_bytes_total counter
jvm_gc_memory_allocated_bytes_total 4.37256192E8
# HELP jvm_threads_peak_threads The peak live thread count since the Java virtual machine started or peak was reset
# TYPE jvm_threads_peak_threads gauge
jvm_threads_peak_threads 22.0
# HELP jvm_classes_unloaded_classes_total The total number of classes unloaded since the Java virtual machine has started execution
# TYPE jvm_classes_unloaded_classes_total counter
jvm_classes_unloaded_classes_total 0.0
# HELP tomcat_sessions_active_current_sessions  
# TYPE tomcat_sessions_active_current_sessions gauge
tomcat_sessions_active_current_sessions 0.0
# HELP tomcat_sessions_created_sessions_total  
# TYPE tomcat_sessions_created_sessions_total counter
tomcat_sessions_created_sessions_total 0.0
# HELP process_files_max_files The maximum file descriptor count
# TYPE process_files_max_files gauge
process_files_max_files 1048576.0
# HELP jvm_classes_loaded_classes The number of classes that are currently loaded in the Java virtual machine
# TYPE jvm_classes_loaded_classes gauge
jvm_classes_loaded_classes 10105.0
# HELP jvm_buffer_count_buffers An estimate of the number of buffers in the pool
# TYPE jvm_buffer_count_buffers gauge
jvm_buffer_count_buffers{id="mapped",} 0.0
jvm_buffer_count_buffers{id="direct",} 10.0
# HELP system_load_average_1m The sum of the number of runnable entities queued to available processors and the number of runnable entities running on the available processors averaged over a period of time
# TYPE system_load_average_1m gauge
system_load_average_1m 0.57
# HELP process_files_open_files The open file descriptor count
# TYPE process_files_open_files gauge
process_files_open_files 84.0
```

## Utilização do Prometheus

Com o Prometheus rodando, é possível usar umas das métricas acima criando gráficos (clicar na aba Graph)

![alt text](https://github.com/marcosvrc/imagens_readme/blob/master/spring-boot-metrics/Executando_Prometheus_Query.png)

## Utilização do Grafana

Com o Grafana rodando, é possível criar dashboards utilizando das métricas geradas pelo micrometer juntamante com o Prometheus. Para maiores detalhes da conexão entre o Grafana e o Prometheus, olhar o artigo mencionando logo no começo desta documentação.

Adicionando Painel no Grafana

![alt text](https://github.com/marcosvrc/imagens_readme/blob/master/spring-boot-metrics/Grafana_adicionando_panel.png)

Montando Query no Grafana

![alt text](https://github.com/marcosvrc/imagens_readme/blob/master/spring-boot-metrics/Grafana_montando_painel_query.png)

Exibindo os dashboards no Grafana

![alt text](https://github.com/marcosvrc/imagens_readme/blob/master/spring-boot-metrics/Grafana_dashboards.png)


[Link Parte 1]: <https://medium.com/projuristech/monitorando-uma-aplica%C3%A7%C3%A3o-spring-boot-2-x-cef826ae793c>
[Link Parte 2]: <https://medium.com/projuristech/monitorando-uma-aplica%C3%A7%C3%A3o-spring-boot-2-x-fc939257db8e>
[Guide Installation Grafana]: <https://grafana.com/docs/grafana/latest/installation/debian/#2-start-the-server>
[Guide Installation Prometheus]: <https://prometheus.io/docs/prometheus/latest/getting_started/>
   
