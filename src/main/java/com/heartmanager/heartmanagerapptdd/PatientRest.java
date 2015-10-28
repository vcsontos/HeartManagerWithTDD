/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heartmanager.heartmanagerapptdd;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author valentin
 */

@Stateless
@Path("")
public class PatientRest {
    
    PatientFacade patientFacade = new PatientFacade();
    
    @POST
    @Path("getAllPatient")
    @Produces({"application/json"})
    public Response getAllPatientData(@FormParam("authentication") String authentication) {
        
        try {
            patientFacade.validateAuthentication(authentication);
            List<Patient> patients = patientFacade.getAllPatients();
        } catch (JeeApplicationException ex) {
            Logger.getLogger(PatientRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
