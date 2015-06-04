/*
 * (C) Copyright ValueLabs. 2014 All rights reserved.
 *
 * Created in 2015 as an unpublished copyright work. All rights reserved. This
 * document and the information it contains is confidential and proprietary to
 * ValueLabs. Hence, it may not be used, copied, reproduced, transmitted, or
 * stored in any form or by any means, electronic, recording, photocopying,
 * mechanical or otherwise, without the prior written permission of ValueLabs.
 * @(#)TestDataRepository.java May 27, 2015
 */

package com.utms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utms.entity.TestData;

/**
 *
 *
 * @author Sravani
 *
 */

public interface TestDataRepository extends JpaRepository<TestData, Integer> {

    public List<TestData> findByProjectId(Integer projectID);
}
