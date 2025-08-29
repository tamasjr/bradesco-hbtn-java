import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] cols = line.split(",", -1);
                if (cols.length < 4) {
                    continue;
                }

                String nome = cols[0].trim();
                String idade = cols[1].trim();
                String departamento = cols[2].trim();
                String salario = cols[3].trim();

                System.out.println("Funcionário: "+ nome);
                System.out.println("Idade: "+ idade);
                System.out.println("Departamento: "+ departamento);
                System.out.println("Salarial: "+ salario);
                System.out.println("------------------------");
            }
            System.out.println("Leitura do arquivo concluída.");

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: `funcionarios.csv`");
        } catch (IOException e) {
            System.err.println("Erro na leitura do aquivo `funcionarios.csv`: " + e.getMessage());
        }
    }
}