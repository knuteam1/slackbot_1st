package ac.knu.service;


import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TimeCommandTest {
    @Test
    public void executeTimeCommandReturnCurrentLocalTime() {
        FriendDataBase friendDataBase = new FriendDataBase();
        TimeCommand timeCommand = new TimeCommand();
        String result = timeCommand.executeCommand(friendDataBase,"time".split("\\s+"));
        assertTrue(result.equalsIgnoreCase("Current Time: "+new Date().toString()));
    }
}
