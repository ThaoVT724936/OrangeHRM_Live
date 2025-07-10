package ultilities;

import org.testng.Assert;

public class AssertHelper {
    public static void assertEquals(String actual, String expect){
        if(actual == null) actual = "";
        if(expect == null) expect = "";
        Assert.assertEquals(actual,expect);
    }
}
