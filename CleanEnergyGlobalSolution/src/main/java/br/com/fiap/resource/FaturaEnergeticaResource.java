package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.FaturaEnergetica;
import br.com.fiap.bo.FaturaEnergeticaBO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/faturaEnergetica")
public class FaturaEnergeticaResource {

    private FaturaEnergeticaBO faturaBo = new FaturaEnergeticaBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FaturaEnergetica> buscar() throws ClassNotFoundException, SQLException {
        return faturaBo.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(FaturaEnergetica fatura, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        faturaBo.inserirBo(fatura);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(fatura.getIdFatura()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{idFatura}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(FaturaEnergetica fatura, @PathParam("idFatura") int idFatura) throws ClassNotFoundException, SQLException {
        fatura.setIdFatura(idFatura);
        faturaBo.atualizarBo(fatura);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idFatura}")
    public Response deletarRs(@PathParam("idFatura") int idFatura) throws ClassNotFoundException, SQLException {
        faturaBo.deletarBo(idFatura);
        return Response.ok().build();
    }
}
