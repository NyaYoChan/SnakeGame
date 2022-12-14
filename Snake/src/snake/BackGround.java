package snake;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BackGround {
    public static void darwBackGround(){
        for(int r = 0; r  < Setting.ROWS; r++){
            for(int c = 0; c < Setting.COLS; c++){
                if((r + c) % 2 == 0){
                    Setting.GC.setFill(Setting.BG_COLOR_1);
                }else{
                    Setting.GC.setFill(Setting.BG_COLOR_2);
                }
                
                Setting.GC.fillRect(r * Setting.SQUARE_SIZE, c * Setting.SQUARE_SIZE, Setting.SQUARE_SIZE, Setting.SQUARE_SIZE);
            }
        }
    }
    
    public static void drawGameOver(){
        Setting.GC.setFill(Setting.GAMEOVER_FONT_COLOR);
        Setting.GC.setFont(new Font(Setting.FONT_STYLE, Setting.FONT_SIZE));
        Setting.GC.fillText("Game Over", Setting.WIDTH/3, Setting.HEIGHT/2.5);
        Setting.GC.setFont(new Font(Setting.FONT_STYLE, Setting.FONT_SIZE));
        Setting.GC.fillText("Press Space Back To Menu", Setting.WIDTH/8, Setting.HEIGHT/2+Setting.FONT_SIZE*2);
    }
    
    public static void drawScore(int score){
        Setting.GC.setFill(Setting.SCORE_FONT_COLOR);
        Setting.GC.setFont(new Font(Setting.FONT_STYLE, Setting.FONT_SIZE));
        Setting.GC.fillText("Score:" + Integer.toString(score), 0, Setting.FONT_SIZE);
    }
    
    public static void drawMenu(){
        Setting.GC.setFill(Setting.BG_COLOR_2);
        Setting.GC.fillRect(0, 0, Setting.WIDTH, Setting.HEIGHT);
        Setting.GC.setFill(Setting.TITLE_FONT_COLOR);
        Setting.GC.setFont(new Font(Setting.FONT_STYLE, Setting.TITLE_FONT_SIZE));
        Setting.GC.fillText("Snake", Setting.WIDTH/2-Setting.TITLE_FONT_SIZE*1.4, Setting.TITLE_FONT_SIZE*2, Setting.TITLE_FONT_SIZE*5);
        Setting.GC.setFill(Setting.TITLE_FONT_COLOR);
        Setting.GC.setFont(new Font(Setting.FONT_STYLE, Setting.FONT_SIZE));
        Setting.GC.fillText("Press Space to Start", Setting.WIDTH/2-Setting.FONT_SIZE*4.6, Setting.FONT_SIZE*10, Setting.FONT_SIZE*20);
    }
}
