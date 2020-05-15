import objectdraw.*;
import java.awt.*;

/*
 * DESCRIBE YOUR CLASS HERE
 * 
 * YOUR NAME / LAB SECTION
 * DATE
 * 
 */
public class MagnetGame extends WindowController {
	
	Magnet M1 = new Magnet(new Location(100,100), canvas);
	Magnet M2 = new Magnet(new Location(300,300), canvas);



    public void onMousePress(Location point) {
    	

    }

    public void onMouseDrag(Location point) {

    }

    public void onMouseClick(Location point) {

    }
    
    public static void main(String[] args) {
    	new MagnetGame().startController(500,500);
    }

}

