# SleepyVoid User Guide



SleepyVoid is a chatbot with cat ASCII art made to help users manage and organize their tasks.
It allows you to add and track tasks, deadlines, and events, remove completed tasks.

It has multiple features such as deadline tracking, event scheduling, task completion marking, storage, and more.

### Note: All commands are not case sensitive

## Adding Tasks


The main function of SleepyVoid is task management, and below are the 3 task types.
They each have different features, so you can choose one of them to use that best fits your task.


### 1. Todo
`todo` stores simple tasks that can be completed without any time specification.
It is ideal for tasks that do not have a specific deadline or schedule.

#### Usage:
To add a `todo` task, use the following command:
 ```
 todo [task description]
 ```

#### Example:
 ```angular2html
 todo Return book
 ```

#### Output:
After successfully adding a todo task, 
you will see the expected output below 
 ```angular2html
            /ᐠ˵+ +˵マ added:
                1. [T][ ] Read Book
          Now there's 2 pending task(s) in the list.
 ```
- The format of your task would be `[T][ ] task description`.
- The first `[T]` indicates that it is a `todo` task.
- The second `[ ]` shows the completion status, which will be elaborated below

#### Key Feature:
* **No time requirement:**  `Todo` can be used for any general tasks

### 2. Deadline
`deadline` stores tasks with a specific due date and time, which is good to use for tasks that have to be completed before a certain deadline.

#### Usage:
To add a `deadline` task, use the following command:
 ```
 deadline [task description] /by [date and time]
 ```
Date and time can be keyed in any format as you wish to.


#### Example:
 ```angular2html
 deadline Submit assignment /by 14 Nov
 ```

#### Output:
The output of successfully adding a `deadline` task is similar to adding a `todo` task.
 ```angular2html
            /ᐠ˵+ +˵マ added:
                2. [D][ ] Submit assignment (by: 14 Nov)
          Now there's 2 pending task(s) in the list.
 ```
- The format would be `[D][ ] task description (by: date and time)`.
- `[D]` represent that this task is a `deadline` task.
- The bracket `(by: _)`shows the given deadline 

#### Key Feature:
* **Time Required:** `deadline` must contain a command `/by` and an input after, to ensure no errors


### 3. Event
`event` is a `task` type that stores tasks or activities that have a start and end time.
This makes it suitable for events in a time block, such as meetings or appointments.
#### Usage:
To add a `event` task, use the following command:
 ```
 event [task description] /from [start date and time] /to [end date and time]
 ```

**Notice:**  the format of date and time is the same as `deadline`.

#### Example:
 ```angular2html
 event Lab /from 2 /to 5
 ```

#### Output:
The output of successfully adding a `event` task is similar to the previous 2 `task` types
 ```angular2html
            /ᐠ˵+ +˵マ added:
                3. [E][ ] Lab (from: 2 to: 5)
          Now there's 3 pending task(s) in the list.
 ```
- The format of your task would be `[E][ ] task description (from: start date and time to: end date and time)`.
- `[E]` represent that this task is an `event` task
- The bracket `(from: _ to: _)`shows the event duration

#### Key Feature:
* **Time Duration Required:** `event` must contain a start time and end time.

## Other commands

To help manage the tasks, we provide a set of useful commands that you can use to interact with SleepyVoid.


**Notice:** The command is not type sensitive

Below are the available commands and their functionalities:

### 1. List
`list` is a command that list all the tasks currently stored in SleepyVoid.

#### Usage:
To list all the tasks, you can use the following command:
 ```angular2html
 list
 ```

#### Example:

 ```angular2html
 list
 ```

#### Output:
The expected output shows below:
 ```angular2html
        /ᐠ˵= =˵マ:
                1. [T][ ] Read Book
                2. [D][ ] Submit assignment (by: 14 Nov)
                3. [E][ ] Lab (from: 2 to: 5)
 ```


### 2. Remove
`remove` allows you to delete a task from the list.

#### Usage:
To remove a task, you can use following command:
 ```angular2html
 remove [index]
 ```
- `index` is the index of the task in the list, which can be viewed from listing the list via the  `list ` command
- The number in front of the task is the task index to use.

#### Example:
 ```angular2html
remove 1
 ```

### Output:
Once the chatbot delete the task from the list, you will find the expected output below:
 ```angular2html
            /ᐠ˵- -˵マ removed: 1. [T][X] Read Book
 ```
When you type `list` again, the list will now look like this
```angular2html
        /ᐠ˵= =˵マ:
                1. [D][ ] Submit assignment (by: 14 Nov)
                2. [E][ ] Lab (from: 2 to: 5)
 ```

### 3. Mark
Mark allows you to mark your task as completed, thus allowing you to check it off the list

#### Usage:
To mark a task, you can use the following command:
 ```angular2html
 mark [index]
 ```
* Same as `delete` command, the index is the number of the task in the list.


#### Example:
Type in these two command in sequence:
 ```angular2html
 mark 1
 ```

#### Output:
The expected output of command `mark 1` would be:
 ```angular2html
            /ᐠ˵, ,˵マ Nice! I've marked this task as done:
                1. [D][X] Submit assignment (by: 14 Nov)
 ```


### 4. Find
`find` is used for finding the specific tasks using a keyword.
You can find specific tasks that contains the keyword in the task description.

#### Usage:
To find a specific task, you can use following command:
 ```angular2html
 find [description]
 ```

* `description` is the keyword that your target tasks should contain. 
If a task contains the keyword, it will be displayed to you

#### Example:
Suppose we want to find tasks that contains the keyword assignment, we can use `find` command:
 ```angular2html
 find assignment
 ```

#### Output:
The expected output is shown below:
 ```angular2html
            /ᐠ˵o o˵マ Here are the matching tasks in your list:
                1. [D][X] Submit assignment (by: 14 Nov)
 ```

## Exit

To end the conversation with SleepyVoid, you can use the following command:
 ```angular2html
 bye
 ```
The chatbot will end the conversation, and you can use it again if you wish to add more tasks.

## Saving Data
All the data is auto saved, thus when you restart the chat, all the previously listed tasks will still be inside.
Any updates made to the list will be autosaved as well.

The saved data will be automatically loaded to the chat when the conversation starts, and can be checked by using the `list` command.

You can access to the saved data via the following path:\
`data/SleepyVoid.txt`

The format of data would be:
 ```angular2html
Deadline | Completed ^* *^ | Submit assignment | 14 Nov
Event | Yet to do... | Lab | 2 ~ 5
 ```
**Notice:** It is discouraged for you to modify data directly inside the file `SleepyVoid.txt`.
If you have to change data in `list.txt`, please follow the same format.
If not, it will cause error when loading your data to SleepyVoid.


If you encounter any errors when loading the file, please delete all the data in the file `SleepyVoid.txt`, and added them again via the chatbot

## Notes
- If any required details are missing or incorrectly formatted,
  the system will prompt an error, and show the steps you can take to use the correct command

