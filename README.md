**Sistema de Gestão da Biblioteca Municipal**<br>
**1. Descrição**:<br>
O Sistema de Gestão da Biblioteca Municipal é uma aplicação desenvolvida em linguagem Java e executada através da consola.
O sistema foi desenvolvido para facilitar o controlo do inventário de livros, utilizadores e operações de empréstimo e devolução.
Os dados são armazenados temporariamente em memória através de arrays e matrizes, não sendo necessária uma base de dados externa.

**2. Funcionalidades**:<br>
**Registo de novo livro**-Insericao de novos titulos, autores, ano  e quantidade; <br>
**Registo de novo utilizador** - Registo de leitores na Biblioteca;<br>
**Consulta do catálogo de livros** - Pesquisar todos livros por titulo ou autor<br>
Pesquisar Livros por título ou autor;<br>
**Efectuar empréstimo de livro** - Emprestar livro a um utilizador registado e registar a devolucao.<br>
**Apresentar Estatísticas** - Historico de livros emprestados, consoante o numero total dos livros mais requisitado<br>

**3. Tecnologias utilizadas**:<br>
Java;<br>
Arrays;<br>
Matrizes;<br>
Estruturas condicionai;s<br>
Estruturas de repetição;<br>
Métodos;<br>
Programação orientada a objectos/conceitos fundamentais de programação Java;<br>
Gi;t<br>
GitHub;<br>

**4. Requisitos**:<br>
Para executar o projecto é necessário ter instalado:
JDK 17 ou versão superior;<br>
Git, caso pretenda clonar o projecto através do terminal.

**5. Clonar o projecto**:<br>
No terminal, execute:
git clone URL_DO_REPOSITORIO
Depois entre na pasta:
cd BibliotecaMunicipal

**6. Compilação**<br>
Entre na pasta onde se encontra o ficheiro Java e execute:
javac BibliotecaMunicipal.java<br>

**7. Execução**<br>
Depois da compilação, execute:
java BibliotecaMunicipal

**8. Menu do sistema**<br>
O programa apresenta um menu com as seguintes opções:
Registar livro<br>
Listar livros disponíveis<br>
Pesquisar livro<br>
Registar utilizador<br>
Listar utilizadores<br>
Efectuar empréstimo<br>
Registar devolução<br>
Consultar histórico<br>
Ver estatísticas<br>
Sair

**9. Armazenamento dos dados**
O projecto utiliza arrays e matrizes para simular uma base de dados em memória.
Os dados são mantidos apenas enquanto o programa estiver em execução. Ao fechar o programa, os dados são perdidos.
10. Estrutura do projecto<br>
BibliotecaMunicipal/<br>
│
├── src/<br>
│   └── BibliotecaMunicipal.java<br>
│
├── README.md<br>
│
└── .gitignore

**12. Autor**<br>
Estudante Lopes Paulo Tchauque<br>
Introdução a Algoritmos e Programação<br>
**UNISCED**<br>
