import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        // implemente o codigo aqui
        if (!fileName.toLowerCase().endsWith(".txt")) {
            fileName += ".txt";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Digite linhas de texto (digite 'sair' para finalizar):");
            while (true) {
                String line = scanner.nextLine();
                if ("sair".equalsIgnoreCase(line.trim())) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Arquivo '" + fileName + "' criado e conteúdo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}