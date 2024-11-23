package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;


@Path("/usuario") // Define o endpoint para a API
public class UsuarioResource {

    private UsuarioBO usuarioBO = new UsuarioBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> buscar() throws ClassNotFoundException, SQLException {
        return usuarioBO.selecionarBo();
    }

    // Cadastrar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(Usuario usuario, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        usuarioBO.inserirBo(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(usuario.getEmail());
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Usuario usuario, @PathParam("email") String email) throws ClassNotFoundException, SQLException {
        usuario.setEmail(email); // Atualizar o email no objeto recebido
        usuarioBO.atualizarBo(usuario);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{email}")
    public Response deleteRs(@PathParam("email") String email) throws ClassNotFoundException, SQLException {
        usuarioBO.deletarBo(email);
        return Response.ok().build();
    }
}
