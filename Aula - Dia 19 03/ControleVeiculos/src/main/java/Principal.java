import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Veiculo[] veiculos = new Veiculo[3];

        lerDadosVeiculos(veiculos, scanner);
        aumentarKmVeiculo(veiculos, scanner);
        calcularValores(veiculos);
        mostrarVeiculosModelo(veiculos, scanner);

        scanner.close();
    }

    public static void lerDadosVeiculos(Veiculo[] veiculos, Scanner scanner) {
        for (int i = 0; i < veiculos.length; i++) {
            Veiculo veiculo = new Veiculo();

            System.out.println("Veículo " + (i + 1) + ":");
            System.out.print("Marca: ");
            veiculo.setMarca(scanner.nextLine());

            System.out.print("Modelo: ");
            veiculo.setModelo(scanner.nextLine());

            System.out.print("Ano: ");
            veiculo.setAno(scanner.nextInt());

            System.out.print("Kilometragem: ");
            veiculo.setKm(scanner.nextInt());

            System.out.print("Valor de venda: ");
            veiculo.setValorVenda(scanner.nextDouble());

            veiculos[i] = veiculo;
            scanner.nextLine();
        }
    }

    public static void aumentarKmVeiculo(Veiculo[] veiculos, Scanner scanner) {
        System.out.println("\nInforme o modelo do veículo que viajou:");
        String modeloViajou = scanner.nextLine();

        System.out.println("Informe a quantidade de kilometragem percorrida:");
        int kmPercorrido = scanner.nextInt();

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modeloViajou)) {
                veiculo.aumentarKm(kmPercorrido);
                System.out.println("Kilometragem atualizada para o veículo " + veiculo.getModelo() + ": " + veiculo.getKm() + " km");
                break;
            }
        }
    }

    public static void calcularValores(Veiculo[] veiculos) {
        double maiorValorVenda = veiculos[0].getValorVenda();
        double menorValorVenda = veiculos[0].getValorVenda();
        int maiorKm = veiculos[0].getKm();
        int menorKm = veiculos[0].getKm();
        double somaValorVenda = veiculos[0].getValorVenda();

        for (int i = 1; i < veiculos.length; i++) {
            double valorVendaAtual = veiculos[i].getValorVenda();
            int kmAtual = veiculos[i].getKm();

            if (valorVendaAtual > maiorValorVenda) {
                maiorValorVenda = valorVendaAtual;
            }
            if (valorVendaAtual < menorValorVenda) {
                menorValorVenda = valorVendaAtual;
            }
            if (kmAtual > maiorKm) {
                maiorKm = kmAtual;
            }
            if (kmAtual < menorKm) {
                menorKm = kmAtual;
            }

            somaValorVenda += valorVendaAtual;
        }

        double valorMedioVenda = somaValorVenda / veiculos.length;

        System.out.println("\nVeículo com maior valor de venda: " + maiorValorVenda);
        System.out.println("Veículo com menor valor de venda: " + menorValorVenda);
        System.out.println("Veículo com maior kilometragem: " + maiorKm + " km");
        System.out.println("Veículo com menor kilometragem: " + menorKm + " km");
        System.out.println("Valor médio de venda para todos os veículos: " + valorMedioVenda);
    }

    public static void mostrarVeiculosModelo(Veiculo[] veiculos, Scanner scanner) {
        System.out.println("\nInforme o modelo de veículo que deseja procurar:");
        String modeloProcurado = scanner.nextLine();

        boolean encontrado = false;
        System.out.println("Veículos do modelo " + modeloProcurado + ":");
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modeloProcurado)) {
                System.out.println("- " + veiculo.getMarca() + " " + veiculo.getModelo());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum veículo do modelo " + modeloProcurado + " foi encontrado.");
        }
    }
}