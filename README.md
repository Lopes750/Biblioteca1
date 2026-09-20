Sistema de Gestão da Biblioteca Municipal
1. Descrição
O Sistema de Gestão da Biblioteca Municipal é uma aplicação desenvolvida em linguagem Java e executada através da consola.
O sistema foi desenvolvido para facilitar o controlo do inventário de livros, utilizadores e operações de empréstimo e devolução.
Os dados são armazenados temporariamente em memória através de arrays e matrizes, não sendo necessária uma base de dados externa.

2. Funcionalidades
Registo de novo livro;
Registo de novo utilizador
Consulta do catálogo de livros;
Pesquisar Livros por título ou autor;
Efectuar empréstimo de livro;
Efectuar devolução de livros;
Apresentar Estatísticas;


3. Tecnologias utilizadas
Java
Arrays
Matrizes
Estruturas condicionais
Estruturas de repetição
Métodos
Programação orientada a objectos/conceitos fundamentais de programação Java
Git
GitHub

4. Requisitos
Para executar o projecto é necessário ter instalado:
JDK 17 ou versão superior;
Git, caso pretenda clonar o projecto através do terminal.

5. Clonar o projecto
No terminal, execute:
git clone URL_DO_REPOSITORIO
Depois entre na pasta:
cd BibliotecaMunicipal

6. Compilação
Entre na pasta onde se encontra o ficheiro Java e execute:
javac BibliotecaMunicipal.java
7. Execução

Depois da compilação, execute:
java BibliotecaMunicipal

8. Menu do sistema
O programa apresenta um menu com as seguintes opções:
Registar livro
Listar livros disponíveis
Pesquisar livro
Registar utilizador
Listar utilizadores
Efectuar empréstimo
Registar devolução
Consultar histórico
Ver estatísticas
Sair

9. Armazenamento dos dados
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

12. Autor<br>
Estudante Lopes Paulo Tchauque<br>
Introdução a Algoritmos e Programação<br>
UNISCED<br>
