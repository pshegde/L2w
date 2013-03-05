package com.example.services;

import java.util.List;

import com.example.models.Time;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/time")
@Produces(MediaType.APPLICATION_JSON)
public class TimeService {
	
	TimeDAO dao = new TimeDAO();
	
    @GET
    public List<Time> get() {
        return new TimeDAO().findAll();
    }

}

