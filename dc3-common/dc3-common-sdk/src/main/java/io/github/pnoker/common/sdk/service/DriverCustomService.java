/*
 * Copyright 2016-present Pnoker All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.pnoker.common.sdk.service;

import io.github.pnoker.common.bean.driver.AttributeInfo;
import io.github.pnoker.common.model.Device;
import io.github.pnoker.common.model.Point;

import java.util.Map;

/**
 * 自定义驱动接口，开发的自定义驱动需要实现 read 和 write 接口，可以参考以提供的驱动模块写法
 *
 * <ol>
 * <li>{@link DriverCustomService#initial} 初始化操作，需要根据不同的驱动实现该功能</li>
 * <li>{@link DriverCustomService#schedule} 调度操作，需要根据不同的驱动实现该功能</li>
 * <li>{@link DriverCustomService#read} 读操作，需要根据不同的驱动实现该功能</li>
 * <li>{@link DriverCustomService#write} 写操作，需要根据不同的驱动实现该功能</li>
 * </ol>
 *
 * @author pnoker
 * @since 2022.1.0
 */
public interface DriverCustomService {
    /**
     * Initial Driver
     */
    void initial();

    /**
     * Schedule Operation
     */
    void schedule();

    /**
     * Read Operation
     *
     * @param driverInfo Driver Attribute Info
     * @param pointInfo  Point Attribute Info
     * @param device     Device
     * @param point      Point
     * @return String Value
     */
    String read(Map<String, AttributeInfo> driverInfo, Map<String, AttributeInfo> pointInfo, Device device, Point point);

    /**
     * Write Operation
     *
     * @param driverInfo Driver Attribute Info
     * @param pointInfo  Point Attribute Info
     * @param device     Device
     * @param value      Value Attribute Info
     * @return Boolean 是否写入
     */
    Boolean write(Map<String, AttributeInfo> driverInfo, Map<String, AttributeInfo> pointInfo, Device device, AttributeInfo value);

}
