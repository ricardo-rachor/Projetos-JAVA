import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReadWriteExample {

    // Pasta onde os arquivos serão salvos
    private static final String FOLDER_PATH = "Arquivos/";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar ao usuário que digite uma mensagem
            System.out.print("Digite a mensagem que deseja salvar: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.isEmpty()) {
                System.out.println("Nenhuma mensagem fornecida. Saindo...");
                return;
            }

            // Criar um Map com os dados a serem escritos nos arquivos
            Map<String, String> data = new HashMap<>();
            data.put("mensagem", userInput);

            // Caminhos dos arquivos de texto
            String[] fileExtensions = {".txt", ".json", ".xml"};

            // Loop para cada extensão de arquivo
            for (String extension : fileExtensions) {
                String filePath = FOLDER_PATH + "mensagem" + extension;
                // Escrever dados no arquivo com a extensão correspondente
                if (extension.equals(".json")) {
                    writeJsonToFile(filePath, data);
                } else {
                    writeToFile(filePath, userInput);
                }
                // Mensagem de confirmação de escrita
                System.out.println("Mensagem foi salva em: " + filePath);
            }

            // Ler e exibir o conteúdo dos arquivos de texto
            System.out.println("\nConteúdo dos arquivos de texto:");
            for (String extension : fileExtensions) {
                String filePath = FOLDER_PATH + "mensagem" + extension;
                String fileType = extension.equals(".json") ? "JSON" : extension.substring(1).toUpperCase();
                System.out.println("Arquivo " + fileType + ":");
                readFromFile(filePath);
            }

        } catch (IOException e) {
            // Tratamento de exceção mais detalhado
            e.printStackTrace();
        }
    }

    /**
     * Escreve uma mensagem em um arquivo de texto.
     *
     * @param filePath Caminho do arquivo a ser escrito.
     * @param message  Mensagem a ser escrita no arquivo.
     */
    public static void writeToFile(String filePath, String message) throws IOException {
        File folder = new File(FOLDER_PATH);
        // Verifica se o diretório existe, se não, cria
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // Escreve a mensagem no arquivo de texto
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(message);
            System.out.println("Mensagem escrita com sucesso no arquivo de texto: " + filePath);
        }
    }

    /**
     * Escreve um Map de dados em um arquivo JSON.
     *
     * @param filePath Caminho do arquivo a ser escrito.
     * @param data     Dados a serem escritos no arquivo.
     */
    public static void writeJsonToFile(String filePath, Map<String, String> data) throws IOException {
        // Escreve os dados em formato JSON no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            StringBuilder jsonBuilder = new StringBuilder("{");
            for (Map.Entry<String, String> entry : data.entrySet()) {
                jsonBuilder.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
            }
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1); // Remove a última vírgula
            jsonBuilder.append("}");
            writer.write(jsonBuilder.toString());
            System.out.println("Dados JSON escritos com sucesso no arquivo: " + filePath);
        }
    }

    /**
     * Lê e exibe o conteúdo de um arquivo de texto.
     *
     * @param filePath Caminho do arquivo a ser lido.
     */
    public static void readFromFile(String filePath) throws IOException {
        // Lê o arquivo e exibe seu conteúdo linha por linha
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}







