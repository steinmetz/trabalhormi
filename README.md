Trabalho de RMI
===============

Implementação do trabalho de RMI, desenvolvido pelos alunos:

* Charles Steinmetz
* Caio
* Henrique Leal

### Objetivos do Trabalho
Desenvolver um sistema para gerenciamento de uma rede de supermercados utilizando a tecnologia RMI.
O sistema será dividido em 3 partes:

**Servidor:** responsável por receber as requisições do Sistema de Retaguarda e do Terminal, e realizar
as alterações necessárias no banco de dados. Deverá ser implementado utilizando RMI. O servidor será uma
aplicação/processo sem interface gráfica, responsável por disponibilizar métodos remotos para manipulação
do banco de dados, voltados ao gerenciamento de funcionários (gerentes de lojas, caixas e atendimento
geral), controle de acesso, gerenciamento de lojas, produtos e estoque. O servidor deverá conter um usuário
administrador padrão, que possibilite a criação de novos funcionários. O servidor também deverá registrar
um log de TODAS as atividades ocorridas.

**Sistema de Retaguarda:** aplicação responsável pelo gerenciamento (cadastro, alteração e exclusão)
de funcionários, lojas, produtos, bem como o controle de estoque por loja. É um sistema acessado pelo
administrador padrão e por gerentes de loja.

O administrador padrão terá acesso a interface completa, podendo:

* Gerenciar gerentes
* Gerenciar lojas
* Associar um gerente a uma loja
* Gerenciar produtos
* Gerenciar estoques em lojas
* Acessar todos os tipos de logs.

O gerente terá acesso a uma interface limitada, podendo:

* Gerenciar funcionários do tipo caixa e atendente em geral
* Gerenciar sua loja
* Gerenciar estoque da sua loja
* Acessar logs referentes a sua loja
