/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.connector.jdbc;

import org.apache.flink.connector.jdbc.databases.derby.DerbyTestBase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Base class for JDBC test using DDL from {@link JdbcTestFixture}. It uses create tables before
 * each test and drops afterwards.
 */
public abstract class JdbcTestBase implements DerbyTestBase {

    @BeforeEach
    public void before() throws Exception {
        JdbcTestFixture.initSchema(getMetadata());
    }

    @AfterEach
    public void after() throws Exception {
        JdbcTestFixture.cleanUpDatabasesStatic(getMetadata());
    }
}
