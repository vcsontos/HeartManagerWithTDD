/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heartmanager.heartmanagerapptdd;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author valentin
 */
@Local
public interface PatientFacadeLocal {
    
    List<Patient> getAllPatients();
}
