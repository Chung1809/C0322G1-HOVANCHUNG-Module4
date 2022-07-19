package codegym.service;

import codegym.model.Music;
import codegym.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository repository;
    @Override
    public List<Music> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Music music) {
         repository.save(music);
    }

    @Override
    public void update(Music music) {
         repository.update(music);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public Music findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Music> search(String name) {
        return repository.search(name);
    }
}
