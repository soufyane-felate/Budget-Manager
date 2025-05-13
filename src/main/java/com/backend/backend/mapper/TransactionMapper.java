package com.backend.backend.mapper;



import com.backend.backend.dto.TransactionDTO;
import com.backend.backend.model.Transaction;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(target = "category.id", source = "categoryId")
    Transaction toEntity(TransactionDTO dto);
}
