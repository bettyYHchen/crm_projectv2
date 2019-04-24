package com.busyqa.crm.repositories;

import com.busyqa.crm.pojo.CrmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrmUserRepository extends JpaRepository<CrmUser, Long> {

    CrmUser findByUserName(String userName);
}
