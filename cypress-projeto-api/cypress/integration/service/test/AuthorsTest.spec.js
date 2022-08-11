import AuthorService from '../requests/AuthorService.request'
const authorService = new AuthorService;

const payloadAddAuthor = require('../payload/authors/Add-author-1.json')
const payloadAddAuthor2 = require('../payload/authors/Add-author-2.json')

context('Authors', () => {

      it('GET - Consultar autores', () => {

        // Chamada service
        authorService.getAllAuthors().as('response')

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
           expect(response.body).to.be.not.null;
         })
                                   
      });

      it('GET - Consultar autor valido por id', () => {

         const idAuthor = 2

         // Chamada service
         authorService.getAuthor(idAuthor).as('response')
 
         // Validações
         cy.get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.not.null;
          })
                                    
       });

       it('GET - Consultar autor valido por id do livro', () => {

         const idbook = 2

         // Chamada service
         authorService.getAuthorByBookID(idbook).as('response')
 
         // Validações
         cy.get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.not.null;
          })
                                    
       });



      it('POST - Adicionar um autor', () => {

                  // Chamada service
                  authorService.postAuthors(payloadAddAuthor).as('response')
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                     expect(response.body.id).to.eq(546513);
                     expect(response.body.firstName).to.eq('Garry');
                   })
                                             
         });

       it('DELETE - Deletar  autor', () => {

                  const idAuthor = 1;

                  // Adiciona um autor
                  authorService.deleteAuthor(payloadAddAuthor).as('response')

                  // Exclui o autor
                  authorService.deleteAuthor(idAuthor).as('response') 
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                   })

                  
                   // excluo o autor após as validações
                  authorService.deleteAuthor(idAuthor).as('response') ;                                   
       });

       it('PUT - Alterar autor', () => {

                  // adiciono um autor
                  authorService.postAuthors(payloadAddAuthor).as('response')

                  const idAuthor = 230;

                  // Exclui o autor
                  authorService.putAuthor(payloadAddAuthor2,idAuthor).as('response') 
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                   })
             
       });
                  
});



