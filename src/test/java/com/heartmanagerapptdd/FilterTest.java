/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heartmanagerapptdd;

import com.heartmanager.heartmanagerapptdd.Patient;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author gl0527
 */
public class FilterTest {

    private Patient dummyPatient;

    @Before
    public void setUp() {
        dummyPatient = new Patient("012-345-678", "Teszt Elek", new Date(1000000));
        SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Map<Integer, String> measurements = new HashMap<>();
        measurements.put(66, dt.format(new Date()));
        measurements.put(79, dt.format(new Date(99999999)));
        measurements.put(35, dt.format(new Date(11111111)));
        dummyPatient.setMeasurements(measurements);
    }

    @Test
    public void filterByYearTest() {
        Map<Integer, String> filteredMeasurements
                = dummyPatient.getMeasurementsByYear(2015); // februári eredmények csak
        for (String s : filteredMeasurements.values()) {
            String[] splittedData = s.split(" ");
            String[] splittedData2 = splittedData[0].split("\\.");
            String year = splittedData2[0];
            Assert.assertEquals("2015", year);
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void filterByYearTestWithWrongInput1() {
        dummyPatient.getMeasurementsByYear(1800);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void filterByYearTestWithWrongInput2() {
        dummyPatient.getMeasurementsByYear(2020);
    }

    @Test
    public void filterByMonthTest() {
        Map<Integer, String> filteredMeasurements
                = dummyPatient.getMeasurementsByMonth(12); // februári eredmények csak
        for (String s : filteredMeasurements.values()) {
            String[] splittedData = s.split(" ");
            String[] splittedData2 = splittedData[0].split("\\.");
            String month = splittedData2[1];
            Assert.assertEquals("12", month);
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void filterByMonthTestWithWrongInput1() {
        dummyPatient.getMeasurementsByMonth(13);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void filterByMonthTestWithWrongInput2() {
        Map<Integer, String> filteredMeasurements
                = dummyPatient.getMeasurementsByMonth(0);
    }

    @Test
    public void filterByDayTest() {
        Map<Integer, String> filteredMeasurements
                = dummyPatient.getMeasurementsByDay(1); // februári eredmények csak
        for (String s : filteredMeasurements.values()) {
            String[] splittedData = s.split(" ");
            String[] splittedData2 = splittedData[0].split("\\.");
            String day = splittedData2[2];
            Assert.assertEquals("1", day);
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void filterByDayTestWithWrongInput1() {
        dummyPatient.getMeasurementsByDay(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void filterByDayTestWithWrongInput2() {
        dummyPatient.getMeasurementsByDay(35);
    }
}
