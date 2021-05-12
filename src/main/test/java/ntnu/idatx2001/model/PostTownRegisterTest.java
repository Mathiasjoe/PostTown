package ntnu.idatx2001.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostTownRegisterTest {

    PostTownRegister postTowns = new PostTownRegister();

    @DisplayName("Test if post town is added correctly to the register")
    @Test
    public void testIfPostTownIsAddedToRegister(){
        PostTown postTown = new PostTown("9602", "Hammerfest", "Hammerfest");
        this.postTowns.addNewPostTown(postTown);
        assertEquals(1, this.postTowns.getTowns().size());
    }

    @DisplayName("Test if Post Town is removed from the register")
    @Test
    public void testIfPostTownIsRemovedFromRegister(){
        PostTown postTown1 = new PostTown("9602", "Hammerfest", "Hammerfest");
        PostTown postTown2 = new PostTown("9690", "Havøysund", "Måsøy");
        this.postTowns.addNewPostTown(postTown1);
        this.postTowns.addNewPostTown(postTown2);
        this.postTowns.removePostTown(postTown1);
        assertEquals(1, this.postTowns.getTowns().size());
    }

    @DisplayName("Test if Post Town is removed from the register if the post town isn't in the register")
    @Test
    public void testIfPostTownIsRemovedWhenNotInRegister(){
        PostTown postTown1 = new PostTown("9602", "Hammerfest", "Hammerfest");
        PostTown postTown2 = new PostTown("9690", "Havøysund", "Måsøy");
        this.postTowns.addNewPostTown(postTown2);
        try{
            this.postTowns.removePostTown(postTown1);
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }

}
