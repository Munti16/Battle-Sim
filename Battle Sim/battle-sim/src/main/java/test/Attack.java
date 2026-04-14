package test;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Attack {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty type = new SimpleStringProperty();
    private StringProperty damage = new SimpleStringProperty();

    public Attack(String n, String t, String d){
        setName(n);
        setType(t);
        setDamage(d);
    }

    public Attack(){
        setName(null);
        setType(null);
        setDamage(null);
    }

    public StringProperty typeProperty() { return type; }

    public String getType() { return typeProperty().get(); }
    public void setType(String t) { typeProperty().set(t); }

    public StringProperty nameProperty() { return name; }

    public String getName() { return nameProperty().get(); }
    public void setName(String n) { nameProperty().set(n); }

    public StringProperty damageProperty() { return damage; }

    public String getDamage() { return damageProperty().get(); }
    public void setDamage(String d) { damageProperty().set(d); }
}
