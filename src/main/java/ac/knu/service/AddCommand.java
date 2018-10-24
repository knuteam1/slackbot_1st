package ac.knu.service;

import ac.knu.exceptions.FriendDataBaseAlreadyFullException;

public class AddCommand extends CommandService {
    public AddCommand() {
        numberOfCommandOptions = 3;
    }
    @Override
    public String executeCommand(FriendDataBase friendDataBase, String[] commandLine) {
        String friendName = super.friendNameValidCheck(commandLine[1]);
        int friendAge = super.friendAgeValidCheck(commandLine[2]);
        Friend.Gender friendGender = super.getGenderFromCommandOption(friendDataBase, commandLine[3]);
        if(friendDataBase.canSaveFriendMore()){
            friendDataBase.addFriendToDataBase(friendName, friendAge, friendGender);
            return friendName+" is added successfully!";
        } else {
            throw new FriendDataBaseAlreadyFullException();
        }
    }
}
