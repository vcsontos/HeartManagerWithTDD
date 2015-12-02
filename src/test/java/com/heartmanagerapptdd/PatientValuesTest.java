/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heartmanagerapptdd;

import com.heartmanager.heartmanagerapptdd.Patient;
import com.heartmanager.heartmanagerapptdd.PatientFacade;
import java.util.List;
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
public class PatientValuesTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    PatientFacade patientFacade;
    List<Patient> patients;
    Patient patient;
    boolean patientHasAbnormalValues;
    boolean patientHasNormalValues;

    public PatientValuesTest() {
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
        patients = PatientFacade.createDummyPatients(true);
        patient = PatientFacade.getPatientFromList(patients, 2);
        int referenceValue1 = 40;
        int referenceValue2 = 100;
        patientHasAbnormalValues = patientFacade.showIfPatientHasNormalValues(patient, referenceValue1);
        patientHasNormalValues = patientFacade.showIfPatientHasNormalValues(patient, referenceValue2);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void whenPatientDataIsAbnormal() {
        Assert.assertFalse(patientHasAbnormalValues);
    }

    @Test
    public void whenPatientDataIsNormal() {
        Assert.assertTrue(patientHasNormalValues);
    }
}
