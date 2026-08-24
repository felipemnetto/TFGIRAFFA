//Eduardo Quadra Siminovich - 26102761, Felipe Kreismann Brigo - 26102885, Felipe Nonticuri Martins Netto - 26102890
public class AcompanhamentoIA
{
    private Aluno aluno;
    private int atividadesEntregues, atividadesIa, atividadesExplicadas, codigosSemAjuda, entregasNaoEstudadas;
    private double riscoPedagogico;    
    
    public AcompanhamentoIA(Aluno aluno){
        this.aluno = aluno;
        this.atividadesEntregues = 0;
        this.atividadesIa = 0;
        this.atividadesExplicadas = 0;
        this.codigosSemAjuda = 0;
        this.entregasNaoEstudadas = 0;
        this.riscoPedagogico = 0;
    }  

    public Aluno getAluno(){return aluno;}
    public int getAtividadesEntregues(){return atividadesEntregues;}
    public int getAtividadesIa(){return atividadesIa;}
    public int getAtividadesExplicadas(){return atividadesExplicadas;}
    public int getCodigosSemAjuda(){return codigosSemAjuda;}
    public int getEntregasNaoEstudadas(){return entregasNaoEstudadas;} 
    public double getRiscoPedagogico(){return riscoPedagogico;}   

    public void setAluno(Aluno aluno){this.aluno = aluno;}
    public void setAtividadesEntregues(int atividadesEntregues){this.atividadesEntregues = atividadesEntregues;}
    public void setAtividadesIa(int atividadesIa){this.atividadesIa = atividadesIa;}
    public void setAtividadesExplicadas(int atividadesExplicadas){this.atividadesExplicadas = atividadesExplicadas;}
    public void setCodigosSemAjuda(int codigosSemAjuda){this.codigosSemAjuda = codigosSemAjuda;}
    public void setEntregasNaoEstudadas(int entregasNaoEstudadas){this.entregasNaoEstudadas = entregasNaoEstudadas;}
    public void setRiscoPedagogico(double riscoPedagogico){this.riscoPedagogico = riscoPedagogico;}

    @Override
    public String toString(){
            
        return "\naluno:" + aluno +
            "\natividadesEntregues:" + atividadesEntregues +
            "\natividadesIa:" + atividadesIa +
            "\natividadesExplicadas:" + atividadesExplicadas +
            "\ncodigosSemAjuda:" + codigosSemAjuda +
            "\nentregasNaoEstudadas:" + entregasNaoEstudadas +
            "\nriscoPedagogico:" + riscoPedagogico;
    }    
}
