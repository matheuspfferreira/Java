import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {

        // Declaração de Variáveis
        String nome = "Matheus Ferreira", tipoConta = "Corrente";
        float saldoAtual = 1500.00f;
        boolean continar = true;

        // Tela Inicial
        System.out.println("************************************************");
        System.out.println("Nome:                " + nome);
        System.out.println("Tipo de conta:       " + tipoConta);
        System.out.println("Saldo inicial:       " + "R$ " + saldoAtual);
        System.out.println("************************************************ \n\n");

        // Execução do Programa
        while (continar) {

            Scanner leitura = new Scanner(System.in);
            int operacao;

            // Menu Principal
            String menu = """
                    1 - Consultar saldo
                    2 - Receber valor
                    3 - Transferir valor
                    4 - Sair \n
                    """;
            System.out.println("Operacões \n");
            System.out.println(menu);
            System.out.println("Digite a operação desejada: ");
            operacao = leitura.nextInt();

            switch (operacao) {

                case 1:
                    System.out.println("Saldo bancário atual: R$ " + saldoAtual + "\n");
                    break;

                case 2:
                    float valorRecebido;
                    System.out.println("Digite o valor a ser recebido");
                    valorRecebido = leitura.nextFloat();
                    saldoAtual += valorRecebido;
                    System.out.println("Recebimento concluído com sucesso \n");
                    break;

                case 3:
                    boolean realizarTransferencia = true;
                    while (realizarTransferencia) {
                        float valorTransferido;
                        int resposta;
                        System.out.println("Digite o valor a ser transferido: ");
                        valorTransferido = leitura.nextFloat();
                        boolean transferenciaPossivel = saldoAtual >= valorTransferido;
                        if (transferenciaPossivel) {
                            saldoAtual -= valorTransferido;
                            System.out.println("Transferência realizada com sucesso \n");
                            realizarTransferencia = false;
                        } else {
                            System.out.println("A transferência não pode ser realizada \n");
                            System.out.println("Deseja tentar outro valor (0 ou 1): ");
                            resposta = leitura.nextInt();
                            switch (resposta) {
                                case 0:
                                    realizarTransferencia = false;
                                    break;
                                case 1:
                                    break;
                                default:
                                    System.out.println("Apenas os valores 0 e 1 são aceitos \n");
                                    realizarTransferencia = false;
                                    break;
                            }
                        }
                    }
                    break;

                case 4:
                    continar = false;
                    break;

                default:
                    System.out.println("Operação inválida \n");
                    break;

            }
        }
    }
}