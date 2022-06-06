package Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player implements Serializable {
    private int myHealth;

    public Player(int theHealth) {
        myHealth = theHealth;
    }

    public int getMyHealth() {
        return myHealth;
    }

    public void setMyHealth(int myHealth) {
        this.myHealth = myHealth;
    }

    public void decreaseHealth(){
        myHealth -=1;
    }

    public boolean alive(){
        return myHealth != 0;
    }

    public void savePlayer(ObjectOutputStream theOut) throws IOException {
        theOut.writeObject(myHealth);
    }

    public void loadPlayer(ObjectInputStream theIn) throws IOException, ClassNotFoundException {
        myHealth = (int) theIn.readObject();
    }
}
