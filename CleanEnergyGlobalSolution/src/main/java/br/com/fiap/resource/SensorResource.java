package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.Sensor;
import br.com.fiap.bo.SensorBO;
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

@Path("/sensor") // Define o endpoint para a API
public class SensorResource {

    private SensorBO sensorBO = new SensorBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> buscar() throws ClassNotFoundException, SQLException {
        return sensorBO.selecionarBo();
    }

    // Cadastrar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(Sensor sensor, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
    	sensorBO.inserirBo(sensor);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(sensor.getId_sensor()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{id_sensor}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Sensor sensor, @PathParam("id_sensor") int id_sensor) throws ClassNotFoundException, SQLException {
        sensor.setId_sensor(id_sensor);
        sensorBO.atualizarBo(sensor);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{email}")
    public Response deleteRs(@PathParam("id_sensor") int id_sensor) throws ClassNotFoundException, SQLException {
        sensorBO.deletarBo(id_sensor);
        return Response.ok().build();
    }

}
