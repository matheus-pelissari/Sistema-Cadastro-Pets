# Sistema de Cadastro de Pets

Sistema de cadastro de pets encontrados, desenvolvido em Java. Permite cadastrar, alterar, deletar e listar pets, com persistência dos dados em arquivos JSON.

## 🐾 Sobre o projeto

A aplicação funciona via terminal, apresentando um menu interativo para o usuário gerenciar registros de pets encontrados (nome, tipo, sexo, local onde foi encontrado, idade, peso e raça).

## 🛠️ Tecnologias utilizadas

- **Java 17**
- **Maven** (gerenciador de dependências e build)
- **Jackson Databind** (`2.17.0`) — serialização/deserialização de JSON
- **Jackson Datatype JSR310** (`2.17.0`) — suporte a `LocalDate`/`LocalDateTime` no Jackson

## 📁 Estrutura do projeto

```
sistema-cadastro/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           ├── controller/
│           │   └── PetController.java
│           └── dao/
│               └── PetDao.java
├── formulario.json      # Perguntas exibidas ao cadastrar/alterar um pet
├── menu.json            # Opções do menu principal
└── pets.json            # Base de dados dos pets cadastrados
```

- **`controller/PetController.java`** — camada responsável pela interação com o usuário (menu, formulário e regras de fluxo).
- **`dao/PetDao.java`** — camada de acesso a dados, responsável por ler e gravar as informações em `pets.json`.

## 📋 Menu principal

O menu é carregado a partir de `menu.json` e oferece as seguintes opções:

| Opção | Ação |
|---|---|
| 1 | Cadastrar um novo pet |
| 2 | Alterar os dados do pet cadastrado |
| 3 | Deletar um pet cadastrado |
| 4 | Listar todos os pets cadastrados |
| 5 | Listar pets por algum critério (idade, nome, raça) |
| 6 | Sair |

## 📝 Formulário de cadastro

As perguntas feitas durante o cadastro/alteração de um pet vêm de `formulario.json`:

1. Nome e sobrenome do pet
2. Tipo do pet (Cachorro/Gato)
3. Sexo do animal (Masculino/Feminino)
4. Cidade onde foi encontrado
5. Rua onde foi encontrado
6. Número da rua
7. Idade aproximada
8. Peso aproximado
9. Raça do pet

## 💾 Armazenamento dos dados

Os pets cadastrados são persistidos no arquivo `pets.json`, no seguinte formato:

```json
{
  "nomeSobrenome": "pet um",
  "raca": "raca s",
  "tipo": "Gato",
  "sexo": "Masculino",
  "idade": 5.0,
  "peso": 5.0,
  "endereco": "cidade a, rua a, 10",
  "dateCreation": "16-07-2026 05:36"
}
```

- `endereco` é montado a partir da cidade, rua e número informados no formulário.
- `dateCreation` registra a data e hora do cadastro no formato `dd-MM-yyyy HH:mm`.

## ▶️ Como executar

### Pré-requisitos

- JDK 17 instalado
- Maven instalado

### Passos

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
   cd sistema-cadastro
   ```

2. Compile o projeto com Maven:
   ```bash
   mvn compile
   ```

3. Execute a aplicação (ajuste a classe principal conforme o `main` do projeto):
   ```bash
   mvn exec:java -Dexec.mainClass="controller.PetController"
   ```

   Ou, alternativamente, compile e rode diretamente com `javac`/`java` apontando para a classe de entrada.
