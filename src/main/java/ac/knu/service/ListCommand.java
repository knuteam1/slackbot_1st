package ac.knu.service;


import ac.knu.exceptions.FriendDataBaseEmptyException;

public class ListCommand extends CommandService {
    public ListCommand() {
        numberOfCommandOptions = 0;
    }
    @Override
    public String executeCommand(FriendDataBase friendDataBase, String[] commandLine) {
        if( friendDataBase.getFriendsNumber() != 0) {
            StringBuilder friendListTable = new StringBuilder();
            for(Friend friend : friendDataBase.getFriendDataBase().values()) {
                friendListTable.append(friend.getFriendInformation()).append("\n");
            }
            return friendListTable.toString();
        } else {
            throw new FriendDataBaseEmptyException();
        }
    }

}
