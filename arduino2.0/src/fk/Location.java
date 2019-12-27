package fk;

import javax.swing.*;

public class Location {
    private String name;
    private String location;
    private String ip;
    private JTextField tempField;
    private JTextField humField;
    private JTextField volField;
    private JTextField ligField;

    public Location(String name, String location, String ip, JTextField tempField,
                    JTextField humField, JTextField volField, JTextField ligField) {
        this.name = name;
        this.location = location;
        this.ip = ip;
        this.tempField = tempField;
        this.humField = humField;
        this.volField = volField;
        this.ligField = ligField;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getIp() {
        return ip;
    }

    public JTextField getTempField() {
        return tempField;
    }

    public JTextField getHumField() {
        return humField;
    }

    public JTextField getVolField(){
        return volField;
    }

    public JTextField getLigField() {
        return ligField;
    }

    void setName(String name) {
        this.name = name;
    }

    void setLocation(String location) {
        this.location = location;
    }

    void setIp(String ip) {
        this.ip = ip;
    }

    void setTempField(JTextField tempField) {
        this.tempField = tempField;
    }

    void setHumField(JTextField humField) {
        this.humField = humField;
    }

    void setVolField(JTextField volField){
        this.volField = volField;
    }

    void setLigField(JTextField ligField){
        this.ligField = ligField;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", ip='" + ip + '\'' +
                ", tempField=" + tempField +
                ", humField=" + humField +
                ", volField=" + volField +
                ", ligField=" + ligField +
                '}';
    }
}
