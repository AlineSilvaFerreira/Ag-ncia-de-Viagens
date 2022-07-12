Algoritmo "DonnaAgenciaDeViagens"
//Aline Silva Ferreira

//Cadastro de clientes -----------------------------------------------------

procedimento cadastroCliente(): caractere

inicio
   para i de 1 ate 5 faca

      escreval("-------------- Cadastro Clientes ---------------")
      escreval(" ")

      escreva("Nome do cliente: ")
      leia (nomeCliente[i])
      escreva("E-mail: ")
      leia (emailCliente[i])
      escreva("CPF: ")
      leia (cpfCliente[i])
      escreval("Telefone: ")
      leia (telCliente[i])

      escreval(" ")
      escreval("Deseja cadastrar outro cliente? [s/n] ")
      leia (continuar)
      limpatela

      se (continuar = "n") entao
         interrompa
      fimse
   fimpara

   escreval("Deseja voltar para o menu? [s/n]")
   leia(menu)

fimprocedimento


//Cadastro de destinos ---------------------------------------------------

procedimento cadastroDestino(): caractere

inicio
   para i de 1 ate 5 faca
      escreval("-------------- Cadastro Destino ---------------")
      escreval(" ")

      escreva("País: ")
      leia (pais[i])
      escreva("Estado: ")
      leia (estado[i])
      escreva("Cidade: ")
      leia (cidade[i])

      escreval(" ")
      escreval("Deseja cadastrar outro destino? [s/n] ")
      leia (continuar)
      limpatela

      se (continuar = "n") entao
         interrompa
      fimse
   fimpara

   escreval("Deseja voltar para o menu? [s/n]")
   leia(menu)
fimprocedimento


//Consulta de clientes --------------------------------------------------

procedimento consultaCliente(): caractere

inicio
   para i de 1 ate 5 faca
      escreval(" ")
      escreval("-------------- Cliente --------------")
      escreval(" ")
      escreval("Nome: ",nomeCliente[i])
      escreval("CPF: ",cpfCliente[i])
      escreval("E-mail: ",emailCliente[i])
      escreval("Telefone: ",telCliente[i])
   fimpara

   escreval(" ")
   escreval("Deseja voltar para o menu? [s/n]")
   leia(menu)

fimprocedimento


//Consulta de destinos --------------------------------------------

procedimento consultaDestino(): caractere

inicio
   para i de 1 ate 5 faca
      escreval(" ")
      escreval("-------------- Destino --------------")
      escreval(" ")
      escreval("País: ",pais[i])
      escreval("Estado: ",estado[i])
      escreval("Cidade: ",cidade[i])
   fimpara

   escreval(" ")
   escreval("Deseja voltar para o menu? [s/n]")
   leia(menu)

fimprocedimento


//-----------------------------------------------------------------------

Var
   continuar, menu: caractere
   i, opcao: inteiro
   nomeCliente, emailCliente: vetor [1..5] de caracter
   cpfCliente, telCliente: vetor [1..5] de inteiro
   cidade, estado, pais: vetor [1..5] de caracter
Inicio

   escreval("- - - - - - - - - - - - - - - - - - - - - - - - - -")
   escreval("              DONNA Agência de Viagens             ")
   escreval("- - - - - - - - - - - - - - - - - - - - - - - - - -")
   escreval(" ")
   escreval("                   Seja bem-vindo!                 ")
   escreval(" ")

   escreval("Digite a opção desejada: ")
   escreval("1 - Cadastrar novo cliente")
   escreval("2 - Cadastrar novo destivo")
   escreval("3 - Consultar clientes")
   escreval("4 - Consultar destinos")
   escreval("5 - Sair")
   leia(opcao)

   limpatela

   se (opcao = 1) entao
      cadastroCliente()
   fimse
   se (opcao = 2) entao
      cadastroDestino()
   fimse
   se (opcao = 3) entao
      consultaCliente()
   fimse
   se (opcao = 4) entao
      consultaDestino()
   fimse
   se (opcao = 5) entao
      interrompa
   fimse

   enquanto menu = "s" faca
      limpatela
      escreval("Digite a opção desejada: ")
      escreval("1 - Cadastrar novo cliente")
      escreval("2 - Cadastrar novo destivo")
      escreval("3 - Consultar clientes")
      escreval("4 - Consultar destinos")
      leia(opcao)
      limpatela

      se (opcao = 1) entao
         cadastroCliente()
      fimse
      se (opcao = 2) entao
         cadastroDestino()
      fimse
      se (opcao = 3) entao
         consultaCliente()
      fimse
      se (opcao = 4) entao
         consultaDestino()
      fimse
      se (opcao = 5) entao
         interrompa
      fimse
   fimenquanto

Fimalgoritmo