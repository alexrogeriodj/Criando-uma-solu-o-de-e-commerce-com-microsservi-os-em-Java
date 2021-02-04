package br.com.alexrogeriodj.vendas.util.producers;

import br.com.alexrogeriodj.vendas.model.Usuario;
import br.com.alexrogeriodj.vendas.util.anotations.UsuarioLogado;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.inject.Produces;

public final class UsuarioProducer {

    @Produces
    @UsuarioLogado
    public Usuario getUsuarioLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}