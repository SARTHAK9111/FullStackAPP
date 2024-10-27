package com.example.CompanyMS.Company.Impl;

import com.example.CompanyMS.Company.Company;
import com.example.CompanyMS.Company.CompanyService;
import org.springframework.stereotype.Service;
import com.example.CompanyMS.Company.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompnayServiceImpl  implements CompanyService {


    private CompanyRepository CompanyRepository;

    public CompnayServiceImpl(CompanyRepository companyRepository) {
        CompanyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanyies() {
        return CompanyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long Id) {
        Optional<Company> CompanyOptional = CompanyRepository.findById(Id);
        if(CompanyOptional.isPresent()){
            Company companyToUpdate = CompanyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());

            CompanyRepository.save(companyToUpdate);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        CompanyRepository.save(company);
    }

    @Override
    public boolean deleteCompnayById(Long id) {
        if(CompanyRepository.existsById(id)){
            CompanyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return CompanyRepository.findById(id).orElse(null);

    }


}
