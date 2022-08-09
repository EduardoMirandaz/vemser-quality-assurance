import Utils from '../utils/utils'
const util = new Utils

import ListaDeUsuariosElements from '../elements/ListaDeUsuariosElements'
const listaDeUsuariosElements = new ListaDeUsuariosElements


export default class listaDeUsuarios { 

    clicarBotaoDeletar(){
        util.clickForce(listaDeUsuariosElements.btnDelete)
    }

}




