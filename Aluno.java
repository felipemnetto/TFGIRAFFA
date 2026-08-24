//Eduardo Quadra Siminovich - 26102761, Felipe Kreismann Brigo - 26102885, Felipe Nonticuri Martins Netto - 26102890
public class Aluno
{
    private Pessoa pessoa;
    private String curso;
    private String matricula;
    private int semestre;
    private int ano;
    private boolean bolsa;

    public Aluno(Pessoa pessoa, String curso, String matricula, int semestre, int ano, boolean bolsa){
       this.pessoa = pessoa;
       this.curso = curso;
       this.matricula = matricula;
       this.semestre = semestre;
       this.ano = ano;
       this.bolsa = bolsa;
    }

    public Pessoa getPessoa() {return pessoa;}
    public void setPessoa(Pessoa pessoa) {this.pessoa = pessoa;}
    public String getCurso() {return curso;}
    public void setCurso(String curso) {this.curso = curso;}
    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
    public int getSemestre() {return semestre;}
    public void setSemestre(int semestre) {this.semestre = semestre;}
    public int getAno() {return ano;}
    public void setAno(int ano) {this.ano = ano;}
    public boolean getBolsa() {return bolsa;}
    public void setBolsa(boolean bolsa) {this.bolsa = bolsa;}

    @Override
    public String toString() {
        return  pessoa +
                "\nCurso:" + curso + 
                "\nMatrícula:" + matricula +
                "\nSemestre:" + semestre +
                "\nAno:" + ano +
                "\nÉ bolsista:" + bolsa;
    }
}
