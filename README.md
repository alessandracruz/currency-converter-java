# Conversor de Moedas – Challenge ONE Back‑End Java

Aplicação de console desenvolvida como parte do **Oracle + Alura ONE – Back‑End Java**.  
Converte valores entre moedas utilizando cotações **em tempo real** da API gratuita [exchangerate.host](https://exchangerate.host).

> **Repositório:** `currency-converter-java`  
> **Objetivo do desafio:** praticar consumo de API, desserialização JSON, coleções, tratamento de erros e princípios de OO em um cenário próximo ao dia a dia de uma pessoa desenvolvedora back‑end.

---

## 🗂️ Funcionalidades

| # | Descrição |
|---|-----------|
| 1 | Menu textual com **6+ opções** de conversão (USD ⇄ BRL, BRL ⇄ ARS, USD ⇄ COP, etc.) |
| 2 | Entrada do valor a converter via teclado (`Scanner`) |
| 3 | Cotações buscadas on‑line a cada execução; nenhum dado hard‑coded |
| 4 | Resultado formatado (2 casas decimais, símbolo da moeda) |
| 5 | Tratamento de exceções de rede, entrada inválida e números negativos |
| 6 | Arquitetura em camadas (`model`, `domain`, `service`, `ui`) para facilitar testes e manutenção |

---

## ⚙️ Pré‑requisitos

| Ferramenta | Versão mínima | Observação |
|------------|--------------|------------|
| **JDK**    | 11 (recomendado 17 LTS) | Já inclui `java.net.http.HttpClient` |
| **Maven**  | 3.8 | Build e dependências (Gson) |
| **IDE**    | IntelliJ IDEA / VS Code | Opcional, mas recomendado |
| **Postman**| — | Útil para testar a API (opcional) |

---

## 📦 Dependências (pom.xml)

```xml
<dependencies>
    <!-- Desserialização JSON -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>
```
Maven resolve o JAR automaticamente – não é necessário adicionar arquivos à mão.

### Obtendo a **API Key**

1. Acesse **<https://app.exchangerate-api.com>** e clique em **Get Free Key**.  
2. Cadastre‑se com seu e‑mail; o painel exibirá uma chave como `j6346d735c999bgr1406cea1`.  
3. Defina uma **variável de ambiente** para não expor a chave no código:

   ```bash
   # Linux/macOS
   export ER_API_KEY=j6346d735c999bgr1406cea1
   ```
O programa lerá System.getenv("ER_API_KEY").

---

## 🏗️ Estrutura do Projeto

```pgsql
currency-converter-java
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com/alura/converter
        │       ├── model          # Enum Currency
        │       ├── domain         # POJO Conversion
        │       ├── service        # Interface + implementação HTTP
        │       └── ui             # ConsoleApp (classe main)
        └── resources              # (opcional) banners, configs
```
---

## 🚀 Instalação e execução

# clone o projeto
git clone https://github.com/<seu‑usuario>/currency-converter-java.git
cd currency-converter-java

# compile e empacote
mvn clean package

# execute
java -cp target/currency-converter-java-1.0-SNAPSHOT.jar com.alura.converter.ui.ConsoleApp

---

## Exemplo de uso

=== Conversor de Moedas ===
1) USD → BRL
2) BRL → USD
3) USD → ARS
4) ARS → USD
5) USD → COP
6) COP → USD
7) Sair
Escolha uma opção: 2
Digite o valor: 100
100,00 BRL equivalem a 20,55 USD (taxa 0,2055)

---

## 🧩 Principais conceitos aplicados

- Orientação a Objetos – encapsulamento (Conversion), enumeração (Currency), interface ↔ implementação (ExchangeRateService).
- Coleções & tipos imutáveis – evita side‑effects.
- HTTP Client (Java 11+) – requisições GET sem bibliotecas externas.
- Gson – desserialização do JSON de resposta.
- Tratamento de exceções – IOException, InterruptedException e validações de entrada.

---

## 🗓️ Roadmap / Extras (opcionais)

- Salvar histórico das conversões em arquivo .csv.
- Adicionar testes unitários JUnit 5 com mockito para a camada service.
- Extrair a taxa de conversão para BigDecimal e formatar com NumberFormat.
- Interface gráfica simples em JavaFX.

## 🤝 Contribuições

Pull requests são bem‑vindos! Sinta‑se livre para abrir issues ou sugerir melhorias.

## 📝 Licença

Distribuído sob os termos da LICENÇA MIT – consulte o arquivo LICENSE para detalhes.




