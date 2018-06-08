package schedule;

import auxiliary.IDGenerator;
import auxiliary.ResponseCode;
import auxiliary.ResultData;
import dao.XiaoLuDao;
import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TokenSchedule {

    @Autowired
    XiaoLuDao xiaoLuDao;

    @Scheduled(cron = "0 0 * * * ?")
    public void update(){
        Map<String, Object> condition = new HashMap<String,Object>();
        condition.put("blockFlag", false);
        ResultData response = new ResultData();
        response = xiaoLuDao.queryAdmin(condition);
        if(response.getResponseCode() == ResponseCode.RESPONSE_OK){
            List<Admin> adminList = (List<Admin>)response.getData();
            if(!adminList.isEmpty()){
                for(Admin admin : adminList){
                    condition.clear();
                    condition.put("adminUsername", admin.getAdminUsername());
                    condition.put("adminPassword", admin.getAdminPassword());
                    condition.put("adminToken", IDGenerator.generate("TKN"));
                    condition.put("blockFlag", false);
                    xiaoLuDao.updateAdmin(condition);
                }
            }
        }
    }

}
