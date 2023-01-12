package com.mahedi.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.mahedi.entity.Product;
import com.mahedi.repository.ProductRepository;
import com.mahedi.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public String allReportInformation(Model model) {
		model.addAttribute("listofinfo", productService.getAllproduct());
		return "ProductInfo";
	}

	@GetMapping("/addnew")
	public String add(Model model) {
		Product reportInformation = new Product();
		model.addAttribute("listofinfo", reportInformation);
		return "saveProductInfo";
	}

	@PostMapping("/saveProductInfo")
	public String imageUpload(@RequestParam MultipartFile img, @ModelAttribute Product product) {
//    reportInformationService.saveReportInfo(reportInformation);
//    ReportInformation im = new ReportInformation();
//        reportInformation.setrHospitalLogo1(img.getOriginalFilename());

		product.setProductImage(img.getOriginalFilename());
		product.setProductName(product.getProductName());
		product.setProductDescription(product.getProductDescription());
		product.setPrice(product.getPrice());
		product.setQunatity(product.getQunatity());

		Product uploadImg = productRepository.save(product);

		if (uploadImg != null) {
			try {

				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
				// System.out.println(path);
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//    session.setAttribute("msg", "Image Upload Sucessfully");

		return "redirect:/";
	}

	@GetMapping("/updateproductInfo/{id}")
	public String updateReportInfo(@PathVariable long id, Model model) {
		Product product = productService.updateProduct(id);
		model.addAttribute("listofAllData", product);
		return "updateproductInfo";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		productService.deleteProduct(id);

		return "redirect:/";
	}

}
