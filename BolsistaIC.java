//Eduardo Quadra Siminovich - 26102761, Felipe Kreismann Brigo - 26102885, Felipe Nonticuri Martins Netto - 26102890
public class BolsistaIC
{
    private Aluno aluno;
    private String projeto;
    private String orientador;

    public BolsistaIC(Aluno aluno, String projeto, String orientador){
       this.aluno = aluno;
       this.projeto = projeto;
       this.orientador = orientador;
    }

    public Aluno getAluno() {return aluno;}
    public void setAluno(Aluno aluno) {this.aluno = aluno;}
    public String getProjeto() {return projeto;}
    public void setProjeto(String projeto) {this.projeto = projeto;}
    public String getOrientador() {return orientador;}
    public void setOrientador(String orientador) {this.orientador = orientador;}

    @Override
    public String toString() {
        return "\nNome:" + aluno.getPessoa().getNome() +
                "\nProjeto:" + projeto +
                "\nOrientador:" + orientador;
    }
}
