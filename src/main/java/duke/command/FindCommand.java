package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Command to execute finding tasks using a keyword
 * @author Nephelite
 * @version 0.1
 */
public class FindCommand extends Command {
    private String word;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for a FindCommand
     * @param word the keyword to search
     * @param tasks the TaskList that Duke is using
     * @param ui the Ui that Duke is using
     */
    public FindCommand(String word, TaskList tasks, Ui ui) {
        this.word = word;
        this.tasks = tasks;
        this.ui = ui;
    }

    @Override
    public void execute(Storage storage) throws DukeException {
        ui.readList(tasks.find(word));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}