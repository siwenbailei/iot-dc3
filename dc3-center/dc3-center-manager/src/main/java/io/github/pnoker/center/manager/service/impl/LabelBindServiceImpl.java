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

package io.github.pnoker.center.manager.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.pnoker.center.manager.entity.query.LabelBindPageQuery;
import io.github.pnoker.center.manager.mapper.LabelBindMapper;
import io.github.pnoker.center.manager.service.LabelBindService;
import io.github.pnoker.common.entity.common.Pages;
import io.github.pnoker.common.exception.NotFoundException;
import io.github.pnoker.common.exception.ServiceException;
import io.github.pnoker.common.model.LabelBind;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * LabelBindService Impl
 *
 * @author pnoker
 * @since 2022.1.0
 */
@Slf4j
@Service
public class LabelBindServiceImpl implements LabelBindService {

    @Resource
    private LabelBindMapper labelBindMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public LabelBind add(LabelBind labelBind) {
        if (labelBindMapper.insert(labelBind) > 0) {
            return labelBindMapper.selectById(labelBind.getId());
        }
        throw new ServiceException("The label bind add failed");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean delete(String id) {
        selectById(id);
        return labelBindMapper.deleteById(id) > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LabelBind update(LabelBind labelBind) {
        selectById(labelBind.getId());
        labelBind.setUpdateTime(null);
        if (labelBindMapper.updateById(labelBind) > 0) {
            return labelBindMapper.selectById(labelBind.getId());
        }
        throw new ServiceException("The label bind update failed");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LabelBind selectById(String id) {
        LabelBind labelBind = labelBindMapper.selectById(id);
        if (null == labelBind) {
            throw new NotFoundException();
        }
        return labelBind;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<LabelBind> list(LabelBindPageQuery labelBindPageQuery) {
        if (ObjectUtil.isNull(labelBindPageQuery.getPage())) {
            labelBindPageQuery.setPage(new Pages());
        }
        return labelBindMapper.selectPage(labelBindPageQuery.getPage().convert(), fuzzyQuery(labelBindPageQuery));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LambdaQueryWrapper<LabelBind> fuzzyQuery(LabelBindPageQuery labelBindPageQuery) {
        LambdaQueryWrapper<LabelBind> queryWrapper = Wrappers.<LabelBind>query().lambda();
        if (ObjectUtil.isNotNull(labelBindPageQuery)) {
            queryWrapper.eq(CharSequenceUtil.isNotEmpty(labelBindPageQuery.getLabelId()), LabelBind::getLabelId, labelBindPageQuery.getLabelId());
            queryWrapper.eq(CharSequenceUtil.isNotEmpty(labelBindPageQuery.getEntityId()), LabelBind::getEntityId, labelBindPageQuery.getEntityId());
        }
        return queryWrapper;
    }

}
