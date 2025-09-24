package Semana9.ListaExercicio3.Exercicio2.infra;

public class Circulo extends FormaGeometrica {
    
    public void setRaio(int valor) {
        this.medida1 = valor;
    }

    public int calculaArea() {
        return (int) (Math.PI * medida1 * medida1);
    }

    public int calculaPerimetro() {
        return (int) (2 * Math.PI * medida1);
    }
    
    public String toString() {
        return "Círculo [raio=" + medida1 + 
               ", área=" + calculaArea() + 
               ", perímetro=" + calculaPerimetro() + "]";
    }
}
