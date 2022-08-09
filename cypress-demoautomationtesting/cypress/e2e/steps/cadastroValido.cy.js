
import RegisterPage from "../pages/RegisterPage"
const registerPage = new RegisterPage

import SucessCreateUserPage from "../pages/SuccessNewUserPage"
const sucessCreateUserPage = new SucessCreateUserPage

import Utils from "../utils/utils"
const util = new Utils


// describe('cadastro valido', () => {
//   it('passes', () => {
    
//     cadastrar()

//     // Validações
//     util.assertSequenceChilds(sucessCreateUserPage.getVerificationFieldName, 
//       'Eduardo', 'Jackson', 'eduardo@gmail.com', 'Universidade do Novo Mexico', 
//       'Masculino', 'Quality Analyst', '19', 'Rua Jao Pedro 233')
//   })

// })

export function cadastrar(){
  registerPage.abrirPaginaDeRegistro()
    

    // preenchendo os campos
    util.typeAndTab(registerPage.getFieldName(), 
    'Eduardo', 'Jackson', 'eduardo@gmail.com', 'Rua Jao Pedro 233', 
    'Universidade do Novo Mexico', 'Quality Analyst', 'Masculino', '19')

    
    // clicando no botao de registrar
    registerPage.clicarBotaoDeRegistro()
}


