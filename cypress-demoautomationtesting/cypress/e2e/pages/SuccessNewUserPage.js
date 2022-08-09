import VerificationElements from '../elements/VerificationElements'
const verificationElements = new VerificationElements

import Utils from '../utils/utils'
const util = new Utils

export default class sucessNewUserPage { 

    get getVerificationFieldName(){
        return verificationElements.verificationFieldName
    }

    get getFailFieldError(){
        return verificationElements.fieldError
    }
    clicarBotaoEditar(){
        util.click(verificationElements.botaoEditar)
    }

    clicarListaDeUsuarios(){
        util.click(verificationElements.listaDeUsuarios)
    }


}




