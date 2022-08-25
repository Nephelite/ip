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

    /**
     * Checks if the input ToDoCommand is identical to this ToDoCommand (to only be used for JUnit testing)
     * @param obj input ToDoCommand
     * @return false if obj is null, not from the ToDoClass, or command, tasks and ui do not match those of this.
     *     Otherwise, return true.
     */
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

    /**
     * {@inheritDoc}
     * @param storage Duke's storage system for tasks
     * @throws DukeException if the input command is invalid
     */
    @Override
    public void execute(Storage storage) throws DukeException {
        String[] returnedArray = command.split(" ");
        if (returnedArray.length == 1) {
            throw new DukeException("your [todo] command is empty."
                    + "\nPlease use the [help] command to check the proper usage of [todo].");
        }
        ToDo toDo = new ToDo(command);
        tasks.add(toDo);
        ui.addTask(toDo, tasks.size());
        storage.saveDuke(tasks);
    }
    /**
     * {@inheritDoc}
     * @return true if the command ends the current session. Otherwise, false.
     * @since 0.1
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
