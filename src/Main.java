import javafx.animation.PauseTransition;
import javafx.scene.paint.Stop;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner ler = new Scanner(System.in);
        Loading carregar = new Loading();
        CalculoCedulas calcular = new CalculoCedulas();
        LimparConsole limpar = new LimparConsole();


        //menu

        for(int contmenu = 0;contmenu<1;contmenu--){

            LimparConsole.Limpar();
            System.out.print("Escolha uma opção: \n"+
                    "1 - Sacar\n" +
                    "2 - Depositar\n" +
                    "3 - Sair\n\n"+
                    "Infome o numero a frente de sua escolha: "
            );

            int opcao = ler.nextInt();

            switch (opcao){

                case 1:
                    for( int j = 0;j<1;j--) {
                        System.out.println("Infome o valor para o saque: ");
                        double saque = ler.nextDouble();
                        System.out.println("Voce deseja receber o valor em cedulas maiores ou menores?\n" +
                                "1 - Maiores\n" +
                                "2 - Menores\n");
                        int tiposaque = ler.nextInt();
                        if (tiposaque != 1 && tiposaque != 2) {
                            System.out.println("Voce inseriu uma resposta invalida!");
                            continue;
                        } else {//loading
                            carregar.carregar();

                            //Estrutura para calcular a quantidade de notas e imprimir na tela
                            calcular.calcular(saque, tiposaque);

                            System.out.println("\nConfirmar recebimento:\n" +
                                    "1 - Sim" +
                                    "    2 - Não\n");
                            int confirmar = ler.nextInt();
                            if (confirmar == 1) {
                                // futuramente decrementar da quant de cedulas
                                break;
                            }
                            else {
                                continue;
                            }
                        }
                    }
                case 2:

                    break;

                case 3:
                    System.exit(1);

                default:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.flush();
                    System.out.println("Atenção!\nVoce inseriu uma opção invalida. Por favor\n"+
                            "Informe o numero a frente da sua opção escolhida\n\n");

            }
        }
        //Fim Menu
    }
}