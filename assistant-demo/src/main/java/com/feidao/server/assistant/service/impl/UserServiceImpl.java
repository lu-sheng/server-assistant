package com.feidao.server.assistant.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feidao.server.assistant.entity.User;
import com.feidao.server.assistant.mapper.UserDao;
import com.feidao.server.assistant.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LN
 * @since 2019-09-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
