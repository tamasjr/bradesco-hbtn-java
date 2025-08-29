public class Estoque {
    private String arquivoCSV;

    public Estoque(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
    }

    // java
    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            System.err.println("Nome inválido.");
            return;
        }
        if (quantidade < 0) {
            System.err.println("Quantidade inválida.");
            return;
        }
        if (preco < 0) {
            System.err.println("Preço inválido.");
            return;
        }

        int nextId = 1;

        java.io.File file = new java.io.File(arquivoCSV);
        if (file.exists()) {
            try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    String[] parts = line.split(",", -1);
                    if (parts.length < 1) continue;
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        if (id >= nextId) nextId = id + 1;
                    } catch (NumberFormatException ignore) {}
                }
            } catch (java.io.IOException e) {
                System.err.println("Erro ao ler o arquivo para obter o próximo ID: " + e.getMessage());
            }
        }

        String registro = String.format(java.util.Locale.US, "%d,%s,%d,%.2f",
                nextId, nome.trim(), quantidade, preco);

        try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(file, true))) {
            bw.newLine();
            bw.write(registro);
            System.out.println("Produto adicionado com ID " + nextId + ".");
        } catch (java.io.IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public void excluirProduto(int id) {
        java.io.File file = new java.io.File(arquivoCSV);
        java.util.List<String> outLines = new java.util.ArrayList<>();
        boolean found = false;

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",", -1);
                if (parts.length >= 1) {
                    try {
                        int currentId = Integer.parseInt(parts[0].trim());
                        if (currentId == id) {
                            found = true;
                            continue;
                        }
                    } catch (NumberFormatException ignore) {}
                }
                outLines.add(line);
            }
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + arquivoCSV);
            return;
        } catch (java.io.IOException e) {
            System.err.println("Erro ao ler o arquivo: " + arquivoCSV + " - " + e.getMessage());
            return;
        }

        if (!found) {
            System.out.println("Produto não encontrado.");
            return;
        }

        try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(file, false))) {
            for (int i = 0; i < outLines.size(); i++) {
                bw.write(outLines.get(i));
                if (i < outLines.size() - 1) bw.newLine();
            }
            System.out.println("Produto excluído.");
        } catch (java.io.IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            System.err.println("Quantidade inválida.");
            return;
        }

        java.io.File file = new java.io.File(arquivoCSV);
        java.util.List<String> outLines = new java.util.ArrayList<>();
        boolean updated = false;

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",", -1);
                if (parts.length >= 4) {
                    try {
                        int currentId = Integer.parseInt(parts[0].trim());
                        if (currentId == id) {
                            String newLine = parts[0].trim() + "," + parts[1].trim() + "," + novaQuantidade + "," + parts[3].trim();
                            outLines.add(newLine);
                            updated = true;
                            continue;
                        }
                    } catch (NumberFormatException ignore) {}
                }
                outLines.add(line);
            }
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + arquivoCSV);
            return;
        } catch (java.io.IOException e) {
            System.err.println("Erro ao ler o arquivo: " + arquivoCSV + " - " + e.getMessage());
            return;
        }

        if (!updated) {
            System.out.println("Produto não encontrado.");
            return;
        }

        try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(file, false))) {
            for (int i = 0; i < outLines.size(); i++) {
                bw.write(outLines.get(i));
                if (i < outLines.size() - 1) bw.newLine();
            }
            System.out.println("Quantidade atualizada.");
        } catch (java.io.IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public void exibirEstoque() {
        System.out.println("\n--- Produtos no Estoque ---");
        int count = 0;

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(arquivoCSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",", -1);
                if (parts.length < 4) continue;

                String idStr = parts[0].trim();
                String nome = parts[1].trim();
                String qtdStr = parts[2].trim();
                String precoStr = parts[3].trim();

                try {
                    int id = Integer.parseInt(idStr);
                    int quantidade = Integer.parseInt(qtdStr);
                    double preco = Double.parseDouble(precoStr);

                    System.out.println(String.format(
                            java.util.Locale.US,
                            "ID: %d | Nome: %s | Quantidade: %d | Preço: %.2f",
                            id, nome, quantidade, preco
                    ));
                    count++;
                } catch (NumberFormatException ignore) {
                }
            }
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + arquivoCSV);
            return;
        } catch (java.io.IOException e) {
            System.err.println("Erro ao ler o arquivo: " + arquivoCSV + " - " + e.getMessage());
            return;
        }

        if (count == 0) {
            System.out.println("Estoque vazio.");
        }
    }
}