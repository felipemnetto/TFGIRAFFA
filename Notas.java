//Eduardo Quadra Siminovich - 26102761, Felipe Kreismann Brigo - 26102885, Felipe Nonticuri Martins Netto - 26102890
import java.util.*;
public class Notas
{
    private Aluno aluno;
    private double[] notasTrab;
    private double[] notasProv;
    private int quantrab;
    private int quantprov;
    
    public Notas(Aluno aluno, int quantrab,int quantprov)
    {
        this.aluno = aluno;
        this.quantrab = quantrab;
        this.quantprov = quantprov;
        this.notasTrab = new double[quantrab];
        this.notasProv = new double[quantprov];
    }
    //Fazer os Getters;
    public Aluno getAluno() {return aluno;}
    public double[] getNotaAluno() {return notasTrab;}
    public double[] getNotasProvas() {return notasProv;}
    public int getQuantTrabalhos(){return quantrab;}
    public int getQuantProvas(){return quantprov;}
    //Os setters SEPARADOS
    public void setNotaTrabalho(int indice, double nota) {
        if (indice >= 0 && indice < quantrab)
            notasTrab[indice] = nota;
    }
     
    public void setNotaProva(int indice, double nota) {
        if (indice >= 0 && indice < quantprov)
            notasProv[indice] = nota;
    }
    //Calcular media das 2 melhores notas
    public double calcMediaTrabalhos(){
       if ( quantrab < 2) return quantrab > 0 ? notasTrab[0]:0;
       double soma = 0;
       double pior = notasTrab[0];

       //Média de todos os trabalhos tirando a pior nota
       for (int i = 0; i < quantrab; i++){
           soma += notasTrab[i];
           if (notasTrab[i] < pior) {
                pior = notasTrab[i];
           }   
        }
       return (soma - pior) / ( quantrab -1);
       }
    
    public double calcMediaProvas(){
        if (quantprov == 0) return 0;
        double soma = 0;
        for (int i = 0; i < quantprov; i++) soma += notasProv[i];
        return soma / quantprov;
    }
    
    //Media final
    public double calcMediaFinal(){
        return (calcMediaTrabalhos() + calcMediaProvas())/2.0;
    }
    
    public String estadoAluno(){
        double media = calcMediaFinal();
        if (media >= 7.0) return "Aprovado(a).";
        if (media >= 5.0) return "Recuperação.";
        return "Reprovado(a).";
    }
    //Stringao de notas do aluno
    public String toString() {
        String Stringao = "\nAluno: " + aluno.getPessoa().getNome() + "\nMatrícula: " + aluno.getMatricula() + "\nNotas de Trabalhos: ";
        for (int i = 0; i < quantrab; i++)
            Stringao += "T" + (i + 1) + " = " + notasTrab[i] + " / ";
        Stringao += "\nMédia dos Trabalhos (sem a pior): " + calcMediaTrabalhos();
        Stringao += "\nNotas de Provas: ";
        for (int i = 0; i < quantprov; i++)
            Stringao += "P" + (i + 1) + " = " + notasProv[i] + " / ";
        Stringao += "\nMédia das Provas: " + calcMediaProvas();
        Stringao += "\nMédia Final: " + calcMediaFinal();
        Stringao += "\nSituação: " + estadoAluno();
        return Stringao;
    }
    
    public static void menuNotas2000(Scanner teclado, Aluno[] listaAlunos){
        int opcao;
        Notas[] listaNotas = new Notas[listaAlunos.length];

        // ── Notas de teste para os 5 alunos pré-cadastrados ──

        // Maria - 3 trabalhos, 2 provas (Aprovada)
        if (listaAlunos[0] != null) {
            listaNotas[0] = new Notas(listaAlunos[0], 3, 2);
            listaNotas[0].setNotaTrabalho(0, 8.0);
            listaNotas[0].setNotaTrabalho(1, 9.0);
            listaNotas[0].setNotaTrabalho(2, 7.5);
            listaNotas[0].setNotaProva(0, 8.5);
            listaNotas[0].setNotaProva(1, 9.0);
        }

        // João - 2 trabalhos, 1 prova (Recuperação)
        if (listaAlunos[1] != null) {
            listaNotas[1] = new Notas(listaAlunos[1], 2, 1);
            listaNotas[1].setNotaTrabalho(0, 6.0);
            listaNotas[1].setNotaTrabalho(1, 5.0);
            listaNotas[1].setNotaProva(0, 5.5);
        }

        // Ana - 4 trabalhos, 2 provas (Reprovada)
        if (listaAlunos[2] != null) {
            listaNotas[2] = new Notas(listaAlunos[2], 4, 2);
            listaNotas[2].setNotaTrabalho(0, 3.0);
            listaNotas[2].setNotaTrabalho(1, 2.0);
            listaNotas[2].setNotaTrabalho(2, 4.0);
            listaNotas[2].setNotaTrabalho(3, 1.5);
            listaNotas[2].setNotaProva(0, 3.5);
            listaNotas[2].setNotaProva(1, 2.5);
        }

        // Carlos - 3 trabalhos, 1 prova (Aprovado)
        if (listaAlunos[3] != null) {
            listaNotas[3] = new Notas(listaAlunos[3], 3, 1);
            listaNotas[3].setNotaTrabalho(0, 10.0);
            listaNotas[3].setNotaTrabalho(1, 9.0);
            listaNotas[3].setNotaTrabalho(2, 8.0);
            listaNotas[3].setNotaProva(0, 7.5);
        }

        // Beatriz - 2 trabalhos, 2 provas (Recuperação)
        if (listaAlunos[4] != null) {
            listaNotas[4] = new Notas(listaAlunos[4], 2, 2);
            listaNotas[4].setNotaTrabalho(0, 6.5);
            listaNotas[4].setNotaTrabalho(1, 4.0);
            listaNotas[4].setNotaProva(0, 6.0);
            listaNotas[4].setNotaProva(1, 5.0);
        }
        
        do {
            exibirMenuNotas2000();
            opcao = lerInteiro(teclado);
            
            switch (opcao) {
                case 1:
                    Aluno a1 = selecaoAluno(teclado, listaAlunos);
                    if (a1 == null) break;
                    listaNotas[indiceAluno(listaAlunos, a1)] = lancarNota(teclado, a1);
                    System.out.println("Notas lançadas com sucesso!");
                    pausar(teclado);
                    break;
                    //Lanca a nota pro aluno (selecaoAluno)(lancarNota)(listaNotas)(indiceAluno)
                
                case 2://Alterar nota do aluno (selecaoAluno)
                Aluno a2 = selecaoAluno(teclado, listaAlunos);
                if (a2 == null) break;
                int val = indiceAluno(listaAlunos, a2);
                if (listaNotas[val] == null) {
                    System.out.println("Este aluno ainda não tem notas lançadas.");
                } else {
                    alterarNota(teclado, listaNotas[val]);
                }
                    pausar(teclado);
                    break;
                
                case 3://ver nota do aluno especifico (selecaoAluno)
                Aluno a3 = selecaoAluno(teclado, listaAlunos);
                if(a3 == null)break;
                int val2 = indiceAluno(listaAlunos, a3);
                if(listaNotas[val2] == null){
                    System.out.println("Esse aluno ainda não tem notas lançadas");}
                    else System.out.println(listaNotas[val2]);
                pausar(teclado);
                break;
                
            
                case 4: //avalicao geral( pegar todas as notas e fazer uma media)
                    System.out.println(" - - - - Boletim geral - - - -");
                    boolean algum = false;
                    for(int i = 0; i < listaAlunos.length; i++){
                    if (listaAlunos[i] != null && listaNotas[i] != null){
                            System.out.println(listaNotas[i]);
                            System.out.println("--------------------");
                            algum = true;
                    }
                }
                    // BUG CORRIGIDO: era "algum = false" (atribuição), tem que ser "algum == false"
                    if(algum == false) System.out.println("Nenhuma nota registrada");
                    pausar(teclado);
                    break;
                    
                case 5://Filtro de reprovado aprovado e recuperacao
                    filtrarSituacao(teclado, listaAlunos, listaNotas);
                    pausar(teclado);
                    break;
            }
        }while (opcao != 0);
        
        
    }
    
    public static void exibirMenuNotas2000() {
        System.out.println("\f");
        System.out.println("""
        ┌──────────────────────────────────────────────────┐
        │~ ~ ~ ~ ~ ~ GERENCIADOR DE NOTAS 2000 ~ ~ ~ ~ ~ ~ │
        ├──────────────────────────────────────────────────┤
        │ [1] - Lançar notas para um aluno                 │
        │ [2] - Alterar notas de um aluno                  │
        │ [3] - Ver notas de um aluno                      │
        │ [4] - Avaliação geral dos alunos                 │
        │ [5] - Filtrar (Reprovado/Aprovado/Recuperação)   │
        ├──────────────────────────────────────────────────┤
        │ [0] - Voltar ao menu principal                   │
        └──────────────────────────────────────────────────┘""");
        System.out.println("\nEscolha uma opção: ");
    }
    
    private static Aluno selecaoAluno(Scanner teclado, Aluno[] listaAlunos) {
        System.out.println("\nSelecione o aluno: ");
        int contador = 0;
        for (int i = 0; i < listaAlunos.length; i++) {
            if (listaAlunos[i] != null) {
                //Se o i começa em 0 então temos que colocar o + 1 ( to falando pq esqueci e ficou errado :))
                System.out.println((i + 1) + " : " + listaAlunos[i].getPessoa().getNome()
                        + " / " + listaAlunos[i].getMatricula());
                contador++;
            }
        }
        //Obvio q nao vai como isso aparecer mas e bom ter
        if (contador == 0) {
            System.out.println("Nenhum aluno cadastrado no sistema.");
            return null;
        }
        System.out.print("Número do aluno: ");
        int escolha = lerInteiro(teclado) - 1;
        //Tirar as "rebarbas" para caso tiver um erro de digitação ou sla
        if (escolha < 0 || escolha >= listaAlunos.length || listaAlunos[escolha] == null) {
            System.out.println("Aluno não encontrado.");
            return null;
        }
        return listaAlunos[escolha];
    }
    
    private static int indiceAluno(Aluno[] listaAlunos, Aluno aluno) {
        for (int i = 0; i < listaAlunos.length; i++)
            if (listaAlunos[i] == aluno) return i;
        return -1;
    }
    
    private static Notas lancarNota(Scanner teclado, Aluno aluno){
        //Setar a quatidade de trabalhos
        System.out.println("Quantos trabalhos tem a cadeira?");
        int quanttrab = lerInteiro(teclado);
        while (quanttrab < 2 ) {
            System.out.println("É necessário 2 trabalhos no mínimo. Tente novamente.");
            quanttrab = lerInteiro(teclado);
        }
        //Setar a quatidade de provas
        System.out.println("Quantas provas tem a cadeira? ");
        int quantprova = lerInteiro(teclado);
        while (quantprova < 1){
            System.out.print("É necessário 1 prova no mínimo. Tente novamente.");
            quantprova = lerInteiro(teclado);
        }
        //Gerar um novo vetor das notas do aluno
        
        Notas notas = new Notas(aluno, quanttrab, quantprova);
        
        for(int i = 0; i < quanttrab; i++){
            System.out.printf("Nota do trabalho %d (0 - 10): ", i + 1);
            notas.setNotaTrabalho(i, lerNota(teclado));
        }
        for(int i = 0; i < quantprova; i++){
            System.out.printf("Nota da prova %d (0 - 10): ", i + 1);
            notas.setNotaProva(i, lerNota(teclado));
        }
        return notas;
    }
    
    //Metodo de alterar nota
    private static void alterarNota(Scanner teclado, Notas nota){
        System.out.println("""
        1 - Alterar nota do trabalho
        2 - Aterar nota de prova
        """);
        int opc = lerInteiro(teclado);
        if(opc == 1){
            System.out.println("Qual trabalho vc quer mudar a nota? (1 -> "+nota.getQuantTrabalhos()+"): ");
            int vl = lerInteiro(teclado) - 1;//nao pode esquecer o -1 :P
            if(vl < 0 || vl >= nota.getQuantTrabalhos()){
                System.out.println("Valor inválido.");
                return;
            }
            System.out.println("Insira o valor da nova nota: ");
            nota.setNotaTrabalho(vl, lerNota(teclado));
            } else if (opc == 2){ 
            // BUG CORRIGIDO: era getQuantTrabalhos() no print, tem que ser getQuantProvas()
            System.out.println("Qual prova vc quer mudar a nota? (1 -> "+nota.getQuantProvas()+"): ");
            int vl = lerInteiro(teclado) - 1;
            if(vl < 0 || vl >= nota.getQuantProvas()){
                System.out.println("Valor inválido.");
                return;
            }
            System.out.println("Insira o valor da nova nota: ");
            nota.setNotaProva(vl, lerNota(teclado));
            }   else {
            System.out.println("Opção inválida.");
            return;
        }
        System.out.println("Nota alterada com sucesso!");
    }
    
    //Metodo para avaliar se a nota é valida no sistema
    private static double lerNota(Scanner teclado) {
            while (true) {    
                try{
                    double nota = teclado.nextDouble();
                    if (nota < 0 || nota > 10) {
                        System.out.print("Nota deve ser entre 0 e 10. Tente novamente: ");
                        continue;
                    }
                    return nota;
                } catch (InputMismatchException e) {
                    System.out.println("Inválido! Digite apenas números.");
                    teclado.nextLine(); // buffer
                }
            }    
        }
    
    //Metodo de pausa para poder prosseguir
    private static void pausar(Scanner teclado) {
        System.out.println("\nPressione ENTER para continuar...");
        teclado.nextLine();
        teclado.nextLine();
    }
    //Metodo de filtro 
    private static void filtrarSituacao(Scanner teclado, Aluno[] listaAlunos, Notas[] listaNotas) {
        System.out.println("\n1 - Aprovados\n2 - Reprovados\n3 - Recuperação");
        System.out.print("Escolha: ");
        int filtro = lerInteiro(teclado);
        String situacao;
        // BUG CORRIGIDO: strings tinham que bater exatamente com o que estadoAluno() retorna
        if (filtro == 1) situacao = "Aprovado(a).";
        else if (filtro == 2) situacao = "Reprovado(a).";
        else situacao = "Recuperação.";
 
        System.out.println("\n||||| " + situacao + " ||||| ");
        boolean encontrou = false;
        for (int i = 0; i < listaAlunos.length; i++) {
            if (listaAlunos[i] != null && listaNotas[i] != null
                    && listaNotas[i].estadoAluno().equals(situacao)) {
                System.out.println(listaAlunos[i].getPessoa().getNome()
                        + " | Média: " + listaNotas[i].calcMediaFinal());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum aluno nesta situação.");
    }
    
    //Tratamento de excecoes de entrada para evitar erro de digitação (aplicar futuramente)
    public static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Inválido! Digite apenas números inteiros.\n");
                scanner.nextLine();
            }
        }
    }
    public static int lerInteiro(Scanner scanner){
        return lerInteiro(scanner, "");
    }
}
