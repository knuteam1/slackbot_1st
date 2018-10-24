package ac.knu.service;

import ac.knu.exceptions.FriendDataBaseEmptyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ListCommandTest {
    private FriendDataBase friendDataBase;
    private ListCommand listCommand;
    @Before
    public void setUp() {
        friendDataBase = new FriendDataBase();
        listCommand = new ListCommand();
        friendDataBase.addFriendToDataBase("hangeul",11,Friend.Gender.MAN);
        friendDataBase.addFriendToDataBase("hankook",21,Friend.Gender.MAN);
    }
    @Test(expected =FriendDataBaseEmptyException.class)
    public void makeErrorDatabaseEmptyWhenTryToListCommandWhenNoData() {
       friendDataBase.getFriendDataBase().clear();
       listCommand.executeCommand(friendDataBase,"list".split("\\s+"));
   }
    @Test
    public void executeListCommandAndReturnFriendInformationByRows() {
        String result = listCommand.executeCommand(friendDataBase,"list".split("\\s+"));
        assertTrue(result.equalsIgnoreCase("hangeul, 11, MAN\nhankook, 21, MAN\n"));
    }
}
