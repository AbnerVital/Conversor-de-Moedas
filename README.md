# 💱 Conversor de Moedas - Java

Projeto Java modularizado que realiza conversão entre moedas latino-americanas e o Dólar Americano, utilizando consumo de API com atualização em tempo real.

---

## 🧾 Estrutura do Projeto

```

com.conversor/
├── Principal.java                     → Classe principal (execução)
├── modelo/                            
│   └── TaxaDeCambio.java              → Representa a taxa de câmbio entre duas moedas
├── servico/                           
│   ├── ClienteApiMoeda.java           → Realiza chamadas à API de câmbio
│   └── ConversorDeMoeda.java          → Lógica de conversão entre moedas
├── Exception/                         
│   └── ErroDeMoedaException.java      → Exception personalizada para erros de API ou moedas inválidas
└── ui/                                
└── MenuDeMoedas.java                  → Interface de terminal com o usuário

````

---

## 🧮 Funcionalidades

- Conversão **bidirecional** entre:
  - Dólar Americano (USD)
  - Real Brasileiro (BRL)
  - Peso Argentino (ARS)
  - Boliviano (BOB)
  - Peso Chileno (CLP)
  - Peso Colombiano (COP)
- Atualização automática via API
- Menu interativo via console
- Exceções tratadas para casos de erro na conversão ou API

---

## 📦 Requisitos

- Java 11 ou superior
- Biblioteca externa: [`org.json`](https://github.com/stleary/JSON-java)

---

## 🛠 Instalação do JSON

1. Baixe o `.jar` da biblioteca JSON:  
   [json-20231013.jar (Maven Central)](https://search.maven.org/artifact/org.json/json/20231013/jar)

2. Crie a pasta `libs/` no seu projeto (se necessário)

3. Adicione o `.jar` ao classpath na sua IDE:
   - IntelliJ: File > Project Structure > Modules > Dependencies
   - Eclipse: Build Path > Add External JARs

---

## ▶️ Como Executar

1. Clone ou copie o projeto
2. Adicione a biblioteca JSON ao classpath
3. Execute a classe:

```bash
br.com.alura.conversor.Principal
````

---

## 💡 Exemplo de Execução

```text
=========== Conversor de Moedas ===========
Escolha a moeda de origem:
1 - USD → Dólar Americano
2 - BRL → Real Brasileiro
3 - ARS → Peso Argentino
4 - CLP → Peso Chileno
5 - COP → Peso Colombiano
6 - BOB → Boliviano

Digite o número da moeda de origem: 2
Digite o número da moeda de destino: 1
Digite o valor a ser convertido: 100

Resultado: 100 BRL equivalem a 19.82 USD
```

---

## 🔧 API Utilizada

* [ExchangeRate API](https://www.exchangerate-api.com/)

  * Endpoint base: `https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/`

> Substitua `SUA_CHAVE_AQUI` pela chave da sua conta gratuita na ExchangeRate API.

---

## ✨ Futuras Melhorias

* Histórico de conversões
* Interface gráfica com JavaFX
* Suporte a mais moedas
* Integração com banco de dados local (SQLite)

---

## 👨‍💻 Autor

| [<img src="https://avatars.githubusercontent.com/u/102125924?v=4" width=115><br><sub>Abner Vital</sub>](https://github.com/AbnerVital) |
| :------------------------------------------------------------------------------------------------------------------------------------: |


## 📫 Contato

* **LinkedIn**: [@Abner Vital](https://www.linkedin.com/in/abner-vital-233730141/)
* **GitHub**: [@AbnerVital](https://github.com/AbnerVital)

---

> Desenvolvido durante os estudos na [Alura](https://www.alura.com.br/)
