package infra;
public class Reserva {
    private int numeroReserva;
    private Hospede hospede;
    private Quarto quarto;
    private String dataEntrada;
    private String dataSaida;

    public Reserva(
        int numeroReserva,
        Hospede hospede,
        Quarto quarto,
        String dataEntrada,
        String dataSaida
    ) {
        this.numeroReserva = numeroReserva;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String toString() {
        return "Numero da reserva: " + numeroReserva + ", feita pelo hospede de cpf: " + hospede.getCpf() + ", no quarto: " + quarto.getNumero() + ", data de entrada: " + dataEntrada + ", data de saida: " + dataSaida;
    }
}
