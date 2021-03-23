package com.anz.ddtb.account.dto.mapper;

import com.anz.ddtb.account.dto.TransactionDTO;
import com.anz.ddtb.account.entity.TransactionEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "entity.valueDate", target = "valueDate", dateFormat = "MM.dd.yyyy")
    @Mapping(source = "entity.debitAmount", target = "debitAmount", numberFormat = "#.00", defaultValue = "")
    @Mapping(source = "entity.creditAmount", target = "creditAmount", numberFormat = "#.00", defaultValue = "")
    @Mapping(source = "entity.transactionNarrative", target = "transactionNarrative", defaultValue = "")
    TransactionDTO entityToDto(final TransactionEntity entity, final String accountNumber,
                               final String accountName, final String currency);

    default List<TransactionDTO> entityListToDtoList(final List<TransactionEntity> entityList, final String accountNumber,
                                                     final String accountName, final String currency){
        List<TransactionDTO> transactionDTOList = entityList.stream()
                .map(entity -> this.entityToDto(entity, accountNumber, accountName, currency))
                .collect(Collectors.toList());
        return transactionDTOList;
    }


}
