package com.yinsw.common.core.exception.file;

import com.yinsw.common.core.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author yinsw
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
