package duke.task;

public abstract class Task {
    private final String task;
    private boolean isDone;

    public Task(String task) {
        this.task = task;
        this.isDone = false;
    }

    public Task(String task, String prefix) {
        String[] returnedArray = task.split(" ");
        String removedPrefix = "";
        int start = 0;
        if (returnedArray[0].equals(prefix)) {
            start = 1;
        }
        for (int i = start; i < returnedArray.length - 1; i++) {
            removedPrefix += returnedArray[i] + " ";
        }
        removedPrefix += returnedArray[returnedArray.length - 1];

        this.task = removedPrefix;
        this.isDone = false;
    }

    public void setDone() {
        isDone = true;
    }

    public void setUndone() {
        isDone = false;
    }

    @Override
    public String toString() {
        String box = isDone ? "[X] " : "[ ] ";
        return box + task;
    }
}
