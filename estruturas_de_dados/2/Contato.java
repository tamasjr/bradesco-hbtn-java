import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contato {
    private List<String> telefones;
    private Set<String> emails;

    public Contato(String telefone, String email) {

        this.telefones = new ArrayList<>();
        this.emails = new HashSet<>();
        this.telefones.add(telefone);
        this.emails.add(email);
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void adicionarTelefone(String telefone) {
        telefones.add(telefone);
    }

    public boolean adicionarEmail(String email) {
        return emails.add(email);
    }
}
