package com.example.JobApp.Company;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanyies();
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody  Company company , @PathVariable Long Id ){

        companyService.updateCompany(company,Id);
        return new ResponseEntity<>("Company updated Successfullu=y" , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany (@RequestBody Company company ){
        companyService.createCompany(company);
        return  new ResponseEntity<>("New Company added  successfully" , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){

        boolean fag = companyService.deleteCompnayById(id);

        if(fag){
            return new ResponseEntity<>("Company Delete Successfully" , HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not found" ,HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);

        if( company !=  null){
            return  new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Company(999L,"Demo","description"), HttpStatus.NOT_FOUND);
        }


}
