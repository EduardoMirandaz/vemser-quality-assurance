/// <reference types="cypress" />

import SignInPage from "../pages/SignInPage";
const signInPage = new SignInPage;

Given("que acesso o sistema {}", (site) => {
   signInPage.navegar(site);
});

And("preencho com email {}", (email) => {
   signInPage.preencherEmail(signInPage.recuperarEmail())
});

And("clico no botao createAnAccount", () => {
   signInPage.clicarBotaoCreateAnAccount()

});

And("clico no genero {}", (genero) => {
   signInPage.clicarBotaoGenero(genero)

});

And("preencho com firstName {}", (firstName) => {
   signInPage.preencherFirstName(firstName)

});

And("preencho com lastName {}", (lastName) => {
   signInPage.preencherLastName(lastName)
});

And("preencho com password {}", (password) => {
   signInPage.preencherPassword(password)
});

And("seleciono data do nascimento", () => {
   signInPage.clicarBotaoDayOfBirth()
   signInPage.clicarBotaoMonthOfBirth()
   signInPage.clicarBotaoYearOfBirth()
});

And("preencho com company {}", (companyName) => {
   signInPage.preencherCompany(companyName)
});

And("preencho com address {}", (address) => {
   signInPage.preencherAddress(address)
});

And("preencho com city {}", (city) => {
   signInPage.preencherCity(city)
});

And("preencho o estado", () => {
   signInPage.clicarBotaoState()
});

And("preencho com postCode {}", (postCode) => {
   signInPage.preencherPostCode(postCode)
});

And("preencho com phone {}", (phone) => {
   signInPage.preencherPhone(phone)
});

When("clico no register", () => {
   signInPage.clicarBotaoRegister();
});
