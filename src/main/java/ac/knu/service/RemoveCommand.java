package ac.knu.service;

public class RemoveCommand extends CommandService {
    public RemoveCommand() {
        numberOfCommandOptions = 1;
    }
    @Override
    public String executeCommand(FriendDataBase friendDataBase, String[] commandLine) {
        String friendName = super.friendNameValidCheck(commandLine[1]);
        return friendDataBase.removeFriendByName(friendName) + " is removed successfully!";
    }
}
