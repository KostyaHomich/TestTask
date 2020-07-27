package test.task.com.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.task.com.entity.Room;
import test.task.com.service.exception.ServiceException;
import test.task.com.service.impl.RoomServiceImpl;
import test.task.com.util.Converter;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Menu extends JFrame {


    private String[] roomColumns = {"Id", "Type"};
    private ApplicationContext context =
            new AnnotationConfigApplicationContext("test.task.com.*");
    private Converter converter = context.getBean(Converter.class);
    private JTable jTable;

    public Menu() {
        Box contents = new Box(BoxLayout.Y_AXIS);

        JMenuBar menuBar = new JMenuBar();

        JMenu jMenuRooms = new JMenu("Rooms");
        JMenu jMenuWorkers = new JMenu("Workers");
        JMenu jMenuOrders = new JMenu("Orders");

        menuBar.add(jMenuOrders);
        menuBar.add(jMenuWorkers);
        menuBar.add(jMenuRooms);

        setBounds(450, 190, 1000, 700);
        // setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Med center");
        setLayout(null);

        try {

            List<Room> roomList = context.getBean(RoomServiceImpl.class).getAll();
            Object[][] array = converter.convertListRoomToArray(roomList);
            jTable = new JTable(array, roomColumns);
            jTable.setLayout(null);
            jTable.setSize(300, 300);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        contents.add(menuBar);
        contents.add(new JScrollPane(jTable));

        setContentPane(contents);

        setVisible(true);
    }


}
