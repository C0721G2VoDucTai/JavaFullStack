package com.codegym.controller;


import com.codegym.model.SanPham;
import com.codegym.service.ISanPhamService;
import com.codegym.service.SanPhamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sanPham")
public class SanPhamController {
//@Autowired
    private ISanPhamService sanPhamService = new SanPhamService();

    @GetMapping
    public String index(Model model){
        List<SanPham> sanPhamList = sanPhamService.findAll();
        model.addAttribute("sanPham",sanPhamList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("sanPham",new SanPham());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("sanPham") SanPham sanPham ){
        sanPham.setId((int)(Math.random()*1000));
        sanPhamService.save(sanPham);
        return "redirect:/sanPham";
    }
   @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        model.addAttribute("sanPham",sanPhamService.findById(id));
        return "edit";
   }
   @PostMapping("/update")
    public String update(@ModelAttribute("sanPham") SanPham sanPham){
        sanPhamService.update(sanPham.getId(),sanPham);
        return "redirect:/sanPham";
   }
   @GetMapping("/delete")
    public String delete(@RequestParam int id , Model model  ){
        model.addAttribute("sanPham",sanPhamService.findById(id));
        return "delete";
   }
   @PostMapping("/delete")
    public String delete(SanPham sanPham , RedirectAttributes attributes){
        sanPhamService.remove(sanPham.getId());
        attributes.addFlashAttribute("success","xóa thành công ");
        return "redirect:/sanPham";
   }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("sanPham", sanPhamService.findById(id));
        return "view";
    }
}
