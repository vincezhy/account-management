package com.anz.ddtb.account.dto.mapper;

import com.anz.ddtb.account.dto.AccountDTO;
import com.anz.ddtb.account.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface AccountMapper{

    @Mapping(source = "openingAvailableBalance", target = "openingAvailableBalance", numberFormat = "#.00")
    @Mapping(source = "balanceDate", target = "balanceDate", dateFormat = "MM.dd.yyyy")
    AccountDTO entityToDto(final AccountEntity entity);

    List<AccountDTO> entityListToDtoList(final List<AccountEntity> entityList);

}
