# 💱 Conversor de Moedas em Java #
Um projeto em **Java** que permite converter valores entre diferentes moedas utilizando a **Exchange Rate API**.  
O programa é totalmente **interativo via console**, exibindo menus com os códigos e nomes das moedas e realizando conversões em tempo real.

---

## 🛠 Funcionalidades ##

- Menu interativo para escolher **moeda base** e **moeda de destino**  
- Conversão de valores com **entrada de ponto ou vírgula**  
- Suporte a 8 moedas filtradas:


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


- Mostra o resultado da conversão em tempo real  
- Permite repetir várias conversões até o usuário decidir sair  
- Exibe mensagens de erro caso a API não responda ou o valor seja inválido  

---

## 💻 Tecnologias Utilizadas ##

- **Java 11+**  
- **Exchange Rate API** ([https://www.exchangerate-api.com/](https://www.exchangerate-api.com/))  
- **Gson** para manipulação de JSON  
- **Git/GitHub** para versionamento  

---

## 🚀 Como Executar ##

1. Clone o repositório:

```bash
git clone https://github.com/seuusuario/conversormoedas.git
```
2. Abra o projeto no IntelliJ ou outro IDE de sua preferência.

3. Substitua "SUA_CHAVE_AQUI" no Main.java pelo token da sua Exchange Rate API:

```bash
CurrencyApiClient client = new CurrencyApiClient("SUA_CHAVE_AQUI");
```

4. Compile e execute Main.java.

5. Siga as instruções do console:

- Escolha a moeda base
- Escolha a moeda de destino
- Digite o valor que deseja converter

---

## ⚡ Exemplo de Uso ##
=== Conversor de Moedas ===
Escolha a moeda base:
1. USD - Dólar Americano
2. EUR - Euro
3. BRL - Real Brasileiro
0. Sair

1

Escolha a moeda de destino:
1. USD - Dólar Americano
2. EUR - Euro
3. BRL - Real Brasileiro

2

Digite o valor em USD que deseja converter: 100
100.00 USD = 95.50 EUR

Deseja realizar outra conversão? (s/n)

---

## 📌 Observações ##
- A chave da API deve ser válida e ativa.
- Algumas moedas podem não funcionar como moeda base dependendo do plano da API.
- O programa aceita valores com ponto (1000.50) ou vírgula (1000,50).
