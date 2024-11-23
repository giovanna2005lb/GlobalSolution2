package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

import br.com.fiap.beans.AlgoritmoIa;
import br.com.fiap.bo.AlgoritmoIaBO;

@Path("/algoritmoia") // Define o endpoint para a API
public class AlgoritmoIaResource {

    private AlgoritmoIaBO algoritmoIaBO = new AlgoritmoIaBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AlgoritmoIa> buscar() throws ClassNotFoundException, SQLException {
        return algoritmoIaBO.selecionarBo();
    }

    // Cadastrar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(AlgoritmoIa algoritmoIa, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
    	algoritmoIaBO.inserirBo(algoritmoIa);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(algoritmoIa.getNome());
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{nome}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(AlgoritmoIa algoritmoIa, @PathParam("nome") String nome) throws ClassNotFoundException, SQLException {
    	algoritmoIa.setNome(nome);
    	algoritmoIaBO.atualizarBo(algoritmoIa);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{nome}")
    public Response deleteRs(@PathParam("nome") String nome) throws ClassNotFoundException, SQLException {
    	algoritmoIaBO.deletarBo(nome);
        return Response.ok().build();
    }

}
