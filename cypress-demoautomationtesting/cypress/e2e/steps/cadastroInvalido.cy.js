
import RegisterPage from "../pages/RegisterPage"
const registerPage = new RegisterPage

import SucessCreateUserPage from "../pages/SuccessNewUserPage"
const sucessCreateUserPage = new SucessCreateUserPage

import Utils from "../utils/utils"
const util = new Utils


describe('cadastro invalido', () => {
  it('passes', () => {
    
    cadastrarInvalido()

    // Validações
    util.validarText(sucessCreateUserPage.getFailFieldError,
    'Name translation missing: pt-BR.activerecord.errors.models.user.attributes.name.blank')
  })

})

export function cadastrarInvalido(){

  registerPage.abrirPaginaDeRegistro()
    
    // preenchendo os campos
    util.typeAndTab(registerPage.getFieldName(), 
    '', '', '', '', 
    '', '', '', '')

    // clicando no botao de registrar
    registerPage.clicarBotaoDeRegistro()
}


