package com.tiantian.tianAIda.controller;

import com.tiantian.tianAIda.common.BaseResponse;
import com.tiantian.tianAIda.common.ErrorCode;
import com.tiantian.tianAIda.common.ResultUtils;
import com.tiantian.tianAIda.exception.BusinessException;
import com.tiantian.tianAIda.model.dto.postthumb.PostThumbAddRequest;
import com.tiantian.tianAIda.model.entity.User;
import com.tiantian.tianAIda.service.PostThumbService;
import com.tiantian.tianAIda.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子点赞接口
 *
 * @author <a href="https://github.com/tiantian">tiantian</a>
 * @from <a href="https://tiantian.icu">tiantian</a>
 */
@RestController
@RequestMapping("/post_thumb")
@Slf4j
public class PostThumbController {

    @Resource
    private PostThumbService postThumbService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param postThumbAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Integer> doThumb(@RequestBody PostThumbAddRequest postThumbAddRequest,
            HttpServletRequest request) {
        if (postThumbAddRequest == null || postThumbAddRequest.getPostId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long postId = postThumbAddRequest.getPostId();
        int result = postThumbService.doPostThumb(postId, loginUser);
        return ResultUtils.success(result);
    }

}
