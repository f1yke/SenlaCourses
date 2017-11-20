package repositories;

import com.danco.training.TextFileWorker;
import entities.Capability;
import org.apache.log4j.Logger;
import utils.TextWorker;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class CapabilityRepository {
    private List<Capability> capabilities;
    private Logger logger = Logger.getLogger(CapabilityRepository.class);
    private int lastId;

    private static CapabilityRepository capabilityRepository;

    public static CapabilityRepository getInstance(String filePath) {
        if (capabilityRepository == null) {
            capabilityRepository = new CapabilityRepository(filePath);
        }
        return capabilityRepository;
    }

    public CapabilityRepository(String filePath) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            capabilities = (List<Capability>) ois.readObject();
            lastId = capabilities.get(capabilities.size() - 1).getId();
        } catch (Exception e) {
            logger.error(e.getMessage());
            lastId = 0;
            capabilities = new ArrayList<>();
        }
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public Capability getCapabilityById(int id) {
        Capability capability = null;
        for (int i = 0; i < capabilities.size(); i++) {
            if (capabilities.get(i).getId() == id) {
                capability = capabilities.get(i);
                break;
            }
        }
        return capability;
    }

    public void addCapability(Capability capability) {
        capability.setId(lastId);
        lastId++;
        capabilities.add(capability);
    }
}