package uninter;

public class Euro extends Moeda{
    public Euro(double valorInicial) {
        this.valor = valorInicial;
    }

    @Override
    public void info() {
        System.out.println("Euro - € " + valor);
    }

    @Override
    public double converter() {
        return this.valor * 5.26;
    }

    // Sobrescrevendo o método equals da classe Object para comparar dois objetos do tipo Euro pelo valor
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Euro) {
            Euro euro = (Euro) obj;
            return this.valor == euro.valor;
        }

        return false;
    }
}
