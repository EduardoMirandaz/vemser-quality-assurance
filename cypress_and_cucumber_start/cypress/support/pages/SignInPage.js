/// <reference types="cypress"/>

import Utils from '../util/util'
const utils = new Utils

import SignInElements from '../elements/SignInElements'
const signInElements = new SignInElements;

const Chance = require('chance')
const chance = new Chance

export default class LoginPage {

    navegar(site) {
        utils.navegar(site);
    }

    preencherEmail(email){
        utils.preencherInput(signInElements.fieldEmail, email);
    }

    preencherPassword(password){
        utils.preencherInput(signInElements.loginPassword, password);
    }

    clicarBotaoSignIn(){
        utils.click(signInElements.btnSignIn);
    }

    recuperarEmail(){
        return chance.email()
    }

    clicarBotaoGenero(genero){
        if(genero == "Mr."){
            utils.click(signInElements.btnMr)
        }
        else if(genero == "Mrs."){
            utils.click(signInElements.btnMiss)
        }
    }
}