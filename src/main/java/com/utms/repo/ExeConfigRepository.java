package com.utms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utms.entity.ExeConfig;

public interface ExeConfigRepository extends JpaRepository<ExeConfig, Integer> {

/*    @Query("SELECT  DISTINCT exe FROM ExeConfig AS exe LEFT JOIN FETCH exe.refBrowsers LEFT JOIN FETCH"
            + " exe.refOperatingSystems LEFT JOIN FETCH exe.autoTestCases as"
            + " autoTest LEFT JOIN FETCH autoTest.testCase as test LEFT JOIN FETCH test.refTestType LEFT JOIN FETCH test.refTestPriority ")
    List<ExeConfig> getCompleteExeConfigList();*/
    
    @Query("SELECT  DISTINCT exe FROM ExeConfig AS exe LEFT JOIN FETCH exe.refBrowsers LEFT JOIN FETCH"
            + " exe.refOperatingSystems LEFT JOIN FETCH exe.autoTestCases as"
            + " autoTest LEFT JOIN FETCH autoTest.testCase as test LEFT JOIN FETCH test.refTestType LEFT JOIN FETCH test.refTestPriority where exe.id = :configId")
    ExeConfig getExeConfig(@Param("configId") Integer configId);
   // ExeConfig getExeConfigById(Integer configId);

}
