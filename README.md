# Tutorial1_CM_14301

### 1. Geracao de Quadrados (cm.exer_1.kt)
O objetivo deste programa e gerar e imprimir os quadrados dos primeiros 50 numeros inteiros (de 1 a 2500).

Para demonstrar a versatilidade da linguagem **Kotlin**, o exercicio foi resolvido de tres formas distintas:
* **Utilizando IntArray**: Criado um array de inteiros primitivos com tamanho fixo.
* **Utilizando Programacao Funcional (map)**: Gerada uma lista a partir de um intervalo (1..50), aplicando uma funcao de mapeamento.
* **Utilizando Array generico**: Uso da classe Array de objetos para calculo via indice.

---

### 2. Calculadora Multifuncoes (cm.exer_2.kt)
Este programa implementa uma calculadora interativa que suporta operacoes aritmeticas, logicas e bitwise, apresentando os resultados em multiplos formatos.

#### **Funcionalidades Principais:**
* **Operacoes Aritmeticas**: Soma, subtracao, multiplicacao e divisao com suporte a numeros decimais.
* **Operacoes Logicas**: Implementacao de portas logicas AND (&&), OR (||) e NOT (!) com entradas booleanas.
* **Operacoes Bitwise**: Suporte a deslocamento de bits para a esquerda (shl) e para a direita (shr).
* **Conversao de Bases**: Para cada operacao, o programa exibe o resultado em tres formatos:
    * **Decimal**: Valor numerico real ou 0/1 para booleanos.
    * **Hexadecimal**: Representacao em base 16 com o prefixo 0x.
    * **Boolean**: Verificacao logica (se o valor e diferente de zero).

---

### 3. Simulacao de Salto de Bola (cm.exer_3.kt)
Este programa simula a perda de altura de uma bola a cada salto, utilizando uma abordagem de sequencia infinita (Lazy Evaluation).

#### **Logica Implementada:**
* **Geracao de Sequencia**: Utiliza `generateSequence` para calcular a altura de cada salto, assumindo que a bola retoma 60% da altura anterior (fator 0.60).
* **Filtros e Limites**: 
    * Comeca numa altura inicial de 100 metros.
    * Filtra apenas valores positivos.
    * Limita a recolha aos primeiros 15 saltos utilizando a funcao `take(15)`.
* **Formatacao**: Exibe as alturas no terminal arredondadas a duas casas decimais (metros).

---

### 4. Primeira Aplicacao Android - Hello World & Calendar (MainActivity.kt)
Este exercicio marca o inicio do desenvolvimento nativo para Android, focando-se na criacao de uma interface grafica (UI) e na interacao com elementos do sistema.

#### **Componentes da Interface (XML):**
* **TextViews**: Utilizacao de labels com diferentes estilos, cores (amarelo e roxo) e tamanhos de fonte para exibir mensagens de boas-vindas.
* **ImageView**: Insercao de uma imagem (`smileygood`) para personalizar o visual da app.
* **CalendarView**: Um calendario interativo posicionado na base do ecrã.

#### **Logica de Programacao (Kotlin):**
* **MainActivity**: Herda de `AppCompatActivity` e gere o ciclo de vida da aplicacao (metodo `onCreate`).
* **Interatividade**: Foi implementado um `setOnDateChangeListener` no Calendario. Quando o utilizador clica numa data, a App exibe um **Toast** (uma pequena mensagem temporaria no fundo do ecra) com a data selecionada no formato `DD/MM/AAAA`.
* **Edge-to-Edge**: Configuracao para que a aplicacao utilize todo o espaco do ecra, incluindo as barras de sistema, garantindo um design moderno.
* **Logs**: O programa imprime o nome da classe e o estado do ciclo de vida no terminal (Logcat) para fins de depuracao.

---

### 5. Visualizador de Informacoes do Sistema (MultiLineTextWidget)
Esta aplicacao Android tem como objetivo extrair e exibir informacoes detalhadas sobre o hardware e o software do dispositivo (ou emulador) onde esta a correr.

#### **Conceitos Implementados:**
* **Classe Build**: Utilizacao da biblioteca `android.os.Build` para aceder a propriedades do sistema como Fabricante (`MANUFACTURER`), Modelo (`MODEL`), Marca (`BRAND`) e versoes de SDK.
* **Formatacao com Strings.xml**: Em vez de escrever o texto diretamente no codigo (Hardcoded), foi utilizado um template no ficheiro `strings.xml` com marcadores de posicao (`%1$s`, `%2$d`, etc.). Isto facilita a manutencao e futura traducao da app.
* **Manipulacao de UI**: Uso de `findViewById` para ligar a logica em Kotlin ao componente `TextView` do layout, atualizando o seu conteudo dinamicamente.
* **Edge-to-Edge**: Implementacao de suporte para o design moderno do Android, ajustando o preenchimento (padding) da vista para evitar sobreposicao com as barras de estado e de navegacao do sistema.

#### **Dados Exibidos:**
O programa apresenta uma lista formatada contendo: Fabricante, Modelo, Marca, Tipo de Build, Utilizador, Versao Base, Versao Incremental, Nivel de SDK, Versao do Android e Identificacao do Display.

---

### 6. Sistema de Gestao de Biblioteca (Main.kt)
Este programa e um sistema completo de gestao de livros que aplica os pilares da Programacao Orientada a Objetos (POO) em Kotlin para simular o funcionamento de uma biblioteca.

#### **Conceitos de POO Aplicados:**
* **Abstracao e Heranca**: Criacao de uma classe abstrata `Book` que serve de molde para tipos especificos de livros (`DigitalBook` e `PhysicalBook`).
* **Polimorfismo**: Utilizacao do metodo abstrato `getStorageInfo()`, onde cada tipo de livro decide como exibir a sua informacao de armazenamento (MB para digitais, gramas para fisicos).
* **Encapsulamento (Getters/Setters Customizados)**: Implementacao de logica de validacao na variavel `availableCopies` para impedir stock negativo e emitir avisos automaticamente quando um livro esgota.
* **Gestao de Colecoes**: Utilizacao de uma `MutableList` dentro da classe `Library` para armazenar, procurar, adicionar e remover livros dinamicamente.

#### **Funcionalidades do Sistema:**
* **Classificacao por Eras**: O sistema classifica automaticamente os livros como "Classic", "Modern" ou "Contemporary" com base no ano de publicacao.
* **Operacoes de Emprestimo**: Logica para verificar disponibilidade, reduzir o stock no emprestimo e aumentar na devolucao.
* **Pesquisa Avancada**: Funcao para listar todos os livros de um determinado autor existentes no acervo.
* **Controlo de Inventario**: Registo do numero total de livros adicionados ao sistema desde a criacao da biblioteca.

---