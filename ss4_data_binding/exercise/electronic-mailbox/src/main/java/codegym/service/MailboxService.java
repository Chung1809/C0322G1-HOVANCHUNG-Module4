package codegym.service;

import codegym.model.Mailbox;
import codegym.repository.IMailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailboxService implements IMailboxService {
    @Autowired
    private IMailboxRepository repository;
    @Override
    public List<Mailbox> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Mailbox mailbox) {
       repository.save(mailbox);
    }

    @Override
    public List<String> language() {
        return repository.language();
    }

    @Override
    public List<String> size() {
        return repository.size();
    }
}
