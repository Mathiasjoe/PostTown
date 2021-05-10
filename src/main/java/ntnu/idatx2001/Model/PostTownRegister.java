package ntnu.idatx2001.Model;

import java.util.ArrayList;

/**
 * The type Post town register.
 */
public class PostTownRegister {

    private ArrayList<PostTown> towns;

    /**
     * Instantiates a new Post town register.
     */
    public PostTownRegister(){
        this.towns = new ArrayList<>();
    }

    /**
     * Add new town to the register.
     *
     * @param town the town
     */
    public void addNewPostTown(PostTown town){
        if(town == null){
            throw new IllegalArgumentException("Town cannot be null");
        }
        this.towns.add(town);
    }

    /**
     * Get the list of all the towns in the register.
     *
     * @return the array list
     */
    public ArrayList<PostTown> getTowns(){
        return towns;
    }

    /**
     * Remove the Town from the register.
     *
     * @param town the town
     */
    public void removePostTown(PostTown town){
        if(this.towns.contains(town)){
            this.towns.remove(town);
        }else{
            throw new IllegalArgumentException("Town does not exist");
        }
    }
}
