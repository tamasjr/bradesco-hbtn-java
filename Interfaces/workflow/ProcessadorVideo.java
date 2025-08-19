import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private List<CanalNotificacao> canais = new ArrayList<>();

    public void registrarCanal(CanalNotificacao canal) {
        canais.add(canal);
    }

    public void processar(Video video) {
        String texto = video.getArquivo() + " - " + video.getFormato();
        Mensagem mensagem = new Mensagem(texto, TipoMensagem.LOG);
        for (CanalNotificacao canal : canais) {
            canal.notificar(mensagem);
        }
    }
}