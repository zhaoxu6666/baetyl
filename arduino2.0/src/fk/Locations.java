package fk;

enum Locations {
    LOCATION1("1","/192.168.0.111","location1"),
    LOCATION2("2","/192.168.0.110","location2"),
    LOCATION3("3","/192.168.0.112","location3"),
    LOCATION4("4","/192.168.0.104","location4"),
    LOCATION5("5","/192.168.0.113","location5");
    private String name;
    private String ip;
    private String location;

    Locations(String name, String ip, String location) {
        this.name = name;
        this.ip = ip;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public String getLocation() {
        return location;
    }
}
