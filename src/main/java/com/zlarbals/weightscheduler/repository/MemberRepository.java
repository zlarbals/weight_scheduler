package com.zlarbals.weightscheduler.repository;

import com.zlarbals.weightscheduler.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {

}
