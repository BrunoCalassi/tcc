package com.projeto.barganhaleilao.controller;
import java.io.IOException;

import javax.validation.Valid;

import com.projeto.barganhaleilao.model.CadProduto;
import com.projeto.barganhaleilao.repository.Produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastroObjeto")
public class cadastroController {

	@Autowired
	private Produtos produtos;


	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(CadProduto cadProduto) {
		ModelAndView mv = new ModelAndView("CadastroObjeto");
		return mv;
	}

	@RequestMapping(value="/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid CadProduto cadProduto, BindingResult result, @RequestParam ("imagem") MultipartFile file) {
		ModelAndView mv =new ModelAndView("CadastroObjeto");
		if(result.hasErrors()){
			return novo(cadProduto);
		}
		try {
			FileUploadUtil.saveFile("C:\\Users\\marcos\\OneDrive\\Área de Trabalho\\tccMarcos1511\\src\\main\\resources\\static\\images\\upload",file.getOriginalFilename(),file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		cadProduto.setCaminho("/images/upload/"+file.getOriginalFilename());
		produtos.save(cadProduto);
		mv.addObject("mensagem", "Produto salvo com sucesso!");
		return mv;
	}

}
