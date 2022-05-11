import java.math.BigDecimal;

/**
 * Function similar to edge
 */
public class Room {
    private boolean myVisited;
    private boolean myNorth;
    private boolean mySouth;
    private boolean myWest;
    private boolean myEast;
    //other variables, Lava, Items,

    enum Direction{
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    private Direction direction;

    public void setDirectionNorth(boolean theNorth){
        myNorth = theNorth;
    }
    public void setDirectionWest(boolean theWest){
        myWest = theWest;
    }
    public void setDirectionEast(boolean theEast){
        myEast = theEast;
    }
    public void setDirectionSouth(boolean theSouth){
        mySouth = theSouth;
    }

    public boolean getDirectionNorth(){
        return myNorth;
    }
    public boolean getDirectionWest(){
        return myWest;
    }
    public boolean getDirectionEast(){
        return myEast;
    }
    public boolean getDirectionSouth(){
        return mySouth;
    }

    public Room() {
        myVisited = false;
    }

    public boolean Visited(){
        return myVisited;
    }

    public void setVisited(boolean theVisited){
        myVisited = theVisited;
    }
}