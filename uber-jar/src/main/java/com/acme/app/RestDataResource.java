package com.acme.app;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("rest-data")
public class RestDataResource {

    @GET
    public Response getAllData() {
        List<RestData> data = Database.getRestData();
        return Response.ok(data).build();
    }

    @GET
    @Path("{dataId}")
    public Response getData(@PathParam("dataId") String dataId) {
        RestData data = Database.getData(dataId);
        return data != null
                ? Response.ok(data).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewData(RestData data) {
        Database.addDataInstance(data);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{dataId}")
    public Response deleteData(@PathParam("dataId") String dataId) {
        Database.deleteDataInstance(dataId);
        return Response.noContent().build();
    }
}
