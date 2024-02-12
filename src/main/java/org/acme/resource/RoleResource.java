package org.acme.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.acme.entity.Role;
import org.acme.service.RoleService;

import java.util.List;

@ApplicationScoped
@Path("/role")
public class RoleResource {

    @Inject RoleService service;

    @GET
    @Path("/roles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getAllRoles(@QueryParam("page") @DefaultValue("0") int page) {
        return service.sortRoles(Role.listAll());
    }
}
