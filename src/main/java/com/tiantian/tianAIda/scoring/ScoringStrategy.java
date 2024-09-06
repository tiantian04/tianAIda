package com.tiantian.tianAIda.scoring;

import com.tiantian.tianAIda.model.entity.App;
import com.tiantian.tianAIda.model.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略
 *
 * @author <a href="https://github.com/tiantian">tiantian</a>
 * @from <a href="https://www.code-nav.cn">tiantian</a>
 */
public interface ScoringStrategy {

    /**
     * 执行评分
     *
     * @param choices
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choices, App app) throws Exception;
}