package snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public Snake snake;
    public Food food;
    public Timeline timeline;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Snake");
        buildMenuScene(primaryStage);
    }
    
    protected void buildMenuScene(Stage primaryStage){
        Group root = new Group();
        Setting.CANVAS = new Canvas(Setting.WIDTH, Setting.HEIGHT);
        root.getChildren().add(Setting.CANVAS);

        Setting.GC = Setting.CANVAS.getGraphicsContext2D();
        BackGround.drawMenu();
        
        Scene menu_scene = new Scene(root, Setting.WIDTH, Setting.HEIGHT);
        
        menu_scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                KeyCode code = event.getCode();
                if(code == KeyCode.SPACE){
                    switchScene(primaryStage);
                }
            }
        });
        
        primaryStage.setScene(menu_scene);
        primaryStage.show();
    }
    
    private void switchScene(Stage primaryStage){
        Group root = new Group();

        Setting.CANVAS = new Canvas(Setting.WIDTH, Setting.HEIGHT);
        root.getChildren().add(Setting.CANVAS);

        Setting.GC = Setting.CANVAS.getGraphicsContext2D();

        Scene scene = new Scene(root, Setting.WIDTH, Setting.HEIGHT);

        snake = new Snake();
        food = new Food(snake);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                if(Setting.STARTED == false){
                    Setting.STARTED = true;
                }
                KeyCode code = event.getCode();
                if(code == KeyCode.RIGHT || code == KeyCode.D){
                    if(!snake.derection.equalsIgnoreCase("LEFT")){
                        snake.derection = "RIGHT";
                    }
                }
                if(code == KeyCode.LEFT || code == KeyCode.A){
                    if(!snake.derection.equalsIgnoreCase("RIGHT")){
                        snake.derection = "LEFT";
                    }
                }
                if(code == KeyCode.DOWN || code == KeyCode.S){
                    if(!snake.derection.equalsIgnoreCase("UP")){
                        snake.derection = "DOWN";
                    }
                }
                if(code == KeyCode.UP || code == KeyCode.W){
                    if(!snake.derection.equalsIgnoreCase("DOWN")){
                        snake.derection = "UP";
                    }
                }
            }
        });

        primaryStage.setScene(scene);

        timeline = new Timeline(new KeyFrame(Duration.millis(Setting.curSpeed), e -> run(primaryStage, scene)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    private void run(Stage primaryStage, Scene scene){
        if(Setting.GAMEOVER){
            BackGround.drawGameOver();
            timeline.stop();
            scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent event){
                    KeyCode code = event.getCode();
                    if(code == KeyCode.SPACE){
                        Setting.GAMEOVER = false;
                        buildMenuScene(primaryStage);
                    }
                }
            });
            return;
        }
        
        BackGround.darwBackGround();
        food.draw();
        snake.draw();
        BackGround.drawScore(snake.score);
        
        switch(snake.derection){
            case "RIGHT":
                snake.moveRight();
                break;
            case "LEFT":
                snake.moveLeft();
                break;
            case "DOWN":
                snake.moveDown();
                break;
            case "UP":
                snake.moveUp();
                break;
        }
        
        isGameOver();
        
        if(snake.isEatFood(food)){
            timeline.setRate(Setting.curSpeedRate);
        }
    }
    
    public void isGameOver(){
        if(snake.snakeHead.x < 0 ||
           snake.snakeHead.y < 0 ||
           snake.snakeHead.x * Setting.SQUARE_SIZE >= Setting.WIDTH ||
           snake.snakeHead.y * Setting.SQUARE_SIZE >= Setting.HEIGHT){
            Setting.GAMEOVER = true;
        }
        if(Setting.STARTED){
            
            // someProblem
            for(int i = 1; i < snake.snakeBody.size(); i++){
                if(snake.snakeHead.x == snake.snakeBody.get(i).x && snake.snakeHead.y == snake.snakeBody.get(i).y){
                    Setting.GAMEOVER = true;
                    break;
                }
            }
        }
    }
    
}