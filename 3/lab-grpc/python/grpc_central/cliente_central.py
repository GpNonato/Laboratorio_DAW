import grpc

import central_pb2
import central_pb2_grpc

OFFSET = 42
PORTA = 50061 + OFFSET


def main():
    canal = grpc.insecure_channel(f"localhost:{PORTA}")
    stub = central_pb2_grpc.CentralAtendimentoStub(canal)

    nome = input("Digite seu nome: ")

    resposta = stub.ConsultarHorario(central_pb2.PerguntaHorario(nome_aluno=nome))
    print(f"[gRPC] {resposta.mensagem}")


if __name__ == "__main__":
    main()