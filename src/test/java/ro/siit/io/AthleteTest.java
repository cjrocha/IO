package ro.siit.io;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class AthleteTest extends TestCase {
    @Test
    public void testGetSeconds() {
        String[] inputs = {"45:19", "1:15:27", "00:55", "09:00", "05:00:24", "27:37"};
        Integer[] expecteds = {2719, 4515, 55, 540, 18000, 1657};
        int i=0;
        for (String input : inputs){
            int b = expecteds[i];
            int a =  Athlete.getSeconds(input);
            Assert.assertEquals(b, a);
            i++;
        }

    }

    @Test
    public void testGetPenalties() {
        int i = 0;
        Athlete k = new Athlete(27,"Piotr Smitzer","CZ","30:10","xxxxx","xxxxx","xxxxx");
        int b = k.getPenalties();
        int a  = 0;
        Assert.assertEquals(b, a);

    }
}