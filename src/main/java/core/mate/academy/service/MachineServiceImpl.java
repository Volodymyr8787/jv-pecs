package core.mate.academy.service;

import core.mate.academy.model.*;

import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    @Override
    public List<T> getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            MachineProducer<Bulldozer> producer = new BulldozerProducer();
            return (List<T>) producer.get();
        }
        if (type == Truck.class) {
            MachineProducer<Truck> producer = new TruckProducer();
            return (List<T>) producer.get();
        }
        if (type == Excavator) {
            MachineProducer<Excavator> producer = new ExcavatorProducer();
            return (List<T>) producer.get();
        }
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }

    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (T machine : machines) {
            machine.doWork();
        }

    }

}
