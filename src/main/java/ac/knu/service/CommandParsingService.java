package ac.knu.service;

import ac.knu.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CommandParsingService {
    private HashMap<String,CommandService> commandLists;
    public CommandParsingService() {
        commandLists = new HashMap<>();
        commandLists.put("add",new AddCommand());
        commandLists.put("remove",new RemoveCommand());
        commandLists.put("find",new FindCommand());
        commandLists.put("list",new ListCommand());
        commandLists.put("time",new TimeCommand());
    }
    public String parsingCommand(FriendDataBase friendDataBase, String command) {
        String[] commandLine = command.split("\\s+");
        if(commandLists.containsKey(commandLine[0])) {
            return checkIfCommandOptionIsExist(
                    commandLine, commandLists.get(commandLine[0])).executeCommand(friendDataBase,commandLine);
        } else {
            throw new InvalidCommandSyntaxException("'"+commandLine[0]+"'");
        }
    }
    public CommandService checkIfCommandOptionIsExist(String[] commandLines, CommandService command)  {
        if(commandLines.length == command.getNumberOfCommandOptions()+1){
            return command;
        } else {
            throw new NoCommandOptionException();
        }
    }
}
