/*
package eapli.base.app.backoffice.console.presentation.pedidoPresentation;

import eapli.base.app.backoffice.console.presentation.catalogoPresentation.ListaCatalogosPrinter;
import eapli.base.app.backoffice.console.presentation.servicoPresentation.ListaServicosPrinter;
import eapli.base.catalogomanagement.dto.CatalogoDto;
import eapli.base.pedidomanagement.application.SolicitarServicoController;
import eapli.base.pedidomanagement.domain.Urgencia;
import eapli.base.servicomanagement.dto.AtributoDTO;
import eapli.base.servicomanagement.dto.FormularioDTO;
import eapli.base.servicomanagement.dto.ServicoDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.*;

public class SolicitarServicoUI extends AbstractUI {

    private SolicitarServicoController solicitarServicoController;

    public SolicitarServicoUI() {
        solicitarServicoController = new SolicitarServicoController();
    }

    @Override
    protected boolean doShow() {

        solicitarServicoController.withUser(); //vai buscar quem está a solicitar o serviço

        System.out.println("Escolha o catalogo que pretende: ");
        //listar catalogos para ele escolher um
        CatalogoDto catalogoDto = selectCatalogo();

        System.out.println("Escoha o serviço: ");
        //listar serviços para ele escolher um
        ServicoDTO servicoDTO = selectServico(catalogoDto.id);
        solicitarServicoController.withServico(servicoDTO.id);

        //solicitarServicoController.withPedidoId();
        //escolhe urgencia
        String urgencia = listaUrgencia();
        solicitarServicoController.withUrgencia(urgencia);

        //insere datas
        Calendar dataLimiteResolucao = Console.readCalendar("Insira a data limite resolucao: ", "dd-MM-yyyy");
        solicitarServicoController.withDataLimiteResolucao(dataLimiteResolucao);

        Calendar dataCriacao = Calendar.getInstance();
        //System.out.println(dataCriacao);
        solicitarServicoController.withDataCriacao(dataCriacao);

        //pede os ficheiros necessários para o pedido
        System.out.println("Adicione ficheiros ao pedido: ");

        int option = 1;

        while(option == 1) {
            String nomeFicheiro = Console.readLine("Insira o nome do ficheiro: ");
            solicitarServicoController.addFicheiro(nomeFicheiro);
            option = Console.readInteger("Deseja inserir mais algum ficheiro?\n\t0. NAO\n1.SIM");
        }

        solicitarServicoController.withListaFicheiros();

        //pede respostas ao formulario do servico

        System.out.println("### Resposta ao formulario Servico ###:\n");
        FormularioDTO formularioDTO = solicitarServicoController.obtainFormularioServico();
        showFormulario(formularioDTO);

        for(AtributoDTO atributoDTO : formularioDTO.listaAtributosDTO) {
            showAtributo(atributoDTO);
            String resposta = Console.readLine("Insira a resposta: ");
            solicitarServicoController.addResposta(resposta, atributoDTO.id);
        }

        solicitarServicoController.addFormularioResposta(formularioDTO.idFormulario);
        solicitarServicoController.withEstadoPedido("submetido");
        solicitarServicoController.createPedido();

        return false;
    }

    private void showFormulario(FormularioDTO formularioDTO) {
        System.out.printf("ID: %d\nNOME: %s", formularioDTO.idFormulario, formularioDTO.nomeFormulario);
    }

    private void showAtributo(AtributoDTO atributoDTO) {
        System.out.printf("NOME VARIAVEL: %s\nTIPO DADOS BASE: %s\nDESCRICAO AJUDA: %s\nETIQUETA: %s\nEXPRESSAO: %s\n",
                atributoDTO.nomeVariavel, atributoDTO.tipoDadosBase, atributoDTO.descricaoAjuda,
                atributoDTO.etiquetaApresentacao, atributoDTO.expressaoRegular);
    }

    private CatalogoDto selectCatalogo() {
        System.out.println("Lista de catalogos");
        final List<CatalogoDto> listaCatalogos = solicitarServicoController.requestAllCatalogosForColaborador();
        final SelectWidget<CatalogoDto> selectorCatalogo = new SelectWidget<>("Selecione um Catalogo", listaCatalogos,
                new ListaCatalogosPrinter());
        selectorCatalogo.show();
        return selectorCatalogo.selectedElement();
    }

    private String listaUrgencia() {
        int option = 0;
        Map<Integer, String> map = new HashMap<>();
        System.out.println("### Lista de Urgencias: ###\n");
        for (int i = 0; i < Urgencia.TipoUrgencia.values().length; i++) {
            System.out.println(i + ". " + Urgencia.TipoUrgencia.values()[i].toString());
            map.put(i, Urgencia.TipoUrgencia.values()[i].toString());
        }

        option = Console.readInteger("Selecione a opção que pretende: ");

        return map.get(option);
    }

    private ServicoDTO selectServico(Long catalogoId) {
        System.out.println("Lista de Servicos");
        final List<ServicoDTO> listaServicos = solicitarServicoController.allServicosFromCatalogo(catalogoId);
        final SelectWidget<ServicoDTO> selectorServico = new SelectWidget<>("Selecione um servico", listaServicos,
                new ListaServicosPrinter());
        selectorServico.show();
        return selectorServico.selectedElement();
    }

    @Override
    public String headline() {
        return "Solicitar Serviço";
    }
}
*/
