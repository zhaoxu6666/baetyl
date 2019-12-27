package fk;

enum Sensors{
    TEMPSENSOR(0),
    HUMSENSOR(1),
    VOLSENSOR(2),
    LIGSENSOR(3);
    private int id;
    Sensors(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}