public class Gerente extends Empregado {
    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double bonusBase = getSalarioFixo() * 0.2;
            double bonusExtra = (departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01;
            return bonusBase + bonusExtra;
        }
        return 0.0;
    }
}