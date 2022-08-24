package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.ToDo;

/**
 * Command to execute adding a ToDo to a TaskList
 * @author Nephelite
 * @version 0.1
 */
public class ToDoCommand extends Command {
    private String command;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for a ToDoCommand
     * @param command the command
     * @param tasks TaskList Duke is using
     * @param ui Ui Duke is using
     * @since 0.1
     */
    public ToDoCommand(String command, TaskList tasks, Ui ui) {
        this.command = command;
        this.tasks = tasks;
        this.ui = ui;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        ToDoCommand commandOther = (ToDoCommand) obj;
        return command.equals(commandOther.command) && tasks.equals(commandOther.tasks) && ui.equals(commandOther.ui);
    }

    @Override
    public void execute(Storage storage) throws DukeException {
        String[] returnedArray = command.split(" ");
        if (returnedArray.length == 1) {
            throw new DukeException("your [todo] duke.command is empty."
                    + "\nPlease use the [help] duke.command to check the proper usage of [todo].");
        }
        ToDo toDo = new ToDo(command);
        tasks.add(toDo);
        ui.addTask(toDo, tasks.size());
        storage.saveDuke(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
