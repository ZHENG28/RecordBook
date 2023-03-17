# 成长记录册（Record Book）
### 1 项目简介
- 功能：
    - 管理员端：登录地址：http://localhost:8080/admin
        1. 统一导入年级、班级、学生以及教师的信息
        2. 接收师生对平台的建议与反馈【待完善】
    - 用户端：登录地址：http://localhost:8080/
        - 教师端：
            1. 可通过主页的图标总览学生的立项情况与月度活动参与情况
            2. 可查看学生的具体信息，以及可视化展示的英语四六级通过情况、立项情况、个人荣誉情况
            3. 通过查看学生的课表空闲情况，选择班级或者具体学生可导出调整后的学生空闲情况统计图
            4. 可创建讲座活动，并在学生端发起参与投票
        - 学生端：
            1. 填写个人信息与个性化的自我介绍，系统将自动生成个人档案，以供其他同学和教师查看
            2. 上传英语四六级通过情况、立项情况、个人取得的荣誉、参加的活动记录等个人学习成果
            3. 导入个人课程表，上传本学期空闲情况，在教师安排活动时以作参考
            4. 教师不定期安排讲座，学生可根据自我意愿进行是否参与讲座的投票
- 所用技术：
	- 前端：bootstrap、thymeleaf、vue.js、echarts
	- 后端：Spring Boot框架、MySQL、Spring Security、Jpa
- 项目启动命令：
    1. 使用项目下的res/db/records.sql文件初始化数据库
    2. 修改配置文件application.properties中的各项参数：`spring.datasource.url`、`spring.datasource.username`、`spring.datasource.password`
### 2 页面展示
#### 1 管理员端
![admin-add](/res/img/admin_add.jpg)
#### 2 用户端
1. 登陆页面：
    ![user-login](/res/img/user_login.jpg)
2. **教师角色**：
    1. 主页：
        ![teacher-index](/res/img/teacher_index.jpg)
    2. 查看学生英语四六级通过情况：
        ![teacher-cet46](/res/img/teacher_cet46.jpg)
    3. 查看学生立项情况：
        ![teacher-project](/res/img/teacher_project.jpg)
    4. 查看学生课表空闲情况：
        ![teacher-timetable](/res/img/teacher_timetable.jpg)
    5. 新建讲座活动：
        ![teacher-activity](/res/img/teacher_activity.jpg)
3. **学生角色**：
    1. 主页：
        ![student-index](/res/img/student_index.jpg)
    2. 个人信息档案：
        ![student-info](/res/img/student_info.jpg)
    3. 课程表：
        ![student-schedule](/res/img/student_schedule.jpg)