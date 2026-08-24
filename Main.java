/**
 * Eduardo Quadra Siminovich - 26102761
 * Felipe Kreismann Brigo - 26102885
 * Felipe Nonticuri Martins Netto - 26102890
 */
import java.util.*;
public class Main
{
    public static Scanner teclado = new Scanner(System.in);
    static Aluno[] listaAlunos = new Aluno[10];
    static BolsistaIC[] listaBolsistas = new BolsistaIC[10];
    static AcompanhamentoIA[] listaAcompanhamentos = new AcompanhamentoIA[10];
    public static int tamListaAlunos = listaAlunos.length;
    public static int tamListaBolsistas = listaBolsistas.length;
    public static void main(String [] args)
    {
        //Pessoas e alunos de teste
        Pessoa p1 = new Pessoa("Ana", 20, "São Paulo");
        listaAlunos[0] = new Aluno(p1, "Ciência da Computação", "12345632", 2, 2025, true);
        listaBolsistas[0] = new BolsistaIC(listaAlunos[0], "Projeto de Pesquisa em IA", "Dr. Silva");
        listaAcompanhamentos[0]= new AcompanhamentoIA(listaAlunos[0]);
        listaAcompanhamentos[0].setRiscoPedagogico(80);

        Pessoa p2 = new Pessoa("Carlos", 22, "Rio de Janeiro");
        listaAlunos[1] = new Aluno(p2, "Engenharia de Software", "65432143", 1, 2026, true);
        listaBolsistas[1] = new BolsistaIC(listaAlunos[1], "Projeto de Pesquisa em Software", "Dr. Souza");
        listaAcompanhamentos[1]= new AcompanhamentoIA(listaAlunos[1]);
        listaAcompanhamentos[1].setRiscoPedagogico(30);

        Pessoa p3 = new Pessoa("Diana", 19, "Belo Horizonte");
        listaAlunos[2] = new Aluno(p3, "Engenharia da Computação", "98765456", 4, 2024, false);
        listaAcompanhamentos[2]= new AcompanhamentoIA(listaAlunos[2]);
        listaAcompanhamentos[2].setRiscoPedagogico(15);

        Pessoa p4 = new Pessoa("Gabriel", 21, "Curitiba");
        listaAlunos[3] = new Aluno(p4, "Engenharia de Software", "45678956", 5, 2023, false);
        listaAcompanhamentos[3]= new AcompanhamentoIA(listaAlunos[3]);
        listaAcompanhamentos[3].setRiscoPedagogico(35);

        Pessoa p5 = new Pessoa("Maria", 23, "Salvador");
        listaAlunos[4] = new Aluno(p5, "Ciência de Dados e Inteligência Artificial", "78912356", 7, 2022, true);
        listaBolsistas[2] = new BolsistaIC(listaAlunos[4],"Simulacao de Multidoes", "Soraia Musse");
        listaAcompanhamentos[4]= new AcompanhamentoIA(listaAlunos[4]);
        listaAcompanhamentos[4].setRiscoPedagogico(70);

        ordenaAlunos();
        ordenaBolsistas();

        int opc;

        do {
            menu();
            opc = lerInteiro(teclado);

            switch (opc){
                case 1: cadastraAluno(); ordenaAlunos(); menuTransicao(); break;//metodo de cadastrar aluno

                case 2://metodo de cadastrar bolsista
                    listaAlunosSemBolsa();
                    System.out.println("\nSe nao desejar cadastrar bolsa, digite 0, caso contrário, digite o número do aluno que deseja cadastrar bolsa! ");
                    int aux = lerInteiro(teclado);
                    if(aux == 0){
                        menuTransicao();
                        break;
                    }
                    if(aux < 1 || aux > listaAlunos.length || listaAlunos[aux-1] == null){
                        System.out.println("Aluno inválido!");
                        menuTransicao();
                        break;
                    }
                    cadastraBolsista(listaAlunos[aux-1]);
                    ordenaBolsistas();
                    menuTransicao();
                    break;

                case 3: registrarUsoIA(); menuTransicao(); break;//registrar acompanhamento do uso de IA

                case 4: 
                
                    listaAlunos(); 
                    System.out.println("\nDigite o número do aluno que deseja visualizar os dados: ");
                    int alunoIndex = lerInteiro(teclado) - 1;
                    if(alunoIndex < 0 || alunoIndex >= listaAlunos.length || listaAlunos[alunoIndex] == null){
                        System.out.println("Aluno inválido!");
                    } else {
                        System.out.println(listaAlunos[alunoIndex]);
                    }
                    menuTransicao(); break;//dados de um aluno específico

                case 5: 
                    
                    listaBolsistas();
                    System.out.println("\nDigite o número do bolsista que deseja visualizar os dados: ");
                    int bolsistaIndex = lerInteiro(teclado) - 1;
                    if(bolsistaIndex < 0 || bolsistaIndex >= listaBolsistas.length || listaBolsistas[bolsistaIndex] == null){
                        System.out.println("Bolsista inválido!");
                    } else {
                        System.out.println(listaBolsistas[bolsistaIndex]);
                    }
                    menuTransicao(); break;//daddos de um bolsista específico

                case 6: nomeMaisLongo(); menuTransicao(); break;// nome mais longo da turma

                case 7: //conta vogais nos nomes cadastrados

                    for(Aluno aluno : listaAlunos)
                    {
                        if(aluno != null){
                            System.out.println(aluno.getPessoa().getNome() + " - " + contadorVogais(aluno.getPessoa().getNome()) + " vogais");
                        }
                    }
                    menuTransicao();
                    break;

                case 8: percentualAlunos(); menuTransicao(); break;// percentual de alunos por curso

                case 9: //calcular media de idade dos alunos
                    if (mediaIdadeAlunos() == 0){
                        System.out.println("Não há alunos cadastrados para calcular a média de idade.");
                    }
                    else{
                        System.out.printf("A média de idades dos alunos é: %.2f\n", mediaIdadeAlunos());
                    }
                    menuTransicao();
                    break;

                case 10: removeAluno(); compactaArrayAlunos(listaAlunos); menuTransicao(); break;// remover aluno da lista de chamada

                case 11: listaAlunos(); menuTransicao(); break;//listar lista de chamada em ordem alfabética

                case 12: calcularRiscoPedagogico(); menuTransicao(); break;// calcular risco pedagogico relacionado ao uso de ia

                case 13: relatorioRisco(); menuTransicao(); break;// exibir relatorio geral de risco por aliumno

                case 14: alunosRiscoAlto(); menuTransicao(); break;// exibir alunos em risco alto
                
                case 15: Notas.menuNotas2000(teclado, listaAlunos); break;

                case 0: System.out.println("Fechando a aplicação..."); break;

                default: System.out.println("Opção invalida! Tente novamente."); break;
            }
        } while (opc != 0);
    }

    public static void registrarUsoIA() {

        listaAlunos();
    
        System.out.print("\nEscolha o número do aluno: ");
        int indice = lerInteiro(teclado) - 1;

        if(indice < 0 || indice >= listaAlunos.length || listaAlunos[indice] == null){
            System.out.println("Aluno inválido!");
            return;
        }
    
        listaAcompanhamentos[indice] = new AcompanhamentoIA(listaAlunos[indice]);
    
        AcompanhamentoIA acomp = listaAcompanhamentos[indice];
        //variavel criada para não precisar ficar chamando o vetor o tempo todo
    
        System.out.print("Quantidade de atividades entregues: ");
        acomp.setAtividadesEntregues(lerInteiro(teclado));

        System.out.print("Quantidade de atividades realizadas com IA: ");
        acomp.setAtividadesIa(lerInteiro(teclado));

        teclado.nextLine();

        System.out.print("O aluno conseguiu explicar o código? (S/N): ");
        String resp = teclado.nextLine();

        if(resp.equalsIgnoreCase("S")||resp.equalsIgnoreCase("SIM"))
            acomp.setAtividadesExplicadas(acomp.getAtividadesEntregues());
        else
            acomp.setAtividadesExplicadas(0);

        System.out.print("O aluno conseguiu modificar a solução sem ajuda? (S/N): ");
        resp = teclado.nextLine();

        if(resp.equalsIgnoreCase("S")||resp.equalsIgnoreCase("SIM"))
            acomp.setCodigosSemAjuda(acomp.getAtividadesEntregues());
        else
            acomp.setCodigosSemAjuda(0);
    
        System.out.print("Foram utilizadas estruturas ainda não estudadas? (S/N): ");
        resp = teclado.nextLine();

        if(resp.equalsIgnoreCase("S")||resp.equalsIgnoreCase("SIM"))
            acomp.setEntregasNaoEstudadas(1);
        else
            acomp.setEntregasNaoEstudadas(0);
    
        acomp.setRiscoPedagogico(0);

        System.out.println("\nAcompanhamento registrado");
    }

    public static void calcularRiscoPedagogico() {

        for (AcompanhamentoIA acomp : listaAcompanhamentos) {

            if (acomp != null) {

                double risco = 0;
    
                // Quanto maior o uso de IA, maior o risco
                if (acomp.getAtividadesEntregues() > 0) {
                    risco += ((double)acomp.getAtividadesIa() /
                              acomp.getAtividadesEntregues()) * 40;
                }

                // Dificuldade para explicar o código
                risco += (10 - acomp.getAtividadesExplicadas()) * 2;

                // Poucos códigos feitos sem ajuda
                risco += (10 - acomp.getCodigosSemAjuda()) * 2;

                // Entregas não estudadas
                risco += acomp.getEntregasNaoEstudadas() * 5;
    
                if(risco > 100){
                risco = 100;}
                if(risco < 0){
                risco = 0;}
                acomp.setRiscoPedagogico(risco);
            }
        }

        System.out.println("Risco pedagógico calculado!");
    }
    
        public static void relatorioRisco() {

        System.out.println("\n _-_-_-_-_- RELATÓRIO GERAL DE RISCO -_-_-_-_-_ ");
    
        boolean registrado = false;

        for (int i = 0; i < listaAcompanhamentos.length; i++) {
            if (listaAcompanhamentos[i] != null) {

                registrado = true;

                AcompanhamentoIA acomp = listaAcompanhamentos[i];

                String classificacao;

                if (acomp.getRiscoPedagogico() < 35) {
                    classificacao = "BAIXO";
                } else if (acomp.getRiscoPedagogico() < 70) {
                    classificacao = "MODERADO";
                } else {
                    classificacao = "ALTO";
                }

                System.out.println("--------------------------------------------");
                System.out.println("Aluno: " + acomp.getAluno().getPessoa().getNome());
                System.out.println("Curso: " + acomp.getAluno().getCurso());
                System.out.println("Matrícula: " + acomp.getAluno().getMatricula());
                System.out.printf("Risco Pedagógico: %.1f%n", acomp.getRiscoPedagogico());
                System.out.println("Classificação: " + classificacao);
            }
        }

        if (!registrado) {
            System.out.println("\nNenhum acompanhamento foi registrado.");
        }
    }
    
    public static void alunosRiscoAlto(){

        System.out.println("\n!!!!! ALUNOS EM RISCO ALTO !!!!!");

        boolean achou = false;

        for(AcompanhamentoIA acomp : listaAcompanhamentos){
            if(acomp != null && acomp.getRiscoPedagogico() >= 70){

                achou = true;

                System.out.println("--------------------------------");
                System.out.println("Aluno: " +
                        acomp.getAluno().getPessoa().getNome());

                System.out.println("Curso: " +
                        acomp.getAluno().getCurso());

                System.out.println("Matrícula: " +
                        acomp.getAluno().getMatricula());

                System.out.println("Risco: " +
                        String.format("%.1f",acomp.getRiscoPedagogico()));
            }
        }

        if(!achou){
            System.out.println("\nNenhum aluno em risco alto");
        }
    }

    public static double mediaIdadeAlunos()
    {
        double somaidades = 0;
        double totalalunos = 0;
        for (Aluno aluno : listaAlunos)
        {
            if ( aluno != null)
            {
                somaidades += aluno.getPessoa().getIdade();
                totalalunos++;
            }
        }
        if (totalalunos ==0){
            return 0;
            }
        else {
            double mediaidade = somaidades/totalalunos;
            return mediaidade;
            }
    }

    public static void nomeMaisLongo()
    {
        String maiornome = "I";

        for (Aluno aluno : listaAlunos)
        {
            if ( aluno != null && aluno.getPessoa().getNome().length() > maiornome.length()){
                maiornome = aluno.getPessoa().getNome();
            }
        }

        System.out.printf("O nome mais comprido da turma é: " + maiornome + "\nQuantidade de letras: " + maiornome.length() + "\n");
    }

    public static void cadastraAluno(){
        Pessoa pessoa = cadastraPessoa();
        int verifica;
        boolean isBolsista = false;

        String curso = selecionaCursos();
        System.out.println("\nInsira sua matrícula: ");
        teclado.nextLine(); // buffer
        String matricula = teclado.nextLine();
        System.out.println("\nInsira seu semestre. Ex.: 1, 2, 3...");
        int semestre = lerInteiro(teclado);
        System.out.println("\nInsira seu ano de ingresso. Ex.: 2020, 2021...");
        int ano = lerInteiro(teclado);

        do
        {
            System.out.println("\nVocê é bolsista? Digite\n1 - Sim\n2 - Nao");
            verifica = lerInteiro(teclado);
        }while(verifica != 1 && verifica != 2);

        if(verifica == 1){isBolsista=true;}

        Aluno aluno = new Aluno(pessoa, curso, matricula, semestre, ano, isBolsista);
        AcompanhamentoIA acompanhamento = new AcompanhamentoIA(aluno);

        if(isBolsista){
            cadastraBolsista(aluno);
        }

        for(int i = 0; i < tamListaAlunos; i++){
            if(listaAlunos[i] == null && listaAcompanhamentos[i]==null){
                listaAlunos[i] = aluno;
                listaAcompanhamentos[i] = acompanhamento;
                System.out.println("\nAluno cadastrado com sucesso!");
                break;
            }
            else if (i == tamListaAlunos - 1){
                System.out.println("Lista de alunos cheia! Impossível cadastrar mais alunos."); break;
            }
        }
    }

    public static void cadastraBolsista(Aluno aluno){
        teclado.nextLine();// buffer
        System.out.println("Qual seu Projeto?");
        String projeto = teclado.nextLine();
        System.out.println("Quem é seu orientador?");
        String orientador = teclado.nextLine();
        BolsistaIC bolsista = new BolsistaIC(aluno, projeto, orientador);
        aluno.setBolsa(true);

        for(int i = 0; i < tamListaBolsistas; i++){
            if(listaBolsistas[i] == null){
                listaBolsistas[i] = bolsista; break;
            }
            else if (i == tamListaBolsistas - 1){
                System.out.println("Lista de bolsistas cheia! Impossível cadastrar mais bolsistas."); break;
            }
        }
    }

    public static Pessoa cadastraPessoa(){
        teclado.nextLine();// buffer
        System.out.println("Digite seu nome");
        String nome = teclado.nextLine();
        System.out.println("\nDigite sua Idade. Ex.: 20, 21...");
        int idade = lerInteiro(teclado);
        teclado.nextLine();// buffer
        System.out.println("\nInsira seu local de nascimento. Ex.: São Paulo, Rio de Janeiro...");
        String localNascimento = teclado.nextLine().toUpperCase();

        Pessoa pessoa = new Pessoa(nome, idade, localNascimento);
        return pessoa;
    }

    public static void listaAlunos()
        {
            System.out.println("\nLista de Alunos:");
            for(int i = 0; i < listaAlunos.length; i++)
                {
                    if(listaAlunos[i] != null) {System.out.println((i+1) +" - "+listaAlunos[i].getPessoa().getNome()+" | Matrícula: "+listaAlunos[i].getMatricula());}
                }
        }

    public static void listaAcompanhamentos()
    {
        System.out.println("\nLista de Acompanhamentos");
        for(int i = 0; i<listaAcompanhamentos.length;i++){
            if(listaAcompanhamentos[i] != null){System.out.println((i+1) + " - "+ listaAcompanhamentos[i].getAluno().getPessoa().getNome()+ " | Matrícula: "+ listaAcompanhamentos[i].getAluno().getMatricula());}
        }
    }

    public static void listaAlunosSemBolsa()
    {
        System.out.println("\nLista de Alunos sem Bolsa:");
        for(int i = 0; i < listaAlunos.length; i++)
            {
                if(listaAlunos[i] != null && !listaAlunos[i].getBolsa()) {System.out.println((i+1) +" - "+listaAlunos[i].getPessoa().getNome()+" | Matrícula: "+listaAlunos[i].getMatricula());}
            }
    }

    public static void removeAluno(){
        listaAlunos();
        int opc;
        do{
            opc = lerInteiro(teclado, "\nEscolha o número do aluno que deseja remover da lista: ");
            if(opc <=0 || opc > listaAlunos.length || listaAlunos[opc-1] == null){
                System.out.println("Valor Inválido");
            }
        }while(opc <=0 || opc > listaAlunos.length || listaAlunos[opc-1] == null);

        if(!avisoRemocao()){
            System.out.println("Remoção Cancelada");
            return;
        }
        removeBolsista(opc); compactaArrayBolsistas(listaBolsistas);
        listaAlunos[opc-1]=null;
        removeAcompanhamento(opc); compactaArrayAcompanhamentos(listaAcompanhamentos);
        System.out.println("\nAluno removido com sucesso!");
    }

    public static void compactaArrayAlunos(Aluno[] alunos){
        int tam = alunos.length;
        int destino=0;
        for (int i = 0; i<tam;i++){
            if (alunos[i]!=null){
                alunos[destino]=alunos[i];
                destino++;
            }
        }
        
        while (destino < tam){
            alunos[destino]=null;
            destino++;
        }  
    }

    public static void removeBolsista(int opc){
        Aluno aluno = listaAlunos[opc-1]; 
        for(int i = 0; i < listaBolsistas.length; i++){
            if(listaBolsistas[i] != null && listaBolsistas[i].getAluno() == aluno){
                listaBolsistas[i] = null;
                break;
            }
        }
    }

    public static void compactaArrayBolsistas(BolsistaIC[] bolsistas){
        int tam = bolsistas.length;
        int destino=0;
        for (int i = 0; i<tam;i++){
            if (bolsistas[i]!=null){
                bolsistas[destino]=bolsistas[i];
                destino++;
            }
        }
        
        while (destino < tam){
            bolsistas[destino]=null;
            destino++;
        }  
    }

    public static void removeAcompanhamento(int opc){
        listaAcompanhamentos[opc-1]=null;
    }

    public static void compactaArrayAcompanhamentos(AcompanhamentoIA[] acompanhamentos){
        int tam = acompanhamentos.length;
        int destino=0;
        for (int i = 0; i<tam;i++){
            if (acompanhamentos[i]!=null){
                acompanhamentos[destino]=acompanhamentos[i];
                destino++;
            }
        }
        
        while (destino < tam){
            acompanhamentos[destino]=null;
            destino++;
        }  
    }

    public static boolean avisoRemocao(){
        System.out.println("\nATENÇÃO! VOCÊ TEM CERTEZA QUE DESEJA REMOVER PERMANENTEMENTE UM ALUNO E TODAS AS SUAS OUTRAS INFORMAÇÕES?\n1 - Sim\n2 - Não");
        int x = lerInteiro(teclado);
        return x == 1;
    }

    public static void ordenaAlunos()
    {
        for(int i = 0; i < listaAlunos.length - 1; i++)
        {
            for(int j = 0; j < listaAlunos.length - 1 - i; j++)
            {
                if(listaAlunos[j] != null && listaAlunos[j + 1] != null)
                {
                    if(listaAlunos[j].getPessoa().getNome().compareToIgnoreCase(listaAlunos[j + 1].getPessoa().getNome()) > 0)
                    {
                        Aluno aux = listaAlunos[j];
                        listaAlunos[j] = listaAlunos[j + 1];
                        listaAlunos[j + 1] = aux;
                    }
                }
            }
        }
    }

    public static void ordenaBolsistas()
    {
        for(int i = 0; i < listaBolsistas.length - 1; i++)
        {
            for(int j = 0; j < listaBolsistas.length - 1 - i; j++)
            {
                if(listaBolsistas[j] != null && listaBolsistas[j + 1] != null)
                {
                    if(listaBolsistas[j].getAluno().getPessoa().getNome().compareToIgnoreCase(listaBolsistas[j + 1].getAluno().getPessoa().getNome()) > 0)
                    {
                        BolsistaIC aux = listaBolsistas[j];
                        listaBolsistas[j] = listaBolsistas[j + 1];
                        listaBolsistas[j + 1] = aux;
                    }
                }
            }
        }
    }

    public static void listaBolsistas()
    {
        System.out.println("Lista de Bolsistas:");
        for (int i = 0; i < listaBolsistas.length; i++){
            if (listaBolsistas[i] != null){
                System.out.println((i+1) +" - "+listaBolsistas[i].getAluno().getPessoa().getNome()+" | Matrícula: "+listaBolsistas[i].getAluno().getMatricula());
            }
        }
    }
    
    public static int contadorVogais(String str)// da biblioteca :)
    {
        int tam = str.length();
        int soma = 0;
        
        for (int i = 0; i<= tam-1; i++)
        {
            char c = str.charAt(i);
            
            switch (c)
            {
                case 'A':
                case 'a':
                case 'á':
                case 'â':
                case 'ã':
                case 'E':    
                case 'e':
                case 'é':
                case 'ê':
                case 'I':  
                case 'i':
                case 'í':  
                case 'O':  
                case 'o':
                case 'ó':
                case 'ô':
                case 'õ': 
                case 'U':   
                case 'u':
                case 'ú':
                    soma++;
                    break;
            }
        }
        return soma;
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

    public static void percentualAlunos(){
        
        int totalAlunos = 0;
        int[] contagemCursos = new int[5]; // Índices: 0 - Ciência da Computação, 1 - Engenharia de Software, 2 - Ciência de Dados e IA, 3 - Engenharia da Computação, 4 - Sistemas de Informação

        for (Aluno aluno : listaAlunos) {
            if (aluno != null) {
                totalAlunos++;
                switch (aluno.getCurso()) {
                    case "Ciência da Computação":
                        contagemCursos[0]++;
                        break;
                    case "Engenharia de Software":
                        contagemCursos[1]++;
                        break;
                    case "Ciência de Dados e Inteligência Artificial":
                        contagemCursos[2]++;
                        break;
                    case "Engenharia da Computação":
                        contagemCursos[3]++;
                        break;
                    case "Sistemas de Informação":
                        contagemCursos[4]++;
                        break;
                }
            }
        }

        System.out.println("\nPercentual de alunos por curso:\n");
        String[] cursos = {"Ciência da Computação", "Engenharia de Software", "Ciência de Dados e Inteligência Artificial", "Engenharia da Computação", "Sistemas de Informação"};
        for (int i = 0; i < cursos.length; i++) {
            double percentual;
            
            if (totalAlunos > 0) {
                percentual = ((double) contagemCursos[i] / totalAlunos) * 100;
            } else {
                percentual = 0;
            }
            System.out.printf("%s: %.2f%%\n", cursos[i], percentual);
        }
    }
    
    public static void menu() {
        System.out.println("\f");
        System.out.println("""
        ┌────────────────────────────────────────────────────────────────────────┐
        │    SISTEMA DE MONITORAMENTO PEDAGÓGICO DE CURSOS DE TECNOLOGIA DA      │
        │                      ESCOLA POLITÉCNICA DA PUCRS                       │
        ├────────────────────────────────────────────────────────────────────────┤
        │ [01] - Cadastrar aluno                                                 │
        │ [02] - Cadastrar bolsista de IC                                        │
        │ [03] - Registrar ou atualizar acompanhamento do uso de IA              │
        │ [04] - Listar dados de um aluno específico                             │
        │ [05] - Listar dados de um bolsista de IC específico                    │
        │ [06] - Mostrar nome mais longo                                         │
        │ [07] - Contar vogais nos nomes cadastrados                             │
        │ [08] - Percentual de alunos por curso                                  │
        │ [09] - Média de idade dos alunos                                       │
        │ [10] - Remover um aluno da lista de chamada                            │
        │ [11] - Exibir lista de chamada em ordem alfabética                     │
        │ [12] - Calcular risco pedagógico relacionado ao uso de IA              │
        │ [13] - Exibir relatório geral de risco por aluno                       │
        │ [14] - Exibir alunos em risco alto                                     │
        │ [15] - GERENCIADOR DE NOTAS 2000 *NOVO!*                               │             
        ├────────────────────────────────────────────────────────────────────────┤
        │ [00] Sair do Sistema                                                   │
        └────────────────────────────────────────────────────────────────────────┘""");
        System.out.print("\nEscolha uma opção: ");
        
    }

    public static void menuTransicao(){
        System.out.println("\n1 - Voltar ao menu principal");
        System.out.println("2 - Encerrar aplicação");
        int opc = lerInteiro(teclado);
        switch (opc){
            case 1: break;
            case 2: System.out.println("Fechando a aplicação..."); System.exit(0); break;
            default: System.out.println("Opção invalida! Retornando ao menu principal..."); break;
        }
    }

    public static String selecionaCursos(){
        System.out.println();
        System.out.println("""
        ┌────────────────────────────────────────────────────┐
        │                   MENU DE CURSOS                   │
        ├────────────────────────────────────────────────────┤
        │ [1] - Ciência da Computação                        │
        │ [2] - Engenharia de Software                       │
        │ [3] - Ciência de Dados e Inteligência Artificial   │
        │ [4] - Engenharia da Computação                     │
        │ [5] - Sistemas de Informação                       │
        └────────────────────────────────────────────────────┘""");
        int opc = lerInteiro(teclado, "Escolha seu curso: ");
        switch(opc){
            case 1: return "Ciência da Computação";
            case 2: return "Engenharia de Software";
            case 3: return "Ciência de Dados e Inteligência Artificial";
            case 4: return "Engenharia da Computação";
            case 5: return "Sistemas de Informação";
            default: System.out.println("Opção inválida!"); return selecionaCursos();
        }
    }
}
