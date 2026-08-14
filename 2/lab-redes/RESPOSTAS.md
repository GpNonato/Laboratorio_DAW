# Respostas - Roteiro 2

## Parte A - TCP

### Pergunta 1

O que acontece se você iniciar o cliente antes do servidor? Por quê?

Resposta:

O cliente mostra erro de conexão recusada. Isso acontece porque o servidor ainda não está rodando na porta 5042 para aceitar a conexão. No TCP, o cliente precisa se conectar ao servidor antes de enviar as mensagens.

### Pergunta 2

Qual mecanismo do TCP garante que as mensagens cheguem na ordem?

Resposta:

O TCP usa números de sequência para organizar as mensagens na ordem certa. Se alguma mensagem não chegar, ele também consegue pedir o reenvio.

### Pergunta 3

O que acontece se dois clientes tentarem se conectar ao mesmo tempo? O código atual suporta isso?

Resposta:

O código atual não suporta dois clientes ao mesmo tempo. O servidor usa apenas um `accept()`, então ele aceita um cliente, atende esse cliente e depois encerra. Para atender vários clientes, seria necessário usar um laço para aceitar novas conexões.

### Evidências de teste

#### Java

Servidor:

![Servidor TCP em Java](evidencias/tcp/tcp-java-servidor.png)

Cliente:

![Cliente TCP em Java](evidencias/tcp/tcp-java-cliente.png)

#### Python

Servidor:

![Servidor TCP em Python](evidencias/tcp/tcp-python-servidor.png)

Cliente:

![Cliente TCP em Python](evidencias/tcp/tcp-python-cliente.png)

## Parte B - UDP

### Pergunta 1

O que aconteceu quando você enviou uma mensagem com o servidor desligado? Compare com o que aconteceria em TCP.

Resposta:

Com o servidor desligado, o cliente envia a mensagem, mas não recebe resposta. Isso acontece porque o UDP não cria uma conexão antes de enviar os dados. No TCP, o cliente mostraria erro de conexão recusada, pois ele precisa se conectar ao servidor antes de enviar a mensagem.

### Pergunta 2

Cite dois exemplos de aplicações reais que usam UDP e explique o motivo.

Resposta:

Um exemplo é o DNS, pois ele precisa responder rápido e uma pequena perda de pacote pode ser resolvida fazendo outra consulta. Outro exemplo são jogos online, pois é mais importante receber a informação mais recente rapidamente do que esperar uma informação antiga chegar.

### Pergunta 3

O servidor UDP não mantém registro de quem está conectado. Isso seria possível?

Resposta:

Seria possível guardar o endereço IP e a porta dos clientes que enviaram mensagens. Mesmo assim, o UDP continuaria sem conexão, pois o servidor apenas guardaria os dados de quem já mandou alguma mensagem.

### Evidências de teste

#### Java

Servidor:

![Servidor UDP em Java](evidencias/udp/udp-java-servidor.png)

Cliente:

![Cliente UDP em Java](evidencias/udp/udp-java-cliente.png)

#### Python

Servidor:

![Servidor UDP em Python](evidencias/udp/udp-python-servidor.png)

Cliente:

![Cliente UDP em Python](evidencias/udp/udp-python-cliente.png)
