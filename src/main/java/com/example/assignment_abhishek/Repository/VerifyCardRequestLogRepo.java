package com.example.assignment_abhishek.Repository;

import com.example.assignment_abhishek.Model.VerifyCardRequestLog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface VerifyCardRequestLogRepo extends PagingAndSortingRepository<VerifyCardRequestLog,Integer> {
    @Query("SELECT v.cardNumber AS cardNumber, COUNT(v.id) AS countt FROM VerifyCardRequestLog v GROUP BY v.cardNumber")
    Page<Map<String,Object>> getVerifyCardRequestLogsCountGroupedByCardNumber(Pageable pageRequest);
}
