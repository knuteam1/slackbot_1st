package ac.knu.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FindCommandTest {
    private FriendDataBase friendDataBase;
    private FindCommand findCommand;
    @Before
    public void setUp() {
        friendDataBase = new FriendDataBase();
        findCommand = new FindCommand();
        friendDataBase.addFriendToDataBase("hangeul",11,Friend.Gender.MAN);
        friendDataBase.addFriendToDataBase("hankook",21,Friend.Gender.MAN);
    }
    @Test
    public void executeRemoveCommandReturnMessageWithFriendName() {
        String result = findCommand.executeCommand(friendDataBase,"find hangeul".split("\\s+"));
        assertTrue(result.equalsIgnoreCase("hangeul, 11, MAN"));
    }
}