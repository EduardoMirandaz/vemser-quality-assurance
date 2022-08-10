// <reference types="cypress" />

import DashboardPage from "../pages/dashboardPage";
const dashboardPage = new DashboardPage;

Then("devo verificar um texto na tela {}", (texto) => {
   dashboardPage.validarTextoNaTela(texto);

});