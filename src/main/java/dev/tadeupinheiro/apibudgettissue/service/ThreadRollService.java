package dev.tadeupinheiro.apibudgettissue.service;

import dev.tadeupinheiro.apibudgettissue.model.ThreadRoll;
import dev.tadeupinheiro.apibudgettissue.repository.ThreadRollRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ThreadRollService {

    final ThreadRollRepository threadRollRepository;

    public ThreadRollService(ThreadRollRepository threadRollRepository) {
        this.threadRollRepository = threadRollRepository;
    }

    public BigDecimal costMetersCalculation (BigDecimal costPriceRoll, double size) {
        return costPriceRoll.divide(BigDecimal.valueOf(size).setScale(2, RoundingMode.CEILING));
    }

    public boolean existsByIdThread (String idName) {
        return threadRollRepository.existsById(idName);
    }

    public Optional<ThreadRoll> findByIdThread (String idName){
        return threadRollRepository.findById(idName);
    }

    public List<ThreadRoll> getAllThreadRolls () {
        return this.threadRollRepository.findAll();
    }

    public boolean existsByAll (Object o) {
        var threadRoll = new ThreadRoll();
        List<ThreadRoll> threadRollList = threadRollRepository.findAll();
        for (ThreadRoll threadRoll1 : threadRollList) {
            threadRoll = threadRoll1;
            boolean resultTest = threadRoll.equals(o);

            if (resultTest) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public ThreadRoll saveThreaRoll (ThreadRoll threadRoll) {
        this.threadRollRepository.save(threadRoll);
        return threadRoll;
    }
}
