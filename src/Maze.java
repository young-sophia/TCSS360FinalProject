public class Maze {
    private final Room[][] myMaze;
    private final int myRows;
    private final int myColumns;
    private char[][] myArrayMaze;

    public Maze(final int theRows, final int theColumns){
        myRows = theRows;
        myColumns = theColumns;
        myMaze = new Room[theRows][theColumns];
        setBlankMaze(theRows, theColumns);
    }

    public static void main(String[] args){
        Maze maze = new Maze(3,3);

//        int[] arr = {0,-1,2,-1};
//        arr = maze.checkNeighbors(0,0);
//        maze.testConverArray(arr);
        maze.GenerateMaze();
        maze.convertMazeToLarger();
        System.out.println();
//        System.out.println(maze.chooseDirection(0,0) + " >>>");
        maze.display();


    }
    private void setBlankMaze(int theRows, int theColumns){
        for(int i = 0; i < theRows; i++){
            for(int j = 0; j < theColumns; j++){
                Room room = new Room();
                myMaze[i][j] = room;
            }
        }
    }


    public int[] checkNeighbors(int x, int y){
        int[] arr = new int[4];
        int counter = 0;
        //N
        if ((x - 1 >= 0 && x - 1 < myRows) && myMaze[x - 1][y].Visited() != true) {
            myMaze[x][y].setDirectionNorth(true);
            arr[0] = counter;
        }
        else{
            arr[0] = -1;
        }
        counter++;
        //W
        if ((y - 1 >= 0 && y - 1 < myColumns) && myMaze[x][y - 1].Visited() != true) {
            myMaze[x][y].setDirectionWest(true);
            arr[1] = counter;
        }
        else{
            arr[1] = -1;
        }
        counter++;
        //S
        if ((x + 1 >= 0 && x + 1 < myRows) && (myMaze[x + 1][y].Visited() != true)) {
            myMaze[x ][y].setDirectionSouth(true);
            arr[2] = counter;
        }
        else{
            arr[2] = -1;
        }
        counter++;
        //E
        if ((y + 1 >= 0 && y + 1 < myColumns) && (myMaze[x][y + 1].Visited() != true)) {
            myMaze[x][y].setDirectionEast(true);
            arr[3] = counter;
        }
        else{
            arr[3] = -1;
        }

        return arr;
        //return array [0,-1,2,-1] containing directions valid.
    }



    public int convertArray(int[] arr){
        int spot = 0;
        int direction = -1;
        int[] arr2 = new int[4];
        int counter = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                counter++;
                arr2[spot] = arr[i];
                spot++;
            }
            //arr2 = 0,2
        }
        //2
        int rand = (int) (Math.random()*counter);// 0 to 1.
        if(rand == 0){
            direction = arr2[0];
        }
        else if(rand == 1){
            direction = arr2[1];
        }
        else if(rand == 2){
            direction = arr2[2];
        }
        else{
            direction = arr2[3];
        }

        return direction;
    }

    //This method picks random direction and checks if it is valid. If direction is valid return that int val, else
    // return -1 saying all neighbors visited.
    public int chooseDirection(int x, int y, int[] arr){
        //get array and convert to the valid number directions
        //method if [T,F,T,F] == [0,-1,2,-1]
        //0 2, if( math.random 0 to 1)  0 2 3 == 0 1 2, if(math.random 0 to 2, if = 0 then 0, if 1 then 2, if 2 then 3
        int direction =convertArray(arr);// 2, but can only go N. [N,W,S,E] = [T,F,F,F]
        int result = -1;
        if(!myMaze[x][y].getDirectionEast() && !myMaze[x][y].getDirectionWest() && !myMaze[x][y].getDirectionSouth() && !myMaze[x][y].getDirectionNorth()){
            return -1;
        }
        if(direction == 0 ){
            if(myMaze[x][y].getDirectionNorth()){
                result = 0;
            }
            else{
                //1 to 3
                System.out.println("ERROR!!!!!!!!!!!!!!!!");
                direction = (int) (Math.random()*3)+1; //1 2 3
            }
        }
        if(direction == 1){
            if(myMaze[x][y].getDirectionWest()){
                result = 1;
            }
            else{
                System.out.println("ERROR!!!!!!!!!!!!!!!!");

                direction = (int) (Math.random()*2)+2; //2 3
            }
        }
        if(direction == 2){
            if(myMaze[x][y].getDirectionSouth()){
                result = 2;
            }
            else{
                System.out.println("ERROR!!!!!!!!!!!!!!!!");

                direction = 3;
            }
        }
        if(direction == 3){
            if(myMaze[x][y].getDirectionEast()){
                result = 3;
            }
            else{
                System.out.println("ERROR!!!!!!!!!!!!!!!!");

            }
        }



        return result;
    }
    public void GenerateMaze(){
        int rand = (int) (Math.random()*myRows);
        int rand2 = (int) (Math.random()*myColumns);

        int direction = (int) (Math.random() * 3);
        myMaze[0][0].setVisited(true);

        create(0,0);
    }

    public void create(int x, int y){
        //check neighbors
        int[] arr = checkNeighbors(x,y);
        int direction  = chooseDirection(x,y,arr);

        if(direction == 0){
            myMaze[x - 1][y].setVisited(true);
            myMaze[x][y].setNorthWall(false);
            myMaze[x-1][y].setSouthWall(false);

            create(x - 1, y);

        }
        else if(direction == 1){
            myMaze[x][y-1].setVisited(true);
            myMaze[x][y].setWestWall(false);
            myMaze[x][y-1].setEastWall(false);

            create(x, y-1);

        }
        else if(direction == 2){
            myMaze[x+1][y].setVisited(true);
            myMaze[x][y].setSouthWall(false);
            myMaze[x+1][y].setNorthWall(false);

            create(x+1,y);

        }
        else if(direction == 3){
            myMaze[x][y+1].setVisited(true);
            myMaze[x][y].setEastWall(false);
            myMaze[x][y+1].setWestWall(false);

            create(x,y+1);

        }
        arr = checkNeighbors(x,y);
        boolean flag = false;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] >-1){
                flag = true;
                break;
            }
        }
        if(flag == true){
            create(x,y);
        }
//        //N
//            if ((x - 1 >= 0 && x - 1 < myRows) && myMaze[x - 1][y].Visited() != true) {
//                myMaze[x - 1][y].setVisited(true);
//                create(x - 1, y);
//            }
//        //W
//            if ((y - 1 >= 0 && y - 1 < myColumns) && myMaze[x][y - 1].Visited() != true) {
//                myMaze[x][y - 1].setVisited(true);
//                create(x, y - 1);
//            }
//            //S
//            if ((x + 1 >= 0 && x + 1 < myRows) && (myMaze[x + 1][y].Visited() != true)) {
//                myMaze[x + 1][y].setVisited(true);
//                create(x + 1, y);
//            }
//            //E
//            if ((y + 1 >= 0 && y + 1 < myColumns) && (myMaze[x][y + 1].Visited() != true)) {
//                myMaze[x][y + 1].setVisited(true);
//                create(x, y + 1);
//            }
    }


    public void display(){
        for (int i = 0 ; i < myRows; i++){
            for (int j = 0; j < myColumns; j++){
                System.out.println(">>" +myMaze[i][j].Visited() + " :" + i + " " + j );
            }
        }
    }

    public void convertMazeToLarger(){
        myArrayMaze = new char[myRows*3 -( myRows-1)][myColumns*3 -(myColumns-1)];
        for(int i = 0; i < myColumns; i++){
            myArrayMaze[0][myColumns-1] = 'W';
        }
        for(int i = 0; i < myArrayMaze.length;i++){
            //left column
            myArrayMaze[i][0] = 'W';
            //bottom row
            myArrayMaze[myArrayMaze.length-1][i] = 'W';
            //top row
            myArrayMaze[0][i] = 'W';
            //right column
            myArrayMaze[i][myArrayMaze.length-1] = 'W';
        }
        //
        //
        int row = 0;
        int col = 0;
        for (int i = 1; row < myRows; i+=2) {
            for (int j = 1; col < myColumns; j += 2) {
                //9 spots should be used for a room
                //top North
                myArrayMaze[i][j] = 'R';
                if (myMaze[row][col].isNorthWall()) {
                    myArrayMaze[i - 1][j] = 'W';
                } else {
                    myArrayMaze[i - 1][j] = 'D';
                }
                if (myMaze[row][col].isWestWall()) {
                    myArrayMaze[i][j - 1] = 'W';
                } else {
                    myArrayMaze[i][j - 1] = 'D';
                }
                if (myMaze[row][col].isEastWall()) {
                    myArrayMaze[i][j + 1] = 'W';
                } else {
                    myArrayMaze[i][j + 1] = 'D';
                }
                if (myMaze[row][col].isSouthWall()) {
                    myArrayMaze[i + 1][j] = 'W';
                } else {
                    myArrayMaze[i + 1][j] = 'D';

                }
                col++;
            }
            col = 0;
            row++;

        }

        for(int i = 0; i < myArrayMaze.length; i++){
            for(int j = 0; j < myArrayMaze[i].length; j++){
                System.out.print(myArrayMaze[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*
    first pass in the spawn spot.
    method(int x, int y){
        if statements
        * if above spot is valid,then move up x-1.make visted true for spot, and recursive call the method with method(x-1, y);
        * if other statements
        ;
    }
     */

}