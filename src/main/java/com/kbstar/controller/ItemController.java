package com.kbstar.controller;

import com.kbstar.dto.*;
import com.kbstar.service.ItemService;
import com.kbstar.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    String dir="item/";
    //application.properties의 imgdir이 변수로 들어옴
    @Value("${uploadimgdir}")
    String imgdir;

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir + "add");
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Item>list = null;
        list= itemService.get();
        model.addAttribute("mlist",list);
        model.addAttribute("center",dir + "all");
        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, int id) throws Exception {
        Item item = null;
        item = itemService.get(id);
        model.addAttribute("gitem",item);
        model.addAttribute("center",dir + "detail");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, Item item) throws Exception {
        MultipartFile mf = item.getImg();
        String imgname = mf.getOriginalFilename();
        item.setImgname(imgname);
        itemService.register(item);
        FileUploadUtil.saveFile(mf,imgdir);
        return "redirect:/item/all";
    }
//    @RequestMapping("/updateimpl")
//    public String updateimpl(Model model, Item item) throws Exception {
//        MultipartFile mf = item.getImg();
//        String imgname = mf.getOriginalFilename();
//        if(imgname.equals("")||imgname==null)
//           imgname = item.getImgname();
//            item.setImgname(imgname);
//        itemService.modify(item);
//        FileUploadUtil.saveFile(mf,imgdir);
//        return "redirect:/item/detail?id="+item.getId();
//    }
    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, Item item) throws Exception {
        MultipartFile mf = item.getImg();
        String new_imgname = mf.getOriginalFilename();
        if(new_imgname.equals("") || new_imgname == null)
            new_imgname = item.getImgname();

            item.setImgname(new_imgname);
            itemService.modify(item);
            FileUploadUtil.saveFile(mf,imgdir);

        //이미지 수정되지 않았을때 기존 이미지로 불러와서 저장되는 이유가 궁금하다.
        return "redirect:/item/detail?id="+item.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, int id) throws Exception {
        itemService.remove(id);
        return "redirect:/item/all";
    }
    @RequestMapping("/search")
    public String search(Model model, ItemSearch ms) throws Exception {
        List<Item>list= itemService.search(ms);
        model.addAttribute("ms",ms);
        model.addAttribute("mlist",list);
        model.addAttribute("center",dir+"all");
        return "index";
    }
}