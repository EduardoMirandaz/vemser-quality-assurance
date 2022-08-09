import SucessCreateUserPage from "../pages/SuccessNewUserPage"
const sucessCreateUserPage = new SucessCreateUserPage

import RegisterPage from "../pages/RegisterPage"
const registerPage = new RegisterPage


import Utils from "../utils/utils"
const util = new Utils

import {cadastrar} from "../steps/cadastro.cy"

// describe('edicao valida', () => {
//     it('passes', () => {

//         cadastrar()
   
//         editar()

//     })
// })

export function editar(){
    sucessCreateUserPage.clicarBotaoEditar()

    util.typeAndTab(registerPage.getFieldName(), 
    'Joao', 'Miranda', 'joao@gmail.com', 'Rua Episcopal', 
    'Universidade de São Paulo', 'Desenvolvedor Backend', 'Masculino', '21')
    
    registerPage.pressEnterInAge()

        // Validações
    util.assertSequenceChilds(sucessCreateUserPage.getVerificationFieldName, 
      'Joao', 'Miranda', 'joao@gmail.com', 'Universidade de São Paulo',
      'Masculino', 'Desenvolvedor Backend', '21', 'Rua Episcopal')

}

