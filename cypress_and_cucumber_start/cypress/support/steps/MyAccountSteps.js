// <reference types="cypress" />

import MyAccountPage from "../pages/MyAccountPage";
const myAccountPage = new MyAccountPage;

Then("devo verificar uma mensagem {}", (texto) => {
   myAccountPage.validarTextoNaTela(texto);
});


