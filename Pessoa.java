//Eduardo Quadra Siminovich - 26102761, Felipe Kreismann Brigo - 26102885, Felipe Nonticuri Martins Netto - 26102890
public class Pessoa
{
    private String nome;
    private int idade;
    private String localNascimento;
    
    //construtor Pessoa
    public Pessoa(String nome, int idade, String localNascimento){
       
       
       
       this.nome = nome;
       this.idade = idade;
       this.localNascimento = localNascimento;
    }
    //metodos getters
    public String getNome(){return nome;}
    public int getIdade(){return idade;}
    public String getLocalNascimento(){return localNascimento;}

    //metodos setters
    public void setNome(String nome){this.nome=nome;}
    public void setIdade(int idade){this.idade=idade;}
    public void setLocalNascimento(String localNascimento){this.localNascimento=localNascimento;}

    @Override
    public String toString(){
        return "\nNome: " + nome + 
               "\nIdade: "+ idade +
               "\nLocal de Nascimento: " + localNascimento;
    }
}
