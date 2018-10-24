package ac.knu.service;

import ac.knu.exceptions.*;
import lombok.Data;

@Data
public abstract class CommandService {
    public int numberOfCommandOptions;
    public abstract String executeCommand(FriendDataBase friendDataBase, String[] commandLine);

    public String friendNameValidCheck(String friendName) {
        for(char alphabet : friendName.toCharArray()){
            if(!Character.isAlphabetic(alphabet)||alphabet == ' ') {
                throw new InvalidFriendNameException("'"+friendName+"'");
            }
        }
        return friendName;
    }
    public int friendAgeValidCheck(String age) {
        for(char digit : age.toCharArray()) {
            if(!Character.isDigit(digit) || digit == ' ') {
                throw new InvalidFriendAgeSyntaxException("'"+age+"'");
            }
        }
        return Integer.parseInt(age);
    }
    public Friend.Gender getGenderFromCommandOption(FriendDataBase friendDataBase, String genderSyntax) {
        if(friendDataBase.getManGenderDictionary().contains(genderSyntax.toLowerCase())) {
            return Friend.Gender.MAN;
        } else if(friendDataBase.getFemaleGenderDictionary().contains(genderSyntax.toLowerCase())) {
            return Friend.Gender.FEMALE;
        } else {
            throw new InvalidGenderSyntaxException("'"+genderSyntax+"'");
        }
    }
}
