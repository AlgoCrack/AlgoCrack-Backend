package com.auth.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.auth.vo.AccountVO;

@Mapper
public interface AccountMapper {

    @Insert(" INSERT INTO account.account (id, name, given_name, family_name, picture, email, created_date) " + 
            " VALUES (#{id}, #{name}, #{givenName}, #{familyName}, #{picture}, #{email}, #{createdDate}) " +
            " ON CONFLICT (id) DO NOTHING; ")
    void addAccount(AccountVO accountVO);

}
