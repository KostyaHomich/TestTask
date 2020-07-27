package test.task.com.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import test.task.com.entity.Room;

@Service
@Scope("prototype")
public class RoomServiceImpl extends AbstractServiceImpl<Room> {
}
