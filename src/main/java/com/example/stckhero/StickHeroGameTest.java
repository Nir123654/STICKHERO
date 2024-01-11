package com.example.stckhero;
import javafx.stage.Stage;
import org.junit.*;

import static org.junit.Assert.*;
public class StickHeroGameTest {
    private static stick_hero_game game;
@Before
public void setUp() throws InterruptedException {


    game=HelloApplication.init_stick_hero;
    game.initialise_game(0);
}
    @Test
    public void Test1(){

    assertTrue(game.isStickGrowing());
}
@Test
    public void Test2(){
    boolean flag=true;
    for(int i=0;i<200;i++){
        PIllars pil =game.create_pillars();
        double xcoord=pil.getxCoordinate();
        if (xcoord<100){
            flag=false;
        }

    }
    assertTrue(flag);

}
@Test
    public void Test3(){
    assertFalse(game.isGameover());
}
@Test
public void Test4() {
    assertFalse(game.isWalkSoundPlaying());
    game.isWalkSoundPlaying();
}
@After
    public void clean_up(){
    game=null;
}




}
