package indi.zhifa.learn.simpleweb.generate.service;

import indi.zhifa.learn.simpleweb.generate.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 芝法酱
 * @since 2021-04-26
 */
public interface IUserService extends IService<User> {
    User findByUserName(String pUserName);
}
