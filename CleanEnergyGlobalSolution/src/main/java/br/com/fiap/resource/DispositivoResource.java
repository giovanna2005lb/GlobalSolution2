package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

import br.com.fiap.beans.Dispositivo;
import br.com.fiap.bo.DispositivoBO;

@Path("/dispositivo") // Define o endpoint para a API
public class DispositivoResource {

    private DispositivoBO dispositivoBO = new DispositivoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dispositivo> buscar() throws ClassNotFoundException, SQLException {
        return dispositivoBO.selecionarBo();
    }

    // Cadastrar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(Dispositivo dispositivo, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        dispositivoBO.inserirBo(dispositivo);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(dispositivo.getId_dispositivo())); // Ajusta o ID para String
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{id_dispositivo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Dispositivo dispositivo, @PathParam("id_dispositivo") int id_dispositivo) throws ClassNotFoundException, SQLException {
        dispositivo.setId_dispositivo(id_dispositivo);
        dispositivoBO.atualizarBo(dispositivo);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id_dispositivo}")
    public Response deleteRs(@PathParam("id_dispositivo") int id_dispositivo) throws ClassNotFoundException, SQLException {
        dispositivoBO.deletarBo(id_dispositivo);
        return Response.noContent().build(); // Melhor prática para deletar
    }
}
