/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.dokidoki.rest.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.dokidoki.entity.Contacto;
import utn.frd.dokidoki.sessions.ContactoFacade;
/**
 *
 * @author Sergio
 */
@Path("/contacto")
public class ContactoRest {
    @EJB
    private ContactoFacade ejbContactoFacade;
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Contacto> findAll(){
        return ejbContactoFacade.findAll();
    }
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Contacto contacto){
        ejbContactoFacade.create(contacto);
    }
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Contacto contacto){
        ejbContactoFacade.edit(contacto);
    }
    //eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")int id){
        ejbContactoFacade.remove( ejbContactoFacade.find(id) );
    }
    //obtener una entidad por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Contacto findById(@PathParam("id")long id){
        return ejbContactoFacade.find(id);
    }
}