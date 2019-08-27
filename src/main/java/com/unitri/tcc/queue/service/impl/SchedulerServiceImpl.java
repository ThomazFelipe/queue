package com.unitri.tcc.queue.service.impl;

import com.unitri.tcc.queue.data.dto.SmsData;
import com.unitri.tcc.queue.data.model.Event;
import com.unitri.tcc.queue.data.model.User;
import com.unitri.tcc.queue.service.EventService;
import com.unitri.tcc.queue.service.ScheduleService;
import com.unitri.tcc.queue.service.SmsService;
import com.unitri.tcc.queue.service.UserService;
import com.unitri.tcc.queue.utils.TaskManager;
import javassist.NotFoundException;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Timer;
import java.util.function.Function;

@Service
public class SchedulerServiceImpl implements ScheduleService {

    @Autowired
    private SmsService smsService;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Value("${schedule.frequency}")
    private String frequency;

    @Value("${schedule.time.unity}")
    private String unity;

    //--------------------------------just execute in another thread instance-----------------------------------------------
    private Function<Object,Object> BASIC_SMS_FUNCTION = o -> {
        SmsData smsData = (SmsData) o;

        Event event = null;
        try {
            event = eventService.getOne(smsData.getEventId());

            smsService.sendTwilio(
                    getQueueInformation( event, smsData.getUserPasswordNumber() ) + smsData.getMessage(),
                    smsData.getNumber());

            if( event.getCurrentPassword().equals( smsData.getUserPasswordNumber() )
                    && Thread.currentThread().getName().equals("SmsSendingThread") ){
                Thread.currentThread().interrupt();
            }

            return true;
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    };

    private String getQueueInformation(Event event, Long userPasswordNumber) {

        if(userPasswordNumber - event.getCurrentPassword() <= 5){
            return  "Senha atual: " + event.getCurrentPassword() + "\n";
        } else {
            return  "ATENÇÃO --- Senha atual: " + event.getCurrentPassword() + "\n";
        }
    }


    @Override
    public void schedule(User user, String message) throws NotFoundException {
        Timer t = new Timer();

        SmsData data = new SmsData(user.getPhone(), message, user.getPasswordNumber());

        List<User> users = userService.findByPhone( data.getNumber() );

        new Thread(
                () -> t.scheduleAtFixedRate(
                        new TaskManager(BASIC_SMS_FUNCTION, data.setEventId(user.getEvent().getId())
                                .setUserPasswordNumber(user.getPasswordNumber())),
                        0,
                        getRate()
                ), "SmsSendingThread"
        );

    }

    private Long getRate() {
        Long time = Long.parseLong(frequency);
        Long unityMultiplier;
        switch (unity){
            case "HOUR":
                unityMultiplier =1000L*60*60;
                break;
            case "MINUTE":
                unityMultiplier = 1000L*60;
                break;
            case "SECOND":
                unityMultiplier = 1000L;
                break;
            default:
                unityMultiplier = 1L;
        }

        return time * unityMultiplier;
    }
}
