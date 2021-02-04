package br.com.alexrogeriodj.vendas.service;

import br.com.alexrogeriodj.vendas.model.Usuario;
import br.com.alexrogeriodj.vendas.util.GenericService;
import br.com.alexrogeriodj.vendas.util.anotations.ClientWs;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.client.WebTarget;

@Named
public class UsuarioService extends GenericService<Usuario, Long> {

    @Inject
    @ClientWs
    private WebTarget webTarget;

    @Transactional
    public Usuario atualizarUsuario(String email) {
        final Usuario usuarioPortal = webTarget.path("/usuario/buscar/").path(email).request().get(Usuario.class);
        final Usuario usuarioBanco = findByEmail(email);

        if(usuarioBanco != null && usuarioBanco.getVersion() == usuarioPortal.getVersion()) {
            return usuarioBanco;
        }

        save(usuarioPortal);

        return usuarioPortal;
    }

    public Usuario findByEmail(String email) {
        return getResultOrNull(getEntityManager().createNamedQuery("Usuario.findByEmail", Usuario.class)
                .setParameter("email", email)
                .getResultList());
    }
}
