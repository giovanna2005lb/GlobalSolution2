package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.Endereco;
import br.com.fiap.bo.EnderecoBO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/endereco") // Define o endpoint para a API
public class EnderecoResource {

    private EnderecoBO enderecoBO = new EnderecoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Endereco> buscar() throws ClassNotFoundException, SQLException {
        return enderecoBO.selecionarBo();
    }

    // Cadastrar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(Endereco endereco, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        enderecoBO.inserirBo(endereco);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(endereco.getId_endereco()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{id_endereco}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Endereco endereco, @PathParam("id_endereco") int id_endereco) throws ClassNotFoundException, SQLException {
        endereco.setId_endereco(id_endereco); // Atualizar o email no objeto recebido
        enderecoBO.atualizarBo(endereco);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id_endereco}")
    public Response deleteRs(@PathParam("id_endereco") int id_endereco) throws ClassNotFoundException, SQLException {
        enderecoBO.deletarBo(id_endereco);
        return Response.ok().build();
    }

}
