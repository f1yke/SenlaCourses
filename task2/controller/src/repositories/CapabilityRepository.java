package repositories;

import com.danco.training.TextFileWorker;
import entities.Capability;
import utils.TextWorker;

import java.text.ParseException;
import java.util.List;

public class CapabilityRepository {
    private List<Capability> capabilities;

    public CapabilityRepository() {
        capabilities = new TextWorker().getCapabilities(new TextFileWorker("D:\\in_capabilities.txt").readFromFile());
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public Capability getCapabilityById(int id) {
        for (int i = 0; i < capabilities.size(); i++) {
            if (capabilities.get(i).getId() == id) {
                return capabilities.get(i);
            }
        }
        return null;
    }

    public void addCapability(Capability capability) {
        capabilities.add(capability);
    }
}