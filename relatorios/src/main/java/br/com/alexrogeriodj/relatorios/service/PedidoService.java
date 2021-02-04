package br.com.alexrogeriodj.relatorios.service;

import br.com.alexrogeriodj.relatorios.util.anotations.VendasClientWS;
import br.com.alexrogeriodj.relatorios.vo.ClienteRankingVo;
import br.com.alexrogeriodj.relatorios.vo.VeiculoRankingVo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.List;

@Named
public class PedidoService implements Serializable {

    @Inject
    @VendasClientWS
    private WebTarget clientVendasWS;

    public List<ClienteRankingVo> findTopClientes() {
        return clientVendasWS.path("/pedido/buscar/topClientes").request().get(new GenericType<List<ClienteRankingVo>>(){});
    }

    public List<VeiculoRankingVo> findTopVeiculos() {
        return clientVendasWS.path("/pedido/buscar/topVeiculos").request().get(new GenericType<List<VeiculoRankingVo>>() {});
    }

}
