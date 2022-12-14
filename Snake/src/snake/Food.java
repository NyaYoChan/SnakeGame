package snake;

import javafx.scene.image.Image;

public class Food {
    int x;
    int y;
    Image image;
    int width;
    int height;
    
    Food(Snake snake){
        this.generateCoordinate();
        while(snake.isCollide(this.x, this.y)){
            this.generateCoordinate();
        }
        this.image = new Image(Setting.FOOD_IMAGES[(int)(Math.random() * Setting.FOOD_IMAGES.length)]);
        this.width = Setting.SQUARE_SIZE;
        this.height = Setting.SQUARE_SIZE;
    }

    public void draw(){
	Setting.GC.drawImage(this.image, this.x * this.width, this.y * this.height, this.width, this.height);
    }
    
    public void generateCoordinate(){
        this.x = (int)(Math.random() * Setting.ROWS);
        this.y = (int)(Math.random() * Setting.COLS);
    }
}
