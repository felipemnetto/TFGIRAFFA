----------------------------------------------------------------------------
Este é o arquivo README do projeto. Você deve descrever aqui o seu projeto.
Informe ao usuário (alguém que não sabe nada sobre este projeto!) tudo que
ele/ela precisa saber. Os comentários devem incluir, pelo menos:
------------------------------------------------------------------------

TÍTULO DO PROJETO: SISTEMA DE MONITORAMENTO PEDAGÓGICO DE CURSOS DE TÉCNOLOGIA DA ESCOLA POLITÉCNICA DA PUCRS

OBJETIVO DO PROJETO: Auxiliar o professor com o acompanhamento dos estudantes de determinada turma, 
verificando se  estão utilizando ferramentas de IA no processo de aprendizagem, identificando situações que possam
indicar uso pouco formativo, dependência excessiva ou fragilidade na compreensão do
código produzido.

AUTORES: Eduardo Quadra Siminovich - 26102761, Felipe Kreismann Brigo - 26102885, Felipe Nonticuri Martins Netto - 26102890

DESCRIÇÃO GERAL DO SISTEMA: O programa apresenta um menu com 15 opções de monitoramento, visualização e cadastro de estudantes
e suas respectivas informações a respeito de todos os possíveis atributos vinculados a eles.

EXPLICAÇÃO DAS CLASSES UTILIZADAS: A aplicação é composta por quatro classes principais que representam diferentes níveis de informações 
relacionadas aos estudantes. A classe Pessoa armazena os dados básicos de um indivíduo, como nome, idade e local de nascimento, 
disponibilizando métodos de acesso e modificação desses atributos. A classe Aluno utiliza um objeto da classe Pessoa para representar um estudante,
acrescentando informações acadêmicas, como curso, matrícula, semestre, ano de ingresso e indicação de bolsa. A classe BolsistaIC representa um aluno 
participante de um projeto de Iniciação Científica, armazenando os dados do aluno juntamente com o projeto desenvolvido e o nome do orientador responsável. 
Por fim, a classe AcompanhamentoIA realiza o monitoramento do uso de Inteligência Artificial por um aluno, registrando métricas como quantidade de atividades entregues, 
atividades realizadas com auxílio de IA, atividades explicadas, códigos produzidos sem ajuda, entregas não estudadas e o nível de risco pedagógico calculado. 
Fora estas classes principais, adicionamos uma nova classe que faz parte do nosso "método inovador", a classe Notas, que é responsável por armazenar e gerenciar as notas 
de um aluno, mantendo uma associação com a classe Aluno. Ela registra as notas de trabalhos e provas em vetores, além da quantidade de avaliações de cada tipo. A classe 
fornece métodos para inserir e consultar as notas e inclui funcionalidades para calcular a média dos trabalhos, desconsiderando a menor nota, e a média das provas. Dessa forma, 
concentra o controle e o processamento do desempenho acadêmico do estudante.

LÓGICA PARA RISCO PEDAGÓGICO: Alunos com risco baixo utilizam a IA de forma consciente, conseguem explicar e modificar seus códigos e demonstram domínio do conteúdo. No risco moderado, há sinais de dependência parcial da IA 
e dificuldades em compreender ou alterar as soluções. Já o risco alto caracteriza alunos que dependem fortemente da IA, não conseguem explicar ou modificar os códigos produzidos e utilizam estruturas que ainda não dominam.

FONTES DE CONSULTAS UTILIZADAS: Não utilizamos nenhuma fonte de consulta.

FERRAMENTAS DE IA UTILIZADAS: Consultamos o Claude AI para tentar utilizar o "tratamento de exceção". A principal dúvida era como aplicar o método de leitura em diferentes partes do programa, tanto com quanto sem uma mensagem ao usuário. Como solução, foi implementada a sobrecarga do método `lerInteiro`, criando uma versão que recebe apenas o Scanner e outra que recebe o Scanner e uma mensagem. A primeira apenas chama a segunda passando uma mensagem vazia, reutilizando toda a lógica de validação em um único método. Essa abordagem reduziu a duplicação de código, facilitou a reutilização da função e tornou a leitura de dados mais segura por meio do tratamento de exceções (try/catch).

**Resumo da interação com a IA:** Foram realizadas perguntas sobre como aplicar um método de validação de entrada em diferentes partes do programa, como utilizá-lo com e sem mensagens ao usuário e como implementar sobrecarga de métodos em Java. A IA explicou o conceito de sobrecarga, sugeriu uma implementação com duas versões do método `lerInteiro`, indicou como substituir as leituras de inteiros existentes no código e esclareceu como essa solução evita repetição de código e melhora a validação das entradas.

DIFICULDADES ENCONTRADAS: Ao longo da produção deste código, nos deparamos com algumas dificuldades como na hora de organizar a listagem separada dos alunos e dos bolsistas,
na otimização de certos métodos quando eles ficavam desnecessariamente "pesados"(algo que acabava virando um efeito em cadeia pois cada vez que alteravamos algum método e/ou alguma sistematização de váriaveis, 
acabavamos tendo que mudar mais outros métodos no meio disso tudo também) e, principalmente, quando fomos desenvolver os métodos para as seções de acompanhamento de IA. Ficamos muito tempo ponderando a respeito 
de como iriamos implementar as váriaveis da classe de acompanhamento. Se iríamos criar um novo vetor para isso ou simplesmente implementar eles dentro dos vetores que ja tinhamos instanciado. Com tudo isso, acabamos
perdendo mais tempo pensando a respeito de qual seria o melhor caminho para metodificar tudo do que de fato programando os "cases".

LIÇÕES APRENDIDAS COM O TRABALHO: Acreditamos que, após este trabalho, tenhamos consolidado um pouco mais os conceitos e a metodologia da Programação Orientada a Objetos (POO). 
Também conseguimos desenvolver mais as linhas de raciocínio para implementação de métodos com suas respectivas funções, principalmente aqueles responsáveis por cadastrar informações, 
percorrer listas de objetos e manipular referências entre classes(que foram os que mais tivemos dificuldades, e consequentemente, passamos mais tempo trabalhando em cima deles). 
Além disso, o desenvolvimento do sistema contribuiu para aprimorar a criação de menus interativos, o tratamento de entradas do usuário, a utilização de vetores, estruturas de repetição e métodos auxiliares, 
além da organização do código em funções menores e mais reutilizáveis.

DIVISÃO DE TAREFAS: 
Eduardo Siminovich: Método de inovação(criação da classe Notas inclusa) e criação do "display" de todos os menus no código.
Felipe Brigo: Métodos padrões(menos os envolvidos em AcompanhamentoIA) e criação/modificação das classes.
Felipe Netto: Todos os métodos relacionados ao AcompanhamentoIA e criação/modificação das classes.
