import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura= new Scanner(System.in);

        int saldoAtual = 0;
        int valorRecebido;
        int valorRetirado;
        int opcao = 0;
        String nome = "";
        String mensagem;
        String mensagemMenu= """
                Por favor digite uma opção:
                1 - Saldo
                2 - Receber Valor
                3 - Transferir Valor
                4 - Dados da conta
                5 - Sair
                """;


        while(true) {
            while(nome == "") {
                System.out.println("***************** BANCO JAVA SCRIPT *****************\n");
                System.out.println("Por Favor digite o seu nome para a abertura da conta:");
                nome = leitura.nextLine();
                System.out.println("Agora digite o valor do seu primeiro depósito sem pontos ou vírgulas:");
                valorRecebido = leitura.nextInt();
                saldoAtual += valorRecebido;
                System.out.println("Parabéns!! Você acaba de abrir sua conta e fazer seu primeiro depósito.");
                System.out.println("Seja bem vindo ao nosso banco!\nVou informar os dados de sua conta abaixo.\n");
                mensagem = """
                        ********************************
                        Cliente:           %s
                        Agência:           0001
                        Conta:             12345-6
                        Tipo de conta:     Corrente
                        Saldo:             R$ %d
                        ********************************
                        """.formatted(nome, saldoAtual);
                System.out.println(mensagem);
            }
            System.out.println(mensagemMenu);
            opcao = leitura.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Seu saldo atual é R$ " + saldoAtual + "\n");
                    break;

                case 2:
                    System.out.println("Por favor digite o valor que irá receber:");
                    valorRecebido = leitura.nextInt();
                    saldoAtual +=valorRecebido;
                    System.out.println("Valor recebido com Sucesso!\n");
                    break;

                case 3:
                    System.out.println("Por favor digite o valor que irá transferir:");
                    valorRetirado = leitura.nextInt();
                    while (valorRetirado > saldoAtual) {
                        System.out.println("O valor que deseja retirar é superior ao seu saldo!");
                        System.out.println("Seu saldo disponível para transferências é de: R$" + saldoAtual);
                        System.out.println("Digite um novo valor para transferir: ");
                        valorRetirado = leitura.nextInt();
                    }
                    saldoAtual -= valorRetirado;
                    System.out.println("Transferência realizada com Sucesso!\n");
                    break;

                case 4:
                    mensagem = """
                ********************************
                Cliente:           %s
                Agência:           0001
                Conta:             12345-6
                Tipo de conta:     Corrente
                Saldo:             R$ %d
                ********************************
                """.formatted(nome,saldoAtual);

                    System.out.println(mensagem);
                    break;

                case 5:
                    System.out.println("Obrigado por utilizar os nossos serviços\n");
                    leitura.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }

        }

    }
}
