package Semana3.SistemaDePassagensUML.infra;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo;
    private float preco;
    private String classeVoo;
    private boolean idaEvolta;
    private int poltrona;
    private Reserva volta;
    private Cidade origem;
    private Cidade destino;

    // Getters e Setters
    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public String getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public String getHoraVoo() {
        return horaVoo;
    }

    public void setHoraVoo(String horaVoo) {
        this.horaVoo = horaVoo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }

    public boolean isIdaEvolta() {
        return idaEvolta;
    }

    public void setIdaEvolta(boolean idaEvolta) {
        this.idaEvolta = idaEvolta;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public Reserva getVolta() {
        return volta;
    }

    public void setVolta(Reserva volta) {
        this.volta = volta;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Reserva nº ").append(numReserva).append(" ===\n");
        sb.append("Data do Voo: ").append(dataVoo).append(" às ").append(horaVoo).append("\n");
        sb.append("Origem: ").append(origem != null ? origem.toString() : "Não informado").append("\n");
        sb.append("Destino: ").append(destino != null ? destino.toString() : "Não informado").append("\n");
        sb.append("Poltrona: ").append(poltrona).append("\n");
        sb.append("Classe: ").append(classeVoo).append("\n");
        sb.append("Preço: R$ ").append(preco).append("\n");
        sb.append("Tipo: ").append(idaEvolta ? "Ida e Volta" : "Somente Ida").append("\n");

        if (volta != null) {
            sb.append("--- Reserva de Volta ---\n");
            sb.append(volta.toString()).append("\n");
        }

        return sb.toString();
    }
}
