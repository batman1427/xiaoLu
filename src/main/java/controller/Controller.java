package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    /**
     * This method is used to upload underline files collections
     * @return
     */
    @CrossOrigin
    @RequestMapping("/upload")
    public Map<String, Object> index(MultipartHttpServletRequest request) {
        MultipartFile file = request.getFile("data_file");
        System.out.println(file.getSize());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "xwz");
        map.put("age", "24");
        return map;
    }

}
