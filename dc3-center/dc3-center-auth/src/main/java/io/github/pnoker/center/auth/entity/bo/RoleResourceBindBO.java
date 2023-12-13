/*
 * Copyright 2016-present the IoT DC3 original author or authors.
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

package io.github.pnoker.center.auth.entity.bo;

import io.github.pnoker.common.base.BaseBO;
import io.github.pnoker.common.valid.Add;
import io.github.pnoker.common.valid.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

/**
 * RoleResourceBind BO
 *
 * @author pnoker
 * @since 2022.1.0
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class RoleResourceBindBO extends BaseBO {

    /**
     * 角色ID
     */
    @NotBlank(message = "Role id can't be empty",
            groups = {Add.class, Update.class})
    private String roleId;

    /**
     * 权限资源ID
     */
    @NotBlank(message = "Resource id can't be empty",
            groups = {Add.class, Update.class})
    private String resourceId;
}
