package com.zjweu;

import com.zjweu.entity.Infocollection;
import com.zjweu.entity.Networkaccess;
import com.zjweu.entity.Projectinvest;
import com.zjweu.entity.User;
import com.zjweu.service.*;
import com.zjweu.service.impl.OrganizationServiceImpl;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ZjweuApplicationTests {

    @Autowired
    private UserService userService;
//    @Autowired
//    private OrganizationService organizationService;
    @Autowired
    private InfoWorkersService infoWorkersService;
    @Autowired
    private SystemPlanService systemPlanService;
    @Autowired
    private TraditionalconsultService traditionalconsultService;
    @Autowired
    private TownshipvideoService townshipvideoService;
    @Autowired
    private AnnualvideoService annualvideoService;
    @Autowired
    private CloudappService cloudappService;
    @Autowired
    private HardwareService hardwareService;
    @Autowired
    private InfocollectionService infocollectionService;
    @Autowired
    private IntelligentdetectService intelligentdetectService;
    @Autowired
    private NetworkaccessService networkaccessService;
    @Autowired
    private ProjectinvestService projectinvestService;
    @Test
    void contextLoads() {
    }
    @Test
    public void save(){
        User user = new User();
        user.setUname("aa");
        user.setUpassword("bb");
        user.setUphone("111111111");
        user.setUsrc("sadfasdf");
        boolean save = userService.save(user);
        System.out.println(save);
    }

    @Test
    public void findAll(){
        System.out.println(projectinvestService.findAll(10,10,"2020"));
    }


    @Test
    public void getUUid(){
        for (int i=0;i<5;i++){
            System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
        }
    }

//    @Test
//    public void  Info(){
//        String cap = "";
//        Random random = new Random();
//        for (int i = 0; i < 6; i++) {
//            int t = random.nextInt(10);
//            cap += String.valueOf(t);
//        }
//        Verification.sendOne("注册", cap, "18705987671");
//    }
//
////    @Test
////    public void JigouFindAll(){
////        List<Organization> organization = organizationService.findAll();
////        System.out.println(organization);
////    }
//    @Test
//    public void getTime(){
//        System.out.println(new Date());
//    }
//
////    @Test
////    public void InfoWorkersFindAll(){
////        List<InfoWorkers> list = infoWorkersService.findAll();
////        System.out.println(list);
////    }
//
//    @Test
//    public void SystemPlanFindAll(){
//        List<SystemPlan> list = systemPlanService.findAll();
//        System.out.println(list);
//    }
//    @Test
//    public void SystemPlanFindById(){
//        SystemPlan plan = systemPlanService.findById(1);
//        System.out.println(plan);
//    }
//
//    @Test
//    public void OrganFindAll(){
//        System.out.println(organizationService.findAll(1,1,"2020"));
//    }
}
