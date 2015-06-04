/*
 * (C) Copyright ValueLabs. 2015 All rights reserved. Created in 2015 as an
 * unpublished copyright work. All rights reserved. This document and the
 * information it contains is confidential and proprietary to ValueLabs. Hence,
 * it may not be used, copied, reproduced, transmitted, or stored in any form or
 * by any means, electronic, recording, photocopying, mechanical or otherwise,
 * without the prior written permission of ValueLabs.
 */
package com.utms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utms.entity.Object;

// TODO: Auto-generated Javadoc
/**
 * Contains domain logic pertaining to object.
 *
 * @author madhu
 * @version Revision: 1.0$ Date&Time:29 May, 2015,5:22:25 PM
 */
public interface ObjectRepository extends JpaRepository<Object, Integer> {

    /**
     * Find by object repo id.
     *
     * @param repoId
     *            the repo id
     * @return the list
     */
    public List<Object> findByObjectRepoId(Integer repoId);
    public Object findById(Integer id);

}
