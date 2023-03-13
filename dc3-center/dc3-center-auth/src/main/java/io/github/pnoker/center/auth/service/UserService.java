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

package io.github.pnoker.center.auth.service;

import io.github.pnoker.center.auth.entity.query.UserPageQuery;
import io.github.pnoker.common.base.Service;
import io.github.pnoker.common.model.User;

/**
 * User Interface
 *
 * @author pnoker
 * @since 2022.1.0
 */
public interface UserService extends Service<User, UserPageQuery> {

    /**
     * 根据登录名称查询用户
     *
     * @param loginName      登录名称
     * @param throwException Throw Exception
     * @return User
     */
    User selectByLoginName(String loginName, boolean throwException);

    /**
     * 判断登录名称是否有效
     *
     * @param loginName 登录名称
     * @return Boolean
     */
    Boolean checkLoginNameValid(String loginName);
}
