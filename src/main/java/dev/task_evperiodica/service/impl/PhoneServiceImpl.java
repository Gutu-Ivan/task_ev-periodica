package dev.task_evperiodica.service.impl;

import dev.task_evperiodica.models.Phone;
import dev.task_evperiodica.repo.PhoneRepository;
import dev.task_evperiodica.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final dev.task_evperiodica.repo.PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        super();
        this.phoneRepository = phoneRepository;
    }

    @Override
    public Phone create(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone read(long id) {
        return phoneRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Phone> readAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone update(long id, Phone phone) {
        Phone foundPhone = phoneRepository.findById(id).orElseThrow();
        foundPhone.setBrand(phone.getBrand());
        foundPhone.setColor(phone.getColor());
        foundPhone.setPrice(phone.getPrice());
        foundPhone.setId(phone.getId());
        phoneRepository.save(foundPhone);
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> delete(long id) {
        phoneRepository.deleteById(id);
        return phoneRepository.findAll();
    }
}
