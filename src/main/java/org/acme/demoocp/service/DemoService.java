package org.acme.demoocp.service;

import java.util.ArrayList;
import java.util.List;

import org.acme.demoocp.model.DemoInput;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String addDemo(DemoInput input){
        return "1";
    }

    public List<DemoInput> getAll(){
        List<DemoInput> demoList = new ArrayList<DemoInput>();
        DemoInput i = new DemoInput();
        i.setId(200L);
        i.setTitle("judul apa");
        i.setDescription("deskripsi apa");
        i.setPublished(false);
        demoList.add(i);
        return demoList;
    }
    
}
