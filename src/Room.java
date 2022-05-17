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

    //booleans for walls keep track of walls

    private boolean NorthWall;
    private boolean SouthWall;
    private boolean EastWall;
    private boolean WestWall;

    //other variables, Lava, Items,

    enum Direction{
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    public boolean isNorthWall() {
        return NorthWall;
    }

    public void setNorthWall(boolean northWall) {
        NorthWall = northWall;
    }

    public boolean isSouthWall() {
        return SouthWall;
    }

    public void setSouthWall(boolean southWall) {
        SouthWall = southWall;
    }

    public boolean isEastWall() {
        return EastWall;
    }

    public void setEastWall(boolean eastWall) {
        EastWall = eastWall;
    }

    public boolean isWestWall() {
        return WestWall;
    }

    public void setWestWall(boolean westWall) {
        WestWall = westWall;
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
        EastWall = true;
        WestWall = true;
        SouthWall = true;
        NorthWall = true;
        myVisited = false;
    }

    public boolean Visited(){
        return myVisited;
    }

    public void setVisited(boolean theVisited){
        myVisited = theVisited;
    }
}