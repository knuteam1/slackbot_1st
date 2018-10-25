package ac.knu.service;

import java.util.Date;

public class TimeCommand extends CommandService {
    public TimeCommand() {
        numberOfCommandOptions = 0;
    }
    @Override
    public String executeCommand(FriendDataBase friendDataBase, String[] commandLine) {
        return "Current Time: " + new Date().toString();
    }
}
