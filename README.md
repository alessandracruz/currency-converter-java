# Conversor de Moedas – Challenge **ONE Back-end Java**

Aplicação dividida em dois módulos:

| Camada        | Tech                 | Descrição                                                    |
| ------------- | -------------------- | ------------------------------------------------------------ |
| **Front-end** | HTML + CSS + JS      | Página responsiva hospedada no **Vercel** para conversão instantânea de moedas |
| **Back-end**  | Java 11 + HttpClient | Console app que consome a mesma API de câmbio para estudo de OO e boas práticas |

> **Repositório:** `currency-converter-java`  
> **Objetivo:** praticar consumo de API, desserialização JSON, coleções, tratamento de erros e princípios de OO **(back-end)** e publicar uma **UI leve** em produção **(front-end)**.

---

## 🌐 Demonstração ao vivo

Acesse a versão publicada no Vercel e teste agora:

> **🔗 https://currency-converter-java.vercel.app**

---

## 🗂️ Funcionalidades (Back-End)

| #    | Descrição                                                    |
| ---- | ------------------------------------------------------------ |
| 1    | Menu textual com **6+ opções** de conversão (USD ⇄ BRL, BRL ⇄ ARS, USD ⇄ COP…) |
| 2    | Entrada de valor via linha de comando                        |
| 3    | Cotação **on-line** (exchangerate.host / exchangerate-api)   |
| 4    | Formatação de moeda (2 casas)                                |
| 5    | Tratamento de erros de rede, entrada inválida, números negativos |
| 6    | Arquitetura em camadas (`model`, `domain`, `service`, `ui`)  |

Front-end utiliza a **mesma API** (via fetch) e exibe o resultado na própria página.

---

## ⚙️ Pré-requisitos (Back-End)

| Ferramenta | Versão mínima           | Obs.                              |
| ---------- | ----------------------- | --------------------------------- |
| JDK        | 11 (17 LTS recomendado) | Inclui `java.net.http.HttpClient` |
| Maven      | 3.8                     | Gerenciamento de dependências     |
| IDE        | IntelliJ IDEA / VS Code | Opcional                          |

*Para o front-end não há dependências: é HTML estático.*

---

## 📦 Dependências principais (`pom.xml`)

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```

## 🔑 Variável de ambiente

Ambos módulos esperam `ER_API_KEY` no ambiente:

```bash
# Linux/macOS
export ER_API_KEY=SEU_TOKEN_AQUI

# Windows (PowerShell)
setx ER_API_KEY "SEU_TOKEN_AQUI"
```

*A chave gratuita é obtida em https://app.exchangerate-api.com (plano Free).*

------

## 🏗️ Estrutura do projeto

```
currency-converter-java
├─ frontend                 # arquivos estáticos enviados ao Vercel
│  ├─ index.html
│  └─ api
|     ├─convert.js
├─ pom.xml                  # módulo java
└─ src
   └─ main/java/com/alura/converter
       ├─ model
       ├─ domain
       ├─ service
       └─ ui
```

------

## 🚀 Execução (Back-End)

```
git clone https://github.com/alessandracruz/currency-converter-java.git
cd currency-converter-java

mvn clean package
java -cp target/currency-converter-java-1.0-SNAPSHOT.jar \
     com.alura.converter.ui.ConsoleApp
```

---

## Exemplo de uso

```text
=== Conversor de Moedas ===
1) USD
2) BRL
3) EUR
4) GBP
5) JPY
6) ARS
7) COP
0) Sair
Escolha moeda origem: 1
Escolha moeda destino: 2
Digite o valor a converter: 55

Resultado => 55.00 USD = 312.06 BRL (rate: 5.6738)
```

## 🧩 Conceitos aplicados

- **Orientação a Objetos** – encapsulamento (`Conversion`), enumeração (`Currency`), interface ↔ implementação (`ExchangeRateService`).
- **Coleções & tipos imutáveis** – evita side-effects.
- **HTTP Client** (Java 11+) – requisições `GET` sem bibliotecas externas.
- **Gson** – desserialização do JSON de resposta.
- **Tratamento de exceções** – `IOException`, `InterruptedException` e validações de entrada.

------

- ## 🗺️ Roadmap

   - [ ] Persistir histórico de conversões (.csv ou SQLite)
   - [ ] Adicionar testes unitários (JUnit 5 + Mockito)
   - [ ] Gráfico de variação da taxa em JavaScript (Chart.js)
   - [ ] Tema Dark/Light no front-end

------

## 🤝 Contribuindo

Pull requests são bem-vindos! Abra uma **issue** se quiser sugerir funcionalidade ou reportar bug.

------

## 📝 Licença

Distribuído sob a **LICENÇA MIT**. Consulte o arquivo `LICENSE` para detalhes.

##### 




