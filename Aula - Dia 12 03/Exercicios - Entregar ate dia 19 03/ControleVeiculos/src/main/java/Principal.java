import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Veiculo[] veiculos = new Veiculo[3];

        lerDadosVeiculos(veiculos, scanner);
        aumentarKmVeiculos(veiculos, scanner);
        ordenarPorKm(veiculos);
        mostrarMenorKm(veiculos);

    }

    public static void lerDadosVeiculos(Veiculo[] veiculos, Scanner scanner) {
        for (int i = 0; i < 3; i++) {
            Veiculo veiculo = new Veiculo();

            System.out.println("Veículo " + (i + 1) + ":");
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Ano: ");
            int ano = scanner.nextInt();
            while (ano < 1950 || ano > 2024) {
                System.out.println("Ano inválido. Digite novamente: ");
                ano = scanner.nextInt();
            }
            System.out.print("Kilometragem: ");
            int km = scanner.nextInt();
            while (km <= 0) {
                System.out.println("Kilometragem inválida. Digite novamente: ");
                km = scanner.nextInt();

            }

            //Cria objetos Veiculo com os dados fornecidos e os armazena na matriz veiculos.
            veiculo.def_dados(marca, modelo, ano, km);
            veiculos[i] = veiculo;
            scanner.nextLine();
        }
    }

    public static void aumentarKmVeiculos(Veiculo[] veiculos, Scanner scanner) {
        System.out.println("\nInforme o aumento de kilometragem:");
        //Itera sobre a matriz de veículos e aumenta a quilometragem de cada veículo pelo valor informado.
        int aumento = scanner.nextInt();
        for (Veiculo veiculo : veiculos) {
            veiculo.aumentar_km(aumento);
        }
    }

    public static void ordenarPorKm(Veiculo[] veiculos) {
        //Classifica os veículos com base em sua quilometragem, usando o algoritmo de ordenação Bubble Sort.
        for (int i = 0; i < veiculos.length - 1; i++) {
            for (int j = 0; j < veiculos.length - i - 1; j++) {
                if (veiculos[j].ret_km() > veiculos[j + 1].ret_km()) {
                    Veiculo temp = veiculos[j];
                    veiculos[j] = veiculos[j + 1];
                    veiculos[j + 1] = temp;
                }
            }
        }
    }

    public static void mostrarMenorKm(Veiculo[] veiculos) {
        System.out.println("\nVeículo com a menor kilometragem:");
        //Exibe os dados do veículo com a menor quilometragem, que está armazenado na primeira posição da matriz de veículos após a ordenação.
        veiculos[0].mostrar_dados();
    }
}