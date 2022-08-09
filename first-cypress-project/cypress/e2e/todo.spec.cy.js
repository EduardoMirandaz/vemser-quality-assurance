// context('Todo', () => {
//   it('passes', () => {
//     cy.visit('https://example.cypress.io')
//   })
// })

// inserir tarefa em https://todomvc.com/examples/react/#/
context('Todo', () => {

  it('Inserir uma nova tarefa na lista', () => {
  
    // site
    cy.visit('https://todomvc.com/examples/react/#/')
  
  
    //                    seletor                         escreva       pressione    
    // cy.get('body > section > div > header > input').type('Comprar batata {enter}')
    cy.get('body > section > div > header > input').type('Comprar batata').type('{enter}')

    cy.get('ul.todo-list li').should('have.length', 1)


  })
})
