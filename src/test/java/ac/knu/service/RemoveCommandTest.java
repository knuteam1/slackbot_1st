package ac.knu.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RemoveCommandTest {
    private FriendDataBase friendDataBase;
    private RemoveCommand removeCommand;
    @Before
    public void setUp() {
        friendDataBase = new FriendDataBase();
        removeCommand = new RemoveCommand();
        friendDataBase.addFriendToDataBase("hangeul",11,Friend.Gender.MAN);
        friendDataBase.addFriendToDataBase("hankook",21,Friend.Gender.MAN);
    }
    @Test
    public void executeRemoveCommandReturnMessageWithFriendName() {
        String result = removeCommand.executeCommand(friendDataBase,"remove hangeul".split("\\s+"));
        assertTrue(result.equalsIgnoreCase("hangeul is removed successfully!"));
    }
}
