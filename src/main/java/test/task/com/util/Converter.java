package test.task.com.util;

import org.springframework.stereotype.Component;
import test.task.com.entity.Room;

import java.util.List;

@Component
public class Converter {

    public String[][] convertListRoomToArray(List<Room> entities) {
        int height = entities.size();
        String[][] array = new String[height][2];
        for (int i = 0; i < height; i++) {

            array[i][0] = String.valueOf(entities.get(i).getId());
            array[i][1] = entities.get(i).getType();
        }
        return array;

    }

}
