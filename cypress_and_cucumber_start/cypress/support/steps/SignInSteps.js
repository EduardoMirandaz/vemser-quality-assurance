/// <reference types="cypress" />

import SignInPage from "../pages/SignInPage";
const signInPage = new SignInPage;

Given("que acesso o sistema {}", (site) => {
   signInPage.navegar(site);
});

And("preencho com email {}", () => {
   signInPage.preencherEmail(signInPage.recuperarEmail())

});

And("clico no genero {}", (genero) => {
   signInPage.clicarBotaoGenero(genero)

});

When("clico botao signIn", () => {
   signInPage.clicarBotaoSignIn();

});

// Then("devo verificar uma mensagem {}", () => {
//   return null;
// });