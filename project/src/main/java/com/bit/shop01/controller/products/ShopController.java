package com.bit.shop01.controller.products;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bit.shop01.bbs.AttachFile;
import com.bit.shop01.page.PagingHelper;
import com.bit.shop01.page.WebContants;
import com.bit.shop01.products.ProductsService;
import com.bit.shop01.products.ProductsVo;

@Controller
public class ShopController {

	 @Autowired
	    private ProductsService productsService;
	   
	    @RequestMapping(value="/outer", method={RequestMethod.GET, RequestMethod.POST})
	    public String outer(String procd,  Integer curPage,  Model model ,String searchWord) throws Exception{
	               
	        if (procd == null) procd = "outer";
	        if (curPage == null) curPage = 1;
	        if (searchWord == null) searchWord = "";
	        
	        int numPerPage = 10;
	        int pagePerBlock = 10;
	        
	        int totalRecord = productsService.getTotalRecord(procd, searchWord);
	        
	        PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	        productsService.setPagingHelper(pagingHelper);
	        
	        int start = pagingHelper.getStartRecord();
	        int end = pagingHelper.getEndRecord();

	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord,start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	        
	   
	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        model.addAttribute("curPage", curPage);
	        
	       
	        return "products/outDetail"; 
	    }
	    
	    
	    
	    
	    @RequestMapping(value="/outer_write", method=RequestMethod.GET)
	    public String outer_write(String procd, Model model) throws Exception {
	       
	        String pronm = productsService.getProductsNm(procd);
	        model.addAttribute("pronm", pronm);
	       
	        return "products/outDetail_write";
	    }
	   
	    @RequestMapping(value="/outer_write", method=RequestMethod.POST)
	    public String outer_write(ProductsVo productsVo , MultipartHttpServletRequest mpRequest) throws Exception{
	        productsService.insert(productsVo);
	        productsVo.setProductNum(productsService.getNewProductsVo().getProductNum());
	        
	    
	        
	        List<MultipartFile> fileList = mpRequest.getFiles("upload");
	        for(MultipartFile mf : fileList){
	        String filename = mf.getOriginalFilename();
	        mf.transferTo(new File(WebContants.BASE_PATH + filename));
	        }
	       
	        
	        
	        int size = fileList.size();
	        for (int i = 0; i < size; i++) {
	         MultipartFile mpFile = fileList.get(i);
	         AttachFile attachFile = new AttachFile();
	         String filename = mpFile.getOriginalFilename();
	         attachFile.setFilename(filename);
	         attachFile.setFiletype(mpFile.getContentType());
	         attachFile.setFilesize(mpFile.getSize());
	         attachFile.setProductNum(productsVo.getProductNum());
	         productsService.insertAttachFile(attachFile);
	        }     
	        
	        
	        return "redirect:/outer/?procd=" + productsVo.getProcd();
	    }
	
	    
	    @RequestMapping(value="/outer_detail", method=RequestMethod.GET)
	    public String outer_detail(int productNum, Integer curPage, String procd, String searchWord, Model model){
	    	
	    	
	    	File dir = new File("C:\\gitK3\\project\\src\\main\\webapp\\resources\\imgs2"); 

			File[] fileList = dir.listFiles();

				System.out.println("start");
				for(int i = 0 ; i < fileList.length ; i++){

					File file = fileList[i]; 

					if(file.isFile()){

						System.out.println("\t ss = " + file.getName());

					} else {
						System.out.println("dd");
					}

				}

			System.out.println("end");
	    	
	    	
	    	  int numPerPage = 10;
	    	  int pagePerBlock = 10;
	    	  if (searchWord == null) searchWord = "";  
	    	  
	    	  
	    	  int totalRecord = productsService.getTotalRecord(procd, searchWord);
	    	  System.out.println(curPage);
	    	  PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	    	  productsService.setPagingHelper(pagingHelper);
	    	  
	    	  int start = pagingHelper.getStartRecord();
	    	  int end = pagingHelper.getEndRecord();
	       
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        ArrayList<AttachFile> attachFileList = productsService.getAttachFileList(productNum);
	 
	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord, start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	       
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        
	        
	        model.addAttribute("thisProductsVo", thisProductsVo);

	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        model.addAttribute("attachFileList", attachFileList);
	       
	        return "products/outDetail_detail";
	    }
	    
	    
	    
	    @RequestMapping(value="/outer_delete", method=RequestMethod.GET)
	    public String outer_delete(int productNum,
	            String procd , Integer curPage, 
	            String searchWord) throws Exception {
	       
	        productsService.delete(productNum);
	       
	        return "redirect:/outer/?procd=" + procd  + 
	        		  "&searchWord=" + searchWord;
	 }  
	   
	    
	    @RequestMapping(value="/outer_edit", method=RequestMethod.GET)
	    public String outer_edit(int productNum,
	            String procd,
	            Model model) throws Exception {
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        String pronm = productsService.getProductsNm(procd);
	         
	        model.addAttribute("thisProductsVo", thisProductsVo);
	        model.addAttribute("pronm", pronm);
	       
	        return "products/outer_edit";
	    }
	   
	    
	    
	    @RequestMapping(value="/outer_edit", method=RequestMethod.POST)
	    public String outer_edit(ProductsVo productsVo,  Integer curPage,
	            String procd, String searchWord,MultipartHttpServletRequest mpRequest, Model model) throws Exception {
	       
	       productsService.update(productsVo);
	       
	       List<MultipartFile> fileList = mpRequest.getFiles("upload");
	       for(MultipartFile mf : fileList){
	       String filename = mf.getOriginalFilename();
	       mf.transferTo(new File(WebContants.BASE_PATH + filename));
	       }
	       
	       int size = fileList.size();
	       for (int i = 0; i < size; i++) {
	        MultipartFile mpFile = fileList.get(i);
	        AttachFile attachFile = new AttachFile();
	        String filename = mpFile.getOriginalFilename();
	        attachFile.setFilename(filename);
	        attachFile.setFiletype(mpFile.getContentType());
	        attachFile.setFilesize(mpFile.getSize());
	        attachFile.setProductNum(productsVo.getProductNum());
	        productsService.insertAttachFile(attachFile);
	       }  
	       
	        return "redirect:/outer_detail/?productNum=" + productsVo.getProductNum() +
	                "&procd=" + productsVo.getProcd() +  "&curPage=" + curPage  +
	                "&searchWord=" + searchWord;
	    }
	    

	    @RequestMapping(value="/outer2", method={RequestMethod.GET, RequestMethod.POST})
	    public String outer2(String procd,  Integer curPage,  Model model ,String searchWord) throws Exception{
	               
	        if (procd == null) procd = "outer";
	        if (curPage == null) curPage = 1;
	        if (searchWord == null) searchWord = "";
	        
	        int numPerPage = 10;
	        int pagePerBlock = 10;
	        
	        int totalRecord = productsService.getTotalRecord(procd, searchWord);
	        
	        PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	        productsService.setPagingHelper(pagingHelper);
	        
	        int start = pagingHelper.getStartRecord();
	        int end = pagingHelper.getEndRecord();

	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord,start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	        
	   
	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        model.addAttribute("curPage", curPage);
	        
	       
	        return "products2/outDetail2"; 
	

}
	    
	    
	    @RequestMapping(value="/outer_write2", method=RequestMethod.GET)
	    public String outer_write2(String procd, Model model) throws Exception {
	       
	        String pronm = productsService.getProductsNm(procd);
	        model.addAttribute("pronm", pronm);
	       
	        return "products2/outDetail_write2";
	    }
	   
	    @RequestMapping(value="/outer_write2", method=RequestMethod.POST)
	    public String outer_write2(ProductsVo productsVo , MultipartHttpServletRequest mpRequest) throws Exception{
	        productsService.insert(productsVo);
	        productsVo.setProductNum(productsService.getNewProductsVo().getProductNum());
	        
	        List<MultipartFile> fileList = mpRequest.getFiles("upload");
	        for(MultipartFile mf : fileList){
	        String filename = mf.getOriginalFilename();
	        mf.transferTo(new File(WebContants.BASE_PATH + filename));
	        }
	       
	        int size = fileList.size();
	        for (int i = 0; i < size; i++) {
	         MultipartFile mpFile = fileList.get(i);
	         AttachFile attachFile = new AttachFile();
	         String filename = mpFile.getOriginalFilename();
	         attachFile.setFilename(filename);
	         attachFile.setFiletype(mpFile.getContentType());
	         attachFile.setFilesize(mpFile.getSize());
	         attachFile.setProductNum(productsVo.getProductNum());
	         productsService.insertAttachFile(attachFile);
	        }     
	        
	        
	        return "redirect:/outer2/?procd=" + productsVo.getProcd();
	    }
	
	    
	    @RequestMapping(value="/outer_detail2", method=RequestMethod.GET)
	    public String outer_detail2(int productNum, Integer curPage, String procd, String searchWord, Model model){
	    	
	    	
	    	File dir = new File("C:\\gitK3\\project\\src\\main\\webapp\\resources\\imgs2"); 

			File[] fileList = dir.listFiles();

				System.out.println("start");
				for(int i = 0 ; i < fileList.length ; i++){

					File file = fileList[i]; 

					if(file.isFile()){

						System.out.println("\t fiel name : " + file.getName());

					} else {
						System.out.println("no file");
					}

				}

			System.out.println("end");
	    	
	    	
	    	  int numPerPage = 10;
	    	  int pagePerBlock = 10;
	    	  if (searchWord == null) searchWord = "";  
	    	  
	    	  
	    	  //목록보기
	    	  int totalRecord = productsService.getTotalRecord(procd, searchWord);
	    	  System.out.println(curPage);
	    	  PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	    	  productsService.setPagingHelper(pagingHelper);
	    	  
	    	  int start = pagingHelper.getStartRecord();
	    	  int end = pagingHelper.getEndRecord();
	       
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        ArrayList<AttachFile> attachFileList = productsService.getAttachFileList(productNum);
	 
	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord, start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	       
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        
	        
	        model.addAttribute("thisProductsVo", thisProductsVo);

	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        model.addAttribute("attachFileList", attachFileList);
	       
	        return "products2/outDetail_detail2";
	    }
	    
	    
	    
	    @RequestMapping(value="/outer_delete2", method=RequestMethod.GET)
	    public String outer_delete2(int productNum,
	            String procd , Integer curPage, 
	            String searchWord) throws Exception {
	       
	        productsService.delete(productNum);
	       
	        return "redirect:/outer2/?procd=" + procd  + 
	        		  "&searchWord=" + searchWord;
	 }  
	   
	    
	    @RequestMapping(value="/outer_edit2", method=RequestMethod.GET)
	    public String outer_edit2(int productNum,
	            String procd,
	            Model model) throws Exception {
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        String pronm = productsService.getProductsNm(procd);
	         
	        model.addAttribute("thisProductsVo", thisProductsVo);
	        model.addAttribute("pronm", pronm);
	       
	        return "products2/outer_edit2";
	    }
	   
	    
	    
	    @RequestMapping(value="/outer_edit2", method=RequestMethod.POST)
	    public String outer_edit2(ProductsVo productsVo,  Integer curPage,
	            String procd, String searchWord,MultipartHttpServletRequest mpRequest, Model model) throws Exception {
	       
	       productsService.update(productsVo);
	       
	       List<MultipartFile> fileList = mpRequest.getFiles("upload");
	       for(MultipartFile mf : fileList){
	       String filename = mf.getOriginalFilename();
	       mf.transferTo(new File(WebContants.BASE_PATH + filename));
	       }
	       
	       int size = fileList.size();
	       for (int i = 0; i < size; i++) {
	        MultipartFile mpFile = fileList.get(i);
	        AttachFile attachFile = new AttachFile();
	        String filename = mpFile.getOriginalFilename();
	        attachFile.setFilename(filename);
	        attachFile.setFiletype(mpFile.getContentType());
	        attachFile.setFilesize(mpFile.getSize());
	        attachFile.setProductNum(productsVo.getProductNum());
	        productsService.insertAttachFile(attachFile);
	       }  
	       
	        return "redirect:/outer_detail2/?productNum=" + productsVo.getProductNum() +
	                "&procd=" + productsVo.getProcd() +  "&curPage=" + curPage  +
	                "&searchWord=" + searchWord;
	    }
	    
	    
	    @RequestMapping(value="/outer3", method={RequestMethod.GET, RequestMethod.POST})
	    public String outer3(String procd,  Integer curPage,  Model model ,String searchWord) throws Exception{
	               
	        if (procd == null) procd = "outer";
	        if (curPage == null) curPage = 1;
	        if (searchWord == null) searchWord = "";
	        
	        int numPerPage = 10;
	        int pagePerBlock = 10;
	        
	        int totalRecord = productsService.getTotalRecord(procd, searchWord);
	        
	        PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	        productsService.setPagingHelper(pagingHelper);
	        
	        int start = pagingHelper.getStartRecord();
	        int end = pagingHelper.getEndRecord();

	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord,start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	        
	   
	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        model.addAttribute("curPage", curPage);
	        
	       
	        return "products3/outDetail3"; 
	

}
	    
	    
	    @RequestMapping(value="/outer_write3", method=RequestMethod.GET)
	    public String outer_write3(String procd, Model model) throws Exception {
	       
	        String pronm = productsService.getProductsNm(procd);
	        model.addAttribute("pronm", pronm);
	       
	        return "products3/outDetail_write3";
	    }
	   
	    @RequestMapping(value="/outer_write3", method=RequestMethod.POST)
	    public String outer_write3(ProductsVo productsVo , MultipartHttpServletRequest mpRequest) throws Exception{
	        productsService.insert(productsVo);
	        productsVo.setProductNum(productsService.getNewProductsVo().getProductNum());
	        
	        List<MultipartFile> fileList = mpRequest.getFiles("upload");
	        for(MultipartFile mf : fileList){
	        String filename = mf.getOriginalFilename();
	        mf.transferTo(new File(WebContants.BASE_PATH + filename));
	        }
	       
	        
	        
	        int size = fileList.size();
	        for (int i = 0; i < size; i++) {
	         MultipartFile mpFile = fileList.get(i);
	         AttachFile attachFile = new AttachFile();
	         String filename = mpFile.getOriginalFilename();
	         attachFile.setFilename(filename);
	         attachFile.setFiletype(mpFile.getContentType());
	         attachFile.setFilesize(mpFile.getSize());
	         attachFile.setProductNum(productsVo.getProductNum());
	         productsService.insertAttachFile(attachFile);
	        }     
	        
	        
	        return "redirect:/outer3/?procd=" + productsVo.getProcd();
	    }
	
	    
	    @RequestMapping(value="/outer_detail3", method=RequestMethod.GET)
	    public String outer_detail3(int productNum, Integer curPage, String procd, String searchWord, Model model){
	    	
	    	
	    	File dir = new File("C:\\gitK3\\project\\src\\main\\webapp\\resources\\imgs2"); 

			File[] fileList = dir.listFiles();

				System.out.println("start");
				for(int i = 0 ; i < fileList.length ; i++){

					File file = fileList[i]; 

					if(file.isFile()){

						System.out.println("\t ss " + file.getName());

					} else {
						System.out.println("dd");
					}

				}

			System.out.println("end");
	    	
	    	
	    	  int numPerPage = 10;
	    	  int pagePerBlock = 10;
	    	  if (searchWord == null) searchWord = ""; 
	    	  
	    	  
	    	  int totalRecord = productsService.getTotalRecord(procd, searchWord);
	    	  System.out.println(curPage);
	    	  PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	    	  productsService.setPagingHelper(pagingHelper);
	    	  
	    	  int start = pagingHelper.getStartRecord();
	    	  int end = pagingHelper.getEndRecord();
	       
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        ArrayList<AttachFile> attachFileList = productsService.getAttachFileList(productNum);
	 
	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord, start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	       
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        
	        
	        model.addAttribute("thisProductsVo", thisProductsVo);

	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        model.addAttribute("attachFileList", attachFileList);
	       
	        return "products3/outDetail_detail3";
	    }
	    
	    
	    
	    @RequestMapping(value="/outer_delete3", method=RequestMethod.GET)
	    public String outer_delete3(int productNum,
	            String procd , Integer curPage, 
	            String searchWord) throws Exception {
	       
	        productsService.delete(productNum);
	       
	        return "redirect:/outer3/?procd=" + procd  + 
	        		  "&searchWord=" + searchWord;
	 }  
	   
	    
	    @RequestMapping(value="/outer_edit3", method=RequestMethod.GET)
	    public String outer_edit3(int productNum,
	            String procd,
	            Model model) throws Exception {
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        String pronm = productsService.getProductsNm(procd);
	         
	        model.addAttribute("thisProductsVo", thisProductsVo);
	        model.addAttribute("pronm", pronm);
	       
	        return "products3/outer_edit3";
	    }
	    
	    
	    @RequestMapping(value="/outer_edit3", method=RequestMethod.POST)
	    public String outer_edit3(ProductsVo productsVo,  Integer curPage,
	            String procd, String searchWord,MultipartHttpServletRequest mpRequest, Model model) throws Exception {
	       
	       productsService.update(productsVo);
	       
	       List<MultipartFile> fileList = mpRequest.getFiles("upload");
	       for(MultipartFile mf : fileList){
	       String filename = mf.getOriginalFilename();
	       mf.transferTo(new File(WebContants.BASE_PATH + filename));
	       }
	       
	       int size = fileList.size();
	       for (int i = 0; i < size; i++) {
	        MultipartFile mpFile = fileList.get(i);
	        AttachFile attachFile = new AttachFile();
	        String filename = mpFile.getOriginalFilename();
	        attachFile.setFilename(filename);
	        attachFile.setFiletype(mpFile.getContentType());
	        attachFile.setFilesize(mpFile.getSize());
	        attachFile.setProductNum(productsVo.getProductNum());
	        productsService.insertAttachFile(attachFile);
	       }  
	       
	        return "redirect:/outer_detail3/?productNum=" + productsVo.getProductNum() +
	                "&procd=" + productsVo.getProcd() +  "&curPage=" + curPage  +
	                "&searchWord=" + searchWord;
	    }
	    
	    
}
