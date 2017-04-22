package com.doctorAppointmentBookingSystem.serviceImpl;

import com.doctorAppointmentBookingSystem.entity.DaySchedule;
import com.doctorAppointmentBookingSystem.model.bindingModel.DayScheduleModel;
import com.doctorAppointmentBookingSystem.repository.DayScheduleRepository;
import com.doctorAppointmentBookingSystem.service.DayScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Edi on 22-Apr-17.
 */
@Service
public class DayScheduleServiceImpl implements DayScheduleService {
    private DayScheduleRepository dayScheduleRepository;

    private ModelMapper modelMapper;

    @Autowired
    public DayScheduleServiceImpl(DayScheduleRepository dayScheduleRepository, ModelMapper modelMapper) {
        this.dayScheduleRepository = dayScheduleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(DayScheduleModel dayScheduleModel) {
        DaySchedule daySchedule = this.modelMapper.map(dayScheduleModel, DaySchedule.class);

        this.dayScheduleRepository.saveAndFlush(daySchedule);
    }
}