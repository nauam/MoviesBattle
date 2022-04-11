# MoviesBattle - Desafio Lets's Code

<p align="center">
  <img src="https://img.shields.io/static/v1?label=java&message=11&color=blue&style=for-the-badge&logo=java"/> <img src="https://img.shields.io/static/v1?label=maven&message=4.0.0&color=red&style=for-the-badge&logo=apache"/> <img src="http://img.shields.io/static/v1?label=spring-boot&message=2.6.6&color=red&style=for-the-badge&logo=spring"/>
</p>
<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM ANDAMENTO&color=green&style=for-the-badge"/> <img src="http://img.shields.io/static/v1?label=License&message=GNU&color=green&style=for-the-badge"/>
</p>

### Tópicos 

:small_blue_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_blue_diamond: [Requisitos](#requisitos)

:small_blue_diamond: [Pré-requisitos](#pré-requisitos)

:small_blue_diamond: [Dependências](#dependências)

:small_blue_diamond: [Como rodar a aplicação](#como-rodar-a-aplicação-arrow_forward)

:small_blue_diamond: [Cadastro](#cadastro)

:small_blue_diamond: [Login](#login)

:small_blue_diamond: [Listar Filmes](#listar-filmes)

:small_blue_diamond: [Como concluir o projeto](#como-concluir-o-projeto)

:small_blue_diamond: [Conclusão](#conclusao)

:small_blue_diamond: [Licença](#licenca)

## Descrição do projeto 

<p align="justify">
   API REST para uma aplicação ao estilo card game, onde serão informados dois filmes e o jogador deve acertar aquele que possui melhor avaliação no IMDB. 
</p>

## Requisitos

### Funcionais

:heavy_check_mark: O jogador deve fazer login para iniciar uma nova partida,

:heavy_check_mark: Dois usuários/jogadores já configurados,

:heavy_multiplication_x: Cada rodada do jogo consiste em informar um par de filmes,

:heavy_multiplication_x: O jogador deve tentar acertar qual filme possui maior pontuação,

:heavy_multiplication_x: Ranking.

### Não Funcionais 

:heavy_check_mark: Armazene os dados em H2,

:heavy_check_mark: Aplicação iniciada usando webscraping,

:heavy_multiplication_x: Testes unitários,

:heavy_multiplication_x: Documentação da API com base no OpenAPI 3.0,

:heavy_check_mark: Solução de autenticação - JWT.

## Pré-requisitos

:warning: [JDK 11](https://www.oracle.com/br/java/technologies/javase-downloads.html)

:warning: [Apache Maven](https://maven.apache.org/download.cgi)

:warning: [Postman](https://www.postman.com/downloads/)

## Dependências

:wrench: H2 Database

:wrench: Spring Data JPA

:wrench: Spring Web

:wrench: Validation

:wrench: Lombok

:wrench: Security

:wrench: JWT

:wrench: Validation

:wrench: jsoup

## Como rodar a aplicação :arrow_forward:

### clone o projeto

```
git clone https://github.com/nauam/MoviesBattle.git
cd MoviesBattle/api-movies-battle/
```
### Construção
Para construir o projeto com o Maven, executar os comando abaixo:

```
mvn clean install
```

O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.

### Execução
Para executar o projeto com o Maven Spring Boot Plugin, executar os comando abaixo:

```
mvn spring-boot:run
```
O comando irá rodar o projeto e subir na porta 8080


## Cadastro:

```localhost:8080/signup```

<details><summary><b>Payload (Clique aqui)</b></summary>

Cadastrar uma nova conta: [**POST**]
```json
{
	"username" : "Maria de Nazaré Esteves Tedesco",
	"email" : "nazare.tedesco@outlook.com",
	"password": "10131949004"
}
```

Caso ocorra como esperado:
```json
{
    "message": "Usuário cadastrado com sucesso!"
}
```

Caso ocorra algum erro de validação irá aparecer:
```json
{
    "status": 400,
    "msg": "Erro de validação",
    "timeStamp": 1649641200705,
    "errors": [
        {
            "fieldName": "username",
            "message": "Username já existente"
        }
		.
		.
		.
    ]
}
```

Validação dos campos:

:boy: username - tamanho entre 3 a 120 caracteres e não pode está em branco

:key: password - tamanho entre 8 a 120 caracteres e não pode está em branco

:email: email será validado.

</details>


## Login:

```localhost:8080/signin```

<details><summary><b>Payload (Clique aqui)</b></summary>

Logar na conta: [**POST**]
```json
{
	"username" : "Maria de Nazaré Esteves Tedesco",
	"password": "10131949004"
}
```

Caso ocorra como esperado:
```json
{
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJNYXJpYSBkZSBOYXphcsOpIEVzdGV2ZXMgVGVkZXNjbyIsImV4cCI6MTY0OTY0MTkzM30.FxwVA7JnB6uuIxraTfy5lnxW7DzwMrpVYi9w22LiQiQ6sGdND3OFOBjCbXo-8HauuyyG1O99qOFXgfMCAmZeLw",
    "id": 4,
    "username": "Maria de Nazaré Esteves Tedesco",
    "email": "nazare.tedesco@outlook.com"
}
```

Caso ocorra algum erro de validação irá aparecer:
```json
{
    "status": 400,
    "msg": "Erro de validação",
    "timeStamp": 1649641772269,
    "errors": [
        {
            "fieldName": "username",
            "message": "Username não existente"
        }
    ]
}
```

</details>


## Listar filmes:

```localhost:8080/imdb/list```

<details><summary><b>Payload (Clique aqui)</b></summary>

Ver os 250 melhores filmes rankeados do IMDB: [**GET**]
```Headers
	KEY: Authorization,
	VALUE: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJNYXJpYSBkZSBOYXphcsOpIEVzdGV2ZXMgVGVkZXNjbyIsImV4cCI6MTY0OTY0MTkzM30.FxwVA7JnB6uuIxraTfy5lnxW7DzwMrpVYi9w22LiQiQ6sGdND3OFOBjCbXo-8HauuyyG1O99qOFXgfMCAmZeLw
```

Caso ocorra como esperado:
```json
[
    {
        "id": 1,
        "ranking": "1",
        "rating": "9.2",
        "name": "Um Sonho de Liberdade (1994)"
    },
    {
        "id": 2,
        "ranking": "2",
        "rating": "9.2",
        "name": "O Poderoso Chefão (1972)"
    },
	.
	.
	.
]
```

</details>

## Como concluir o projeto:

O projeto conta com a funcionalidade de encriptar a senha dos usuário para salvar no banco de dados, isso permite que haja uma segurança maior. 

A funcionalidade de autenticação foi feita usando o JWT (JSON Web Token) que é um método RCT 7519 padrão da indústria para realizar autenticação entre duas partes por meio de um token assinado que autentica uma requisição web. Esse token é um código em Base64 que armazena objetos JSON com os dados que permitem a autenticação da requisição. Para acessar qualquer endpoint é necessário está autenticado, exceto para os endpoints de cadastro ```/signup``` e o de login ```/signin```.

Cada requisição feita, há um padrão de validação do payload que deve ser seguida, por exemplo, para o signup o campo username deve conter entre 3 a 120 caracteres, não pode está em branco e tem que ser único, o campo de password deve conter entre 8 a 120 caracteres e não pode está em branco e por fim o campo email é validado e deve conter as três partes principais: a parte local, um símbolo @ e um domínio. Caso haja algum campo invalido, aparecerá uma mensagem de explicando o erro de validação.

Quando o projeto é rodado, dois jogadores são criados o Player1 ```{"username": Player1, "password": luvadepedreiro}``` e o Player2 ```{"username": Player2, "password": jaacaboujessica}```.

A base de dados é formada pelos 250 melhores filmes rankeados do IMDB e é baseada do site oficial do [IMDb](https://www.imdb.com/chart/top/?ref_=nv_mv_250), onde é usado o WebScrapping para respar os dados da pagina e salvar no BD (banco de dados). As informações que são pegas no site são referente ao ranking, nota, nome e ano de lançamento. Para gerar esse banco de dados é necessário está autenticado e acessar o endpoint ```/imdb/list```, essa funcionalidade ainda tem que ser melhorada para gerar o BD ao rodar o projeto.

Devido ao tempo para codificar a aplicação, as regras de negócio do jogo não foram implementadas, mas essas regras seriam:

Com o usuário devidamente autenticado, o jogo seria inicializado pelo endpoint  ```game/quiz/start``` com @GetMapping e teria como resposta o numero da partida, posição em tela do filme 1, nome do filme 1, posição em tela do filme 2, nome do filme 2, numero de acertos, o numero de erros, ranking e se a partida está finalizada a resposta seria assim:

```json
{
    "quiz": 1,
    "choice": [{
        "position": "LEFT",
        "name": "O Poderoso Chefão (1972)"
    },{
        "position": "RIGHT",
        "name": "Um Sonho de Liberdade (1994)"
    }],
    "score": 0,
    "failure": 0,
    "ranking": 5,
    "finish": false
}
```

Para validar a resposta o endpoint seria ```game/answer/{$quiz}?choice={$position}``` com @PutMapping e teria como resposta o numero da nova partida, se a resposta estava certo ou errada, numero de acertos, o numero de erros, ranking e se a partida está finalizada a resposta seria assim:

```json
{
    "quiz": 1,
    "answer": "correct",
    "score": 1,
    "failure": 0,
    "ranking": 3,
    "finish": false
}
```

Caso erre 3 vezes a resposta seria assim:

```json
{
    "quiz": 3,
    "answer": "wrong",
    "score": 0,
    "failure": 3,
    "ranking": 5,
    "finish": true
}
```

Para continuar o jogo o endpoint seria ```game/quiz/next``` com @GetMapping e teria como resposta igual ao endpoint  ```game/quiz/start```:


```json
{
    "quiz": 2,
    "choice": [{
        "position": "LEFT",
        "name": "O Poderoso Chefão (1972)"
    },{
        "position": "RIGHT",
        "name": "Batman: O Cavaleiro das Trevas"
    }],
    "score": 1,
    "failure": 0,
    "ranking": 3,
    "finish": false
}
```

O jogo pode ser finalizado pelo usuário a partir do endpoint ```game/quiz/finish``` com @GetMapping e teria como resposta o numero de acertos, o numero de erros, ranking e se a partida está finalizada, a resposta seria assim:

```json
{
    "score": 1,
    "failure": 0,
    "ranking": 3,
    "finish": true
}
```

A listagem do ranking pode ser visualizado pelo usuário a partir do endpoint ```game/ranking``` com @GetMapping e teria como resposta o numero de acertos, o numero de erros, ranking e se a partida está finalizada, a resposta seria assim:

```json
{
    "1": {
        "username": "player2"
    },
    "2": {
        "username": "player1"
    },
    "3": {
        "username": "player1"
    },
    .
    .
    .
    "5": {
        "username": "player10"
    }
}
```

Devido ao tempo, não foi implementado os testes unitários na aplicação, o teste unitário consiste em verificar o comportamento das menores unidades na aplicação.

## Conclusão

Essa aplicação me fez/fará colocar bastante teória em prátrica e também colocar bastante coisas que eu vejo no meu dia a dia como desenvolvedor em um projeto totalmente novo. 


## Licença

The [GNU General Public License v3.0]()

Copyright &copy;  2022 - MoviesBattle - Desafio Lets's Code (Nauam)
