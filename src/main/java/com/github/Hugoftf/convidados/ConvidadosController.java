package com.github.Hugoftf.convidados;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ConvidadosController {

    @GetMapping
    public List<Convidados> listaDeConvidados(){
        List<Convidados> listConvidados = new ArrayList<>();
        listConvidados.add(new Convidados("Hugo", "13314415512"));
        listConvidados.add(new Convidados("Ygor", "13315566789"));
        return listConvidados;
    }
    
}
