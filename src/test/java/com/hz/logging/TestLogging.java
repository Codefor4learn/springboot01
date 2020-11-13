package com.hz.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.tools.JavaFileManager;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLogging {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    JavaMailSender mailSender;

    @Test
    public void test01(){

        // 日志的级别 由低到高
        // 可以调整输出级别，日志就只会在这个级别以后的高级别生效
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        // springboot默认使用info级别
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");

    }

    // 发送邮件
    @Test
    public void test02(){

        SimpleMailMessage message = new SimpleMailMessage();

        // 邮件设置
        message.setSubject("可爱的黄福德");
        message.setText("19. 我不知道有些人想干什么，我讲话不管你高不高兴，你这个出去的是一批一批垃圾，祸害社会，你看看我们学校土木院出去的就帮人家看图纸，指导施工，这算什么工程师呀！培训我两个月，我也会看。我有的时候非常感慨，你们的社会责任感有几个有？我们学校没有学生在公交车上让座偶的，我感到很丢人噢。\n" +
                "20. 我们那个时候，老师轻松的不的了，你看这才几年，也就十年时间吧！我八几年读大学，到图书馆借资料，都是一些很经典的书，我到借阅处看一下，就看清楚他什么时候还，等他还的时候，我们再去借，这个社会变了。\n" +
                "21. 戴着一款手表十几万，我没有表。 我们有些人是害怕吃苦，娇生惯养，养了一帮子废物！依靠父母，这是耻辱。有同学花4千元买双鞋被我看到了，我说：你是香港脚啊！我读大学时，没有父母送，送什么？自己拎着箱子走。没错，我活着很累，但我心里很坦然。少花点钱，多学点能耐，比什么都好！\n" +
                "22. 我们那时候高考放榜，至少方圆七八里地都听说我考上大学了。现在我们村人见到我回去都说：汤大学回来了啊你现在功不成名不就，你去窜什么？我没有时间跟你们瞎磨，自己对自己负责。 你现在功不成名不就，你去窜什么？我没有时间跟你们瞎磨，自己对自己负责。\n" +
                "23. 你慢慢混吧，没有关系，但是当你技不如人，想到我这句话时，已经晚了。 我汤某人给你讲数学的，如果你觉得我故事讲的好，请你立马给我滚蛋。有的学生还觉得那个老师很风趣，风趣又什么用？你是要去学东西哎！\n" +
                "24我这个人有个特点，有个原则：我不干坏事!有好多人，我帮他办了事了，要给我送礼，我说：你门都没有。我家不缺这个东西。我有熟人在省级机关，我从来不跟他联系，我要你名片干嘛，我考我自己能力吃饭。你们看我是像个农民呀，我是土生土长的农村人，你们看，中国现在的经济模式要转型了，你们看我是不为什么？再不转就没救了，我问你，转型之后，中国的发展考什么？考科技人才，所以我希望你们要用知识武装头脑，加入中国以后爆发战争，我没有什么，我照样可以去农村种地，我的劳动能力还是很好的，你们呢？你们能干什么？所以，我主张大学生第一件事就要会劳动，劳动是很锻炼人的\n" +
                "25. 我今年在家就在读《论语》和《毛泽东思想》\n" +
                "26. 我曾经说过，最聪明的人是在课堂上解决问题的。我讲我们学校的学生都喜欢一些三教九流的货不真价不实的垃圾人。我经常讲一句话：我都没正眼瞧过他们。你不是货真价实的就给我站一边去，那些烂人噢，我们学校竟然还有好多学生去跟他们合影。我在南京大学认识好多很有名的学者，我完全可以把他们请到我们学校来，但我没有，这样做对我们学校的学生不合适。我这个人脾气很坏，这个社会上有好多东西我看不惯，人像在社会上立足还是要有真才实学。\n" +
                "27. 我以前有个同学，人品实在是太差，后来他去了日本，结果找了个女友，还没有结婚就生小孩了，我们给他起外号叫人品太次郎，给他女友起外号叫未婚先有子，你们看看我还是很有才的噢。\n" +
                "28. 你们什么时候见到我崇拜明星，我告诉你地球就要毁灭了。");
        message.setTo("773941079@qq.com");
        message.setFrom("1532246395@qq.com");

        mailSender.send(message);
    }

    @Test
    public void test03() throws MessagingException, InterruptedException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // 邮件设置
        helper.setSubject("可爱的黄福德");
        helper.setText("黄图");

        // 上传文件
        helper.addAttachment("hs1.jpg",new File("E:\\WorkPlace\\IDEA\\springboot01\\src\\main\\resources\\static\\imgs\\hs1.jpg"));
        helper.addAttachment("hs2.jpg",new File("E:\\WorkPlace\\IDEA\\springboot01\\src\\main\\resources\\static\\imgs\\hs2.jpg"));

        //helper.setTo("773941079@qq.com");
        helper.setTo("1739755943@qq.com");
        //helper.setTo("3455981779@qq.com");
        helper.setFrom("1532246395@qq.com");
        int i = 0;
        while (true){
            mailSender.send(mimeMessage);
            i++;
            System.out.println("发送第" + i + "封邮件");
            Thread.sleep(10000);

        }
    }
}
