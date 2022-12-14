package snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Setting {
    // game controll
    protected static boolean STARTED = false;
    protected static boolean GAMEOVER = false;
    
    // background
    protected static Canvas CANVAS;
    protected static GraphicsContext GC;
    protected static int WIDTH = 630;
    protected static int HEIGHT = WIDTH;
    protected static int ROWS = 21;
    protected static int COLS = ROWS;
    protected static int SQUARE_SIZE = WIDTH / ROWS;
    protected static Color BG_COLOR_1 = Color.web("bababa");
    protected static Color BG_COLOR_2 = Color.web("858585");
    
    // font
    protected static String FONT_STYLE = "Digital-7";
    protected static int FONT_SIZE = 40;
    protected static int TITLE_FONT_SIZE = 100;
    protected static Color GAMEOVER_FONT_COLOR = Color.web("ee1911");
    protected static Color SCORE_FONT_COLOR = Color.web("000000");
    protected static Color TITLE_FONT_COLOR = Color.web("000000");
    
    // snake
    protected static Color SNAKE_HEAD_COLOR = Color.web("1af44f");
    protected static Color SNAKE_BODY_COLOR = Color.web("00c22f");
    protected static int curSpeed = 200;
    protected static double curSpeedRate = 1.0;
    protected static double SPEED_UP = 0.06;
    
    // food
    protected static String[] FOOD_IMAGES = new String[]{"/images/golden_apple.png",
                                                                "/images/enchanted_golden_apple.png"};
}
