<h1>
  💱 Challenge Conversor de Moedas — Oracle Next Education (ONE)
</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-red?style=for-the-badge" alt="Java">
  <img src="https://img.shields.io/badge/Gson-JSON-blue?style=for-the-badge" alt="Gson">
  <img src="https://img.shields.io/badge/ExchangeRate--API-Consumo-green?style=for-the-badge" alt="ExchangeRate API">
  <img src="https://img.shields.io/badge/Alura-ONE-ED8B00?style=for-the-badge" alt="Alura ONE">
</p>

Projeto prático de capacitação e consolidação de conceitos desenvolvidos na trilha de **Java e Orientação a Objetos**, integrante do programa **Oracle Next Education (ONE)** em parceria com a **Alura**.

A aplicação consiste em um motor de terminal dinâmico que consome payloads em tempo real da **ExchangeRate-API** para realizar conversões financeiras entre diversas moedas globais utilizando taxas de câmbio atualizadas instantaneamente.

---

## 📌 Moedas Suportadas (Padrão ISO 4217)

O sistema foi arquitetado de forma totalmente flexível e escalável. Graças à integração direta com o nó analítico da API externa, o conversor oferece **suporte universal a mais de 160 moedas globais simultaneamente**. 

O utilizador pode digitar qualquer código padrão de três letras (**ISO 4217**) no terminal, permitindo combinações livres entre moedas como:

| Código | Moeda |
|--------|-------|
| USD    | Dólar Americano |
| EUR    | Euro |
| BRL    | Real Brasileiro |
| ARS    | Peso Argentino |
| BOB    | Boliviano Boliviano |
| CLP    | Peso Chileno |
| COP    | Peso Colombiano |
| KRW    | Won Sul-Coreano |
---

## 📌 Engenharia de Software & Arquitetura Back-End

O ecossistema interno da aplicação foi projetado seguindo princípios de separação de responsabilidades (SoC) e manipulação controlada de fluxos:

* **Isolamento do Cliente HTTP (`CurrencyApiClient`):** Criação de uma classe especializada encarregada exclusivamente por orquestrar conexões externas. Utiliza as APIs nativas do Java `HttpClient`, `HttpRequest` e `HttpResponse` para disparar requisições baseadas em URIs de forma limpa.
* **Desserialização Orientada a Tipos (Gson):** Integração da biblioteca Google Gson para interceptar strings JSON brutas retornadas pela API e mapeá-las programaticamente em estruturas reutilizáveis do Java (`JsonObject`), extraindo dinamicamente as chaves do nó de taxas (`conversion_rates`).
* **Menu de Estado Interativo & Input via Scanner:** A classe `Main` gerencia o loop de execução contínua (`while`) que processa as opções de conversão no terminal. O fluxo intercepta dados via teclado usando a classe `Scanner`, tratando erros de entrada caso o utilizador insira opções inválidas ou valores inconsistentes.
* **Abstrações e Modelagem de Dados:** Utilização de tipos modernos e modelagem limpa para representar os pares de moedas e realizar as operações aritméticas de conversão (`valor Bruto × taxa de Câmbio`) diretamente na memória operacional do console.

---

## 📂 Organização dos Arquivos

```text
challenge-conversor-de-moedas
├── src
│   ├── CurrencyApiClient.java   # Cliente HTTP dedicado ao consumo da API externa
│   └── Main.java                # Ponto de entrada, loops de controle e interface do terminal
├── .idea/                       # Arquivos de metadados da IDE (IntelliJ IDEA)
└── README.md                    # Documentação técnica do ecossistema

```

---

## 🚀 Como Executar o Projeto

Por se tratar de uma aplicação baseada em console Java puro, podes rodar o binário compilado diretamente pelo teu terminal de comandos ou importando o projeto numa IDE (IntelliJ IDEA, Eclipse, VS Code):

### Pré-requisitos

* **Java JDK** (versão 11 ou superior instalada e configurada nas variáveis de ambiente).
* Uma chave de acesso válida da **ExchangeRate-API** (caso queiras rodar o próprio ambiente parametrizado de requisições).

### Passos para execução por terminal:

1. Realize o clone deste repositório:
```bash
git clone https://github.com/cassia-nascimento/challenge-conversor-de-moedas.git

```


2. Acesse a pasta raiz do projeto:
```bash
cd challenge-conversor-de-moedas

```


3. Compile os arquivos código-fonte Java:
```bash
javac src/*.java

```


4. Execute a aplicação:
```bash
java -cp src Main

```

---

## 👩‍💻 Autora

Projeto de imersão em consumo de serviços Back-End desenvolvido por **Cássia Nascimento**.

* [GitHub Profile](https://github.com/cassia-nascimento)
* [LinkedIn](https://www.linkedin.com/in/cassia--nascimento/)
