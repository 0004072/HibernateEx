package com.hsenid.ORM;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by hsenid on 2/14/17.
 *
 */
public class Address implements Serializable{
    private String lineOne, lineTwo, cityOne, cityTwo;

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    public void setCityOne(String cityOne) {
        this.cityOne = cityOne;
    }

    public void setCityTwo(String cityTwo) {
        this.cityTwo = cityTwo;
    }

    public String getLineOne() {
        return lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public String getCityOne() {
        return cityOne;
    }

    public String getCityTwo() {
        return cityTwo;
    }

    public void setAddress(String lineOne, String lineTwo, String cityOne, String cityTwo){
        setLineOne(lineOne);
        setLineTwo(lineTwo);
        setCityOne(cityOne);
        setCityTwo(cityTwo);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

    }
}
