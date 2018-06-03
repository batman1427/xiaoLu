package excel.impl;

import auxiliary.ResultData;
import excel.XiaoluExcel;
import excel.template.CallCustomerExcel;
import excel.template.ExtensionExcel;
import excel.template.IncomingCallExcel;
import excel.template.IntermediaryExcel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class XiaoluExcelImpl implements XiaoluExcel {

    @Override
    public void createIntermediary(Map<String, Object> condition) {
        try {
            IntermediaryExcel.createTable(condition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCallCustomer(Map<String, Object> condition) {
        try {
            CallCustomerExcel.createTable(condition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createExtension(Map<String, Object> condition) {
        try {
            ExtensionExcel.createTable(condition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createIncomingCall(Map<String, Object> condition) {
        try {
            IncomingCallExcel.createTable(condition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
