package excel.impl;

import auxiliary.ResultData;
import excel.XiaoluExcel;
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
}
