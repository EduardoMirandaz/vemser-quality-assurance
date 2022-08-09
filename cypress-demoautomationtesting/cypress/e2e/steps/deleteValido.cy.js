import SucessCreateUserPage from "../pages/SuccessNewUserPage"
const sucessCreateUserPage = new SucessCreateUserPage

import RegisterPage from "../pages/RegisterPage"
const registerPage = new RegisterPage

import ListaDeUsuarioPage from "../pages/ListaDeUsuariosPage"
const listaDeUsuariosPage = new ListaDeUsuarioPage

import Utils from "../utils/utils"
const util = new Utils

import {cadastrar} from "./cadastro.cy"

describe('delecao valida', () => {
    it('passes', () => {

        cadastrar()
   
        deletar()

    })
})

export function deletar(){
    sucessCreateUserPage.clicarListaDeUsuarios()
    listaDeUsuariosPage.clicarBotaoDeletar()
}

