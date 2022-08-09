export default class Ultis {

    navegar(url){ 
       cy.visit(url)
    }
  
    click(elemet){ 
       cy.get(elemet).click() 
    }
  
    clickForce(elemet){ 
       cy.get(elemet).click({force:true}) 
    }
  
    preencherInput(element, text){ 
       cy.get(element).type(text)
    }
  
    preencherInputComTeclaNoFinal(element, text, tecla){
       cy.get(element).type(text).type(tecla);
    }
  
    preencherInputForce(element, text){ 
       cy.get(element).type(text, {force:true})
    }
    
    tempo(tempo){ 
       cy.wait(tempo) 
    }
  
    select(element, value){ 
       cy.get(element).select(value) 
    }
  
    validarText(element, text){ 
       cy.get(element).should('contain', text) 
    }
  
    validarQuantItemNaLista(element, quant){
       cy.get(element).should('have.length', quant)
    }

   typeAndTab(){
      var element = cy.get(arguments[0])
      for(var i = 1; i < arguments.length; i++){
         element.clear().type(arguments[i]).tab()
      }
   }

   assertSequenceChilds(){
      var newPath = arguments[0];
      for(var i = 1; i < arguments.length; i++){    
         cy.get(newPath + i + ')')
         .should('contain', arguments[i])
      }
   }

   enter(element){
      cy.get(element).type('{enter}')
   }
}