package com.kbstar.controller;

import com.kbstar.dto.Marker;
import com.kbstar.dto.MarkerSearch;
import com.kbstar.service.MarkerService;

import com.kbstar.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/marker")
public class MarkerController {
    @Autowired
    MarkerService markerService;
    String dir="marker/";
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
        List<Marker>list = null;
        list= markerService.get();
        model.addAttribute("mlist",list);
        model.addAttribute("center",dir + "all");
        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, int id) throws Exception {
        Marker marker = null;
        marker = markerService.get(id);
        model.addAttribute("gmarker",marker);
        model.addAttribute("center",dir + "detail");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, Marker marker) throws Exception {
        MultipartFile mf = marker.getMimg();
        String imgname = mf.getOriginalFilename();
        marker.setImg(imgname);
        markerService.register(marker);
        FileUploadUtil.saveFile(mf,imgdir);
        return "redirect:/marker/all";
    }
//    @RequestMapping("/updateimpl")
//    public String updateimpl(Model model, marker marker) throws Exception {
//        MultipartFile mf = marker.getImg();
//        String imgname = mf.getOriginalFilename();
//        if(imgname.equals("")||imgname==null)
//           imgname = marker.getImgname();
//            marker.setImgname(imgname);
//        markerService.modify(marker);
//        FileUploadUtil.saveFile(mf,imgdir);
//        return "redirect:/marker/detail?id="+marker.getId();
//    }
    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, Marker marker) throws Exception {
        MultipartFile mf = marker.getMimg();
        String new_imgname = mf.getOriginalFilename();
        if(new_imgname.equals("") || new_imgname == null)
            new_imgname = marker.getImg();
            marker.setImg(new_imgname);
            markerService.modify(marker);
            FileUploadUtil.saveFile(mf,imgdir);
        //이미지 수정되지 않았을때 기존 이미지로 불러와서 저장되는 이유가 궁금하다.
        return "redirect:/marker/detail?id="+marker.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, int id) throws Exception {
        markerService.remove(id);
        return "redirect:/marker/all";
    }
    @RequestMapping("/search")
    public String search(Model model, MarkerSearch ms) throws Exception {
        List<Marker>list= markerService.search(ms);
        model.addAttribute("ms",ms);
        model.addAttribute("mlist",list);
        model.addAttribute("center",dir+"all");
        return "index";
    }
}