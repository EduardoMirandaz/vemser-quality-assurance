Feature: SignIn

Scenario Outline: Validar cadastro de usuario válido
    Given que acesso o sistema <sistema>
    And preencho com email <email>
    And clico botao signIn
    And clico no genero <genero>
    And preencho com firstName <firstName>
    And preencho com lastName <lastName>
    And preencho com password <password>
    And seleciono data do nascimento
    And preencho com company <companyName>
    And preencho com address <address>
    And preencho com address <city>
    And preencho o estado
    And preencho com o postCode <postCode>
    And preencho com o phone <phone>
    When clico no register
    Then devo verificar uma mensagem <msgm>

    Examples:
        | sistema                                                                           | email    | genero | firstName  | lastName  | password  | companyName  | address      | city       | postCode | phone      | msgm    |
        | http://automationpractice.com/index.php?controller=authentication&back=my-account | teste123 | Mr.    | Eduardo    | Miranda   | Miranda   | DBCom        | Joao Ramalho | Sao Carlos | 55236    | 2254846235 | Sucesso |

