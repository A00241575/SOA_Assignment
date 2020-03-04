/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.characters;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;

@Path("characters")
/**
 * REST Web Service
 * @author dec72
 */
public class CharacterResource {

    private String id;

    /**
     * Creates a new instance of CharacterResource
     */
    private CharacterResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the CharacterResource
     */
    public static CharacterResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of CharacterResource class.
        return new CharacterResource(id);
    }

    /**
     * Retrieves representation of an instance of restfulpkg.CharacterResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CharacterResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource CharacterResource
     */
    @DELETE
    public void delete() {
    }
}
