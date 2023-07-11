package uninter;

public class Real extends Moeda{

    public Real(double valorInicial) {
        this.valor = valorInicial;
    }

    @Override
    public void info() {
        System.out.println("Real - R$ " + valor);
    }

    @Override
    public double converter() {
        return this.valor;
    }

    // Sobrescrevendo o método equals da classe Object para comparar dois objetos do tipo Real pelo valor
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Real) {
            Real real = (Real) obj;
            return this.valor == real.valor;
        }

        return false;
    }
}
