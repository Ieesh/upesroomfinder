package upes.roomfinder;

import java.util.Arrays;

public enum Building {
    Nineth_Block,
    Tenth_Block,
    Eleventh_Block,
    blank;


    @Override
    public String toString() {
        if(super.toString().equals("blank")){
            return "";
        }
        return super.toString().replaceAll("_"," ");
    }

    public static Building getValue(String building){
        if(contains(building,Keywords.ninethblock)){
            return Nineth_Block;
        } else if(contains(building,Keywords.tenthblock)){
            return Tenth_Block;
        } else if(contains(building,Keywords.eleventhblock)){
            return Eleventh_Block;

        } else {
            return blank;
        }
    }

    private static boolean contains(String value,String[] array){
        return Arrays.asList(array).contains(value);
    }
}
