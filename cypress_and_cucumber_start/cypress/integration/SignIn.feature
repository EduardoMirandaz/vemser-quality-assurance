Feature: SignIn

Scenario Outline: Validar cadastro de usuario válido
    Given que acesso o sistema <sistema>
    And preencho com email <email>
    And clico no botao createAnAccount
    And clico no genero <genero>
    And preencho com firstName <firstName>
    And preencho com lastName <lastName>
    And preencho com password <password>
    And seleciono data do nascimento
    And preencho com company <companyName>
    And preencho com address <address>
    And preencho com city <city>
    And preencho o estado
    And preencho com postCode <postCode>
    And preencho com phone <phone>
    When clico no register
    Then devo verificar uma mensagem <msgm>

    Examples:
        | sistema                                                                           | email             | genero | firstName  | lastName  | password  | companyName  | address      | city       | postCode | phone      | msgm       |
        | http://automationpractice.com/index.php?controller=authentication&back=my-account | teste123@joao.com | Mr.    | Eduardo    | Miranda   | senh@a1   | DBCom        | Joao Ramalho | Sao Carlos | 55236    | 2254846235 | MY ACCOUNT |

