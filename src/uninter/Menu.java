package uninter;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Cofrinho cofrinho;

    public Menu() {
        scanner = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    private void exibirOpcoesParaAdicionarMoedasEAdicionarAoCofrinho () {
        System.out.println("Escolha a moeda: ");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");

        int opcaoDaMoedaSelecionada = scanner.nextInt();

        System.out.println("Digite o valor: ");
        String valorInseridoPeloUsuario = scanner.next();

        // Substitui a vírgula para melhorar a experiência do usuário
        valorInseridoPeloUsuario = valorInseridoPeloUsuario.replace(",", ".");
        double valorDaMoedaFormatado = Double.parseDouble(valorInseridoPeloUsuario);

        Moeda moeda = null;

        if(opcaoDaMoedaSelecionada == 1) {
            moeda = new Real(valorDaMoedaFormatado);
        } else if (opcaoDaMoedaSelecionada == 2) {
            moeda = new Dolar(valorDaMoedaFormatado);
        } else if (opcaoDaMoedaSelecionada == 3) {
            moeda = new Euro(valorDaMoedaFormatado);
        } else {
            System.out.println("Opção de moeda inválida");
            exibirMenu();
            return;
        }

        cofrinho.adicionar(moeda);
        System.out.println("Moeda adicionada com sucesso, continue poupando!");
    }

    private void removerMoeda() {
        //verifica se cofrinho está vazio
        if(cofrinho.verificaSeCofrinhoEstaVazio()) {
            System.out.println("Cofrinho vazio, comece a poupar!");

            exibirMenu();
            return;
        }

        System.out.println("Escolha a moeda: ");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");

        int opcaoDaMoedaSelecionada = scanner.nextInt();

        System.out.println("Digite o valor: ");
        String valorInseridoPeloUsuario = scanner.next();

        // Substitui a vírgula para melhorar a experiência do usuário
        valorInseridoPeloUsuario = valorInseridoPeloUsuario.replace(",", ".");
        double valorDaMoedaFormatado = Double.parseDouble(valorInseridoPeloUsuario);

        Moeda moeda = null;

        if(opcaoDaMoedaSelecionada == 1) {
            moeda = new Real(valorDaMoedaFormatado);
        } else if (opcaoDaMoedaSelecionada == 2) {
            moeda = new Dolar(valorDaMoedaFormatado);
        } else if (opcaoDaMoedaSelecionada == 3) {
            moeda = new Euro(valorDaMoedaFormatado);
        } else {
            System.out.println("Opção de moeda inválida");
            exibirMenu();
            return;
        }

        //verifica se a moeda existe no cofrinho
        if(!cofrinho.verificaSeMoedaExiste(moeda)) {
            System.out.println("Moeda não existe no cofrinho");

            exibirMenu();
            return;
        }

        cofrinho.remover(moeda);
        System.out.println("Moeda retirada, gaste com sabedoria!");
    }

    public void exibirMenu() {
        System.out.println("Cofrinho de Isaac Jordao Brito Santos: ");

        System.out.println("1 - Adicionar moeda: ");
        System.out.println("2 - Remover moeda: ");
        System.out.println("3 - Listar moedas: ");
        System.out.println("4 - Calcular valor total convertido para Real: ");
        System.out.println("0 - Encerrar");

        String opcao = scanner.next();

        System.out.println("Opção escolhida: " + opcao);

        switch (opcao) {
            case "1":
                exibirOpcoesParaAdicionarMoedasEAdicionarAoCofrinho();

                exibirMenu();
                break;
            case "2":
                removerMoeda();

                exibirMenu();
                break;
            case "3":
                cofrinho.listagemDeMoedas();

                exibirMenu();
                break;
            case "4":
                double valorTotalConvertidoParaReal = cofrinho.totalConvertido();
                String valorTotalConvertidoParaString = String.format("%.2f", valorTotalConvertidoParaReal);
                System.out.println("Seu valor total do carrinho convertido para Real é: R$ " + valorTotalConvertidoParaString);

                exibirMenu();
                break;
            case "0":
                System.out.println("Programa encerrado com sucesso!");

                break;
            default:
                System.out.println("Opção inválida");

                // Mostra o menu novamente se a opção for inválida
                exibirMenu();
                break;

        }

    }
}
