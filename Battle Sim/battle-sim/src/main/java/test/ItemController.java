package test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemController {
    private ObservableList<Attack> attacks = FXCollections.observableArrayList();

    public ObservableList<Attack> getAttacks()
    {
        return attacks;
    }

    public int getSize()
    {
        return attacks.size();
    }

    public Attack getAttack(int i)
    {
        return attacks.get(i);
    }

    public void addAttacks(String n, String t, String d)
    {
        Attack attack = new Attack(n, t, d);
        attacks.add(attack);
    }

    public Attack removeAttack(int i)
    {
        return attacks.remove(i);
    }
}
