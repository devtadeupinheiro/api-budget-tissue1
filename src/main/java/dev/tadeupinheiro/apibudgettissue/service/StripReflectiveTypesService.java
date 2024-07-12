package dev.tadeupinheiro.apibudgettissue.service;

import dev.tadeupinheiro.apibudgettissue.model.StripReflectiveTypes;
import dev.tadeupinheiro.apibudgettissue.repository.StripReflectiveTypesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StripReflectiveTypesService {

    final StripReflectiveTypesRepository stripReflectiveTypesRepository;

    public StripReflectiveTypesService (StripReflectiveTypesRepository stripReflectiveTypesRepository){
        this.stripReflectiveTypesRepository = stripReflectiveTypesRepository;
    }

    public boolean existsByIdStripReflectiveTypes (Integer idStripReflectiveTypes){
        return this.stripReflectiveTypesRepository.existsById(idStripReflectiveTypes);
    }

    public boolean existsByAll (Object o){
        var stripReflectiveTypes = new StripReflectiveTypes();
        List<StripReflectiveTypes> stripReflectiveTypesList = stripReflectiveTypesRepository.findAll();
        for (StripReflectiveTypes stripReflectiveTypes1 : stripReflectiveTypesList){
            stripReflectiveTypes = stripReflectiveTypes1;
            boolean resultTest = stripReflectiveTypes.equals(o);

            if (resultTest) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public StripReflectiveTypes saveStripReflectiveTypes (StripReflectiveTypes stripReflectiveTypes){
        this.stripReflectiveTypesRepository.save(stripReflectiveTypes);
        return stripReflectiveTypes;
    }

    public List<StripReflectiveTypes> findAllStripReflectiveTypes() {
        return this.stripReflectiveTypesRepository.findAll();
    }

    public Optional<StripReflectiveTypes> getOneStripReflectiveTypes (Integer id){
        Optional<StripReflectiveTypes> stripReflectiveTypesOptional = this.stripReflectiveTypesRepository.findById(id);
        return stripReflectiveTypesOptional;
    }
}
