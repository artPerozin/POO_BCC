package exercicio2.dados;

public class Dono {
    private String nome;
    private Endereco endereco;
    private String cpf;

    public Dono(
        String nome,
        String cpf
    ){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCPF(){
        return this.cpf;
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
}
