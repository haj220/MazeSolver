package cs2114.mazesolver;
import java.util.Stack;
/**
 * @author HJ
 * @version 2018.04.06
 */
public class Maze implements IMaze {
    
    //Fields
    private MazeCell[][] game;
    private int size;
    private ILocation star;
    private ILocation fin;
    
    //Constructor
    
    /**
     * @param size the size of the mazeArr
     * Constructor
     */    
    
    public Maze(int size) {
        this.size = size;
        game = new MazeCell[size][size];
        for (int h = 0; h < size; h++) {
            for (int w = 0; w < size; w++) {
                game[h][w] = MazeCell.UNEXPLORED;
            }
        }
        this.star = new Location(0, 0);
        this.fin = new Location(size - 1, size - 1);
    }
    
    @Override
    public int size() {
        return size;
    }
    @Override
    public ILocation getStartLocation() {
        return star;
    }
    @Override
    public void setStartLocation(ILocation location) {
        if (getCell(location) != MazeCell.INVALID_CELL) {
            if (getCell(location) == MazeCell.WALL) {
                game[location.x()][location.y()] = MazeCell.UNEXPLORED;
            }
            star = location;
        }
    }
    @Override
    public ILocation getGoalLocation() {
        return fin;
    }
    @Override
    public void setGoalLocation(ILocation location) {
        if (getCell(location) != MazeCell.INVALID_CELL) {
            if (getCell(location) == MazeCell.WALL) {
                game[location.x()][location.y()] = MazeCell.UNEXPLORED;
            }
            fin = location;
        }
    }
    @Override
    public MazeCell getCell(ILocation location) {
        if (location.x() < size() 
                && location.y() < size()
                && location.x() >= 0
                && location.y() >= 0) {
            return game[location.x()][location.y()];
        }
        return MazeCell.INVALID_CELL;
    }
    @Override
    public void setCell(ILocation location, MazeCell cell) {
        if (cell == MazeCell.INVALID_CELL) {
            return;
        }
        if (getCell(location) != MazeCell.INVALID_CELL)
        { 
            if (cell == MazeCell.WALL
                    && (location.equals(star)
                    || location.equals(fin))) {
                return;
            }
            else {
                game[location.x()][location.y()] = cell;
            }
        }
    }
    
    /**
     
     * @param s the stack
     * @return the String
     */
    public String toString(Stack<ILocation> s) {
        Stack<ILocation> temp = new Stack<ILocation>();
        while (!s.isEmpty()) {
            temp.push(s.pop());
        }
        String result = "";
        while (!temp.isEmpty()) {
            result = result + temp.pop().toString();
        }
        return result;
    }
    
    @Override
    public String solve() {
        Stack<ILocation> solu = new Stack<ILocation>();
        solu.push(getStartLocation());
        while (!solu.empty()) {
            setCell(solu.peek(), MazeCell.CURRENT_PATH);
            if (solu.peek().equals(getGoalLocation())) {
                return toString(solu);
            }
            else if (getCell(solu.peek().south()) == MazeCell.UNEXPLORED) {
                solu.push(solu.peek().south());
            }
            else if (getCell(solu.peek().east()) == MazeCell.UNEXPLORED) {
                solu.push(solu.peek().east());
            }
            else if (getCell(solu.peek().west()) == MazeCell.UNEXPLORED) {
                solu.push(solu.peek().west());
            }
            else if (getCell(solu.peek().north()) == MazeCell.UNEXPLORED) {
                solu.push(solu.peek().north());
            }
            else {
                setCell(solu.peek(), MazeCell.FAILED_PATH);
                solu.pop();
            }
        }
        return null;
    }
}