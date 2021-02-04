package br.com.alexrogeriodj.vendas.ws;


import br.com.alexrogeriodj.vendas.model.Cliente;
import br.com.alexrogeriodj.vendas.model.Modelo;
import br.com.alexrogeriodj.vendas.model.Veiculo;
import br.com.alexrogeriodj.vendas.service.ClienteService;
import br.com.alexrogeriodj.vendas.service.ModeloService;
import br.com.alexrogeriodj.vendas.service.VeiculoService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("cadastros")
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrosWs {

    @Inject
    private ClienteService clienteService;

    @Inject
    private ModeloService modeloService;

    @Inject
    private VeiculoService veiculoService;

    @PUT
    @Path("clientes/atualizar")
    public void atualizarCliente(Cliente cliente) {
        clienteService.save(cliente);
    }

    @PUT
    @Path("modelos/atualizar")
    public void atualizarModelo(Modelo modelo) {
        modeloService.save(modelo);
    }

    @PUT
    @Path("modelos/atualizar")
    public void atualizarModelo(Veiculo veiculo) {
        veiculoService.save(veiculo);
    }

}
