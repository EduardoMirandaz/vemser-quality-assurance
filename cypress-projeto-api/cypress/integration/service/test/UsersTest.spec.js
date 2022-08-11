import UserService from '../requests/UserService.request'
const userService = new UserService;

const payloadAddUser = require('../payload/users/Add-user-1.json')
const payloadAddUser2 = require('../payload/users/Add-user-2.json')
const payloadAddUser3 = require('../payload/users/Add-user-3.json')

// Testes negativos foram omitidos pois a API não está construída corretamente, ao passo que qualquer requisição retorna 200.


context('Users', () => {

      it('GET - Consultar usuarios', () => {

        // Chamada service
        userService.getAllUsers().as('response')

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
           expect(response.body).to.be.not.null;
         })
                                   
      });

      it('GET - Consultar usuario valido por id', () => {
         
         // esse cadastro acaba sendo inutil pois a api nao está salvando os cadastros no banco
         userService.postUser(payloadAddUser).as('response')

         const idUser = 1;

         // Chamada service
         userService.getUser(idUser).as('response')
 
         // Validações
         cy.get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.not.null;
          })
                                    
       });


         // ********** BUG *********** //
         
      //  it('GET - Consultar usuario valido por id inválido', () => {
      //    const idUser = -1;

      //    // Chamada service
      //    userService.getUser(idUser).as('response')
 
      //    // Validações
      //    cy.get('@response').should((response) => {
      //       expect(response.status).to.eq(404);
      //       expect(response.body).to.be.not.null;
      //     })
                                    
      //  });

      it('POST - Adicionar um usuario', () => {

                  // Chamada service
                  userService.postUser(payloadAddUser).as('response')
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                     expect(response.body.id).to.eq(3265);
                     expect(response.body.userName).to.eq('thedraude');
                   })
                                             
         });

         it('POST - Adicionar um usuario inválido', () => {

               // Chamada service
               userService.postUser(payloadAddUser3).as('response')
         
               // Validações
               cy.get('@response').should((response) => {
                  expect(response.status).to.eq(400);
                  })
                                             
         });

       it('DELETE - Deletar  usuario', () => {

                  // Adiciona um usuario
                  userService.deleteUser(payloadAddUser).as('response')

                  const idUser = 3265;

                  // Exclui o usuario
                  userService.deleteUser(idUser).as('response') 
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                   })

                   // excluo o usuario após as validações
                  userService.deleteUser(idUser).as('response') ;                                   
       });

       it('PUT - Alterar usuario', () => {

                  // adiciono um usuario
                  userService.postUser(payloadAddUser).as('response')

                  const idUser = 3265;

                  // Exclui o usuario
                  userService.putUser(payloadAddUser2,idUser).as('response') 
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                   })
             
       });
                  
       
});


