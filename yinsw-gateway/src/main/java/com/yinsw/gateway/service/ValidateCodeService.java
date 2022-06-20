package com.yinsw.gateway.service;

import java.io.IOException;
import com.yinsw.common.core.exception.CaptchaException;
import com.yinsw.common.core.web.domain.AjaxResult;

/**
 * 验证码处理
 *
 * @author yinsw
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCaptcha(String key, String value) throws CaptchaException;
}
