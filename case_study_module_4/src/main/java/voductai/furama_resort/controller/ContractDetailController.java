package voductai.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import voductai.furama_resort.model.contract.Contract;
import voductai.furama_resort.model.contract.ContractDetail;
import voductai.furama_resort.service.contract.IAttachServiceService;
import voductai.furama_resort.service.contract.IContractDetailService;
import voductai.furama_resort.service.contract.IContractService;

import java.util.List;

@Controller
@RequestMapping("contract-detail")
public class ContractDetailController {
    @Autowired
    IAttachServiceService attachServiceService;
    @Autowired
    IContractService contractService;
    @Autowired
    IContractDetailService contractDetailService;

    @ModelAttribute("contractList")
    public Iterable< Contract > contractList() {
        return contractService.findAll();
    }

    @ModelAttribute("attachServiceList")
    public Iterable< Contract > attachServiceList() {
        return contractService.findAll();
    }

    @GetMapping
    public String showListContractDetail(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page< ContractDetail > contractDetailPage = contractDetailService.findAll(pageable);
        model.addAttribute("contractDetailPage",contractDetailPage);
        return "contract-detail/list";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract-detail/create";
    }

    @PostMapping("create")
    public String createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail,
                                       Model model) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract-detail";
    }
}

