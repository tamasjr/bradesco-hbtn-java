import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos = new ArrayList<>();

    public static void main (String args[]) {
        GestaoAlunos gestao = new GestaoAlunos();
        gestao.adicionarAluno("Maria", 20);
        gestao.adicionarAluno("João", 22);
        gestao.adicionarAluno("José",36);
        gestao.listarAlunos();
        gestao.buscarAluno("Maria");
        gestao.excluirAluno("José");
        gestao.excluirAluno("Francisco");
        gestao.buscarAluno("João");
        gestao.listarAlunos();
    }

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
        System.out.println("Aluno adicionado: " + nome);
    }

    public void excluirAluno(String nome) {
        boolean removido = alunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Aluno removido: " + nome);
        } else {
            System.out.println("Aluno não encontrado: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado: " + nome);
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de alunos:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }
}