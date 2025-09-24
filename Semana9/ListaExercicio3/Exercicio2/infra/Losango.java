package Semana9.ListaExercicio3.Exercicio2.infra;

public class Losango extends FormaGeometrica {

    public int calculaArea() {
        return (medida1 * medida2) / 2;
    }

    public int calculaPerimetro() {
        double lado = Math.sqrt(Math.pow(medida1 / 2.0, 2) + Math.pow(medida2 / 2.0, 2));
        return (int) (4 * lado);
    }
    
    public void setD(int valor) {
        this.medida1 = valor;
    }

    public void setd(int valor) {
        this.medida2 = valor;
    }

    public String toString() {
        return "Losango [D=" + medida1 + 
               ", d=" + medida2 + 
               ", área=" + calculaArea() + 
               ", perímetro=" + calculaPerimetro() + "]";
    }
}
