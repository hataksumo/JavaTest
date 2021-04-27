package indi.zhifa.learn.simpleweb.generate.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import indi.zhifa.learn.simpleweb.generate.entity.User;
import indi.zhifa.learn.simpleweb.generate.mapper.UserMapper;
import indi.zhifa.learn.simpleweb.generate.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 芝法酱
 * @since 2021-04-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User findByUserName(String pUserName) {
        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery().eq(User::getUserName,pUserName);
        return baseMapper.selectOne(query);
    }
}
