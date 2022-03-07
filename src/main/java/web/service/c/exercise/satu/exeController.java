/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.service.c.exercise.satu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pascal
 */
@Controller
public class exeController {
     @RequestMapping("/getdata")
    public String getProduk(Model model,HttpServletRequest data){
        
        String caridata = data.getParameter("data1");
        String datanotfound = "";
                
        List<String> buffer = new ArrayList<>();
        
        ArrayList<List<String>> daftar = new ArrayList<>();
        ArrayList<List<String>> senddata = new ArrayList<>();
        
       daftar.add(Arrays.asList("Samsung", "Samsung Galaxy S10"));
       daftar.add(Arrays.asList("Iphone", "Iphone 11"));
       daftar.add(Arrays.asList("Vivo", "Vivo Z1"));
       daftar.add(Arrays.asList("Oppo", "Oppo R3"));
       
       for (int idx = 0; idx<daftar.size(); idx++){
           buffer = daftar.get(idx);
           if(buffer.get(0).contains(caridata)){
               senddata.add(daftar.get(idx));
           }
       }
       
       if(senddata.isEmpty()){
               datanotfound="data tidak ditemukan";
       }
       
       for (int idx = 0; idx<daftar.size(); idx++){
           buffer = daftar.get(idx);
           if(buffer.get(0).contains(caridata)){
               senddata.remove(daftar.get(idx));
           }
       }
       
       model.addAttribute("datahp", senddata);
       model.addAttribute("dataisnull", datanotfound);
       return "viewalldata";
    }
}
