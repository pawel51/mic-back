package pz1.MIC.service;

import org.springframework.stereotype.Service;
import pz1.MIC.model.Quest;
import pz1.MIC.repository.QuestRepository;

@Service
public class QuestService extends GenericManagementService<Quest, QuestRepository> {
    public QuestService(QuestRepository repository) {
        super(repository);
    }
}
