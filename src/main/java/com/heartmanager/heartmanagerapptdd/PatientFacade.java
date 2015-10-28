/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heartmanager.heartmanagerapptdd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author valentin
 */
public class PatientFacade implements PatientFacadeLocal {   
    
    public void validateAuthentication(String authenticationData) throws JeeApplicationException {
        
        if (StringUtils.isEmpty(authenticationData)) {
            throw new JeeApplicationException(Constant.AUTHENTICATION_IS_NOT_VALID);
        }
        
        if (authenticationData.length() < 5) {
            throw new JeeApplicationException(Constant.AUTHENTICATION_IS_NOT_VALID);
        }
    }
    
    public List<Patient> getAllPatients() {
        return createDummyPatients();
    }
    
    public static List<Patient> createDummyPatients() {
       
        List<Patient> patients = new ArrayList<>(5);
        
        for (int i = 1; i <= 5; i++) {
            
            String birthOfDate = "1990100" + i;
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            
            Date date = null;
            try {
                date = format.parse(birthOfDate);
            } catch (ParseException ex) {
                Logger.getLogger(PatientFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Patient patient = new Patient("12345" + i, "name" + i, date);
            
            if (i % 2 == 0) {
                patient.setSex(Sex.MEN);
            } else {
                patient.setSex(Sex.WOMEN);
            }
            
            Map<Integer, String> measurements = new HashMap<>();
            Random randomGenerator = new Random();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); 
            for (int j = 0; j < 20; j++) {
                int randomInt = randomGenerator.nextInt(30);
                measurements.put(50 + randomInt, dt.format(new Date()));
            }
            patient.setMeasurements(measurements);
            patients.add(patient);
        }
        return patients;
    }
    
}
