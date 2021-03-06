package cn.com.showings.service.impl;

import cn.com.showings.pojo.exception.BusinessException;
import cn.com.showings.pojo.exception.FileBusinessException;
import cn.com.showings.dao.mapper.SysUsersMapper;
import cn.com.showings.dao.mapper.UsersRelateRolesMapper;
import cn.com.showings.pojo.SysRoles;
import cn.com.showings.pojo.SysUsers;
import cn.com.showings.pojo.UsersRelateRoles;
import cn.com.showings.service.IUserService;
import cn.com.showings.service.impl.base.BaseService;
import cn.com.showings.tools.CompressTools;
import cn.com.showings.tools.FileTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明: 用户相关服务实现
 * 更新记录：
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private UsersRelateRolesMapper usersRelateRolesMapper;

    @Autowired
    private MessageDigestPasswordEncoder passwordEncoder;


    public SysUsers findSysUserByUserName(String userName) throws Exception {
        return sysUsersMapper.selectByUserName(userName);
    }


    public SysUsers findUserByUserID(int userID) throws Exception {
        return sysUsersMapper.selectByPrimaryKey(userID);
    }


    public boolean changePassword(String newPwd, String oldPwd, SysUsers sysUsers) throws Exception {
        //对原密码校验
        String passwordMD5 = passwordEncoder.encodePassword(oldPwd, sysUsers.getUsername());
        if (!passwordMD5.equals(sysUsers.getPassword())) {
            throw new BusinessException("原密码不符，修改密码失败！");
        }
        String password = passwordEncoder.encodePassword(newPwd, sysUsers.getUsername());
        SysUsers modifyUser = new SysUsers();
        modifyUser.setUserId(sysUsers.getUserId());
        modifyUser.setPassword(password);
        modifyUser.setEnabled(true);
        modifyUser.setAccountNonExpired(true);
        modifyUser.setAccountNonLocked(true);
        modifyUser.setCredentialsNonExpired(true);

        int rows = sysUsersMapper.updateByPrimaryKeySelective(modifyUser);

        return rows > 0;
    }


    public int updateUserLoginInfo(SysUsers sysUsers) throws Exception {
        return sysUsersMapper.updateByPrimaryKeySelective(sysUsers);
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean register(SysUsers sysUsers) throws Exception {
        if (null != sysUsersMapper.selectByUserName(sysUsers.getUsername())) {
            throw new BusinessException(messageSourceAccessor.getMessage("UserService.UserNameIsExist", "手机号码已存在！"));
        }
        //初始化用户信息
        Date createDate = new Date();
        sysUsers.setDtCreate(createDate);//账户创建日期
        sysUsers.setEnabled(true);//账户可用:true-可用,false-不可用
        sysUsers.setAccountNonExpired(true);//账户未过期:true-未过期,false-过期
        sysUsers.setAccountNonLocked(true);//账户未锁定:true-未锁定,false-锁定
        sysUsers.setCredentialsNonExpired(true);//密码凭证未过期:true-未过期,false-过期
        //对密码进行MD5加密
        String passwordMD5 = passwordEncoder.encodePassword(sysUsers.getPassword(), sysUsers.getUsername());
        sysUsers.setPassword(passwordMD5);
        //插入数据库并返回
        int isSuccess = sysUsersMapper.insertSelective(sysUsers);
        if (isSuccess <= 0) {
            throw new BusinessException("创建用户信息失败！");
        }
        UsersRelateRoles usersRelateRoles = new UsersRelateRoles();
        usersRelateRoles.setUserId(sysUsers.getUserId());
        usersRelateRoles.setRoleId(SysRoles.MEMBER);
        int isSetRole = usersRelateRolesMapper.insert(usersRelateRoles);
        if (isSetRole <= 0) {
            throw new BusinessException("创建用户角色失败！");
        }
        return true;
    }


    public boolean modify(SysUsers sysUsers) throws Exception {
        //先查询用户信息
        SysUsers query = sysUsersMapper.selectByPrimaryKey(sysUsers.getUserId());
        sysUsers.setAccountNonExpired(query.isAccountNonExpired());
        sysUsers.setAccountNonLocked(query.isAccountNonLocked());
        sysUsers.setEnabled(query.isEnabled());
        sysUsers.setCredentialsNonExpired(query.isCredentialsNonExpired());
        //判断用户状态
        return statusCheck(sysUsers) && sysUsersMapper.updateByPrimaryKeySelective(sysUsers) > 0;
    }


    public String savePortrait(MultipartFile multipartFile, Integer userID, int x, int y, int w, int h, int sw, int sh) throws Exception {
        String path = FileTools.getPortraitPath(userID) + FileTools.getPortraitFileName(multipartFile.getOriginalFilename());
        //存入硬盘
        multipartFile.transferTo(new File(path));

        //图片截取
        if (FileTools.imgCut(path, x, y, w, h, sw, sh)) {
            CompressTools compressTools = new CompressTools(new File(path));
            if (compressTools.simpleCompress(300, 300, true)) {
                return FileTools.filePathToSRC(path, FileTools.IMG);
            } else {
                throw new FileBusinessException("图片压缩异常！");
            }
        } else {
            throw new FileBusinessException("图片裁剪异常！");
        }
    }

    public boolean statusCheck(SysUsers sysUsers) throws Exception {
        if (!sysUsers.isEnabled()) {
            throw new DisabledException("账户不可用！");
        } else if (!sysUsers.isAccountNonLocked()) {
            throw new LockedException("账户被锁定！");
        } else if (!sysUsers.isAccountNonExpired()) {
            throw new AccountExpiredException("账户已过期！");
        } else if (!sysUsers.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("密码凭证已过期！请立即更换！");
        } else {
            return true;
        }
    }
}
