package br.com.alexrogeriodj.relatorios.controller;

import br.com.alexrogeriodj.relatorios.model.Modulo;
import br.com.alexrogeriodj.relatorios.model.Usuario;
import br.com.alexrogeriodj.relatorios.util.ApplicationProperty;
import br.com.alexrogeriodj.relatorios.util.TokenUsuarioUtil;
import br.com.alexrogeriodj.relatorios.util.anotations.UsuarioLogado;
import org.omnifaces.util.Faces;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UtilController {

    @Inject
    @UsuarioLogado
    private Usuario usuario;

    @Inject
    private ApplicationProperty configuracao;

    public void redirectAplicacao(Modulo moduloMenu) throws IOException {
        final String token = TokenUsuarioUtil.createToken(usuario, moduloMenu);
        Faces.redirect(moduloMenu.getUrl() + "?token=%s&", token);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ApplicationProperty getConfiguracao() {
        return configuracao;
    }
}
