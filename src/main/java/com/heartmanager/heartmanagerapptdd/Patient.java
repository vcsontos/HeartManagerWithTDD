/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heartmanager.heartmanagerapptdd;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author valentin
 */
public class Patient {

    private String taj;
    private String name;
    private Date dateOfBirth;
    private Sex sex;
    private Map<Integer, String> measurements;
    
    public Patient(String taj) {
        this.taj = taj;
    }

    public Patient(String taj, String name, Date dateOfBirth) {
        this.taj = taj;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Map<Integer, String> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<Integer, String> measurements) {
        this.measurements = measurements;
    }

    public Map<Integer, String> getMeasurementsByYear(Integer y)
            throws ArrayIndexOutOfBoundsException {

        if (y < 1900 || y > 2015) {
            throw new ArrayIndexOutOfBoundsException("Wrong year given!");
        }

        Map<Integer, String> filteredMeasurements = new HashMap<>();

        for (Integer i : measurements.keySet()) {
            String[] splittedData = measurements.get(i).split(" ");
            String date = splittedData[0];
            String[] splittedData2 = date.split("\\.", 3);
            String year = splittedData2[0];

            if (y.toString().equals(year)) {
                filteredMeasurements.put(i, measurements.get(i));
            }
        }

        return filteredMeasurements;
    }

    public Map<Integer, String> getMeasurementsByMonth(Integer m)
            throws ArrayIndexOutOfBoundsException {

        if (m < 1 || m > 12) {
            throw new ArrayIndexOutOfBoundsException("Wrong month given!");
        }

        Map<Integer, String> filteredMeasurements = new HashMap<>();

        for (Integer i : measurements.keySet()) {
            String[] splittedData = measurements.get(i).split(" ");
            String date = splittedData[0];
            String[] splittedData2 = date.split("\\.", 3);
            String month = splittedData2[1];

            if (m.toString().equals(month)) {
                filteredMeasurements.put(i, measurements.get(i));
            }
        }

        return filteredMeasurements;
    }

    public Map<Integer, String> getMeasurementsByDay(Integer d)
            throws ArrayIndexOutOfBoundsException {

        if (d < 1 || d > 31) {
            throw new ArrayIndexOutOfBoundsException("Wrong day given!");
        }

        Map<Integer, String> filteredMeasurements = new HashMap<>();

        for (Integer i : measurements.keySet()) {
            String[] splittedData = measurements.get(i).split(" ");
            String date = splittedData[0];
            String[] splittedData2 = date.split("\\.", 3);
            String day = splittedData2[2];

            if (d.toString().equals(day)) {
                filteredMeasurements.put(i, measurements.get(i));
            }
        }

        return filteredMeasurements;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.taj);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 79 * hash + Objects.hashCode(this.sex);
        hash = 79 * hash + Objects.hashCode(this.measurements);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.taj, other.taj)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        if (!Objects.equals(this.measurements, other.measurements)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "taj=" + taj + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", measurements=" + measurements + '}';
    }

}
