package com.example.firstproject.Controller;

import com.example.firstproject.dto.articleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ArticleController {

  @Autowired
  private ArticleRepository articleRepository; 

  @GetMapping("/articles/new")
  public String ArticleForm(){
    return "articles/new";
  }
    
  

  @PostMapping("/articles/create")
  public String newCreateForm(articleForm form){
    //System.out.println(form.toString());
    log.info(form.toString());
    Article article=form.toEntity();
    //System.out.println(article.toString());
    log.info(article.toString());
    
    Article saved= articleRepository.save(article);
    //System.out.println(saved.toString());
    log.info(saved.toString());
    return "";
  }

  
  
}
