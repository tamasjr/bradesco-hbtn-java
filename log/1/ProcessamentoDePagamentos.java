import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

public class ProcessamentoDePagamentos {
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i <= 5; i++) {
            logger.info("Iniciando o processamento do pagamento " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            int status = random.nextInt(3);
            switch (status) {
                case 0:
                    logger.info("Pagamento " + i + " processado com sucesso.");
                    break;
                case 1:
                    logger.error("Erro ao processar o pagamento " + i + ": Falha na transação.");
                    break;
                case 2:
                    logger.warn("Pagamento " + i + " está pendente. Aguardando confirmação.");
                    break;
            }
        }
        logger.info("Processamento de pagamentos concluído.");
    }
}
