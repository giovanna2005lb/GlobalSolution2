package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.HistoricoConsumo;
import br.com.fiap.bo.HistoricoConsumoBO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/historicoConsumo")
public class HistoricoConsumoResource {

    private HistoricoConsumoBO historicoBo = new HistoricoConsumoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HistoricoConsumo> buscar() throws ClassNotFoundException, SQLException {
        return historicoBo.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(HistoricoConsumo historico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        historicoBo.inserirBo(historico);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(historico.getIdHistorico()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{idHistorico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(HistoricoConsumo historico, @PathParam("idHistorico") int idHistorico) throws ClassNotFoundException, SQLException {
        historico.setIdHistorico(idHistorico);
        historicoBo.atualizarBo(historico);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idHistorico}")
    public Response deletarRs(@PathParam("idHistorico") int idHistorico) throws ClassNotFoundException, SQLException {
        historicoBo.deletarBo(idHistorico);
        return Response.ok().build();
    }
}
