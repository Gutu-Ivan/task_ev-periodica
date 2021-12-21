package dev.task_evperiodica.service;

import dev.task_evperiodica.models.Phone;

import java.util.List;

public interface PhoneService {
    Phone create(Phone phone);
    Phone read(long id);
    List<Phone> readAll();
    Phone update(long id, Phone phone);
    List<Phone> delete(long id);
}
