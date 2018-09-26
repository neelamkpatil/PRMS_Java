/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.restful;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.user.entity.User;
import sg.edu.nus.iss.phoenix.user.entity.Users;
import sg.edu.nus.iss.phoenix.user.restful.UserRESTService;
import sg.edu.nus.iss.phoenix.user.service.ReviewSelectUserService;
import sg.edu.nus.iss.phoenix.user.service.UserService;

/**
 *
 * @author wangzuxiu
 */
@Path("user")
@RequestScoped
public class UserRESTService {
    @Context
    private UriInfo context;
    
    private UserService service;

    /**
     * Creates a new instance of UserRESTService
     */
    public UserRESTService() {
        service = new UserService();
    }

    /**
     * Retrieves representation of an instance of resource
     * @return an instance of resource
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getAllUsers() {
        ArrayList<User> urlist = service.findAllUR();
        Users ursList = new Users();
        ursList.setUrList(new ArrayList<User>());
        
        for (int i = 0; i < urlist.size(); i++) {
            ursList.getUrList().add(
                new User(urlist.get(i).getId(), 
                    urlist.get(i).getPassword(),
                    urlist.get(i).getName(),
                    urlist.get(i).getRoles()));
        }

        return ursList;
    }
    
    @GET
    @Path("/allByRole")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getAllUsersByRole() {
        ReviewSelectUserService reviewUserService=new ReviewSelectUserService();
        System.out.println("in rest call");
        List<User> urlist = reviewUserService.reviewSelectUserByRole();
        Users ursList = new Users();
        ursList.setUrList(new ArrayList<User>());
        
        for (int i = 0; i < urlist.size(); i++) {
            ursList.getUrList().add(
                new User(urlist.get(i).getId(), 
                    urlist.get(i).getPassword(),
                    urlist.get(i).getName(),
                    urlist.get(i).getRoles()));
        }

        return ursList;
    }
    
    /**
     * PUT method for updating or creating an instance of resource
     * @param content representation for the resource
     */
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User ur) {
        service.processModify(ur);
    }
    
    /**
     * POST method for creating an instance of resource
     * @param content representation for the resource
     */
    @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User ur) {
        service.processCreate(ur);
    }
   
    /**
     * DELETE method for deleting an instance of resource
     * @param name name of the resource
     */
    @DELETE
    @Path("/delete/{urname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("urname") String name) {
        String name2;
        try { 
            name2 = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); 
            return;
        }

        service.processDelete(name2);
    }
}
