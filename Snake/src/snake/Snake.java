package snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class Snake {
    Point snakeHead;
    List<Point> snakeBody = new ArrayList();
    int unit_width;
    int unit_height;
    String derection = new String();
    int score;
    
    Snake(){
        for(int i = 0; i < 3; i++){
            this.snakeBody.add(new Point(Setting.COLS / 2, Setting.ROWS / 2));
        }
        this.snakeHead = this.snakeBody.get(0);
        this.unit_width = Setting.SQUARE_SIZE;
        this.unit_height = Setting.SQUARE_SIZE;
        switch((int)(Math.random()*10)%4){
            case 0:
                this.derection = "RIGHT";
                break;
            case 1:
                this.derection = "LEFT";
                break;
            case 2:
                this.derection = "DOWN";
                break;
            case 3:
                this.derection = "UP";
                break;
        }
        this.score = 0;
    }
    
    public boolean isCollide(int x, int y){
        for(Point snake : this.snakeBody){
            if(x == snake.getX() && y == snake.getY()){
                return true;
            }
        }
        return false;
    }
    
    public void draw(){
        Setting.GC.setFill(Setting.SNAKE_HEAD_COLOR);
        Setting.GC.fillRoundRect(this.snakeHead.getX() * this.unit_width, this.snakeHead.getY() * this.unit_height, this.unit_width-1, this.unit_height-1, 35, 30);
        Setting.GC.setFill(Setting.SNAKE_BODY_COLOR);
        for(int i = 1; i < this.snakeBody.size(); i++){
            Setting.GC.fillRoundRect(this.snakeBody.get(i).getX() * this.unit_width, this.snakeBody.get(i).getY() * this.unit_height, this.unit_width-1, this.unit_height-1, 20, 10);
        }
        for(int i = this.snakeBody.size()-1; i-1 >= 0; i--){
            this.snakeBody.get(i).x = this.snakeBody.get(i-1).x;
            this.snakeBody.get(i).y = this.snakeBody.get(i-1).y;
        }
    }
    
    public void moveRight(){
        this.snakeHead.x++;
    }
    public void moveLeft(){
        this.snakeHead.x--;
    }
    public void moveDown(){
        this.snakeHead.y++;
    }
    public void moveUp(){
        this.snakeHead.y--;
    }
    
    public boolean isEatFood(Food food){
        if(this.isCollide(food.x, food.y)){
            this.score++;
            food.generateCoordinate();
            int curLength = this.snakeBody.size()-1;
            this.snakeBody.add(new Point((int)this.snakeBody.get(curLength).getX(), (int)this.snakeBody.get(curLength).getY()));
            Setting.curSpeedRate += Setting.SPEED_UP;
            return true;
        }
        return false;
    }
}
