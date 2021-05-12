package ntnu.idatx2001.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostTownTest {


    @DisplayName("Test that a Post town will be added with the correct parameters")
    @Test
    public void testIfPostTownIsAddedCorrectly(){
        PostTown postTown = new PostTown("9602", "Hammerfest", "Hammerfest");
        assertEquals("9602", postTown.getPostalCode());
        assertEquals("Hammerfest", postTown.getCity());
        assertEquals("Hammerfest", postTown.getMunicipality());
    }

    @DisplayName("Test if a post Town cannot be added with a blank postal code")
    @Test
   public void testThatPostTownCannotBeAddedWithWrongPostalCode(){
        PostTown postTown = new PostTown("9602", "Hammerfest", "Hammerfest");
        try{
            postTown.setPostalCode("");
            fail();
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }
   }

}