package pz1.MIC.service;

import org.springframework.stereotype.Service;
import pz1.MIC.model.Monster;
import pz1.MIC.repository.MonsterRepository;

@Service
public class MonsterService extends GenericManagementService<Monster, MonsterRepository> {
    public MonsterService(MonsterRepository repository) {
        super(repository);
    }
}
