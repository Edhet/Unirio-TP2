class Funcionario {
    protected String nome;
    protected double salarioBruto, descontoIR;

    public Funcionario(String nome, double salarioBruto) {
        setNome(nome);
        setSalarioBruto(salarioBruto);
    }

    public double getSalarioLiquido() {
        return salarioBruto - descontoIR;
    }

    public String getNome() {
        return nome;
    }


    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = (salarioBruto > 0) ? salarioBruto : 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Estagiario extends Funcionario {
    public Estagiario(String nome, double salarioBruto) {
        super(nome, salarioBruto);
        descontoIR = 0;
    }
}

class Vendedor extends Funcionario {
    private double faixaIR, percentualBonus, valorBonus;

    public Vendedor(String nome, double salarioBruto, double faixaIR, double percentualBonus) {
        super(nome, salarioBruto);
        setFaixaIR(faixaIR);
        setPercentualBonus(percentualBonus);
        calcularBonusEIR();
    }

    public void calcularBonusEIR() {
        valorBonus = salarioBruto * percentualBonus;
        salarioBruto += valorBonus;
        descontoIR = salarioBruto * faixaIR;
    }

    public void setPercentualBonus(double percentualBonus) {
        this.percentualBonus = clamp(percentualBonus, 0.0, 1.0);
    }

    public void setFaixaIR(double faixaIR) {
        this.faixaIR = clamp(faixaIR, 0.0, 1.0);
    }

    // 😈
    private <T extends Comparable<T>> T clamp(T value, T min, T max) {
        if (value.compareTo(min) < 0)
            return min;
        else if (value.compareTo(min) > 0)
            return max;
        else
            return value;
    }
}
