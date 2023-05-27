class JurosSimples {
    protected Double capital;
    protected Double taxaDeJuros;
    protected Double tempo;

    public JurosSimples(Double capital, Double taxaDeJuros, Double tempo) {
        setCapital(capital);
        setTaxaDeJuros(taxaDeJuros);
        setTempo(tempo);
    }

    public Double calcularJuros() {
        return (capital == null || taxaDeJuros == null || tempo == null) ? null : capital * taxaDeJuros * tempo;
    }

    public void setCapital(double capital) {
        if (capital > 0)
            this.capital = capital;
    }

    public void setTaxaDeJuros(double taxaDeJuros) {
        if (taxaDeJuros > 0 && taxaDeJuros < 1)
            this.taxaDeJuros = taxaDeJuros;
    }

    public void setTempo(double tempo) {
        if (tempo > 0)
            this.tempo = tempo;
    }

    public double getCapital() {
        return capital;
    }

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public double getTempo() {
        return tempo;
    }
}

class JurosComposto extends JurosSimples {
    public JurosComposto(Double capital, Double taxaDeJuros, Double tempo) {
        super(capital, taxaDeJuros, tempo);
    }

    @Override
    public Double calcularJuros() {
        return (capital == null || taxaDeJuros == null || tempo == null) ? null : capital * Math.pow(1 + taxaDeJuros, tempo) - capital;
    }
}
