package dev.tadeupinheiro.apibudgettissue.service;

import dev.tadeupinheiro.apibudgettissue.model.Painting;
import dev.tadeupinheiro.apibudgettissue.model.Product;
import dev.tadeupinheiro.apibudgettissue.repository.PaintingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaintingService {

    final PaintingRepository paintingRepository;

    public PaintingService (PaintingRepository paintingRepository){
        this.paintingRepository = paintingRepository;
    }

    public boolean existsByIdPainting (Integer idPainting){
        return this.paintingRepository.existsById(idPainting);
    }

    @Transactional
    public Painting savePainting (Painting painting){
        this.paintingRepository.save(painting);
        return painting;
    }

    public List<Painting> findAllPaintings (){
        return this.paintingRepository.findAll();
    }

}
