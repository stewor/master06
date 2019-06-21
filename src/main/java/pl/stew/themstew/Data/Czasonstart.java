package pl.stew.themstew.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Czasonstart {
    CzasRepo czasRepo;
    @Autowired
    public void addCzas(CzasRepo czasRepo){
        this.czasRepo=czasRepo;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void addCzas(){
        Date now =new Date();
        Czas c=new Czas();
        c.setDate(now);
        czasRepo.save(c);
        }
}
