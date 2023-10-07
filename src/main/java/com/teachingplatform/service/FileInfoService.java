package com.teachingplatform.service;

import com.teachingplatform.entity.dto.SessionWebUserDto;
import com.teachingplatform.entity.dto.UploadResultDto;
import com.teachingplatform.entity.po.FileInfo;
import com.teachingplatform.entity.query.FileInfoQuery;
import com.teachingplatform.entity.vo.PaginationResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * 文件信息 业务接口
 */
public interface FileInfoService {

    /**
     * 根据条件查询列表
     */
    List<FileInfo> findListByParam(FileInfoQuery param);

    /**
     * 根据条件查询列表
     */
    Integer findCountByParam(FileInfoQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<FileInfo> findListByPage(FileInfoQuery param);

    /**
     * 新增
     */
    Integer add(FileInfo bean);

    /**
     * 批量新增
     */
    Integer addBatch(List<FileInfo> listBean);

    /**
     * 批量新增/修改
     */
    Integer addOrUpdateBatch(List<FileInfo> listBean);

    /**
     * 根据FileIdAndUserId查询对象
     */
    FileInfo getFileInfoByFileIdAndUserId(String fileId, String userId);


    /**
     * 根据FileIdAndUserId修改
     */
    Integer updateFileInfoByFileIdAndUserId(FileInfo bean, String fileId, String userId);


    /**
     * 根据FileIdAndUserId删除
     */
    Integer deleteFileInfoByFileIdAndUserId(String fileId, String userId);

    /**
     * 上传文件
     * @param webUserDto
     * @param fileId
     * @param file
     * @param fileName
     * @param filePid
     * @param fileMd5
     * @param chunkIndex
     * @param chunks
     * @return
     */
    UploadResultDto uploadFile(SessionWebUserDto webUserDto, String fileId, MultipartFile file, String fileName, String filePid, String fileMd5, Integer chunkIndex,
                               Integer chunks);

    /**
     * 文件重命名
     * @param fileId
     * @param userId
     * @param fileName
     * @return
     */
    FileInfo rename(String fileId, String userId, String fileName);

    /**
     * 新建目录
     * @param filePid
     * @param userId
     * @param folderName
     * @return
     */
    FileInfo newFolder(String filePid, String userId, String folderName);

    /**
     * 文件移动
     * @param fileIds
     * @param filePid
     * @param userId
     */
    void changeFileFolder(String fileIds, String filePid, String userId);

    /**
     * 文件移入回收站
     * @param userId
     * @param fileIds
     */
    void removeFile2RecycleBatch(String userId, String fileIds);

    /**
     * 将回收站文件恢复
     * @param userId
     * @param fileIds
     */
    void recoverFileBatch(String userId, String fileIds);

    /**
     * 删除指定目录
     * @param userId
     * @param fileIds
     * @param adminOp
     */
    void delFileBatch(String userId, String fileIds, Boolean adminOp);

    /**
     * 检查用户权限
     * @param rootFilePid
     * @param userId
     * @param fileId
     */
    void checkRootFilePid(String rootFilePid, String userId, String fileId);

    void saveShare(String shareRootFilePid, String shareFileIds, String myFolderId, String shareUserId, String cureentUserId);

    /**
     * 获取用户已使用空间的大小
     * @param userId
     * @return
     */
    Long getUserUseSpace(@Param("userId") String userId);

    /**
     * 删除指定用户上传的文件和文件夹
     * @param userId
     */
    void deleteFileByUserId(@Param("userId") String userId);
}