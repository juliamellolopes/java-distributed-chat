# Sistema de Chat Distribuído em Java

Este projeto consiste em um **Sistema de Chat Distribuído** desenvolvido em **Java**, integrando uma **aplicação desktop**, uma **aplicação web** e **comunicação multicast**, como parte do estudo prático da disciplina de **Sistemas Distribuídos**.

O sistema simula características de aplicações reais de mensagens, incluindo **sincronização de mensagens entre múltiplos clientes**, **atualização em tempo real** e **distribuição de publicidade via multicast**.

---

## Arquitetura do Sistema

O projeto é dividido em três componentes principais:

### Aplicação Desktop (Java Swing)
- Interface gráfica para troca de mensagens
- Comunicação com o servidor via **Socket TCP**
- Atualização automática das mensagens
- Recebimento de anúncios publicitários via **Multicast UDP**
- Suporte a clientes sem avatar (comportamento *ghost/fallback*)

### Aplicação Web (JSP)
- Interface web para envio e visualização de mensagens
- Sincronização com o mesmo servidor utilizado pelo desktop
- Atualização automática da conversa
- Exibição de publicidade sincronizada via multicast

### Servidor (Middleware)
- Recebe mensagens dos clientes desktop e web
- Armazena e distribui as mensagens
- Controla a atualização dos clientes
- Envia anúncios publicitários para todos os clientes utilizando **IP Multicast**

---

## Tecnologias Utilizadas

- Java SE  
- Java Swing  
- JSP / Servidor Web  
- Sockets TCP  
- Multicast UDP  
- Threads  
- Arquitetura Cliente–Servidor  
- Conceitos de Sistemas Distribuídos  

---

## Sistema de Publicidade via Multicast

Um dos diferenciais do projeto é o uso de **Multicast UDP** para a distribuição de publicidade:

- O servidor envia periodicamente o nome de uma imagem publicitária
- Todos os clientes conectados (desktop e web) recebem o anúncio simultaneamente
- Cada cliente carrega e exibe a imagem localmente
- Demonstra comunicação **um-para-muitos**, característica de sistemas distribuídos

---

## Conceitos Aplicados

- Comunicação síncrona e assíncrona  
- Distribuição de mensagens  
- Multithreading  
- Atualização em tempo real  
- Integração entre plataformas (Web ↔ Desktop)  
- Tratamento de clientes heterogêneos  

---

## Como Executar o Projeto

1. Inicie o **servidor/middleware**
2. Inicie o **servidor multicast de publicidade**
3. Execute a **aplicação desktop**
4. Acesse a **aplicação web** pelo navegador
5. Envie mensagens e observe a sincronização entre os clientes

---

## Contexto Acadêmico

Este projeto foi desenvolvido como atividade prática da disciplina de **Sistemas Distribuídos**, com foco em:

- Comunicação em rede  
- Arquiteturas distribuídas  
- Aplicações cliente-servidor  
- Comunicação multicast em redes locais  
