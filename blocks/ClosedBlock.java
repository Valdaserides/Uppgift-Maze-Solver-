package blocks;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ClosedBlock extends Block{

	public ClosedBlock() {
		Rectangle r = new Rectangle(Block.SIZE, Block.SIZE);
		r.setFill(Color.BLACK);
		r.setStroke(Color.GREEN);
		this.getChildren().add(r);
	}
	
}
