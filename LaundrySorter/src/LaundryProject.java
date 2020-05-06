import objectdraw.*;
import java.awt.*;

public class LaundryProject extends WindowController {
	
	private FilledRect clothesborder;
	private FilledRect clothesinterior;
	private FramedRect whites;
	private FramedRect darks;
	private FramedRect colors;
	
	private final Location CB_START = new Location(180, 80);
	private final Location CI_START = new Location(185, 85);
	private final Location WHITE_START = new Location(70, 270);
	private final Location DARK_START = new Location(170, 270);
	private final Location COLORS_START = new Location(270, 270);
	
	private final Location CB_END = new Location(220, 120);
	private final Location CI_END = new Location(215, 115);
	private final Location WHITE_END = new Location(130, 330);
	private final Location DARK_END = new Location(230, 330);
	private final Location COLORS_END = new Location(330, 330);
	
	private Text whitetext;
	private Text darktext;
	private Text colortext;
	
	private Text correct;
	private Text incorrect;
	private int c;
	private int i;
	
	RandomIntGenerator Gen = new RandomIntGenerator(0, 255);
	
	private Color GetColor() {
		int r = Gen.nextValue();
		int g = Gen.nextValue();
		int b = Gen.nextValue();
		return new Color(r, g, b);
	}
	private int CIcolor;
	
	private boolean cbPressed = false;
	private Location priorPoint;
	
	public void begin() {
		
		clothesborder = new FilledRect(CB_START, CB_END, canvas);
		clothesborder.setColor(Color.BLACK);
		clothesinterior = new FilledRect(CI_START, CI_END, canvas);
		clothesinterior.setColor(GetColor());
		
		whites = new FramedRect(WHITE_START, WHITE_END, canvas);
		darks = new FramedRect(DARK_START, DARK_END, canvas);
		colors = new FramedRect(COLORS_START, COLORS_END, canvas);
		
		whitetext = new Text("Whites", WHITE_START.getX()+10, WHITE_START.getY()+10 , canvas);
		darktext = new Text("Darks", DARK_START.getX()+10, DARK_START.getY()+10 , canvas);
		colortext = new Text("Colors", COLORS_START.getX()+10, COLORS_START.getY()+10 , canvas);
		
		correct = new Text("Correct = " + c, 20, 20, canvas);
		incorrect = new Text("Inorrect = " + i, 20, 40, canvas);
	}
	public void onMousePress(Location point) {
		if(clothesborder.contains(point)) {
			cbPressed = true;
			priorPoint = point;
			
		} else {
			cbPressed = false;
		}
		
	}
	
	public void onMouseDrag(Location pointtwo) {
		double changex;
		double changey;
		if(cbPressed) {
			changex = pointtwo.getX() - priorPoint.getX();
			changey = pointtwo.getY() - priorPoint.getY();
			clothesborder.move(changex, changey);
			clothesinterior.move(changex, changey);
			priorPoint = pointtwo;
			
			
			
		}
	}
	
	public void onMouseRelease(Location end) {
		if(whites.contains(end) || darks.contains(end) || colors.contains(end)) {
			Color currentcolor = clothesinterior.getColor();
			int colorSum = currentcolor.getBlue() + currentcolor.getGreen() + currentcolor.getRed();
			if(whites.contains(end) && colorSum > 600) {
				c += 1;
				correct.setText("Correct = " + c);
			} else if(darks.contains(end) && colorSum <= 255) {
				c += 1;
				correct.setText("Correct = " + c);
			}else if(colors.contains(end) && (colorSum > 255 && colorSum <= 600)) {
				c += 1;
				correct.setText("Correct = " + c);
			}else {
				i += 1;
				incorrect.setText("Incorrect = " + i);
			}
			clothesinterior.setColor(GetColor());
		}
	
			clothesborder.moveTo(CB_START);
			clothesinterior.moveTo(CI_START);	
			
			
	
		}
		
		
	public static void main(String[] args) {
		new LaundryProject().startController(400, 400);
	}

}
