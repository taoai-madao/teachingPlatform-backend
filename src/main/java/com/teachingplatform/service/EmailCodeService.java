package com.teachingplatform.service;


import com.teachingplatform.entity.po.EmailCode;
import com.teachingplatform.entity.query.EmailCodeQuery;
import com.teachingplatform.entity.vo.PaginationResultVO;

import java.util.List;


/**
 * 邮箱验证码 业务接口
 */
public interface EmailCodeService {

    /**
     * 根据条件查询列表
     */
    List<EmailCode> findListByParam(EmailCodeQuery param);

    /**
     * 根据条件查询列表
     */
    Integer findCountByParam(EmailCodeQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<EmailCode> findListByPage(EmailCodeQuery param);

    /**
     * 新增
     */
    Integer add(EmailCode bean);

    /**
     * 批量新增
     */
    Integer addBatch(List<EmailCode> listBean);

    /**
     * 批量新增/修改
     */
    Integer addOrUpdateBatch(List<EmailCode> listBean);

    /**
     * 根据EmailAndCode查询对象
     */
    EmailCode getEmailCodeByEmailAndCode(String email, String code);


    /**
     * 根据EmailAndCode修改
     */
    Integer updateEmailCodeByEmailAndCode(EmailCode bean, String email, String code);


    /**
     * 根据EmailAndCode删除
     */
    Integer deleteEmailCodeByEmailAndCode(String email, String code);

    /**
     * 验证码发送
     * @param toEmail
     * @param type
     */
    void sendEmailCode(String toEmail, Integer type);

    /**
     * 验证码校验
     * @param email
     * @param code
     */
    void checkCode(String email, String code);
}