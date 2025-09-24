package Semana9.ListaExercicio3.Exercicio2.infra;

public class TrianguloEquilatero extends FormaGeometrica {
    
    public int calculaArea() {
        return (int) ((medida1 * medida1 * Math.sqrt(3)) / 4);
    }

    public int calculaPerimetro() {
        return 3 * medida1;
    }
    
    public void setLado(int valor) {
        this.medida1 = valor;
    }

    public String toString() {
        return "Triângulo Equilátero [lado=" + medida1 + 
               ", área=" + calculaArea() + 
               ", perímetro=" + calculaPerimetro() + "]";
    }
}
