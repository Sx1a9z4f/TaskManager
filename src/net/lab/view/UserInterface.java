package net.lab.view;

import net.lab.controller.TaskJournal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UserInterface extends JFrame {

    private TaskJournal taskJournal;

    private JPanel jPanel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JScrollPane ScrollPane;
    private JTable table1;
    private final static String[] str = {"Name","Description","Notification date","Contacts"};

    public UserInterface(ArrayList arrayList,TaskJournal taskJournal) throws HeadlessException {
        super("Task Manager");
        this.taskJournal = taskJournal;
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel1);
        initComponents(arrayList);
        fillTable(arrayList);
        setVisible(true);
    }

    private void initComponents(ArrayList arrayList){
        addTaskButton.addActionListener(e -> {

        });

        deleteTaskButton.addActionListener(e->{

        });
    }

    private void toArray(ArrayList list){

    }

    public void fillTable(ArrayList list){
        Vector data = new Vector();
        Vector name = new Vector();
        for (int i = 0; i < str.length; i++) {
            name.add(i,str[i]);
        }
        TableModel tm = new TableModel(data,name);
    }

    class TableModel extends DefaultTableModel{
        public TableModel(Vector data,Vector<String> colNames){
            super(data,colNames);
        }
    }

}