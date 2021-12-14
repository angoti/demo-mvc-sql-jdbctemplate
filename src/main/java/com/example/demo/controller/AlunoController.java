package com.example.demo.controller;

import javax.validation.Valid;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping(value = "alunos")
    public String mostraTodosUsuarios(Model model) {
        model.addAttribute("lista", alunoRepository.buscaTodos());
        return "alunos";
    }

    @GetMapping(value = "novo-aluno")
    public String exibeFormNovo(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "form-aluno";
    }

    @PostMapping(value = "novo-aluno")
    public String cadastraNovo(@Valid Aluno aluno, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form-aluno";
        }
        alunoRepository.grava(aluno);
        return "redirect:/alunos";
    }
    
    @GetMapping(value = "excluir-aluno")
    public String excluiUsuario(@RequestParam(value = "id", required = true) String login) {
        alunoRepository.excluir(login);
        return "redirect:/alunos";
    }
    
    @GetMapping("editar-aluno")
    public String exibeFormAluno(Model model, @RequestParam(value = "id", required = true) String login){
        Aluno aluno = alunoRepository.buscaPorLogin(login);
        model.addAttribute("aluno", aluno);
        return "form-edita-aluno";
    }
    
    @PostMapping("/atualiza-aluno")
    public String atualizaAluno(Aluno aluno){
        alunoRepository.atualiza(aluno);
        return "redirect:/alunos";
    }
}
