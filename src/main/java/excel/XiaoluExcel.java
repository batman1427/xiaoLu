package excel;

import auxiliary.ResultData;

import java.util.Map;

public interface XiaoluExcel {

    void createIntermediary(Map<String, Object> condition);

    void createCallCustomer(Map<String, Object> condition);

    void createExtension(Map<String, Object> conditon);

    void createIncomingCall(Map<String, Object> condition);
}
