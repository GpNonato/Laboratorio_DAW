# Respostas - Roteiro 3

## Parte 4.1

### Pergunta 1

O endereço do servidor (localhost, IP, grupo multicast) está escrito diretamente no código do cliente? Isso favorece ou prejudica a transparência de localização?

Resposta:




### Pergunta 2

Para “perguntar uma coisa” ao servidor, o cliente precisa montar uma string de texto manualmente (e o servidor precisa interpretá-la/fazer parsing)? Isso é meio-termo, presença ou ausência de transparência de acesso?

Resposta:



### Pergunta 3

O que aconteceria com o cliente se o servidor mudasse de máquina amanhã? Alguma dessas quatro soluções sobreviveria a essa mudança sem alterar o código-fonte do cliente?

Resposta:





Depois de implementar as Partes C e D deste roteiro (gRPC), volte a este exercício e complemente sua resposta comparando com o que você observou usando RPC - essa comparação é justamente a Pergunta 3 da seção 4.3.


## Parte 4.3

### Pergunta 1

Dentre os 8 tipos de transparência listados, qual você diria que é a mais visível para o programador que está usando um serviço remoto (e não construindo a infraestrutura por trás dele)? Justifique.
### Pergunta 2

Transparência total é sempre desejável? Dê um exemplo (pode ser hipotético) de uma situação em que esconder completamente que uma operação é remota atrapalharia mais do que ajudaria (dica: pense em desempenho ou em tratamento de falhas).
### Pergunta 3

(Responder depois de concluir as Partes C e D) Comparando o cliente TCP do laboratório anterior com o cliente gRPC que você vai construir agora: qual dos dois exige que você “pense em rede” (sockets, send/receive, parsing de string) e qual permite que você “pense no problema” (chamar uma função e receber um resultado)? A que tipo de transparência isso se relaciona?