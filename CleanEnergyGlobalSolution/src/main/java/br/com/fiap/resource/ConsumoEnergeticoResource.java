package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.ConsumoEnergetico;
import br.com.fiap.bo.ConsumoEnergeticoBO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/consumoEnergetico")
public class ConsumoEnergeticoResource {

    private ConsumoEnergeticoBO consumoBo = new ConsumoEnergeticoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConsumoEnergetico> buscar() throws ClassNotFoundException, SQLException {
        return consumoBo.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(ConsumoEnergetico consumoEnergetico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        consumoBo.inserirBo(consumoEnergetico);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(consumoEnergetico.getIdConsumo()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{idConsumo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(ConsumoEnergetico consumoEnergetico, @PathParam("idConsumo") int idConsumo) throws ClassNotFoundException, SQLException {
        consumoEnergetico.setIdConsumo(idConsumo);
        consumoBo.atualizarBo(consumoEnergetico);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idConsumo}")
    public Response deletarRs(@PathParam("idConsumo") int idConsumo) throws ClassNotFoundException, SQLException {
        consumoBo.deletarBo(idConsumo);
        return Response.ok().build();
    }
}
