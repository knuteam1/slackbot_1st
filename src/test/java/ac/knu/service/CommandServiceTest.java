package ac.knu.service;

import ac.knu.exceptions.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandServiceTest {
    private CommandService commandService;
    private FriendDataBase friendDataBase;
    @Before
    public void setUp() {
        friendDataBase = new FriendDataBase();
        commandService = new CommandService() {
            @Override
            public String executeCommand(FriendDataBase friendDataBase, String[] commandLine) {
                return null;
            }
        };
    }

    @Test(expected = InvalidFriendNameException.class)
    public void makeErrorWhenFriendNameOptionIsInvalid() {
        assertFalse(commandService.friendNameValidCheck("hang2121").equalsIgnoreCase("hang2121"));
    }
    @Test
    public void returnStringFriendNameIfNameIsValid() {
        assertTrue(commandService.friendNameValidCheck("hangeul").equalsIgnoreCase("hangeul"));
    }
    @Test(expected = InvalidFriendAgeSyntaxException.class)
    public void makeErrorWhenFriendAgeIsInvalid() {
        assertFalse(commandService.friendAgeValidCheck("aa")==22);
    }
    @Test
    public void returnIntFriendAgeIfAgeIsValid() {
        assertEquals(11, commandService.friendAgeValidCheck("11"));
    }
    @Test(expected = InvalidGenderSyntaxException.class)
    public void makeErrorWhenFriendGenderIsInvalid() {
        assertNotSame(commandService.getGenderFromCommandOption(friendDataBase, "stringMan"), Friend.Gender.MAN);
        assertNotSame(commandService.getGenderFromCommandOption(friendDataBase,"prettyGirl"), Friend.Gender.FEMALE);
    }
    @Test
    public void returnGenderEnumIfFriendGenderIsValidWord() {
        assertEquals(commandService.getGenderFromCommandOption(friendDataBase, "male"), Friend.Gender.MAN);
        assertEquals(commandService.getGenderFromCommandOption(friendDataBase, "Woman"), Friend.Gender.FEMALE);
    }

}
