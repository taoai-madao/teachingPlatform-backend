package com.teachingplatform.service;

import com.teachingplatform.entity.dto.SessionWebUserDto;
import com.teachingplatform.entity.po.UserInfo;
import com.teachingplatform.entity.query.UserInfoQuery;
import com.teachingplatform.entity.vo.PaginationResultVO;

import java.util.List;


/**
 * 用户信息 业务接口
 */
public interface UserInfoService {

    /**
     * 根据条件查询列表
     */
    List<UserInfo> findListByParam(UserInfoQuery param);

    /**
     * 根据条件查询列表
     */
    Integer findCountByParam(UserInfoQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<UserInfo> findListByPage(UserInfoQuery param);

    /**
     * 新增
     */
    Integer add(UserInfo bean);

    /**
     * 批量新增
     */
    Integer addBatch(List<UserInfo> listBean);

    /**
     * 批量新增/修改
     */
    Integer addOrUpdateBatch(List<UserInfo> listBean);

    /**
     * 根据UserId查询对象
     */
    UserInfo getUserInfoByUserId(String userId);


    /**
     * 根据UserId修改
     */
    Integer updateUserInfoByUserId(UserInfo bean, String userId);


    /**
     * 根据UserId删除
     */
    Integer deleteUserInfoByUserId(String userId);


    /**
     * 根据Email查询对象
     */
    UserInfo getUserInfoByEmail(String email);


    /**
     * 根据Email修改
     */
    Integer updateUserInfoByEmail(UserInfo bean, String email);


    /**
     * 根据Email删除
     */
    Integer deleteUserInfoByEmail(String email);


    /**
     * 根据NickName查询对象
     */
    UserInfo getUserInfoByNickName(String nickName);


    /**
     * 根据NickName修改
     */
    Integer updateUserInfoByNickName(UserInfo bean, String nickName);


    /**
     * 根据NickName删除
     */
    Integer deleteUserInfoByNickName(String nickName);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    SessionWebUserDto login(String email, String password);

    /**
     * 用户注册
     * @param email
     * @param nickName
     * @param password
     * @param emailCode
     */
    void register(String email, String nickName, String password, String emailCode);

    /**
     * 重置密码
     * @param email
     * @param password
     * @param emailCode
     */
    void resetPwd(String email, String password, String emailCode);

    /**
     * 更新用户状态
     * @param userId
     * @param status
     */
    void updateUserStatus(String userId, Integer status);

    /**
     * 更新用户空间
     * @param userId
     * @param changeSpace
     */
    void changeUserSpace(String userId, Integer changeSpace);
}