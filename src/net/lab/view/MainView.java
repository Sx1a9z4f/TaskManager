package net.lab.view;

import net.lab.model.ModelContract;
import net.lab.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class MainView extends JFrame implements ViewContract {


    private JPanel jPanel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JScrollPane ScrollPane;
    private JTable table;

    private ModelContract model;


    public MainView(ModelContract model) throws HeadlessException {
        super("Task Manager");
        setBounds(400, 150, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel1);
        initComponents();
        this.model = model;
        Vector<Task> gg = new Vector<>();
        gg.add(new Task("fdnfh","dfgh","gfdh","gdfjd"));
        updateView(gg);
        setVisible(true);
    }

    private void initComponents() {
        addTaskButton.addActionListener(e -> {
            new AddView(this);
        });

        deleteTaskButton.addActionListener(e -> {

        });
    }

    @Override
    public void updateView(Vector<Task> tasks) {
        tableNameCol();
        table.setModel(new TableModel(toNormalVector(tasks), namCol));
    }

    @Override
    public void addNewTask(Task task) {
        model.addTask(task);
       // updateView(model.getTasks());
    }

    @Override
    public Task getAddTask() {
        return null;
    }


    private static Vector<String> namCol = new Vector<>(4);

    private void tableNameCol() {
        namCol.add("Name");
        namCol.add("Description");
        namCol.add("Notification date");
        namCol.add("Contacts");
    }

    private Vector<Vector<String>> toNormalVector(Vector<Task> tasks) {
        Vector<Vector<String>> data = new Vector<>();
        for (Task value : tasks) {
            Vector<String> task = new Vector<>();
            task.add(value.getName());
            task.add(value.getDescription());
            task.add(value.getNotificationDate());
            task.add(value.getContacts());
            data.add(task);
        }
        return data;
    }


    static class TableModel extends DefaultTableModel {
        TableModel(Vector<Vector<String>> data, Vector namCol) {
            super(data, namCol);
        }
    }

}
