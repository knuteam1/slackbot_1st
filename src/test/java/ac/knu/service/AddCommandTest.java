package ac.knu.service;

import ac.knu.exceptions.FriendDataBaseAlreadyFullException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class AddCommandTest {
    private AddCommand addCommand;
    private FriendDataBase friendDataBase;
    @Before
    public void setUp() {
        addCommand = new AddCommand();
        friendDataBase = new FriendDataBase();
        friendDataBase.addFriendToDataBase("hangeul",11,Friend.Gender.MAN);
        friendDataBase.addFriendToDataBase("hankook",21,Friend.Gender.MAN);
        friendDataBase.addFriendToDataBase("kim",11,Friend.Gender.FEMALE);
        friendDataBase.addFriendToDataBase("bae",11,Friend.Gender.FEMALE);
        friendDataBase.addFriendToDataBase("jung",11,Friend.Gender.FEMALE);
        friendDataBase.addFriendToDataBase("hun",11,Friend.Gender.FEMALE);
        friendDataBase.addFriendToDataBase("choi",11,Friend.Gender.FEMALE);
        friendDataBase.addFriendToDataBase("david",11,Friend.Gender.FEMALE);
        friendDataBase.addFriendToDataBase("kang",11,Friend.Gender.FEMALE);
    }
    @Test
    public void executeAddCommandReturnMessageWithFriendName() {
        String result = addCommand.executeCommand(friendDataBase,"add jessica 22 female".split("\\s+"));
        assertTrue(result.equalsIgnoreCase("jessica is added successfully!"));
    }
    @Test(expected = FriendDataBaseAlreadyFullException.class)
    public void makeErrorAfterMaximumLimitOfFriendWhenAdding(){
        assertTrue(addCommand.executeCommand(
                friendDataBase,"add james 21 male".split("\\s+")).equalsIgnoreCase("james is added successfully!"));
        addCommand.executeCommand(
                friendDataBase,"add mina 32 female".split("\\s+"));
    }
}
