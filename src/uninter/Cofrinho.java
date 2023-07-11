package uninter;

import java.util.ArrayList;

public class Cofrinho {
    private ArrayList<Moeda> listaMoedas;

    public Cofrinho() {
        this.listaMoedas = new ArrayList<Moeda>();
    }

    public void adicionar(Moeda moeda) {
        this.listaMoedas.add(moeda);
    }

    public void remover(Moeda moeda) {
        this.listaMoedas.remove(moeda);
    }

    public void listagemDeMoedas() {
        if(this.listaMoedas.isEmpty()) {
            System.out.println("Cofrinho vazio, comece a poupar!");
            return;
        }

        for (Moeda moeda : this.listaMoedas) {
            moeda.info();
        }
    }

    public double totalConvertido() {
        if(this.listaMoedas.isEmpty()) {
            return 0;
        }

        double valorTotal = 0;

        for (Moeda moeda : this.listaMoedas) {
            valorTotal += moeda.converter();
        }

        return valorTotal;
    }

    public boolean verificaSeMoedaExiste(Moeda moeda) {
        return this.listaMoedas.contains(moeda);
    }

    public boolean verificaSeCofrinhoEstaVazio() {
        return this.listaMoedas.isEmpty();
    }

}
