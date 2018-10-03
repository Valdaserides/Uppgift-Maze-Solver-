package map;

import blocks.Block;
import blocks.ClosedBlock;
import blocks.GoalBlock;
import blocks.OpenBlock;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MapSolver extends Group{

	static int steps = 0;
	Map map;
	static boolean solved = false;
	
	
	public MapSolver(Map map) {
		
		this.map = map;
		int x = map.getStartX();
		int y = map.getStartY();
		
		solve(x, y, 1);
		solve(x, y, 2);
		solve(x, y, 3);
		solve(x, y, 4);
		
	}
	
	public void solve(int x, int y, int dir) {

		if(dir == 1) {
			y++;
		}
		if(dir == 2) {
			x++;
		}
		if(dir == 3) {
			x--;
		}
		if(dir == 4) {
			y--;
		}
		
		Block b = map.getBlock(x, y);
		
		if(solved) {
			return;
		}
		
		if(b instanceof OpenBlock) {

			steps++;
			
		}

		if(b instanceof ClosedBlock || b == null) {
			
			return;
			
		}
		
		if(b instanceof GoalBlock) {
			
			solved = true;
			System.out.println(steps);
			return;
			
		}

		if(dir == 1) { // upp
			solve(x,y,3);
			solve(x,y,2);
			solve(x,y,1);
		}
		if(dir == 2) { // höger
			solve(x,y,2);
			solve(x,y,1);
			solve(x,y,4);
		}
		if(dir == 3) {
			solve(x,y,3);
			solve(x,y,1);
			solve(x,y,4);
			
		}
		if(dir == 4) {
			solve(x,y,4);
			solve(x,y,3);
			solve(x,y,2);
		}
		
	}
	
}
