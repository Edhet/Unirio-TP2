
class Conta {
    protected double saldo;
    protected int numero;

    public Conta(double saldo, int numero) {
        setSaldo(saldo);
        setNumero(numero);
    }

    public boolean sacarDinheiro(double quantia) {
        if (saldo - quantia <= 0)
            return false;
        saldo -= quantia;
        return true;
    }

    public void depositar(double quantia) {
        saldo += quantia;
    }

    public void setSaldo(double saldo) {
        this.saldo = (saldo > 0) ? saldo : 0;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }
}

class ContaPoupanca extends Conta {
    private double percentualRendimento;

    public ContaPoupanca(double saldo, int numero, double percentualRendimento) {
        super(saldo, numero);
        setPercentualRendimento(percentualRendimento);
    }

    public void render() {
        saldo += saldo * percentualRendimento;
    }

    public void setPercentualRendimento(double percentualRendimento) {
        this.percentualRendimento = clamp(percentualRendimento, 0.0, 1.0);
    }

    private <T extends Comparable<T>> T clamp(T value, T min, T max) {
        if (value.compareTo(min) < 0)
            return min;
        else if (value.compareTo(min) > 0)
            return max;
        else
            return value;
    }
}

class ContaEspecial extends Conta {
    private double limiteEspecial;

    public ContaEspecial(double saldo, int numero, double limiteEspecial) {
        super(saldo, numero);
        setLimiteEspecial(limiteEspecial);
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = (limiteEspecial > 0) ? limiteEspecial : 0;
        this.saldo += this.limiteEspecial;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }
}
