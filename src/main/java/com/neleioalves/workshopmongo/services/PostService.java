package com.neleioalves.workshopmongo.services;

import com.neleioalves.workshopmongo.domain.Post;
import com.neleioalves.workshopmongo.repository.PostRepository;
import com.neleioalves.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        maxDate = maxDate.plusDays(1);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
