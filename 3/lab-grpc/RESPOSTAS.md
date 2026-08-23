# Respostas - Roteiro 3

## Parte 4.1

### Pergunta 1

O endereço do servidor (localhost, IP, grupo multicast) está escrito diretamente no código do cliente? Isso favorece ou prejudica a transparência de localização?

Resposta:

No TCP e no UDP, o cliente usa `localhost` no código. No Multicast, o grupo `230.0.0.1` também está no código. No WebSocket, a URL com `localhost` e a porta também estão escritas no cliente. Isso prejudica a transparência de localização, pois o cliente precisa saber onde o servidor está.

### Pergunta 2

Para “perguntar uma coisa” ao servidor, o cliente precisa montar uma string de texto manualmente (e o servidor precisa interpretá-la/fazer parsing)? Isso é meio-termo, presença ou ausência de transparência de acesso?

Resposta:

No TCP, UDP e Multicast, as mensagens são montadas como texto e depois interpretadas pelo outro lado. Isso mostra pouca transparência de acesso, pois o programador precisa pensar em como enviar e ler os dados. No WebSocket isso melhora um pouco, mas ainda são usadas mensagens de texto.

### Pergunta 3

O que aconteceria com o cliente se o servidor mudasse de máquina amanhã? Alguma dessas quatro soluções sobreviveria a essa mudança sem alterar o código-fonte do cliente?

Resposta:

Se o servidor mudasse de máquina, seria preciso trocar o endereço no código do cliente. Do jeito que foram feitas, nenhuma das quatro soluções continuaria funcionando sem alterar o cliente, pois os endereços estão escritos diretamente no código.


## Parte 4.3

### Pergunta 1

Dentre os 8 tipos de transparência listados, qual você diria que é a mais visível para o programador que está usando um serviço remoto (e não construindo a infraestrutura por trás dele)? Justifique.

Resposta:

A transparência de localização é a mais visível. Isso porque, no laboratório anterior, foi necessário escrever no código o endereço do servidor, como `localhost`, IP ou grupo multicast. Se o endereço muda, o cliente também precisa mudar.

### Pergunta 2

Transparência total é sempre desejável? Dê um exemplo (pode ser hipotético) de uma situação em que esconder completamente que uma operação é remota atrapalharia mais do que ajudaria.

Resposta:

Não. Uma operação remota pode demorar mais ou falhar por causa da rede. Se isso ficar totalmente escondido, o programa pode parecer travado e o usuário não vai entender o que aconteceu. Por isso, é importante tratar tempo de espera e erros de conexão.

### Pergunta 3

(Responder depois de concluir as Partes C e D) Comparando o cliente TCP do laboratório anterior com o cliente gRPC que você vai construir agora: qual dos dois exige que você “pense em rede” (sockets, send/receive, parsing de string) e qual permite que você “pense no problema” (chamar uma função e receber um resultado)? A que tipo de transparência isso se relaciona?