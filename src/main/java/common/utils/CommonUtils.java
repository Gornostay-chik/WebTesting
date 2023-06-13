package common.utils;

import java.util.List;

/**
 * Class for serves methods such print some information, take screenshots and others...
 */
public class CommonUtils {

    public static <T> void printActualAndExpectedLists (List<T> actualList, List<T> expectedList){
        actualList.stream().forEach((i) -> {
            System.out.println("actualList = " + i.toString());
        });
        expectedList.stream().forEach((i) -> {
            System.out.println("expectList = " + i.toString());
        });
    }
}
