package cn.zhiyucs.blog.service.Impl;

import cn.zhiyucs.blog.db.mapper.UserMapper;
import cn.zhiyucs.blog.db.pojo.User;
import cn.zhiyucs.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
