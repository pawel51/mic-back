package pz1.MIC.service;

import org.springframework.stereotype.Service;
import pz1.MIC.model.MonsterDefinition;
import pz1.MIC.repository.MonsterDefinitionRepository;

@Service
public class MonsterDefinitionService extends GenericManagementService<MonsterDefinition, MonsterDefinitionRepository> {
    public MonsterDefinitionService(MonsterDefinitionRepository repository) {
        super(repository);
    }
}
