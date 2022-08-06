package pessoa;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pessoa.dto.*;
import pessoa.service.PessoaService;
import utils.JsonManipulation;

import java.net.URISyntaxException;
import java.util.Map;

import static massaDeDados.PostPaths.*;
import static utils.JsonManipulation.criarJsonCadastro;
import static utils.Util.*;

public class pessoaTests {
    PessoaService pessoaService = new PessoaService();

    // ***************************************************************************
    //                       CADASTRAR PESSOA -> POST
    // ***************************************************************************
    @Test
    public void cadastroPessoaValida(){

        Map<String, String> pessoaEnviadaParaRequisicao = JsonManipulation
                .recuperarCadastro(cadastroPessoaValidaPostPath);

        criarJsonCadastro(pessoaEnviadaParaRequisicao, cadastroCriadoPath);

        PessoaValidPostDTO pessoaValidPostDTO =
                pessoaService.cadastroPessoaValida(loginAdmin(),
                        converterJsonParaArrayDeBytes(cadastroPessoaValidaPostPath));

        // Verificando nome
        Assert.assertEquals(pessoaValidPostDTO.getNome(), pessoaEnviadaParaRequisicao.get("nome"));

        // Verificando cpf
        Assert.assertEquals(pessoaValidPostDTO.getCpf(), pessoaEnviadaParaRequisicao.get("cpf"));

        // Verificando data
        Assert.assertEquals(pessoaValidPostDTO.getDataNascimento(), pessoaEnviadaParaRequisicao.get("dataNascimento"));

        // Verificando email
        Assert.assertEquals(pessoaValidPostDTO.getEmail(), pessoaEnviadaParaRequisicao.get("email"));

        // Verificando se o id nao é nulo
        Assert.assertNotNull(pessoaValidPostDTO.getIdPessoa());


        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaValidPostDTO.getIdPessoa().toString());


    }

    @Test
    public void cadastroPessoaVazia(){

        PessoaInvalidDTO pessoaInvalidDTO =
                pessoaService.cadastroPessoaVazia(loginAdmin(),
                        converterJsonParaArrayDeBytes(cadastroPessoaVaziaPostPath));

        // Verificando requisicao
        Assert.assertEquals(pessoaInvalidDTO.getStatus(), String.valueOf(HttpStatus.SC_BAD_REQUEST));

        // Verificando invalidação da data
        Assert.assertEquals(pessoaInvalidDTO.getErrors()[0], nomeInvalido);
        // Verificando invalidação do nome
        Assert.assertEquals(pessoaInvalidDTO.getErrors()[1], dataNascimentoInvalida);


    }
    // ***************************************************************************
    //                       DELETAR PESSOA -> DELETE
    // ***************************************************************************
    @Test
    public void deletePessoaValida(){

        PessoaValidPostDTO pessoaValidPostDTO = cadastrarPessoaValida();
        String idPessoaASerDeletada = pessoaValidPostDTO.getIdPessoa().toString();
        deletarPessoaPorId(idPessoaASerDeletada);

    }

    @Test
    public void deletePessoaInvalida(){

        cadastrarPessoaValida();
        String idPessoaASerDeletada = "-1";
        PessoaInvalidDTO pessoaInvalidDTO = pessoaService.deletePessoaInvalida(loginAdmin(), idPessoaASerDeletada);
        // Verificando invalidação do nome
        Assert.assertEquals(pessoaInvalidDTO.getMessage(), idPessoaNaoEncontrado);
    }


    // ***************************************************************************
    //                       EDITAR PESSOA  -> PUT
    // ***************************************************************************
    @Test
    public void editarPessoaCompletaValida(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        Map<String, String> pessoaEnviadaParaRequisicao = JsonManipulation
                .recuperarCadastro(updatePessoaValidaPutPath);

        criarJsonCadastro(pessoaEnviadaParaRequisicao, updateCriadoPath);

        PessoaValidPostDTO pessoaEditadaRetornada = pessoaService.
                edicaoPessoaValida(loginAdmin(),
                        converterJsonParaArrayDeBytes(updatePessoaValidaPutPath),
                        pessoaCadastrada.getIdPessoa().toString());


        // Verificando nome
        Assert.assertEquals(pessoaEditadaRetornada.getNome(), pessoaEnviadaParaRequisicao.get("nome"));

        // Verificando cpf
        Assert.assertEquals(pessoaEditadaRetornada.getCpf(), pessoaEnviadaParaRequisicao.get("cpf"));

        // Verificando data
        Assert.assertEquals(pessoaEditadaRetornada.getDataNascimento(), pessoaEnviadaParaRequisicao.get("dataNascimento"));

        // Verificando email
        Assert.assertEquals(pessoaEditadaRetornada.getEmail(), pessoaEnviadaParaRequisicao.get("email"));

        // Verificando se o id continua nao nulo
        Assert.assertNotNull(pessoaEditadaRetornada.getIdPessoa());


        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaEditadaRetornada.getIdPessoa().toString());
    }

    @Test
    public void editarPessoaVazia(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        Map<String, String> pessoaEnviadaParaRequisicao = JsonManipulation
                .recuperarCadastro(updatePessoaValidaPutPath);

        criarJsonCadastro(pessoaEnviadaParaRequisicao, updateCriadoPath);

        PessoaInvalidDTO pessoaInvalidEditDTO = pessoaService.
                edicaoPessoaInvalida(loginAdmin(),
                        converterJsonParaArrayDeBytes(updatePessoaVaziaPostPath),
                        pessoaCadastrada.getIdPessoa().toString());


        // Verificando requisicao
        Assert.assertEquals(pessoaInvalidEditDTO.getStatus(), String.valueOf(HttpStatus.SC_BAD_REQUEST));

        // Verificando invalidação do nome
        Assert.assertEquals(pessoaInvalidEditDTO.getErrors()[0], nomeInvalido);
        // Verificando invalidação da data
        Assert.assertEquals(pessoaInvalidEditDTO.getErrors()[1], dataNascimentoInvalida);



        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());
    }


    // ***************************************************************************
    //                   RECUPERAR PESSOAS INTERVALO DATAS /data-nascimento
    // ***************************************************************************
    @Test
    public void recuperarPessoasIntervaloDatasValido() throws URISyntaxException {

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        pessoaService.recuperarPessoasNoIntervaloDeDatas(loginAdmin(), pessoaCadastrada.getDataNascimento(), "2002-10-15");

        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());
    }


    // ***************************************************************************
    //                       RECUPERAR POR CPF   /{cpf}/cpf
    // ***************************************************************************
    @Test
    public void recuperarPessoaPorCpf(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        PessoaValidPostDTO pessoaBuscada = pessoaService.recuperarPessoaValidaPorCpf(loginAdmin(), pessoaCadastrada.getCpf());

        // Verificando nome
        Assert.assertEquals(pessoaCadastrada.getNome(), pessoaBuscada.getNome());

        // Verificando cpf
        Assert.assertEquals(pessoaCadastrada.getCpf(), pessoaBuscada.getCpf());

        // Verificando data
        Assert.assertEquals(pessoaCadastrada.getDataNascimento(), pessoaBuscada.getDataNascimento());

        // Verificando email
        Assert.assertEquals(pessoaCadastrada.getEmail(), pessoaBuscada.getEmail());

        // Verificando se o id continua nao nulo
        Assert.assertEquals(pessoaCadastrada.getIdPessoa(), pessoaBuscada.getIdPessoa());


        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());

    }

    @Test
    public void recuperarPorCpfInexistente(){
        String idInvalido = "-1";
        pessoaService.recuperarPessoaInexistentePorCpf(loginAdmin(), idInvalido);
    }


    // ***************************************************************************
    //                       LISTAR PESSOAS
    // ***************************************************************************
    @Test
    public void listarPessoasValido(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        String nroPagina = "0";
        String tamanhoDeCadaPagina = "100";


        PageDTO paginaRecuperada = pessoaService.listarPessoasValido(loginAdmin(), nroPagina, tamanhoDeCadaPagina);

        // Deve haver pelo menos um elemento no relatório.
        Assert.assertTrue(Integer.parseInt(paginaRecuperada.getTotalElements()) >= 1);

        // Como deve haver pelo menos uma pessoa, testo se a pessoa na posição 0 do content é diferente de nula;

        // Verificando nome
        Assert.assertNotNull(paginaRecuperada.getContent()[0].getNome());

        // Verificando cpf
        Assert.assertNotNull(paginaRecuperada.getContent()[0].getCpf());

        // Verificando data
        Assert.assertNotNull(paginaRecuperada.getContent()[0].getDataNascimento());

        // Verificando email
        Assert.assertNotNull(paginaRecuperada.getContent()[0].getEmail());

        // Verificando se o id continua nao nulo
        Assert.assertNotNull(paginaRecuperada.getContent()[0].getIdPessoa());


        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());

    }

    @Test
    public void listarPessoasInvalido(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        String nroPagina = "0";
        String tamanhoDeCadaPagina = "0";

        PessoaInvalidDTO pessoaInvalidDTO = pessoaService.listarPessoasInvalido(loginAdmin(), nroPagina, tamanhoDeCadaPagina);

        // Erro 500
        Assert.assertEquals(pessoaInvalidDTO.getStatus(), String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR));

        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());

    }

    // ***************************************************************************
    //                       RELATORIO PESSOA   /relatorio
    // ***************************************************************************
    @Test
    public void relatorioPessoaValido(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        String idPessoaBuscada = pessoaCadastrada.getIdPessoa().toString();

        RelatorioDTO[] pessoasRecuperadas = pessoaService.relatorioPessoaValido(loginAdmin(), idPessoaBuscada);

        // Como deve haver pelo menos uma pessoa, verifico que os elementos da pessoa na posicao 0 são diferentes de nulo;

        // Verificando nome
        Assert.assertNotNull(pessoasRecuperadas[0].getNomePessoa());

        // Verificando email
        Assert.assertNotNull(pessoasRecuperadas[0].getEmail());

        // Verificando se o id continua nao nulo
        Assert.assertNotNull(pessoasRecuperadas[0].getIdPessoa());


        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());

    }


    @Test
    public void relatorioPessoaInvalido(){
        String idInvalido = "-1";
        pessoaService.relatorioPessoaInvalido(loginAdmin(), idInvalido);
    }


    // ***************************************************************************
    //                       RELATORIO LISTA COMPLETA    /lista-completa
    // ***************************************************************************
    @Test
    public void relatorioListaCompletaValido(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        String idPessoaBuscada = pessoaCadastrada.getIdPessoa().toString();

        PessoaCompletaDTO[] pessoasRecuperadas = pessoaService.relatorioListaCompletaValido(loginAdmin(), idPessoaBuscada);

        // Como deve haver pelo menos uma pessoa, verifico que os elementos da pessoa na posicao 0 são diferentes de nulo;

        // Verificando nome
        Assert.assertNotNull(pessoasRecuperadas[0].getNome());

        // Verificando email
        Assert.assertNotNull(pessoasRecuperadas[0].getEmail());

        // Verificando se o id continua nao nulo
        Assert.assertNotNull(pessoasRecuperadas[0].getIdPessoa());


        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());

    }

    @Test
    public void relatorioListaCompletaInvalido(){
        String idInvalido = "-1";
        pessoaService.relatorioListaCompletaInvalido(loginAdmin(), idInvalido);
    }


    // ***************************************************************************
    //                            LISTA COM ENDERECOS  /lista-com-enderecos
    // ***************************************************************************
    @Test
    public void relatorioListaComEnderecosValido(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        String idPessoaBuscada = pessoaCadastrada.getIdPessoa().toString();

        PessoaCompletaDTO[] pessoasRecuperadas = pessoaService.relatorioListaComEnderecosValido(loginAdmin(), idPessoaBuscada);

        // Como deve haver pelo menos uma pessoa, verifico que os elementos da pessoa na posicao 0 são diferentes de nulo;

        // Verificando nome
        Assert.assertNotNull(pessoasRecuperadas[0].getNome());

        // Verificando email
        Assert.assertNotNull(pessoasRecuperadas[0].getEmail());

        // Verificando se o id continua nao nulo
        Assert.assertNotNull(pessoasRecuperadas[0].getIdPessoa());


        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());

    }

    @Test
    public void relatorioListaComEnderecosInvalido(){
        String idInvalido = "-1";
        pessoaService.relatorioListaComEnderecosInvalido(loginAdmin(), idInvalido);
    }

    // ***************************************************************************
    //                            LISTA COM CONTATOS    /lista-com-contatos
    // ***************************************************************************

    @Test
    public void relatorioListaComContatosValido(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        String idPessoaBuscada = pessoaCadastrada.getIdPessoa().toString();

        PessoaCompletaDTO[] pessoasRecuperadas = pessoaService.relatorioListaComContatosValido(loginAdmin(), idPessoaBuscada);

        // Como deve haver pelo menos uma pessoa, verifico que os elementos da pessoa na posicao 0 são diferentes de nulo;

        // Verificando nome
        Assert.assertNotNull(pessoasRecuperadas[0].getNome());

        // Verificando email
        Assert.assertNotNull(pessoasRecuperadas[0].getEmail());

        // Verificando se o id continua nao nulo
        Assert.assertNotNull(pessoasRecuperadas[0].getIdPessoa());


        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());

    }

    @Test
    public void relatorioListaComContatosInvalido(){
        String idInvalido = "-1";
        pessoaService.relatorioListaComContatosInvalido(loginAdmin(), idInvalido);
    }

    // ***************************************************************************
    //                        LISTAR BUSCA POR NOME */byname
    // ***************************************************************************

    @Test
    public void listarPorNomeValido(){

        PessoaValidPostDTO pessoaCadastrada = cadastrarPessoaValida();

        String nomePessoaBuscada = pessoaCadastrada.getNome();

        PessoaCompletaDTO[] pessoasRecuperadas = pessoaService.listarPorNomeValido(loginAdmin(), nomePessoaBuscada);

        // Como deve haver pelo menos uma pessoa, verifico que os elementos da pessoa na posicao 0 são diferentes de nulo;

        // Verificando nome
        Assert.assertNotNull(pessoasRecuperadas[0].getNome());

        // Verificando cpf
        Assert.assertNotNull(pessoasRecuperadas[0].getCpf());

        // Verificando data
        Assert.assertNotNull(pessoasRecuperadas[0].getDataNascimento());

        // Verificando email
        Assert.assertNotNull(pessoasRecuperadas[0].getEmail());

        // Verificando se o id continua nao nulo
        Assert.assertNotNull(pessoasRecuperadas[0].getIdPessoa());

        // Deletando pessoa após as validações
        deletarPessoaPorId(pessoaCadastrada.getIdPessoa().toString());

    }

    @Test
    public void listarPorNomeInvalido(){
        String nomeInexistente = "-1";

        Object[] retorno =  pessoaService.listarPorNomeInvalido(loginAdmin(), nomeInexistente);

        Assert.assertEquals(retorno.length, 0);
    }



    // ***************************************************************************
    //                                UTILITÁRIOS
    // ***************************************************************************
    public PessoaValidPostDTO cadastrarPessoaValida(){
        Map<String, String> pessoaEnviadaParaRequisicao = JsonManipulation
                .recuperarCadastro(cadastroPessoaValidaPostPath);

        criarJsonCadastro(pessoaEnviadaParaRequisicao, cadastroCriadoPath);

        return pessoaService.cadastroPessoaValida(loginAdmin(),
                        converterJsonParaArrayDeBytes(cadastroPessoaValidaPostPath));
    }

    private void deletarPessoaPorId(String idPessoaASerDeletada) {
        pessoaService.deletePessoaValida(loginAdmin(), idPessoaASerDeletada);
    }


}
