/// <reference types="cypress" />

import Utils from '../util/util'
const utils = new Utils

import MyAccountElements from '../elements/MyAccountElements'
const myAccountElements = new MyAccountElements;

export default class MyAccountPage {

    validarTextoNaTela(text) {
        utils.validarText(myAccountElements.titleMyAccount, text)
    }
    
}