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
