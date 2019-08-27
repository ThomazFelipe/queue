package com.unitri.tcc.queue.service;

import com.unitri.tcc.queue.data.dto.SmsData;
import com.unitri.tcc.queue.data.model.User;
import javassist.NotFoundException;

public interface ScheduleService {
    void schedule(User user, String message) throws NotFoundException;
}
