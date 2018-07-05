package com.ahao.mybatis.user;

import com.ahao.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserMapperImpl {

    /**
     * 查询
     * ahao 20180705
     * */
    public User findUser(Integer id) {
        SqlSession sqlSession = MybatisUtil.sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.findUser(id);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 批量查询
     * ahao 20180705
     * */
    public List<User> findUsers() {
        SqlSession sqlSession = MybatisUtil.sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.findUsers();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 批量添加
     * ahao 20180705
     * */
    public void addUsers(List<User> users) {
        SqlSession sqlSession = MybatisUtil.sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addUsers(users);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 嵌套类
     * */
    public static class TestMain {
        public static void main(String[] args) {
            UserMapperImpl userMapper = new UserMapperImpl();
            //User usera = userMapper.findUser(2);
            //System.out.println("usera is : " + usera);
            long preTime = new Date().getTime();
            List<User> users = userMapper.findUsers();
            long nextTime = new Date().getTime();
            System.out.println("--**findUsers time is : " + (nextTime-preTime));
            /*Iterator iterator = users.iterator();
            while (iterator.hasNext()) {
                System.out.println("user is : " + (User) iterator.next());
            }
            for (User user : users) {
                System.out.println("user is : " + user);
            }
            for (int i = 0; i < users.size(); i++) {
                System.out.println("user is : " + users.get(i));
            }*/

            /*List<User> addUsers = new ArrayList<User>();
            for (int i = 0; i < 100000; i++) {
                User user = new User();
                user.setName("ahao"+i);
                user.setAge(18);
                user.setSex(1);
                addUsers.add(user);
            }
            long preTime = new Date().getTime();
            userMapper.addUsers(addUsers);
            long nextTime = new Date().getTime();
            System.out.println("--**insert time is : " + (nextTime-preTime));*/
        }
    }
}
