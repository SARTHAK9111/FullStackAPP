package com.example.JobApp.Company.Impl;

import com.example.JobApp.Company.Company;
import com.example.JobApp.Company.CompanyRepository;
import com.example.JobApp.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompnayServiceImpl  implements CompanyService {


    private CompanyRepository CompanyRepository;

    public CompnayServiceImpl(com.example.JobApp.Company.CompanyRepository companyRepository) {
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
            companyToUpdate.setJobs(company.getJobs());

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
