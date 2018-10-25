package ac.knu.service;

public class FindCommand extends CommandService {
    public FindCommand() {
        numberOfCommandOptions = 1;
    }
    @Override
    public String executeCommand(FriendDataBase friendDataBase, String[] commandLine) {
        String friendName = super.friendNameValidCheck(commandLine[1]);
        return friendDataBase.searchAndGetFriendByName(friendName).getFriendInformation();
    }
}
