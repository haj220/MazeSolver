package cs2114.mazesolver;
import student.TestCase;
/**
 * @author HJ
 * @version 2018.04.06
 */
public class MazeTest
    extends TestCase
{
    //Fields
    
    private Maze maze1;
    
    //Constructor
    /**
     * Constructor
     */
    public MazeTest() {
        //empty constructor
    }
    /**
     * set up the variables
     */
    public void setUp() {
        maze1 = new Maze(10);
    }
    
    /**
     * Test the setter and getter of the start location
     */
    public void testStartLocation() {
        assertEquals(maze1.getStartLocation().toString(), "(0, 0)");
        maze1.setStartLocation(new Location(3, 7));
        assertEquals(maze1.getStartLocation().toString(), "(3, 7)");
        maze1.setStartLocation(new Location(11, 9));
        assertEquals(maze1.getStartLocation().toString(), "(3, 7)");
        maze1.setCell(new Location(4, 3), MazeCell.WALL);
        maze1.setStartLocation(new Location(4, 3));
        assertEquals(maze1.getStartLocation().toString(), "(4, 3)");
        assertEquals(maze1.getCell(new Location(4, 3)), MazeCell.UNEXPLORED);
    }
    
    /**
     * Test the setter and getter of the goal location
     */
    public void testGoalLocation() {
        assertEquals(maze1.getGoalLocation().toString(), "(9, 9)");
        maze1.setGoalLocation(new Location(2, 4));
        assertEquals(maze1.getGoalLocation().toString(), "(2, 4)");
        maze1.setGoalLocation(new Location(9, 11));
        assertEquals(maze1.getGoalLocation().toString(), "(2, 4)");
        maze1.setCell(new Location(4, 3), MazeCell.WALL);
        maze1.setGoalLocation(new Location(4, 3));
        assertEquals(maze1.getGoalLocation().toString(), "(4, 3)");
        assertEquals(maze1.getCell(new Location(4, 3)), MazeCell.UNEXPLORED);
    }
    
    /**
     * Test the setCell method
     */
    public void testSetCell() {
        MazeCell a;
        maze1.setCell(new Location(99, 6), MazeCell.UNEXPLORED);
        assertEquals(maze1.getCell(new Location(99, 6)), MazeCell.INVALID_CELL);
        maze1.setCell(new Location(4, 3), MazeCell.INVALID_CELL);
        assertEquals(maze1.getCell(new Location(4, 3)), MazeCell.UNEXPLORED);
        maze1.setCell(new Location(3, 2), MazeCell.WALL);
        assertEquals(maze1.getCell(new Location(3, 2)), MazeCell.WALL);
        maze1.setCell(new Location(7, 8), MazeCell.FAILED_PATH);
        assertEquals(maze1.getCell(new Location(7, 8)), MazeCell.FAILED_PATH);
        maze1.setCell(new Location(0, 0), MazeCell.WALL);
        assertEquals(maze1.getCell(new Location(0, 0)), MazeCell.UNEXPLORED);
        maze1.setCell(new Location(0, 0), MazeCell.CURRENT_PATH);
        assertEquals(maze1.getCell(new Location(0, 0)), MazeCell.CURRENT_PATH);
        maze1.setCell(new Location(9, 9), MazeCell.WALL);
        assertEquals(maze1.getCell(new Location(9, 9)), MazeCell.UNEXPLORED);
        a = MazeCell.valueOf("UNEXPLORED");
        assertEquals(a, maze1.getCell(new Location(1, 0)));
    }
    
    /**
     * Test the solver
     */
    public void testSolve() {
        maze1 = new Maze(3);
        assertEquals(maze1.solve(), 
                "(0, 0)(0, 1)(0, 2)(1, 2)(2, 2)");
        maze1 = new Maze(3);
        maze1.setCell(new Location(2, 1), MazeCell.WALL);
        maze1.setCell(new Location(1, 2), MazeCell.WALL);
       
      
        assertEquals(maze1.solve(), 
                null);
        
        
    }
}
