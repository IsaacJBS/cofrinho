package uninter;

public class Dolar extends Moeda{
    public Dolar(double valorInicial) {
        this.valor = valorInicial;
    }

    @Override
    public void info() {
        System.out.println("Dolar - US$ " + valor);
    }

    @Override
    public double converter() {
        return this.valor * 4.85;
    }

    // Sobrescrevendo o método equals da classe Object para comparar dois objetos do tipo Dolar pelo valor
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Dolar) {
            Dolar dolar = (Dolar) obj;
            return this.valor == dolar.valor;
        }

        return false;
    }
}
