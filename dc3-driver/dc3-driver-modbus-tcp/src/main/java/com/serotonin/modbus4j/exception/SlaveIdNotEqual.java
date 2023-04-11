/*
 * Copyright 2016-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.serotonin.modbus4j.exception;

public class SlaveIdNotEqual extends ModbusTransportException {
    private static final long serialVersionUID = -1;

    /**
     * Exception to show that the requested slave id is not what was received
     * 
     * @param requestSlaveId - slave id requested
     * @param responseSlaveId - slave id of response
     */
    public SlaveIdNotEqual(int requestSlaveId, int responseSlaveId) {
        super("Response slave id different from requested id", requestSlaveId);
    }
}
