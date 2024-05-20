import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Documento[] documentos = new Documento[100];
        int quantidadeDocumentos = 0;

        // Leitura dos dados dos documentos
        System.out.println("Digite o número de documentos na pasta (máximo 100):");
        int numDocumentos = scanner.nextInt();

        for (int i = 0; i < numDocumentos; i++) {
            System.out.println("Digite o nome do documento " + (i + 1) + ":");
            String nome = scanner.next();
            System.out.println("Digite o tipo do documento (extensão):");
            String tipo = scanner.next();
            System.out.println("Digite o tamanho do documento em bytes ou kbytes:");
            int tamanho = scanner.nextInt();

            documentos[i] = new Documento(nome, tipo, tamanho);
            quantidadeDocumentos++;
        }

        // Informações solicitadas
        int tamanhoMaximo = Integer.MIN_VALUE;
        int somaTamanhos = 0;
        int quantidadeTipo = 0;

        for (int i = 0; i < quantidadeDocumentos; i++) {
            Documento doc = documentos[i];
            somaTamanhos += doc.getTamanho();

            if (doc.getTamanho() > tamanhoMaximo) {
                tamanhoMaximo = doc.getTamanho();
            }

            if (doc.getTipo().equalsIgnoreCase("txt")) {
                quantidadeTipo++;
            }
        }

        System.out.println("Dados do documento com maior tamanho:");
        for (int i = 0; i < quantidadeDocumentos; i++) {
            Documento doc = documentos[i];
            if (doc.getTamanho() == tamanhoMaximo) {
                System.out.println("Nome: " + doc.getNome());
                System.out.println("Tipo: " + doc.getTipo());
                System.out.println("Tamanho: " + doc.getTamanho());
                break; // Saída do loop após encontrar o documento com maior tamanho
            }
        }

        System.out.println("Soma dos tamanhos de todos os documentos: " + somaTamanhos);
        System.out.println("Quantidade de documentos do tipo TXT: " + quantidadeTipo);
    }
}