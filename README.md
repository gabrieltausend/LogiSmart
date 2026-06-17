# LogiSmart - Sistema de Gestão de Ordens de Entrega

## Sobre o Projeto

O LogiSmart é um sistema desktop desenvolvido em Java com o objetivo de automatizar o processo de geração de ordens de entrega em operações logísticas.

A aplicação permite o cadastro de produtos, criação de pedidos e seleção automática da transportadora responsável pela entrega com base em critérios como distância e urgência do pedido.

O projeto foi desenvolvido como atividade acadêmica da disciplina de Engenharia de Software II, aplicando conceitos de modelagem, desenvolvimento orientado a objetos, versionamento e qualidade de software.

---

## Funcionalidades

### Produtos

* Cadastro de produtos
* Consulta de produtos cadastrados
* Visualização detalhada dos produtos
* Upload de imagem do produto

### Pedidos

* Cadastro de pedidos
* Associação de cliente e produto
* Definição da distância da entrega
* Classificação de pedidos urgentes

### Logística

* Seleção automática de transportadoras
* Geração automática de ordens de entrega
* Rastreamento do status da entrega
* Visualização das transportadoras cadastradas

### Dashboard

* Quantidade de produtos cadastrados
* Quantidade de transportadoras
* Quantidade de ordens geradas
* Indicadores gerais do sistema

---

## Tecnologias Utilizadas

* Java 17
* Java Swing
* JDBC
* MySQL
* Git
* GitHub

---

## Arquitetura do Projeto

O sistema foi organizado utilizando separação em camadas:

```text
src/
│
├── model/
│
├── view/
│
├── service/
│
├── dao/
│
├── database/
│
├── util/
│
└── main/
```

### Model

Contém as entidades do sistema:

* Produto
* Cliente
* Pedido
* Transportadora
* OrdemEntrega

### View

Contém todas as interfaces gráficas:

* MainMDI
* DashboardMDI
* TelaProdutos
* TelaCadastroProduto
* TelaDetalheProduto
* TelaPedido
* TelaTransportadora
* TelaRastreamento

### Service

Responsável pelas regras de negócio:

* ProdutoService
* OrdemEntregaService
* LogisticaService

### DAO

Responsável pela comunicação com o banco de dados:

* ProdutoDAO
* ClienteDAO
* PedidoDAO
* TransportadoraDAO
* OrdemEntregaDAO

### Database

Configuração de conexão com o banco.

---

## Estrutura do Banco de Dados

### Produto

```sql
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    descricao TEXT,
    preco DOUBLE,
    endereco VARCHAR(200),
    imagem VARCHAR(255)
);
```

### Cliente

```sql
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(30),
    endereco VARCHAR(200)
);
```

### Transportadora

```sql
CREATE TABLE transportadora (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    custo_km DOUBLE,
    entrega_rapida BOOLEAN
);
```

### Pedido

```sql
CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    produto_id INT,
    urgente BOOLEAN,
    distancia DOUBLE
);
```

### Ordem de Entrega

```sql
CREATE TABLE ordem_entrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(20),
    pedido_id INT,
    transportadora_id INT,
    status VARCHAR(50),
    data_criacao DATE
);
```

---

## Como Executar

### 1. Clonar o Projeto

```bash
git clone https://github.com/seu-usuario/logismart.git
```

### 2. Abrir no NetBeans ou IntelliJ IDEA

Importe o projeto normalmente pela IDE.

### 3. Configurar o Banco de Dados

Criar o banco:

```sql
CREATE DATABASE logismart;
```

Executar os scripts de criação das tabelas.

### 4. Configurar a Classe Conexao

```java
private static final String URL =
    "jdbc:mysql://localhost:3306/logismart";

private static final String USER =
    "root";

private static final String PASSWORD =
    "sua_senha";
```

### 5. Adicionar o Driver JDBC

Adicionar o MySQL Connector/J às bibliotecas do projeto.

### 6. Executar

Executar a classe:

```java
Main.java
```

---

## Fluxo de Funcionamento

1. Cadastro dos produtos.
2. Cadastro das transportadoras.
3. Criação do pedido.
4. Definição da distância e urgência.
5. Seleção automática da transportadora.
6. Geração da ordem de entrega.
7. Acompanhamento do status da entrega.

---

## Estratégia de Versionamento

### Branches

```text
main
develop
feature/*
bugfix/*
```

### Padrão de Commits

```text
feat: nova funcionalidade

fix: correção de erro

docs: atualização da documentação

refactor: melhoria interna

test: testes
```

---

## Autor

Gabriel Tausendfreund Carneiro

Projeto desenvolvido para a disciplina de Engenharia de Software II.
