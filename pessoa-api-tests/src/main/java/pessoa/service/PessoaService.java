package pessoa.service;
import org.apache.http.client.utils.URIBuilder;

import io.restassured.http.ContentType;
import org.kohsuke.rngom.util.Uri;
import pessoa.dto.*;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PessoaService {

    private static final String baseUrl = "https://dbc-pessoa-api.herokuapp.com/pessoa/";

    // ***************************************************************************
    //                        CADASTRO PESSOA    */  -> POST
    // ***************************************************************************
    public PessoaValidPostDTO cadastroPessoaValida(String token, String jsonBody) {
        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                header("Authorization", token).
                log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(PessoaValidPostDTO.class); // recuperar como PessoaValidPostDTO
    }

    public PessoaInvalidDTO cadastroPessoaVazia(String token, String jsonBody) {
        return given().
                contentType(ContentType.JSON).
                header("Authorization", token).
                log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl)
                .then()
                .log()
                .all()
                .statusCode(400)
                .extract().as(PessoaInvalidDTO.class); // recuperar como PessoaValidPostDTO
    }

    // ***************************************************************************
    //                        EDICAO PESSOA    */  -> PUT
    // ***************************************************************************
    public PessoaValidPostDTO edicaoPessoaValida(String token, String jsonBody, String idPessoa) {
        // REST-ASSURED
        //dado isso

        String newUrl = baseUrl + idPessoa;
        return given().
                contentType(ContentType.JSON).
                header("Authorization", token).
                log().all()
                .body(jsonBody)
                .when()
                .put(newUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(PessoaValidPostDTO.class); // recuperar como PessoaValidPostDTO
    }

    public PessoaInvalidDTO edicaoPessoaInvalida(String token, String jsonBody, String idPessoa) {
        // REST-ASSURED
        //dado isso

        String newUrl = baseUrl + idPessoa;
        return given().
                contentType(ContentType.JSON).
                header("Authorization", token).
                log().all()
                .body(jsonBody)
                .when()
                .put(newUrl)
                .then()
                .log()
                .all()
                .statusCode(400)
                .extract().as(PessoaInvalidDTO.class); // recuperar como PessoaValidPostDTO
    }

    // ***************************************************************************
    //                        DELECAO PESSOA    */{idPessoa}  -> DELETE
    // ***************************************************************************
    public void deletePessoaValida(String token, String id) {

        String newUrl = baseUrl + id;
        given().
                header("Authorization", token).
                log().all()
                .when()
                .delete(newUrl)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    public PessoaInvalidDTO deletePessoaInvalida(String token, String id) {

        String newUrl = baseUrl + id;
        return given().
                header("Authorization", token).
                log().all()
                .when()
                .delete(newUrl)
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract().as(PessoaInvalidDTO.class);
    }


    // ***************************************************************************
    //                  RECUPERAR INTERVALO DE DATAS    */data-nascimento  -> GET
    // ***************************************************************************
    public PessoaValidPostDTO[] recuperarPessoasNoIntervaloDeDatas(String token, String data1, String data2) throws URISyntaxException {

        String newUrl = baseUrl + "data-nascimento";

        String[] data1list = data1.split("-");
        String[] data2list = data2.split("-");

        data1 = data1list[2]+"/"+data1list[1]+"/"+data1list[0];
        data2 = data2list[2]+"/"+data2list[1]+"/"+data2list[0];

        URIBuilder ub = new URIBuilder(newUrl);
        ub.addParameter("data", data1);
        ub.addParameter("dtFinal", data2);
        String url = ub.toString();


        return given().
                header("Authorization", token).
                log().all()
                .when()
                .get(url)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(PessoaValidPostDTO[].class);
    }

    // ***************************************************************************
    //                        RECUPERAR PESSOA POR CPF    */{cpf}/cpf
    // ***************************************************************************

    public PessoaValidPostDTO recuperarPessoaValidaPorCpf(String token, String cpf) {

            String newUrl = baseUrl + cpf + "/cpf";
            return given().
                    header("Authorization", token).
                    log().all()
                    .when()
                    .get(newUrl)
                    .then()
                    .log()
                    .all()
                    .statusCode(200)
                    .extract().as(PessoaValidPostDTO.class); // recuperar como PessoaValidPostDTO
    }

    public void recuperarPessoaInexistentePorCpf(String token, String cpf) {

        String newUrl = baseUrl + cpf + "/cpf";

        given().
        header("Authorization", token).
        log().all()
        .when()
        .get(newUrl)
        .then()
        .log()
        .all()
        .statusCode(200);
    }


    // ***************************************************************************
    //                              LISTAR PESSOAS    */
    // ***************************************************************************
    public PageDTO listarPessoasValido(String token, String nroPagina, String tamanhoDeCadaPagina) {

        String newUrl = baseUrl.substring(0, baseUrl.length() -1) + "?pagina=" + nroPagina +"&tamanhoDasPaginas="+tamanhoDeCadaPagina;
        return given().
                header("Authorization", token).
                log().all()
                .when()
                .get(newUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(PageDTO.class); // recuperar como PessoaValidPostDTO
    }

    public PessoaInvalidDTO listarPessoasInvalido(String token, String nroPagina, String tamanhoDeCadaPagina) {

        String newUrl = baseUrl.substring(0, baseUrl.length() -1) + "?pagina=" + nroPagina +"&tamanhoDasPaginas="+tamanhoDeCadaPagina;
        return given().
                header("Authorization", token).
                log().all()
                .when()
                .get(newUrl)
                .then()
                .log()
                .all()
                .statusCode(500)
                .extract().as(PessoaInvalidDTO.class); // recuperar como PessoaValidPostDTO
    }

    // ***************************************************************************
    //                              PESSOA RELATORIO      */relatorio?idPessoa{}
    // ***************************************************************************
    public RelatorioDTO[] relatorioPessoaValido(String token, String idPessoaBuscada) {

        String newUrl = baseUrl+ "relatorio?idPessoa=" + idPessoaBuscada;

        return given().
                header("Authorization", token).
                log().all()
                .when()
                .get(newUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(RelatorioDTO[].class);
    }

    public void relatorioPessoaInvalido(String token, String idPessoaBuscada) {

        String newUrl = baseUrl+ "relatorio?idPessoa=" + idPessoaBuscada;
        requestInvalidaSemRetorno(token, newUrl);
    }

    // ***************************************************************************
    //                              LISTA COMPLETA      */lista-completa
    // ***************************************************************************
    public PessoaCompletaDTO[] relatorioListaCompletaValido(String token, String idPessoaBuscada) {
        String newUrl = baseUrl+ "lista-completa?idPessoa=" + idPessoaBuscada;
        return getPessoaCompletaDTOS(token, newUrl);
    }

    public void relatorioListaCompletaInvalido(String token, String idPessoaBuscada) {
        String newUrl = baseUrl+ "relatorio?idPessoa=" + idPessoaBuscada;
        requestInvalidaSemRetorno(token, newUrl);
    }


    // ***************************************************************************
    //                            LISTA COM ENDERECOS
    // ***************************************************************************
    public PessoaCompletaDTO[] relatorioListaComEnderecosValido(String token, String idPessoaBuscada) {
        String newUrl = baseUrl+ "lista-com-enderecos?idPessoa=" + idPessoaBuscada;
        return getPessoaCompletaDTOS(token, newUrl);
    }

    public void relatorioListaComEnderecosInvalido(String token, String idPessoaBuscada) {
        String newUrl = baseUrl+ "lista-com-enderecos?idPessoa=" + idPessoaBuscada;
        requestInvalidaSemRetorno(token, newUrl);
    }

    // ***************************************************************************
    //                            LISTA COM CONTATOS
    // ***************************************************************************
    public PessoaCompletaDTO[] relatorioListaComContatosValido(String token, String idPessoaBuscada) {
        String newUrl = baseUrl+ "lista-com-contatos?idPessoa=" + idPessoaBuscada;
        return getPessoaCompletaDTOS(token, newUrl);
    }

    public void relatorioListaComContatosInvalido(String token, String idPessoaBuscada) {
        String newUrl = baseUrl+ "lista-com-contatos?idPessoa=" + idPessoaBuscada;
        requestInvalidaSemRetorno(token, newUrl);
    }

    // ***************************************************************************
    //                        LISTAR BUSCA POR NOME */byname
    // ***************************************************************************
    public PessoaCompletaDTO[] listarPorNomeValido(String token, String busca) {

        String newUrl = baseUrl+ "byname?nome=" + busca;

        return given().
                header("Authorization", token).
                log().all()
                .when()
                .get(newUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(PessoaCompletaDTO[].class);
    }

    public Object[] listarPorNomeInvalido(String token, String busca) {
        String newUrl = baseUrl+ "byname?nome=" + busca;
        return  given().
                header("Authorization", token).
                log().all()
                .when()
                .get(newUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(Object[].class);

    }


    // ***************************************************************************
    //                                UTILITÁRIOS
    // ***************************************************************************
    private PessoaCompletaDTO[] getPessoaCompletaDTOS(String token, String newUrl) {
        return given().
                header("Authorization", token).
                log().all()
                .when()
                .get(newUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(PessoaCompletaDTO[].class);
    }

    private void requestInvalidaSemRetorno(String token, String newUrl){
        given().
                header("Authorization", token).
                log().all()
                .when()
                .get(newUrl)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

}
