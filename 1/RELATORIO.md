# Relatório - Roteiro 1: Threads em Java

Aluno: Gabriel Pedrosa do Carmo Nonato

## Parte A

```java
public class AtendimentoThread extends Thread {
    int idCliente;

    public void run() {
        System.out.println(
                getName() +
                        " atendendo cliente " +
                        idCliente);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var t = new AtendimentoThread();
        t.start();
        t.join();
    }
}
```

Saída:

```text
Thread-0 atendendo cliente 0
```

Pergunta:

> O tempo total ficou perto de 1s ou de 5s com 5 atendimentos? Por quê?

Resposta:

Ficou perto de 1 segundo, isso porque o código cria apenas uma thread e, com isso, o tempo é de somente 1 segundo. Caso fossem criadas 5 threads, criando 5 instâncias de `AtendimentoThread`, o resultado também seria próximo de 1 segundo, pois cada thread dormiria 1 segundo em paralelo.

## Parte B

```java
public class AtendimentoRunnable implements Runnable {
    int idCliente;

    public void run() {
        System.out.println("atendendo cliente " + idCliente);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Runnable r = new AtendimentoRunnable();
        new Thread(r, "Atendente-1").start();
    }
}
```

Saída:

```text
atendendo cliente 0
```

Pergunta:

> Qual das duas classes (Parte A ou B) você poderia fazer herdar de outra classe hoje?

Resposta:

A classe da Parte B, `AtendimentoRunnable`, pode herdar de outra classe, pois ela apenas implementa `Runnable`. A classe da Parte A já herda de `Thread` e não poderia herdar de outra classe.

## Parte C

```java
public class MuitasThreads {
    public static void main(String[] args) throws InterruptedException {
        int total = 10_000;
        Thread[] threads = new Thread[total];

        for (int i = 0; i < total; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads[i].start();
        }

        for (var t : threads) {
            t.join();
        }
    }
}
```

Saída:

```text
O programa foi executado sem erros e não exibiu saída no terminal.
```

Pergunta:

> Por que criar uma thread de SO é mais caro do que criar um objeto comum em Java?

Resposta:

Criar uma thread é mais caro porque ela usa memória e recursos do sistema operacional. Um objeto comum em Java é mais simples e não usa esses recursos.

Pergunta:

> O que esse limite sugere sobre usar 1 thread por requisição em um servidor web?

Resposta:

Isso mostra que criar uma thread para cada requisição pode dar problema se chegarem muitos pedidos ao mesmo tempo. O servidor pode ficar sem memória ou atingir o limite de threads.

## Parte D

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtendimentoExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            int idCliente = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() +
                        " atendendo cliente " + idCliente);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
}
```

Saída:

```text
pool-1-thread-2 atendendo cliente 1
pool-1-thread-3 atendendo cliente 2
pool-1-thread-4 atendendo cliente 3
pool-1-thread-1 atendendo cliente 0
pool-1-thread-1 atendendo cliente 6
pool-1-thread-2 atendendo cliente 4
pool-1-thread-4 atendendo cliente 5
pool-1-thread-3 atendendo cliente 7
pool-1-thread-1 atendendo cliente 8
pool-1-thread-2 atendendo cliente 9
```

Pergunta:

> Com 4 threads atendendo 10 clientes, o tempo total ficou perto de 1s, 2s ou 3s?

Resposta:

O tempo total ficou perto de 3 segundos. Porque temos 4 threads para atender 10 clientes. No primeiro segundo, 4 são atendidos; no segundo, mais 4; e no terceiro, os últimos 2. As mesmas threads são reutilizadas, evitando criar uma thread nova para cada cliente.
