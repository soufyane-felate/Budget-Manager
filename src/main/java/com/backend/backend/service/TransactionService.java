package com.backend.backend.service;
import com.backend.backend.dto.TransactionDTO;
import com.backend.backend.mapper.TransactionMapper;
import com.backend.backend.model.Transaction;
import com.backend.backend.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    //private final CategoryRepository categoryRepository;
    private final TransactionMapper transactionMapper;

    public List<TransactionDTO> getAll() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionMapper::toDTO)
                .toList();
    }

    public TransactionDTO add(TransactionDTO dto) {
        Transaction transaction = transactionMapper.toEntity(dto);
      //  transaction.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow());
        return transactionMapper.toDTO(transactionRepository.save(transaction));
    }

    public TransactionDTO update(Long id, TransactionDTO dto) {
        Transaction transaction = transactionRepository.findById(Math.toIntExact(id)).orElseThrow();
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setDate(dto.getDate());
        transaction.setType(dto.getType());
      //  transaction.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow());
        return transactionMapper.toDTO(transactionRepository.save(transaction));
    }

    public void delete(Long id) {
        transactionRepository.deleteById(Math.toIntExact(id));
    }
}
