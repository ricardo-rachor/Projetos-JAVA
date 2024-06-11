import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class FileReadWriteExample {

    private static final String IMAGES_FOLDER = "Imagem/images/";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar ao usuário que digite a string Base64 da imagem
            System.out.print("Digite a string Base64 da imagem: ");
            String base64Image = scanner.nextLine().trim();

            if (base64Image.isEmpty()) {
                System.out.println("Nenhuma string Base64 fornecida. Saindo...");
                return;
            }

            // Decodificar a string Base64 para bytes
            byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

            // Salvar a imagem decodificada como arquivo
            String imagePath = IMAGES_FOLDER + "imagem_decodificada.png"; // Você pode mudar a extensão conforme necessário
            writeImageToFile(imagePath, decodedBytes);

            System.out.println("Imagem decodificada salva em: " + imagePath);
        } catch (IOException e) {
            // Tratamento de exceção mais detalhado
            e.printStackTrace();
        }
    }

    /**
     * Escreve dados de imagem em um arquivo.
     *
     * @param filePath Caminho do arquivo de imagem a ser escrito.
     * @param data     Dados de imagem a serem escritos no arquivo.
     */
    public static void writeImageToFile(String filePath, byte[] data) throws IOException {
        // Cria o diretório se não existir
        File folder = new File(IMAGES_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
            System.out.println("Imagem escrita com sucesso: " + filePath);
        }
    }
}

