package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTodos() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить в Банк");

        String[] subtasks = {"Забрать посылку", "Взять свой кофе", "Записаться в автосервис", "Зайти в Банк"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Банк");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSubtask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить в Банк");

        String[] subtasks = {"Забрать посылку", "Взять свой кофе", "Записаться в автосервис", "Зайти в Банк"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("кофе");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTwo() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить в Банк");

        String[] subtasks = {"Забрать посылку", "Взять свой кофе", "Позвонить в автосервис", "Зайти в Банк"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить в Банк");

        String[] subtasks = {"Забрать посылку", "Взять свой кофе", "Позвонить в автосервис", "Зайти в Банк"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Подготовка тест-кейсов");
        todos.search("Банк закрытие");
        todos.search("в 9:00 утра");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(1, "Позвонить в Банк");

        boolean expected = false;
        boolean actual = simpleTask.matches("банк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить в Банк");

        String[] subtasks = {"Забрать посылку", "Взять свой кофе", "Позвонить в автосервис", "Зайти в Банк"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(simpleTask.getTitle());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSubTask() {

        String[] subtasks = {"Забрать посылку", "Взять свой кофе", "Позвонить в автосервис", "Зайти в Банк"};
        Epic epic = new Epic(2, subtasks);

        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMeetingGetTopic() {

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        String expected = "Подготовка тест-кейсов";
        String actual = meeting.getTopic();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMeetingGetProject() {

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        String expected = "Банк Закрытие";
        String actual = meeting.getProject();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMeetingGetStart() {

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        String expected = "в 9:00 утра";
        String actual = meeting.getStart();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {

        Meeting meeting = new Meeting(
                3,
                "Подготовка тест-кейсов",
                "Банк Закрытие",
                "в 9:00 утра"
        );

        int expected = 3;
        int actual = meeting.getId();

        Assertions.assertEquals(expected, actual);
    }

}