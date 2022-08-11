const API_URL = Cypress.env('API_BASE_URL')

// end point
const authors = '/Authors'

export default class BookService {

  getAllAuthors(){
    return cy.request({
           method: 'GET',
           url: `${API_URL}${authors}`,
           failOnStatusCode: false,
    })
  }

  getAuthor(idAuthor){
       return cy.request({
              method: 'GET',
              url: `${API_URL}${authors}/${idAuthor}`,
              failOnStatusCode: false,
       })
  }

  getAuthorByBookID(idAuthor){
       return cy.request({
              method: 'GET',
              url: `${API_URL}${authors}/authors/books/${idAuthor}`,
              failOnStatusCode: false,
       })
  }


  postAuthors(payload){
     return cy.request({
            method: 'POST',
            url: `${API_URL}${authors}`,
            failOnStatusCode: false,
            body: payload
     })
   }

   deleteAuthor(idAuthor){
     return cy.request({
            method: 'DELETE',
            url: `${API_URL}${authors}/${idAuthor}`,
            failOnStatusCode: false,
        })
    }

    putAuthor(payload,idAuthor){
                  return cy.request({
                         method: 'PUT',
                         url: `${API_URL}${authors}/${idAuthor}`,
                         failOnStatusCode: false,
                         body: payload
                     })
                 }


}