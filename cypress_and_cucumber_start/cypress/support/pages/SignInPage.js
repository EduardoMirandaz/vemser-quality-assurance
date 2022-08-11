/// <reference types="cypress"/>

import Utils from '../util/util'
const utils = new Utils

import SignInElements from '../elements/SignInElements'
const signInElements = new SignInElements;

const Chance = require('chance')
const chance = new Chance

export default class SignInPage {

    navegar(site) {
        utils.navegar(site);
    }

    recuperarEmail(){
        return chance.email()
    }

    clicarBotaoSignIn(){
        utils.click(signInElements.btnSignIn);
    }

    clicarBotaoCreateAnAccount(){
        utils.clickWait(signInElements.btnCreateAnAccount, 12000);
    }

    clicarBotaoGenero(genero){
        if(genero == "Mr."){
            utils.click(signInElements.btnMr)
        }
        else if(genero == "Mrs."){
            utils.click(signInElements.btnMiss)
        }
    }

    preencherEmail(email){
        utils.preencherInput(signInElements.fieldEmail, email);
    }

    preencherPassword(password){
        utils.preencherInput(signInElements.fieldPassword, password);
    }
    
    preencherFirstName(firstName){
        utils.preencherInput(signInElements.fieldFirstName, firstName);
    }

    preencherLastName(lastName){
        utils.preencherInput(signInElements.fieldLastName, lastName);
    }

    clicarBotaoDayOfBirth(){
        utils.select(signInElements.btnDayOfBirth, '13');
    }

    clicarBotaoMonthOfBirth(){
        utils.select(signInElements.btnMonthOfBirth, '4');
    }

    clicarBotaoYearOfBirth(){
        utils.select(signInElements.btnYearOfBirth, '1956');
    }

    preencherCompany(company){
        utils.preencherInput(signInElements.fieldCompany, company);
    }

    preencherAddress(address){
        utils.preencherInput(signInElements.fieldAddress, address);
    }

    preencherCity(city){
        utils.preencherInput(signInElements.fieldCity, city);
    }

    clicarBotaoState(){
        utils.select(signInElements.btnState, 'Louisiana');
    }

    preencherPostCode(postCode){
        utils.preencherInput(signInElements.fieldPostCode, postCode);
    }

    preencherPhone(phone){
        utils.preencherInput(signInElements.fieldPhone, phone);
    }

    clicarBotaoRegister(){
        utils.clickForce(signInElements.btnRegister);
    }
    

    validarTextoInvalidPhone(text) {
        utils.validarText(signInElements.tilteInvalidPhone, text)
    }


}