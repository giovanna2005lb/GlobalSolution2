package br.com.fiap.resource;

import br.com.fiap.beans.RelatorioEnergetico;
import br.com.fiap.bo.RelatorioEnergeticoBO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

import java.sql.SQLException;
import java.util.List;

@Path("/relatorio") // Define o endpoint para a API
public class RelatorioEnergeticoResource {

    private RelatorioEnergeticoBO relatorioBO = new RelatorioEnergeticoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RelatorioEnergetico> buscar() throws ClassNotFoundException, SQLException {
        return relatorioBO.selecionarBo();
    }

    // Cadastrar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarRelatorio(RelatorioEnergetico relatorio, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        relatorioBO.inserirBo(relatorio);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(relatorio.getIdRelatorio()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{idRelatorio}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRelatorio(RelatorioEnergetico relatorio, @PathParam("idRelatorio") int idRelatorio) throws ClassNotFoundException, SQLException {
        relatorio.setIdRelatorio(idRelatorio);
        relatorioBO.atualizarBo(relatorio);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idRelatorio}")
    public Response deletarRelatorio(@PathParam("idRelatorio") int idRelatorio) throws ClassNotFoundException, SQLException {
        relatorioBO.deletarBo(idRelatorio);
        return Response.ok().build();
    }
}
