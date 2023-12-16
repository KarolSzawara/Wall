package szawara.karol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {
    Wall testWall;
    @BeforeEach
    void setUp(){
        SampleBlock block1 = new SampleBlock("Red", "Wood");
        SampleBlock block2 = new SampleBlock("Blue", "Stone");
        SampleBlock block3 = new SampleBlock("Green", "Wood");

        SampleBlock block4 = new SampleBlock("Yellow", "Stone");
        SampleBlock block5 = new SampleBlock("Red", "Metal");

        SampleCompositeBlock compositeBlock1 = new SampleCompositeBlock(
            new SampleBlock("Black", "Wood"),
            Arrays.asList(new SampleBlock("White", "Stone"))
            );

        SampleCompositeBlock compositeBlock2 = new SampleCompositeBlock(
            new SampleBlock("Gray", "Metal"),
                Arrays.asList(
                    new SampleBlock("Brown", "OakWood"),
                    new SampleBlock("Pink", "Stone")
                )
        );
        testWall=new Wall(Arrays.asList(block1, block2, block3, block4, block5, compositeBlock1, compositeBlock2));
    }
    @Test
    void findBlockByColor() {
        assertEquals(testWall.findBlocksByMaterial("OakWood").get(0).getColor(),"Brown");
    }

    @Test
    void findBlocksByMaterial() {
        assertEquals(testWall.findBlockByColor("Pink").get().getMaterial(),"Stone");
    }

    @Test
    void count() {
        assertEquals(testWall.count(),10);
    }
}