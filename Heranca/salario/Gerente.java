public class Gerente extends Empregado {
    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            return getSalarioFixo() * 0.2;
        }
        return 0.0;
    }
}