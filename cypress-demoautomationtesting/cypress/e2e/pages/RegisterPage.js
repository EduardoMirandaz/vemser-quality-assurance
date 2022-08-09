import Utils from '../utils/utils'
const util = new Utils

import RegisterElements from '../elements/RegisterElements'
const registerElements = new RegisterElements


export default class registerPage { 

    abrirPaginaDeRegistro(){
        util.navegar(registerElements.url)
    }

    preencherCamposDoRegistro(){
        util.typeAndTab(arguments)
    }

    clicarBotaoDeRegistro(){
        util.click(registerElements.btnCreate)
    }

    clicarBotaoDeletar(){
        util.click(registerElements.btnDelete)
    }

    getFieldName(){
        return registerElements.fieldName
    }
    
    pressEnterInAge(){
        util.enter(registerElements.age)
    }

}




