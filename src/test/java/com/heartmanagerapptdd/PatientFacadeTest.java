/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heartmanagerapptdd;

import com.heartmanager.heartmanagerapptdd.Constant;
import com.heartmanager.heartmanagerapptdd.JeeApplicationException;
import com.heartmanager.heartmanagerapptdd.Patient;
import com.heartmanager.heartmanagerapptdd.PatientFacade;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author valentin
 */
public class PatientFacadeTest {
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    PatientFacade patientFacade;
    List<Patient> patients;
    
    public PatientFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        patientFacade = new PatientFacade();
        patients = PatientFacade.createDummyPatients();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void whenAuthenticationIsNullThenReturnWebApplicationException() throws JeeApplicationException {
        exception.expect(JeeApplicationException.class);
        exception.expectMessage(Constant.AUTHENTICATION_IS_NOT_VALID);
        patientFacade.validateAuthentication(null);
    }
    
    @Test
    public void whenAuthenticationLessThanFiveCharactersThenReturnWebApplicationException() throws JeeApplicationException {
        exception.expect(JeeApplicationException.class);
        exception.expectMessage(Constant.AUTHENTICATION_IS_NOT_VALID);
        patientFacade.validateAuthentication("1234");
    }

    @Test
    public void whenAuthenticationIsValid() throws JeeApplicationException {
        patientFacade.validateAuthentication("12345");
    }
    
    @Test
    public void whenGetAllPatientsThenReturnPatients() {
        Assert.assertTrue(CollectionUtils.isEqualCollection(patients, patientFacade.getAllPatients()));
    }
}
